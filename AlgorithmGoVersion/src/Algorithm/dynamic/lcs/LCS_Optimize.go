package lcs

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/11 18:09
 * @author-Email micromicrohard@outlook.com
 * @description
 */
type LCS_Optimize struct {
}

// 返回 字符串 source, pattern 的相似度【有几个字符相等】
func (lcs *LCS_Optimize) GetSimilarityMethod(source, pattern string) string {
	return ""
}

func (lcs *LCS_Optimize) GetCommonLength(source, pattern string) int {
	return 0
}

func (lcs *LCS_Optimize) lcsOperation(source, pattern string) {

}

func (lcs *LCS_Optimize) InterfaceName() string {
	return "LCS"
}
