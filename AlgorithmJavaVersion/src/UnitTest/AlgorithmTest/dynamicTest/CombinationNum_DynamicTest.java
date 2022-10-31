package UnitTest.AlgorithmTest.dynamicTest;

import Algorithm.dynamic.CombinationNum_Dynamic;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-25 16:42
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 求数组中元素之和为指定值
 * CombinationNum_NonRepeat(dynamic)
 * 给你一个 只包含正整数 的 非空 数组 nums 和一个给定值 Target 。求出数组中是否存在某些值相加等于 Target。
 */

public class CombinationNum_DynamicTest {

    @Test
    public void test() {
        test(new CombinationNum_Dynamic());
    }

    public void test(CombinationNum_Dynamic instance) {
        boolean flag = instance.GetTargetValue(demo01, target01);
        assert !flag;
        flag = instance.GetTargetValue(demo02, target02);
        assert !flag;
        flag = instance.GetTargetValue(demo03, target03);
        assert flag;
        flag = instance.GetTargetValue(demo04, target04);
        assert flag;
        flag = instance.GetTargetValue(demo05, target05);
        assert flag;
        flag = instance.GetTargetValue(demo06, target06);
        assert flag;
        flag = instance.GetTargetValue(demo07, target07);
        assert flag;
        flag = instance.GetTargetValue(demo08, target08);
        assert flag;
        flag = instance.GetTargetValue(demo09, target09);
        assert flag;
        flag = instance.GetTargetValue(demo10, target10);
        assert flag;
        flag = instance.GetTargetValue(demo11, target11);
        assert !flag;
        flag = instance.GetTargetValue(demo12, target12);
        assert !flag;
        flag = instance.GetTargetValue(demo13, target13);
        assert flag;
    }

    int[] demo01 = {};
    int target01 = 0;
    int[] demo02 = null;
    int target02 = 0;
    int[] demo03 = {1, 2, 5};
    int target03 = 9;
    int[] demo04 = {5, 6, 7, 8, 7, 6, 5};
    int target04 = 116;

    int[] demo05 = {5, 6, 7, 8, 7, 6, 5};
    int target05 = 10;
    int[] demo06 = {5, 6, 7, 8, 7, 6, 5};
    int target06 = 18;
    int[] demo07 = {1, 1, 1, 1, 1, 1, 1};
    int target07 = 7;
    int[] demo08 = {1};
    int target08 = 8;
    int[] demo09 = {1, 1, -9, 1, 1, 1, 1};
    int target09 = -8;
    int[] demo10 = {1, 1, -2, -3, -4, 1, 1};
    int target10 = -8;
    int[] demo11 = {2, 3};
    int target11 = 1;
    int[] demo12 = {3};
    int target12 = 5;
    int[] demo13 = {5};
    int target13 = 15;
}
