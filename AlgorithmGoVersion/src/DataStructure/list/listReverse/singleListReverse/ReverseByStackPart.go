package singleListReverse

import "AlgorithmPractice/src/DataStructure/list"

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/7 16:45
 * @author-Email micromicrohard@outlook.com
 * @description
 */
type ReverseList interface {
	ReverseMethod(node *list.Nodelj) *list.Nodelj
	InterfaceName() string
}

type ReverseByStackPart struct {
}

func (r *ReverseByStackPart) ReverseMethod(node *list.Nodelj) *list.Nodelj {
	if node == nil {
		return nil
	}
	return r.Reverse(node)
}

func (r *ReverseByStackPart) Reverse(node *list.Nodelj) *list.Nodelj {
	if node.Next == nil {
		return node
	}
	NewNode := r.Reverse(node.Next)
	node.Next.Next = node
	node.Next = nil
	return NewNode
}

func (r *ReverseByStackPart) InterfaceName() string {
	return "ReverseList"
}
