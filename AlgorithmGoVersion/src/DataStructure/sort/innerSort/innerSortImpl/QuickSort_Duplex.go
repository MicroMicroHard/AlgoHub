package innerSortImpl

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021-06-22 00:09
 * @author—Email 蔚蔚樱first@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 快速排序——双向快排
 */

type QuickSortDuplex struct {
}

func (s *QuickSortDuplex) SortMethod(array []int) []int {
	if array == nil || len(array) <= 1 {
		return array
	}
	quickSortDuplexing(array, 0, len(array)-1)
	return array
}

func quickSortDuplexing(array []int, left, right int) {

	if left < right {
		flagPosition := left
		lowPosition := left
		highPosition := right

		//自左,右向中间进行对比
		for ; lowPosition < highPosition; {
			/**
			 * tips003：两个while必须有一个=，不然会导致死循环
			 *
			 * tips004:下方两个while循环可以互相换顺序，
			 * 但是如果是从小到大排序，"="号必须给high
			 * 但是如果是从大到小排序，"="号必须给low
			 */

			// 自左向中间进行对比
			for ; lowPosition < highPosition; lowPosition++ {
				if array[lowPosition] >= array[flagPosition] {
					break
				}
			}
			//自右向中间进行对比
			for ; highPosition > lowPosition; highPosition-- {
				if array[highPosition] < array[flagPosition] {
					break
				}
			}
			//交换值
			if lowPosition < highPosition {
				array[lowPosition], array[highPosition] = array[highPosition], array[lowPosition]
			}
		}

		//交换标杆元素
		if lowPosition != flagPosition {
			array[lowPosition], array[flagPosition] = array[flagPosition], array[lowPosition]
		}

		quickSortDuplexing(array, left, lowPosition-1)
		quickSortDuplexing(array, highPosition+1, right)
	}
}

func (s *QuickSortDuplex) InterfaceName() string {
	return "ArraySortINTF"
}