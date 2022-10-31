package print_study

import (
	"fmt"
	"time"
)

// yg
// @author: 蔚蔚樱
// @date: 2022/7/2613:05
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:

func ma1in() {

	go spinner(100 * time.Millisecond)
	const n = 45
	fibN := fib(n) // slow
	fmt.Printf("\rFibonacci(%d) = %d", n, fibN)
}
func spinner(delay time.Duration) {
	for {
		for _, r := range `-\|/` {
			fmt.Printf("%c", r)
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
