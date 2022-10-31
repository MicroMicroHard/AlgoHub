package heapStackQueue

/**
 * @author 蔚蔚樱
 * @date 2021-11-23 22:01
 * @author—Email micromicrohard@outlook.com
 * @descriPtion 栈
 * 1、出栈
 * 2、入栈
 * 3、获取栈顶元素
 * 4、栈判空
 * 5、查找值
 * 6、获取栈中实际容量
 * 7、获取栈中最大容量
 * 8、扩容
 * @blogURL
 */

type Stacklj interface {
	Pop() int

	Push(value int) bool

	Peek() int

	Empty() bool

	Search(value int) bool

	GetRealSize() int

	GetMaxSize() int

	Resize()
}
