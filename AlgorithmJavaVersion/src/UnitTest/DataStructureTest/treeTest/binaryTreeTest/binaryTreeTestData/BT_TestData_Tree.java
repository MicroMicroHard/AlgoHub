package UnitTest.DataStructureTest.treeTest.binaryTreeTest.binaryTreeTestData;

import Common.Utils.ArrayTools;
import DataStructure.tree.binaryTree.binaryTreeImpl.BinaryTree2ArrayImpl;
import DataStructure.tree.binaryTree.BinaryTreeImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2022/1/25
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 二叉树 树形式
 */

public class BT_TestData_Tree extends BT_TestData_Array_S_Print {

    public static int[] ReduceNLF(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        for (int j : array) {
            if (j != NLF) {
                list.add(j);
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

    public static BinaryTreeImpl Tree_BT_Empty() {
        return null;
    }

    public static BinaryTreeImpl Tree_BT_Full_Level_WithNLF_1() {
        return new BinaryTreeImpl(1);
    }

    public static BinaryTreeImpl Tree_BT_Full_Level_WithNLF_2() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl(1);
        binaryTree1.left = new BinaryTreeImpl(2);
        binaryTree1.right = new BinaryTreeImpl(3);
        return binaryTree1;
    }

    public static BinaryTreeImpl Tree_BT_Full_Level_WithNLF_3() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl(1);
        BinaryTreeImpl binaryTree2 = new BinaryTreeImpl(2);
        BinaryTreeImpl binaryTree3 = new BinaryTreeImpl(3);
        binaryTree1.left = binaryTree2;
        binaryTree1.right = binaryTree3;
        binaryTree2.left = new BinaryTreeImpl(4);
        binaryTree2.right = new BinaryTreeImpl(5);
        binaryTree3.left = new BinaryTreeImpl(6);
        binaryTree3.right = new BinaryTreeImpl(7);
        return binaryTree1;
    }

    public static BinaryTreeImpl Tree_BT_Full_Level_WithNLF_4() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl(1);
        BinaryTreeImpl binaryTree2 = new BinaryTreeImpl(2);
        BinaryTreeImpl binaryTree3 = new BinaryTreeImpl(3);
        BinaryTreeImpl binaryTree4 = new BinaryTreeImpl(4);
        BinaryTreeImpl binaryTree5 = new BinaryTreeImpl(5);
        BinaryTreeImpl binaryTree6 = new BinaryTreeImpl(6);
        BinaryTreeImpl binaryTree7 = new BinaryTreeImpl(7);
        binaryTree1.left = binaryTree2;
        binaryTree1.right = binaryTree3;
        binaryTree2.left = binaryTree4;
        binaryTree2.right = binaryTree5;
        binaryTree3.left = binaryTree6;
        binaryTree3.right = binaryTree7;
        binaryTree4.left = new BinaryTreeImpl(8);
        binaryTree4.right = new BinaryTreeImpl(9);
        binaryTree5.left = new BinaryTreeImpl(10);
        binaryTree5.right = new BinaryTreeImpl(11);
        binaryTree6.left = new BinaryTreeImpl(12);
        binaryTree6.right = new BinaryTreeImpl(13);
        binaryTree7.left = new BinaryTreeImpl(14);
        binaryTree7.right = new BinaryTreeImpl(15);
        return binaryTree1;
    }

    public static BinaryTreeImpl Tree_BT_Level_WithNLF_1() {
        return Tree_BT_Full_Level_WithNLF_1();
    }

