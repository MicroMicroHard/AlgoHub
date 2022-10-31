package Algorithm.comprehensive.lms;

import Common.Utils.UTFactory;
import Top100.Dynamic;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/27
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://leetcode-cn.com/problems/maximum-product-subarray/
 * @description 最大子段乘积(连续)
 * 给定一个数组，求出这个数组最大连续的子段乘积
 * 输入：{5, -4, 3, 4, 9}
 * 输出：3 * 4 * 9 = 108
 */

public class LMS_Dynamic_1 implements LMS, Dynamic {

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
        long max = array[0], min = array[0], answer = array[0];

        for (int i = 1; i < array.length; ++i) {
            long max_old = max, min_old = min;
            // attention:  Math.max(a * b, c * b) 不等于 Math.max(a, c) * b
            max = Math.max(array[i], Math.max(max_old * array[i], min_old * array[i]));
            min = Math.min(array[i], Math.min(max_old * array[i], min_old * array[i]));
            answer = Math.max(max, answer);
        }
        return answer;
    }

}
