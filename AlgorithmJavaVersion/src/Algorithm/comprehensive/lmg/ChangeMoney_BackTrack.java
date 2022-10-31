package Algorithm.comprehensive.lmg;

import Common.Utils.UTFactory;
import Top100.ChangeMoney;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-25 16:42
 * @author—Email micromicrohard@outlook.com
 * @description 换零钱
 * 给定一个数组，数组内数字随意组合【不可以重复选取】，是否可以凑出乘积等于target的组合
 * 示例 1:
 * 输入: coins = [1, 2, 5], target = 5
 * 输出: true
 * 解释: 5 = 1 * 5
 * <p>
 * 示例 2:
 * 输入: coins = [2, 4, 9, 11], target = 22
 * 输出: true
 * 解释: 22 = 2 * 11
 * 示例 2:
 * 输入: coins = [2, 4, 9, 11], target = 37
 * 输出: false
 */

public class ChangeMoney_BackTrack implements ChangeMoney {

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

    int multiSum = 1;
    boolean flag;

    public boolean Check(int[] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }
        multiSum = 1;
        flag = roll(0, array, target);
        return flag;
    }

    public boolean roll(int depth, int[] array, int target) {
        if (depth == array.length) {
            return false;
        }
        if (multiSum == target || array[depth] == target) {
            return true;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                continue;
            }
            multiSum *= array[i];
            flag = roll(depth + 1, array, target);
            if (flag) {
                return true;
            }
            multiSum /= array[i];
        }
        return false;
    }
}