    public static BinaryTreeImpl Tree_BT_Level_WithNLF_2() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl(1);
        binaryTree1.left = new BinaryTreeImpl(2);
        return binaryTree1;
    }

    public static BinaryTreeImpl Tree_BT_Level_WithNLF_3() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl(1);
        BinaryTreeImpl binaryTree2 = new BinaryTreeImpl(2);
        binaryTree1.left = binaryTree2;
        binaryTree2.right = new BinaryTreeImpl(3);
        return binaryTree1;
    }

    public static BinaryTreeImpl Tree_BT_Level_WithNLF_4() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl(1);
        BinaryTreeImpl binaryTree2 = new BinaryTreeImpl(2);
        BinaryTreeImpl binaryTree3 = new BinaryTreeImpl(3);
        BinaryTreeImpl binaryTree5 = new BinaryTreeImpl(5);
        BinaryTreeImpl binaryTree6 = new BinaryTreeImpl(6);
        binaryTree1.left = binaryTree2;
        binaryTree1.right = binaryTree3;
        binaryTree2.left = new BinaryTreeImpl(4);
        binaryTree3.left = binaryTree5;
        binaryTree3.right = binaryTree6;
        binaryTree5.left = new BinaryTreeImpl(7);
        return binaryTree1;
    }

    public static BinaryTreeImpl Tree_BT_Level_WithNLF_5() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl(1);
        BinaryTreeImpl binaryTree4 = new BinaryTreeImpl(4);
        BinaryTreeImpl binaryTree3 = new BinaryTreeImpl(3);
        BinaryTreeImpl binaryTree6 = new BinaryTreeImpl(6);
        binaryTree1.left = new BinaryTreeImpl(2);
        binaryTree1.right = binaryTree4;
        binaryTree4.left = new BinaryTreeImpl(5);
        binaryTree4.right = binaryTree3;
        binaryTree3.left = binaryTree6;
        binaryTree6.right = new BinaryTreeImpl(7);
        return binaryTree1;
    }

    public static BinaryTreeImpl Tree_BT_Level_WithNLF_6() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl(1);
        BinaryTreeImpl binaryTree4 = new BinaryTreeImpl(4);
        BinaryTreeImpl binaryTree3 = new BinaryTreeImpl(3);
        BinaryTreeImpl binaryTree6 = new BinaryTreeImpl(6);
        BinaryTreeImpl binaryTree5 = new BinaryTreeImpl(5);
        BinaryTreeImpl binaryTree7 = new BinaryTreeImpl(7);
        BinaryTreeImpl binaryTree8 = new BinaryTreeImpl(8);
        BinaryTreeImpl binaryTree9 = new BinaryTreeImpl(9);
        BinaryTreeImpl binaryTree10 = new BinaryTreeImpl(10);
        binaryTree1.left = new BinaryTreeImpl(2);
        binaryTree1.right = binaryTree4;
        binaryTree4.left = binaryTree5;
        binaryTree4.right = binaryTree3;
        binaryTree5.left = binaryTree6;
        binaryTree3.left = binaryTree7;
        binaryTree6.left = binaryTree8;
        binaryTree6.right = binaryTree9;
        binaryTree7.left = binaryTree10;
        binaryTree10.left = new BinaryTreeImpl(13);
        binaryTree8.left = new BinaryTreeImpl(11);
        binaryTree9.right = new BinaryTreeImpl(12);
        return binaryTree1;
    }

    public static BinaryTreeImpl Tree_BT_Level_WithNLF_7() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl(1);
        BinaryTreeImpl binaryTree4 = new BinaryTreeImpl(4);
        BinaryTreeImpl binaryTree3 = new BinaryTreeImpl(3);
        BinaryTreeImpl binaryTree5 = new BinaryTreeImpl(5);
        BinaryTreeImpl binaryTree7 = new BinaryTreeImpl(7);
        BinaryTreeImpl binaryTree10 = new BinaryTreeImpl(10);
        BinaryTreeImpl binaryTree13 = new BinaryTreeImpl(13);
        BinaryTreeImpl binaryTree6 = new BinaryTreeImpl(6);
        BinaryTreeImpl binaryTree8 = new BinaryTreeImpl(8);
        BinaryTreeImpl binaryTree9 = new BinaryTreeImpl(9);
        BinaryTreeImpl binaryTree11 = new BinaryTreeImpl(11);
        BinaryTreeImpl binaryTree12 = new BinaryTreeImpl(12);
        binaryTree1.left = new BinaryTreeImpl(2);
        binaryTree1.right = binaryTree4;
        binaryTree4.left = binaryTree5;
        binaryTree4.right = binaryTree3;
        binaryTree3.left = binaryTree7;
        binaryTree7.left = binaryTree10;
        binaryTree10.left = binaryTree13;
        binaryTree13.left = new BinaryTreeImpl(17);
        binaryTree13.right = new BinaryTreeImpl(18);
        binaryTree5.left = binaryTree6;
        binaryTree6.left = binaryTree8;
        binaryTree6.right = binaryTree9;
        binaryTree8.left = binaryTree11;
        binaryTree11.right = new BinaryTreeImpl(14);
        binaryTree9.right = binaryTree12;
        binaryTree12.left = new BinaryTreeImpl(15);
        binaryTree12.right = new BinaryTreeImpl(16);
        return binaryTree1;
    }

    public static BinaryTreeImpl Tree_BT_Level_WithNLF_8() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl(1);
        BinaryTreeImpl binaryTree2 = new BinaryTreeImpl(2);
        BinaryTreeImpl binaryTree3 = new BinaryTreeImpl(3);
        BinaryTreeImpl binaryTree4 = new BinaryTreeImpl(4);
        BinaryTreeImpl binaryTree5 = new BinaryTreeImpl(5);
        BinaryTreeImpl binaryTree6 = new BinaryTreeImpl(6);
        BinaryTreeImpl binaryTree7 = new BinaryTreeImpl(7);
        BinaryTreeImpl binaryTree8 = new BinaryTreeImpl(8);
        BinaryTreeImpl binaryTree10 = new BinaryTreeImpl(10);
        BinaryTreeImpl binaryTree12 = new BinaryTreeImpl(12);
        BinaryTreeImpl binaryTree13 = new BinaryTreeImpl(13);
        BinaryTreeImpl binaryTree14 = new BinaryTreeImpl(14);
        BinaryTreeImpl binaryTree16 = new BinaryTreeImpl(16);
        BinaryTreeImpl binaryTree19 = new BinaryTreeImpl(19);
        BinaryTreeImpl binaryTree21 = new BinaryTreeImpl(21);
        BinaryTreeImpl binaryTree22 = new BinaryTreeImpl(22);
        binaryTree1.left = binaryTree2;
        binaryTree1.right = binaryTree3;
        binaryTree2.left = binaryTree4;
        binaryTree3.left = binaryTree5;
        binaryTree3.right = binaryTree6;
        binaryTree4.left = binaryTree7;
        binaryTree4.right = binaryTree8;
        binaryTree5.left = new BinaryTreeImpl(9);
        binaryTree5.right = binaryTree10;
        binaryTree6.right = new BinaryTreeImpl(11);
        binaryTree7.right = binaryTree12;
        binaryTree12.left = new BinaryTreeImpl(15);
        binaryTree12.right = binaryTree16;
        binaryTree16.left = binaryTree21;
        binaryTree21.left = new BinaryTreeImpl(24);
        binaryTree8.right = binaryTree13;
        binaryTree13.right = new BinaryTreeImpl(17);
        binaryTree10.left = binaryTree14;
        binaryTree14.left = new BinaryTreeImpl(18);
        binaryTree14.right = binaryTree19;
        binaryTree19.left = binaryTree22;
        binaryTree22.right = new BinaryTreeImpl(25);
        return binaryTree1;
    }

    public static BinaryTreeImpl Tree_BT_Level_WithNLF_9() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl(1);
        BinaryTreeImpl binaryTree2 = new BinaryTreeImpl(2);
        BinaryTreeImpl binaryTree3 = new BinaryTreeImpl(3);
        BinaryTreeImpl binaryTree4 = new BinaryTreeImpl(4);
        BinaryTreeImpl binaryTree5 = new BinaryTreeImpl(5);
        BinaryTreeImpl binaryTree6 = new BinaryTreeImpl(6);
        BinaryTreeImpl binaryTree7 = new BinaryTreeImpl(7);
        BinaryTreeImpl binaryTree8 = new BinaryTreeImpl(8);
        binaryTree1.left = binaryTree2;
        binaryTree2.left = binaryTree3;
        binaryTree3.left = binaryTree4;
        binaryTree4.left = binaryTree5;
        binaryTree5.left = binaryTree6;
        binaryTree6.left = binaryTree7;
        binaryTree7.left = binaryTree8;
        return binaryTree1;
    }

    public static void main(String[] args) {
        String pattern = "new UTDataEntity(strTools.ConcatMultiParams(\"%s\",\"%s\"), \"%s\"),\n";
        BinaryTree2ArrayImpl tools = new BinaryTree2ArrayImpl();

        int[] output = tools.BT2ArrayByPreOrder(Tree_BT_Full_Level_WithNLF_1(), true, true);
        System.out.printf(pattern,
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Full_Level_WithNLF_1_PostOrder), "{"),
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Full_Level_WithNLF_1_InOrder), "{"),
                ArrayTools.IntArray2Sequence(output, "{"));
        output = tools.BT2ArrayByPreOrder(Tree_BT_Full_Level_WithNLF_2(), true, true);
        System.out.printf(pattern,
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Full_Level_WithNLF_2_PostOrder), "{"),
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Full_Level_WithNLF_2_InOrder), "{"),
                ArrayTools.IntArray2Sequence(output, "{"));
        output = tools.BT2ArrayByPreOrder(Tree_BT_Full_Level_WithNLF_3(), true, true);
        System.out.printf(pattern,
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Full_Level_WithNLF_3_PostOrder), "{"),
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Full_Level_WithNLF_3_InOrder), "{"),
                ArrayTools.IntArray2Sequence(output, "{"));
        output = tools.BT2ArrayByPreOrder(Tree_BT_Full_Level_WithNLF_4(), true, true);
        System.out.printf(pattern,
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Full_Level_WithNLF_4_PostOrder), "{"),
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Full_Level_WithNLF_4_InOrder), "{"),
                ArrayTools.IntArray2Sequence(output, "{"));

        output = tools.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_2(), true, true);
        System.out.printf(pattern,
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Level_WithNLF_2_PostOrder), "{"),
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Level_WithNLF_2_InOrder), "{"),
                ArrayTools.IntArray2Sequence(output, "{"));
        output = tools.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_3(), true, true);
        System.out.printf(pattern,
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Level_WithNLF_3_PostOrder), "{"),
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Level_WithNLF_3_InOrder), "{"),
                ArrayTools.IntArray2Sequence(output, "{"));
        output = tools.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_4(), true, true);
        System.out.printf(pattern,
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Level_WithNLF_4_PostOrder), "{"),
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Level_WithNLF_4_InOrder), "{"),
                ArrayTools.IntArray2Sequence(output, "{"));
        output = tools.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_5(), true, true);
        System.out.printf(pattern,
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Level_WithNLF_5_PostOrder), "{"),
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Level_WithNLF_5_InOrder), "{"),
                ArrayTools.IntArray2Sequence(output, "{"));
        output = tools.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_6(), true, true);
        System.out.printf(pattern,
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Level_WithNLF_6_PostOrder), "{"),
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Level_WithNLF_6_InOrder), "{"),
                ArrayTools.IntArray2Sequence(output, "{"));
        output = tools.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_7(), true, true);
        System.out.printf(pattern,
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Level_WithNLF_7_PostOrder), "{"),
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Level_WithNLF_7_InOrder), "{"),
                ArrayTools.IntArray2Sequence(output, "{"));
        output = tools.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_8(), true, true);
        System.out.printf(pattern,
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Level_WithNLF_8_PostOrder), "{"),
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Level_WithNLF_8_InOrder), "{"),
                ArrayTools.IntArray2Sequence(output, "{"));
        output = tools.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_9(), true, true);
        System.out.printf(pattern,
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Level_WithNLF_9_PostOrder), "{"),
                ArrayTools.IntArray2Sequence(ReduceNLF(Array_BT_Level_WithNLF_9_InOrder), "{"),
                ArrayTools.IntArray2Sequence(output, "{"));
    }
}


