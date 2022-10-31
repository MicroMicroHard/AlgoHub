package queue

type PriorityQueuelj struct {
}

//offer = push，入队
func (queue *PriorityQueuelj) Offer(value int) bool {
	return false
}

//出队
func (queue *PriorityQueuelj) Poll() int {
	return 0
}

//弹出第一个队首元素（不删除）
func (queue *PriorityQueuelj) Peek() int {
	return 0
}

//队列判空
func (queue *PriorityQueuelj) Empty() bool {
	return false
}

//获取真实队列长度
func (queue *PriorityQueuelj) GetRealSize() int {
	return 0
}

//获取最大队列长度
func (queue *PriorityQueuelj) GetMaxsize() int {
	return 0
}

//队列扩容
func (queue *PriorityQueuelj) ReSize() {

}

//查找函数
func (queue *PriorityQueuelj) Search(value int) bool {
	return false
}
