package Algorithm.comprehensive.lms;

import Common.Utils.UTFactory;
import Top100.Dynamic;
import Top100.Mathlj;
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
public class NumReduceMaxMulti_Math extends NumReduceMaxMulti implements LMS, Dynamic, Mathlj {

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

    /**
     * 在数学上貌似有个啥“均值定理”来着，大概意思是如果两个整数的和为n，
     * 当两个整数尽量平分n的时候，两个整数的乘积才能达到最大
     */
    public int reduce(int num) {
        if (num <= 1) {
            return num;
        }
        if (num <= 3) {
            return num - 1;
        }
        /**
         * 最优因子是3，所以我们需要让 n/3，这样的话，余数可能是1,2 两种可能性。
         * 如果余数是1，刚才我们也分析过，对于1的拆分是没有意义的，所以我们退一步，将最后一次的3和1的拆分，用2和2代替。
         * 如果余数是2，那不消多说，直接乘以最后的2即可。
         */
        int x = num / 3, y = num % 3;
        //恰好整除，直接为3^x
        if (y == 0) {
            return (int) Math.pow(3, x);
        }
        //余数为1，退一步 3^(x-1)*2*2,余数为2，直接乘以2
        return y == 1 ? (int) Math.pow(3, x - 1) * 4 : (int) Math.pow(3, x) * 2;
    }

    
    public long LargestMultiOfSubSequence(int[] array) {
        return 0;
    }
}
