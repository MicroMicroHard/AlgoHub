package UnitTest.DataStructureTest.arrayAndListTest.doublePointTest;

import DataStructure.arrayRelevant.doublePoint.FindValueinArray;

import java.util.Arrays;
import java.util.List;

public class FindValueinArrayData {

    public void testgetPositions(FindValueinArray fg) {
        List list = fg.getPositions(demo01, 0);
        for (int i = 0; i < list.size(); i++) {
            int[] answer = (int[]) list.get(i);
            assert Arrays.equals(answer, target01[i]);
            assert !Arrays.equals(answer, target02[i]);
        }
    }

    int[] demo01 = new int[]{-1, 2, 1, 1, 1, -1};
    int[][] target01 = {{0, 2}, {0, 3}, {0, 4}, {2, 5}, {3, 5}, {4, 5}};
    int[][] target02 = {{0, 1}, {0, 4}, {0, 6}, {2, 8}, {3, 0}, {4, 1}};
}
