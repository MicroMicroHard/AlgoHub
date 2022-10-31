package UnitTest.AlgorithmTest.combineTest.sumofSubSequenceTest.LMGTest;

import Algorithm.comprehensive.lmg.ChangeMoney_BackTrack;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-25 16:42
 * @author—Email micromicrohard@outlook.com
 * @description 换零钱
 * 给定一个数组，数组内数字随意组合【不可以重复选取】，是否可以凑出乘积等于target的组合
 * 示例 1:
 * 输入: coins = [1, 2, 5], target = 5
 * 输出: true
 * 解释: 5 = 1 * 5
 * <p>
 * 示例 2:
 * 输入: coins = [2, 4, 9, 11], target = 22
 * 输出: true
 * 解释: 22 = 2 * 11
 * 示例 2:
 * 输入: coins = [2, 4, 9, 11], target = 37
 * 输出: false
 */

public class ChangeMoney_BackTrackTest {

    @Test
    public void test() {
        test(new ChangeMoney_BackTrack());
    }

    public void test(ChangeMoney_BackTrack instance) {
        boolean answer = instance.Check(demo01, target01);
        assert answer;
        answer = instance.Check(demo02, target02);
        assert !answer;
        answer = instance.Check(demo03, target03);
        assert !answer;
        answer = instance.Check(demo04, target04);
        assert !answer;
        answer = instance.Check(demo05, target05);
        assert !answer;
        answer = instance.Check(demo06, target06);
        assert !answer;
        answer = instance.Check(demo07, target07);
        assert answer;
        answer = instance.Check(demo08, target08);
        assert answer;
        answer = instance.Check(demo09, target09);
        assert answer;
        answer = instance.Check(demo10, target10);
        assert answer;
        answer = instance.Check(demo11, target11);
        assert answer;
        answer = instance.Check(demo12, target12);
        assert answer;
        answer = instance.Check(demo13, target13);
        assert answer;
    }

    int[] demo01 = {1, 2, 5};
    int target01 = 5;
    int[] demo02 = {2, 4, 9, 1};
    int target02 = 22;
    int[] demo03 = {1, 2, 5};
    int target03 = 37;
    int[] demo04 = null;
    int target04 = 37;
    int[] demo05 = {};
    int target05 = 37;
    int[] demo06 = {1, 2, 5};
    int target06 = 0;
    int[] demo07 = {7, 6, 4, 3, 4, 5, 6, 7};
    int target07 = 49;
    int[] demo08 = {7, 6, 4, 3, 4, 5, 6, 7};
    int target08 = 980;
    int[] demo09 = {7, 6, 4, 3, 5, 5, 6, 7};
    int target09 = 3600;
    int[] demo10 = {1, 2, 0, 5};
    int target10 = 0;
    int[] demo11 = {1, 2, 4, 8, 7, 6, 5, 4, 5};
    int target11 = 100;
    int[] demo12 = {1, 2, 4, 8, 7, 6, 5, 4, 5}; //2,6,5,5
    int target12 = 300;
    int[] demo13 = {1, 2, 4, 8, 7, 6, 5, 4, 5};
    int target13 = 1;
}
