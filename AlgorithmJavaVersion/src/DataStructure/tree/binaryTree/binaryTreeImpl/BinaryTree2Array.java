package DataStructure.tree.binaryTree.binaryTreeImpl;

import DataStructure.tree.Tree;
import DataStructure.tree.binaryTree.BinaryTreeImpl;

/**
 * @author 蔚蔚樱
 * @date 2020-02-18 18:44
 * @description 根据二叉树 创建（二叉树序列化）
 * 按层：
 * 1、按层遍历二叉树 输出数组
 * S形：
 * 1、S形遍历二叉树 输出数组
 * 按序：
 * 1、先序遍历二叉树 输出数组
 * 2、中序遍历二叉树 输出数组
 * 3、后序遍历二叉树 输出数组
 * <p>
 * 说明
 * withSymbol==true 表示用特殊符号【Constant.NullLeafSymbol】来表示叶子节点的左右孩子
 * recursive==true  表示递归方式
 */
public interface BinaryTree2Array extends Tree {
    //按层遍历二叉树 输出数组
    int[] BT2ArrayByLevelOutput(BinaryTreeImpl root);

    //按行打印二叉树
    void BT2ArrayByLevelPrint(BinaryTreeImpl root);

    //S形遍历二叉树 输出数组
    int[] BT2ArrayBySPrint(BinaryTreeImpl root);

    //先序 遍历二叉树 输出数组【递归、单栈】
    int[] BT2ArrayByPreOrder(BinaryTreeImpl root, boolean withSymbol, boolean recursive);

    //中序 遍历二叉树 输出数组【递归、单栈】
    int[] BT2ArrayByInOrder(BinaryTreeImpl root, boolean withSymbol, boolean recursive);

    //后序 遍历二叉树 输出数组【递归写法、单栈法 双栈法】
    int[] BT2ArrayByPostOrder(BinaryTreeImpl root, boolean withSymbol, boolean recursive);
}

