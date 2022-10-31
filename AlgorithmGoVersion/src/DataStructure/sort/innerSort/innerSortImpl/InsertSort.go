package innerSortImpl

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021-06-20 13:09
 * @author—Email 蔚蔚樱first@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 插入排序
 */

type InsertSort struct {
}

func (s *InsertSort) SortMethod(array []int) []int {

	if array == nil || len(array) <= 1 {
		return array
	}
	for index := 1; index <= len(array)-1; index++ {
		cur := index
		temp := array[index]
		for ; cur >= 1; cur-- {
			if temp < array[cur-1] {
				array[cur] = array[cur-1]
			} else {
				break
			}
		}
		if cur != index {
			array[cur] = temp
		}
	}
	return array
}

func (s *InsertSort) InterfaceName() string {
	return "ArraySortINTF"
}