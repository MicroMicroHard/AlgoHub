# 排序专题

---

## <font color=#AfA2A3 size=6>简介</font>

内部排序及其应用

## <font color=#AfA2A3 size=6>目录</font>

---

#### Part One : 内部排序-数组：

+ 1.1、[冒泡排序](#BubbleSort)
+ 1.2、[堆排序](#HeapSort)
+ 1.3、[插入排序](#InsertSort)
+ 1.4、[选择排序](#SelectSort)
+ 1.5、[桶排序](#BucketSort)
+ 1.6、[计数排序](#CountSort)
+ 1.7、[归并排序](#MergeSort)
+ 1.8、[基数排序](#RadixSort)
+ 1.9、[希尔排序](#ShellSort)
+ 1.10、[快速排序](#QuickSort):单向快排、双向快排、插排改进快排
+ [更详尽版：归并、桶排、基数、计数、希尔排序的具体Java实现](https://blog.csdn.net/ljfirst/article/details/93710865)

#### Part Two : 内部排序-链表：

+ 2.1、[链表插入排序](#ListInsertSort)
+ 2.2、[链表归并排序](#ListMergeSort)

#### Part Three : 内部排序的应用：

+ 3.1、[解压字符串并且排序输出](#3.1)
+ 3.2、[超过半数的数](#3.2)
+ 3.3、k数
    + 3.3.1、[返回数组中最小的k个数](#3.3.1)
    + 3.3.2、[返回数组中最小的第k个数](#3.3.2)
    + 3.3.3、[链表的倒数第K个元素](#3.3.3)
+ 3.4、[统计字符串中首先出现三次的英文字符](#3.4)

## <font color=#AfA2A3 size=6>实现</font>

---

#### 冒泡排序

<p id="BubbleSort"></p>

+ 代码实现：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/innerSortImpl/BubbleSort.java)
  、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/innerSortImpl/BubbleSort.go)
+ 设计思路：
    + 什么是冒泡排序：
        + 1.每次比较相邻的两个元素
        + 2.每次从头比到尾，能确定一个元素的最终位置
        + 3.除了之前最终确定的元素不需要比对外，其他元素重复1和2步骤。
    + 冒泡排序的时间复杂度：
        + O($n^2$)。
        + (在一般情况下)第一次对比n-1次，第二次对比n-2次，...，第n-1次对比1次，共对比（1+n-1）*n-1=O($n^2$)。
    + 冒泡排序的稳定性：稳定。
+ 注意事项：内外层循环需要注意区分范围。

#### 堆排序

<p id="HeapSort"></p>

+ 代码实现：
    + 第一种堆排方式：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/innerSortImpl/HeapSort.java)
      、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/innerSortImpl/HeapSort.go)
    + 第二种堆排方式：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/innerSortImpl/HeapSort2.java)
      、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/innerSortImpl/HeapSort2.go)
+ 设计思路：
    + 什么是堆排序：
        + 初试化建堆，建完后，堆顶即最大/最小元素。
        + 交换堆顶和数组末尾元素，然后针对剩余的n-1个元素，对堆顶元素进行调整即可。
        + 重复2),直到所有元素有序。
    + 堆排序的时间复杂度：
        + 综合：O(n log 2<sup>n</sup>)。
        + 整堆的时间复杂度：O(n log 2<sup>n</sup>)。
        + 建堆的时间复杂度：O(n/2 * log 2<sup>n</sup>)。
    + 堆排序的稳定性：不稳定。
+ 注意事项：堆的边界不明确，会导致数组越界错误。

#### 插入排序

<p id="InsertSort"></p>

+ 代码实现：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/innerSortImpl/InsertSort.java)
  、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/innerSortImpl/InsertSort.go)
+ 设计思路：
    + 什么是插入排序：
        + 将待排序区划分为有序和无序区，初始时有序区只有一个数，即自身有序。
        + 从无序区选取数，按其关键码值的大小逐个插入到一个已经排好序的有序序列中，直到所有的纪录插入完为止。
    + 插入排序的时间复杂度：
        + O(n)。
        + (在一般情况下)第一个元素自身有序，第二个元素跟第一个对比，第三个元素跟前两个元素对比。。。共对比（0+1+2+。。。+（n-1））=O(n)。
    + 插入排序的稳定性：稳定。
+ 注意事项：插入点的选择

#### 选择排序

<p id="SelectSort"></p>

+ 代码实现：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/innerSortImpl/SelectSort.java)
  、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/innerSortImpl/SelectSort.go)
+ 设计思路：
    + 什么是选择排序：
        + 将待排序区划分为有序和无序区，有序区初始值为0。
        + 每次从待排序的数据元素序列中选出最小（或最大）的一个元素，
        + 存放在序列的起始位置，直到全部待排序的数据元素排完。
    + 选择排序的时间复杂度：
        + O($n^2$)。
        + (在一般情况下)每次选出一个最大或者最小，那么n个元素需要选择n-1次（外部排序趟数n-1），前 i 趟确定 i 个元素的最终位置（跟冒泡一样），每趟排序的对比次数为 n-i。
    + 选择排序的稳定性：
        + 选择排序是不稳定的排序方法。
        + （比如序列[5， 5， 3]第一次就将第一个[5]与[3]交换，导致第一个5挪动到第二个5后面）。

+ 注意事项：内外层循环的范围以及交换数值的储存方式。

#### 桶排序

<p id="BucketSort"></p>

+ 代码实现：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/innerSortImpl/BucketSort.java)
  、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/innerSortImpl/BucketSort.go)
+ 设计思路：
    + 什么是桶排序：
        + 首先一次遍历获取数组的最大值和最小值，从而得到桶的数量，并新建数据结构。
        + 再次遍历数组，先判断属于哪个桶，再判断桶内的链表位置。
        + 将桶内数据整理为数组并返回。
    + 桶排序的时间复杂度：
        + 第一次遍历获取桶数量： O(n)
        + 找插入点：O(m + n)
    + 桶排序的稳定性：桶排序是稳定的排序方法。

+ 注意事项：

#### 计数排序

<p id="CountSort"></p>

+ 代码实现：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/innerSortImpl/CountSort.java)
  、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/innerSortImpl/CountSort.go)
+ 设计思路：
    + 什么是计数排序：
        + 是一种牺牲空间换取时间的做法，
        + 首先找到数值区间，然后根据每个数对应的位置加一。
    + 计数排序的时间复杂度：O(n+k)
    + 计数排序的稳定性：稳定
+ 注意事项：

#### 归并排序

<p id="MergeSort"></p>

+ 代码实现：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/innerSortImpl/MergeSort.java)
  、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/innerSortImpl/MergeSort.go)
+ 设计思路：
    + 什么是归并排序：
        + 把两个数组合并为一个数组，
        + 合并的过程中，按照大小排序，那么新数组自然是有序的。
    + 归并排序的时间复杂度：
        + O(n log 2<sup>n</sup>)
        + 时间复杂度的推导过程：[归并排序时间复杂度推导](https://www.cnblogs.com/sheeva/p/6600666.html)
    + 归并排序的稳定性：

+ 注意事项：

#### 基数排序

<p id="RadixSort"></p>

+ 代码实现：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/innerSortImpl/RadixSort.java)
  、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/innerSortImpl/RadixSort.go)
+ 设计思路：
    + 什么是基数排序：
    + 基数排序的时间复杂度：
    + 基数排序的稳定性：

+ 注意事项：

#### 希尔排序

<p id="ShellSort"></p>

+ 代码实现：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/innerSortImpl/ShellSort.java)
  、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/innerSortImpl/ShellSort.go)
