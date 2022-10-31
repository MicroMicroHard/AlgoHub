package singleListReverse

import "AlgorithmPractice/src/DataStructure/list"

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/7 16:45
 * @author-Email micromicrohard@outlook.com
 * @description
 */
type ReverseByMultiPoint2 struct {
}

func (r *ReverseByMultiPoint2) ReverseMethod(node *list.Nodelj) *list.Nodelj {
	if node == nil {
		return nil
	}
	var (
		pre     *list.Nodelj
		cur     = node
		NewNode *list.Nodelj
	)
	for cur != nil {
		pre = cur
		cur = cur.Next
		pre.Next = NewNode
		NewNode = pre
	}
	return NewNode
}

func (r *ReverseByMultiPoint2) InterfaceName() string {
	return "ReverseList"
}
