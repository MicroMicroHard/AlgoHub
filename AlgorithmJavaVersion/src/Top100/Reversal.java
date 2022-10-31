package Top100;


import DataStructure.arrayRelevant.arrayTransformation.ReversalString;
import DataStructure.arrayRelevant.arrayTransformation.ReversalString2;
import DataStructure.arrayRelevant.arrayTransformation.ReversalString3;
import DataStructure.list.listReverse.*;
import DataStructure.arrayRelevant.matrix.Matrix_Reversal;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/8/25
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 反转
 * 字符串反转
 * 链表反转
 * 矩阵反转
 */

public interface Reversal {

    /**
     字符串反转
     {@link ReversalString}
     {@link ReversalString2}
     {@link ReversalString3}

     链表反转有两种方式:
     利用系统栈递归,配合数组使用 / 利用指针关系 反转链表   {@link ListReverse}
     两两交换链表中的节点               {@link ListReverse_Part2_SwapPairs}
     反转从index1 到 index2 之间的数据  {@link ListReverse_TwoPosition}
     每N个数反转一次                   {@link ListReverse_PartN_impl}
     反转链表最后几个数                 {@link ListReverse_LastK_2Top}

     矩阵反转 {@link Matrix_Reversal}
     */
}
