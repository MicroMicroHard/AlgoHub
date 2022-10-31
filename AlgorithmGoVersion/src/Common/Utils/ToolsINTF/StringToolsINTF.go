package ToolsINTF

import "AlgorithmPractice/src/DataStructure/list"

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/10 11:29
 * @author-Email micromicrohard@outlook.com
 * @description
 * Format、Replace、Check
 * trans params
 * Recognize params
 * PlaceHolder
 */
type StringToolsINTF interface {
	// Format、Replace、Check
	FormatStr(params string) string
	ReplaceStr(params string) string
	CheckFormatStr(params string) bool

	// trans params
	ReduceStr2StrArray(params string) []string  // string 转 数组
	ReduceStr2StrMatrix(params string) []string // string 转 矩阵

	// Recognize params
	RecognizeBool(params string) (bool, error)                  //将字符串转成 boolean
	RecognizeBoolArray(params string) ([]bool, error)           //将字符串转成 boolean 数组
	RecognizeInt(params string) (int, error)                    //将字符串转成 int
	RecognizeIntArray(params string) ([]int, error)             //将字符串转成 int 数组
	RecognizeIntMatrix(params string) ([][]int, error)          //将字符串转成 int 矩阵
	RecognizeStr(params string) (string, error)                 //将字符串转成 string
	RecognizeStrArray(params string) ([]string, error)          //将字符串转成 string 数组
	RecognizeStrMatrix(params string) ([][]string, error)       //将字符串转成 string 矩阵
	RecognizeNodelj(params string) (*list.Nodelj, error)        //将字符串转成 Nodelj
	RecognizeNodeljArray(params string) ([]*list.Nodelj, error) //将字符串转成 Nodelj 数组

	// PlaceHolder
	MapPlaceHolder(sourceStr string, targetMap map[string]interface{}) (string, error)
}
