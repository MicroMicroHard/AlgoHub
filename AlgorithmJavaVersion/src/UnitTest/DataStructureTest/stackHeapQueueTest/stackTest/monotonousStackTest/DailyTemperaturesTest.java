package UnitTest.DataStructureTest.stackHeapQueueTest.stackTest.monotonousStackTest;

import DataStructure.heapStackQueue.stack.monotonousStack.DailyTemperatures;
import DataStructure.heapStackQueue.stack.monotonousStack.DailyTemperatures_Impl1;
import DataStructure.heapStackQueue.stack.monotonousStack.DailyTemperatures_Impl2;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/9/4
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 单调栈【每日温度】 测试案例
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 输入: array = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 */

public class DailyTemperaturesTest {

    @Test
    public void testGetContinueDays() {
        test(new DailyTemperatures());
    }

    @Test
    public void testGetContinueDays_Impl1() {
        test(new DailyTemperatures_Impl1());
    }

    @Test
    public void testGetContinueDays_Impl2() {
        test(new DailyTemperatures_Impl2());
    }

    public void test(DailyTemperatures dt) {
        int[] answer = dt.GetContinueDays(demo001);
        assert Arrays.equals(answer, target001);
        answer = dt.GetContinueDays(demo01);
        assert Arrays.equals(answer, target01);
        answer = dt.GetContinueDays(demo02);
        assert Arrays.equals(answer, target02);
        answer = dt.GetContinueDays(demo03);
        assert Arrays.equals(answer, target03);
        answer = dt.GetContinueDays(demo04);
        assert Arrays.equals(answer, target04);
    }

    public int[] demo01 = {73, 74, 75, 71, 69, 72, 76, 73};
    public int[] target01 = {1, 1, 4, 2, 1, 1, 0, 0};
    public int[] demo02 = {30, 40, 50, 60};
    public int[] target02 = {1, 1, 1, 0};
    public int[] demo03 = {30, 60, 90};
    public int[] target03 = {1, 1, 0};
    public int[] demo04 = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
    public int[] target04 = {8, 1, 5, 4, 3, 2, 1, 1, 0, 0};

    public int[] demo001 = {};
    public int[] target001 = {};
}
