package DataStructure.tree.binaryTree.binaryTree2Array;

import Common.Constant.C;
import Common.Utils.UTFactory;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/14 12:09
 * @author-Email micromicrohard@outlook.com
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
        String input = "{1, 2, NLF, 3, NLF, NLF, NLF}";
        String output = "{1, 2, NLF, 3, NLF, NLF, NLF}";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    // 先序 遍历二叉树 输出数组【单栈】
    public int[] Method_Stack(BinaryTreeImpl root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeImpl> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                list.add(root.value);
                root = root.left;
            }
            if (C.WithNLF) {
                list.add(C.NLF);
            }
            //attention: 为什么不需要判断stack.isEmpty()？因为while内仅有此处在pop，每次pop完都会被while循环判断一次
            root = stack.pop().right;
        }
        if (C.WithNLF) {
            list.add(C.NLF);// 补上最后一个节点的右孩子(空叶子节点)
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

    public int[] Method_Stack2(BinaryTreeImpl root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeImpl> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) { // 递归的stack表示
            if (root == null) {
                if (C.WithNLF) {
                    list.add(C.NLF);
                }
                root = stack.pop();
                continue;
            }
            list.add(root.value);
            stack.push(root.right);
            stack.push(root.left);
            root = stack.pop();
        }
        if (C.WithNLF) {
            list.add(C.NLF); // 补上最后一个节点的右孩子(空叶子节点)
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

    // 先序 遍历二叉树 输出数组【递归】
    public int[] Method_Recursive(BinaryTreeImpl root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        roll(root, list);
        return list.stream().mapToInt(x -> x).toArray();
    }

    public void roll(BinaryTreeImpl node, List<Integer> list) {
        if (node == null) {
            if (C.WithNLF) {
                list.add(C.NLF);
            }
            return;
        }
        list.add(node.value);
        roll(node.left, list);
        roll(node.right, list);
    }
}
