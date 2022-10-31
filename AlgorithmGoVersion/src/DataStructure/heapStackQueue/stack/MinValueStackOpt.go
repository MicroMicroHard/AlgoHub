package stack

type MinValueStackOpt struct {
}

func (stack *MinValueStackOpt) Pop() int {
	return 0
}

func (stack *MinValueStackOpt) Push(value int) bool {
	return false
}

func (stack *MinValueStackOpt) Peek() int {
	return 0
}

func (stack *MinValueStackOpt) Empty() bool {
	return false
}

func (stack *MinValueStackOpt) Search(value int) bool {
	return false
}

func (stack *MinValueStackOpt) GetRealSize() int {
	return 0
}

func (stack *MinValueStackOpt) GetMaxSize() int {
	return 0
}

func (stack *MinValueStackOpt) Resize() {

}
