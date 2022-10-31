from DataStructure.sort.innerSort.SortInterface import SortInterface

"""
 * @Class: HeapSort
 * @author: micromicrohard
 * @date: 2022/5/1422:43
 * @author—Email: ljfirst@mail.ustc.edu.cn
 * @description: 堆排序
 * @blogURL:
"""


class HeapSort(SortInterface):
    def SortMethod(self, array):
        """ for grammar 倒序输出
        从10到0进行遍历循环，括号里最后一个-1是步长，实现倒序；前两个参数是起始和终止值，也是前闭后开。
        for i in range(10, -1, -1):
            print(i)
        """
        # 建堆
        for i in range(len(array) // 2, -1, -1):  # grammar python除法向下取整: r = x // y , python除法向上取整：r = math.ceil(x / y)
            self.heapify_big(array, i, len(array) - 1)
        # 整堆
        for i in range(len(array) - 1, -1, -1):
            array[i], array[0] = array[0], array[i]
            self.heapify_big(array, 0, i - 1)  # attention: i - 1 来表示可以到达的border
        return array

    # 小顶堆
    def heapify_small(self, array, root, border):
        if root > border | border < 0:
            return
        # 找出孩子节点中比当前root小的
        left = 2 * root + 1
        if left > border:
            return
        right = left + 1
        # 当且仅当 right没有越界，并且比left小
        if right < border:
            if array[right] < array[left]:
                left = right
        if array[left] < array[root]:
            array[left], array[root] = array[root], array[left]
            self.heapify_small(array, left, border)

    # 大顶堆
    def heapify_big(self, array, root, border):
        if root > border | border < 0:
            return
        # 找出孩子节点中比当前root小的
        left = 2 * root + 1
        if left > border:
            return
        # 当且仅当 right没有越界，并且比left小
        if left + 1 < border and array[left + 1] > array[left]:
            left = left + 1
        if array[left] > array[root]:
            array[left], array[root] = array[root], array[left]
            self.heapify_big(array, left, border)
