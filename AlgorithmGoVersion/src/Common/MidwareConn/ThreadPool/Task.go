package ThreadPool

import "fmt"

type Task struct {
	taskId int
	f      func(id int) error
}

// NewTask Task的构造函数
func NewTask(id int, f1 func(id int) error) *Task {
	return &Task{
		taskId: id,
		f:      f1,
	}
}

// 执行task
func (t *Task) execute() {
	fmt.Println("taskId:", t.taskId, "is execute")
	err := t.f(t.taskId)
	if err != nil {
		fmt.Println("err:", err)
		return
	}
}
