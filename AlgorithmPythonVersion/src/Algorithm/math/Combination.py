from Algorithm.math.Factorial import Factorial
from Utils.Constant.C import ErrorNum

"""
 * @Class: Combination 
 * @author: micromicrohard
 * @date: 2022/5/2220:42
 * @author—Email: micromicrohard@outlook.com
 * @description: 数学组合数
 * @blogURL:
"""


class Combination(Factorial):
    def __init__(self):
        pass

    def Method(self, m, n):
        if m < n or n < 0:
            return ErrorNum
        m_Factorial = Factorial.FactorialMethod(self, m)
        n_Factorial = Factorial.FactorialMethod(self, n)
        m_n_Factorial = Factorial.FactorialMethod(self, m - n)
        return m_Factorial / (m_n_Factorial * n_Factorial)


instance = Combination()
value = instance.Method(5, 2)
print(value)
