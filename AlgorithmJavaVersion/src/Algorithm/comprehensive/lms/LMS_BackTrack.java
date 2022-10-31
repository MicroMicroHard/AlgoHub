package Algorithm.comprehensive.lms;

import Common.Utils.UTFactory;
import Top100.CombinationAndPermutation;
import Top100.BackTrack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/1/27
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://leetcode-cn.com/problems/maximum-product-subarray/
 * @description 最大子段乘积(连续)
 * 给定一个数组，求出这个数组最大连续的子段乘积
 * 输入：{5, -4, 3, 4, 9}
 * 输出：3 * 4 * 9 = 108
 */

public class LMS_BackTrack implements LMS, CombinationAndPermutation, BackTrack {

    @Test // 验证功能：从数据库获取测试数据，用于单元测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误的测试案例
    public void DoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    long sum;
    long best;
    List list_best;
    List list_temp;

    public long LargestMultiOfSubSequence(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        best = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            sum = 1;
            list_temp = new ArrayList();
            roll(i, array);
        }
        return best;
    }

    public void roll(int depth, int[] array) {

        for (int i = depth; i < array.length; i++) {
            if (array[i] == 0) {
                if (0 > best) {
                    best = 0;
                }
                return;
            }

            sum *= array[i];
            list_temp.add(array[i]);
            if (sum > best) {
                list_best = new ArrayList(list_temp);
                best = sum;
            }
        }
    }

    
    public int[][] Solution(int[] array, int target) {
        return new int[0][];
    }
}
