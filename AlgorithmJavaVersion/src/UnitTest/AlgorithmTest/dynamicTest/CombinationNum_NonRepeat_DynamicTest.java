package UnitTest.AlgorithmTest.dynamicTest;

import Algorithm.dynamic.CombinationNum_NonRepeat_Dynamic;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-25 16:42
 * @author—Email micromicrohard@outlook.com
 * @description 分割等和子集 测试案例
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @blogURL https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * <p>
 * 这道题可以转换成：组合数组中的数之和为指定值，只不过这个和是数组Sum的一半
 * 给定数组 array=[1,3,6,8,5] 和 给定的目标值 target=9
 * 数组不可以重复的选择，最终给出符合target的序列
 * 比如符合给定数组和目标值的序列为：
 * [1,8],
 * [3,6],
 * [1,3,5],
 */

public class CombinationNum_NonRepeat_DynamicTest {

    @Test
    public void testCombinationNum_Dynamic_JudgeAnswer() {
        testJudgeAnswer(new CombinationNum_NonRepeat_Dynamic());
    }

    public void testJudgeAnswer(CombinationNum_NonRepeat_Dynamic combinationNum) {
        boolean flag = combinationNum.JudgeAnswer(demo01);
        assert flag;
        flag = combinationNum.JudgeAnswer(demo02);
        assert !flag;
        flag = combinationNum.JudgeAnswer(demo03);
        assert !flag;
    }

    @Test
    public void testCombinationNum_Dynamic_Judge() {
        test(new CombinationNum_NonRepeat_Dynamic());
    }

    public void test(CombinationNum_NonRepeat_Dynamic combinationNum) {
        boolean flag = combinationNum.JudgeAnswer(demo01, target01);
        assert flag;
        flag = combinationNum.JudgeAnswer(demo02, target02);
        assert !flag;
        flag = combinationNum.JudgeAnswer(demo03, target03);
        assert flag;
    }

    int[] demo01 = {1, 5, 11, 5};//true
    int target01 = 6;
    int[] demo02 = {1, 2, 3, 5};//false
    int target02 = 20;
    int[] demo03 = {2, 2, 3, 5};//false
    int target03 = 4;

}
