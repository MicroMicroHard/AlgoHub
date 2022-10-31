package Algorithm.backtrack;

import Algorithm.dynamic.ChangeMoney_Least_Dynamic;
import Common.Utils.ArrayTools;
import Top100.CombinationAndPermutation;
import Top100.BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-25 16:42
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 换零钱
 * 给定不同面额的硬币 coins 和一个总金额 target。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 * 输入: coins = [1, 2, 5], target = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 示例 2:
 * 输入: coins = [2], target = 3
 * 输出: -1
 */

public class ChangeMoney_Least_BackTrack extends ChangeMoney_Least_Dynamic implements CombinationAndPermutation, BackTrack {

    List<List<Integer>> list_all;
    List<Integer> list_temp;

    // todo
    public int method(int[] coins, int target) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        if (target <= 0) {
            return 0;
        }
        int[][] list = Solution(coins, target);
        if (list == null || list.length == 0) {
            return 0;
        }
        return list[0].length;
    }

    
    public int[][] Solution(int[] array, int target) {

        list_all = new ArrayList<>();
        list_temp = new ArrayList();
        roll(array, target);
        return ArrayTools.ListSort(list_all);
    }

    public void roll(int[] array, int target) {
        if (target == 0) {
            list_all.add(new ArrayList<>(list_temp));
            return;
        }
        for (int money : array) {
            if (money <= target) {
                list_temp.add(money);
                roll(array, target - money);
                list_temp.remove(list_temp.size() - 1);
            }
        }
    }
}
