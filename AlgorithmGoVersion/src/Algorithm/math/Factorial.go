package math

import C "AlgorithmPractice/src/Common/Constant"

// Factorial
// @author: 蔚蔚樱
// @date: 2022/5/2219:11
// @author—Email: micromicrohard@outlook.com
// @description: 阶乘
// @blogURL:
type Factorial struct {
}

func (p *Factorial) FactorialMethod(n int) int {

	if n < 0 {
		return C.ErrorNum
	}
	if n == 0 {
		return 1
	}
	var result int = 1
	for i := 1; i <= n; i++ {
		result *= i
	}
	return result
}
