package innerSortImpl

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021-06-22 00:09
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 计数排序
 */

type CountSort struct {
}

func (s *CountSort) SortMethod(array []int) []int {
	if array == nil || len(array) <= 1 {
		return array
	}
	return array
}


func (s *CountSort) InterfaceName() string {
	return "ArraySortINTF"
}