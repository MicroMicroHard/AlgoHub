package Algorithm.dynamic;

import Top100.Dynamic;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-25 16:42
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 换零钱
 * 给定不同面额的硬币 coins 和一个总金额 target。编写一个函数来计算可以凑成总金额 所有可能的情况。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * 示例 2:
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 * <p>
 * 示例 3:
 * 输入：amount = 10, coins = [10]
 * 输出：1
 */

public class ChangeMoneyCombination_Dynamic implements Dynamic {

    public int method(int[] coins, int target) {

        if (coins == null || coins.length == 0 || target <= 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;  //tips:注意此处的1，表示构建0元只有1中方法：那就是不选
        for (int coin : coins) {
            //VIPTips：for循环的差异是：一个求解结果是 排列数，一个求解结果是 组合数
            //具体见解析：https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-iihe-pa-lou-ti-wen-ti-dao-di-yo/
            for (int i = coin; i <= target; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[target];
    }
}
