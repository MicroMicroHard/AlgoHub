package UnitTest.AlgorithmTest.combineTest.sumofSubSequenceTest.LMSTest;

import Algorithm.comprehensive.lms.*;
import UnitTest.AlgorithmTest.combineTest.sumofSubSequenceTest.LargestValueTestData;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/1/27
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 最大子段乘积(连续)
 * 给定一个数组，求出这个数组最大连续的子段乘积
 * 输入：{5, -4, 3, 4, 9}
 * 输出：3 * 4 * 9 = 108
 */
public class LMSTest extends LargestValueTestData {

    @Test
    public void testLMS_Dynamic() {
        test(new LMS_Dynamic());
    }

    @Test
    public void testLMS_BackTrack() {
        test(new LMS_BackTrack());
    }

    @Test
    public void testLMS_Dynamic_1() {
        test(new LMS_Dynamic_1());
    }

    @Test
    public void testLMS_Dynamic_2() {
        test(new LMS_Dynamic_2());
    }

    public void test(LMS instance) {
        long answer = instance.LargestMultiOfSubSequence(demo01);
        assert answer == target01_lms;
        answer = instance.LargestMultiOfSubSequence(demo02);
        assert answer == target02_lms;
        answer = instance.LargestMultiOfSubSequence(demo03);
        assert answer == target03_lms;
        answer = instance.LargestMultiOfSubSequence(demo04);
        assert answer == target04_lms;
        answer = instance.LargestMultiOfSubSequence(demo05);
        assert answer == target05_lms;
        answer = instance.LargestMultiOfSubSequence(demo06);
        assert answer == target06_lms;
        answer = instance.LargestMultiOfSubSequence(demo07);
        assert answer == target07_lms;
        answer = instance.LargestMultiOfSubSequence(demo08);
        assert answer == target08_lms;
        answer = instance.LargestMultiOfSubSequence(demo09);
        assert answer == target09_lms;

        answer = instance.LargestMultiOfSubSequence(demo10);
        assert answer == target10_lms;
        answer = instance.LargestMultiOfSubSequence(demo11);
        assert answer == target11_lms;
        answer = instance.LargestMultiOfSubSequence(demo12);
        assert answer == target12_lms;
        answer = instance.LargestMultiOfSubSequence(demo13);
        assert answer == target13_lms;
        answer = instance.LargestMultiOfSubSequence(demo14);
        assert answer == target14_lms;
        answer = instance.LargestMultiOfSubSequence(demo15);
        assert answer == target15_lms;
        answer = instance.LargestMultiOfSubSequence(demo16);
        assert answer == target16_lms;
        answer = instance.LargestMultiOfSubSequence(demo17);
        assert answer == target17_lms;
        answer = instance.LargestMultiOfSubSequence(demo18);
        assert answer == target18_lms;
        answer = instance.LargestMultiOfSubSequence(demo19);
        assert answer == target19_lms;

        answer = instance.LargestMultiOfSubSequence(demo20);
        assert answer == target20_lms;
        answer = instance.LargestMultiOfSubSequence(demo21);
        assert answer == target21_lms;
        answer = instance.LargestMultiOfSubSequence(demo22);
        assert answer == target22_lms;
        answer = instance.LargestMultiOfSubSequence(demo23);
        assert answer == target23_lms;
        answer = instance.LargestMultiOfSubSequence(demo24);
        assert answer == target24_lms;
        answer = instance.LargestMultiOfSubSequence(demo25);
        assert answer == target25_lms;
        answer = instance.LargestMultiOfSubSequence(demo26);
        assert answer == target26_lms;
        answer = instance.LargestMultiOfSubSequence(demo27);
        assert answer == target27_lms;
        answer = instance.LargestMultiOfSubSequence(demo28);
        assert answer == target28_lms;
        answer = instance.LargestMultiOfSubSequence(demo29);
        assert answer == target29_lms;

        answer = instance.LargestMultiOfSubSequence(demo30);
        assert answer == target30_lms;
        answer = instance.LargestMultiOfSubSequence(demo31);
        assert answer == target31_lms;
        answer = instance.LargestMultiOfSubSequence(demo32);
        assert answer == target32_lms;
        answer = instance.LargestMultiOfSubSequence(demo33);
        assert answer == target33_lms;
        answer = instance.LargestMultiOfSubSequence(demo34);
        assert answer == target34_lms;
        answer = instance.LargestMultiOfSubSequence(demo35);
        assert answer == target35_lms;
        answer = instance.LargestMultiOfSubSequence(demo36);
        assert answer == target36_lms;
        answer = instance.LargestMultiOfSubSequence(demo37);
        assert answer == target37_lms;
        answer = instance.LargestMultiOfSubSequence(demo38);
        assert answer == target38_lms;
        answer = instance.LargestMultiOfSubSequence(demo39);
        assert answer == target39_lms;

        answer = instance.LargestMultiOfSubSequence(demo40);
        assert answer == target40_lms;
        answer = instance.LargestMultiOfSubSequence(demo41);
        assert answer == target41_lms;
        answer = instance.LargestMultiOfSubSequence(demo42);
        assert answer == target42_lms;
    }
}
