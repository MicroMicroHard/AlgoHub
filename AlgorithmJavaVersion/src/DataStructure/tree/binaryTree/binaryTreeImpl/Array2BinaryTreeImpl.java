package DataStructure.tree.binaryTree.binaryTreeImpl;

import Common.Constant.C;
import DataStructure.tree.binaryTree.BinaryTreeImpl;

import java.util.*;

/**
 * @author liujun
 * @date 2020-02-18 16:42
 * @description 二叉树的实现
 * 单序创建：
 * 1.1、将按层次遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】
 * 特殊符号:
 * 2.1、将按先序遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】
 * 2.2、将按中序遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】
 * 2.3、将按后序遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】
 * 完全二叉树:
 * 2.1、将一个完全二叉树的数组 构造成一个二叉树【递归、非递归解法】
 * 多序创建：
 * 4.1、已知前序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。【递归、非递归解法】
 * 4.2、已知后序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。【递归、非递归解法】
 */
public class Array2BinaryTreeImpl implements Array2BinaryTree {

    //----------------------单序创建--------------------------------
    //1、将按层次遍历的方式输入的数组  构造成一个二叉树(写法一：非递归，堆栈)
    public BinaryTreeImpl array2BTByLevel(int[] array, boolean recursive) {
        if (recursive) {
            return createBTByLevelRecursive(array);
        }
        return createBTByLevelNonRecursive(array);
    }

    //2.1、将按先序遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】
    public BinaryTreeImpl array2BTByPreOrder(int[] array, boolean recursive) {
        if (recursive) {
            return createBTByPreOrderRecursive(array);
        }
        return createBTByPreOrderNonRecursive(array);
    }

    //2.2、将按中序遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】
    public BinaryTreeImpl array2BTByInOrder(int[] array, boolean recursive) {
        if (recursive) {
            return createBTByInOrderRecursive(array);
        }
        return createBTByInOrderNonRecursive(array);
    }

    //2.3、将按后序遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】

    public BinaryTreeImpl array2BTByPostOrder(int[] array, boolean recursive) {
        if (recursive) {
            return createBTByPostOrderRecursive(array);
        }
        return createBTByPostOrderNonRecursive(array);
    }

    //3.1、将一个完全二叉树的数组 构造成一个二叉树【递归、非递归解法】
    public BinaryTreeImpl array2FullBT(int[] array, boolean recursive) {
        if (recursive) {
            return createFullBTRecursive(array);
        }
        return createFullBTNonRecursive(array);
    }

    //4.1、已知前序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。【递归、非递归解法】
    public BinaryTreeImpl array2BTByPre_InOrder(int[] PreOrderArray, int[] InOrderArray, boolean recursive) {
        if (recursive) {
            return createBTByPre_InOrderRecursive(PreOrderArray, InOrderArray);
        }
        return createBTByPre_InOrderNonRecursive(PreOrderArray, InOrderArray);
    }

    //4.2、已知后序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。【递归、非递归解法】
    public BinaryTreeImpl array2BTByPost_InOrder(int[] PostOrderArray, int[] InOrderArray, boolean recursive) {
        if (recursive) {
            return createBTByPost_InOrder(PostOrderArray, InOrderArray);
        }
        return createBTByPost_InOrderNonRecursive(PostOrderArray, InOrderArray);
    }


    public BinaryTreeImpl createBTByLevelRecursive(int[] array) {
        if (!check(array)) {
            return null;
        }
        // todo
        int depth = 0;
        BinaryTreeImpl root = new BinaryTreeImpl(array[depth]);
        return root;
    }

