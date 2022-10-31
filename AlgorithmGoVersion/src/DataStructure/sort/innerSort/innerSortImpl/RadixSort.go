package innerSortImpl

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021-06-22 00:09
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 基数排序
 */

type RadixSort struct {
}

func (s *RadixSort) SortMethod(array []int) []int {
	if array == nil || len(array) <= 1 {
		return array
	}
	return array
}

func (s *RadixSort) InterfaceName() string {
	return "ArraySortINTF"
}