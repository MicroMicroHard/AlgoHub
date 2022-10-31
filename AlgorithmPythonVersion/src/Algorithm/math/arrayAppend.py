"""
 * @Class: arrayAppend 
 * @author: liujun
 * @date: 2022/5/2221:19
 * @author—Email: ljfirst@mail.ustc.edu.cn
 * @description:
 * @blogURL:
"""


class arrayAppend:
    arr = []

    def __init__(self):
        pass

    def Method(self):
        i = 0
        while i < 6:
            self.arr.append(i)  # array grammar 的append的用法
            i += 1
        print(self.arr)


instance = arrayAppend()
instance.Method()
