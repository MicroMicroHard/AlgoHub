package DataStructure.tree.binaryTree.binaryTreeTestData;

import Common.Constant.C;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/1/25
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 二叉树 数组形式
 */

public class BT_TestData_Array {

    //NLF=NullLeafSymbol:表示空叶子结点
    public static int NLF = C.NLF;

    //满二叉树
    public static int[] Array_BT_Full_Level_1 = {
            1
    };
    public static int[] Array_BT_Full_Level_2 = {
             1,
            2, 3
    };
    public static int[] Array_BT_Full_Level_3 = {
                1,
              2,   3,
            4, 5, 6, 7
    };
    public static int[] Array_BT_Full_Level_WithNLF_1 = {
               1,
            NLF, NLF
    };
    //满二叉树--带叶子节点符号
    public static int[] Array_BT_Full_Level_WithNLF_2 = {
                     1,
                2,        3,
            NLF, NLF, NLF, NLF,
    };
    public static int[] Array_BT_Full_Level_WithNLF_3 = {
                               1,
                      2,                  3,
                4,         5,        6,         7,
            NLF, NLF,  NLF, NLF,  NLF, NLF,  NLF, NLF,
    };
    public static int[] Array_BT_Full_Level_WithNLF_4 = {
                                                 1,
                               2,                                   3,
                    4,                   5,                 6,                 7,
               8,        9,       10,        11,       12,      13,        14,       15,
            NLF,NLF,  NLF,NLF,  NLF,NLF,  NLF,NLF,  NLF,NLF,  NLF,NLF,  NLF,NLF,  NLF,NLF
    };

    //非满二叉树
    public static int[] Array_BT_Level_WithNLF_2 = {
                    1,
                2,     NLF,
            NLF,  NLF

    };
    public static int[] Array_BT_Level_WithNLF_3 = {
                      1,
                  2,     NLF,
               NLF, 3,
                 NLF, NLF
    };
    public static int[] Array_BT_Level_WithNLF_4 = {
                              1,
                   2,                   3,
                4,   NLF,          5,           6,
            NLF, NLF,           7,    NLF,   NLF, NLF,
                             NLF, NLF
    };
    public static int[] Array_BT_Level_WithNLF_5 = {
                          1,
                2,                  4,
            NLF, NLF,        5,               3,
                         NLF,  NLF,       6,      NLF,
                                      NLF,   7,
                                          NLF, NLF
    };
    public static int[] Array_BT_Level_WithNLF_6 = {
                               1,
                2,                            4,
            NLF, NLF,             5,                         3,
                               6,     NLF,                7,      NLF,
                         8,          9,               10,    NLF,
                      11,  NLF,  NLF,  12,          13,  NLF,
                    NLF,NLF,         NLF,NLF,     NLF,NLF
    };
    public static int[] Array_BT_Level_WithNLF_7 = {
                                    1,
                2,                                        4,
            NLF, NLF,              5,                                        3,
                               6,       NLF,                            7,        NLF,
                         8,          9,                           10,       NLF,
                      11,  NLF,  NLF,   12,                  13,       NLF,
                  NLF,   14,       15,      16,          17,     18,
                       NLF,NLF,  NLF,NLF, NLF,NLF,    NLF,NLF,  NLF,NLF
    };
    public static int[] Array_BT_Level_WithNLF_8 = {
                                                            1,
                                        2,                                     3,
                                4,              NLF,                 5,                       6,
                      7,                    8,               9,                10,        NLF,    11,
               NLF,        12,          NLF,     13,      NLF,NLF,          14,    NLF,         NLF, NLF,
                   15,              16,       NLF,   17,               18,          19,
               NLF,   NLF,      21,     NLF,      NLF,  NLF,        NLF, NLF,   22,     NLF,
                            24,     NLF,                                    NLF,   25,
                        NLF,   NLF,                                            NLF,   NLF
    };

    public static int[] Array_BT_Level_WithNLF_9 = {
                                     1,
                                 2,    NLF,
                              3,    NLF,
                           4,    NLF,
                         5,   NLF,
                      6,   NLF,
                   7,   NLF,
                8,   NLF,
            NLF,  NLF
    };
}


