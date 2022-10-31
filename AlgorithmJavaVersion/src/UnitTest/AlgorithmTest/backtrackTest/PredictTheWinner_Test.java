package UnitTest.AlgorithmTest.backtrackTest;

import Algorithm.backtrack.PredictTheWinner_BackTrack;
import Algorithm.dynamic.PredictTheWinner_Dynamic;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/1/14
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 预测赢家 测试用例
 * 给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。
 * 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。
 * 每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。
 * 玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。
 * 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。
 * 你可以假设每个玩家的玩法都会使他的分数最大化。
 * @blogURL https://leetcode-cn.com/problems/predict-the-winner/
 */

public class PredictTheWinner_Test {

    @Test
    public void TestPredictTheWinner_BT() {
        test(new PredictTheWinner_BackTrack());
    }

    @Test
    public void TestPredictTheWinner_Dynamic() {
        test(new PredictTheWinner_Dynamic());
    }

    public void test(PredictTheWinner_BackTrack instance) {
        assert !instance.PredictTheWinner(demo01);
        assert instance.PredictTheWinner(demo02);
        assert !instance.PredictTheWinner(demo03);
        assert instance.PredictTheWinner(demo04);
        assert instance.PredictTheWinner(demo05);
    }

    int[] demo01 = {1, 5, 2};
    int[] demo02 = {1, 5, 233, 7};
    int[] demo03 = {1, 5, 2};
    int[] demo04 = {0};
    int[] demo05 = {5, 3, 4, 5};
}
