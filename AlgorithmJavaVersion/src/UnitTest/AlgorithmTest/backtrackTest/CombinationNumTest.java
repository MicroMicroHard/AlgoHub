package UnitTest.AlgorithmTest.backtrackTest;

import Algorithm.backtrack.CombinationNum_BackTrack;
import Common.Utils.ArrayTools;
import Top100.CombinationAndPermutation;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/1/14
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 组合数组中的数之和为指定值 测试案例 --- 换零钱的递归做法
 * 给定数组 array=[1,3,6,8,5] 和 给定的目标值 target=9
 * 数组可以无限重复的选择，最终给出符合target的序列
 * 比如符合给定数组和目标值的序列为：
 * [
 * [1,1,1,6],
 * [1,8],
 * [3,6],
 * [1,3,5],
 * [1,1,1,1,5]]
 * [1,1,1,1,1,1,1,1,1]]
 * [1,1,3,1,3]]
 * [3,3,3]
 * ]
 */

public class CombinationNumTest {

    @Test
    public void testCombinationNum_BackTrack() {
        test(new CombinationNum_BackTrack());
    }

    public void test(CombinationAndPermutation instance) {
        int[][] answer = instance.Solution(demo01, target01);
        assert answer.length == answer01.length;
        ArrayTools.EqualsIntMatrix(answer, answer01);
    }


    int[] demo01 = {1, 3, 6, 8, 5};
    int target01 = 9;
    int[][] answer01 = {
            {1, 8},
            {3, 6},
            {1, 3, 5},
            {3, 3, 3},
            {1, 1, 1, 6},
            {1, 1, 1, 1, 5},
            {1, 1, 1, 3, 3},
            {1, 1, 1, 1, 1, 1, 3},
            {1, 1, 1, 1, 1, 1, 1, 1, 1}};
}
