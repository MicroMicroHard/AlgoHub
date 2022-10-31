package UnitTest.DataStructureTest.arrayAndListTest.arrayApplyTest;

import DataStructure.heapStackQueue.heap.GetMidNum;
import org.junit.Test;

public class GetMidNumTest {

    GetMidNum gm = new GetMidNum();

    @Test
    public void testGetMidNum() {
        double answer = 0;
        for (int i = 0; i < demo01.length / 2; i++) {
            gm.addNum(demo01[i]);
            answer = gm.findMedian();
        }
        assert answer == 2.5;
        for (int i = demo01.length / 2; i < demo01.length; i++) {
            gm.addNum(demo01[i]);
            answer = gm.findMedian();
        }
        assert answer == 4.5;
        for (int i = 0; i < demo02.length / 2; i++) {
            gm.addNum(demo02[i]);
            answer = gm.findMedian();
        }
        assert answer == 2.5;

        for (int i = demo02.length / 2; i < demo02.length; i++) {
            gm.addNum(demo02[i]);
            answer = gm.findMedian();
        }
        assert answer == 0;
    }

    int[] demo01 = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] demo02 = {-1, -2, -3, -4, -5, -6, -7, -8};
}
