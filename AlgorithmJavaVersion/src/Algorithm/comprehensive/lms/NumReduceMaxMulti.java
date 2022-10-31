package Algorithm.comprehensive.lms;

import Common.Utils.UTFactory;
import Top100.ChangeMoney;
import Top100.Dynamic;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-25 16:44
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 数字的最大乘积 （类似的题目还有剪绳子）
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，
 * 并使这些整数的乘积最大化。 返回你可以获得的最大乘积
 * @blogURL
 */
public class NumReduceMaxMulti implements ChangeMoney, LMS, Dynamic {

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

    public int reduce(int num) {
        if (num <= 1) {
            return num;
        }
        int[] maxMultiarray = new int[num + 1];
        maxMultiarray[1] = 1;
        //attention:注意循环范围
        for (int i = 2; i <= num; i++) {
            for (int j = 1; j < i; j++) {
                maxMultiarray[i] = Math.max(maxMultiarray[i], (i - j) * Math.max(j, maxMultiarray[j]));
            }
        }
        return maxMultiarray[num];
    }


    
    public long LargestMultiOfSubSequence(int[] array) {
        return 0;
    }
}
