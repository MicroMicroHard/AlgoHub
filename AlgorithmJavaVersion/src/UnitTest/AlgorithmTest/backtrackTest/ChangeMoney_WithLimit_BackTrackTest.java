package UnitTest.AlgorithmTest.backtrackTest;

import Algorithm.backtrack.ChangeMoney_WithLimit_BackTrack;
import org.junit.Test;

public class ChangeMoney_WithLimit_BackTrackTest {

    @Test
    public void test() {
        test(new ChangeMoney_WithLimit_BackTrack());
    }

    public void test(ChangeMoney_WithLimit_BackTrack instance) {
        boolean flag = instance.GetTargetValue(demo01, limit01, target01);
        assert !flag;
        flag = instance.GetTargetValue(demo02, limit02, target02);
        assert !flag;
        flag = instance.GetTargetValue(demo03, limit03, target03);
        assert flag;
        flag = instance.GetTargetValue(demo04, limit04, target04);
        assert !flag;
        flag = instance.GetTargetValue(demo05, limit05, target05);
        assert !flag;
        flag = instance.GetTargetValue(demo06, limit06, target06);
        assert flag;
        flag = instance.GetTargetValue(demo07, limit07, target07);
        assert flag;
    }

    int[] demo01 = null;
    int[] limit01 = {};
    int target01 = 0;
    int[] demo02 = {};
    int[] limit02 = {};
    int target02 = 0;
    int[] demo03 = {1, 2, 5, 8};
    int[] limit03 = {1, 2, 0, 4};
    int target03 = 17;
    int[] demo04 = {1, 2, 5};
    int[] limit04 = {2, 2, 2};
    int target04 = 17;
    int[] demo05 = {1, 2, 5};
    int[] limit05 = {2, 2, 2};
    int target05 = 17;
    int[] demo06 = {1, 2, 5};
    int[] limit06 = {3, 2, 0};
    int target06 = 6;
    int[] demo07 = {0, 0, 0};
    int[] limit07 = {0, 0, 0};
    int target07 = 0;
}