    public BinaryTreeImpl createBTByLevelNonRecursive(int[] array) {
        if (!check(array)) {
            return null;
        }
        //借助队列实现
        Queue<BinaryTreeImpl> queue = new LinkedList<>();
        int depth = 0;
        BinaryTreeImpl root = new BinaryTreeImpl(array[depth]);
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryTreeImpl binaryTree = queue.poll();
            //left child exist
            if (++depth < array.length && array[depth] != C.NLF) {
                binaryTree.left = new BinaryTreeImpl(array[depth]);
                queue.offer(binaryTree.left);
            }
            //right child exist
            if (++depth < array.length && array[depth] != C.NLF) {
                binaryTree.right = new BinaryTreeImpl(array[depth]);
                queue.offer(binaryTree.right);
            }
        }
        return root;
    }

    //1、将按层次遍历的方式输入的数组  构造成一个二叉树(写法二:递归)
    private volatile int count;

    public BinaryTreeImpl createBinaryTreeLevel(BinaryTreeImpl root, int[] tree_num, int i) {
        if (i < tree_num.length) {
            if (tree_num[i] == C.NLF) {
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

    //2、将按先序遍历的方式输入的数组  构造成一个二叉树
    public BinaryTreeImpl createBTByPreOrderRecursive(int[] array) {
        if (!check(array)) {
            return null;
        }
        Queue<BinaryTreeImpl> queue = new LinkedList<>();
        for (int value : array) {
            queue.add(new BinaryTreeImpl(value));
        }
        BinaryTreeImpl root = PreOrder(queue);
        return root;
    }

    public BinaryTreeImpl createBTByPreOrderNonRecursive(int[] array) {
        if (!check(array)) {
            return null;
        }
        Stack<BinaryTreeImpl> stack = new Stack<>();
        BinaryTreeImpl root = new BinaryTreeImpl(array[0]);
        BinaryTreeImpl preNode = root;
        stack.push(preNode);
        Map<BinaryTreeImpl, Boolean> leftMap = new HashMap<>();

        for (int i = 1; i < array.length; i++) {
            // 如果是空节点
            if (array[i] == C.NLF) {
                boolean flag = leftMap.getOrDefault(preNode, false);
                if (flag) {
                    stack.pop();
                    preNode = stack.empty() ? null : stack.peek();
                } else {
                    leftMap.put(preNode, true);
                }
                continue;
            }
            BinaryTreeImpl node = new BinaryTreeImpl(array[i]);
            if (preNode == null) {
                preNode = stack.pop();
            }
            if (leftMap.containsKey(preNode)) {
                preNode.right = node;
                stack.pop();
            } else {
                preNode.left = node;
                leftMap.put(node, true);
            }
            preNode = node;
            stack.push(node);
        }
        return root;
    }

    private BinaryTreeImpl PreOrder(Queue<BinaryTreeImpl> queue) {
        if (queue == null || queue.size() == 0) {
            return null;
        }
        BinaryTreeImpl root = queue.poll();
        if (root.value == C.NLF) {
            return null;
        }
        root.left = PreOrder(queue);
        root.right = PreOrder(queue);
        return root;
    }


    //3、将按中序遍历的方式输入的数组  构造成一个二叉树
    public BinaryTreeImpl createBTByInOrderRecursive(int[] array) {
        /*
        if (!check(array)) {
            return null;
        }
        Queue<BinaryTreeImpl> queue = new LinkedList<>();
        for (int value : array) {
            queue.add(new BinaryTreeImpl(value));
        }
        BinaryTreeImpl root = InOrder(queue);
        return root;*/
        //因为无法找到根节点，所以无法构造
        return null;
    }

    public BinaryTreeImpl createBTByInOrderNonRecursive(int[] array) {
        return null;
    }

    //4、将按后序遍历的方式输入的数组  构造成一个二叉树
    public BinaryTreeImpl createBTByPostOrderRecursive(int[] array) {
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

    public BinaryTreeImpl createBTByPostOrderNonRecursive(int[] array) {
        return null;
    }

    private BinaryTreeImpl PostOrder(Deque<BinaryTreeImpl> queue) {
        if (queue == null || queue.size() == 0) {//attention:递归的退出条件
            return null;
        }
        BinaryTreeImpl root = queue.pollLast();
        if (root.value == C.NLF) {
            return null;
        }
        root.right = PostOrder(queue);
        root.left = PostOrder(queue);
        return root;
    }

    // 5、将一个完全二叉树的数组 构造成一个二叉树
    public BinaryTreeImpl createFullBTRecursive(int[] array) {
        return null;
    }

    public BinaryTreeImpl createFullBTNonRecursive(int[] array) {
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
        for (int j : array) {
            btlist.add(new BinaryTreeImpl(j));
        }
        //注意此处的i < (length - 1) / 2，而不是i < (length + 1) / 2
        for (int i = 0; i < (length - 1) / 2; i++) {
            btlist.get(i).left = btlist.get(2 * i + 1);
            btlist.get(i).right = btlist.get(2 * i + 2);
        }
        return btlist.get(0);
    }

    //----------------------多序创建--------------------------------

    //6、已知前序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。
    public BinaryTreeImpl createBTByPre_InOrderRecursive(int[] PreOrderArray, int[] InOrderArray) {
        if (check(PreOrderArray) && check(InOrderArray)) {
            int preStart = 0;
            int preEnd = PreOrderArray.length - 1;
            int inStart = 0;
            int inEnd = InOrderArray.length - 1;
            // todo 判断相等
            if (preEnd == inEnd) {
                return createTreePre_InOrder(PreOrderArray, preStart, preEnd, InOrderArray, inStart, inEnd);
            }
        }
        return null;
    }

    public BinaryTreeImpl createBTByPre_InOrderNonRecursive(int[] PreOrderarray, int[] InOrderArray) {
        return null;
    }

    public BinaryTreeImpl createTreePre_InOrder(int[] PreOrderArray, int preStart, int preEnd,
                                                int[] InOrderArray, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        //此处是PreOrderArray[preStart]，不是PreOrderArray[0]
        int value = PreOrderArray[preStart];
        BinaryTreeImpl node = new BinaryTreeImpl(value);
        int in_Index = 0;
        //循环不是从0 到 InOrderArray.length
        for (int i = inStart; i <= inEnd; i++) {
            if (value == InOrderArray[i]) {
                in_Index = i;
                break;
            }
        }
        //此处length = index - inStart，而不是length = index - preStart
        int length = in_Index - inStart;
        node.left = createTreePre_InOrder(PreOrderArray, preStart + 1, preStart + length,
                InOrderArray, inStart, in_Index - 1);
        node.right = createTreePre_InOrder(PreOrderArray, preStart + length + 1, preEnd,
                InOrderArray, in_Index + 1, inEnd);
        return node;
    }

    //7、已知后序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。
    public BinaryTreeImpl createBTByPost_InOrder(int[] PostOrderArray, int[] InOrderArray) {
        if (check(PostOrderArray) && check(InOrderArray)) {
            int postStart = 0;
            int postEnd = PostOrderArray.length - 1;
            int inStart = 0;
            int inEnd = InOrderArray.length - 1;
            if (postEnd == inEnd) {
                return createTreePost_InOrder(PostOrderArray, postStart, postEnd, InOrderArray, inStart, inEnd);
            }
        }
        return null;
    }

    public BinaryTreeImpl createBTByPost_InOrderNonRecursive(int[] PostOrderArray, int[] InOrderArray) {
        return null;
    }

    public BinaryTreeImpl createTreePost_InOrder(int[] PostOrderArray, int postStart, int postEnd, int[] InOrderArray, int inStart, int inEnd) {
        if (postStart <= postEnd) {
            //此处是PreOrderArray[preStart]，不是PreOrderArray[0]
            BinaryTreeImpl node = new BinaryTreeImpl(PostOrderArray[postEnd]);
            int in_Index = 0;
            //循环不是从0 到 InOrderArray.length
            for (int i = inStart; i <= inEnd; i++) {
                if (node.value == InOrderArray[i]) {
                    in_Index = i;
                    break;
                }
            }
            //此处length = index - inStart，而不是length = index - preStart
            int length = in_Index - inStart;
            node.left = createTreePost_InOrder(PostOrderArray, postStart, postStart + length - 1, InOrderArray, inStart, in_Index - 1);
            node.right = createTreePost_InOrder(PostOrderArray, postStart + length, postEnd - 1, InOrderArray, in_Index + 1, inEnd);
            return node;
        }
        return null;
    }
}
