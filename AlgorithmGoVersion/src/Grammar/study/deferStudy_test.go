package study

import (
	"fmt"
	"testing"
	"time"
)

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/21 00:39
 * @author-Email micromicrohard@outlook.com
 * @description
 * 1、defer延迟执行的是与其直接接触的func，非直接接触的会被立马执行，所以根据这个性质，可以执行一些统计耗时的功能
 */
func TestDeferStudy(t *testing.T) {
	a := 1
	b := 2
	A(a, b)
	a += 1 // a=2
	fmt.Print("main1: a->", a, ",b->", b, ",c->", "\n")
	defer A(a, A(a, b))
	fmt.Print("main2: a->", a, ",b->", b, ",c->", "\n")
	b += 1 // b=3
	defer A(a, A(a, b))
	fmt.Print("main:3 a->", a, ",b->", b, ",c->", "\n")
	a = 9
	b = 10
}

func TestSimpleDeferStudy(t *testing.T) {
	a := 1
	b := 2
	fmt.Print("main1: a->", a, ",b->", b, ",c->", "\n")
	a += 1 // a=2
	defer A(a, A(a, b))
	fmt.Print("main2: a->", a, ",b->", b, ",c->", "\n")
	a = 9
	b = 10
}

func A(a, b int) int {
	c := a + b
	fmt.Print("a->", a, ",b->", b, ",c->", c, "\n")
	return c
}

//grammar defer延迟执行的是与其直接接触的func，非直接接触的会被立马执行，所以根据这个性质，可以执行一些统计耗时的功能
//注意两点：1：DeferFunc后面有两个()，2：DeferFunc的start := time.Now()是写在return前面的，构成两个不同的方法，
//原理见 TestSimpleDeferStudy
func TestDeferMethod(t *testing.T) {
	defer DeferFunc()()
	start1 := time.Now()
	time.Sleep(2 * time.Second)
	fmt.Println("TestDeferMethod end,cost ", time.Since(start1))
}

func DeferFunc() func() {
	start := time.Now()
	fmt.Println("虽然在DeferFunc里面，但是不是直接接触的，所以会被立马执行")
	return func() {
		fmt.Println("---------")
		tc := time.Since(start)
		fmt.Println("直接接触defer func，之后执行：exec DeferFunc,time record:", tc)
	}
}
