package innerSort

import "AlgorithmPractice/src/DataStructure/list"

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/2 00:31
 * @author-Email micromicrohard@outlook.com
 * @description
 */
type ListSortINTF interface {
	SortMethod(root *list.Nodelj) *list.Nodelj

	InterfaceName() string
}
