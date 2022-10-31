package DataStructure.tree.binaryTree;

import Common.Utils.ArrayTools;
import DataStructure.tree.binaryTree.array2BinaryTree.Array2BTByPreOrder;
import DataStructure.tree.binaryTree.binaryTree2Array.BT2ArrayByPreOrder;

/**
 * @author liujun
 * @date 2020-02-18 16:09
 * 二叉树 ： 判断两个二叉树相等
 */

public class BinaryTreeImpl implements BinaryTree {

    public BinaryTreeImpl left;    //左孩子
    public BinaryTreeImpl right;   //右孩子
    public BinaryTreeImpl parent;  //父节点
    public BinaryTreeImpl next;    //横向节点
    public int value = 0;          //值
    public static int count = 0;   //层计数值

    public BinaryTreeImpl() {
        this.left = null;
        this.right = null;
        this.parent = null;
        this.value = 0;
    }

    public BinaryTreeImpl(int value) {
        this.left = null;
        this.right = null;
        this.parent = null;
        this.value = value;
    }

    //判断两个二叉树相等
    public boolean equals(BinaryTreeImpl source, BinaryTreeImpl target) {

        if (source == null) {
            return target == null;
        }
        if (target != null) {
            if (source.value != target.value) {
                return false;
            } else {
                return equals(source.left, target.left) && equals(source.right, target.right);
            }
        }
        return false;
    }

    public boolean equals(BinaryTreeImpl target) {
        return equals(this, target);
    }

    public void bind(BinaryTreeImpl root, BinaryTreeImpl left, BinaryTreeImpl right, BinaryTreeImpl parent) {
        root.left = left;
        root.right = right;
        root.parent = parent;
    }

    public void bind(BinaryTreeImpl left, BinaryTreeImpl right, BinaryTreeImpl parent) {
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public void bind(BinaryTreeImpl left, BinaryTreeImpl right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int[] serialize(BinaryTreeImpl root) {
        BT2ArrayByPreOrder tools = new BT2ArrayByPreOrder();
        int[] answer = tools.Method(root);
        return answer;
    }

    @Override
    public BinaryTreeImpl deserialization(int[] array) {
        Array2BTByPreOrder tools = new Array2BTByPreOrder();
        return tools.Method(array);
    }

    public void print() {
        ArrayTools.printIntArray(serialize(this));
    }
}