+ 设计思路：
    + 什么是希尔排序：
        + 将原本的一个数组，分成若干个数组，独自排序
        + 第一次分成n个数组，第二次分成n/2个数组，第三次分成n/4个....
        + 每次排序才有插入排序来调整序列
    + 希尔排序的时间复杂度：
    + 希尔排序的稳定性：
        + 不稳定，因为分队排序的时候，可能会导致排序的先后顺序改变

+ 注意事项：
    + gap的大小设置，
    + 注意到代码中含有四次嵌套的循环，每次的起止需要注意
    + 注意一下越界问题
    + 插入排序的写法需要注意

#### 快排及其改进

<p id="QuickSort"></p>

+ 代码实现：
    + 单项快排：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/innerSortImpl/QuickSort_Simplex.java)
      、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/innerSortImpl/QuickSort_Simplex.go)
    + 双项快排：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/innerSortImpl/QuickSort_Duplex.java)
      、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/innerSortImpl/QuickSort_Duplex.go)
    + 插改快排：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/innerSortImpl/QuickSort_InsertOpt.java)
      、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/innerSortImpl/QuickSort_InsertOpt.go)
+ 这篇文章针对快排的单项、双向、改进分别做了详细解释，请移步：[快排及其优化](https://blog.csdn.net/ljfirst/article/details/94576528)

#### 链表插入排序

<p id="ListInsertSort"></p>

+ 代码实现：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/listSort/ListInsertSort.java)
  、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/listSort/ListInsertSort.go)
