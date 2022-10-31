package Algorithm.backtrack;

import Top100.BackTrack;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/1/14
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 预测赢家 回溯法
 * 给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。
 * 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。
 * 每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。
 * 玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。
 * 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。
 * 你可以假设每个玩家的玩法都会使他的分数最大化。
 * @blogURL https://leetcode-cn.com/problems/predict-the-winner/
 */
public class PredictTheWinner_BackTrack implements BackTrack {

    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        return roll(nums, 0, nums.length - 1) >= 0;
    }

    public int roll(int[] nums, int begin, int end) {
        if (begin == end) {
            return nums[begin];
        }
        // 当前玩家减去下一个玩家的结果
        int target01 = nums[begin] - roll(nums, begin + 1, end);
        int target02 = nums[end] - roll(nums, begin, end - 1);
        return Math.max(target01, target02);
    }
}
