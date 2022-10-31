package UnitTest.AlgorithmTest.backtrackTest;

import Algorithm.backtrack.CombinationNum_NonRepeat_BackTrack;
import Algorithm.dynamic.CombinationNum_NonRepeat_Dynamic;
import Common.Utils.ArrayTools;
import Top100.CombinationAndPermutation;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/14
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 组合数组中的数之和为指定值 测试案例 --- 换零钱的递归做法
 * 给定数组 array=[1,3,6,8,5] 和 给定的目标值 target=9
 * 数组 不可以 无限重复 的选择，最终给出符合target的序列
 * 比如符合给定数组和目标值的序列为：
 * [
 * [1,8],
 * [3,6],
 * [1,3,5],
 * ]
 */

public class CombinationNum_NonRepeatTest {

    @Test
    public void testCombinationNum_NonRepeat_BackTrack() {
        test(new CombinationNum_NonRepeat_BackTrack());
    }

    @Test
    public void testCombinationNum_NonRepeat_Dynamic() {
        test(new CombinationNum_NonRepeat_Dynamic());
    }


    public void test(CombinationAndPermutation instance) {
        int[][] answer = instance.Solution(demo01, target01);
        assert answer.length == answer01.length;
        ArrayTools.EqualsIntMatrix(answer, answer01);

        answer = instance.Solution(demo02, target02);
        assert answer.length == answer02.length;
        ArrayTools.EqualsIntMatrix(answer, answer02);

        answer = instance.Solution(demo03, target03);
        assert answer.length == answer03.length;
        ArrayTools.EqualsIntMatrix(answer, answer03);

        answer = instance.Solution(demo04, target04);
        assert answer.length == answer04.length;
        ArrayTools.EqualsIntMatrix(answer, answer04);

        answer = instance.Solution(demo05, target05);
        assert answer.length == answer05.length;
        ArrayTools.EqualsIntMatrix(answer, answer05);
    }

    int[] demo01 = {1, 3, 6, 8, 5};
    int target01 = 9;
    int[][] answer01 = {
            {1, 8},
            {3, 6},
            {1, 3, 5}
    };

    int[] demo02 = {1, 3, 6, 8, 5};
    int target02 = 10;
    int[][] answer02 = {
            {1, 3, 6}
    };

    int[] demo03 = {1, 3, 6, 8, 5};
    int target03 = 90;
    int[][] answer03 = {
    };

    int[] demo04 = {10, 1, 2, 7, 6, 1, 5};
    int target04 = 8;
    int[][] answer04 = {
            {1, 7},
            {2, 6},
            {1, 1, 6},
            {1, 2, 5},
    };

    int[] demo05 = {1, 3, 6, 8, 5, 3, 3};
    int target05 = 10;
    int[][] answer05 = {
            {1, 3, 6}
            , {1, 3, 3, 3}
    };
}
