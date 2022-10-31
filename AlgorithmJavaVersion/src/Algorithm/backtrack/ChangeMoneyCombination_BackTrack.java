package Algorithm.backtrack;

import Common.Utils.ArrayTools;
import Top100.CombinationAndPermutation;
import Top100.Dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-25 16:42
 * @author—Email micromicrohard@outlook.com
 * @description 换零钱【组合问题】
 * 给定不同面额的硬币 array 和一个总金额 target。编写一个函数来计算可以凑成总金额 所有可能的情况。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 * 输入：amount = 5, array = [1, 2, 5]
 * 输出：{
 * {5},
 * {1,2,2},
 * {1,1,1,2},
 * {1,1,1,1,1},
 * }
 * 示例 2:
 * 输入：amount = 3, array = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 * <p>
 * 示例 3:
 * 输入：amount = 10, array = [10]
 * 输出：{10}
 */

public class ChangeMoneyCombination_BackTrack implements CombinationAndPermutation, Dynamic {

    List list_all;
    List list_temp;
    int sum;

    
    public int[][] Solution(int[] array, int target) {
        if (array == null || array.length == 0 || target <= 0) {
            return null;
        }

        list_all = new ArrayList<>();
        list_temp = new ArrayList<>();
        sum = 0;

        roll(0, array, target);
        int[][] answer = ArrayTools.ListSort(list_all);
        return answer;
    }

    public void roll(int depth, int[] array, int target) {
        if (sum == target) {
            list_all.add(new ArrayList<>(list_temp));
            return;
        }
        if (sum > target) {
            return;
        }
        // 排列组合tips【回溯】: i 从0开始，是排列问题，从上次的深度depth开始，是组合问题
        for (int i = depth; i < array.length; i++) {
            list_temp.add(array[i]);
            sum += array[i];

            roll(i, array, target);

            sum -= array[i];
            list_temp.remove(list_temp.size() - 1);
        }
    }
}
