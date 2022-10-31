package UnitTest.AlgorithmTest.backtrackTest;

import Algorithm.backtrack.ChangeMoneyPermutation_BackTrack;
import Common.Utils.ArrayTools;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-25 16:42
 * @author—Email micromicrohard@outlook.com
 * @description 换零钱 【排列问题】
 * 给定不同面额的硬币 array 和一个总金额 target。编写一个函数来计算可以凑成总金额 所有可能的情况。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 * 输入：amount = 5, array = [1, 2, 5]
 * 输出：{
 * {5},
 * {1,2,2},
 * {2,1,2},
 * {2,2,1},
 * {1,1,1,2},
 * {1,1,2,1},
 * {1,2,1,1},
 * {2,1,1,1},
 * {1,1,1,1,1},
 * }
 * 示例 2:
 * 输入：amount = 3, array = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 * <p>
 * 示例 3:
 * 输入：amount = 10, array = [10]
 * 输出：{10}
 */

public class ChangeMoneyPermutation_BackTrackTest {

    @Test
    public void test() {
        test(new ChangeMoneyPermutation_BackTrack());
    }

    public void test(ChangeMoneyPermutation_BackTrack instance) {
        int[][] answer = instance.Solution(demo01, target01);
        assert ArrayTools.EqualsIntMatrix(answer, answer01);
        answer = instance.Solution(demo02, target02);
        assert ArrayTools.EqualsIntMatrix(answer, answer02);
        answer = instance.Solution(demo03, target03);
        assert ArrayTools.EqualsIntMatrix(answer, answer03);
        /*answer = instance.getAnswer(demo04, target04);
        assert ArrayUtilsImpl.IntMatrixEquals(answer, answer04);*/
    }

    int[] demo01 = {1, 2, 5};
    int target01 = 5;
    int[][] answer01 = {
            {5},
            {1, 2, 2},
            {2, 1, 2},
            {2, 2, 1},
            {1, 1, 1, 2},
            {1, 1, 2, 1},
            {1, 2, 1, 1},
            {2, 1, 1, 1},
            {1, 1, 1, 1, 1}
    };

    int[] demo02 = {2};
    int target02 = 3;
    int[][] answer02 = new int[][]{};

    int[] demo03 = {10};
    int target03 = 10;
    int[][] answer03 = {
            {10}
    };

    int[] demo04 = {1, 1, 2, 5};
    int target04 = 5;
    int[][] answer04 = {
            {5},
            {1, 2, 2},
            {2, 1, 2},
            {2, 2, 1},
            {1, 1, 1, 2},
            {1, 1, 2, 1},
            {1, 2, 1, 1},
            {2, 1, 1, 1},
            {1, 1, 1, 1, 1}
    };
}
