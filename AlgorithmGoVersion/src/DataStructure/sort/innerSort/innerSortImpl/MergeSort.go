package innerSortImpl

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021-06-22 00:09
 * @author—Email 蔚蔚樱first@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 归并排序
 */

type MergeSort struct {
}

func (s *MergeSort) SortMethod(array []int) []int {

	if array == nil || len(array) <= 1 {
		return array
	}
	temp := make([]int, len(array))
	s.mergeSort(array, temp, 0, len(array)-1)
	return array
}

func (s *MergeSort) mergeSort(array, temp []int, left, right int) {
	if left < right {
		mid := (left + right) / 2
		s.mergeSort(array, temp, left, mid)
		s.mergeSort(array, temp, mid+1, right)
		s.sort(array, temp, left, mid, right)
	}
}

func (s *MergeSort) sort(array, temp []int, left, mid, right int) {
	l := left
	r := mid + 1
	position := left
	for l <= mid && r <= right {
		if array[l] < array[r] {
			temp[position] = array[l]
			l++
		} else {
			temp[position] = array[r]
			r++
		}
		position++
	}
	for l <= mid {
		temp[position] = array[l]
		l++
		position++
	}
	for r <= right {
		temp[position] = array[r]
		r++
		position++
	}
	//原址
	for i := left; i <= right; i++ {
		array[i] = temp[i]
	}
}

func (s *MergeSort) InterfaceName() string {
	return "ArraySortINTF"
}