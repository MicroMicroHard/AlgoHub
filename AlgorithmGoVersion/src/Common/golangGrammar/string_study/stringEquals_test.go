package string_study

import (
	"fmt"
	"strings"
	"testing"
)

// stringEquals_test.go
// @author: 蔚蔚樱
// @date: 2022/5/2422:48
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:

func Test_stringEquals_judgeEquals(t *testing.T) {
	type args struct {
		args  string
		args2 string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			"111",
			args{
				"123", "124",
			},
			false,
		},
		{
			"222",
			args{
				"acb", "abc",
			},
			true,
		},
		{
			"333",
			args{
				"12345", "34567",
			},
			false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			p := &stringEquals{}
			if got := p.judgeEquals(tt.args.args, tt.args.args2); got != tt.want {
				t.Errorf("judgeEquals() = %v, want %v", got, tt.want)
			}
		})
	}
}

func Test_stringEquals_judgeEquals1(t *testing.T) {
	var (
		age    = 22
		info   = "info"
		score1 = 23.6789
	)
	aa := &GetScoreRequest{
		Waybill: []*WayBillInfo{{
			Name:   12345,
			Age:    &age,
			Addr:   "china",
			Info:   &info,
			Score:  111.1111,
			Score1: &score1,
		}},
	}
	fmt.Println(aa)
}

type WayBillInfo struct {
	Name   int
	Age    *int
	Addr   string
	Info   *string
	Score  float32
	Score1 *float64
}

type GetScoreRequest struct {
	Waybill []*WayBillInfo `protobuf:"bytes,1,rep,name=waybill" json:"waybill,omitempty"`
}

func TestContainAny(t *testing.T) {

	// grammar : ContainsAny 在字符串中找到子字符串中的字符之一，该函数也会返回true
	fmt.Println(strings.ContainsAny("abc", "A"))
	fmt.Println(strings.ContainsAny("abc", "agt")) //true
	fmt.Println(strings.ContainsAny("876tgh", "000"))
	fmt.Println(strings.ContainsAny("876tgh", "666666")) //true

	fmt.Println(strings.Contains("abc", "ab"))           //true
	fmt.Println(strings.Contains("abcmethod", "method")) //true
	fmt.Println(strings.Contains("abcmethod", "Method"))
	fmt.Println(strings.Contains("876tgh", "666666"))

	fmt.Println(strings.Contains(
		strings.ToLower("abcmethod"),
		strings.ToLower("Method"))) //true
}
