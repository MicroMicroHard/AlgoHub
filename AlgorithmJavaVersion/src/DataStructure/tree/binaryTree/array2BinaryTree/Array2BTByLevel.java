package DataStructure.tree.binaryTree.array2BinaryTree;

import Common.Constant.C;
import Common.Utils.UTFactory;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/14 12:13
 * @author-Email micromicrohard@outlook.com
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
        String input = "{1,2,NLF,NLF, 3,NLF, NLF}";
        String output = "{1,2,NLF,3,NLF,NLF, NLF}";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    public BinaryTreeImpl Met1hod_Queue(int[] array) {
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

    // todo Method_Recursive
}
