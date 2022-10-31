package DataStructure.tree.binaryTree.binaryTreeApply;

import DataStructure.tree.binaryTree.BinaryTreeImpl;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-7-21 10:57:09
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 填充节点【非满二叉树】
 * 填充每个节点的下一个右侧节点指针 题目见链接
 * @blogURL https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */

public class BT_Next {

    public BinaryTreeImpl connect(BinaryTreeImpl root) {
        if (root == null) {
            return root;
        }
        BinaryTreeImpl cur = root;
        BinaryTreeImpl head = null;
        BinaryTreeImpl pre = null;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (head == null) {
                        head = cur.left;
                        pre = cur.left;
                    } else {
                        pre.next = cur.left;
                        pre = pre.next;
                    }
                }
                if (cur.right != null) {
                    if (head == null) {
                        head = cur.right;
                        pre = cur.right;
                    } else {
                        pre.next = cur.right;
                        pre = pre.next;
                    }
                }
                cur = cur.next;
            }
            cur = head;
            head = null;
            pre = null;
        }
        return root;
    }
}