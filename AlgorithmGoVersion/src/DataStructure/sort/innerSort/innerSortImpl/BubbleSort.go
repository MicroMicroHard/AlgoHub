package innerSortImpl

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021-06-22 00:09
 * @author—Email 蔚蔚樱first@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 冒泡排序
 */

type BubbleSort struct {
}

func (s *BubbleSort) SortMethod(array []int) []int {

	if array == nil || len(array) <= 1 {
		return array
	}
	//定义是否发生交换
	flag := false
	for index := 0; index < len(array)-1; index++ {
		for i := 0; i < len(array)-1-index; i++ {
			if array[i] > array[i+1] {
				array[i], array[i+1] = array[i+1], array[i]
				flag = true
			}
		}
		if !flag {
			break
		}
		flag = false
	}

	return array
}

func (s *BubbleSort) InterfaceName() string {
	return "ArraySortINTF"
}
