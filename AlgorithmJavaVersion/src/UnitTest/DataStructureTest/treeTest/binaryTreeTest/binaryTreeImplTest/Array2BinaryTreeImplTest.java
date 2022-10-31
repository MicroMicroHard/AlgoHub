package UnitTest.DataStructureTest.treeTest.binaryTreeTest.binaryTreeImplTest;


import DataStructure.tree.binaryTree.binaryTreeImpl.Array2BinaryTreeImpl;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import UnitTest.DataStructureTest.treeTest.binaryTreeTest.binaryTreeTestData.BT_TestData_Tree;
import DataStructure.tree.binaryTree.binaryTreeImpl.Array2BinaryTree;
import org.junit.Test;

/*
 * @author 蔚蔚樱
 * @date 2020-02-18 16:42
 * @description 二叉树的实现 测试案例
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


public class Array2BinaryTreeImplTest extends BT_TestData_Tree {

    Array2BinaryTree instance = new Array2BinaryTreeImpl();

    //1.1、将按层次遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】
    @Test
    public void TestArray2BTByLevel() {
        BinaryTreeImpl answer = instance.array2BTByLevel(Array_BT_Full_Level_WithNLF_1, false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_1());

        answer = instance.array2BTByLevel(Array_BT_Level_WithNLF_2, false);
        assert answer.equals(Tree_BT_Level_WithNLF_2());
        answer = instance.array2BTByLevel(Array_BT_Level_WithNLF_3, false);
        assert answer.equals(Tree_BT_Level_WithNLF_3());
        answer = instance.array2BTByLevel(Array_BT_Level_WithNLF_4, false);
        assert answer.equals(Tree_BT_Level_WithNLF_4());
        answer = instance.array2BTByLevel(Array_BT_Level_WithNLF_5, false);
        assert answer.equals(Tree_BT_Level_WithNLF_5());
        answer = instance.array2BTByLevel(Array_BT_Level_WithNLF_6, false);
        assert answer.equals(Tree_BT_Level_WithNLF_6());
        answer = instance.array2BTByLevel(Array_BT_Level_WithNLF_7, false);
        assert answer.equals(Tree_BT_Level_WithNLF_7());
        answer = instance.array2BTByLevel(Array_BT_Level_WithNLF_8, false);
        assert answer.equals(Tree_BT_Level_WithNLF_8());
    }

    //2.1、将按先序遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】
    @Test
    public void TestArray2BTByPreOrder() {
        BinaryTreeImpl answer = instance.array2BTByPreOrder(Array_BT_Full_Level_WithNLF_1_PreOrder, false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_1());
        answer = instance.array2BTByPreOrder(Array_BT_Full_Level_WithNLF_2_PreOrder, false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_2());
        answer = instance.array2BTByPreOrder(Array_BT_Full_Level_WithNLF_3_PreOrder, false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_3());
        answer = instance.array2BTByPreOrder(Array_BT_Full_Level_WithNLF_4_PreOrder, false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_4());

        answer = instance.array2BTByPreOrder(Array_BT_Level_WithNLF_2_PreOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_2());
        answer = instance.array2BTByPreOrder(Array_BT_Level_WithNLF_3_PreOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_3());
        answer = instance.array2BTByPreOrder(Array_BT_Level_WithNLF_4_PreOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_4());
        answer = instance.array2BTByPreOrder(Array_BT_Level_WithNLF_5_PreOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_5());
        answer = instance.array2BTByPreOrder(Array_BT_Level_WithNLF_6_PreOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_6());
        answer = instance.array2BTByPreOrder(Array_BT_Level_WithNLF_7_PreOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_7());
        answer = instance.array2BTByPreOrder(Array_BT_Level_WithNLF_8_PreOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_8());
        answer = instance.array2BTByPreOrder(Array_BT_Level_WithNLF_9_PreOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_9());
    }

    //2.2、将按中序遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】
    @Test
    public void TestArray2BTByInOrder() {
        BinaryTreeImpl answer = instance.array2BTByInOrder(Array_BT_Full_Level_WithNLF_1_InOrder, false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_1());
        answer = instance.array2BTByInOrder(Array_BT_Full_Level_WithNLF_2_InOrder, false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_2());
        answer = instance.array2BTByInOrder(Array_BT_Full_Level_WithNLF_3_InOrder, false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_3());

        answer = instance.array2BTByInOrder(Array_BT_Level_WithNLF_2_InOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_2());
        answer = instance.array2BTByInOrder(Array_BT_Level_WithNLF_3_InOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_3());
        answer = instance.array2BTByInOrder(Array_BT_Level_WithNLF_4_InOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_4());
        answer = instance.array2BTByInOrder(Array_BT_Level_WithNLF_5_InOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_5());
        answer = instance.array2BTByInOrder(Array_BT_Level_WithNLF_6_InOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_6());
        answer = instance.array2BTByInOrder(Array_BT_Level_WithNLF_7_InOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_7());
        answer = instance.array2BTByInOrder(Array_BT_Level_WithNLF_8_InOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_8());

    }


    //2.3、将按后序遍历的方式输入的数组  构造成一个二叉树（特殊符号）【递归、非递归解法】
    @Test
    public void TestCreateBTByPostOrderRecursive() {
        BinaryTreeImpl answer = instance.array2BTByPostOrder(Array_BT_Full_Level_WithNLF_1_PostOrder, false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_1());
        answer = instance.array2BTByPostOrder(Array_BT_Full_Level_WithNLF_2_PostOrder, false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_2());
        answer = instance.array2BTByPostOrder(Array_BT_Full_Level_WithNLF_3_PostOrder, false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_3());

        answer = instance.array2BTByPostOrder(Array_BT_Level_WithNLF_2_PostOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_2());
        answer = instance.array2BTByPostOrder(Array_BT_Level_WithNLF_3_PostOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_3());
        answer = instance.array2BTByPostOrder(Array_BT_Level_WithNLF_4_PostOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_4());
        answer = instance.array2BTByPostOrder(Array_BT_Level_WithNLF_5_PostOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_5());
        answer = instance.array2BTByPostOrder(Array_BT_Level_WithNLF_6_PostOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_6());
        answer = instance.array2BTByPostOrder(Array_BT_Level_WithNLF_7_PostOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_7());
        answer = instance.array2BTByPostOrder(Array_BT_Level_WithNLF_8_PostOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_8());
        answer = instance.array2BTByPostOrder(Array_BT_Level_WithNLF_9_PostOrder, false);
        assert answer.equals(Tree_BT_Level_WithNLF_9());
    }

    //3.1、将一个完全二叉树的数组 构造成一个二叉树【递归、非递归解法】
    @Test
    public void TestCreateFullBTNoRecursive() {
        BinaryTreeImpl answer = instance.array2FullBT(Array_BT_Full_Level_1, false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_1());
        answer = instance.array2FullBT(Array_BT_Full_Level_2, false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_2());
        answer = instance.array2FullBT(Array_BT_Full_Level_3, false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_3());
    }

    //4.1、已知前序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。【递归、非递归解法】
    @Test
    public void TestCreateBTByPre_InOrderRecursive() {
        BinaryTreeImpl answer = instance.array2BTByPre_InOrder(ReduceNLF(Array_BT_Full_Level_WithNLF_1_PreOrder), ReduceNLF(Array_BT_Full_Level_WithNLF_1_InOrder), false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_1());
        answer = instance.array2BTByPre_InOrder(ReduceNLF(Array_BT_Full_Level_WithNLF_2_PreOrder), ReduceNLF(Array_BT_Full_Level_WithNLF_2_InOrder), false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_2());
        answer = instance.array2BTByPre_InOrder(ReduceNLF(Array_BT_Full_Level_WithNLF_3_PreOrder), ReduceNLF(Array_BT_Full_Level_WithNLF_3_InOrder), false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_3());
        answer = instance.array2BTByPre_InOrder(ReduceNLF(Array_BT_Full_Level_WithNLF_4_PreOrder), ReduceNLF(Array_BT_Full_Level_WithNLF_4_InOrder), false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_4());

        answer = instance.array2BTByPre_InOrder(ReduceNLF(Array_BT_Level_WithNLF_2_PreOrder), ReduceNLF(Array_BT_Level_WithNLF_2_InOrder), false);
        assert answer.equals(Tree_BT_Level_WithNLF_2());
        answer = instance.array2BTByPre_InOrder(ReduceNLF(Array_BT_Level_WithNLF_3_PreOrder), ReduceNLF(Array_BT_Level_WithNLF_3_InOrder), false);
        assert answer.equals(Tree_BT_Level_WithNLF_3());
        answer = instance.array2BTByPre_InOrder(ReduceNLF(Array_BT_Level_WithNLF_4_PreOrder), ReduceNLF(Array_BT_Level_WithNLF_4_InOrder), false);
        assert answer.equals(Tree_BT_Level_WithNLF_4());
        answer = instance.array2BTByPre_InOrder(ReduceNLF(Array_BT_Level_WithNLF_5_PreOrder), ReduceNLF(Array_BT_Level_WithNLF_5_InOrder), false);
        assert answer.equals(Tree_BT_Level_WithNLF_5());
        answer = instance.array2BTByPre_InOrder(ReduceNLF(Array_BT_Level_WithNLF_6_PreOrder), ReduceNLF(Array_BT_Level_WithNLF_6_InOrder), false);
        assert answer.equals(Tree_BT_Level_WithNLF_6());
        answer = instance.array2BTByPre_InOrder(ReduceNLF(Array_BT_Level_WithNLF_7_PreOrder), ReduceNLF(Array_BT_Level_WithNLF_7_InOrder), false);
        assert answer.equals(Tree_BT_Level_WithNLF_7());
        answer = instance.array2BTByPre_InOrder(ReduceNLF(Array_BT_Level_WithNLF_8_PreOrder), ReduceNLF(Array_BT_Level_WithNLF_8_InOrder), false);
        assert answer.equals(Tree_BT_Level_WithNLF_8());
        answer = instance.array2BTByPre_InOrder(ReduceNLF(Array_BT_Level_WithNLF_9_PreOrder), ReduceNLF(Array_BT_Level_WithNLF_9_InOrder), false);
        assert answer.equals(Tree_BT_Level_WithNLF_9());
    }

    @Test
    public void TestCreateBTByPre_InOrderNonRecursive() {
    }

    //4.2、已知后序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。【递归、非递归解法】
    @Test
    public void TestCreateBTPost_InOrderRecursive() {
        BinaryTreeImpl answer = instance.array2BTByPost_InOrder(ReduceNLF(Array_BT_Full_Level_WithNLF_1_PostOrder), ReduceNLF(Array_BT_Full_Level_WithNLF_1_InOrder), false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_1());
        answer = instance.array2BTByPost_InOrder(ReduceNLF(Array_BT_Full_Level_WithNLF_2_PostOrder), ReduceNLF(Array_BT_Full_Level_WithNLF_2_InOrder), false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_2());
        answer = instance.array2BTByPost_InOrder(ReduceNLF(Array_BT_Full_Level_WithNLF_3_PostOrder), ReduceNLF(Array_BT_Full_Level_WithNLF_3_InOrder), false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_3());
        answer = instance.array2BTByPost_InOrder(ReduceNLF(Array_BT_Full_Level_WithNLF_4_PostOrder), ReduceNLF(Array_BT_Full_Level_WithNLF_4_InOrder), false);
        assert answer.equals(Tree_BT_Full_Level_WithNLF_4());

        answer = instance.array2BTByPost_InOrder(ReduceNLF(Array_BT_Level_WithNLF_2_PostOrder), ReduceNLF(Array_BT_Level_WithNLF_2_InOrder), false);
        assert answer.equals(Tree_BT_Level_WithNLF_2());
        answer = instance.array2BTByPost_InOrder(ReduceNLF(Array_BT_Level_WithNLF_3_PostOrder), ReduceNLF(Array_BT_Level_WithNLF_3_InOrder), false);
        assert answer.equals(Tree_BT_Level_WithNLF_3());
        answer = instance.array2BTByPost_InOrder(ReduceNLF(Array_BT_Level_WithNLF_4_PostOrder), ReduceNLF(Array_BT_Level_WithNLF_4_InOrder), false);
        assert answer.equals(Tree_BT_Level_WithNLF_4());
        answer = instance.array2BTByPost_InOrder(ReduceNLF(Array_BT_Level_WithNLF_5_PostOrder), ReduceNLF(Array_BT_Level_WithNLF_5_InOrder), false);
        assert answer.equals(Tree_BT_Level_WithNLF_5());
        answer = instance.array2BTByPost_InOrder(ReduceNLF(Array_BT_Level_WithNLF_6_PostOrder), ReduceNLF(Array_BT_Level_WithNLF_6_InOrder), false);
        assert answer.equals(Tree_BT_Level_WithNLF_6());
        answer = instance.array2BTByPost_InOrder(ReduceNLF(Array_BT_Level_WithNLF_7_PostOrder), ReduceNLF(Array_BT_Level_WithNLF_7_InOrder), false);
        assert answer.equals(Tree_BT_Level_WithNLF_7());
        answer = instance.array2BTByPost_InOrder(ReduceNLF(Array_BT_Level_WithNLF_8_PostOrder), ReduceNLF(Array_BT_Level_WithNLF_8_InOrder), false);
        assert answer.equals(Tree_BT_Level_WithNLF_8());
        answer = instance.array2BTByPost_InOrder(ReduceNLF(Array_BT_Level_WithNLF_9_PostOrder), ReduceNLF(Array_BT_Level_WithNLF_9_InOrder), false);
        assert answer.equals(Tree_BT_Level_WithNLF_9());
    }

    @Test
    public void TestCreateBTPost_InOrderNonRecursive() {
    }
}
