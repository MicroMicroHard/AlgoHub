package Algorithm.comprehensive.lmg;

import Common.Utils.UTFactory;
import Top100.Dynamic;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-25 16:41
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 打家劫舍2
 * 在一条直线上，有n个房屋，每个房屋中有数量不等的财宝，有一个盗 贼希望从房屋中盗取财宝，由于房屋中有报警器，
 * 如果同时从相邻的两个房屋中盗取财宝就会触发报警器。问在不触发报警器的前提下，最多可获取多少财宝？
 * 例如 {}，则选择空=0
 * 例如 {-5}，则选择 -5 = -5
 * 例如 {-5, 2}，则选择 2 = 2
 * 例如 {-5, 2, -6}，则选择-5 * -6 = 30
 * 例如 {-5, -6, 2} ，则选择 2 = 2
 * 例如 {-5, 2, -6, 0} ，则选择 -5 * -6 = 30
 * 例如 {5，2，6，3，1，7}，则选择 5 * 6 * 7 = 210
 * 例如 {5，2，6，3，1，-7}，则选择 5 * 6 = 30
 * 例如 {5，2，-6，3，1，-7}，则选择 5 * -6 * -7 = 210
 * 例如 {-5, -1, -6, 0, -3, 0, -7}，则选择-5 * -6 * -3 * -7 = 630
 * @blogURL
 */
public class LMG_Dynamic implements LMG, Dynamic {

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

    public int LargestMultiOfGap(int[] values) {

        if (values == null || values.length == 0) {
            return 0;
        }
        int length = values.length;
        int[] valueMax = new int[length];
        int[] valueMin = new int[length];
        valueMax[0] = values[0];
        valueMin[0] = values[0];
        if (length == 1) {
            return valueMax[0];
        }

        valueMax[1] = Math.max(values[0], values[1]);
        valueMin[1] = Math.min(values[0], values[1]);
        if (length == 2) {
            return valueMax[1];
        }

        for (int i = 2; i < length; i++) {
            valueMax[i] = Math.max(Math.max(Math.max(
                    valueMax[i - 2] * values[i], valueMin[i - 2] * values[i]), //选择间隔积
                    valueMax[i - 1]),//选择上一个最优解
                    values[i]);      //选择当前值
            valueMin[i] = Math.min(Math.min(Math.min(
                    valueMax[i - 2] * values[i], valueMin[i - 2] * values[i]), //选择间隔积
                    valueMin[i - 1]),//选择上一个最优解
                    values[i]);      //选择当前值
        }
        return valueMax[length - 1];
    }
}
