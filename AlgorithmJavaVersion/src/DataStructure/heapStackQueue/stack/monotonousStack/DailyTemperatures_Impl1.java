package DataStructure.heapStackQueue.stack.monotonousStack;

import java.util.Stack;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/4
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 单调栈【每日温度】
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * input:  {73,74,75,71,69,72,76,73}
 * output: {1, 1, 4, 2, 1, 1, 0, 0}
 * 注意：Impl、Impl1、Impl2的区别
 */

public class DailyTemperatures_Impl1 extends DailyTemperatures {

    public int[] GetContinueDays(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        int[] answer = new int[array.length];
        Stack<Integer> stack = new Stack<>();
        // answer中未操作的位置原本就是0，如果题意修改，考虑进行初始化
        for (int i = array.length - 1; i >= 0; i--) {
            // stack中存放的是 数组的index
            while (!stack.empty() && array[i] >= array[stack.peek()]) {
                stack.pop();
            }
            answer[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return answer;
    }
}
