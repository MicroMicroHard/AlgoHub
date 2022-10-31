package Utils

import (
	"AlgorithmPractice/src/Common/MidwareConn/DBConn"
	"AlgorithmPractice/src/Common/conf"
	"AlgorithmPractice/src/DataStructure/list"
	"errors"
	"fmt"
	"reflect"
	"strings"
)

// ClazzTools
// @author: 蔚蔚樱
// @date: 2022/6/1420:16
// @author—Email: micromicrohard@outlook.com
// @description:
// 获取反射对象的所有方法  {@link ClassReflectTools#GetExecMethod}
// 执行方法             {@link ClassReflectTools#MethodExec}
// 转换方法的输出        {@link ClassReflectTools#GetMethodOutput}
// 转换方法的输入        {@link ClassReflectTools#GetMethodInput}
// 反射方法并执行        {@link ClassReflectTools#ExecAssert}
// 判断结构是否相等      {@link ClassReflectTools#JudgeMethodResultEquals}
// 打印参数             {@link ClassReflectTools#printParams}
// @blogURL:

type ReflectTools struct {
	*StringTools
	*ArrayTools
}

func (r *ReflectTools) GetCleanClassName(clazz interface{}) (className, interfaceName string) {

	clazzType := reflect.TypeOf(clazz)
	if clazzType.Kind() == reflect.Ptr { //指针类型获取真正type需要调用Elem
		clazzType = clazzType.Elem()
	}
	//TypeString := clazzType.String()   reflect grammar : String() 获取的是：包名.类型名
	TypeString := clazzType.Name() // reflect grammar : Name() 获取的是：类型名
	TypeNameArr := strings.Split(TypeString, ".")

	// 如果存在 InterfaceName 则使用 InterfaceName获取测试案例
	interfaceNamePoint := r.GetInterfaceName(clazz)
	if interfaceNamePoint != nil {
		interfaceName = *interfaceNamePoint
	}
	// 没有实现接口 否则返回 真实结构体名字
	return TypeNameArr[len(TypeNameArr)-1], interfaceName
}

// 判断该结构体是否是继承自接口，并返回 InterfaceName 接口名
func (r *ReflectTools) GetInterfaceName(clazz interface{}) *string {
	typeOfClazz := reflect.TypeOf(clazz)
	for i := 0; i < typeOfClazz.NumMethod(); i++ {
		method := typeOfClazz.Method(i)
		if method.Name != "InterfaceName" {
			continue
		}
		valueOfClass := reflect.ValueOf(clazz)
		methodExec := valueOfClass.MethodByName(method.Name)
		interfaceName := methodExec.Call(nil)
		if interfaceName != nil {
			va := interfaceName[0].Interface().(string)
			return &va
		} else {
			fmt.Printf("%s 未配置接口名\n", interfaceName)
			break
		}
	}
	return nil
}

func (r *ReflectTools) GetMethodAndName(clazz interface{}) ([]reflect.Method, []string) {
	methodName := make([]string, 0)
	methods := make([]reflect.Method, 0)

	data_t := reflect.TypeOf(clazz)
	for i := 0; i < data_t.NumMethod(); i++ {
		method := data_t.Method(i)
		// 对 solution 和 method 的方法进行操作
		if strings.Contains(strings.ToLower(method.Name), "method") ||
			strings.Contains(strings.ToLower(method.Name), "solution") {
			//fmt.Printf("方法名:%s, 方法类型:%v\n", method.Name, method.Type)
			methodName = append(methodName, method.Name)
			methods = append(methods, method)
		}
	}
	return methods, methodName
}

