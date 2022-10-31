package DataStructure.tree.binaryTree.binaryTree2Array;

import Common.Constant.C;
import Common.Utils.UTFactory;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import jdk.nashorn.internal.ir.EmptyNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/14 12:12
 * @author-Email micromicrohard@outlook.com
 * @description 1、按行打印二叉树 【按层输出遍历的数组】
 * 2、按层遍历二叉树 输出数组
 * @blogURL
 */
public class BT2ArrayByLevel {

    @Test // 验证功能：从数据库获取测试数据，用于单元测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误的测试案例
    public void DoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    // 2、按层遍历二叉树 输出数组
    public int[] Method_ByLevel(BinaryTreeImpl root) {
        if (root == null) {
            return new int[]{};
        }
        Queue<BinaryTreeImpl> queue = new LinkedList<>();
        List<BinaryTreeImpl> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeImpl node = queue.poll();
            if (node == null) {
                if (C.WithNLF) {
                    list.add(new BinaryTreeImpl(C.NLF));
                }
                continue;
            } else {
                list.add(node);
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return list.stream().mapToInt(x -> x.value).toArray();
    }

    // 1、按行打印二叉树
    public void PrintLevel(BinaryTreeImpl root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeImpl> queue = new LinkedList<>();
        queue.offer(root);
        BinaryTreeImpl front = root;
        BinaryTreeImpl cur = root;
        while (!queue.isEmpty()) {
            BinaryTreeImpl node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null) {
                cur = node.left;
                queue.offer(node.left);
            }
            if (node.right != null) {
                cur = node.right;
                queue.offer(node.right);
            }
            if (node == front) {
                front = cur;
                System.out.println();
            }
        }
    }
}
