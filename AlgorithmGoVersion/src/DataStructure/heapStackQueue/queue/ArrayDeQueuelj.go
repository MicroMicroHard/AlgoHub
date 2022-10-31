package queue

type ArrayDeQueuelj struct {
	*ArrayQueuelj // go grammar 不写相当于Java中的继承
}

// Offer = Push，入队 // offerTail offer = Push, 队尾入队
func (queue *ArrayDeQueuelj) Offer(value int) bool {
	return false
}

// offerFront offer = Push, 队首入队
func (queue *ArrayDeQueuelj) OfferFront(value int) bool {
	return false
}

// Poll 出队  // PollFront Poll = add, 队首出队
func (queue *ArrayDeQueuelj) Poll() int {
	return 0
}

// PollTail Poll = add, 队尾出队
func (queue *ArrayDeQueuelj) PollTail() int {
	return 0
}

// Peek 弹出第一个队首元素（不删除） // PeekFront 弹出第一个队首元素（不删除）
func (queue *ArrayDeQueuelj) Peek() int {
	return 0
}

// PeekTail 弹出第一个队尾元素（不删除）
func (queue *ArrayDeQueuelj) PeekTail() int {
	return 0
}

// Empty 队列判空
func (queue *ArrayDeQueuelj) Empty() bool {
	return false
}

// GetRealSize 获取真实队列长度
func (queue *ArrayDeQueuelj) GetRealSize() int {
	return 0
}

// GetMaxsize 获取最大队列长度
func (queue *ArrayDeQueuelj) GetMaxsize() int {
	return 0
}

// ReSize 队列扩容
func (queue *ArrayDeQueuelj) ReSize() {

}

// Search 查找函数
func (queue *ArrayDeQueuelj) Search(value int) bool {
	return false
}
