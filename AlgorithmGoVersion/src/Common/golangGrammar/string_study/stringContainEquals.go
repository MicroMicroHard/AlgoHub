package string_study

import "strings"

// stringContainEquals
// @author: 蔚蔚樱
// @date: 2022/5/2422:27
// @author—Email: micromicrohard@outlook.com
// @description: 请实现一个算法，确定一个字符串的所有字符【是否全都不同】。这里我们要求【不允许使用额外的存储结构】。
//给定一个string，请返回一个bool值,true代表所有字符全都不同，false代表存在相同的字符。
//保证字符串中的字符为【ASCII字符】。字符串的⻓度小于等于【3000】。
// @blogURL:
type stringContainEquals struct {
}

func (p *stringContainEquals) ContainEquals(args string) bool {
	if len(args) == 0 || len(args) > 3000 {
		return false
	}
	for _, v := range args {
		if strings.Contains(args, string(v)) {
			return false
		}
	}
	return true
}

func (p *stringContainEquals) ContainEquals2(args string) bool {
	if len(args) == 0 || len(args) > 3000 {
		return false
	}
	for k, v := range args {
		if strings.Index(args, string(v)) != k {
			return false
		}
	}
	return true
}

func (p *stringContainEquals) ContainEquals3(args string) bool {
	if len(args) == 0 || len(args) > 3000 {
		return false
	}
	for k, v := range args {
		if strings.LastIndexAny(args, string(v)) != k {
			return false
		}
	}
	return true
}

