package DataStructure.tree.binaryTree.binaryTree2Array;

import Common.Constant.C;
import Common.Utils.UTFactory;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import org.junit.Test;

import java.util.*;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/14 12:09
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 中序 遍历二叉树 输出数组【递归、单栈】
 * @blogURL
 */
public class BT2ArrayByInOrder {

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

    // 中序 遍历二叉树 输出数组
    public int[] Method(BinaryTreeImpl root) {
        if (root == null) {
            return null;
        }
        Stack<BinaryTreeImpl> stack = new Stack();
        List<Integer> list = new ArrayList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryTreeImpl node = stack.pop();
            while (node.left != null) {
                stack.push(node);
                node = node.left;
            }
            list.add(node.value);
        }
        int[] answer = list.stream().mapToInt(x -> x).toArray();
        return answer;
    }

    public int[] Method_Recursive(BinaryTreeImpl root) {
        if (root == null) {
            return null;
        }
        // 是否输出带 叶子符号的数组 NLF = NullLeafSymbol:表示空叶子结点
        boolean withNLF = false;
        List<Integer> list = new ArrayList<>();
        roll(root, list, withNLF);
        int[] answer = list.stream().mapToInt(x -> x).toArray();
        return answer;
    }

    public void roll(BinaryTreeImpl node, List<Integer> list, boolean withNLF) {
        if (node == null) {
            if (withNLF) {
                list.add(C.NLF);
            }
            return;
        }
        roll(node.left, list, withNLF);
        list.add(node.value);
        roll(node.right, list, withNLF);
    }
}
