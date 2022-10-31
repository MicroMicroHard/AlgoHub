package Algorithm.comprehensive.lms;

import Common.Utils.UTFactory;
import Top100.Dynamic;
import org.junit.Test;

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

public class LMS_Dynamic_2 implements LMS, Dynamic {

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

    public long LargestMultiOfSubSequence(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] answer = new int[array.length];
        int[] answer_negative = new int[array.length];
        answer[0] = array[0];
        answer_negative[0] = array[0];
        int best = 0;
        int best_negative = 0;

        for (int i = 1; i < array.length; i++) {
            answer[i] = Math.max(answer[i - 1] * array[i], array[i]);

            if (Math.abs(answer_negative[i - 1] * array[i]) > Math.abs(array[i])) {
                answer_negative[i] = answer_negative[i - 1] * array[i];
            } else {
                answer_negative[i] = array[i];
            }
            best = Math.max(best, answer[i]);
            best_negative = Math.max(best_negative, answer_negative[i]);
        }
        int ans = Math.max(best, best_negative);
        return ans;
    }
}
