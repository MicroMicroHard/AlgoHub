import itertools

"""
 * @Class: TaxCalculation
 * @author: micromicrohard
 * @date: 2022/5/1422:43
 * @author—Email: ljfirst@mail.ustc.edu.cn
 * @description: 排列组合 C43
 题目 有四个数字：1、2、3、4，能组成多少个互不相同且无重复数字的三位数？各是多少？
 程序分析 遍历全部可能，把有重复的剃掉。
 * @blogURL:
"""


class NoReapteNum:
    def __init__(self):
        pass

    def cal(self):
        total = 0
        for i in range(1, 5):
            for j in range(1, 5):
                for k in range(1, 5):
                    if i != j and j != k and i != k:
                        print(i, j, k)
                        total += 1
        print(total)

    def cal2(self):
        sum2 = 0
        a = [1, 2, 3, 4]
        # array grammar itertools.permutations: https://vimsky.com/examples/usage/python-itertools-permutations.html
        for i in itertools.permutations(a, 3):
            print(i)
            sum2 += 1
        print(sum2)


df = NoReapteNum()
df.cal2()
