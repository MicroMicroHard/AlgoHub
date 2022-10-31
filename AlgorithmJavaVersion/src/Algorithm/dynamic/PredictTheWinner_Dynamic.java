package Algorithm.dynamic;

import Algorithm.backtrack.PredictTheWinner_BackTrack;
import Top100.Dynamic;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/14
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 预测赢家 动态规划法
 * 给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。
 * 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。
 * 每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。
 * 玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。
 * 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。
 * 你可以假设每个玩家的玩法都会使他的分数最大化。
 * @blogURL https://leetcode-cn.com/problems/predict-the-winner/
 */
public class PredictTheWinner_Dynamic extends PredictTheWinner_BackTrack implements Dynamic {

    /**
     * answer[i][j]表示在牌[i,j]中选取，[动态方程中差值越大，赢的可能性越大]
     * 1、当前玩家要么选择i，要么选择j，所以动态方程：answer[i][j] = Math.max(nums[i] - answer[i + 1][j], nums[j] - answer[i][j - 1])
     * 2、只有当i<j才有意义
     * 3、动态方程中出现i + 1，所以i的遍历是从 [length - 1]-> [0], i < j 才有意义，所以j的遍历是从 [i + 1] -> [length]
     */
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int length = nums.length;
        int[][] answer = new int[length][length];
        for (int i = 0; i < length; i++) {
            answer[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                answer[i][j] = Math.max(nums[i] - answer[i + 1][j], nums[j] - answer[i][j - 1]);
            }
        }
        return answer[0][length - 1] >= 0;
    }
}
