package DataStructure.tree.binaryTree.binaryTreeApply;

import DataStructure.tree.binaryTree.BinaryTreeImpl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/8/19
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 * @description 662. 二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。
 * 这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 */
public class BT_MaxBroad {

    public int GetMaxBroadMethod(BinaryTreeImpl root) {
        if (root == null) {
            return 0;
        }
        Deque<BinaryTreeImpl> queue = new ArrayDeque<>();
        queue.offerLast(root);
        //root.value = 100; 不受root值影响，后续计算出来的是相对值
        int maxBroad = 0;
        while (!queue.isEmpty()) {
            int width = queue.size();
            int broad = queue.getLast().value - queue.getFirst().value + 1;
            for (int i = 0; i < width; i++) {
                BinaryTreeImpl node = queue.pollFirst();
                if (node.left != null) {
                    node.left.value = 2 * node.value + 1;
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    node.right.value = 2 * node.value + 2;
                    queue.offerLast(node.right);
                }
            }
            if (broad > maxBroad) {
                maxBroad = broad;
            }
        }
        return maxBroad;
    }
}
