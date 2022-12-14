package Algorithm.comprehensive.lis;

import Common.Utils.ArrayTools;
import Common.Utils.UTFactory;
import Top100.Dynamic;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-10-27 22:04
 * @author—Email micromicrohard@outlook.com
 * @description 最长递增子序列 动态规划法 LongestIncreasingSubsequence
 * 在一个给定的数值序列中，找到一个子序列，使得这个子序列元素的数值依次递增，并且这个子序列的长度尽可能地大。
 * 最长递增子序列中的元素在原序列中不一定是连续的
 */

public class LIS_Dynamic implements LIS, Dynamic {

    //最长递增子序列的长度
    int best;
    //用于记录最长递增子序列的 StringBuffer
    StringBuffer sb;
    //记录当前最大值的数组
    int[] longest;
    //point 用于跟踪值
    int point;
    //sequence 转换出来的数组
    int[] intArray;

    public int Method(String sequence) {
        if (!check(sequence)) {
            return 0;
        }
        int length = sequence.length();
        intArray = ArrayTools.Sequence2IntArray(sequence);
        longest = new int[length];
        best = 0;
        point = 0;
        //充填数组
        Arrays.fill(longest, 1);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if ((intArray[j] < intArray[i])) {
                    longest[i] = Math.max((longest[j] + 1), longest[i]);
                }
            }
            if (longest[i] > best) {
                best = longest[i];
                point = i;
            }
        }
        return best;
    }

    // LongestIncreasingSubsequence
    public String LongestIncreasingSubsequence() {
        //寻找值
        sb = new StringBuffer();
        sb.append(intArray[point]);
        for (int i = point - 1; i >= 0; i--) {
            if (longest[i] == longest[point] - 1) {
                sb.append(intArray[i]);
                point = i;
            }
        }
        return sb.reverse().toString();
    }

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
}
