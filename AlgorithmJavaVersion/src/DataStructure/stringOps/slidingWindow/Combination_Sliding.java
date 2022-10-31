package DataStructure.stringOps.slidingWindow;

import Algorithm.comprehensive.lms.LMS;
import Common.Utils.ArrayTools;
import Top100.CombinationAndPermutation;
import Top100.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/15
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 数组的连续积 小于给定值的组合
 * 求出数组中连续数的 积 小于给定值的组合,使用滑动窗口
 * <p>
 * 输入：{10, 5, 2, 6}，target：101
 * 输出：{
 * {10}, {10,5}, {10,5,2},
 * {5}, {5,2}, {5,2,6},
 * {2}, {2,6},
 * {6}
 * }
 */

public class Combination_Sliding implements LMS, CombinationAndPermutation, SlidingWindow {

    List<List<Integer>> list_all;

    // 确定边界
    public int[][] Solution(int[] array, int target) {
        int left = 0;
        int right = 0;
        int mul = 1;
        list_all = new ArrayList<>();

        while (right < array.length || left < right) {
            // 右指针扩张
            while (right < array.length && mul * array[right] <= target) {
                mul *= array[right];
                right++;
            }
            roll(array, left, right - 1);
            // 左指针收缩
            mul /= array[left];
            left++;
        }
        int[][] sortArray = ArrayTools.ListSort(list_all);
        return sortArray;
    }


    // 输出
    public void roll(int[] array, int left, int right) {
        for (int i = left; i <= right; i++) {
            List<Integer> temp1 = new ArrayList<>();
            for (int j = left; j <= i; j++) {
                temp1.add(array[j]);
            }
            list_all.add(temp1);
        }
    }

    public long LargestMultiOfSubSequence(int[] array) {
        return 0;
    }
}
