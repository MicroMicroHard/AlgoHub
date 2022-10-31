package AlternatePrint

import (
	"fmt"
	"sync"
	"testing"
	"time"
)

// PrintAlternate2
// @author: 蔚蔚樱
// @date: 2022/4/2322:53
// @author—Email: micromicrohard@outlook.com
// @description: 交替打印
// 三协程交替输出序列 "010203040506..."
// 现有函数 printNumber 可以用一个整数参数调用，并输出该整数到控制台。
// 例如，调用 printNumber(7) 将会输出 7 到控制台。
// 给你类 ZeroEvenOdd 的一个实例，该类中有三个函数：zero、even 和 odd 。ZeroEvenOdd 的相同实例将会传递给三个不同线程：
//
// 线程 A：调用 zero() ，只输出 0 ，线程 B：调用 even() ，只输出偶数，线程 C：调用 odd() ，只输出奇数
// 修改给出的类，以输出序列 "010203040506..." ，其中序列的长度必须为 2n 。
// @blogURL: https://leetcode-cn.com/problems/print-zero-even-odd/

func TestPrintAlternate2(t *testing.T) {
	p := PrintAlternate2{}
	go p.Print(7)
	time.Sleep(2 * time.Second)
}

type PrintAlternate2 struct {
}

var (
	zeroMsg = make(chan int, 0)
	oddMsg  = make(chan int, 0)
	evenMsg = make(chan int, 0)
	wg      = &sync.WaitGroup{}
	n       int
)

func (p *PrintAlternate2) Print(num int) {
	n = num
	wg.Add(num)

	go p.PrintZero()
	go p.PrintOdd()
	go p.PrintEven()
	zeroMsg <- 0

	wg.Wait()
}

func (p *PrintAlternate2) PrintZero() {
	defer wg.Done()
	for {
		key := <-zeroMsg
		if key > n {
			fmt.Println("end when comes to zero")
			return
		}
		fmt.Print(fmt.Sprintf("0%d", key))
		oddMsg <- key + 1
	}
}

// PrintEven 输出偶数
func (p *PrintAlternate2) PrintEven() {
	defer wg.Done()
	for {
		key := <-evenMsg
		if key > n {
			fmt.Println("end when comes to even")
			return
		}
		fmt.Print(fmt.Sprintf("0%d", key))
		oddMsg <- key + 1
	}
}

func (p *PrintAlternate2) PrintOdd() {
	defer wg.Done()
	for {
		key := <-oddMsg
		if key > n {
			fmt.Println("end when comes to odd")
			return
		}
		fmt.Print(fmt.Sprintf("0%d", key))
		evenMsg <- key + 1
	}
}
