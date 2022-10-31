package Algorithm.dynamic;

import Top100.CombinationAndPermutation;
import Top100.Dynamic;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-25 16:42
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @blogURL https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * <p>
 * 这道题可以转换成：组合数组中的数之和为指定值，只不过这个和是数组Sum的一半
 * 给定数组 array=[1,3,6,8,5] 和 给定的目标值 target=9
 * 问题1：数组不可以重复的选择，是否可以组成target
 * 问题2：数组不可以重复的选择，最终给出符合target的序列
 * 比如符合给定数组和目标值的序列为：
 * [1,8],
 * [3,6],
 * [1,3,5],
 */

public class CombinationNum_NonRepeat_Dynamic implements CombinationAndPermutation, Dynamic {

    public int[] getTargetArray(int[] array) {
        if (array == null || array.length <= 1) {
            return null;
        }
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        if (sum % 2 != 0) {
            return null;
        }
        int target = sum / 2;
        int[][] list = Solution(array, target);
        // 没有满足的结果
        if (list.length == 0) {
            return null;
        }
        // 只取其中一条
        /*int listTarget = list[0];
        int[] targetArray = new int[listTarget.size()];
        for (int i = 0; i < listTarget.size(); i++) {
            targetArray[i] = listTarget.get(i);
        }
        return targetArray;*/
        return null;
    }

    // 组合数组中的数之和为指定值
    public int[][] Solution(int[] array, int target) {
        //CombinationNum_Dynamic gt = new CombinationNum_Dynamic();
        //return gt.GetTargetValue(array, target);
        return null;
    }

    // 判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
    public boolean JudgeAnswer(int[] array) {
        if (array == null || array.length <= 1) {
            return false;
        }
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        return JudgeAnswer(array, target);
    }

    public boolean JudgeAnswer(int[] array, int target) {

        // today todo
        int[][] answerMatrix = new int[array.length + 1][target];
        for (int i = 0; i < array.length; i++) {
            answerMatrix[i][0] = 1;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (array[i] == j) {
                    answerMatrix[i][j] = 1;
                } else if (array[i] < j) {
                    answerMatrix[i][j] = answerMatrix[i - 1][j - array[i]] | answerMatrix[i - 1][j];
                } else {
                    answerMatrix[i][j] = answerMatrix[i - 1][j];
                }
            }
        }
        return answerMatrix[array.length - 1][target] == 1;
    }
}
