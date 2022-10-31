import unittest

from src.DataStructure.sort.innerSort.innerSortImpl.HeapSort import HeapSort


class HeapSortTest(unittest.TestCase):
    def testSortMethod(self):
        self.assertEqual(HeapSort().SortMethod(arr), target)  # add assertion here


arr = [1, 2, 3, 4, 5, 6, 9, 8, 7, 6, 5, 4, 3]  # format grammar 如果arr是 ()类型，会出错，因为()类型是只读的，只有list[]类型才可以交换顺序
target = [1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9]
