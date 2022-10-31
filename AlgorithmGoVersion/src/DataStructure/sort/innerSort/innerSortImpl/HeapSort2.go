package innerSortImpl

import (
	"AlgorithmPractice/src/Common/Utils"
)

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021-06-22 00:09
 * @author—Email 蔚蔚樱first@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 堆排序 2
 */

type HeapSort2 struct {
}

func (s *HeapSort2) SortMethod(array []int) []int {
	if array == nil || len(array) <= 1 {
		return array
	}

	for i := 0; i < len(array)-1; i++ {
		//整堆
		s.heapify2_big(array, len(array)-1-i)
		//交换
		array[0], array[len(array)-1-i] = array[len(array)-1-i], array[0]
	}
	return array
}

func (s *HeapSort2) heapify2_big(array []int, border int) {

	for root := (border - 1) / 2; root >= 0; root-- {
		child := root*2 + 1
		if child > border {
			break
		}
		// tips002:边界值的等于需要特别注意
		if child+1 <= border {
			child = Utils.GetArrayMaxIndex(array, child, child+1)
		}
		if array[child] > array[root] {
			array[child], array[root] = array[root], array[child]
		}
	}
}

func (s *HeapSort2) InterfaceName() string {
	return "ArraySortINTF"
}