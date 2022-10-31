package UnitTest.AlgorithmTest.backtrackTest;

import Algorithm.backtrack.CombinationPlus;
import DataStructure.stringOps.slidingWindow.Combination_Sliding;
import Common.Utils.ArrayTools;
import Top100.CombinationAndPermutation;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/19
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 数组的连续积小于给定值的组合 测试案例
 */
public class CombinationTest {

    @Test
    public void testArrayPermutationPlus() {
        test(new CombinationPlus());
    }

    @Test
    public void testArrayPermutation_Sliding() {
        test(new Combination_Sliding());
    }

    public void test(CombinationAndPermutation instance) {
        int[][] answer = instance.Solution(demo01, target01);
        assert ArrayTools.EqualsIntMatrix(answer, answer01);
        answer = instance.Solution(demo02, target02);
        assert ArrayTools.EqualsIntMatrix(answer, answer02);
        answer = instance.Solution(demo03, target03);
        assert ArrayTools.EqualsIntMatrix(answer, answer03);
        answer = instance.Solution(demo04, target04);
        assert ArrayTools.EqualsIntMatrix(answer, answer04);
    }

    public int[] demo01 = {10, 5, 2, 6};
    public int target01 = 100;
    public int[][] answer01 = {
            {2},
            {5},
            {6},
            {10},
            {2, 6},
            {5, 2},
            {10, 5},
            {5, 2, 6},
            {10, 5, 2}
    };

    public int[] demo02 = {2, 8, 4, 6, 9, 3};
    public int target02 = 64;
    public int[][] answer02 = {
            {2},
            {3},
            {4},
            {6},
            {8},
            {9},
            {2, 8},
            {4, 6},
            {6, 9},
            {8, 4},
            {9, 3},
            {2, 8, 4},
    };

    public int[] demo03 = {2, 8, 9, 3, 7, 2};
    public int target03 = 72;
    public int[][] answer03 = {
            {2},
            {2},
            {3},
            {7},
            {8},
            {9},
            {2, 8},
            {3, 7},
            {7, 2},
            {8, 9},
            {9, 3},
            {3, 7, 2},
    };

    public int[] demo04 = {1, 5, 3, 2, 4};
    public int target04 = 6;
    public int[][] answer04 = {
            {1},
            {2},
            {3},
            {4},
            {5},
            {1, 5},
            {3, 2}
    };
}
