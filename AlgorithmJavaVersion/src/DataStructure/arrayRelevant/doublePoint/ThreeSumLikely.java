package DataStructure.arrayRelevant.doublePoint;

import Common.Utils.UTFactory;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/07/26
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 三数之和
 * 给定一个数 target，在一维数组中，找出某 3 个数相加与 target最相近。
 * 要求：
 * 如果存在这个 3 个数，返回这三个数，没有返回 null
 * 输入：
 * int[] demoArray01_y = {1, 100, 22, 39, 43, 58, 64, 76, 79, 85, 96, 58};
 * int target01 = 99;
 * 输出：true (1-22-76)
 */

public class ThreeSumLikely {

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

    public int[] getValuesMethod(int[] array, int target) {
        if (array == null || array.length < 3) {
            return null;
        }

        int[] newarray = Arrays.copyOf(array, array.length);
        Arrays.sort(newarray);

        // attention： 当 target 值非常小的时候，注意越界问题，
        int bestMinGap = newarray[0] + newarray[1] + newarray[2] - target;
        int[] answer = new int[]{newarray[0], newarray[1], newarray[2]};

        for (int i = 0; i <= newarray.length - 3; i++) {
            int left = i + 1;
            int right = newarray.length - 1;

            while (left < right) {
                /* attention: 不建议使用TwoSumLikely.TwoSumLikelyPart,因为计算存在正负数
                比如 target = 20,
                选出来的第一个数是25，那么另外两个数 需要 接近与 -5 而不是 5 */
                int tempSum = newarray[left] + newarray[right] + newarray[i] - target;

                /** attention：
                 * 因为int类型的循环，当target是一个很小或者很大的数字时，比如 Integer.MAX_VALUE，
                 * 在计算机的表示中，-1000 其实 是比 50 更靠近 Integer.MAX_VALUE。
                 * 例如：
                 *  array  = {1, 100, -1000,-2,-3,22, 39, 43, 58, 64, 76, 79, 85, 96, 58}
                 *  target = Integer.MAX_VALUE
                 *  answer = {-1000, -2, -3} 而不是 {85, 96, 100}
                 */
                if (Math.abs(tempSum) < Math.abs(bestMinGap)) {
                    bestMinGap = tempSum;
                    answer = new int[]{newarray[i], newarray[left], newarray[right]};
                } /*else { attention: 此处的 break 是错误的
                    break;
                }*/

                // 要逼近 target，双指针只有一种方式
                if (tempSum == 0) {
                    return answer;
                } else if (tempSum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}
