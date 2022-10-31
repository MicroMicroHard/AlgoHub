package DataStructure.heapStackQueue.stack.monotonousStack;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/9/4
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 单调栈【每日温度】--暴力法
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * input:  {73,74,75,71,69,72,76,73}
 * output: {1, 1, 4, 2, 1, 1, 0, 0}
 * 注意：Impl、Impl1、Impl2的区别
 */

public class DailyTemperatures_Impl2 extends DailyTemperatures {

    public int[] GetContinueDays(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        int[] answer = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }
}
