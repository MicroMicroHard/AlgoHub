package Algorithm.dynamic;

import Top100.Dynamic;

import java.util.Arrays;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-25 16:42
 * @author—Email micromicrohard@outlook.com
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

public class ChangeMoney_Least_Dynamic implements Dynamic {

    public int method(int[] coins, int target) {

        if (coins == null || coins.length == 0) {
            return -1;
        }
        if (target <= 0) {
            return 0;
        }

        int max = target + 1;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;  //attention:注意此处的0
        for (int i = 1; i <= target; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[target] == max ? -1 : dp[target];
    }

    //todo 二维DP by ronaldWu

}
