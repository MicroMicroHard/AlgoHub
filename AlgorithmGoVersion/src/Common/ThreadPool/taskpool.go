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

type Pool struct {
	Capacity int
	TaskChan chan TaskStruct
	sync.Mutex
}

func NewPool(capacity int) *Pool {

	taskChannel := make(chan TaskStruct)

	p := &Pool{
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
func (p *Pool) Close() {
	close(p.TaskChan)
}

func (p *Pool) run() {

	var (
		task TaskStruct
		ok   bool
	)

	go func() {
		defer func() {
			if r := recover(); r != nil {
				// for-select可以封装，这里再次触发进去. var forSelect := func() {for {select: ...}}
				//logkit.With(logkit.Any("error", r)).Error("pool one go routine panic")
				fmt.Println("pool one go routine panic")

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
					fmt.Println("task pool error")
					//logkit.With(zap.Error(taskErr)).Warn("task pool error")
				}
				task.TheWaitGroup.Done()
			}
		}
	}()
}

func (p *Pool) Put(task TaskStruct) error {

	if task.TheWaitGroup != nil {
		task.TheWaitGroup.Add(1)
	}

	p.TaskChan <- task
	return nil
}
