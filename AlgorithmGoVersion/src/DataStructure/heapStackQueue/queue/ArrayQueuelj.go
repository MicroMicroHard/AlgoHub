package queue

type ArrayQueuelj struct {
}

// Offer = push，入队
func (queue *ArrayQueuelj) Offer(value int) bool {
	return false
}

// Poll 出队
func (queue *ArrayQueuelj) Poll() int {
	return 0
}

// Peek 弹出第一个队首元素（不删除）
func (queue *ArrayQueuelj) Peek() int {
	return 0
}

// Empty 队列判空
func (queue *ArrayQueuelj) Empty() bool {
	return false
}

// GetRealSize 获取真实队列长度
func (queue *ArrayQueuelj) GetRealSize() int {
	return 0
}

// GetMaxsize 获取最大队列长度
func (queue *ArrayQueuelj) GetMaxsize() int {
	return 0
}

// ReSize 队列扩容
func (queue *ArrayQueuelj) ReSize() {

}

// Search 查找函数
func (queue *ArrayQueuelj) Search(value int) bool {
	return false
}
