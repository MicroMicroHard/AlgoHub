package DataStructure.tree.binaryTree.binaryTreeTestData;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/1/25
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 二叉树 数组形式 先序遍历
 */

public class BT_TestData_Array_PreOrder extends BT_TestData_Array_PostOrder {

    //满二叉树
    public static int[] Array_BT_Full_Level_1_PreOrder = {
            1
    };
    public static int[] Array_BT_Full_Level_2_PreOrder = {
            1, 2, 3
    };
    public static int[] Array_BT_Full_Level_3_PreOrder = {
            1, 2, 4, 5, 3, 6, 7
    };
    public static int[] Array_BT_Full_Level_WithNLF_1_PreOrder = {
            1, NLF, NLF
    };
    //满二叉树--带叶子节点符号
    public static int[] Array_BT_Full_Level_WithNLF_2_PreOrder = {
            1,
            2, NLF, NLF,
            3, NLF, NLF
    };
    public static int[] Array_BT_Full_Level_WithNLF_3_PreOrder = {
            1,
            2, 4, NLF, NLF, 5, NLF, NLF,
            3, 6, NLF, NLF, 7, NLF, NLF,
    };
    public static int[] Array_BT_Full_Level_WithNLF_4_PreOrder = {
            1,
            2, 4, 8, NLF, NLF, 9, NLF, NLF, 5, 10, NLF, NLF, 11, NLF, NLF,
            3, 6, 12, NLF, NLF, 13, NLF, NLF, 7, 14, NLF, NLF, 15, NLF, NLF
    };

    //非满二叉树
    public static int[] Array_BT_Level_WithNLF_2_PreOrder = {
            1,
            2, NLF, NLF,
            NLF
    };
    public static int[] Array_BT_Level_WithNLF_3_PreOrder = {
            1,
            2, NLF, 3, NLF, NLF,
            NLF
    };
    public static int[] Array_BT_Level_WithNLF_4_PreOrder = {
            1, 2, 4, NLF, NLF, NLF, 3, 5, 7, NLF, NLF, NLF, 6, NLF, NLF,
    };
    public static int[] Array_BT_Level_WithNLF_5_PreOrder = {
            1, 2, NLF, NLF, 4, 5, NLF, NLF, 3, 6, NLF, 7, NLF, NLF, NLF,
    };
    public static int[] Array_BT_Level_WithNLF_6_PreOrder = {
            1, 2, NLF, NLF, 4,
            5, 6, 8, 11, NLF, NLF, NLF, 9, NLF, 12, NLF, NLF, NLF,
            3, 7, 10, 13, NLF, NLF, NLF, NLF, NLF
    };
    public static int[] Array_BT_Level_WithNLF_7_PreOrder = {
            1, 2, NLF, NLF, 4,
            5, 6, 8, 11, NLF, 14, NLF, NLF, NLF, 9, NLF, 12, 15, NLF, NLF, 16, NLF, NLF, NLF,
            3, 7, 10, 13, 17, NLF, NLF, 18, NLF, NLF, NLF, NLF, NLF
    };
    public static int[] Array_BT_Level_WithNLF_8_PreOrder = {
            1,
            2, 4,
            7, NLF, 12, 15, NLF, NLF, 16, 21, 24, NLF, NLF, NLF, NLF,
            8, NLF, 13, NLF, 17, NLF, NLF, NLF,
            3,
            5, 9, NLF, NLF, 10, 14, 18, NLF, NLF, 19, 22, NLF, 25, NLF, NLF, NLF, NLF,
            6, NLF, 11, NLF, NLF
    };
    public static int[] Array_BT_Level_WithNLF_9_PreOrder = {
            1, 2, 3, 4, 5, 6, 7, 8, NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF, NLF
    };
}


