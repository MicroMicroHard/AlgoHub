package Algorithm.comprehensive.lis;

import Common.Utils.ArrayTools;
import Common.Utils.UTFactory;
import Top100.DoublePoint;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/12/31
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 最长递增子序列 双指针
 * 双指针要求连续
 */
public class LIS_Point implements LIS, DoublePoint {

    
    public int Method(String sequence) {

        if (!check(sequence)) {
            return 0;
        }
        int[] StringArray = ArrayTools.Sequence2IntArray(sequence);
        if (StringArray.length == 1) {
            return 1;
        }
        int left = 0;
        int right = 1;
        int countNum = 0;
        while (right < StringArray.length) {
            while (right < StringArray.length && StringArray[right] > StringArray[right - 1]) {
                right++;
            }
            countNum = Math.max(countNum, right - left);
            left = right;
            right++;
        }
        return countNum;
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
