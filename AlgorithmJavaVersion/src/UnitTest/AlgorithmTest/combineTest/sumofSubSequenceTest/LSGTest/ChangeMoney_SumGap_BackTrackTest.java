package UnitTest.AlgorithmTest.combineTest.sumofSubSequenceTest.LSGTest;

import Algorithm.comprehensive.lsg.ChangeMoney_SumGap_BackTrack;
import org.junit.Test;

public class ChangeMoney_SumGap_BackTrackTest {

    @Test
    public void test() {
        test(new ChangeMoney_SumGap_BackTrack());
    }

    public void test(ChangeMoney_SumGap_BackTrack instance) {
        boolean flag = instance.check(demo01, target01);
        assert !flag;
        flag = instance.check(demo02, target02);
        assert !flag;
        flag = instance.check(demo03, target03);
        assert !flag;
        flag = instance.check(demo04, target04);
        assert flag;
        flag = instance.check(demo05, target05);
        assert flag;
        flag = instance.check(demo06, target06);
        assert !flag;
        flag = instance.check(demo07, target07);
        assert !flag;
        flag = instance.check(demo08, target08);
        assert flag;
        flag = instance.check(demo09, target09);
        assert flag;
    }

    int[] demo01 = {};
    int target01 = 0;
    int[] demo02 = null;
    int target02 = 0;
    int[] demo03 = {1, 12, 5, 7};
    int target03 = 13;
    int[] demo04 = {1, 3, 12, 7};
    int target04 = 13;
    int[] demo05 = {1, 2, 5};
    int target05 = 5;
    int[] demo06 = {2};
    int target06 = 3;
    int[] demo07 = {1, 2, 5};
    int target07 = 3;
    int[] demo08 = {1, 3, 12, 7};
    int target08 = 8;
    int[] demo09 = {1, 3, 12, 7};
    int target09 = 10;
}
