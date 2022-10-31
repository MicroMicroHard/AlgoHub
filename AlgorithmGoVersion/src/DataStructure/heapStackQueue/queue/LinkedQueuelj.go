package queue

type LinkedQueuelj struct {
	
}

//offer = push，入队
func (queue *LinkedQueuelj) Offer(value int) bool {
	return false
}

//出队
func (queue *LinkedQueuelj) Poll() int {
	return 0
}

//弹出第一个队首元素（不删除）
func (queue *LinkedQueuelj) Peek() int {
	return 0
}

//队列判空
func (queue *LinkedQueuelj) Empty() bool {
	return false
}

//获取真实队列长度
func (queue *LinkedQueuelj) GetRealSize() int {
	return 0
}

//获取最大队列长度
func (queue *LinkedQueuelj) GetMaxsize() int {
	return 0
}

//队列扩容
func (queue *LinkedQueuelj) ReSize() {

}

//查找函数
func (queue *LinkedQueuelj) Search(value int) bool {
	return false
}
