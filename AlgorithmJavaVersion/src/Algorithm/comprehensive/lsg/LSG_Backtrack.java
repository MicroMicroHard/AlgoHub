package Algorithm.comprehensive.lsg;

import Algorithm.comprehensive.lss.LSSOpt;
import Common.Utils.UTFactory;
import Top100.BackTrack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-25 16:41
 * @author—Email micromicrohard@outlook.com
 * @description 打家劫舍
 * 在一条直线上，有n个房屋，每个房屋中有数量不等的财宝，有一个盗 贼希望从房屋中盗取财宝，由于房屋中有报警器，
 * 如果同时从相邻的两个房屋中盗取财宝就会触发报警器。问在不触发报警器的前提下，最多可获取多少财宝？
 * 例如 [5，2，6，3，1，7]，则选择5，6，7
 * @blogURL
 */

public class LSG_Backtrack implements LSG, BackTrack {

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

    int sum;
    int best;
    List<Integer> list_best;
    List<Integer> list_temp;

    // 和 ChangeMoney_SumGap_BackTrack 的区别在于一个求解最大值，一个求解target
    public int LargestSumOfGap(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        best = Integer.MIN_VALUE;
        sum = 0;

        list_temp = new ArrayList<>();
        roll(0, array);
        return best;
    }

    public void roll(int depth, int[] array) {
        // 更新最优解
        if (sum > best && list_temp.size() != 0) {
            LSSOpt lss = new LSSOpt();
            int[] answer = list_temp.stream().mapToInt(x -> x).toArray();
            int sum_temp = lss.LargestSumOfSubSequenceMethod(answer);
            if (sum_temp > best) {
                best = sum_temp;
            }
            list_best = new ArrayList<>();
            for (int i = lss.begin; i <= lss.end; i++) {
                list_best.add(answer[i]);
            }
        }

        // 为什么 这个地方的判断不放在函数入口：因为存在符合要求的list序列被该判断拦截，所以此处的判断需要在"更新最优解"之后
        if (depth >= array.length) {
            return;
        }

        for (int i = depth; i < array.length; i++) {
            /*
            为什么次数引入判断？为了求解整个函数的最大值。如果存在全部负数的数组，不会进入"更新最优解"部分，所以无法求解最优解，
            对于全部负数的序列，最优解是数组的最大的那个负数*/
            if (array[i] > best) {
                best = array[i];
            }

            sum += array[i];
            list_temp.add(array[i]);

            roll(i + 2, array);// tips: 此处的 i 或者 depth 需要注意，常规情况下都是使用i+1，只有在对数组做全排列才会考虑使用depth

            list_temp.remove(list_temp.size() - 1);
            sum -= array[i];
        }
    }
}
