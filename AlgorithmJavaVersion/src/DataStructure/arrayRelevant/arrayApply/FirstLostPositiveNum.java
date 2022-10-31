package DataStructure.arrayRelevant.arrayApply;


import Common.Constant.C;
import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-8-8 下午07:03:55
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class FirstLostPositiveNum {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误测试案例
    public void TestDoubleTrack() throws Exception {
        String input = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18";
        String output = "19";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    public int Method(int[] array) {
        if (array == null || array.length == 0) {
            return C.ErrorNum;
        }
        // 整理负数
        for (int i = 0; i < array.length; i++) {
            // tips:需要考虑0
            if (array[i] <= 0) {
                array[i] = array.length + 1;
            }
        }
        // 转换负数
        for (int i = 0; i < array.length; i++) {
            int num = Math.abs(array[i]);
            if (num <= array.length) {
                // tips:num - 1
                array[num - 1] = -Math.abs(array[num - 1]);
            }
        }
        // 计算结果
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                return i + 1;
            }
        }
        return array.length;
    }
}
