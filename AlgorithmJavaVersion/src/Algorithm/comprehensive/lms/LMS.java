package Algorithm.comprehensive.lms;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/1/27
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://leetcode-cn.com/problems/maximum-product-subarray/
 * @description 最大子段乘积(连续)
 * LMS:LargestMultiOfSubSequence
 * 给定一个数组，求出这个数组最大连续的子段乘积
 * 输入：{5, -4, 3, 4, 9}
 * 输出：3 * 4 * 9 = 108
 */

public interface LMS {

    long LargestMultiOfSubSequence(int[] array);
}
