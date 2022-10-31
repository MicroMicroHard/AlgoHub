package AlternatePrint

import (
	"fmt"
	"testing"
	"time"
)

// PrintAlternate
// @author: 蔚蔚樱
// @date: 2022/4/2322:34
// @author—Email: micromicrohard@outlook.com
// @description: AlternatePrint
// 两个不同的线程将会共用一个 FooBar 实例：
// 线程 A 将会调用 foo() 方法，而 线程 B 将会调用 bar() 方法, 请设计修改程序，以确保 "foobar" 被输出 n 次。
// 示例 1：
// 输入：n = 1 输出："foobar" 解释：这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
// 示例 2：
// 输入：n = 2 输出："foobarfoobar" 解释："foobar" 将被输出两次。
// @blogURL: https://leetcode-cn.com/problems/print-foobar-alternately/

func TestPrintAlternate_Print(t *testing.T) {
	p := PrintAlternate{}
	go p.Print(3)
	time.Sleep(2 * time.Second)
}

type PrintAlternate struct {
}

var (
	fooMsg = make(chan string, 1)
	barMsg = make(chan string, 1)
)

func (p *PrintAlternate) Print(n int) {
	wg.Add(2 * n)
	barMsg <- "start"
	for i := 0; i < n; i++ {
		go p.foo()
		go p.bar()
	}
	wg.Wait()
}

func (p *PrintAlternate) foo() {
	defer wg.Done()
	key := <-barMsg
	fmt.Print("foo")
	fooMsg <- key
}

func (p *PrintAlternate) bar() {
	defer wg.Done()
	key := <-fooMsg
	fmt.Println("bar")
	barMsg <- key
}
