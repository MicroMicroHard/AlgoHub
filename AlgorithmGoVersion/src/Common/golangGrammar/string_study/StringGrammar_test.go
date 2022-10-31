package string_study

import (
	"fmt"
	"strings"
	"testing"
)

// String Grammar
// @author: 蔚蔚樱
// @date: 2022/5/2522:55
// @author—Email: micromicrohard@outlook.com
// @description: https://golangbyexample.com//

// TrimSpace
// TrimSuffix
// TrimPrefix
// Title
// ToUpper
// ToLower
// HasSuffix
// Join
// Fields
// Split

// @blogURL:

func TestTrimSpace(t *testing.T) {
	res := strings.TrimSpace(" test  ")
	fmt.Println(res)
	res = strings.TrimSpace(" This is test  ")
	fmt.Println(res)
}

func TestTrimSuffix(t *testing.T) {
	//This will output "removed"
	res := strings.TrimSuffix("removedtest", "test")
	fmt.Println(res)

	//The input string will remain unchanged as it doesn't contain the test as suffix
	res2 := strings.TrimSuffix("removedtes", "test")
	fmt.Println(res2)

	res3 := strings.TrimSuffix("removedtes", "1111")
	fmt.Println(res3)
}

func TestTrimPrefix(t *testing.T) {
	//This will output removed
	res := strings.TrimPrefix("testremoved", "test")
	fmt.Println(res)

	//The input string will remain unchanged as it doesn't contain the test as prefix
	res2 := strings.TrimPrefix("tesremoved", "test")
	fmt.Println(res2)
}

func TestTitle(t *testing.T) {
	res := strings.Title("this is a test sentence")
	fmt.Println(res)
}

func TestToUpper(t *testing.T) {
	res := strings.ToUpper("abc")
	fmt.Println(res)

	res = strings.ToUpper("abc12$")
	fmt.Println(res)
}

func TestToLower(t *testing.T) {
	res := strings.ToLower("ABC")
	fmt.Println(res)

	res = strings.ToLower("ABC12$a")
	fmt.Println(res)

	res = strings.ToLower("asw")
	fmt.Println(res)
}

func TestHasSuffix(t *testing.T) {
	//Input string contains the suffix
	res := strings.HasSuffix("abcdef", "ef") // 后缀
	fmt.Println(res)
	res = strings.HasSuffix("abcdef", "ab") // 后缀
	fmt.Println(res)

	//Input string doesn't contain the suffix
	res = strings.HasPrefix("abcdef", "ab") // 前缀
	fmt.Println(res)
	res = strings.HasPrefix("abcdef", "ef") // 前缀
	fmt.Println(res)
}

func TestJoin(t *testing.T) {
	//Case 1 s contains sep. Will output slice of length 3
	res := strings.Join([]string{"ab", "cd", "ef"}, "-")
	fmt.Println(res)

	//Case 2 slice is empty. It will output a empty string
	res = strings.Join([]string{}, "-")
	fmt.Println(res)

	//Case 3 sep is empty. It will output a string combined from the slice of strings
	res = strings.Join([]string{"ab", "cd", "ef"}, "")
	fmt.Println(res)
}

func TestFields(t *testing.T) {
	//Case 1 Input string contains single spaces
	res := strings.Fields("ab cd ef")
	fmt.Println(res)

	//Case 2 Input string doesn't contain white spaces
	res = strings.Fields("abcdef")
	fmt.Println(res)

	//Case 3 Input string contains double white spaces and spaces at end too.
	res = strings.Fields("ab  cd   ef ")
	fmt.Println(res)

	//Case 4: Input string contain white spaces only. Will output a empty slice
	res = strings.Fields("  ")
	fmt.Println(res)

	//Case 5: Input string is empty. Will output a empty slice
	res = strings.Fields("")
	fmt.Println(res)
}

func TestSplit(t *testing.T) {
	//Case 1 s contains sep. Will output slice of length 3
	res := strings.Split("ab$cd$ef", "$")
	fmt.Println(res)

	//Case 2 s doesn't contain sep. Will output slice of length 1
	res = strings.Split("ab$cd$ef", "-")
	fmt.Println(res)

	//Case 3 sep is empty. Will output slice of length 8
	res = strings.Split("ab$cd$ef", "")
	fmt.Println(res)

	//Case 4 both s and sep are empty. Will output empty slice
	res = strings.Split("", "")
	fmt.Println(res)
}

func Test(t *testing.T) { // grammar 换行打印
	multiline := `This 
is a 
multiline string`

	fmt.Println(multiline)

	multiline = "qwert" +
		"ghj"

	fmt.Println(multiline)
}

