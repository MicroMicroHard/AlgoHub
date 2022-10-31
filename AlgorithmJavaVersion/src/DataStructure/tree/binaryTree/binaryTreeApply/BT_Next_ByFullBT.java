package DataStructure.tree.binaryTree.binaryTreeApply;

import DataStructure.tree.binaryTree.BinaryTreeImpl;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-7-21 10:57:09
 * @author-Email micromicrohard@outlook.com
 * @description 填充节点
 * 填充每个节点的下一个右侧节点指针 题目见链接
 * @blogURL https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */

public class BT_Next_ByFullBT {

    public BinaryTreeImpl connect(BinaryTreeImpl root) {
        if (root == null) {
            return root;
        }
        BinaryTreeImpl cur = root;
        while (cur != null) {
            BinaryTreeImpl head = cur;
            // leftmost向下移动
            while (cur != null) {
                // head向左移动
                if (cur.left != null) {
                    cur.left = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right = cur.next.left;
                }
                cur = cur.next;
            }
            cur = head.left;
        }
        return root;
    }
}