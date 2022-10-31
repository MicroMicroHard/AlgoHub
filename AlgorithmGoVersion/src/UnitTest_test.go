package src

import (
	"AlgorithmPractice/src/Algorithm/dynamic/lcs"
	"AlgorithmPractice/src/Algorithm/math"
	"AlgorithmPractice/src/Common/Utils"
	"AlgorithmPractice/src/Common/conf"
	"testing"
)

var (
	utFactory Utils.UTFactory
)

func init() {
	conf.GetConfig()
	utFactory = Utils.NewUTFactory()
	DBConnTool = Utils.NewDBConnTools()
}

// 验证功能：用于全量测试
func TestFunc(t *testing.T) {
	//utFactory.UTExecutorWithoutPool(&innerSortImpl.HeapSort{})
	/*utFactory.UTExecutorWithoutPool(interface().(math.Combination)
	utFactory.UTEntrance(&math.Permutation{})*/
	utFactory.UTExecutorWithPool([]interface{}{
		&math.Combination{},
	})
}

// 调试功能 : 用于复现错误测试案例
func TestDoubleTrack(t *testing.T) {
	input := "abcde1234  ############  1234abcde"
	output := "abcde"
	utFactory.DoubleTrack(&lcs.LCS_Dynamic{}, input, output)
}

/* array grammar / attention:
	以下两种写法区别：
	a = append(a, GetDataStructure()...)
	a = append(a, GetDataStructure())
    ...是拆成单个，不写...是整个数组作为一个元素进入 */
// 全量回归测试
func TestAllUT(t *testing.T) {
	a := append(GetAlgorithm(), GetDataStructure()...)
	utFactory.UTExecutorWithPool(a)
}

func TestAlgorithmUT(t *testing.T) {
	utFactory.UTExecutorWithPool(GetAlgorithm())
}

func TestDataStructureUT(t *testing.T) {
	utFactory.UTExecutorWithPool(GetDataStructure())
}
