package Common.Utils.GC.binaryTreeImpl;

import DataStructure.tree.Tree;
import DataStructure.tree.binaryTree.BinaryTreeImpl;

/**
 * @author 蔚蔚樱
 * @date 2020-02-18 16:09
 * @description 二叉树的实现（二叉树反序列化）
 * 单序创建：
 * 1.1、将按层次遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】
 * 特殊符号:
 * 2.1、将按先序遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】
 * 2.2、将按中序遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】
 * 2.3、将按后序遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】
 * 完全二叉树:
 * 2.1、将一个完全二叉树的数组 构造成一个二叉树【递归、非递归解法】
 * 多序创建：
 * 4.1、已知前序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。【递归、非递归解法】
 * 4.2、已知后序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。【递归、非递归解法】
 */
public interface Array2BinaryTree extends Tree {

    //1.1、将按层次遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】:按行构造二叉树，只能是满二叉树的数组才可以
    BinaryTreeImpl array2BTByLevel(int[] array, boolean recursive);

    //2.1、将按先序遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】
    BinaryTreeImpl array2BTByPreOrder(int[] array, boolean recursive);

    //2.2、将按中序遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】
    BinaryTreeImpl array2BTByInOrder(int[] array, boolean recursive);

    //2.3、将按后序遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】
    BinaryTreeImpl array2BTByPostOrder(int[] array, boolean recursive);

    //3.1、将一个完全二叉树的数组 构造成一个二叉树【递归、非递归解法】
    BinaryTreeImpl array2FullBT(int[] array, boolean recursive);

    //4.1、已知前序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。【递归、非递归解法】
    BinaryTreeImpl array2BTByPre_InOrder(int[] PreOrderArray, int[] InOrderArray, boolean recursive);

    //4.2、已知后序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。【递归、非递归解法】
    BinaryTreeImpl array2BTByPost_InOrder(int[] PostOrderArray, int[] InOrderArray, boolean recursive);

    default boolean check(int[] array) {
        return array != null && array.length != 0;
    }
}
