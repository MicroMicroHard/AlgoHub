package DataStructure.tree.binaryTree.binaryTree2Array;

import Common.Utils.UTFactory;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/14 12:12
 * @author-Email micromicrohard@outlook.com
 * @description S形遍历二叉树 输出数组（栈）
 * @blogURL
 */
public class BT2ArrayBySLevel {

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

    public int[] Method(BinaryTreeImpl root) {
        if (root == null) {
            return new int[]{};
        }
        Stack<BinaryTreeImpl> stack_left = new Stack<>();
        Stack<BinaryTreeImpl> stack_right = new Stack<>();
        stack_left.push(root);
        List<BinaryTreeImpl> list = new ArrayList<>();
        boolean flag = false; // 控制左右打印的标识
        while (!stack_left.isEmpty()) {
            while (!stack_left.isEmpty()) {
                BinaryTreeImpl node = stack_left.pop();
                list.add(node);
                if (flag) {
                    if (node.left != null) {
                        stack_right.push(node.left);
                    }
                    if (node.right != null) {
                        stack_right.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        stack_right.push(node.right);
                    }
                    if (node.left != null) {
                        stack_right.push(node.left);
                    }
                }
            }
            stack_left = stack_right;
            stack_right = new Stack<>();
            flag = !flag;
        }
        return list.stream().mapToInt(x -> x.value).toArray();
    }
}
