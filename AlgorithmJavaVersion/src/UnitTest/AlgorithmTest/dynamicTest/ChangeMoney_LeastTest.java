package UnitTest.AlgorithmTest.dynamicTest;

import Algorithm.backtrack.ChangeMoney_Least_BackTrack;
import Algorithm.dynamic.ChangeMoney_Least_Dynamic;
import org.junit.Test;

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

public class ChangeMoney_LeastTest {

    @Test
    public void TestChangeMoney_Dynamic() {
        test(new ChangeMoney_Least_Dynamic());
    }

    @Test
    public void TestChangeMoney_BackTrack() {
        test(new ChangeMoney_Least_BackTrack());
    }

    public void test(ChangeMoney_Least_Dynamic changeMoneyDynamic) {
        int result = changeMoneyDynamic.method(demo01, demo01_target);
        assert result == 3;
        result = changeMoneyDynamic.method(demo02, demo02_target);
        assert result == -1;
        result = changeMoneyDynamic.method(demo03, demo03_target);
        assert result == -1;
        result = changeMoneyDynamic.method(demo04, demo04_target);
        assert result == 0;
        result = changeMoneyDynamic.method(demo05, demo05_target);
        assert result == 0;
    }

    int[] demo01 = {1, 2, 5};
    int demo01_target = 11;  //return : 3
    int[] demo02 = {2};
    int demo02_target = 3;   //return : -1
    int[] demo03 = {};
    int demo03_target = 11;  //return : -1
    int[] demo04 = {1, 2, 5};
    int demo04_target = 0;   //return : -1
    int[] demo05 = {1};
    int demo05_target = 0;   //return : -1
}
