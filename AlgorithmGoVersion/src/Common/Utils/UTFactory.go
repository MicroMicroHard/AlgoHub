package Utils

import (
	"AlgorithmPractice/src/Algorithm/dynamic/lcs"
	"AlgorithmPractice/src/Common/MidwareConn/DBConn"
	"AlgorithmPractice/src/Common/MidwareConn/ThreadPool"
	"fmt"
	"strings"
	"sync"
)

// UTFactory
// @author: 蔚蔚樱
// @date: 2022/6/1420:20
// @author—Email: micromicrohard@outlook.com
// @description 单元测试工厂
// 主要包含以下的方法：
// UTExecutorWithoutPool： 测试全量数据，通过{@link UTFactory#UTExecutorWithoutPool}，连接数据库获取测试案例，然后逐个执行,
// DebugTest：遇见不正确的案例，会输出在控制台，然后使用{@link UTFactory#DebugTest}，将控制台的输入输出手动粘贴到对应的input和output，进行断点调试
// InterfaceTest：根据接口名获取所有的实现，使用统一的测试数据，逐个测试实现类的方法，{@link UTFactory#DoUnitTest_Interface}
// 根据 className 打印测试案例：{@link UTFactory#PrintUTData}
// @blogURL: https://www.cnblogs.com/deehuang/p/14564516.html

type UTFactory struct {
	DBConnTools   *DBConnTools
	Pool          *ThreadPool.SPP
	*ReflectTools // attention :注意这种不显式写明类型 的初始化方式
}

func NewUTFactory() UTFactory {
	return UTFactory{
		DBConnTools:  NewDBConnTools(),
		Pool:         ThreadPool.NewSPP(5),
		ReflectTools: &ReflectTools{},
	}
}

func (u *UTFactory) UTExecutorWithPool(clazzArr []interface{}) {
	// 获取UT数据
	UTDataMap, err := u.GetUTDataEntityAll()
	if err != nil {
		return
	}
	wg := sync.WaitGroup{}
	for _, c := range clazzArr {
		clazz := c // grammar attention: 闭包问题，注意独立出来
		err := u.Pool.Put(
			ThreadPool.TaskStruct{
				Fun: func() error {
					u.UTExecutor(clazz, UTDataMap)
					return nil
				},
				TheWaitGroup: &wg,
			})
		if err != nil {
			fmt.Println(err)
			return
		}
	}
	wg.Wait()
}

func (u *UTFactory) DoubleTrack(clazz interface{}, inputStr, outputStr string) {
	// 获取对应的类的测试方法
	clazzName, _ := u.GetCleanClassName(clazz)
	var entity = DBConn.UTDataEntity{
		Input:     &inputStr,
		Output:    &outputStr,
		ClassName: &clazzName,
	}

	u.UTExecutor(clazz, map[string][]*DBConn.UTDataEntity{
		clazzName: {&entity},
	})
}

func (u *UTFactory) UTExecutorWithoutPool(clazz interface{}) {
	clazzName, _ := u.GetCleanClassName(clazz) // 获取对应的类的测试方法
	// 获取测试数据
	data, err := u.DBConnTools.UTDate_QueryBySlaver(clazzName)
	if err != nil {
		return
	}
	if len(data) == 0 {
		fmt.Printf("请检查【主/从】数据库，未查询到与%s相关的数据[pool]\n", clazzName)
	}

	// 获取执行方法 和 名称
	_, methodNames := u.GetMethodAndName(clazz)
	for _, methodName := range methodNames {
		methodExeErrorCnt := 0 // 方法执行错误几次
		word := ""
		// 执行测试案例
		for _, entity := range data {
			methodExeErrorCnt += u.MethodExec(clazz, methodName, *entity)
		}
		className_Method := clazzName + "." + methodName
		if methodExeErrorCnt == 0 {
			word = fmt.Sprintf("%50s 通过测试，共通过 %2d 个测试案例", className_Method, len(data))
		} else {
			word = fmt.Sprintf("%50s 测试未通过，存在 %d/%d 个测试案例没有通过", className_Method, methodExeErrorCnt, len(data))
		}
		fmt.Println(word)
	}
}

