package study

import (
	"fmt"
	"testing"
)

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/21 01:40
 * @author-Email micromicrohard@outlook.com
 * @description
 * 1、数组的对象赋值，两者使用的是用一个对象，一改俱改
 * 2、数组形式的赋值方式和取值方式
 */

// 1、数组的对象赋值，两者使用的是用一个对象，一改俱改
func TestArrayAssignment(t *testing.T) {
	ss := make(map[string]*ScoreL)
	// attention 赋值方法
	a, a2, a3, a4 := 1.0, 2.0, 3.0, 4.0
	ss["234"] = &ScoreL{
		Scores:  []float64{1, 2, 3, 4},
		Scores2: &[]float64{1, 2, 3, 4},
		Scores3: []*float64{&a, &a2, &a3, &a4},
	}
	result := make(map[string][]float64, 3)
	result2 := make(map[string]*[]float64, 3)
	result3 := make(map[string][]*float64, 3)
	for i, v := range ss {
		result[i] = v.Scores // grammar，这种赋值是可以的,但是会关联在一块，比如后续将Scores[0]修改成88，result也会变
		result2[i] = v.Scores2
		result3[i] = v.Scores3
	}
	// attention 数组形式的赋值方式和取值方式
	d := 100.0
	ss["234"].Scores[0] = 88
	(*(ss["234"].Scores2))[0] = 33
	ss["234"].Scores3[0] = &d
	fmt.Println(result)
	for _, v := range result2 {
		fmt.Print(v, " ")
	}
	fmt.Println()
	for _, v := range result3 {
		for _, l := range v {
			fmt.Print(*l, " ")
		}
	}
}

type ScoreL struct {
	Scores  []float64  `protobuf:"fixed64,1,rep,packed,name=scores,proto3" json:"scores,omitempty"`
	Scores2 *[]float64 `protobuf:"fixed64,1,rep,packed,name=scores2,proto3" json:"scores2,omitempty"`
	Scores3 []*float64 `protobuf:"fixed64,1,rep,packed,name=scores3,proto3" json:"scores3,omitempty"`
}
