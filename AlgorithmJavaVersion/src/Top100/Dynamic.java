package Top100;

import Algorithm.comprehensive.backpack.Backpack_Dynamic;
import Algorithm.comprehensive.lis.LIS_Dynamic;
import Algorithm.comprehensive.*;
import Algorithm.dynamic.*;
import Algorithm.dynamic.lcs.LCS_Dynamic;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/12/7
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 动态规划专题
 */

public interface Dynamic {

    /**
     * Tips：换零钱 和 背包问题 的区别在于：背包问题是每个物品选择一个，但是换零钱是每个物品可以选择 N 次
     * 换零钱                  {@link ChangeMoney_Least_Dynamic}
     * 背包问题                {@link Backpack_Dynamic}
     * 将数组分割成两个相等的子集 {@link CombinationNum_NonRepeat_Dynamic}
     *
     * 编辑距离                {@link EditDistance}
     * 字符组成判断             {@link StringInDic}
     * 计算路径数               {@link CountPathNum}
     * 预测赢家 动态规划法       {@link PredictTheWinner_Dynamic}
     *
     * 连续问题
     * LSS 最大子段和    (连续)    {@link  LSS_Dynamic#LargestSumOfSubSequence}
     * LMS 最大子段乘积   (连续)   {@link  LMS_Dynamic#LargestMultiOfSubSequence}
     * LIS 最长递增子序列 (不连续)  {@link  LIS_Dynamic#LongestIncreasingOfSubsequence}
     * LCS 最长公共子序列 (不连续)  {@link  LCS_Dynamic#LongestCommonOfSequence}
     * LSG 最大间隔和    (不连续)  {@link  LSG_Dynamic#LargestSumOfGap}
     * LMG 最大间隔乘积   (不连续)  {@link LMG_Dynamic#LargestMultiOfGap}
     */
}
