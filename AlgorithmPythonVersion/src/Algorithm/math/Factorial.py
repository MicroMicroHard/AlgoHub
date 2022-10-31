from Utils.Constant.C import ErrorNum

"""
 * @Class: Factorial 
 * @author: liujun
 * @date: 2022/5/2220:07
 * @author—Email: ljfirst@mail.ustc.edu.cn
 * @description: 阶乘
 * @blogURL:
"""


class Factorial:
    def __init__(self):
        pass

    def FactorialMethod(self, value):
        if value < 0:
            return ErrorNum
        if value == 0:
            return 1
        i = 1
        result = 1
        while i <= value:  # while grammar,注意 循环变量 i 需要在外层写
            result *= i
            i += 1
        return result


instance = Factorial()
value = instance.FactorialMethod(5)
print(value)
