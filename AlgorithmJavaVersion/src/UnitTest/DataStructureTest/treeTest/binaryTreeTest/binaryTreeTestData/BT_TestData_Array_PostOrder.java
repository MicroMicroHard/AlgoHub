package UnitTest.DataStructureTest.treeTest.binaryTreeTest.binaryTreeTestData;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/1/25
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 二叉树 数组形式 后序遍历
 */

public class BT_TestData_Array_PostOrder extends BT_TestData_Array_InOrder {

    //满二叉树
    public static int[] Array_BT_Full_Level_1_PostOrder = {
            1
    };
    public static int[] Array_BT_Full_Level_2_PostOrder = {
            2, 3, 1
    };
    public static int[] Array_BT_Full_Level_3_PostOrder = {
            4, 5, 2, 6, 7, 3, 1
    };
    public static int[] Array_BT_Full_Level_WithNLF_1_PostOrder = {
            NLF, NLF, 1
    };
    //满二叉树--带叶子节点符号
    public static int[] Array_BT_Full_Level_WithNLF_2_PostOrder = {
            NLF, NLF, 2, NLF, NLF, 3, 1,
    };
    public static int[] Array_BT_Full_Level_WithNLF_3_PostOrder = {
            NLF, NLF, 4, NLF, NLF, 5, 2, NLF, NLF, 6, NLF, NLF, 7, 3, 1
    };
    public static int[] Array_BT_Full_Level_WithNLF_4_PostOrder = {
            NLF, NLF, 8, NLF, NLF, 9, 4, NLF, NLF, 10, NLF, NLF, 11, 5, 2, NLF, NLF, 12, NLF, NLF, 13, 6, NLF, NLF, 14, NLF, NLF, 15, 7, 3, 1
    };

    //非满二叉树
    public static int[] Array_BT_Level_WithNLF_2_PostOrder = {
            NLF, NLF, 2, NLF, 1
    };
    public static int[] Array_BT_Level_WithNLF_3_PostOrder = {
            NLF, NLF, NLF, 3, 2, NLF, 1
    };
    public static int[] Array_BT_Level_WithNLF_4_PostOrder = {
            NLF, NLF, 4, NLF, 2, NLF, NLF, 7, NLF, 5, NLF, NLF, 6, 3, 1
    };
    public static int[] Array_BT_Level_WithNLF_5_PostOrder = {
            NLF, NLF, 2, NLF, NLF, 5, NLF, NLF, NLF, 7, 6, NLF, 3, 4, 1
    };
    public static int[] Array_BT_Level_WithNLF_6_PostOrder = {
            NLF, NLF, 2, NLF, NLF, 11, NLF, 8, NLF, NLF, NLF, 12, 9, 6, NLF, 5, NLF, NLF, 13, NLF, 10, NLF, 7, NLF, 3, 4, 1
    };
    public static int[] Array_BT_Level_WithNLF_7_PostOrder = {
            NLF, NLF, 2, NLF, NLF, NLF, 14, 11, NLF, 8, NLF, NLF, NLF, 15, NLF, NLF, 16, 12, 9, 6, NLF, 5,
            NLF, NLF, 17, NLF, NLF, 18, 13, NLF, 10, NLF, 7, NLF, 3,
            4, 1
    };
    public static int[] Array_BT_Level_WithNLF_8_PostOrder = {
            NLF, NLF, NLF, 15, NLF, NLF, 24, NLF, 21, NLF, 16, 12, 7,
            NLF, NLF, NLF, NLF, 17, 13, 8,
            4, NLF, 2,
            NLF, NLF, 9, NLF, NLF, 18, NLF, NLF, NLF, 25, 22, NLF, 19, 14, NLF, 10, 5,
            NLF, NLF, NLF, 11, 6,
            3,
            1
    };
    public static int[] Array_BT_Level_WithNLF_9_PostOrder = {
            NLF, NLF, 8, NLF, 7, NLF, 6, NLF, 5, NLF, 4, NLF, 3, NLF, 2, NLF, 1
    };
}


