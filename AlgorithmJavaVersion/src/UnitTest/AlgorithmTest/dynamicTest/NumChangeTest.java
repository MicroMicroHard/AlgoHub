package UnitTest.AlgorithmTest.dynamicTest;

import Algorithm.dynamic.NumChange;
import org.junit.Test;

public class NumChangeTest {

    @Test
    public void test() {
        test(new NumChange());
    }

    public void test(NumChange instance) {
        int answer = instance.GetChangeTime(demo01);
        assert answer == target01;
        answer = instance.GetChangeTime(demo02);
        assert answer == target02;
        answer = instance.GetChangeTime(demo03);
        assert answer == target03;
        answer = instance.GetChangeTime(demo04);
        assert answer == target04;
    }

    int demo01 = 1;
    int target01 = 0;
    int demo02 = 2;
    int target02 = 1;
    int demo03 = 3;
    int target03 = 2;
    int demo04 = 4;
    int target04 = 2;
}
