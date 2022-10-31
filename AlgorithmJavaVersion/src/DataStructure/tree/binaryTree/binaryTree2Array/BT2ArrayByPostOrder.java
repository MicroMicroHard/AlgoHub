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
 * @description 后序 遍历二叉树 输出数组
 * 递归写法
 * 单栈法
 * 双栈法
 * @blogURL
 */
public class BT2ArrayByPostOrder {

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

    // 后序 遍历二叉树 输出数组【单栈法】
    public int[] Meth1od_Stack(BinaryTreeImpl root) {
        if (root == null) {
            return new int[]{};
        }
        Stack<BinaryTreeImpl> stack = new Stack<>();
        stack.push(root);
        BinaryTreeImpl cur = null;
        BinaryTreeImpl pre = root;
        List<BinaryTreeImpl> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (cur.left != null && pre != cur.left && pre != cur.right) {
                stack.push(cur.left);
            } else if (cur.right != null && pre != cur.right) {
                stack.push(cur.right);
            } else {
                list.add(stack.pop());
                pre = cur;
            }
        }
        return list.stream().mapToInt(x -> x.value).toArray();
    }

    // 后序 遍历二叉树 输出数组【双栈法】
    public int[] Method_DoubleStack(BinaryTreeImpl root) {
        if (root == null) {
            return new int[]{};
        }
        Stack<BinaryTreeImpl> stack = new Stack<>();
        Stack<BinaryTreeImpl> stack_back = new Stack<>(); // 用于倒序存储访问节点，达到后续遍历的方式
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeImpl node = stack.pop();
            if (node == null) {
                if (C.WithNLF) {
                    stack_back.push(new BinaryTreeImpl(C.NLF));
                }
                continue;
            }
            stack_back.push(node);
            stack.push(node.left);
            stack.push(node.right);
        }
        // 整理输出
        int cap = stack_back.size();
        int[] answer = new int[cap];
        for (int i = 0; i < cap; i++) {
            BinaryTreeImpl node = stack_back.pop();
            answer[i] = node.value;
        }
        return answer;
    }

    // 后序 遍历二叉树 输出数组【递归写法】
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
        roll(node.left, list);
        roll(node.right, list);
        list.add(node.value);
    }
}
