package DataStructure.tree.binaryTree.binaryTreeApply;

import DataStructure.tree.binaryTree.BinaryTreeImpl;

import java.util.Map;
import java.util.Stack;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/8/19
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 判断平衡二叉树
 */
public class BT_BalanceJudge {

    BT_MaxDepth bt = new BT_MaxDepth();

    //判断二叉树的左右孩子 深度差是否为 1
    public boolean judgeBalanceMethod_Stack(BinaryTreeImpl root) {
        if (root == null) {
            //注意此处为true，不是false
            return true;
        }
        bt.getBiggestDepthMethod(root);
        Map<BinaryTreeImpl, Integer> map = bt.statisticsMap;
        Stack<BinaryTreeImpl> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            BinaryTreeImpl tempRoot = stack.pop();
            int gap = Math.abs(map.getOrDefault(tempRoot.left, 0) - map.getOrDefault(tempRoot.right, 0));
            if (gap > 1) {
                return false;
            }
            if (tempRoot.left != null) {
                stack.push(tempRoot.left);
            }
            if (tempRoot.right != null) {
                stack.push(tempRoot.right);
            }
        }
        return true;
    }

    public boolean judgeBalanceMethod(BinaryTreeImpl root) {
        if (root == null) {
            //注意此处为true，不是false
            return true;
        }
        int left = bt.getBiggestDepthMethod(root.left);
        int right = bt.getBiggestDepthMethod(root.right);
        int gap = Math.abs(left - right);
        if (gap > 1) {
            return false;
        }
        // 因为已经限定 gap <= 1，所以此处不需要考虑 root.left == null && root.right == null 的交叉情况
        if (root.left != null && root.right != null) {
            return judgeBalanceMethod(root.left) && judgeBalanceMethod(root.right);
        }
        return true;
    }
}
