package Utils

import C "AlgorithmPractice/src/Common/Constant"

func GetMax(value1, value2 int) int {
	if value1 > value2 {
		return value1
	}
	return value2
}

func GetMin(value1, value2 int) int {
	if value1 > value2 {
		return value2
	}
	return value1
}

func CompAbs(a, b int) int {
	if a < 0 {
		a = -a
	}
	if b < 0 {
		b = -b
	}
	return a - b
}

func GetAbs(a, b int) (absA, absB int) {
	if a < 0 {
		a = -a
	}
	if b < 0 {
		b = -b
	}
	return a, b
}

func GetArrayMaxIndex(array []int, index1, index2 int) int {
	if index1 >= len(array) || index2 >= len(array) {
		return C.ErrorNum
	}
	if array[index1] > array[index2] {
		return index1
	}
	return index2
}

func GetArrayMinIndex(array []int, index1, index2 int) int {
	if index1 >= len(array) || index2 >= len(array) {
		return C.ErrorNum
	}
	if array[index1] > array[index2] {
		return index2
	}
	return index1
}
