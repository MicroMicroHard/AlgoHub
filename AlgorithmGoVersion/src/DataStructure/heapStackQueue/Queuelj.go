package heapStackQueue

/**
 * @author 蔚蔚樱
 * @date 2021-11-23 22:01
 * @author-Email micromicrohard@outlook.com
 * @description 队列的基本方法
 * 1、元素入队
 * 2、元素出队
 * 3、弹出队首元素（不删除）
 * 4、队列判空
 * 5、查找值
 * 6、获取真实队列长度
 * 7、获取最大队列长度
 * 8、队列扩容
 * @blogURL
 */

type Queuelj interface {

	// Offer = push，入队
	Offer(value int) bool

	// Poll 出队
	Poll() int

	// Peek 弹出第一个队首元素（不删除）
	Peek() int

	// Empty 队列判空
	Empty() bool

	// GetRealSize 获取真实队列长度
	GetRealSize() int

	// GetMaxsize 获取最大队列长度
	GetMaxsize() int

	// ReSize 队列扩容
	ReSize()

	// Search 查找函数
	Search(value int) bool
}
