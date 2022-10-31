package DataStructure.arrayRelevant.doublePoint;

import Top100.SlidingWindow;
import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/4/2 22:07
 * @author—Email micromicrohard@outlook.com
 * @description 找出 补充并反转后的 最大连续的数字1的个数
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * @blogURL https://leetcode-cn.com/problems/max-consecutive-ones-iii/description/
 * <p>
 * input：nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0], K = 2
 * output：6
 * 解释：[1, 1, 1, 0, 0, 1_, 1, 1, 1, 1, 1_], 带下划线的数字从 0 翻转到 1，最长的子数组长度为 6。
 * <p>
 * input：nums = [0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1], K = 3
 * output：10
 * 解释：[0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1] , 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 */

public class MaxContinuityOne implements SlidingWindow {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误测试案例
    public void TestDoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    public int Method(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int boundLength = 0;
        int oneNumCount = 0;
        int bestLength = 0;
        while (left <= right && right < array.length) {
            if (array[right] == 1) {
                oneNumCount++;
            }
            boundLength = right - left + 1;
            if (boundLength - oneNumCount <= k) {
                bestLength = Math.max(bestLength, boundLength);
            } else {
                if (array[left] == 1) {// attention:在缩小右边界的时候，需要注意，先判断，再缩小，否则会出现漏减 1 的问题,所以left++需要放在if后面
                    oneNumCount--;
                }
                left++;
            }
            right++;
        }
        return bestLength;
    }
}
