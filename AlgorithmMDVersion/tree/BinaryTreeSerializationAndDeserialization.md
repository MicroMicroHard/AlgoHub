# 二叉树序列化和反序列化

---
## <font color=#Af9233 size=4>简介</font>
+ 说明： 二叉树的序列化和反序列化，有两种方式：
  + 特殊符号标记法：在将二叉树序列化为数组的时候，需要标记空指针为"特殊符号"，这样在反序列化的时候，就可以根据这些符号和序列方式来唯一确定一颗二叉树。
  + 两序确认法：在序列化的时候，不需要标记特殊符号，这样序列化出来的就是一个纯数组或者字符串，但是这样的数组即使知道序列方式，也是无法反序列化出来的，必须使用**中序+先序**，或者**中序+后续**的两个数组，才能将其反序列化。


## <font color=#Af9233 size=4>目录</font>

---
+ 二叉树的序列化
  + [按层遍历二叉树 输出数组](#Binary2ArrayLevel_print)
  + [S形遍历二叉树 输出数组](#Binary2ArrayS)
  + [先序遍历二叉树 输出数组](#PreOrder_recursion)
  + [中序遍历二叉树 输出数组](#InOrder_recursion)
  + [后序遍历二叉树 输出数组](#PostOrder_recursion)
  + [先序遍历二叉树 输出数组(特殊符号)](#Binary2ArrayPreOrder_Symbol)
  + [中序遍历二叉树 输出数组(特殊符号)](#Binary2ArrayInOrder_Symbol)
  + [后序遍历二叉树 输出数组(特殊符号)](#Binary2ArrayPostOrder_Symbol)
+ 二叉树的反序列化
  + [将按层次遍历的方式输入的数组  构造成一个二叉树](#createBinaryTreeLevel)
  + [将按先序遍历的方式输入的数组  构造成一个二叉树](#createPreOrder)
  + [将按中序遍历的方式输入的数组  构造成一个二叉树](#中序遍历二叉树)
  + [将按后序遍历的方式输入的数组  构造成一个二叉树](#createPostOrder)
  + [将按照完全二叉树输入的数组  构造成一个完全二叉树](#createfulltree)
  + [根据先序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树](#createTreePre_InOrder)
  + [根据后序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树](#createTreePost_InOrder)
+ 二叉树转链表
  + [全部转左孩子](#BinaryTree2LinkedList_Left)
  + [全部转右孩子](#BinaryTree2LinkedList_Right)

## <font color=#Af92A3 size=6>实现</font>

---
<font color=Af9233 size=4 >**按层遍历二叉树 输出数组**</font>
<p id="Binary2ArrayLevel_print"></p>

+ 设计思路
  + 通过队列的先进先出来构建父节点的弹出顺序
  + 通过双指针的对比来判断层级顺序
+ 主要代码

<font color=Af9233 size=4 >**S形遍历二叉树 输出数组**</font>
<p id="Binary2ArrayS"></p>

+ 设计思路
  + 利用双栈的特点，来交替打印输出的层级元素
+ 主要代码
```java
public int[] Binary2ArrayS(BinaryTreeImpl root) {
    if (check(root)) {
        return new int[0];
    }
    List<Integer> list = new ArrayList<>();
    Stack<BinaryTreeImpl> stack1 = new Stack();
    Stack<BinaryTreeImpl> stack2 = new Stack();
    stack1.push(root);
    list.add(root.value);
    boolean rawflag = true;

    while (!stack1.empty() || !stack2.empty()) {
        while (!stack1.empty()) {
            BinaryTreeImpl node = stack1.pop();
            if (rawflag) {
                if (node.left != null) {
                    stack2.push(node.left);
                    list.add(node.left.value);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                    list.add(node.right.value);
                }
            } else {
                if (node.right != null) {
                    stack2.push(node.right);
                    list.add(node.right.value);
                }
                if (node.left != null) {
                    stack2.push(node.left);
                    list.add(node.left.value);
                }
            }
        }
        rawflag = !rawflag;
        stack1 = stack2;
        stack2 = new Stack<>();
    }
    int[] binaryTrees = list.stream().mapToInt(Integer::intValue).toArray();
    return binaryTrees;
}
```
+ 注意事项
  + 标识位rawflag需要在每次层级关系结束的时候，反转一次
  + 层级关系结束的时候，双栈需要交换一次

<font color=Af9233 size=4 >**先序遍历二叉树 输出数组**</font>
<p id="PreOrder_recursion"></p>

+ 设计思路
  + 先序遍历的特点是，先跟节点，再左孩子，后右孩子
+ 主要代码
```java
//先序递归
public void PreOrder_recursion(BinaryTreeImpl root) {
    if (root == null) {
        return;
    }
    listPreOrder.add(root.value);
    if (root.left != null) {
        PreOrder_recursion(root.left);
    }
    if (root.right != null) {
        PreOrder_recursion(root.right);
    }
}
```
+ 一直遍历左孩子，再弹出右孩子
```java
//先序非递归
public void PreOrder_stack(BinaryTreeImpl root) {
    Stack<BinaryTreeImpl> stack = new Stack();
    while (root != null || !stack.empty()) {
        while (root != null) {
            stack.push(root);
            listPreOrder.add(root.value);
            root = root.left;
        }
        root = stack.pop().right;
    }
}
```
+ 注意事项

<font color=Af9233 size=4 >**中序遍历二叉树 输出数组**</font>
<p id="InOrder_recursion"></p>

+ 设计思路
  + 中序遍历的特点是，先左孩子，再跟节点，最后右孩子
+ 主要代码
```java
//中序递归
private void InOrder_recursion(BinaryTreeImpl root) {
    if (root == null) {
        return;
    }
    InOrder_recursion(root.left);
    listInOrder.add(root.value);
    InOrder_recursion(root.right);
}
```
```java
//中序非递归
private void InOrder_stack(BinaryTreeImpl root) {
    Stack<BinaryTreeImpl> stack = new Stack<>();
    while (root != null || !stack.empty()) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        listInOrder.add(root.value);
        root = root.right;
    }
}
```
+ 注意事项
  + 中序非递归中需要注意list加入节点的时机

<font color=Af9233 size=4 >**后序遍历二叉树 输出数组**</font>
<p id="PostOrder_recursion"></p>

+ 设计思路
  + 后序遍历的特点是，先左孩子，再右孩子，最后跟节点
+ 主要代码
```java
//后续遍历 递归
private void PostOrder_recursion(BinaryTreeImpl root) {
    if (check(root)) {
        return;
    }
    PostOrder_recursion(root.left);
    PostOrder_recursion(root.right);
    listPostOrder.add(root.value);
}
```
+ 后续遍历 双栈法在遍历的时候，看似stack1是跟节点，左孩子，右孩子的顺序入栈，实则在导出至stack2的时候，是右孩子、左孩子、跟节点的顺序。
```java
//后续遍历 双栈法
private void PostOrder_stack2(BinaryTreeImpl root) {
    Stack<BinaryTreeImpl> stack1 = new Stack<>();
    Stack<BinaryTreeImpl> stack2 = new Stack<>();
    stack1.push(root);
    while (!stack1.empty()) {
        root = stack1.pop();
        stack2.push(root);
        if (root.left != null) {
            stack1.push(root.left);
        }
        if (root.right != null) {
            stack1.push(root.right);
        }
    }
    while (!stack2.empty()) {
        listPostOrder.add(stack2.pop().value);
    }
}
```
```java
//后续遍历 单栈法
public void PostOrder_stack1(BinaryTreeImpl h) {
    Stack<BinaryTreeImpl> stack = new Stack<>();
    stack.push(h);
    BinaryTreeImpl c = null;
    while (!stack.isEmpty()) {
        c = stack.peek();
        if (c.left != null && h != c.left && h != c.right) {
            stack.push(c.left);
        } else if (c.right != null && h != c.right) {
            stack.push(c.right);
        } else {
            listPostOrder.add(stack.pop().value);
            h = c;
        }
    }
}
```
+ 注意事项
  + 单栈法的h是上一个节点的位置，用于标记自身是否被重复入栈。

<font color=Af9233 size=4 >**先序遍历二叉树 输出数组(特殊符号)**</font>
<p id="Binary2ArrayPreOrder_Symbol"></p>

+ 设计思路
  + 递归
+ 主要代码
```java
public int[] Binary2ArrayPreOrder_Symbol(BinaryTreeImpl root) {
        if (check(root)) {
            return new int[]{};
        }
        listPreOrder_Symbol = new ArrayList<>();
        PreOrder_Symbol(root);
        return listPreOrder_Symbol.stream().mapToInt(x -> x).toArray();
    }

    private void PreOrder_Symbol(BinaryTreeImpl root) {
        if (root == null) {
            listPreOrder_Symbol.add(Symbol);
            return;
        }
        listPreOrder_Symbol.add(root.value);
        PreOrder_Symbol(root.left);
        PreOrder_Symbol(root.right);
    }
```

<font color=Af9233 size=4 >**中序遍历二叉树 输出数组(特殊符号)**</font>
<p id="Binary2ArrayInOrder_Symbol"></p>

+ 设计思路
  + 递归
+ 主要代码
```java
public int[] Binary2ArrayInOrder_Symbol(BinaryTreeImpl root) {
    if(check(root)){
        return new int[]{};
    }
    listInOrder_Symbol = new ArrayList<>();
    InOrder_Symbol(root);
    return  listInOrder_Symbol.stream().mapToInt(Integer::intValue).toArray();
}

private void InOrder_Symbol(BinaryTreeImpl root){
    if(root == null){
        listInOrder_Symbol.add(Symbol);
        return;
    }
    InOrder_Symbol(root.left);
    listInOrder_Symbol.add(root.value);
    InOrder_Symbol(root.right);
}
```

<font color=Af9233 size=4 >**后序遍历二叉树 输出数组(特殊符号)**</font>
<p id="Binary2ArrayPostOrder_Symbol"></p>

+ 设计思路
  + 递归
+ 主要代码
```java
public int[] Binary2ArrayPostOrder_Symbol(BinaryTreeImpl root) {
        if(check(root)){
            return new int[]{};
        }
        listPostOrder_Symbol = new ArrayList<>();
        PostOrder_Symbol(root);
        return listPostOrder_Symbol.stream().mapToInt(Integer::intValue).toArray();
    }

    private void PostOrder_Symbol(BinaryTreeImpl root){
        if(root==null){
            listPostOrder_Symbol.add(Symbol);
            return;
        }
        PostOrder_Symbol(root.left);
        PostOrder_Symbol(root.right);
        listPostOrder_Symbol.add(root.value);
    }
```

## 二叉树的反序列化
---
<font color=Af9233 size=4 >**将按层次遍历的方式输入的数组  构造成一个二叉树**</font>
<p id="createBinaryTreeLevel"></p>

+ 设计思路
  + 通过队列辅助，实现节点顺序
+ 主要代码
```java
//1、将按层次遍历的方式输入的数组  构造成一个二叉树(写法一：非递归，堆栈)
public BinaryTreeImpl createBinaryTreeLevel(int[] array) {
    if (!check(array)) {
        return null;
    }
    BinaryTreeImpl root = null;
    //借助队列实现
    Queue<BinaryTreeImpl> queue = new LinkedList();
    int depth = 0;
    root = new BinaryTreeImpl(array[depth]);
    queue.offer(root);
    while (!queue.isEmpty()) {
        BinaryTreeImpl binaryTree = queue.poll();
        //left child exist
        if (++depth < array.length && array[depth] != -1) {
            binaryTree.left = new BinaryTreeImpl(array[depth]);
            queue.offer(binaryTree.left);
        }
        //right child exist
        if (++depth < array.length && array[depth] != -1) {
            binaryTree.right = new BinaryTreeImpl(array[depth]);
            queue.offer(binaryTree.right);
        }
    }
    return root;
}
```
+ 使用递归实现，但是需要注意，此处的count是必须是全局变量。
```java
//1、将按层次遍历的方式输入的数组  构造成一个二叉树(写法二:递归)
private volatile int count;
public BinaryTreeImpl createBinaryTreeLevel(BinaryTreeImpl root, int[] tree_num, int i) {
    if (i < tree_num.length) {
        if (tree_num[i] == -1) {
            return null;
        } else {
            //new root's lchild and rchild
            BinaryTreeImpl lchild = new BinaryTreeImpl();
            BinaryTreeImpl rchild = new BinaryTreeImpl();
            //preOrder
            root.value = tree_num[i];
            root.left = createBinaryTreeLevel(lchild, tree_num, ++count);
            root.right = createBinaryTreeLevel(rchild, tree_num, ++count);
        }
    }
    return root;
}
```
+ 注意事项
  + count是必须是全局变量。

<font color=Af9233 size=4 >**将按先序遍历的方式输入的数组  构造成一个二叉树**</font>
<p id="createPreOrder"></p>

+ 设计思路
  + 通过队列记录数组顺序
  + 先序构造二叉树
+ 主要代码
```java
public BinaryTreeImpl createPreOrder(int[] array) {
    Queue<BinaryTreeImpl> queue = new LinkedList<>();
    if (!check(array)) {
        return null;
    }
    for (int value : array) {
        queue.add(new BinaryTreeImpl(value));
    }
    BinaryTreeImpl root = PreOrder(queue);
    return root;
}

private BinaryTreeImpl PreOrder(Queue<BinaryTreeImpl> queue) {
    if (queue == null) {
        return null;
    }
    BinaryTreeImpl root = queue.poll();
    if (root.value == Symbol) {
        return null;
    }
    root.left = PreOrder(queue);
    root.right = PreOrder(queue);
    return root;
}
```
+ 注意事项

<font color=Af9233 size=4 >**将按中序遍历的方式输入的数组  构造成一个二叉树**</font>
<p id="中序遍历二叉树"></p>

+ 注意事项
  + 中序无法还原二叉树，因为无法找到跟节点

<font color=Af9233 size=4 >**将按后序遍历的方式输入的数组  构造成一个二叉树**</font>
<p id="createPostOrder"></p>

+ 设计思路
  + 通过队列记录数组顺序
  + 因为队列的最后一位是跟节点，继续后续生成二叉树。
  + 注意队列的入队顺序，因此先右孩子，再左孩子。
+ 主要代码
```java
public BinaryTreeImpl createPostOrder(int[] array) {
    if (!check(array)) {
        return null;
    }
    Deque<BinaryTreeImpl> queue = new LinkedList<>();
    for (int value : array) {
        queue.add(new BinaryTreeImpl(value));
    }
    BinaryTreeImpl root = PostOrder(queue);
    return root;
}

private BinaryTreeImpl PostOrder(Deque<BinaryTreeImpl> queue) {
    if (queue == null) {
        return null;
    }
    BinaryTreeImpl root = queue.pollLast();
    if (root.value == Symbol) {
        return null;
    }
    root.right = PostOrder(queue);
    root.left = PostOrder(queue);
    return root;
}
```
+ 注意事项

<font color=Af9233 size=4 >**将按照完全二叉树输入的数组  构造成一个完全二叉树**</font>
<p id="createfulltree"></p>

+ 设计思路
  + 第一步：判断此数组是否为完全二叉树，即数组长度是否为 2的n次方-1
  + 第二步：循环构建节点
  + 第三部：构建节点关系f(i)=f(2*i+1)
+ 主要代码
```java
public BinaryTreeImpl createfulltree(int[] array) {
    if (array == null || array.length == 0) {
        return null;
    }
    int length = array.length;
    int base = 2;
    //判断一个数是否为 2的n次方-1
    int indexlength = String.valueOf(Math.log(length + 1) / Math.log(base)).length();
    //double型 整数 数字转字符串长度，长度为3
    if (indexlength > 3) {
        return null;
    }
    List<BinaryTreeImpl> btlist = new ArrayList<>();
    for (int i = 0; i < length; i++) {
        btlist.add(new BinaryTreeImpl(array[i]));
    }
    //注意此处的i < (length - 1) / 2，而不是i < (length + 1) / 2
    for (int i = 0; i < (length - 1) / 2; i++) {
        btlist.get(i).left = btlist.get(2 * i + 1);
        btlist.get(i).right = btlist.get(2 * i + 2);
    }
    return btlist.get(0);
}
```
+ 注意事项

<font color=Af9233 size=4 >**根据前序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树**</font>
<p id="createTreePre_InOrder"></p>

+ 设计思路
  + 先序遍历的第一个节点是中序遍历的中间节点
  + 通过循环判断中间节点，将中序分成两部分，进行递归
+ 主要代码
```java
public BinaryTreeImpl createTreePre_InOrder(int[] PreOrderarray, int preStart, int preEnd, int[] InOrderarray, int inStart, int inEnd) {
    if (preStart <= preEnd) {
        //此处是PreOrderarray[preStart]，不是PreOrderarray[0]
        int value = PreOrderarray[preStart];
        BinaryTreeImpl node = new BinaryTreeImpl(value);
        int index = 0;
        //循环不是从0 到 InOrderarray.length
        for (int i = inStart; i <= inEnd; i++) {
            if (value == InOrderarray[i]) {
                index = i;
                break;
            }
        }
        //此处length = index - inStart，而不是length = index - preStart
        int length = index - inStart;
        node.left = createTreePre_InOrder(PreOrderarray, preStart + 1, preStart + length,
                InOrderarray, inStart, index - 1);
        node.right = createTreePre_InOrder(PreOrderarray, preStart + length + 1, preEnd,
                InOrderarray, index + 1, inEnd);
        return node;
    }
    return null;
}
```
+ 注意事项

<font color=Af9233 size=4 >**根据后序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树**</font>
<p id="createTreePost_InOrder"></p>

+ 设计思路
  + 后序遍历的最后一个节点是中序遍历的中间节点
  + 通过循环判断中间节点，将中序分成两部分，进行递归
+ 主要代码
```java
public BinaryTreeImpl createTreePost_InOrder(int[] PostOrderarray, int postStart, int postEnd, int[] InOrderarray, int inStart, int inEnd) {
        if (postStart <= postEnd) {
            //此处是PreOrderarray[preStart]，不是PreOrderarray[0]
            int value = PostOrderarray[postEnd];
            BinaryTreeImpl node = new BinaryTreeImpl(value);
            int index = 0;
            //循环不是从0 到 InOrderarray.length
            for (int i = inStart; i <= inEnd; i++) {
                if (value == InOrderarray[i]) {
                    index = i;
                    break;
                }
            }
            //此处length = index - inStart，而不是length = index - preStart
            int length = index - inStart;
            node.left = createTreePost_InOrder(PostOrderarray, postStart, postStart + length - 1,
                    InOrderarray, inStart, index - 1);
            node.right = createTreePost_InOrder(PostOrderarray, postStart + length, postEnd - 1,
                    InOrderarray, index + 1, inEnd);
            return node;
        }
        return null;
    }
```
+ 注意事项


## 二叉树转链表
---
<font color=Af9233 size=4 >**右孩子转左孩子的左孩子**</font>
<p id="BinaryTree2LinkedList_Left"></p>

+ 设计思路
  + 取出节点的左右孩子，右孩子置空
  + 循环左孩子（之前的）至叶子节点，
  + 将右孩子（之前的）复制给该叶子节点的左孩子
+ 主要代码
```java
//将右孩子并至左孩子叶子结点，形成链表
private BinaryTreeImpl BinaryTree2LinkedList_Left(BinaryTreeImpl binaryTree) {
    if (binaryTree == null) {
        return null;
    }
    /**
     * 取出节点的左右孩子，右孩子置空
     * 循环左孩子（之前的）至叶子节点，
     * 将右孩子（之前的）复制给该叶子节点的左孩子
     */
    BinaryTree2LinkedList_Left(binaryTree.left);
    BinaryTree2LinkedList_Left(binaryTree.right);
    BinaryTreeImpl nodeleft = binaryTree.left;
    BinaryTreeImpl noderight = binaryTree.right;
    binaryTree.right = null;
    BinaryTreeImpl p = binaryTree;
    //注意此处的写法是p.left 而不是p，因为存在判空问题
    while (p.left != null) {
        p = p.left;
    }
    p.left = noderight;
    return binaryTree;
}
```
+ 注意事项

<font color=Af9233 size=4 >**左孩子转右孩子的右孩子**</font>
<p id="BinaryTree2LinkedList_Right"></p>

+ 设计思路
  + 取出节点的左右孩子，直接把左孩子复制给跟节点的右孩子，左孩子置空
  + 循环右孩子（之前的左孩子）至叶子节点，
  + 将右孩子（之前的）复制给该叶子节点的右孩子
+ 主要代码
```java
private BinaryTreeImpl BinaryTree2LinkedList_Right(BinaryTreeImpl binaryTree) {
    if (binaryTree == null) {
        return null;
    }
    /**
     * 取出节点的左右孩子，直接把左孩子复制给跟节点的右孩子，左孩子置空
     * 循环右孩子（之前的左孩子）至叶子节点，
     * 将右孩子（之前的）复制给该叶子节点的右孩子
     */
    BinaryTree2LinkedList_Right(binaryTree.left);
    BinaryTree2LinkedList_Right(binaryTree.right);
    BinaryTreeImpl nodeleft = binaryTree.left;
    BinaryTreeImpl noderight = binaryTree.right;
    binaryTree.left = null;
    binaryTree.right = nodeleft;
    BinaryTreeImpl p = binaryTree;
    //注意此处的写法是p.left 而不是p，因为存在判空问题
    while (p.right != null) {
        p = p.right;
    }
    p.right = noderight;
    return binaryTree;
}
```
+ 注意事项

