package Algorithm.comprehensive.lsg;

import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-25 16:42
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 换零钱【LSG问题】
 * 给定不同面额的硬币 array 和一个总金额 target。
 * 如果限制随意组合，仅能选取间隔的钱币，那么是否还能凑出target表示金额
 * 如果没有任何一种硬币组合能组成总金额，返回 false。
 * 示例 1:
 * 输入：target = 5, array = [1, 2, 5]
 * 输出：false
 * <p>
 * 示例 2:
 * 输入：target = 3, array = [2]
 * 输出：false
 * <p>
 * 示例 3:
 * 输入：target = 6, array = [1, 2, 5]
 * 输出：true
 * <p>
 * 示例 4:
 * 输入：target = 3, array = [1, 2, 5]
 * 输出：false
 */

public class ChangeMoney_SumGap_BackTrack implements LSG {

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

    int sum = 0;

    // 和 LSG_Backtrack 的区别在于一个求解最大值，一个求解target
    public boolean check(int[] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }
        boolean flag;
        for (int i = 0; i < array.length; i++) {
            sum = 0;
            flag = roll(i, array, target);
            if (flag) {
                return true;
            }
        }
        return false;
    }

    private boolean roll(int depth, int[] array, int target) {
        // 超过长度 或者 超过预期
        if (depth >= array.length || array[depth] + sum > target) {
            return false;
        }
        sum += array[depth];
        if (sum == target) {
            return true;
        }
        for (int i = depth + 2; i < array.length; i++) {
            boolean flag = roll(i, array, target);
            if (flag) {
                return flag;
            }
        }
        sum -= array[depth];
        return false;
    }

    
    public int LargestSumOfGap(int[] array) {
        return 0;
    }
}
