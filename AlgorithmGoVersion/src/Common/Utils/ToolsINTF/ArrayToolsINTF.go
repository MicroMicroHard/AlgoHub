package ToolsINTF

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/11 23:03
 * @author-Email micromicrohard@outlook.com
 * @description
 * 1、判断相等
 * 2、转换
 * 3、打印
 * 4、排序
 * 5、复制
 */
type ArrayToolsINTF interface {
	// Equals
	IntArrayEquals(arrayA, arrayB []int, isPrint bool) bool //判断两个int[] 是否相等,isPrint：控制在不想等的时候是否打印
	IntMatrixEquals(matrixA, matrixB [][]int) bool          //判断两个int[][]  是否相等
	StrArrayEquals(strA, strB string) bool                  //判断两个string[] 是否相等
	StrArrayEqualsStrict(strA, strB string) bool            //判断两个string[] 是否严格顺序相等(index严格一致)
	// trans
	Str2IntArray(params string) []int //将 String类型的数字字符串 转换成int[]
	IntArray2Str(params []int) string //将 int[] 拼接成String类型的数字字符串
	// print
	IntArrayPrint(params []int)    //打印一维int数组
	IntMatrixPrint(params [][]int) //打印二维int数组
	StrMatrixPrint([][]string)     //打印二维字符串数组
	// sort
	ListSort() //按照list的长度从小到大排序,相同长度的list,按照相同位置 字典序 小的优先排序
	// copy
	ArrayDeepCopy()  //数组深copy
	MatrixDeepCopy() //矩阵深copy
}
