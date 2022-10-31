package UnitTest.AlgorithmTest.dynamicTest;

import Algorithm.dynamic.NumChangeOps;
import org.junit.Test;

public class NumChangeOpsTest {

    @Test
    public void test() {
        test(new NumChangeOps());
    }

    public void test(NumChangeOps instance) {
        int answer = instance.GetChangeTime(5, 5, 2);
        assert answer == 2;
    }

}
