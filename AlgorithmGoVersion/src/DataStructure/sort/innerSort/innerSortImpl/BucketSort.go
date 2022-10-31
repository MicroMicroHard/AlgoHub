package innerSortImpl

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021-06-22 00:09
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 桶排序
 */

type BucketSort struct {
}

func (s *BucketSort) SortMethod(array []int) []int {
	if array == nil || len(array) <= 1 {
		return array
	}
	return array
}

func (s *BucketSort) InterfaceName() string {
	return "ArraySortINTF"
}
