package UnitTest.AlgorithmTest.greedyTest;

import Algorithm.greedy.EraseOverlapIntervals;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/6/8
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 无重叠区间
 */
public class EraseOverlapIntervalsTest {

    EraseOverlapIntervals era = new EraseOverlapIntervals();

    @Test
    public void TestcountSection() {

        int value = era.countSection(demo01);
        assert value == 4;
        value = era.countSection(demo02);
        assert value == 3;
        value = era.countSection(demo03);
        assert value == 0;
        value = era.countSection(demo04);
        assert value == 0;
        value = era.countSection(demo05);
        assert value == 0;
        value = era.countSection(demo06);
        assert value == 5;
        value = era.countSection(demo07);
        assert value == 0;
        value = era.countSection(demo08);
        assert value == 2;
    }

    //互不重叠，重叠数为0,互不相交的数量为4
    public int[][] demo01 = {
            {1, 2}, {2, 3}, {3, 4}, {4, 5}
    };
    //互不相交的数量最大为3
    public int[][] demo02 = {
            {1, 3}, {2, 5}, {3, 4}, {4, 5}
    };
    //反案例，均为0
    public int[][] demo03 = {};
    public int[][] demo04 = null;
    public int[][] demo05 = {{}, {}, {}, {}};
    //互不相交的数量最大为5
    public int[][] demo06 = {
            {1, 3}, {4, 6}, {7, 9}, {9, 10}, {10, 17},
            {3, 8}, {9, 13},
            {2, 10},
            {5, 8}, {8, 11},
            {9, 14},
            {6, 10}, {5, 9}};
    //互不相交的数量最大为1
    public int[][] demo07 = {
            {}, {1, 3}, {}, {2, 4}
    };
    public int[][] demo08 = {
            {7, 10}, {2, 4},
    };
}
