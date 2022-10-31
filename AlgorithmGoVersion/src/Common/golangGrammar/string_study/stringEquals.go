package string_study

import "strings"

// stringEquals
// @author: 蔚蔚樱
// @date: 2022/5/2422:46
// @author—Email: micromicrohard@outlook.com
// @description: 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//这里规定【大小写为不同字符】，且考虑字符串重点空格。给定一个string s1和一个string s2，请返回一个bool， 代表两串是否重新排列后可相同。
//保证两串的⻓度都小于等于5000。
// @blogURL:
type stringEquals struct {
}

func (p *stringEquals) judgeEquals(args, args2 string) bool {
	for _, v := range args {
		if strings.Count(args, string(v)) != strings.Count(args2, string(v)) {
			return false
		}
	}
	return true
}

/* string grammar
string equals grammar: 字符串相等的三种方式：https://www.php.cn/be/go/440036.html
1、==
2、strings.Compare()
3、strings.EqualFold()
*/
