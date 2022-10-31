package DataStructure.tree.binaryTree.binaryTreeImpl;

import Common.Constant.C;
import DataStructure.tree.binaryTree.BinaryTreeImpl;

import java.util.*;

/**
 * @author 蔚蔚樱
 * @date 2020-02-18 18:46
 * @description 按层：
 * 1、按层遍历二叉树 输出数组（队列）{@link BinaryTree2ArrayImpl#BT2ArrayByLevelOutput}
 * S形：
 * 1、S形遍历二叉树 输出数组（栈）  {@link BinaryTree2ArrayImpl#BT2ArrayBySPrint}
 * 按序：
 * 1、先序遍历二叉树 输出数组
 * 2、中序遍历二叉树 输出数组
 * 3、后序遍历二叉树 输出数组
 * 1-1、先序遍历二叉树 输出数组(特殊符号) {@link BinaryTree2ArrayImpl#BT2ArrayByPreOrder}
 * 2-1、中序遍历二叉树 输出数组(特殊符号) {@link BinaryTree2ArrayImpl#BT2ArrayByInOrder}
 * 3-1、后序遍历二叉树 输出数组(特殊符号) {@link BinaryTree2ArrayImpl#BT2ArrayByPostOrder}
 */
public class BinaryTree2ArrayImpl implements BinaryTree2Array {

    //按层输出遍历的数组
    public int[] BT2ArrayByLevelOutput(BinaryTreeImpl root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new LinkedList<>();
        Queue<BinaryTreeImpl> queue = new LinkedList<>();
        queue.offer(root);
        list.add(root.value);
        while (!queue.isEmpty()) {
            BinaryTreeImpl binaryTree = queue.poll();
            if (binaryTree.left != null) {
                queue.offer(binaryTree.left);
                list.add(binaryTree.left.value);
            }
            if (binaryTree.right != null) {
                queue.offer(binaryTree.right);
                list.add(binaryTree.right.value);
            }
        }
        int[] binaryTrees = list.stream().mapToInt(Integer::intValue).toArray();
        return binaryTrees;
    }

    //按行打印二叉树
    public void BT2ArrayByLevelPrint(BinaryTreeImpl root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeImpl> queue = new LinkedList<>();
        queue.offer(root);
        BinaryTreeImpl front = root;
        BinaryTreeImpl tail = root;
        while (!queue.isEmpty()) {
            BinaryTreeImpl binaryTree = queue.poll();
            System.out.print(binaryTree.value + " ");
            if (binaryTree.left != null) {
                queue.offer(binaryTree.left);
                tail = binaryTree.left;
            }
            if (binaryTree.right != null) {
                queue.offer(binaryTree.right);
                tail = binaryTree.right;
            }
            //换行标志
            if (binaryTree == front) {
                front = tail;
                System.out.println();
            }
        }
    }

    //S形遍历二叉树 输出数组（栈）
    public int[] BT2ArrayBySPrint(BinaryTreeImpl root) {
        if (root == null) {
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

    //------------------------【先序遍历】----------------------------------
    List<Integer> listPreOrder;
    List<Integer> listInOrder;
    List<Integer> listPostOrder;

    //先序遍历二叉树 输出数组
    public int[] BT2ArrayByPreOrder(BinaryTreeImpl root) {
        return BT2ArrayByPreOrder(root, false, false);
    }

    //先序遍历二叉树 输出数组(特殊符号)
    public int[] BT2ArrayByPreOrder(BinaryTreeImpl root, boolean withSymbol, boolean recursive) {
        if (root == null) {
            return new int[0];
        }
        listPreOrder = new ArrayList<>();
        //PreOrder_recursion(root);
        if (recursive) {
            PreOrder_recursion(root, withSymbol);
        } else {
            PreOrder_stack(root);
        }
        int[] arrayPreOrder = listPreOrder.stream().mapToInt(x -> x).toArray();
        return arrayPreOrder;
    }

    //先序递归
    public void PreOrder_recursion(BinaryTreeImpl root, boolean withSymbol) {
        if (root == null) {
            if (withSymbol) {
                listPreOrder.add(C.NLF);
            }
            return;
        }
        listPreOrder.add(root.value);
        PreOrder_recursion(root.left, withSymbol);
        PreOrder_recursion(root.right, withSymbol);
    }

    //先序非递归
    public void PreOrder_stack(BinaryTreeImpl root) {
        Stack<BinaryTreeImpl> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                listPreOrder.add(root.value);//visit
                root = root.left;
            }
            root = stack.pop().right;
        }
    }

    //------------------------【中序遍历】----------------------------------

    //中序遍历二叉树 输出数组【递归和非递归】【叶子的孩子是否表示成特殊符号】
    public int[] BT2ArrayByInOrder(BinaryTreeImpl root) {
        return BT2ArrayByInOrder(root, false, false);
    }

    public int[] BT2ArrayByInOrder(BinaryTreeImpl root, boolean withSymbol, boolean recursive) {
        if (root == null) {
            return new int[0];
        }
        listInOrder = new ArrayList<>();
        if (recursive) {
            InOrder_recursion(root, withSymbol);
        } else {
            InOrder_stack(root, withSymbol);
        }
        int[] arrayInorder = listInOrder.stream().mapToInt(x -> x).toArray();
        return arrayInorder;
    }

    //中序遍历--递归【符号】
    public void InOrder_recursion(BinaryTreeImpl root, boolean withSymbol) {
        if (root == null) {
            if (withSymbol) {
                listInOrder.add(C.NLF);
            }
            return;
        }
        InOrder_recursion(root.left, withSymbol);
        listInOrder.add(root.value);
        InOrder_recursion(root.right, withSymbol);
    }

    //中序遍历--非递归【符号】
    public void InOrder_stack(BinaryTreeImpl root, boolean withSymbol) {
        Stack<BinaryTreeImpl> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (withSymbol) {
                listInOrder.add(C.NLF);
            }
            root = stack.pop();
            listInOrder.add(root.value);
            root = root.right;
        }
    }

    //------------------------【后序遍历】----------------------------------

    //后序遍历二叉树 输出数组(特殊符号)
    public int[] BT2ArrayByPostOrder(BinaryTreeImpl root) {
        return BT2ArrayByPostOrder(root, false, false);
    }

    public int[] BT2ArrayByPostOrder(BinaryTreeImpl root, boolean withSymbol, boolean recursive) {
        if (root == null) {
            return new int[]{};
        }
        listPostOrder = new ArrayList<>();
        if (recursive) {
            PostOrder_recursion(root, withSymbol);
        } else {
            PostOrder_double_stack(root);
        }
        return listPostOrder.stream().mapToInt(Integer::intValue).toArray();
    }

    //后续遍历 递归
    public void PostOrder_recursion(BinaryTreeImpl root, boolean withSymbol) {
        if (root == null) {
            if (withSymbol) {
                listPostOrder.add(C.NLF);
            }
            return;
        }
        PostOrder_recursion(root.left, withSymbol);
        PostOrder_recursion(root.right, withSymbol);
        listPostOrder.add(root.value);
    }

    //后续遍历 双栈法
    public void PostOrder_double_stack(BinaryTreeImpl root) {
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

    //后续遍历 单栈法
    public void PostOrder_single_stack(BinaryTreeImpl h) {
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

}
