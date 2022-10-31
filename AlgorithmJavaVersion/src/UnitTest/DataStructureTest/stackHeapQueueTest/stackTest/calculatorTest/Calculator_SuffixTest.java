package UnitTest.DataStructureTest.stackHeapQueueTest.stackTest.calculatorTest;

import DataStructure.heapStackQueue.stack.calculator.Calculator_Suffix;
import Top100.Calculator;
import org.junit.Test;

public class Calculator_SuffixTest {

    @Test
    public void test() {
        test(new Calculator_Suffix());
    }

    public void test(Calculator instance) {
        double target01 = instance.cal(demo01);
        assert target01 == answer01;
        target01 = instance.cal(demo02);
        assert target01 == answer02;
        target01 = instance.cal(demo03);
        assert target01 == answer03;
    }

    String demo01 = "2 3 +";
    double answer01 = 5;
    String demo02 = "2 3 * 5 + 6 -";//2*3+5-6
    double answer02 = 5;
    String demo03 = "16 8 2 / -";//16-8/2=12
    double answer03 = 12;
}
