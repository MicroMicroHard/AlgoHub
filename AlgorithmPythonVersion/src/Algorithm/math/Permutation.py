from Algorithm.math.Factorial import Factorial
from Utils.Constant.C import ErrorNum

"""
 * @Class: Permutation 
 * @author: micromicrohard
 * @date: 2022/5/2220:23
 * @author—Email: ljfirst@mail.ustc.edu.cn
 * @description: 数学 排列数
 * @blogURL:
"""


class Permutation(Factorial):
    def __init__(self):
        pass

    def PermutationMethod(self, m, n):
        if m < n or n < 0:
            return ErrorNum
        m_Factorial = Factorial.FactorialMethod(self, m)  # 继承 grammar : 使用父类中的方法
        m_n_Factorial = Factorial.FactorialMethod(self, m - n)  # 继承 grammar : 使用父类中的方法
        # m = super.FactorialMethod(m)
        return m_Factorial / m_n_Factorial


instance = Permutation()
value = instance.PermutationMethod(5, 2)
print(value)
