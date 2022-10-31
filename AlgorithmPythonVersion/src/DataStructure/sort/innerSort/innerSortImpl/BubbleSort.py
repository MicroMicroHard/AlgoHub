from DataStructure.sort.innerSort.SortInterface import SortInterface

"""
 * @Class: BubbleSort
 * @author: micromicrohard
 * @date: 2022/5/1422:43
 * @author—Email: micromicrohard@outlook.com
 * @description: 冒泡排序
 * @blogURL:
"""


class BubbleSort(SortInterface):
    def SortMethod(self, array):
        for i in range(0, len(array) - 1):
            for j in range(0, len(array) - i - 1):
                if array[j] > array[j + 1]:
                    array[j], array[j + 1] = array[j + 1], array[j]
        return array
