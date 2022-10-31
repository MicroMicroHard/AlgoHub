"""
 * @Class: share 
 * @author: micromicrohard
 * @date: 2022/6/1223:43
 * @author—Email: micromicrohard@outlook.com
 * @description:
 * @blogURL: https://mp.weixin.qq.com/s?__biz=MzIzNTg3MDQyMQ==&mid=2247505669&idx=2&sn=dfe28684768f3b03dba67acf5bbb52d8&chksm=e8e216bfdf959fa9e6c6942f28b7ef8712fcadea5de914eeb19015f3bc2564d28727094ea28c&mpshare=1&scene=1&srcid=0612E14DaokvIBgB1EDKOSCJ&sharer_sharetime=1655041010794&sharer_shareid=ef6cd311552070a69165575310840121&exportkey=AaZptgvwdtuI4Wjr5833X8o%3D&acctmode=0&pass_ticket=JMZJSyHhnpYlporMBQP%2FvfHRfMyi8xXYkCq75uxAGCYrLKXMFgUga9Tejh9apkBD&wx_header=0#rd
"""
import numpy as np


class share:
    def __init__(self):
        pass

    def Method(self):
        pass


instance = share()
instance.Method()
#
# a = np.arange(0, 60, 5)
# a = a.reshape(3, 4)
# print(a)
#
# for x in np.nditer(a):
#     print(x)

# a = np.arange(0, 60, 5)
# a = a.reshape(3, 4)
# print(a)
# b = np.array([1, 2, 3, 4], dtype=int)
# print(b)
#
# for x, y in np.nditer([a, b]):
#     print(x, y)


# a = np.arange(0, 8, 2)
# print(a)
# b = a.reshape(4, 1)
# print(b)


# a = np.arange(0, 16, 2).reshape(2, 4)
# print(a)
# # 返回展开数组中的下标的对应元素
# print(list(a.flat))


# ndarray.flatten(order)其中：order：‘C’ — 按行，‘F’ — 按列，‘A’ — 原顺序，‘k’ —元素在内存中的出现顺序。
# a = np.arange(8).reshape(2, 4)
# print(a)
# # default is column-major
# print(a.flatten())
# print(a.flatten(order='F'))


# a = np.arange(24).reshape(2, 3, 4)
# print(a)
# print(a.shape)
# b = np.array(np.transpose(a))
# print(b)
# print(b.shape)


a = np.arange(12).reshape(3, 4)
print(a)
print(a.T)
