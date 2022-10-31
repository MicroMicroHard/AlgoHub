package singleListReverse

import "AlgorithmPractice/src/DataStructure/list"

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/7 16:45
 * @author-Email micromicrohard@outlook.com
 * @description 使用一个领头指针
 */
type ReverseByMultiPoint struct {
}

func (r *ReverseByMultiPoint) ReverseMethod(node *list.Nodelj) *list.Nodelj {
	if node == nil {
		return nil
	}
	newNode := &list.Nodelj{}
	cur := node
	pre := node
	for cur != nil {
		pre = cur
		cur = cur.Next
		pre.Next = newNode.Next
		newNode.Next = pre
	}
	return newNode.Next
}

func (r *ReverseByMultiPoint) InterfaceName() string {
	return "ReverseList"
}
