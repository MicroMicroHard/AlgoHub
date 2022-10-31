package UnitTest.DataStructureTest.arrayAndListTest.findValueTest;

import DataStructure.arrayRelevant.findValue.FindDiffinMonotonousArray;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2020-01-08 14:03
 * @authorEmail ljfirst@mail.ustc.edu.cn
 * @description
 * @blogURL
 */
public class FindDiffinMonotonousArrayTest {

    @Test
    public void testfind() {
        test(new FindDiffinMonotonousArray());
    }

    public void test(FindDiffinMonotonousArray findDiffinMonotonousArray) {
        int count = findDiffinMonotonousArray.find(Demo01);
        assert count == 9;
        count = findDiffinMonotonousArray.find(Demo02);
        assert count == 9;
        count = findDiffinMonotonousArray.find(Demo03);
        assert count == 7;
        count = findDiffinMonotonousArray.find(Demo04);
        assert count == 9;
        count = findDiffinMonotonousArray.find(Demo05);
        assert count == 6;
        count = findDiffinMonotonousArray.find(Demo051);
        assert count == 6;
        count = findDiffinMonotonousArray.find(Demo06);
        assert count == 1;
    }

    int[] Demo01 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 7, 6, 3, 1};
    int[] Demo02 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] Demo03 = {9, 8, 7, 6, 4, 3, 1};
    int[] Demo04 = {1, 2, 4, 4, 5, 6, 8, 9, 9, 7, 6, 4, 3, 1};
    int[] Demo05 = {2, 2, 6, 7, 5, 4, 1};
    int[] Demo051 = {2, 2, 6, 7, 5, 2, 4, 1};
    int[] Demo06 = {2, 2, 2, 2, 2, 2};
}
