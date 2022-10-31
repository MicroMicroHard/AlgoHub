package string_study

import "fmt"

// ReviseString
// @author: 蔚蔚樱
// @date: 2022/5/2422:36
// @author—Email: micromicrohard@outlook.com
// @description: 请实现一个算法，在不使用【额外数据结构和储存空间】的情况下，翻转一个给定的字符串(可以使用单个过程变 量)。
//给定一个string，请返回一个string，为翻转后的字符串。保证字符串的⻓度小于等于5000。
// @blogURL:
type ReviseString struct {
}

func (p *ReviseString) revise(args string) string {
	str := []rune(args) // array grammar rune string转数组
	length := len(str)
	for i := 0; i < length/2; i++ {
		str[i], str[length-1-i] = str[length-1-i], str[i]
	}
	fmt.Println("origin:", args, "    cur:", string(str))
	return string(str)
}
