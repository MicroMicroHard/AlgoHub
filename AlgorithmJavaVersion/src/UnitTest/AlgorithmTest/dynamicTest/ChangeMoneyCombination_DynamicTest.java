package UnitTest.AlgorithmTest.dynamicTest;

import Algorithm.dynamic.ChangeMoneyCombination_Dynamic;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-25 16:42
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 换零钱【组合问题】
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

public class ChangeMoneyCombination_DynamicTest {

    @Test
    public void TestChangeMoneyCombination_Dynamic() {
        test(new ChangeMoneyCombination_Dynamic());
    }

    public void test(ChangeMoneyCombination_Dynamic changeMoneyDynamic) {
        int result = changeMoneyDynamic.method(demo01, demo01_target);
        assert result == 4;
        result = changeMoneyDynamic.method(demo02, demo02_target);
        assert result == 0;
        result = changeMoneyDynamic.method(demo03, demo03_target);
        assert result == 0;
        result = changeMoneyDynamic.method(demo04, demo04_target);
        assert result == 1;
        result = changeMoneyDynamic.method(demo05, demo05_target);
        assert result == 0;
        result = changeMoneyDynamic.method(demo06, demo06_target);
        assert result == 0;
    }

    int[] demo01 = {1, 2, 5};
    int demo01_target = 5;  //return : 4
    int[] demo02 = {2};
    int demo02_target = 3;   //return : 0
    int[] demo03 = {};
    int demo03_target = 11;  //return : -1
    int[] demo04 = {10};
    int demo04_target = 10;   //return : 1
    int[] demo05 = {1};
    int demo05_target = 0;   //return : 0
    int[] demo06 = {7};
    int demo06_target = 0;   //return : 0
}
