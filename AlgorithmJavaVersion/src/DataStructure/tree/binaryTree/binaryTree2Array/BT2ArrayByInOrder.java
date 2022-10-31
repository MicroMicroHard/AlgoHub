package DataStructure.tree.binaryTree.binaryTree2Array;

import Common.Constant.C;
import Common.Utils.UTFactory;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import org.junit.Test;

import java.util.*;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/14 12:09
 * @author-Email micromicrohard@outlook.com
 * @description 中序 遍历二叉树 输出数组【递归、单栈】
 * @blogURL
 * @attention 二叉树的叶子和节点的关系：
 * 对于任意一棵二叉树，如果2度的节点数有 n2 个，则叶子数 n0 必定为 n2+1 (n0=n2+1)
 * 从节点发散分支的角度：总的分支数量 = 0*n0 + 1*n1 + 2*n2
 * 从分支对应节点的角度：总的分支数量 = n0 + n1 + n2 - 1 【-1是因为root节点没有向上对应的分支】
 * 又因为二叉树的n1 = 0,所以 n0 = n2 + 1
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
    public int[] Method_Stack(BinaryTreeImpl root) {
        if (root == null) {
            return new int[]{};
        }
        Stack<BinaryTreeImpl> stack = new Stack();
        List<Integer> list = new ArrayList<>();
        BinaryTreeImpl node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (C.WithNLF) {
                list.add(C.NLF);
            }
            //attention: 为什么不需要判断stack.isEmpty()？因为while内仅有此处在pop，每次pop完都会被while循环判断一次
            node = stack.pop();
            list.add(node.value);
            node = node.right;
        }
        if (C.WithNLF) { // 补上最后一个节点的空指针
            list.add(C.NLF);
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

    public int[] Method_Recursive(BinaryTreeImpl root) {
        if (root == null) {
            return new int[]{};
        }
        // 是否输出带 叶子符号的数组 NLF = NullLeafSymbol:表示空叶子结点
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
        list.add(node.value);
        roll(node.right, list);
    }
}