+ 设计思路：
+ 注意事项：

#### 链表归并排序

<p id="ListMergeSort"></p>

+ 代码实现：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/listSort/ListMergeSort.java)
  、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/listSort/ListInsertSort.go)
+ 设计思路：
+ 注意事项：

#### 解压字符串并且排序输出

<p id="3.1"></p>

+ 问题描述：将一段压缩后的字符串解压缩，并且排序输出。
+ 代码实现：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/innerSortApply/Decompress.java)
  、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/innerSortApply/Decompress.go)
+ 设计思路：
    + 解题步骤
    + 代码展示
+ 注意事项：

#### 找出超过半数的那个数字

<p id="3.2"></p>

+ 问题描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
+ 代码实现：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/innerSortApply/HalfPastNum.java)
  、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/innerSortApply/HalfPastNum.go)
+ 设计思路：
    + 解题步骤
    + 代码展示
+ 注意事项：

#### 返回数组中最小的k个数

<p id="3.3.1"></p>

+ 代码实现：[java](../AlgorithmJavaVersion/src/DataStructure/heapStackQueue/heap/ReturnKMin.java)
  、[go](../AlgorithmGoVersion/src/DataStructure/heapStackQueue/heap/ReturnKMin.go)
+ 设计思路：
    + 解题步骤
    + 代码展示

+ 注意事项：

#### 返回数组中最小的第k个数

<p id="3.3.2"></p>

+ 代码实现：[java](../AlgorithmJavaVersion/src/DataStructure/heapStackQueue/heap/ReturnKthMin.java)
  、[go](../AlgorithmGoVersion/src/DataStructure/heapStackQueue/heap/ReturnKthMin.go)
+ 设计思路：
    + 解题步骤
    + 代码展示
+ 注意事项：

#### 链表的倒数第K个元素

<p id="3.3.3"></p>

+ 说明：
  + 查找链表的倒数第K个元素
  + 删除链表的倒数第K个元素
+ 代码实现：[java](../AlgorithmJavaVersion/src/DataStructure/list/listRealize/TheLastKImpl.java)
  、[go](../AlgorithmGoVersion/src/DataStructure/list/listRealize/TheLastKImpl.go)
+ 设计思路：
    + 解题步骤
    + 代码展示
+ 注意事项：

#### 统计字符串中首先出现三次的英文字符

<p id="3.4"></p>

+ 问题描述：给定一个英文字符串,请写一段代码找出这个字符串中首先出现三次的那个英文字符(需要区分大小写)。
+ 代码实现：[java](../AlgorithmJavaVersion/src/DataStructure/sort/innerSort/innerSortApply/StatisticFirstThreeChar.java)
  、[go](../AlgorithmGoVersion/src/DataStructure/sort/innerSort/innerSortApply/StatisticFirstThreeChar.go)
+ 设计思路：
    + 解题步骤
    + 代码展示
+ 注意事项：

### <font color=#AfA2A3 size=6>总结</font>

<p id="summary"></p>

---

+ 常见角度考虑：
    +
+ 常见解法总结：
    +