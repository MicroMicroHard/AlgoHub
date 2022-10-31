package DataStructure.arrayRelevant.doublePoint;

import Top100.DoublePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/7/20
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 2数之和
 * 给定一个数 target，在一维数组中，找出某 2 个数相加与 target最相近
 * 要求一：如果存在这个 2 个数，返回true，反则返回false。
 * 要求二：返回存在的这 2 个值
 * 要求三：返回存在的这 2 个值在数组中的原位置
 * 要求四：返回所有的 2 数之和的组合
 * 要求五：返回所有的 2 数之和在数组中原位置的组合
 */
public class TwoSumLikely implements DoublePoint {

    // 要求一：如果存在这个两个数，返回true，反则返回false。
    public int[] existMethod(int[] array, int target) {
        if (array == null || array.length <= 1) {
            return null;
        }

        int[] newarray = Arrays.copyOf(array, array.length);
        Arrays.sort(newarray);
        return TwoSumLikelyPart(newarray, target, 0, array.length - 1);
    }

    public int[] TwoSumLikelyPart(int[] newarray, int target, int left, int right) {
        // 因为是双指针，不一样，所以此处需要判断 left != right，相等退出
        if (newarray == null || newarray.length < 2 || left > newarray.length - 1 || right < 0 || left >= right) {
            return null;
        }

        int minGap = Integer.MAX_VALUE;
        int[] result = new int[]{newarray[0], newarray[1]};

        while (left < right) {
            int sum = newarray[left] + newarray[right];
            // 保留最佳值
            if (minGap > Math.abs(sum - target)) {
                result = new int[]{newarray[left], newarray[right]};
                minGap = Math.abs(sum - target);
            }

            // 万变不离其宗的是两数之和 要逼近 target，所以只有一种方式
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                // 恰好为0
                return new int[]{newarray[left], newarray[right]};
            }
        }
        return result;
    }
}
