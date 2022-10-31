package doublePoint

import (
	"AlgorithmPractice/src/Common/Utils"
	"sort"
)

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/08/02
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 三数之和
 * 给定一个数 target，在一维数组中，找出某 3 个数相加与 target最相近。
 * 要求：
 * 如果存在这个 3 个数，返回这三个数，没有返回{Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE}
 * 输入：
 * int[] demoArray01_y = {1, 100, 22, 39, 43, 58, 64, 76, 79, 85, 96, 58};
 * int target01 = 99;
 * 输出：true (1-22-76)
 */

type ThreeSumLikely struct {
}

func (t *ThreeSumLikely) GetValuesMethod(array []int, target int) []int {

	sort.Ints(array)
	ans := make([]int, 3)
	if len(array) <= 2 {
		return nil
	}
	ans[0] = array[0]
	ans[1] = array[1]
	ans[2] = array[2]
	gap := array[0] + array[1] + array[2] - target

	for i := 0; i <= len(array)-3; i++ {
		left := i + 1
		right := len(array) - 1

		for left < right {
			temp := array[i] + array[left] + array[right] - target
			if Utils.CompAbs(gap, temp) > 0 {
				gap = temp
				ans[0] = array[i]
				ans[1] = array[left]
				ans[2] = array[right]
			}
			if temp == 0 {
				return ans
			} else if temp < 0 {
				left++
			} else {
				right--
			}
		}
	}
	sort.Ints(ans)
	return ans
}