func (u *UTFactory) PrintUTData(clazz interface{}) {

	clazzName, _ := u.GetCleanClassName(clazz)
	clazzUTData, err := u.DBConnTools.MySqlCluster.ExecQuery(clazzName)
	if err != nil {
		return
	}
	if len(clazzUTData) == 0 {
		errInfo := fmt.Sprintf("请检查【主/从】数据库，未查询到与%s相关的数据", clazzName)
		fmt.Println(errInfo)
	}
	for _, utData := range clazzUTData {
		u.paramsPrint(utData)
		//Display("", reflect.ValueOf(utData))
	}
}

func (u *UTFactory) UTExecutor(clazz interface{}, utDataMap map[string][]*DBConn.UTDataEntity) {
	// 获取对应的类的测试方法
	clazzName, interfaceName := u.GetCleanClassName(clazz)
	clazzNameOrigin := clazzName
	if interfaceName != "" {
		clazzName = interfaceName
	}
	utData := u.GetUTDataEntity(utDataMap, clazzName)
	if utData == nil {
		fmt.Printf("请检查【主/从】数据库，未查询到与%s相关的数据\n", clazzName+"/"+interfaceName)
		return
	}
	// 获取执行方法名
	_, methodNames := u.GetMethodAndName(clazz)
	// 执行测试案例
	for _, methodName := range methodNames {
		methodExeErrorCnt := 0 // 方法执行错误几次
		// 执行测试案例
		for _, data := range utData {
			//data.Print()
			methodExeErrorCnt += u.MethodExec(clazz, methodName, *data)
		}
		className_Method := fmt.Sprintf("%s.%s", clazzNameOrigin, methodName)
		if methodExeErrorCnt == 0 {
			fmt.Printf("\n%50s 测试通过，共通过 %2d 个测试案例", className_Method, len(utData))
		} else {
			fmt.Printf("\n%50s 测试未通过，存在 %d/%d 个测试案例没有通过", className_Method, methodExeErrorCnt, len(utData))
		}
	}
}

func (u *UTFactory) GetUTDataEntityAll() (map[string][]*DBConn.UTDataEntity, error) {
	// 获取UT数据
	utData, err := u.DBConnTools.MySqlCluster.ExecQueryAllUTData()
	if err != nil {
		fmt.Print(err)
		return nil, err
	}
	if len(utData) == 0 {
		errInfo := fmt.Sprintf("请检查【主/从】数据库，查询到0条数据")
		fmt.Println(errInfo)
	}
	UTDataMap := make(map[string][]*DBConn.UTDataEntity)
	for i, datum := range utData {
		_, exist := UTDataMap[*utData[i].ClassName]
		if !exist {
			UTDataMap[*utData[i].ClassName] = make([]*DBConn.UTDataEntity, 0)
		}
		UTDataMap[*utData[i].ClassName] = append(UTDataMap[*utData[i].ClassName], datum)
	}
	return UTDataMap, nil
}

func (u *UTFactory) GetUTDataEntity(utDataMap map[string][]*DBConn.UTDataEntity, keyName string) []*DBConn.UTDataEntity {
	var (
		lcsTools       = &lcs.LCS_Dynamic{}
		similarityBest = 0
		CNK            string // CNK:classNameKey
	)

	ans := utDataMap[keyName]
	if ans != nil {
		return ans
	}

	for classNameKey, _ := range utDataMap {
		// 此处有坑：attention： utDataMap是map，for循环的时候，内部元素每次出现的顺序可能不一样，当出现多个key 符合 Contains的时候，结果会不一样
		// 举例：utDataMap中有两个key，分别是 name 和 name_1,而我们需要的是 name，map在for循环中，出现任何一个都会return，而name_1不是我们期望的
		// 解决办法： 使用相似度最高的 类名
		if strings.Contains(classNameKey, keyName) {
			similarity := lcsTools.GetCommonLength(classNameKey, keyName)
			if similarityBest < similarity {
				similarityBest = similarity
				CNK = classNameKey
			}
		}
	}
	if CNK == "" {
		return nil
	}
	ans = utDataMap[CNK]
	return ans
}
