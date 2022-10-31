package UnitTest.DataStructureTest.arrayAndListTest.preSumAndDiffArrayTest;

import DataStructure.arrayRelevant.preSumAndDiffArray.PreSumArrayApply_ChangeMoney;
import org.junit.Test;

public class PreSumArrayApply_ChangeMoneyTest {

    @Test
    public void test() {
        test(new PreSumArrayApply_ChangeMoney());
    }

    public void test(PreSumArrayApply_ChangeMoney instance) {
        boolean answer = instance.check(demo01, target01);
        assert answer;
        answer = instance.check(demo02, target02);
        assert !answer;
        answer = instance.check(demo03, target03);
        assert !answer;
        answer = instance.check(demo04, target04);
        assert answer;
        answer = instance.check(demo05, target05);
        assert answer;
        answer = instance.check(demo06, target06);
        assert answer;
    }

    int[] demo01 = {2, 4, -1, 1, 3, 5, -9};
    int target01 = 0;
    int[] demo02 = {};
    int target02 = 0;
    int[] demo03 = null;
    int target03 = 0;
    int[] demo04 = {2, 4, 1, 9, 5, 5, -9};
    int target04 = 20;
    int[] demo05 = {2, 4, 1, 9, 5, 5, -9, 2, 4, 1, 9, 5, 5, -9};
    int target05 = 2;
    int[] demo06 = {2, 4, 1, 9, 5, 5, -9, 2, 4, 1, 9, 5, 5, -9};
    int target06 = 3;
}
