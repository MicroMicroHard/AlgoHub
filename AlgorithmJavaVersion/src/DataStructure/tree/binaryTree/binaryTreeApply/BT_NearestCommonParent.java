package DataStructure.tree.binaryTree.binaryTreeApply;

import DataStructure.tree.binaryTree.BinaryTreeImpl;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-3-23 02:54:10
 * @author-Email micromicrohard@outlook.com
 * @description 查找最近公共父节点/最近公共祖先
 * 思路一
 * 思路二
 * @URL
 */
public class BT_NearestCommonParent {

    //思路一 todo
    public BinaryTreeImpl findNCP(BinaryTreeImpl root, int x1, int x2) {
        if (root == null || x1 == root.value || x2 == root.value) return root;
        BinaryTreeImpl leftNode = findNCP(root.left, x1, x2);
        BinaryTreeImpl rightNode = findNCP(root.right, x1, x2);
        if (leftNode != null && rightNode != null) {
            return root;
        }
        return leftNode == null ? rightNode : leftNode;

       /* if (root == null) {
            return null;
        }
        if (root.value == x1 || root.value == x2) {
            return root;
        }
        BinaryTreeImpl leftNode = findNCP(root.left, x1, x2);
        BinaryTreeImpl rightNode = findNCP(root.right, x1, x2);
        if (leftNode != null && rightNode != null) {
            return root;
        }
        return leftNode == null ? rightNode : leftNode;*/
    }

    public BinaryTreeImpl findNCP1(BinaryTreeImpl root, int x1, int x2) {
        if (root == null) {
            return null;
        }
        if (root.value == x1 || root.value == x2) {
            return findx(root, x1) && findx(root, x2) ? root : null;
        }
        BinaryTreeImpl left = findNCP(root.left, x1, x2);
        BinaryTreeImpl right = findNCP(root.right, x1, x2);
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    //单节点查找值
    public boolean findx(BinaryTreeImpl root, int x) {
        if (null == root) {
            return false;
        }
        if (root.value == x) {
            return true;
        }
        return findx(root.left, x) || findx(root.right, x);
    }
}
