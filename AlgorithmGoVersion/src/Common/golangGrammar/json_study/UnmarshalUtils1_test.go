package json_study

import (
	"encoding/json"
	"fmt"
	"testing"
)

// UnmarshalUtils
// @author: 蔚蔚樱
// @date: 2022/4/2716:02
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:

type RouteArr11 struct {
	RouteTestDate []Route `json:"routeTestDate"`
}

type Route struct {
	RouteType *RouteType `protobuf:"varint,2,opt,name=route_type,json=routeType,enum=Algo_dispatch.RouteType" json:"route_type,omitempty"`
}

type RouteType int32

const (
	RouteType_ROUTE_PICKUP   RouteType = 1
	RouteType_ROUTE_DELIVERY RouteType = 2
	RouteType_ROUTE_DRIVER   RouteType = 3
)

func TestFuncName1(t *testing.T) {

	// attention :为什么此处 Unmarshal 不到值，因为没有看清楚"type Route struct" 这个结构对应的json字段是route_type，而不是protobuf里面的"json=routeType"
	str1 := "{\"routeTestDate\":[{\"routeType\":1},{\"routeType\":1}]}"
	var routed1 RouteArr11
	if err := json.Unmarshal([]byte(str1), &routed1); err != nil {
		fmt.Println("Unmarshal_Error")
		return
	}

	str := "{\"routeTestDate\":[{\"route_type\":1},{\"route_type\":1}]}"
	var routed RouteArr11
	if err := json.Unmarshal([]byte(str), &routed); err != nil {
		fmt.Println("Unmarshal_Error")
		return
	}
	fmt.Println()
}
