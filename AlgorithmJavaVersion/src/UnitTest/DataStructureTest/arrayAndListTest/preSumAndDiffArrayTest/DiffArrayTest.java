package UnitTest.DataStructureTest.arrayAndListTest.preSumAndDiffArrayTest;

import DataStructure.arrayRelevant.preSumAndDiffArray.DiffArray;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/9/8
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 差分数组
 */
public class DiffArrayTest {

    DiffArray diffArray = new DiffArray();

    //差分数组:通过差分数组获取原数组
    @Test
    public void testgetDiffOrigin() {
        int[] answer = diffArray.getDiffOrigin(diffArray.buildDiffArray(demo01));
        assert Arrays.equals(answer, demo01);
        answer = diffArray.getDiffOrigin(diffArray.buildDiffArray(demo02));
        assert Arrays.equals(answer, demo02);
        answer = diffArray.getDiffOrigin(diffArray.buildDiffArray(demo03));
        assert Arrays.equals(answer, demo03);
        answer = diffArray.getDiffOrigin(diffArray.buildDiffArray(demo04));
        assert Arrays.equals(answer, demo04);
    }

    int[] demo01 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    int[][] opear01 = {{2, 4, 1}, {3, 5, 2}, {7, 9, 6}, {2, 5, 5}, {1, 7, 2}};
    int[] target01 = {1, 3, 9, 11, 11, 10, 3, 9, 7, 7};

    int[] demo02 = {};
    int[][] opear02 = {{2, 4, 1}, {3, 5, 2}, {7, 9, 6}, {2, 5, 5}, {1, 7, 2}};
    int[] target02 = {};

    int[] demo03 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    int[][] opear03 = {{2, 3, 1}, {4, 9, -3}, {4, 7, 4}, {6, 7, -1}, {8, 20, 10}};
    int[] target03 = {1, 2, 4, 5, 6, 7, 7, 8, 16, 7};

    int[] demo04 = {0, 0, 0, 0, 0};
    int[][] opear04 = {{0, 1, 10}, {1, 2, 20}, {1, 4, 25}};
    int[] target04 = {10, 55, 45, 25, 25};
}
