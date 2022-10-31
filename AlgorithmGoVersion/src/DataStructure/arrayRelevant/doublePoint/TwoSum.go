package doublePoint

import "sort"

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/6/14 10:18 下午
 * @author-Email micromicrohard@outlook.com
 * @description 2数之和 测试案例
 * 给定一个数 target，在一维数组中，找出某 2 个数相加得 target。
 * 要求一：如果存在这个 2 个数，返回true，反则返回false。
 * 要求二：返回存在的这 2 个值
 * 要求三：返回存在的这 2 个值在数组中的原位置
 * 要求四：返回所有的 2 数之和的组合
 * 要求五：返回所有的 2 数之和在数组中原位置的组合
 */

type TwoSum struct {
}

func (t *TwoSum) Method(array []int, target int) bool {
	if array == nil || len(array) == 0 {
		return false
	}
	// array copy grammar:深拷贝和欠拷贝 copy,不影响原来的数组
	var arrayNew = make([]int, len(array))
	copy(arrayNew[:], array)
	sort.Ints(arrayNew)
	left := 0
	right := len(arrayNew) - 1
	for left < right {
		for left < right && arrayNew[left]+arrayNew[right] < target { // grammar: 代替 while的写法
			left++
		}
		for left < right && arrayNew[left]+arrayNew[right] > target {
			right--
		}
		if left < right && arrayNew[left]+arrayNew[right] == target {
			return true
		}
	}
	return false
}
