package Algorithm.comprehensive.lss;

import Common.Utils.UTFactory;
import Top100.Dynamic;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-25 16:36
 * @author—Email micromicrohard@outlook.com
 * @description 最大子段和 动态规划
 * LargestSumofSubSequence by dynamic
 * 给定一个数组，求这个数组的连续子数组中，最大的那一段的和
 * @blogURL
 */

public class LSS_Dynamic implements LSS, Dynamic {

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

    public int LargestSumOfSubSequenceMethod(int[] array) {
        int sum = 0;
        if (array == null || array.length == 0) {
            return 0;
        }
        int length = array.length;
        int[] LargestSum = new int[length];
        sum = LargestSum[0] = array[0];
        if (length == 1) {
            return sum;
        }

        for (int i = 1; i < length; i++) {
            LargestSum[i] = Math.max(LargestSum[i - 1] + array[i], array[i]);
            if (LargestSum[i] > sum) {
                sum = LargestSum[i];
            }
        }
        return sum;
    }
}
