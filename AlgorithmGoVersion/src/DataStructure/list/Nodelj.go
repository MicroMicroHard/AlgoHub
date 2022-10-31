package list

import "fmt"

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/7/9 13:43
 * @author-Email micromicrohard@outlook.com
 * @description
 */
type Nodelj struct {
	Key   int
	Value string
	Front *Nodelj
	Next  *Nodelj
	Down  *Nodelj
}

func NewNodeEmpty() *Nodelj {
	return &Nodelj{}
}

func NewNodeKey(key int) *Nodelj {
	return &Nodelj{Key: key}
}

func NewNode(key int, value string) *Nodelj {
	return &Nodelj{Key: key, Value: value}
}

func (n *Nodelj) Print() {
	if n != nil {
		fmt.Print(n.Value, " -> ")
		n.Next.Print()
	}
}

func (n *Nodelj) Nodelj2Array() {
	n.NodeljToArray(n)
}

func (n *Nodelj) NodeljToArray(nodelj *Nodelj) []int {
	var (
		arr = make([]int, 0)
	)
	for nodelj != nil {
		arr = append(arr, nodelj.Key)
		nodelj = nodelj.Next
	}
	return arr
}

func (n *Nodelj) Array2Nodelj(array []int) *Nodelj {
	var (
		head = &Nodelj{}
		cur  *Nodelj
	)
	if array == nil || len(array) == 0 {
		return nil
	}
	cur = head
	for _, value := range array {
		cur.Next = &Nodelj{
			Key: value,
		}
		cur = cur.Next
	}
	return head.Next
}

func (n *Nodelj) NodeljEquals(a *Nodelj, b *Nodelj) bool {

	if a == nil && b == nil {
		return true
	}
	if a == nil || b == nil {
		return false
	}
	for a != nil && b != nil {
		if a.Key != b.Key {
			return false
		}
		a = a.Next
		b = b.Next
	}
	return a == nil && b == nil
}

func (n *Nodelj) NodeljEqual(b *Nodelj) bool {
	return n.NodeljEquals(n, b)
}
