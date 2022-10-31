package ThreadPool

import "fmt"

// Pool go 协程池
type Pool struct {
	workerNum  int        //worker的数量，由客户指定
	EntryChan  chan *Task //提供给客户传任务的一个通道
	workerChan chan *Task //协程池内部传给worker的一个通道
}

func NewPool(num int) *Pool {
	return &Pool{
		workerNum:  num,
		EntryChan:  make(chan *Task),
		workerChan: make(chan *Task),
	}
}

func (p *Pool) worker() {
	for task := range p.workerChan {
		task.execute()
	}
}

func (p *Pool) ReceiveTask(task *Task) {
	p.EntryChan <- task
	fmt.Println("taskId:", task.taskId, "is Received")
}

func (p *Pool) Run() {
	for i := 0; i < p.workerNum; i++ {
		go p.worker()
	}

	for task := range p.EntryChan {
		p.workerChan <- task
	}
	close(p.EntryChan)
	close(p.workerChan)
}
