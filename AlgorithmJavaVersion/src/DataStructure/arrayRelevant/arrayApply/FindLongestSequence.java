package DataStructure.arrayRelevant.arrayApply;

import Common.Utils.UTFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/5/15
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * @description 找出数字连续的最长序列
 * 最长递增序列长度
 * 给定一个未排序的整数数组 array ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题
 * 示例 1：
 * 输入：array = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * 输入：array = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */

public class FindLongestSequence {

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

    public int Method(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return 1;
        }
        Arrays.sort(array);
        int count_temp = 1;
        int count_best = 1;
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                break;
            }
            if (array[i + 1] - array[i] == 1) {
                count_temp++;
            } else {
                count_temp = 1;
            }
            if (count_best < count_temp) {
                count_best = count_temp;
            }
        }
        return count_best;
    }

    public int MethodOps(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return 1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : array) {
            map.put(j, 1);
        }
        int best = 1;

        for (int j : array) {
            // Tips: 此处的if 具有分支限定的含义, 找到断层的点
            if (!map.containsKey(j - 1)) {
                int target = j;
                int count = 1;
                while (map.containsKey(++target)) {
                    count++;
                }
                best = Math.max(best, count);
            }
        }
        return best;
    }
}
