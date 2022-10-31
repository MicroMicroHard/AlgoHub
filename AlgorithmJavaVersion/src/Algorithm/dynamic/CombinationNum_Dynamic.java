package Algorithm.dynamic;

import Algorithm.backtrack.CombinationNum_BackTrack;
import Algorithm.comprehensive.lsg.LSG;
import Top100.CombinationAndPermutation;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-25 16:42
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 求数组中元素之和为指定值
 * CombinationNum_NonRepeat(dynamic)
 * 给你一个 只包含正整数 的 非空 数组 nums 和一个给定值 Target 。求出数组中是否存在某些值相加等于 Target。
 */

public class CombinationNum_Dynamic implements CombinationAndPermutation, LSG {

    // 该方法的递归方式：CombinationNum_NonRepeat
    CombinationNum_BackTrack cn = new CombinationNum_BackTrack();

    public boolean GetTargetValue(int[] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }
        // 因为存在负数情况，所以需要进行判断
        int size = target >= 0 ? target : -target;
        boolean[] answer = new boolean[size + 1];
        answer[0] = true;

        for (int i = 1; i <= size; i++) {
            for (int coin : array) {
                if (i - coin >= 0) {
                    answer[i] = answer[i - coin];
                }
                // 已满足条件
                if (answer[i]) {
                    break;
                }
            }
        }
        return answer[size];
    }

    
    public int LargestSumOfGap(int[] array) {
        return 0;
    }

    
    public int[][] Solution(int[] array, int target) {
        return new int[0][];
    }
}
