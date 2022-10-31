package AlternatePrint

import (
	"fmt"
	"sync"
	"testing"
)

// PrintBySequence
// @author: 蔚蔚樱
// @date: 2022/4/2322:27
// @author—Email: micromicrohard@outlook.com
// @description: 无论数组中的顺序如何，只按照1，2，3 顺序打印
// 三个不同的线程 A、B、C 将会共用一个 实例。
// 线程 A 将会调用 first() 方法
// 线程 B 将会调用 second() 方法
// 线程 C 将会调用 third() 方法
// 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
// @blogURL: https://leetcode-cn.com/problems/print-in-order/

func TestPrintBySequence(t *testing.T) {
	var seq PrintBySequence
	arr := []int{1, 2, 3}
	seq.Print(arr)
	fmt.Println("==========")
	arr = []int{2, 1, 3}
	seq.Print(arr)
	fmt.Println("==========")
	arr = []int{3, 2, 1}
	seq.Print(arr)
}

type PrintBySequence struct {
}

func (p *PrintBySequence) Print(arr []int) {
	var (
		ch1   = make(chan string)
		ch2   = make(chan string)
		group sync.WaitGroup
	)
	group.Add(len(arr))

	for _, v := range arr {
		switch v {
		case 1:
			go p.FirstPrint(ch1, ch2, &group)
		case 2:
			go p.SecondPrint(ch1, ch2, &group)
		case 3:
			go p.SecondThird(ch1, ch2, &group)
		}
	}
	group.Wait()
}

func (p *PrintBySequence) FirstPrint(ch1, ch2 chan string, group *sync.WaitGroup) {
	defer group.Done()
	fmt.Println("first")
	ch1 <- "key"
}

func (p *PrintBySequence) SecondPrint(ch1, ch2 chan string, group *sync.WaitGroup) {
	defer group.Done()
	str := <-ch1
	fmt.Println("second")
	ch2 <- str
}

func (p *PrintBySequence) SecondThird(ch1, ch2 chan string, group *sync.WaitGroup) {
	defer group.Done()
	<-ch2
	fmt.Println("third")
	//	ch1 <- str
}
