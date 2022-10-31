package queue

type StackQueuelj struct {
}

//offer = push，入队
func (queue *StackQueuelj) Offer(value int) bool {
	return false
}

//出队
func (queue *StackQueuelj) Poll() int {
	return 0
}

//弹出第一个队首元素（不删除）
func (queue *StackQueuelj) Peek() int {
	return 0
}

//队列判空
func (queue *StackQueuelj) Empty() bool {
	return false
}

//获取真实队列长度
func (queue *StackQueuelj) GetRealSize() int {
	return 0
}

//获取最大队列长度
func (queue *StackQueuelj) GetMaxsize() int {
	return 0
}

//队列扩容
func (queue *StackQueuelj) ReSize() {

}

//查找函数
func (queue *StackQueuelj) Search(value int) bool {
	return false
}
