package Utils

import (
	"fmt"
)

// @author 蔚蔚樱
// @version 1.0
// @date 2020-02-11 15:11
// @author-Email micromicrohard@outlook.com
// @description 数组工具类
type ArrayTools struct {
}

// IntArrayEquals 判断两个int[]  是否相等
func (a *ArrayTools) IntArrayEquals(arrayA, arrayB []int, isPrint bool) bool {
	if arrayA == nil && arrayB == nil {
		return true
	}
	if arrayA == nil || arrayB == nil || len(arrayA) != len(arrayB) {
		fmt.Println("ExpectOutput: ", arrayA)
		fmt.Println("ActualOutput:", arrayB)
		return false
	}
	if &arrayA == &arrayB {
		return true
	}
	if len(arrayA) == 0 && len(arrayB) == len(arrayA) {
		return true
	}
	for k, v := range arrayA {
		if arrayB[k] != v {
			fmt.Print("\n ExpectOutput: ", arrayA)
			fmt.Print("\n ActualOutput: ", arrayB)
			return false
		}
	}
	return true
}

// IntMatrixEquals 判断两个int[][]  是否相等
func (a *ArrayTools) IntMatrixEquals(matrixA, matrixB [][]int) bool {
	return false
}

// StrArrayEquals 判断两个string[] 是否相等
func (a *ArrayTools) StrArrayEquals(strA, strB string) bool {
	return false
}

// StrArrayEqualsStrict 判断两个string[] 是否严格顺序相等(index严格一致)
func (a *ArrayTools) StrArrayEqualsStrict(strA, strB string) bool {
	return false
}

// Str2IntArray 将 String类型的数字字符串 转换成int[]
func (a *ArrayTools) Str2IntArray(params string) []int {
	return nil
}

// IntArray2Str 将 int[] 拼接成String类型的数字字符串
func (a *ArrayTools) IntArray2Str(params []int) string {
	return ""
}

// IntArrayPrint 打印一维数组
func (a *ArrayTools) IntArrayPrint(params []int) {
	fmt.Print("{")
	for i, param := range params {
		fmt.Print(param)
		if i != len(params)-1 {
			fmt.Print(", ")
		}
	}
	fmt.Println("}")
}

// PrintIntMatrix 打印二维数组
func (a *ArrayTools) IntMatrixPrint(params [][]int) {

}

// PrintStrMatrix 打印二维字符串数组
func (a *ArrayTools) StrMatrixPrint([][]string) {

}

// sort //按照list的长度从小到大排序,相同长度的list,按照相同位置 字典序 小的优先排序
func (a *ArrayTools) ListSort() {

}

// copy //数组深copy
func (a *ArrayTools) ArrayDeepCopy() {

}

//矩阵深copy
func (a *ArrayTools) MatrixDeepCopy() {

}
