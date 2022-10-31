package slidingWindow

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/7/21
 * @author—Email 蔚蔚樱first@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 数组的连续积小于给定值的组合
 * 求出数组中连续数的积小于给定值的组合,使用滑动窗口
 * <p>
 * 输入：{10, 5, 2, 6}，target：100
 * 输出：{
 * {10}, {10,5}, {10,5,2},
 * {5}, {5,2}, {5,2,6},
 * {2}, {2,6},
 * {6}
 * }
 */

type ArraypermutationSliding struct {
}


func (as *ArraypermutationSliding) GetAnswer(array []int, target int) (list1 [][]int) {

	left := 0
	right := 0
	mul := 1
	listAll := make([][]int, 0)
	// 确定边界
	for ; right < len(array)-1 || left < right; {

		// 右指针扩张
		for ; right < len(array); {
			if mul*array[right] <= target {
				mul = mul * array[right]
				right++
			} else {
				break
			}
		}
		listTemp := print(array, left, right-1)
		listAll = append(listAll, listTemp...)
		// 左指针收缩
		mul = mul / array[left]
		left++
	}
	return listAll
}

// 输出 
func print(array []int, left, right int) (listSub [][]int) {

	listAllSub := make([][]int, 0)
	for i := left; i <= right; i++ {
		sub := make([]int, 0)
		for j := left; j <= i; j++ {
			sub = append(sub, array[j])
		}
		listAllSub = append(listAllSub, sub)
	}
	return listAllSub
}
