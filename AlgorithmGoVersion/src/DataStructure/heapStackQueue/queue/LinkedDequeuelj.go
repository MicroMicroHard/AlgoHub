package queue

type LinkDeQueuelj struct {
}

// Offer = push，入队
func (queue *LinkDeQueuelj) Offer(value int) bool {
	return false
}

// Poll 出队
func (queue *LinkDeQueuelj) Poll() int {
	return 0
}

// Peek 弹出第一个队首元素（不删除）
func (queue *LinkDeQueuelj) Peek() int {
	return 0
}

// Empty 队列判空
func (queue *LinkDeQueuelj) Empty() bool {
	return false
}

// GetRealSize 获取真实队列长度
func (queue *LinkDeQueuelj) GetRealSize() int {
	return 0
}

// GetMaxsize 获取最大队列长度
func (queue *LinkDeQueuelj) GetMaxsize() int {
	return 0
}

// ReSize 队列扩容
func (queue *LinkDeQueuelj) ReSize() {

}

// Search 查找函数
func (queue *LinkDeQueuelj) Search(value int) bool {
	return false
}

// offerFront offer = push, 队首入队
func (queue *LinkDeQueuelj) OfferFront(value int) bool {
	return false
}

// offerTail offer = push, 队尾入队
func (queue *LinkDeQueuelj) OfferTail(value int) bool {
	return false
}

// peekFront 弹出第一个队首元素（不删除）
func (queue *LinkDeQueuelj) PeekFront() int {
	return 0
}

// peekTail 弹出第一个队尾元素（不删除）
func (queue *LinkDeQueuelj) PeekTail() int {
	return 0
}

// pollFront poll = add, 队首出队
func (queue *LinkDeQueuelj) PollFront() int {
	return 0
}

// pollTail poll = add, 队尾出队
func (queue *LinkDeQueuelj) PollTail() int {
	return 0
}
