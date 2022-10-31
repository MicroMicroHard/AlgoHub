"""
 * @Class: CompleteSquare 
 * @author: micromicrohard
 * @date: 2022/5/2220:48
 * @author—Email: micromicrohard@outlook.com
 * @description:
 * @blogURL:
"""


class CompleteSquare:
    def __init__(self):
        pass

    def Method(self):
        n = 0
        while (n + 1) ** 2 - n * n <= 168:
            n += 1
        print(n + 1)

    def SquareMethod(self, n):
        print(n ** 2)  # math square grammar
        print(n * n)


instance = CompleteSquare()
instance.SquareMethod(4)
instance.SquareMethod(6)
instance.SquareMethod(7)
