package golangGrammar

import (
	"fmt"
	"testing"
	"time"
)

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/11 18:43
 * @author-Email micromicrohard@outlook.com
 * @description
 */
type display struct {
}


func TestInsertTestDat1a(t *testing.T) {
	go spinner(100 * time.Millisecond)
	const n = 45
	fibN := fib(n) // slow
	fmt.Printf("\rFibonacci(%d) = %d\n", n, fibN)
}

func spinner(delay time.Duration) {
	for {
		for _, r := range `-\|/` { // special grammar：光标闪现， 以及 \r 的用法
			fmt.Printf("\r%c", r)
			time.Sleep(delay)
		}
	}
}

func fib(x int) int {
	if x < 2 {
		return x
	}
	return fib(x-1) + fib(x-2)
}