package math

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/19 23:58
 * @author-Email micromicrohard@outlook.com
 * @description
 */

type PrimeNumINTF interface {
	PrimeMethod(nums int) []int
	InterfaceName() string
}

type PrimeNum struct {
}

func (c *PrimeNum) PrimeMethod(nums int) []int {
	primeList := make([]int, 0)
	if nums < 2 {
		return primeList
	}
	num := 2
	primeList = append(primeList, 2)
	isPrime := false
	for num <= nums {
		isPrime = false
		for _, prime := range primeList {
			isPrime = true
			if num%prime == 0 {
				isPrime = false
				break
			}
		}
		if isPrime {
			primeList = append(primeList, num)
		}
		num++
	}
	return primeList
}

func (c *PrimeNum) InterfaceName() string {
	return "PrimeNum"
}
