package innerSort

// 所有排序算法的接口
type ArraySortINTF interface {
	SortMethod(array []int) []int

	InterfaceName() string
}
