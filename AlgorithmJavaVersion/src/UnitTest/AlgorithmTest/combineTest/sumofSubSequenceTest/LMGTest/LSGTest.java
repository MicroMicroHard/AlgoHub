package UnitTest.AlgorithmTest.combineTest.sumofSubSequenceTest.LMGTest;

import Algorithm.comprehensive.lmg.LMG_Dynamic;
import UnitTest.AlgorithmTest.combineTest.sumofSubSequenceTest.LargestValueTestData;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-25 16:41
 * @author—Email micromicrohard@outlook.com
 * @description 打家劫舍2 测试案例
 * 在一条直线上，有n个房屋，每个房屋中有数量不等的财宝，有一个盗 贼希望从房屋中盗取财宝，由于房屋中有报警器，
 * 如果同时从相邻的两个房屋中盗取财宝就会触发报警器。问在不触发报警器的前提下，最多可获取多少财宝？
 * 例如 {}，则选择空=0
 * 例如 {-5}，则选择 -5 = -5
 * 例如 {-5, 2}，则选择 2 = 2
 * 例如 {-5, 2, -6}，则选择-5 * -6 = 30
 * 例如 {-5, -6, 2} ，则选择 2 = 2
 * 例如 {-5, 2, -6, 0} ，则选择 -5 * -6 = 30
 * 例如 {5，2，6，3，1，7}，则选择 5 * 6 * 7 = 210
 * 例如 {5，2，6，3，1，-7}，则选择 5 * 6 = 30
 * 例如 {5，2，-6，3，1，-7}，则选择 5 * -6 * -7 = 210
 * 例如 {-5, -1, -6, 0, -3, 0, -7}，则选择-5 * -6 * -3 * -7 = 630
 * @blogURL
 */

public class LSGTest extends LargestValueTestData {

    @Test
    public void testLMG_Dynamic() {
        test(new LMG_Dynamic());
    }

    public void test(LMG_Dynamic instance) {
        int answer = instance.LargestMultiOfGap(demo01);
        assert answer == target01_lmg;
        answer = instance.LargestMultiOfGap(demo02);
        assert answer == target02_lmg;
        answer = instance.LargestMultiOfGap(demo03);
        assert answer == target03_lmg;
        answer = instance.LargestMultiOfGap(demo04);
        assert answer == target04_lmg;
        answer = instance.LargestMultiOfGap(demo05);
        assert answer == target05_lmg;
        answer = instance.LargestMultiOfGap(demo06);
        assert answer == target06_lmg;
        answer = instance.LargestMultiOfGap(demo07);
        assert answer == target07_lmg;
        answer = instance.LargestMultiOfGap(demo08);
        assert answer == target08_lmg;
        answer = instance.LargestMultiOfGap(demo09);
        assert answer == target09_lmg;

        answer = instance.LargestMultiOfGap(demo10);
        assert answer == target10_lmg;
        answer = instance.LargestMultiOfGap(demo11);
        assert answer == target11_lmg;
        answer = instance.LargestMultiOfGap(demo12);
        assert answer == target12_lmg;
        answer = instance.LargestMultiOfGap(demo13);
        assert answer == target13_lmg;
        answer = instance.LargestMultiOfGap(demo14);
        assert answer == target14_lmg;
        answer = instance.LargestMultiOfGap(demo15);
        assert answer == target15_lmg;
        answer = instance.LargestMultiOfGap(demo16);
        assert answer == target16_lmg;
        answer = instance.LargestMultiOfGap(demo17);
        assert answer == target17_lmg;
        answer = instance.LargestMultiOfGap(demo18);
        assert answer == target18_lmg;
        answer = instance.LargestMultiOfGap(demo19);
        assert answer == target19_lmg;

        answer = instance.LargestMultiOfGap(demo20);
        assert answer == target20_lmg;
        answer = instance.LargestMultiOfGap(demo21);
        assert answer == target21_lmg;
        answer = instance.LargestMultiOfGap(demo22);
        assert answer == target22_lmg;
        answer = instance.LargestMultiOfGap(demo23);
        assert answer == target23_lmg;
        answer = instance.LargestMultiOfGap(demo24);
        assert answer == target24_lmg;
        answer = instance.LargestMultiOfGap(demo25);
        assert answer == target25_lmg;
        answer = instance.LargestMultiOfGap(demo26);
        assert answer == target26_lmg;
        answer = instance.LargestMultiOfGap(demo27);
        assert answer == target27_lmg;
        answer = instance.LargestMultiOfGap(demo28);
        assert answer == target28_lmg;
        answer = instance.LargestMultiOfGap(demo29);
        assert answer == target29_lmg;

        answer = instance.LargestMultiOfGap(demo30);
        assert answer == target30_lmg;
        answer = instance.LargestMultiOfGap(demo31);
        assert answer == target31_lmg;
        answer = instance.LargestMultiOfGap(demo32);
        assert answer == target32_lmg;
        answer = instance.LargestMultiOfGap(demo33);
        assert answer == target33_lmg;
        answer = instance.LargestMultiOfGap(demo34);
        assert answer == target34_lmg;
        answer = instance.LargestMultiOfGap(demo35);
        assert answer == target35_lmg;
        answer = instance.LargestMultiOfGap(demo36);
        assert answer == target36_lmg;
        answer = instance.LargestMultiOfGap(demo37);
        assert answer == target37_lmg;
        answer = instance.LargestMultiOfGap(demo38);
        assert answer == target38_lmg;
        answer = instance.LargestMultiOfGap(demo39);
        assert answer == target39_lmg;

        answer = instance.LargestMultiOfGap(demo40);
        assert answer == target40_lmg;
        answer = instance.LargestMultiOfGap(demo41);
        assert answer == target41_lmg;
        answer = instance.LargestMultiOfGap(demo42);
        assert answer == target42_lmg;
    }
}
