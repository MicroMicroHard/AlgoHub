package UnitTest.AlgorithmTest.backtrackTest;

import Algorithm.backtrack.ArrayCombination;
import Algorithm.backtrack.ArrayCombination_SingleLock;
import Algorithm.backtrack.ArrayCombination_WithMap;
import Algorithm.backtrack.ArrayCombination_WithMapArray;
import Common.Utils.ArrayTools;
import org.junit.Test;

import java.util.List;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-8-23 上午09:56:39
 * @author—Email micromicrohard@outlook.com
 * @description 数组全排列
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入：[1、2、3]
 * 输出：[1,2,3]、[1,3,2]、[2,1,3]、[2,3,1]、[3,1,2]、[3,2,1]
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：[1,1,2]、[1,2,1]、[2,1,1]]
 * @attation 1.返回所有不重复的全排列
 * 2.循环处i = depth
 */

public class ArrayCombinationTest {

    @Test
    public void testArrayCombination() {
        // 使用每层一个visit遍历器来统计是否访问过
        test(new ArrayCombination());
    }

    @Test
    public void testArrayCombinationWithMap() {
        // 利用map去重
        test(new ArrayCombination_WithMap());
    }

    @Test
    public void testArrayCombinationWithMapArray() {
        // 使用一个总的visit遍历器来统计是否访问过，结束的时候，进行底层去除
        test(new ArrayCombination_WithMapArray());
    }

    @Test
    public void testArrayCombination_SingleLock() {
        // 使用一个总的visit遍历器来统计是否访问过，结束的时候，进行底层去除
        test(new ArrayCombination_SingleLock());
    }


    public void test(ArrayCombination instance) {
        List list = instance.permuteUnique(demo01);
        assert ArrayTools.EqualsIntMatrix(ArrayTools.ListSort(list), target01);
        list = instance.permuteUnique(demo02);
        assert ArrayTools.EqualsIntMatrix(ArrayTools.ListSort(list), target02);
        list = instance.permuteUnique(demo03);
        assert ArrayTools.EqualsIntMatrix(ArrayTools.ListSort(list), target03);
        list = instance.permuteUnique(demo04);
        assert ArrayTools.EqualsIntMatrix(ArrayTools.ListSort(list), target04);
    }

    int[] demo01 = {1, 2, 3};
    int[][] target01 = {
            {1, 2, 3}, {1, 3, 2},
            {2, 1, 3}, {2, 3, 1},
            {3, 1, 2}, {3, 2, 1}
    };
    int[] demo02 = {1, 1, 2};
    int[][] target02 = {
            {1, 1, 2}, {1, 2, 1},
            {2, 1, 1}
    };
    int[] demo03 = {1, 1, 2, 2, 3, 3};
    int[][] target03 = {
            {1, 1, 2, 2, 3, 3}, {1, 1, 2, 3, 2, 3}, {1, 1, 2, 3, 3, 2},
            {1, 1, 3, 2, 2, 3}, {1, 1, 3, 2, 3, 2}, {1, 1, 3, 3, 2, 2},
            {1, 2, 1, 2, 3, 3}, {1, 2, 1, 3, 2, 3}, {1, 2, 1, 3, 3, 2},
            {1, 2, 2, 1, 3, 3}, {1, 2, 2, 3, 1, 3}, {1, 2, 2, 3, 3, 1},
            {1, 2, 3, 1, 2, 3}, {1, 2, 3, 1, 3, 2}, {1, 2, 3, 2, 1, 3},
            {1, 2, 3, 2, 3, 1}, {1, 2, 3, 3, 1, 2}, {1, 2, 3, 3, 2, 1},
            {1, 3, 1, 2, 2, 3}, {1, 3, 1, 2, 3, 2}, {1, 3, 1, 3, 2, 2},
            {1, 3, 2, 1, 2, 3}, {1, 3, 2, 1, 3, 2}, {1, 3, 2, 2, 1, 3},
            {1, 3, 2, 2, 3, 1}, {1, 3, 2, 3, 1, 2}, {1, 3, 2, 3, 2, 1},
            {1, 3, 3, 1, 2, 2}, {1, 3, 3, 2, 1, 2}, {1, 3, 3, 2, 2, 1},
            {2, 1, 1, 2, 3, 3}, {2, 1, 1, 3, 2, 3}, {2, 1, 1, 3, 3, 2},
            {2, 1, 2, 1, 3, 3}, {2, 1, 2, 3, 1, 3}, {2, 1, 2, 3, 3, 1},
            {2, 1, 3, 1, 2, 3}, {2, 1, 3, 1, 3, 2}, {2, 1, 3, 2, 1, 3},
            {2, 1, 3, 2, 3, 1}, {2, 1, 3, 3, 1, 2}, {2, 1, 3, 3, 2, 1},
            {2, 2, 1, 1, 3, 3}, {2, 2, 1, 3, 1, 3}, {2, 2, 1, 3, 3, 1},
            {2, 2, 3, 1, 1, 3}, {2, 2, 3, 1, 3, 1}, {2, 2, 3, 3, 1, 1},
            {2, 3, 1, 1, 2, 3}, {2, 3, 1, 1, 3, 2}, {2, 3, 1, 2, 1, 3},
            {2, 3, 1, 2, 3, 1}, {2, 3, 1, 3, 1, 2}, {2, 3, 1, 3, 2, 1},
            {2, 3, 2, 1, 1, 3}, {2, 3, 2, 1, 3, 1}, {2, 3, 2, 3, 1, 1},
            {2, 3, 3, 1, 1, 2}, {2, 3, 3, 1, 2, 1}, {2, 3, 3, 2, 1, 1},
            {3, 1, 1, 2, 2, 3}, {3, 1, 1, 2, 3, 2}, {3, 1, 1, 3, 2, 2},
            {3, 1, 2, 1, 2, 3}, {3, 1, 2, 1, 3, 2}, {3, 1, 2, 2, 1, 3},
            {3, 1, 2, 2, 3, 1}, {3, 1, 2, 3, 1, 2}, {3, 1, 2, 3, 2, 1},
            {3, 1, 3, 1, 2, 2}, {3, 1, 3, 2, 1, 2}, {3, 1, 3, 2, 2, 1},
            {3, 2, 1, 1, 2, 3}, {3, 2, 1, 1, 3, 2}, {3, 2, 1, 2, 1, 3},
            {3, 2, 1, 2, 3, 1}, {3, 2, 1, 3, 1, 2}, {3, 2, 1, 3, 2, 1},
            {3, 2, 2, 1, 1, 3}, {3, 2, 2, 1, 3, 1}, {3, 2, 2, 3, 1, 1},
            {3, 2, 3, 1, 1, 2}, {3, 2, 3, 1, 2, 1}, {3, 2, 3, 2, 1, 1},
            {3, 3, 1, 1, 2, 2}, {3, 3, 1, 2, 1, 2}, {3, 3, 1, 2, 2, 1},
            {3, 3, 2, 1, 1, 2}, {3, 3, 2, 1, 2, 1}, {3, 3, 2, 2, 1, 1}
    };
    int[] demo04 = {2, 6, 8, 2};
    int[][] target04 = {
            {2, 2, 6, 8}, {2, 2, 8, 6}, {2, 6, 2, 8},
            {2, 6, 8, 2}, {2, 8, 2, 6}, {2, 8, 6, 2},
            {6, 2, 2, 8}, {6, 2, 8, 2}, {6, 8, 2, 2},
            {8, 2, 2, 6}, {8, 2, 6, 2}, {8, 6, 2, 2},
    };
}
