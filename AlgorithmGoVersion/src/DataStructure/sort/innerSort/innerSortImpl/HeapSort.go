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
 * @description 堆排序
 */

type HeapSort struct {
}

func (s *HeapSort) SortMethod(array []int) []int {
	if array == nil || len(array) <= 1 {
		return array
	}

	/*
		tips001:长度为n的数组，最后一个非叶子结点的index是: (n-1)/2
		推导：index为k的非叶子结点的左右孩子index分别是：2k+1、2k+2，所以为了求出确切的k值，index为n的孩子结点的父节点是：(n-1)/2
		应用：array最后一个叶子结点的index：n=len(arrayRelevant)-1，最后一个非叶子结点的index：（len(arrayRelevant)-1-1）/2 = len(arrayRelevant)/2-1
	*/
	// 建堆
	for i := len(array)/2 - 1; i >= 0; i-- {
		s.heapify_big(array, i, len(array)-1)
	}

	// 整堆
	for lastIndex := len(array) - 1; lastIndex > 0; lastIndex-- {
		array[0], array[lastIndex] = array[lastIndex], array[0]
		s.heapify_big(array, 0, lastIndex-1)
	}

	return array
}

//整堆函数——小顶堆
func (s *HeapSort) heapify_small(array []int, root, border int) {

	//边界检查
	if border >= len(array) || border <= 0 {
		return
	}
	//左孩子，最大值标记
	child := 2*root + 1
	if child > border {
		return
	}
	//如果右孩子存在,且找出最小值
	if child+1 <= border {
		child = Utils.GetArrayMinIndex(array, child, child+1)
	}
	if array[child] < array[root] {
		array[child], array[root] = array[root], array[child]
		s.heapify_small(array, child, border)
	}
}

func (s *HeapSort) heapify_big(array []int, root, border int) {

	if border <= 0 || border >= len(array) {
		return
	}
	child := root*2 + 1
	if child > border {
		return
	}
	if child+1 <= border {
		child = Utils.GetArrayMaxIndex(array, child, child+1)
	}
	if array[child] > array[root] {
		array[child], array[root] = array[root], array[child]
		s.heapify_big(array, child, border)
	}
}

func (s *HeapSort) InterfaceName() string {
	return "ArraySortINTF"
}