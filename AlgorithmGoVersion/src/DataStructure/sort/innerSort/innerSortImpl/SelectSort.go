package innerSortImpl

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021-06-20 13:09
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 选择排序
 */

type SelectSort struct {
}

func (s *SelectSort) SortMethod(array []int) []int {

	if array == nil || len(array) <= 1 {
		return array
	}

	for index := 0; index < len(array)-1; index++ {
		flag := index
		for cur := index + 1; cur <= len(array)-1; cur++ {
			if array[flag] > array[cur] {
				flag = cur
			}
		}
		if flag != index {
			array[flag], array[index] = array[index], array[flag]
		}
	}

	return array
}

func (s *SelectSort) InterfaceName() string {
	return "ArraySortINTF"
}