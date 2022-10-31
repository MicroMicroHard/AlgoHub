package UnitTest.AlgorithmTest.combineTest.sumofSubSequenceTest.LSGTest;


import Algorithm.comprehensive.lsg.*;
import UnitTest.AlgorithmTest.combineTest.sumofSubSequenceTest.LargestValueTestData;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-25 16:41
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 打家劫舍 测试案例
 * @blogURL
 */
public class LSGTest extends LargestValueTestData {

    @Test
    public void TestLSG_Dynamic() {
        test(new LSG_Dynamic());
    }

    @Test
    public void TestLSG_Backtrack() {
        test(new LSG_Backtrack());
    }

    public void test(LSG instance) {
        int answer = instance.LargestSumOfGap(demo01);
        assert answer == target01_lsg;
        answer = instance.LargestSumOfGap(demo02);
        assert answer == target02_lsg;
        answer = instance.LargestSumOfGap(demo03);
        assert answer == target03_lsg;
        answer = instance.LargestSumOfGap(demo04);
        assert answer == target04_lsg;
        answer = instance.LargestSumOfGap(demo05);
        assert answer == target05_lsg;
        answer = instance.LargestSumOfGap(demo06);
        assert answer == target06_lsg;
        answer = instance.LargestSumOfGap(demo07);
        assert answer == target07_lsg;
        answer = instance.LargestSumOfGap(demo08);
        assert answer == target08_lsg;
        answer = instance.LargestSumOfGap(demo09);
        assert answer == target09_lsg;

        answer = instance.LargestSumOfGap(demo10);
        assert answer == target10_lsg;
        answer = instance.LargestSumOfGap(demo11);
        assert answer == target11_lsg;
        answer = instance.LargestSumOfGap(demo12);
        assert answer == target12_lsg;
        answer = instance.LargestSumOfGap(demo13);
        assert answer == target13_lsg;
        answer = instance.LargestSumOfGap(demo14);
        assert answer == target14_lsg;
        answer = instance.LargestSumOfGap(demo15);
        assert answer == target15_lsg;
        answer = instance.LargestSumOfGap(demo16);
        assert answer == target16_lsg;
        answer = instance.LargestSumOfGap(demo17);
        assert answer == target17_lsg;
        answer = instance.LargestSumOfGap(demo18);
        assert answer == target18_lsg;
        answer = instance.LargestSumOfGap(demo19);
        assert answer == target19_lsg;

        answer = instance.LargestSumOfGap(demo20);
        assert answer == target20_lsg;
        answer = instance.LargestSumOfGap(demo21);
        assert answer == target21_lsg;
        answer = instance.LargestSumOfGap(demo22);
        assert answer == target22_lsg;
        answer = instance.LargestSumOfGap(demo23);
        assert answer == target23_lsg;
        answer = instance.LargestSumOfGap(demo24);
        assert answer == target24_lsg;
        answer = instance.LargestSumOfGap(demo25);
        assert answer == target25_lsg;
        answer = instance.LargestSumOfGap(demo26);
        assert answer == target26_lsg;
        answer = instance.LargestSumOfGap(demo27);
        assert answer == target27_lsg;
        answer = instance.LargestSumOfGap(demo28);
        assert answer == target28_lsg;
        answer = instance.LargestSumOfGap(demo29);
        assert answer == target29_lsg;

        answer = instance.LargestSumOfGap(demo30);
        assert answer == target30_lsg;
        answer = instance.LargestSumOfGap(demo31);
        assert answer == target31_lsg;
        answer = instance.LargestSumOfGap(demo32);
        assert answer == target32_lsg;
        answer = instance.LargestSumOfGap(demo33);
        assert answer == target33_lsg;
        answer = instance.LargestSumOfGap(demo34);
        assert answer == target34_lsg;
        answer = instance.LargestSumOfGap(demo35);
        assert answer == target35_lsg;
        answer = instance.LargestSumOfGap(demo36);
        assert answer == target36_lsg;
        answer = instance.LargestSumOfGap(demo37);
        assert answer == target37_lsg;
        answer = instance.LargestSumOfGap(demo38);
        assert answer == target38_lsg;
        answer = instance.LargestSumOfGap(demo39);
        assert answer == target39_lsg;

        answer = instance.LargestSumOfGap(demo40);
        assert answer == target40_lsg;
        answer = instance.LargestSumOfGap(demo41);
        assert answer == target41_lsg;
        answer = instance.LargestSumOfGap(demo42);
        assert answer == target42_lsg;
    }
}
