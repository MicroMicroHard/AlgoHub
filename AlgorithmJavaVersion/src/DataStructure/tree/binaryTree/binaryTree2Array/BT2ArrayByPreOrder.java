package DataStructure.tree.binaryTree.binaryTree2Array;

import Common.Constant.C;
import Common.Utils.UTFactory;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/14 12:09
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 先序 遍历二叉树 输出数组【递归、单栈】
 * @blogURL
 */
public class BT2ArrayByPreOrder {

    @Test // 验证功能：从数据库获取测试数据，用于单元测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误的测试案例
    public void DoubleTrack() throws Exception {
        String input = "{1, 2, 3, 4, 5, 6, 7, 8, NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF}";
        String output = "{1, 2, 3, 4, 5, 6, 7, 8, NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF}";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    // 默认带 空叶子 Symbol符号
    boolean withSymbol = true;

    // 先序 遍历二叉树 输出数组【单栈】
    public int[] Method(BinaryTreeImpl root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeImpl> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (root != null) {
                list.add(root.value);
                stack.push(root.left);
                root = root.left;
            }
            list.add(C.NLF);
            // stack.pop().right 需要检查 stack.isEmpty() 和 stack.peek() == null
            while (!stack.isEmpty() && stack.peek() == null) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                root = stack.pop().right;
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

    public int[] Met1hod2(BinaryTreeImpl root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeImpl> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) { // 递归的stack表示
            list.add(root.value);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
            root = stack.pop();
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

    // 先序 遍历二叉树 输出数组【递归】
    public int[] Met1hod_Recursive(BinaryTreeImpl root) {
        if (root == null) {
            return null;
        }
        return null;
    }
}
