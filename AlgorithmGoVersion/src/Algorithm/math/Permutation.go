package math

import C "AlgorithmPractice/src/Common/Constant"

// Permutation
// @author: 蔚蔚樱
// @date: 2022/5/2219:50
// @author—Email: micromicrohard@outlook.com
// @description: 数学 排列数
// @blogURL:
type Permutation struct {
}

// PermutationMethod = C(m,n)
func (p *Permutation) PermutationMethod(m, n int) int {
	if m < n || n < 0 {
		return C.ErrorNum
	}
	return p.exec2(m, n)
}

func (p *Permutation) exec(m, n int) int {
	f := &Factorial{}
	m_Factorial := f.FactorialMethod(m)
	n_Factorial := f.FactorialMethod(m - n)
	return m_Factorial / n_Factorial
}

func (p *Permutation) exec2(m, n int) int {

	result := 1
	for i := m; i > m-n; i-- {
		result *= i
	}
	return result
}
