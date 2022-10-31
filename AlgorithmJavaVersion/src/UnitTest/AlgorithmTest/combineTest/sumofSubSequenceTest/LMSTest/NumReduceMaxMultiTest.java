package UnitTest.AlgorithmTest.combineTest.sumofSubSequenceTest.LMSTest;

import Algorithm.comprehensive.lms.NumReduceMaxMulti;
import Algorithm.comprehensive.lms.NumReduceMaxMulti_Math;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-25 16:44
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 数字的最大乘积（类似的题目还有剪绳子）测试案例
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，
 * 并使这些整数的乘积最大化。 返回你可以获得的最大乘积
 * input:1    output:1
 * input:2    output:1
 * input:3    output:2
 * input:4    output:4
 * input:5    output:6
 * input:6    output:9
 * input:7    output:12
 * input:8    output:18
 * input:9    output:27
 * input:10   output:36
 * @blogURL
 */

public class NumReduceMaxMultiTest {

    @Test
    public void testReduce() {
        test(new NumReduceMaxMulti());
    }

    @Test
    public void testReduce_Math() {
        test(new NumReduceMaxMulti_Math());
    }

    public void test(NumReduceMaxMulti numReduceMaxMulti) {
        int value = numReduceMaxMulti.reduce(DemoNum01);
        assert value == Answer01;
        value = numReduceMaxMulti.reduce(DemoNum02);
        assert value == Answer02;
        value = numReduceMaxMulti.reduce(DemoNum03);
        assert value == Answer03;
        value = numReduceMaxMulti.reduce(DemoNum04);
        assert value == Answer04;
        value = numReduceMaxMulti.reduce(DemoNum05);
        assert value == Answer05;
        value = numReduceMaxMulti.reduce(DemoNum06);
        assert value == Answer06;
        value = numReduceMaxMulti.reduce(DemoNum07);
        assert value == Answer07;
        value = numReduceMaxMulti.reduce(DemoNum08);
        assert value == Answer08;
        value = numReduceMaxMulti.reduce(DemoNum09);
        assert value == Answer09;
        value = numReduceMaxMulti.reduce(DemoNum10);
        assert value == Answer10;
        value = numReduceMaxMulti.reduce(DemoNum011);
        assert value == Answer011;
        value = numReduceMaxMulti.reduce(DemoNum022);
        assert value == Answer022;
    }

    int DemoNum011 = 0;
    int Answer011 = 0;
    int DemoNum022 = -1;
    int Answer022 = -1;

    int DemoNum01 = 1;
    int Answer01 = 1;
    int DemoNum02 = 2;
    int Answer02 = 1;
    int DemoNum03 = 3;
    int Answer03 = 2;
    int DemoNum04 = 4;
    int Answer04 = 4;
    int DemoNum05 = 5;
    int Answer05 = 6;
    int DemoNum06 = 6;
    int Answer06 = 9;
    int DemoNum07 = 7;
    int Answer07 = 12;
    int DemoNum08 = 8;
    int Answer08 = 18;
    int DemoNum09 = 9;
    int Answer09 = 27;
    int DemoNum10 = 10;
    int Answer10 = 36;
}