// go reflect grammar : 获取方法的入参、出参 个数和类型
func (r *ReflectTools) GetMethodInputOutput(entity DBConn.UTDataEntity,
	paramsType reflect.Type) (inputParams, outputParams []reflect.Value) {

	inputParams = make([]reflect.Value, 0)
	outputParams = make([]reflect.Value, 0)
	inputStr := r.FormatStr(entity.GetInput())
	outputStr := r.FormatStr(entity.GetOutput())
	inputArray := strings.Split(inputStr, conf.AlgorithmConf.Common.SpiltExpr)
	outputArray := strings.Split(outputStr, conf.AlgorithmConf.Common.SpiltExpr)

	inputParamsTypeNum := paramsType.NumIn()
	/*if len(inputArray) != inputParamsTypeNum {
		errInfo := fmt.Sprintf("入参参数的数量不正确,函数的入参数为：%d，实际获取到的入参数为：%d", inputParamsTypeNum, len(inputArray))
		fmt.Println(errInfo)
		return
	}*/
	// get inputStr
	for i := 0; i < inputParamsTypeNum; i++ {
		methodInput := paramsType.In(i) // 入参类型
		//fmt.Println(methodParams)
		inputParams = append(inputParams, r.ParamsRecognize(inputArray[i], methodInput))
	}

	// get outputStr
	outputParamsTypeNum := paramsType.NumOut()
	if len(outputArray) != outputParamsTypeNum {
		errInfo := fmt.Sprintf("出参参数的数量不正确,函数的出参数为：%d，实际获取到的出参数为：%d", outputParamsTypeNum, len(outputArray))
		fmt.Println(errInfo)
		return
	}
	for i := 0; i < outputParamsTypeNum; i++ {
		methodOutput := paramsType.Out(i)
		outputParams = append(outputParams, r.ParamsRecognize(outputArray[i], methodOutput))
	}

	return inputParams, outputParams
}

func (r *ReflectTools) ParamsRecognize(context string, paramsType reflect.Type) reflect.Value {

	var (
		err         error
		resultValue interface{}
	)
	context = r.ReplaceStr(r.FormatStr(context))

	if conf.AlgorithmConf.Common.EmptyExpr == context {
		return r.EmptyParamsRecognize(context, paramsType)
	}

	switch paramsType.String() {
	case "int":
		resultValue, err = r.RecognizeInt(context)
	case "[]int":
		resultValue, err = r.RecognizeIntArray(context)
	case "string":
		resultValue, err = r.RecognizeStr(context)
	case "slice":
		resultValue, err = r.RecognizeIntArray(context)
	case "bool":
		resultValue, err = r.RecognizeBool(context)
	case "*list.Nodelj":
		resultValue, err = r.RecognizeNodelj(context)
	default:
		fmt.Printf("%s 参数类型缺失，请配置\n", paramsType)
		return reflect.Value{}
	}
	if err != nil {
		fmt.Printf("\nGetAccordingParams\n")
		return reflect.Value{}
	}
	return reflect.ValueOf(resultValue)
}

func (r *ReflectTools) EmptyParamsRecognize(context string, paramsType reflect.Type) reflect.Value {

	context = r.ReplaceStr(r.FormatStr(context))
	var resultValue interface{}

	switch paramsType.String() {
	case "int":
		resultValue = 0
	case "[]int":
		resultValue = make([]int, 0)
	case "string":
		resultValue = ""
	case "slice":
		resultValue = make([]string, 0)
	case "bool":
		resultValue = false
	case "*list.Nodelj":
		resultValue = list.NewNodeEmpty()
	default:
		fmt.Printf("%s 参数类型缺失，请配置\n", paramsType)
		return reflect.Value{}
	}
	return reflect.ValueOf(resultValue)
}


