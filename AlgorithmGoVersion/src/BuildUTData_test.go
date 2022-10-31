package src

import (
	"AlgorithmPractice/src/Algorithm/dynamic/lcs"
	"AlgorithmPractice/src/Algorithm/math"
	"AlgorithmPractice/src/Common/MidwareConn/DBConn"
	"AlgorithmPractice/src/Common/Utils"
	"AlgorithmPractice/src/DataStructure/arrayRelevant/doublePoint"
	"AlgorithmPractice/src/DataStructure/list/listReverse/singleListReverse"
	"AlgorithmPractice/src/DataStructure/sort/innerSort/innerSortImpl"
	"fmt"
	"testing"
)

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/9/27 02:35
 * @author-Email micromicrohard@outlook.com
 * @description
 */
var (
	DBConnTool *Utils.DBConnTools
)

// 打印测试案例
func TestPrintUTData(t *testing.T) {
	utFactory.PrintUTData(&math.Combination{})
}

func GetAlgorithm() []interface{} {
	clazzArr := []interface{}{

		// backtrack
		// comprehensive

		// dynamic
		&lcs.LCS_Dynamic{}, //&lcs.LCS_Optimize{},
		//Palindrome_Judge.class,
		//Palindrome_Find.class,

		// greedy

		// math
		&math.PrimeNum{}, &math.PrimeNumChannel{}, &math.Combination{}, &math.Permutation{}, &math.Factorial{},
		//NthPowerOfTwo.class,

		//BigNumSum.class,
		//BigNumSub.class,
		//BigNumMulti.class
		//BigNumDiv.class,
	}
	return clazzArr
}

func GetDataStructure() []interface{} {
	clazzArr := []interface{}{
		// arrayRelevant
		//ArrayMulti.class,
		//BuildTeamByTall.class,
		//FindArraySection.class,
		//FindLongestSequence.class,
		// arrayRelevant -- xor
		//FindNum_Treble_One.class,
		//FindNum_Twice_Two.class,
		//FindNum_Once_Double.class,
		//FindNum_Twice_One.class,
		// arrayRelevant -- doublePoint
		//&doublePoint.TwoSum{},
		//&doublePoint.TwoSumLikely{},
		&doublePoint.ThreeSumLikely{},
		//TwoSum_Position.class,
		//TwoSum_Position_Repeat.class,
		//ThreeSum.class,

		// list
		&singleListReverse.ReverseByMultiPoint{}, &singleListReverse.ReverseByMultiPoint2{}, &singleListReverse.ReverseByStackPart{},

		// graph
		//TheLeastNeighbors.class,
		//Floyd.class,

		// heapStackQueue
		//WordFrequency.class,

		// sort
		&innerSortImpl.HeapSort{},

		// stringOps
		// stringOps -- LNS
		//LNRSubstring.class,
		// stringOps -- slidingWindow
		// stringOps -- stringAndSequence
		//DigitalTrans.class,

		// tree
		//BT_MirrorJudge.class,
		//BT_MirrorOperation.class,
		//BT_MaxBroad.class,
		//BT_MaxDepth.class,
		//BT_BalanceJudge.class,
	}
	return clazzArr
}

// 主从同步数据
func TestSynchronizationUTData(t *testing.T) {
	DBConnTool.SynchronizationUTData()
}

// 读写分离:从库读取
func TestReadWriteSeparation_Read(t *testing.T) {
	className := "ArrayMulti"
	result, err := DBConnTool.UTDate_QueryBySlaver(className)
	if err != nil {
		fmt.Print(err)
	}
	for i := 0; i < len(result); i++ {
		result[i].Print()
	}
}

// 读写分离:主库写入
func TestReadWriteSeparation_Write(t *testing.T) {
	i1 := "121911"
	i2 := "2221"
	i3 := "333"
	entity := DBConn.UTDataEntity{
		Input:     &i1,
		Output:    &i2,
		ClassName: &i3,
	}
	DBConnTool.MySqlCluster.ExecInsert(&entity)
}
