package lcs

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/11 18:02
 * @author-Email micromicrohard@outlook.com
 * @description
 */
type LCS interface {
	//获取LCS的长度
	GetCommonLength(source, pattern string) int

	//获取LCS的最长字串
	GetSimilarityMethod(source, pattern string) string

	InterfaceName() string
}
