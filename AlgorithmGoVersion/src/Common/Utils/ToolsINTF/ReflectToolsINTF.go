package ToolsINTF

import (
	"AlgorithmPractice/src/Common/MidwareConn/DBConn"
	"reflect"
)

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/11 22:43
 * @author-Email micromicrohard@outlook.com
 * @description through reflect
 * get class name、method
 * get params
 * exec method、judge result
 * print params
 */

type ReflectToolsINTF interface {
	// get class name、method
	GetCleanClassName(clazz interface{}) (className, interfaceName string) // 获取结构体的名字，如果是接口，则返回 InterfaceName 接口名
	GetInterfaceName(clazz interface{}) *string                            // 判断该结构体是否是继承自接口，并返回 InterfaceName 接口名【接口名以INTF结尾】
	GetMethodAndName(clazz interface{}) ([]reflect.Method, []string)       // 获取含有method和solution的 方法数组和方法名数组

	// get params
	GetMethodInputOutput(entity DBConn.UTDataEntity,
		paramsType reflect.Type) (inputParams, outputParams []reflect.Value)    // 根据方法类型，获取方法的入参、出参【个数和类型】
	ParamsRecognize(context string, paramsType reflect.Type) reflect.Value      // 将string转换成入参类型
	EmptyParamsRecognize(context string, paramsType reflect.Type) reflect.Value // 将string转换成入参类型的空参数
	ParamsPrint(params interface{})                                             // 参数 打印
	ParamsEquals(ExpectOutput, ActualOutput []reflect.Value) bool               // 判断 参数 是否相等

	// exec method、judge result
	MethodExec(clazz interface{}, methodName string, entity DBConn.UTDataEntity) int //执行反射方法

	// print params
	Display(path string, v reflect.Value) //打印参数-结构体类型
}
