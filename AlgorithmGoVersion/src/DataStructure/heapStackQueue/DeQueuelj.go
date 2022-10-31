package heapStackQueue

type DeQueuelj interface {

	// OfferFront offer = Push, 队首入队
	OfferFront(value int) bool

	// OfferTail offer = Push, 队尾入队 == Offer

	// PeekFront 弹出第一个队首元素（不删除）== Peek

	// PeekTail 弹出第一个队尾元素（不删除）
	PeekTail() int

	// PollFront Poll = add, 队首出队 == Poll

	// PollTail Poll = add, 队尾出队
	PollTail() int
}