func (r *ReflectTools) ParamsPrint(params interface{}) {

	if params == nil {
		fmt.Println("nil")
		return
	}
	//obj reflect.Value
	obj := reflect.ValueOf(params)
	//fmt.Println(obj.Interface())

	/*objType := reflect.TypeOf(obj)     // reflect grammar : 获取obj对象的类型
		fmt.Printf("%T\n", 3)            // reflect grammar : fmt.Printf 提供了一个缩写 %T 参数, 内部使用 reflect.TypeOf 来输出
		fmt.Println(objType)
	    aa := reflect.Indirect(obj)      // reflect grammar: 获取v指向的值，即，如果v是nil指针，则Indirect返回零值。如果v不是指针，则Indirect返回v
		fmt.Print(aa.Kind())
		fmt.Print(aa)*/

	flag := false

	switch obj.Interface().(type) {
	case int:
		fmt.Println(obj.Interface().(int))
		flag = true
	case []int:
		intArray := obj.Interface().([]int)
		r.IntArrayPrint(intArray)
		flag = true
	case string:
		fmt.Println(obj.Interface().(string))
		flag = true
	case []string:
		fmt.Println(obj.Interface().([]string))
		flag = true
	case bool:
		fmt.Println(obj.Interface().(bool))
		flag = true
	case float64:
		fmt.Println(obj.Interface().(float64))
		flag = true
	case *DBConn.UTDataEntity:
		entity := obj.Interface().(*DBConn.UTDataEntity)
		entity.Print()
		flag = true
	}
	if !flag {
		fmt.Println(obj.Interface())
	}
}

// grammar : %T	输出值的类型
// 通过反射执行方法
func (r *ReflectTools) MethodExec(clazz interface{}, methodName string, entity DBConn.UTDataEntity) int {

	//if method == (reflect.Method{}) { // 括号不能去
	if len(methodName) == 0 {
		errInfo := fmt.Sprintf("请检查方法名，未查询到名为%s和%s的方法名", "method", "solution")
		fmt.Println(errInfo)
		return 0
	}
	/*data_f := reflect.ValueOf(clazz)
	methodExec := data_f.MethoDBConnyName(method.Name)*/

	valueOfClass := reflect.ValueOf(clazz)
	methodExec := valueOfClass.MethodByName(methodName)
	if methodExec.Kind() != reflect.Func {
		fmt.Println("方法名不正确")
		return 0
	}

	// 暂时处理 nil 作为反射的入参 不好使用
	if *entity.Input == conf.AlgorithmConf.Common.NullExpr {
		fmt.Printf("\nskip nil,%s", *entity.Input)
		return 0
	}

	// 入参、出参
	input, ExpectOutput := r.GetMethodInputOutput(entity, methodExec.Type())
	// 执行
	ActualOutput := methodExec.Call(input)

	if !r.ParamsEquals(ExpectOutput, ActualOutput) {
		fmt.Println(fmt.Sprintf("Method %s exec failed \n", methodName))
		entity.Print()
		fmt.Println("ActualOutput:")
		r.ParamsPrint(ActualOutput[0])
		return 1 // 错误数
	}
	return 0
}

func (r *ReflectTools) ParamsEquals(ExpectOutput, ActualOutput []reflect.Value) bool {

	// ExpectOutput, ActualOutput 如果存在长度和类型不一致
	if len(ExpectOutput) < 1 || len(ActualOutput) < 1 || len(ExpectOutput) != len(ActualOutput) ||
		reflect.ValueOf(ExpectOutput[0]).Kind() != reflect.ValueOf(ActualOutput[0]).Kind() {
		return false
	}
	/*ans := reflect.TypeOf(ExpectOutput[0])
	ansking := reflect.TypeOf(ExpectOutput[0]).Kind()
	fmt.Println(ans)
	fmt.Println(ansking)*/

	switch ExpectOutput[0].Interface().(type) {
	case int:
		return ExpectOutput[0].Int() == ActualOutput[0].Int()
	case []int:
		return r.IntArrayEquals(ExpectOutput[0].Interface().([]int), ActualOutput[0].Interface().([]int), false)
	case string:
		return strings.EqualFold(ExpectOutput[0].String(), ActualOutput[0].String())
	case bool:
		return ExpectOutput[0].Bool() == ActualOutput[0].Bool()
	case *list.Nodelj:
		node := &list.Nodelj{}
		// interface grammar : assert interface
		return node.NodeljEquals(ExpectOutput[0].Interface().(*list.Nodelj), ActualOutput[0].Interface().(*list.Nodelj))
	}
	return false
}

