# 二叉树专题

---

## <font color=#AfA2A3 size=6>简介</font>

+ 说明：本文通过列举二叉树的序列化和反序列化过程中的可能出现的问题， 使用堆栈队列数组链表等基本数据结构来强化对先序、中序、后序的认识。
+ [总结](#summary)

## <font color=#AfA2A3 size=6>目录</font>

---

+ 1、**二叉树序列化**
    + 1.1、将一颗二叉树按照先序遍历的方式输出(递归、非递归)
      [java](../AlgorithmJavaVersion/src/DataStructure/tree/binaryTree/binaryTree2Array/BT2ArrayByPreOrder.java)、
      [go](../AlgorithmGoVersion/src/DataStructure/tree/binaryTree/binaryTree2Array/BT2ArrayByPreOrder.go)
    + 1.2、将一颗二叉树按照中序遍历的方式输出(递归、非递归)
      [java](../AlgorithmJavaVersion/src/DataStructure/tree/binaryTree/binaryTree2Array/BT2ArrayByInOrder.java)、
      [go](../AlgorithmGoVersion/src/DataStructure/tree/binaryTree/binaryTree2Array/BT2ArrayByInOrder.go)
    + 1.3、将一颗二叉树按照后序遍历的方式输出(递归、非递归)
      [java](../AlgorithmJavaVersion/src/DataStructure/tree/binaryTree/binaryTree2Array/BT2ArrayByPostOrder.java)、
      [go](../AlgorithmGoVersion/src/DataStructure/tree/binaryTree/binaryTree2Array/BT2ArrayByPostOrder.go)
    + 1.4、将一颗二叉树按层遍历的方式输出
      [java](../AlgorithmJavaVersion/src/DataStructure/tree/binaryTree/binaryTree2Array/BT2ArrayByLevel.java)、
      [go](../AlgorithmGoVersion/src/DataStructure/tree/binaryTree/binaryTree2Array/BT2ArrayByLevel.go)
    + 1.5、打印一颗二叉树的左视图
      [java](../AlgorithmJavaVersion/src/DataStructure/tree/binaryTree/binaryTree2Array/BT2ArrayByLeftView.java)、
      [go](../AlgorithmGoVersion/src/DataStructure/tree/binaryTree/binaryTree2Array/BT2ArrayByLeftView.go)
    + 1.6、将一颗二叉树按照S形遍历的方式输出
      [java](../AlgorithmJavaVersion/src/DataStructure/tree/binaryTree/binaryTree2Array/BT2ArrayBySLevel.java)、
      [go](../AlgorithmGoVersion/src/DataStructure/tree/binaryTree/binaryTree2Array/BT2ArrayBySLevel.go)
+ 2、**二叉树反序列化**
    + 2.1、根据先序排列的数组(带空叶子符号)，构造二叉树
      [java](../AlgorithmJavaVersion/src/DataStructure/tree/binaryTree/array2BinaryTree/Array2BTByPreOrder.java)、
      [go](../AlgorithmGoVersion/src/DataStructure/tree/binaryTree/array2BinaryTree/Array2BTByPreOrder.go)
    + 2.2、根据中序排列的数组(带空叶子符号)，构造二叉树
      [java](../AlgorithmJavaVersion/src/DataStructure/tree/binaryTree/array2BinaryTree/Array2BTByInOrder.java)、
      [go](../AlgorithmGoVersion/src/DataStructure/tree/binaryTree/array2BinaryTree/Array2BTByInOrder.go)
    + 2.3、根据后序排列的数组(带空叶子符号)，构造二叉树
      [java](../AlgorithmJavaVersion/src/DataStructure/tree/binaryTree/array2BinaryTree/Array2BTByPostOrder.java)、
      [go](../AlgorithmGoVersion/src/DataStructure/tree/binaryTree/array2BinaryTree/Array2BTByPostOrder.go)
    + 2.4、根据先序和中序排列的数组，构造二叉树
      [java](../AlgorithmJavaVersion/src/DataStructure/tree/binaryTree/array2BinaryTree/Array2BTByPre_InOrder.java)、
      [go](../AlgorithmGoVersion/src/DataStructure/tree/binaryTree/array2BinaryTree/Array2BTByPre_InOrder.go)
    + 2.5、根据后序和中序排列的数组，构造二叉树
      [java](../AlgorithmJavaVersion/src/DataStructure/tree/binaryTree/array2BinaryTree/Array2BTByPost_InOrder.java)、
      [go](../AlgorithmGoVersion/src/DataStructure/tree/binaryTree/array2BinaryTree/Array2BTByPost_InOrder.go)
    + 2.6、根据按层排列的数组(带空叶子符号)，构造二叉树
      [java](../AlgorithmJavaVersion/src/DataStructure/tree/binaryTree/array2BinaryTree/Array2BTByLevel.java)、
      [go](../AlgorithmGoVersion/src/DataStructure/tree/binaryTree/array2BinaryTree/Array2BTByLevel.go)
    + 2.7、根据完全二叉树排列的数组(带空叶子符号)，构造二叉树
      [java](../AlgorithmJavaVersion/src/DataStructure/tree/binaryTree/array2BinaryTree/Array2BtByFullTree.java)、
      [go](../AlgorithmGoVersion/src/DataStructure/tree/binaryTree/array2BinaryTree/Array2BtByFullTree.go)
+ 3、**二叉树转链表**
    + 全部转左孩子 [java]()、[go]()
    + 全部转右孩子 [java]()、[go]()

## <font color=#AfA2A3 size=6>思路</font>

---

+ 将一颗二叉树按照
    + 先序遍历的方式输出
    + 中序遍历的方式输出
    + 后序遍历的方式输出
    + 层遍历的方式输出
    + 左视图的方式输出:当队尾标识到达最右边的时候，队首元素就是左视图看到的元素
    + S形遍历的方式输出
+ 构造二叉树
    + 根据先序排列的数组(带空叶子符号)
    + 根据中序排列的数组(带空叶子符号)
    + 根据后序排列的数组(带空叶子符号)
    + 根据先序和中序排列的数组
    + 根据后序和中序排列的数组
    + 根据按层排列的数组(带空叶子符号)
    + 根据完全二叉树排列的数组(带空叶子符号)
+ 二叉树转链表
    + 全部转左孩子
    + 全部转右孩子

### <font color=#AfA2A3 size=6>总结</font>

<p id="summary"></p>

---

+ 常见角度考虑：
    + 先序、中序、后序的输出
+ 常见解法总结：
    + 利用递归或者栈来构建先进后出的序列
    + 利用队列来构建层次关系






