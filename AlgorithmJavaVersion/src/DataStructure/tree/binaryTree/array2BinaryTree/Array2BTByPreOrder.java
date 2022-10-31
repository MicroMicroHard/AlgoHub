package DataStructure.tree.binaryTree.array2BinaryTree;

import Common.Constant.C;
import Common.Utils.UTFactory;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import org.junit.Test;

import java.util.*;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/14 12:14
 * @author-Email micromicrohard@outlook.com
 * @description 将按先序遍历的方式输入的数组
 * 根据先序遍历的数组(带符号)，构造成一个二叉树（特殊符号）【递归、非递归解法】
 * Method_Stack
 * Method_Recursive
 * Method_Recursive_Constant
 * @blogURL
 */
public class Array2BTByPreOrder {

    @Test // 验证功能：从数据库获取测试数据，用于单元测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误的测试案例
    public void DoubleTrack() throws Exception {
        String input = "{1, 2, NLF, NLF, 4, 5, NLF, NLF, 3, 6, NLF, 7, NLF, NLF, NLF}";
        String output = "{1, 2, NLF, NLF, 4, 5, NLF, NLF, 3, 6, NLF, 7, NLF, NLF, NLF}";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    // attention 非递归的写法，需要一个辅助工具：记录左孩子已经有值的leftMap，来维护关系
    public BinaryTreeImpl Method_Stack(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        Stack<BinaryTreeImpl> stack = new Stack<>();
        BinaryTreeImpl root = new BinaryTreeImpl(array[0]);
        stack.push(root);
        Map<BinaryTreeImpl, Boolean> leftMap = new HashMap<>();
        BinaryTreeImpl preNode = root; // attention preNode = root

        for (int i = 1; i < array.length; i++) {
            BinaryTreeImpl node = null;
            if (array[i] != C.NLF) {
                node = new BinaryTreeImpl(array[i]);
            }
            if (leftMap.getOrDefault(preNode, false)) {
                preNode.right = node;
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                preNode.left = node;
                leftMap.put(preNode, true);
            }
            if (node == null) {
                preNode = !stack.isEmpty() ? stack.peek() : null;
                continue;
            }
            preNode = node;
            stack.push(preNode);
        }
        return root;
    }

    public BinaryTreeImpl Method_Recursive_Queue(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i : array) {
            queue.add(i);
        }
        return roll(queue);
    }

    public BinaryTreeImpl roll(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return null;
        }
        int value = queue.poll();
        if (value == C.NLF) {
            return null;
        }
        BinaryTreeImpl node = new BinaryTreeImpl(value);
        node.left = roll(queue);
        node.right = roll(queue);
        return node;
    }

    int count = 0;

    public BinaryTreeImpl Method_Recursive_Constant(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        count = 0;
        return roll(new BinaryTreeImpl(array[0]), array, 0);
    }

    public BinaryTreeImpl roll(BinaryTreeImpl root, int[] array, int index) {
        if (index >= array.length) {
            return null;
        }
        if (array[index] == C.NLF) {
            return null;
        }
        root.value = array[index];
        root.left = roll(new BinaryTreeImpl(), array, ++count);
        root.right = roll(new BinaryTreeImpl(), array, ++count);
        return root;
    }
}