func (r *ReflectTools) Display(path string, v reflect.Value) {
	switch v.Kind() {
	case reflect.Invalid:
		fmt.Printf("%s = invalid\n", path)
	case reflect.Slice, reflect.Array:
		for i := 0; i < v.Len(); i++ {
			r.Display(fmt.Sprintf("%s[%d]", path, i), v.Index(i))
		}
	case reflect.Struct:
		for i := 0; i < v.NumField(); i++ {
			fieldPath := fmt.Sprintf("%s.%s", path, v.Type().Field(i).Name)
			r.Display(fieldPath, v.Field(i))
		}
	case reflect.Map:
		for _, key := range v.MapKeys() {
			r.Display(fmt.Sprintf("%s[%s]", path,
				key), v.MapIndex(key))
		}
	case reflect.Ptr:
		if v.IsNil() {
			fmt.Printf("%s = nil\n", path)
		} else {
			r.Display(fmt.Sprintf("(*%s)", path), v.Elem())
		}
	case reflect.Interface:
		if v.IsNil() {
			fmt.Printf("%s = nil\n", path)
		} else {
			fmt.Printf("%s.type = %s\n", path, v.Elem().Type())
			r.Display(path+".value", v.Elem())
		}
	default: // basic types, channels, funcs
		fmt.Printf("%s = %s\n", path, v)
	}
}

func GetReflectResult1(clazz interface{}, methodName string, inputParams ...interface{}) ([]reflect.Value, error) {
	//data := doublePoint.ThreeSumLikely{}
	//获得结构体的类型
	data_t := reflect.TypeOf(clazz)
	data_f := reflect.ValueOf(clazz)
	fmt.Println("数据结构体的类型为:", data_t.Name())
	fmt.Println("数据结构体的类型为:", data_f.MethodByName("method"))
	for i := 0; i < data_t.NumMethod(); i++ {
		method := data_t.Method(i)
		fmt.Printf("方法名:%s, 方法类型:%v\n", method.Name, method.Type)
	}

	//fmt.Println("修改前的UserName为:", data.Name)
	//通过反射调用方法
	method := data_f.MethodByName(methodName)
	if method.Kind() == reflect.Func {
		args := []reflect.Value{
			reflect.ValueOf(nil),
			reflect.ValueOf(nil),
		}
		return method.Call(args), nil
		//fmt.Println("修改后的UserName为:", data.Name)
	}
	return nil, nil
}
func GetReflectResult(method interface{}, methodName string, inputParams ...interface{}) ([]reflect.Value, error) {

	/*clazzType := reflect.TypeOf(name)
	if clazzType.Kind() == reflect.Ptr { //指针类型获取真正type需要调用Elem
		clazzType = clazzType.Elem()
	}*/

	//v := reflect.ValueOf(method)
	data_t := reflect.TypeOf(method)
	data_f := reflect.ValueOf(&method)

	for i := 0; i < data_t.NumMethod(); i++ {
		method1 := data_t.Method(i)
		fmt.Printf("方法名:%s, 方法类型:%v\n", method1.Name, method1.Type)
	}

	input := make([]reflect.Value, len(inputParams))
	for k, v := range inputParams {
		input[k] = reflect.ValueOf(v)
	}

	df := data_f.MethodByName(methodName)
	if df.Kind() == reflect.Func {
		return df.Call(input), nil
	}

	//methodOrigin := v.MethoDBConnyName(methodName)

	execMethod := reflect.ValueOf(method)
	tt := execMethod.Type()
	fmt.Println(tt)
	if len(inputParams) != tt.NumIn() {
		return nil, errors.New("the number of input params not match!")
	}

	return nil, nil
}
