package ThreadPool

import (
	"fmt"
	"math"
	"runtime"
	"sync"
)

type TaskStruct struct {
	Fun          func() error
	TheWaitGroup *sync.WaitGroup
}

// Synergetic Process Pool
type SPP struct {
	Capacity int
	TaskChan chan TaskStruct
	sync.Mutex
}

func NewSPP(capacity int) *SPP {

	taskChannel := make(chan TaskStruct)

	p := &SPP{
		Capacity: capacity,
		TaskChan: taskChannel,
	}

	for ii := 0; ii < capacity; ii++ { // 一开始就创建 协程 等待任务
		p.run()
	}

	return p
}

/*
	1. 直接关闭 channel 退出所有的 run 函数
*/
func (p *SPP) Close() {
	close(p.TaskChan)
}

func (p *SPP) run() {

	var (
		task TaskStruct
		ok   bool
	)

	go func() {
		defer func() {
			if r := recover(); r != nil {
				// for-select可以封装，这里再次触发进去. var forSelect := func() {for {select: ...}}
				fmt.Print("error:", r)
				trace := make([]byte, 1<<16)
				n := runtime.Stack(trace, false)
				s := fmt.Sprintf("panic: '%v'\n, Stack Trace:\n %s", r, string(trace[:int(math.Min(float64(n), float64(7000)))]))
				// 输出详细的桟信息
				fmt.Println(s)
				task.TheWaitGroup.Done()
			}
			go p.run()
		}()

		for {
			select {
			case task, ok = <-p.TaskChan:
				if !ok {
					return
				}
				taskErr := task.Fun()
				if taskErr != nil {
					fmt.Println("taskErr:", taskErr)
				}
				task.TheWaitGroup.Done()
			}
		}
	}()
}

func (p *SPP) Put(task TaskStruct) error {
	if task.TheWaitGroup != nil {
		task.TheWaitGroup.Add(1)
	}
	p.TaskChan <- task
	return nil
}
