package UnitTest.DataStructureTest.arrayAndListTest.arrayApplyTest;

import DataStructure.arrayRelevant.arrayApply.MergeSection;
import Common.Utils.ArrayTools;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/1
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 输入：intervals = [[1,3},{2,6},{8,10},{15,18]]
 * 输出：[[1,6},{8,10},{15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 解析地址：https://leetcode-cn.com/problems/merge-intervals/
 */

public class MergeSectionTest {

    MergeSection m = new MergeSection();

    @Test
    public void TestMergeSectionTest() {
        int[][] answer = m.merge(demo01);
        assert ArrayTools.EqualsIntMatrix(answer, target01);
        answer = m.merge(demo02);
        assert ArrayTools.EqualsIntMatrix(answer, target02);
        answer = m.merge(demo03);
        assert ArrayTools.EqualsIntMatrix(answer, target03);
        answer = m.merge(demo04);
        assert ArrayTools.EqualsIntMatrix(answer, target04);
    }

    int[][] demo01 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] target01 = {{1, 6}, {8, 10}, {15, 18}};

    int[][] demo02 = {{1, 3}, {5, 7}, {8, 10}, {4, 9}};
    int[][] target02 = {{1, 3}, {4, 10}};

    int[][] demo03 = {{1, 3}, {1, 3}, {2, 6}, {0, 18}};
    int[][] target03 = {{0, 18}};

    int[][] demo04 = {{-1, 3}, {-2, 0}, {8, 10}, {15, 18}};
    int[][] target04 = {{-2, 3}, {8, 10}, {15, 18}};
}
