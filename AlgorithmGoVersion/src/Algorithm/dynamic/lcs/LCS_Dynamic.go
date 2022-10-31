package lcs

// LCS_Dynamic
// @author: 蔚蔚樱
// @date: 2022/8/218:46
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:
type LCS_Dynamic struct {
}

// 返回 字符串 source, pattern 的相似度【有几个字符相等】
func (lcs *LCS_Dynamic) GetCommonLength(source, pattern string) int {
	if source == "" || pattern == "" {
		return 0
	}
	numMatrix, _ := lcs.lcsOperation(source, pattern)
	return numMatrix[len(source)-1][len(pattern)-1]
}

func (lcs *LCS_Dynamic) GetSimilarityMethod(source, pattern string) string {
	if source == "" || pattern == "" {
		return ""
	}
	_, similarityMatrix := lcs.lcsOperation(source, pattern)
	return lcs.BackTrackLCS(similarityMatrix, pattern)
}

func (lcs *LCS_Dynamic) lcsOperation(source, pattern string) ([][]int, [][]string) {
	var (
		n1, n2           int        // 获取字符串长度,其中在矩阵中n1表示行数,n2表示列数
		numMatrix        [][]int    // 数值矩阵 存放字符匹配数量的最大值
		similarityMatrix [][]string // 标记矩阵 存放字符匹配标记
	)
	n1 = len(source)
	n2 = len(pattern)
	numMatrix = make([][]int, n1+1)
	similarityMatrix = make([][]string, n1+1)
	for i, _ := range numMatrix {
		numMatrix[i] = make([]int, n2+1)
		similarityMatrix[i] = make([]string, n2+1)
	}

	for i := 1; i <= n1; i++ {
		for j := 1; j <= n2; j++ {
			a := string(source[i-1])
			b := string(pattern[j-1])
			if a == b {
				numMatrix[i][j] = numMatrix[i-1][j-1] + 1
				similarityMatrix[i][j] = "match"
			} else if numMatrix[i-1][j] > numMatrix[i][j-1] {
				numMatrix[i][j] = numMatrix[i-1][j]
				similarityMatrix[i][j] = "up"
			} else {
				numMatrix[i][j] = numMatrix[i][j-1]
				similarityMatrix[i][j] = "left"
			}
		}
	}
	return numMatrix, similarityMatrix
}

func (lcs *LCS_Dynamic) BackTrackLCS(similarityMatrix [][]string, pattern string) string {
	var lcsStrArr []string // lsc串
	var lcsString string   // lsc串
	if similarityMatrix == nil || len(similarityMatrix) == 0 {
		return ""
	}
	// attention: i,j 并不是双重循环，不能直接 ++--
	row := len(similarityMatrix) - 1
	column := len(similarityMatrix[0]) - 1
	for row >= 0 && column >= 0 {
		if similarityMatrix[row][column] == "match" {
			lcsStrArr = append(lcsStrArr, string(pattern[column-1]))
			row--
			column--
		} else if similarityMatrix[row][column] == "up" {
			row--
		} else {
			column--
		}
	}
	// grammar string数组转string
	for i := len(lcsStrArr) - 1; i >= 0; i-- {
		lcsString += lcsStrArr[i]
	}
	return lcsString
}

func (lcs *LCS_Dynamic) InterfaceName() string {
	return "LCS"
}
