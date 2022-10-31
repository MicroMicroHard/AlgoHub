package json_study

import (
	"encoding/json"
	"fmt"
	"testing"
)

// UnmarshalUtils_test
// @author: 蔚蔚樱
// @date: 2022/4/2716:02
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:

type RouteArr1 struct {
	RouteTestDate []string `json:"routeTestDate"`
}

type RouteArr2 struct {
	routeTestDate []string `json:"routes"`
}

type RouteArr3 struct {
	RouteTestDate []string `json:"routes"`
}

func TestFuncName(t *testing.T) {

	str := "{\"routes\":[\"1222\",\"22222\",\"33333\"]}"
	var asd RouteArr1
	if err := json.Unmarshal([]byte(str), &asd); err != nil {
		fmt.Println("Unmarshal_Error")
		return
	}
	// attention: 此处是因为 RouteArr1 中的 routeTestDate 跟 str 中的 routes 名字不相符导致解析不到，但不是错误
	fmt.Println("----------RouteArr1----err-----")
	var asd2 RouteArr2
	if err := json.Unmarshal([]byte(str), &asd2); err != nil {
		fmt.Println("Unmarshal_Error")
		return
	}
	// attention: 此处是因为 RouteArr2 中的 routes 跟 str 中的 routes 名字routeTestDate没有大写，但是导致解析不到，但不是错误
	fmt.Println("----------RouteArr2----err-----")
	var asd3 RouteArr3
	if err := json.Unmarshal([]byte(str), &asd3); err != nil {
		fmt.Println("Unmarshal_Error")
		return
	}
	fmt.Println("----------RouteArr3----succ-----")
}
