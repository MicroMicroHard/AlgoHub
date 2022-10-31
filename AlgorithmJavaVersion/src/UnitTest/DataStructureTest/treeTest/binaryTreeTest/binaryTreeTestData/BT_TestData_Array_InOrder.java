package UnitTest.DataStructureTest.treeTest.binaryTreeTest.binaryTreeTestData;

/**
 * @author liujun
 * @version 1.0
 * @date 2022/1/25
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 二叉树 数组形式 中序遍历
 */

public class BT_TestData_Array_InOrder extends BT_TestData_Array {

    //满二叉树
    public static int[] Array_BT_Full_Level_1_InOrder = {
            1
    };
    public static int[] Array_BT_Full_Level_2_InOrder = {
            2, 1, 3
    };
    public static int[] Array_BT_Full_Level_3_InOrder = {
            4, 5, 2, 1, 6, 3, 7
    };
    public static int[] Array_BT_Full_Level_WithNLF_1_InOrder = {
            NLF, 1, NLF
    };
    //满二叉树--带叶子节点符号
    public static int[] Array_BT_Full_Level_WithNLF_2_InOrder = {
            NLF, 2, NLF, 1, NLF, 3, NLF,
    };
    public static int[] Array_BT_Full_Level_WithNLF_3_InOrder = {
            NLF, 4, NLF, 2, NLF, 5, NLF, 1, NLF, 6, NLF, 3, NLF, 7, NLF,
    };
    public static int[] Array_BT_Full_Level_WithNLF_4_InOrder = {
            NLF, 8, NLF, 4, NLF, 9, NLF, 2, NLF, 10, NLF, 5, NLF, 11, NLF, 1, NLF, 12, NLF, 6, NLF, 13, NLF, 3, NLF, 14, NLF, 7, NLF, 15, NLF
    };

    //非满二叉树
    public static int[] Array_BT_Level_WithNLF_2_InOrder = {
            NLF, 2, NLF, 1, NLF,
    };
    public static int[] Array_BT_Level_WithNLF_3_InOrder = {
            NLF, 2, NLF, 3, NLF, 1, NLF
    };
    public static int[] Array_BT_Level_WithNLF_4_InOrder = {
            NLF, 4, NLF, 2, NLF, 1, NLF, 7, NLF, 5, NLF, 3, NLF, 6, NLF,
    };
    public static int[] Array_BT_Level_WithNLF_5_InOrder = {
            NLF, 2, NLF, 1, NLF, 5, NLF, 4, NLF, 6, NLF, 7, NLF, 3, NLF
    };
    public static int[] Array_BT_Level_WithNLF_6_InOrder = {
            NLF, 2, NLF, 1, NLF, 11, NLF, 8, NLF, 6, NLF, 9, NLF, 12, NLF, 5, NLF, 4, NLF, 13, NLF, 10, NLF, 7, NLF, 3, NLF,
    };
    public static int[] Array_BT_Level_WithNLF_7_InOrder = {
            NLF, 2, NLF, 1, NLF, 11, NLF, 14, NLF, 8, NLF, 6, NLF, 9, NLF, 15, NLF, 12, NLF, 16, NLF, 5, NLF, 4, NLF, 17, NLF, 13, NLF, 18, NLF, 10, NLF, 7, NLF, 3, NLF,
    };
    public static int[] Array_BT_Level_WithNLF_8_InOrder = {
            NLF, 7, NLF, 15, NLF, 12, NLF, 24, NLF, 21, NLF, 16, NLF, 4, NLF, 8, NLF, 13, NLF, 17, NLF, 2, NLF, 1, NLF, 9, NLF, 5, NLF, 18, NLF, 14, NLF, 22, NLF, 25,
            NLF, 19, NLF, 10, NLF, 3, NLF, 6, NLF, 11, NLF,
    };
    public static int[] Array_BT_Level_WithNLF_9_InOrder = {
            NLF, 8, NLF, 7, NLF, 6, NLF, 5, NLF, 4, NLF, 3, NLF, 2, NLF, 1, NLF,
    };
}


