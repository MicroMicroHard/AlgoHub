package ThreadPool

import (
	"fmt"
	"testing"
	"time"
)

func RealTask(id int) error {
	fmt.Println(time.Now(), fmt.Sprintf("Doing %d", id)) // string grammar: 使用Sprintf拼接字符串
	return nil
}

func TestPool(t *testing.T) {
	p := NewPool(3)
	id := 0
	go func() {
		for i := 0; i < 5; i++ {
			p.ReceiveTask(NewTask(id, RealTask))
			id++
		}
	}()

	// dead lock grammar: 死锁和fmt的问题
	// 如果 p.Run() 不加上 go 另起一个协程，会发生死锁，具体见：https://blog.csdn.net/u011328417/article/details/89473323
	// 如果不加上 time.Sleep，就看不见打印，因为test协程 比 fmt所在的协程 提前结束，因此看不见打印
	// Sleep的时间少于1毫秒也看不见，因为写代码的时候，最好指定时间单位，比如：time.Second
	go p.Run()
	time.Sleep(3 * time.Second)
}
