package math

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/19 23:58
 * @author-Email micromicrohard@outlook.com
 * @description
 */

type PrimeNumChannel struct {
}

func (c *PrimeNumChannel) PrimeMethod(nums int) []int {

	ans := make([]int, 0)
	in := make(chan int)
	go c.produceNum(in)
	for i := 0; i < nums; i++ {
		num := <-in
		if num > nums { // 不加判断就是输出 nums 个素数，加了就是输出小于nums的素数
			break
		}
		ans = append(ans, num)
		out := make(chan int)
		go c.Filter(in, out, num)
		in = out
	}
	return ans
}

func (c *PrimeNumChannel) produceNum(in chan<- int) <-chan int {
	for i := 2; ; i++ {
		in <- i
	}
}

func (c *PrimeNumChannel) Filter(in <-chan int, out chan<- int, cur int) chan<- int {
	for {
		prime := <-in
		if prime%cur != 0 {
			out <- prime
		}
	}
}

func (c *PrimeNumChannel) InterfaceName() string {
	return "PrimeNum"
}
