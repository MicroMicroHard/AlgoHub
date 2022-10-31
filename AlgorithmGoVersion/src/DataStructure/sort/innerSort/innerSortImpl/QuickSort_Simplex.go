package innerSortImpl

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021-06-22 00:09
 * @author—Email 蔚蔚樱first@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 快速排序——单向快排
 */

type QuickSortSimplex struct {
}

func (s *QuickSortSimplex) SortMethod(array []int) []int {
	if array == nil || len(array) <= 1 {
		return array
	}
	quickSortSimplex(array, 0, len(array)-1)
	return array
}

func quickSortSimplex(array []int, left, right int) {

	midPosition := left
	flagPosition := left
	if left < right {
		//自左向右进行对比
		for i := left + 1; i <= right; i++ {
			if array[i] < array[flagPosition] {
				midPosition++
				array[midPosition], array[i] = array[i], array[midPosition]
			}
		}
		//交换标杆元素
		if midPosition != flagPosition {
			array[midPosition], array[flagPosition] = array[flagPosition], array[midPosition]
		}

		quickSortSimplex(array, left, midPosition-1)
		quickSortSimplex(array, midPosition+1, right)
	}
}

func (s *QuickSortSimplex) InterfaceName() string {
	return "ArraySortINTF"
}