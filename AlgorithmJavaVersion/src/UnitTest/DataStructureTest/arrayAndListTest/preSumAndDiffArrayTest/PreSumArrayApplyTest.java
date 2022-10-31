package UnitTest.DataStructureTest.arrayAndListTest.preSumAndDiffArrayTest;

import DataStructure.arrayRelevant.preSumAndDiffArray.PreSumArrayApply;
import org.junit.Test;

public class PreSumArrayApplyTest extends PreSumArrayTest {

    PreSumArrayApply psa = new PreSumArrayApply();

    @Test
    public void testCountOfSumEqualsK() {
        int answer = psa.CountOfSumEqualsK(demo01, 5);
        assert answer == 2;
        answer = psa.CountOfSumEqualsK(demo02, 5);
        assert answer == 7;
        answer = psa.CountOfSumEqualsK(demo03, 5);
        assert answer == 3;
        answer = psa.CountOfSumEqualsK(demo04, 5);
        assert answer == 10;
        answer = psa.CountOfSumEqualsK(demo05, 5);
        assert answer == 0;
        answer = psa.CountOfSumEqualsK(demo06, 5);
        assert answer == 10;
        answer = psa.CountOfSumEqualsK(demo07, 5);
        assert answer == 6;
        answer = psa.CountOfSumEqualsK(demo08, 5);
        assert answer == 1;
        answer = psa.CountOfSumEqualsK(demo081, 5);
        assert answer == 2;
        answer = psa.CountOfSumEqualsK(demo09, 0);
        assert answer == 10;
    }
}
