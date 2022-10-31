package DataStructure.tree.binaryTree.array2BinaryTree;

import Common.Constant.C;
import Common.Utils.UTFactory;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/14 12:13
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 按层次遍历的方式输入的数组
 * 构造成一个二叉树（特殊符号）【递归、非递归解法】
 * @attation 按行构造二叉树，只能是满二叉树的数组才可以
 * @blogURL
 */
public class Array2BTByLevel {

    @Test // 验证功能：从数据库获取测试数据，用于单元测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误的测试案例
    public void DoubleTrack() throws Exception {
        String input = "{1, 2, 3, 4, NLF, 5, 6, 7, 8, 9, 10, NLF, 11, NLF, 12, NLF, 13, NLF, NLF, 14, NLF, NLF, NLF, 15, 16, NLF, 17, 18, 19, NLF, NLF, 21, NLF, NLF, NLF, NLF, NLF, 22, NLF, 24, NLF, NLF, 25, NLF, NLF, NLF, NLF}";
        String output = "{1, 2, 4, 7, NLF, 12, 15, NLF, NLF, 16, 21, 24, NLF, NLF, NLF, NLF, 8, NLF, 13, NLF, 17, NLF, NLF, NLF, 3, 5, 9, NLF, NLF, 10, 14, 18, NLF, NLF, 19, 22, NLF, 25, NLF, NLF, NLF, NLF, 6, NLF, 11, NLF, NLF}";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    public BinaryTreeImpl Method(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        Queue<BinaryTreeImpl> queue = new LinkedList<>();
        BinaryTreeImpl root = new BinaryTreeImpl(array[0]);
        queue.offer(root);
        int index = 0;
        while (!queue.isEmpty()) {
            BinaryTreeImpl node = queue.poll();
            if (++index < array.length && array[index] != C.NLF) { // 注意此处的 ++index < array.length
                node.left = new BinaryTreeImpl(array[index]);
                queue.offer(node.left);
            }
            if (++index < array.length && array[index] != C.NLF) { // // 注意此处的 ++index < array.length
                node.right = new BinaryTreeImpl(array[index]);
                queue.offer(node.right);
            }
        }
        return root;
    }

    public BinaryTreeImpl Met1hod_Recursive(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return levelRecurse(new BinaryTreeImpl(array[0]), array, 1);
    }

    public BinaryTreeImpl levelRecurse(BinaryTreeImpl root, int[] array, int index) {
        if (index >= array.length) {
            return null;
        }
        if (array[index] == C.NLF) {
            return null;
        }
        BinaryTreeImpl leftChild = new BinaryTreeImpl();
        BinaryTreeImpl rightChild = new BinaryTreeImpl();
      /*  int leftIndex = ++index;
        int rightIndex = ++index;*/
        root.value = array[index];
        root.left = levelRecurse(leftChild, array, ++index);
        root.right = levelRecurse(rightChild, array, ++index);
        return root;
    }
}