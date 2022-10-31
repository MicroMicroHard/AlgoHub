package UnitTest.DataStructureTest.treeTest.binaryTreeTest.binaryTreeTestData;

import Common.Constant.C;

/**
 * @author liujun
 * @version 1.0
 * @date 2022/1/25
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 二叉树 数组形式
 */

public class BT_TestData_Array_S_Print extends BT_TestData_Array_PreOrder {

    //NLF=NullLeafSymbol:表示空叶子结点
    public static int NLF = C.NLF;

    //满二叉树
    public static int[] Array_BT_Full_Level_1_S_Print = {
            1
    };
    public static int[] Array_BT_Full_Level_2_S_Print = {
            1, 2, 3
    };
    public static int[] Array_BT_Full_Level_3_S_Print = {
            1, 2, 3, 7, 6, 5, 4,
    };
    public static int[] Array_BT_Full_Level_WithNLF_1_S_Print = {
            1, NLF, NLF
    };
    //满二叉树--带叶子节点符号
    public static int[] Array_BT_Full_Level_WithNLF_2_S_Print = {
            1, 2, 3, NLF, NLF, NLF, NLF,
    };
    public static int[] Array_BT_Full_Level_WithNLF_3_S_Print = {
            1, 2, 3, 7, 6, 5, 4, NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF,
    };
    public static int[] Array_BT_Full_Level_WithNLF_4_S_Print = {
            1,
            2, 3,
            7, 6, 5, 4,
            8, 9, 10, 11, 12, 13, 14, 15,
            NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF
    };

    //非满二叉树
    public static int[] Array_BT_Level_WithNLF_2_S_Print = {
            1,
            2, NLF,
            NLF, NLF

    };
    public static int[] Array_BT_Level_WithNLF_3_S_Print = {
            1,
            2, NLF,
            3, NLF,
            NLF, NLF
    };
    public static int[] Array_BT_Level_WithNLF_4_S_Print = {
            1,
            2, 3,
            6, 5, NLF, 4,
            NLF, NLF, 7, NLF, NLF, NLF,
            NLF, NLF
    };
    public static int[] Array_BT_Level_WithNLF_5_S_Print = {
            1,
            2, 4,
            3, 5, NLF, NLF,
            NLF, NLF, 6, NLF,
            7, NLF,
            NLF, NLF
    };
    public static int[] Array_BT_Level_WithNLF_6_S_Print = {
            1,
            2, 4,
            3, 5, NLF, NLF,
            6, NLF, 7, NLF,
            NLF, 10, 9, 8,
            11, NLF, NLF, 12, 13, NLF,
            NLF, NLF, NLF, NLF, NLF, NLF
    };
    public static int[] Array_BT_Level_WithNLF_7_S_Print = {
            1,
            2, 4,
            3, 5, NLF, NLF,
            6, NLF, 7, NLF,
            NLF, 10, 9, 8,
            11, NLF, NLF, 12, 13, NLF,
            18, 17, 16, 15, 14, NLF,
            NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF
    };
    public static int[] Array_BT_Level_WithNLF_8_S_Print = {
            1,
            2, 3,
            6, 5, NLF, 4,
            7, 8, 9, 10, NLF, 11,
            NLF, NLF, NLF, 14, NLF, NLF, 13, NLF, 12, NLF,
            15, 16, NLF, 17, 18, 19,
            NLF, 22, NLF, NLF, NLF, NLF, NLF, 21, NLF, NLF,
            24, NLF, NLF, 25,
            NLF, NLF, NLF, NLF
    };
    public static int[] Array_BT_Level_WithNLF_9_S_Print = {
            1, 2, NLF, NLF, 3, 4, NLF, NLF, 5, 6, NLF, NLF, 7, 8, NLF, NLF, NLF
    };
}


