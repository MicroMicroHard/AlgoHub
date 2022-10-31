package Topic100

import (
	"AlgorithmPractice/src/DataStructure/arrayRelevant/doublePoint"
	"errors"
	"fmt"
	"reflect"
	"testing"
)

func ReflectMethod(name interface{}, params ...interface{}) ([]reflect.Value, error) {
	f := reflect.ValueOf(name)
	if len(params) != f.Type().NumIn() {
		return nil, errors.New("the number of input params not match!")
	}
	in := make([]reflect.Value, len(params))
	for k, v := range params {
		in[k] = reflect.ValueOf(v)
	}
	return f.Call(in), nil
}

func Method(a, b string) string {
	return a + " " + b
}

func Test(t *testing.T) {
	//m := map[string]interface{}{"test": Method}

	ret, err := ReflectMethod(Method, "hello", "world")
	if err != nil {
		fmt.Println("method invoke error:", err)
	}
	fmt.Println(ret)
}

//定义一个结构体
type UserData struct {
	Name string
}

//定义结构体的方法
func (u *UserData) SetUserName(name string) {
	(*u).Name = name
	fmt.Println("SetUserName方法被调用...")
}

func Test1(t *testing.T) {

	var data interface{}
	data = &doublePoint.ThreeSumLikely{}
	//获得结构体的类型
	data_t := reflect.TypeOf(data)
	data_f := reflect.ValueOf(data)
	fmt.Println("数据结构体的类型为:", data_t.Name())
	for i := 0; i < data_t.NumMethod(); i++ {
		method := data_t.Method(i)
		fmt.Printf("方法名:%s, 方法类型:%v\n", method.Name, method.Type)
	}

	//fmt.Println("修改前的UserName为:", data.Name)
	//通过反射调用方法
	method := data_f.MethodByName("GetValuesMethod")
	DemoArray01 := []int{1, 100, 22, 39, 43, 58, 64, 76, 79, 85, 96, 58}
	Target01 := 99
	if method.Kind() == reflect.Func {
		args := []reflect.Value{
			reflect.ValueOf(DemoArray01),
			reflect.ValueOf(Target01),
		}
		fmt.Println(method.Call(args))
		//fmt.Println("修改后的UserName为:", data.Name)
	}
}

func Test2(t *testing.T) {
	clazz := doublePoint.ThreeSumLikely{}
	data_t := reflect.TypeOf(clazz)
	data_f := reflect.ValueOf(&clazz)
	fmt.Println("数据结构体的类型为:", data_t.Name())
	for i := 0; i < data_t.NumMethod(); i++ {
		method := data_t.Method(i)
		fmt.Printf("方法名:%s, 方法类型:%v\n", method.Name, method.Type)
	}

	//fmt.Println("修改前的UserName为:", data.Name)
	//通过反射调用方法
	methodName := "GetValuesMethod"
	method := data_f.MethodByName(methodName)
	if method.Kind() == reflect.Func {
		args := []reflect.Value{
			reflect.ValueOf(nil),
			reflect.ValueOf(nil),
		}
		method.Call(args)
		//fmt.Println("修改后的UserName为:", data.Name)
	}
}

func Test3(t *testing.T) {

	tagsFeature := make(map[string]uint32, 0)
	tagsFeature["b_buyer_id"] = 0
	tagsFeature["b_fd_order_comple_num"] = 0
	tagsFeature["b_fd_order_comple_num"] = 0
	tagsFeature["b_real_szsdk_deviceid"] = 7
	tagsFeature["d_driver_id"] = 0
	tagsFeature["d_fd_order_average_rating_50"] = 0
	tagsFeature["d_fd_order_complete_num"] = 0
	tagsFeature["d_fd_order_complete_rate_50"] = 0
	tagsFeature["d_order_average_rating_50"] = 7
	tagsFeature["d_order_complete_num"] = 7
	tagsFeature["d_order_complete_rate_50"] = 7
	tagsFeature["d_real_qms_point"] = 7
	tagsFeature["d_real_rating_score_50"] = 7
	tagsFeature["d_real_reject_stack_order_ts"] = 0
	tagsFeature["d_real_szsdk_deviceid"] = 7
	tagsFeature["d_real_szsdk_risk_tags"] = 7
	tagsFeature["s_real_szsdk_deviceid"] = 7
	tagsFeature["s_store_id"] = 0

	tags := []string{"b_real_szsdk_deviceid", "b_fd_order_comple_num"}
	var serviceType uint32 = 1

	ans := make([]string, 0)

	for ii := 0; ii < len(tags); ii++ {
		if _, exist := tagsFeature[tags[ii]]; !exist {
			continue
		}
		if tagsFeature[tags[ii]]&serviceType == 0 {
			continue
		}
		ans = append(ans, tags[ii])
	}

	fmt.Println(ans)
}
