package Utils

import (
	C "AlgorithmPractice/src/Common/Constant"
	"AlgorithmPractice/src/Common/conf"
	"AlgorithmPractice/src/DataStructure/list"
	"encoding/json"
	"fmt"
	"github.com/spf13/cast"
	"regexp"
	"strconv"
	"strings"
)

// StringUtils
/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/2/27 4:56 PM
 * @author-Email micromicrohard@outlook.com
 * @description 字符串 处理函数
 * <p>
 * 将字符串转成boolean        {@link StringHandler#RecognizeBool}
 * 将字符串转成int            {@link StringHandler#RecognizeInt}
 * 将字符串转成int[]          {@link StringHandler#RecognizeIntArray}
 * 将字符串转成int[][]        {@link StringHandler#RecognizeIntMatrix}
 * 将字符串转成String         {@link StringHandler#RecognizeStr}
 * 将字符串转成String[]       {@link StringHandler#RecognizeStrArray}
 * 将字符串转成String[][]     {@link StringHandler#RecognizeStrMatrix}
 * 将字符串转成Nodelj         {@link StringHandler#RecognizeNodelj}
 * 将字符串转成Nodelj[]       {@link StringHandler#RecognizeNodeljArray}
 * <p>
 * 数据库中的数据格式可能存在不规则的情况，比如两个[],[]之间的空格位置可能是[], []或者[] ,[]，因此需要统一化{@link StringHandler#formatString}，
 * 数据处理的时候，需要把:}、{、]、"、[这五个符号替换掉，{@link StringHandler#replaceString}，
 * 数据处理的时候，需要校验是否仅含【大小写字母、数字、负数、逗号、空格】，{@link StringHandler#CheckFormatStr}，
 * 数据处理的时候，需要字符串解析成String一维数组{@link StringHandler#ReduceStr2StrArray}和二维数组{@link StringHandler#ReduceStr2StrMatrix}，
 */

type StringTools struct {
}

func (s *StringTools) FormatStr(params string) string {
	return strings.ReplaceAll(params, " ", "")
}

func (s *StringTools) ReplaceStr(params string) string {
	params = strings.ReplaceAll(params, "{", "")
	params = strings.ReplaceAll(params, "}", "")
	params = strings.ReplaceAll(params, "[", "")
	params = strings.ReplaceAll(params, "]", "")
	params = strings.ReplaceAll(params, "\"", "")
	return strings.Trim(params, " ")
}

//CheckFormatStr 正则 grammar: MustCompile, 检验是否仅含【大小写字母、数字、负数、逗号、空格】，
//如果需要加上"[]"的检验，写法：pattern = "[-,a-z\\[\\]A-Z\\s\\d*]+";
func (s *StringTools) CheckFormatStr(params string) bool {
	params = s.ReplaceStr(s.FormatStr(params))
	pattern := "[-,a-zA-Z\\s\\d*]+"
	reg := regexp.MustCompile(pattern)
	if !reg.Match([]byte(params)) {
		fmt.Println("Error, params :" + params)
		return false
	}
	return true
}

func (s *StringTools) ReduceStr2StrArray(params string) []string {
	params = s.FormatStr(params)
	if !s.CheckFormatStr(params) {
		return nil
	}
	return strings.Split(params, ",")
}

func (s *StringTools) ReduceStr2StrMatrix(params string) []string {
	if params == "" || len(params) == 0 {
		return nil
	}
	params = s.FormatStr(params)
	if !s.CheckFormatStr(params) {
		return nil
	}
	if strings.ContainsAny(params, "},{") {
		return strings.Split(params, "},{")
	}
	return strings.Split(params, "],[")
}

// MapPlaceHolder map占位符替换
func (s *StringTools) MapPlaceHolder(sourceStr string, targetMap map[string]interface{}) (string, error) {

	sourceMap := make(map[string]interface{})
	err := json.Unmarshal([]byte(sourceStr), &sourceMap)
	if err != nil {
		fmt.Println("err", err)
		return "", err
	}

	for k, v := range sourceMap {
		switch v.(type) {
		case string:
			placeStr := ""
			// Tips strings Contains的用法
			if strings.Contains(v.(string), "#") {
				// Tips strings Split的用法
				vSplit := strings.Split(v.(string), "#")
				if len(vSplit)%2 == 0 {
					continue
				}
				for i := 0; i < len(vSplit); i++ {
					if i%2 == 0 {
						placeStr += vSplit[i]
					} else {
						value, ok := targetMap[vSplit[i]]
						if ok {
							placeStr += cast.ToString(value)
						}
					}
				}
				sourceMap[k] = placeStr
			}
		default:
		}
	}

	d, err := json.Marshal(sourceMap)
	if err != nil {
		return "", err
	}
	return string(d), nil
}

func (s *StringTools) RecognizeBool(params string) (bool, error) {
	return strings.EqualFold(params, conf.AlgorithmConf.Common.TRUEExpr), nil
}

func (s *StringTools) RecognizeBoolArray(params string) ([]bool, error) {
	return nil, nil
}

func (s *StringTools) RecognizeInt(params string) (int, error) {
	switch params {
	case conf.AlgorithmConf.Common.MinValueExpr:
		return C.MinInt64, nil
	case conf.AlgorithmConf.Common.MaxValueExpr:
		return C.MaxInt64, nil
	case conf.AlgorithmConf.Common.ErrorExpr:
		return C.ErrorNum, nil
	}
	/*	if stringEqualFold(params, C.ErrorNumStr) {
		return C.ErrorNum, nil
	}*/
	intValue, err := strconv.Atoi(params)
	if err != nil {
		fmt.Println("RecognizeInt ERROR:", err)
		return C.ErrorNum, err
	}
	return intValue, nil
}

func (s *StringTools) RecognizeIntArray(params string) ([]int, error) {
	switch params {
	case conf.AlgorithmConf.Common.NullExpr:
		return nil, nil
	case conf.AlgorithmConf.Common.EmptyExpr:
		return make([]int, 0), nil
	default:
	}
	paramsStrArray := s.ReduceStr2StrArray(params)
	if paramsStrArray == nil {
		return nil, nil
	}
	paramsStringArray := make([]int, len(paramsStrArray))
	for k, v := range paramsStrArray {
		recognizeInt, err := s.RecognizeInt(v)
		if err != nil {
			fmt.Printf("\nRecognizeIntArray")
			return nil, err
		}
		paramsStringArray[k] = recognizeInt
	}
	return paramsStringArray, nil
}

func (s *StringTools) RecognizeIntMatrix(params string) ([][]int, error) {
	switch params {
	case conf.AlgorithmConf.Common.NullExpr:
		return nil, nil
	case conf.AlgorithmConf.Common.EmptyExpr:
		return make([][]int, 0), nil
	default:
	}
	paramsStrArray := s.ReduceStr2StrMatrix(params)
	if paramsStrArray == nil {
		return nil, nil
	}
	paramsStringArray := make([][]int, len(paramsStrArray))
	var err error
	for i := 0; i < len(paramsStrArray); i++ {
		paramsStringArray[i], err = s.RecognizeIntArray(paramsStrArray[i])
		if err != nil {
			fmt.Println("err:", err)
			return nil, err
		}
	}
	return paramsStringArray, nil
}

func (s *StringTools) RecognizeStr(params string) (string, error) {
	switch params {
	/*case conf.AlgorithmConf.Common.NullExpr:
	return nil, nil*/
	case conf.AlgorithmConf.Common.EmptyExpr:
		return "", nil
	default:
	}
	return params, nil
}

func (s *StringTools) RecognizeStrArray(params string) ([]string, error) {
	switch params {
	case conf.AlgorithmConf.Common.NullExpr:
		return nil, nil
	case conf.AlgorithmConf.Common.EmptyExpr:
		return make([]string, 0), nil
	default:
	}
	paramsStrArray := s.ReduceStr2StrArray(params)
	if paramsStrArray == nil {
		return nil, nil
	}
	paramsStringArray := make([]string, len(paramsStrArray))
	for i := 0; i < len(paramsStrArray); i++ {
		paramsStringArray[i] = s.ReplaceStr(paramsStrArray[i])
	}
	return paramsStringArray, nil
}

func (s *StringTools) RecognizeStrMatrix(params string) ([][]string, error) {
	switch params {
	case conf.AlgorithmConf.Common.NullExpr:
		return nil, nil
	case conf.AlgorithmConf.Common.EmptyExpr:
		return make([][]string, 0), nil
	default:
	}
	paramsStrArray := s.ReduceStr2StrMatrix(params)
	if paramsStrArray == nil {
		return nil, nil
	}
	paramsStringArray := make([][]string, len(paramsStrArray))
	for i, paramsStr := range paramsStrArray {
		paramsStringArray[i] = s.ReduceStr2StrArray(paramsStr)
	}
	return paramsStringArray, nil
}

func (s *StringTools) RecognizeNodelj(params string) (*list.Nodelj, error) {
	arr, err := s.RecognizeIntArray(params)
	if err != nil {
		return nil, err
	}
	nodeTools := list.NewNodeEmpty()
	return nodeTools.Array2Nodelj(arr), nil
}

func (s *StringTools) RecognizeNodeljArray(params string) ([]*list.Nodelj, error) {
	var (
		nodeArr   = make([]*list.Nodelj, 0)
		nodeTools = list.NewNodeEmpty()
	)
	arrayMatrix, err := s.RecognizeIntMatrix(params)
	if err != nil {
		return nil, err
	}
	for _, arr := range arrayMatrix {
		nodeArr = append(nodeArr, nodeTools.Array2Nodelj(arr))
	}
	return nodeArr, nil
}
