package golangGrammar

import (
	"fmt"
	"runtime"
	"sync"
	"testing"
)

// grammar
// @author: 蔚蔚樱
// @date: 2022/5/2522:28
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:

type query func(string) string

func exec(name string, vs ...query) string {
	ch := make(chan string)
	fn := func(i int) {
		ch <- vs[i](name)
		/*
			ch <- func(n string) string {
				return "4567890"
			}(name)
		*/

	}
	for i, _ := range vs {
		go fn(i)
	}
	return <-ch
}

func TestM1ain(m *testing.T) {
	for i := 0; i < 10; i++ {
		ret := exec("111", func(n string) string {
			return n + "func1"
		}, func(n string) string {
			return n + "func2"
		}, func(n string) string {
			return n + "func3"
		}, func(n string) string {
			return n + "func4"
		})
		fmt.Println(ret)
	}
}

func defer_call() {
	defer func() { fmt.Println("打印前") }()
	defer func() { fmt.Println("打印中") }()
	defer func() { fmt.Println("打印后") }()
	//panic("触发异常")
}

type student struct {
	Name string
	Age  int
}

func TestPpase_student(y *testing.T) {
	m := make(map[string]*student)
	stus := []student{
		{Name: "zhou", Age: 24},
		{Name: "li", Age: 23},
		{Name: "wang", Age: 22},
	}
	for _, v := range stus {
		/*vv := v
		m[v.Name] = &vv*/
		m[v.Name] = &v // grammar 注意这种写法是错误的
	}

	for _, v := range m {
		fmt.Println(v)
	}
}

func TestYYY(t *testing.T) {

	runtime.GOMAXPROCS(1)
	wg := sync.WaitGroup{}
	wg.Add(20)
	for i := 0; i < 10; i++ {
		go func() {
			fmt.Println(",,,,i: ", i)
			wg.Done()
		}()
	}
	for i := 0; i < 10; i++ {
		go func(i int) {
			fmt.Println("i: ", i)
			wg.Done()
		}(i)
	}
	wg.Wait()
}

func TestY1YY(t *testing.T) {
	var y *int64
	*y = 1
	switch *y {
	case 1:
		fmt.Println("----")
	case 2:
		fmt.Println("1111")
	default:
		fmt.Println("33333")
	}
}
