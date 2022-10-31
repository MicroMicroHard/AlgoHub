package DataStructure.tree.binaryTree.binaryTreeApply;

import DataStructure.tree.binaryTree.BinaryTreeImpl;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 蔚蔚樱
 * @date 2020-02-20 10:17
 * @description 反转二叉树
 * 将二叉树 进行镜像操作
 */

//BinaryTreeReversal
public class BT_MirrorOperation extends BinaryTreeImpl {

    //递归
    public BinaryTreeImpl MirrorMethod(BinaryTreeImpl root) {
        if (root == null) {
            return null;
        }
        //exchange left child and right child
        BinaryTreeImpl binaryTree = root.left;
        root.left = root.right;
        root.right = binaryTree;

        //mirror left child and right child
        MirrorMethod(root.left);
        MirrorMethod(root.right);
        return root;
    }

    //非递归
    public BinaryTreeImpl MirrorMethod_Stack(BinaryTreeImpl root) {
        if (root == null) {
            return null;
        }
        Queue<BinaryTreeImpl> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeImpl node = q.poll();
            // 交换
            BinaryTreeImpl binaryTree = node.left;
            node.left = node.right;
            node.right = binaryTree;

            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return root;
    }
}
