package math

import C "AlgorithmPractice/src/Common/Constant"

// Combination
// @author: 蔚蔚樱
// @date: 2022/5/2220:03
// @author—Email: micromicrohard@outlook.com
// @description: 数学组合数
// @blogURL:
type Combination struct {
}

func (p *Combination) CombinationMethod(m, n int) int {

	if m < n || n < 0 {
		return C.ErrorNum
	}
	f := &Factorial{}
	m_Factorial := f.FactorialMethod(m)
	m_n_Factorial := f.FactorialMethod(m - n)
	n_Factorial := f.FactorialMethod(n)
	return m_Factorial / (n_Factorial * m_n_Factorial)
}
