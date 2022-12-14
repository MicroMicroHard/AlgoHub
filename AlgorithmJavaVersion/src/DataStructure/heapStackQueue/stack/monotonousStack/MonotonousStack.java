package DataStructure.heapStackQueue.stack.monotonousStack;

import DataStructure.heapStackQueue.stack.ArrayStacklj;
import DataStructure.heapStackQueue.Stacklj;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/9/4
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 单调栈 下一个更大元素
 * 给你一个数组，返回一个等长的数组，对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1.
 * 另一道相似题目：https://leetcode-cn.com/problems/daily-temperatures/
 * input:  {2, 1, 2,  4,  3}
 * output: {4, 2, 4, -1, -1}
 */

public class MonotonousStack {

    //使用栈的方法
    public int[] GetNextBiggerValue(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        Stacklj stack = new ArrayStacklj();
        int[] ans = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            // 比Array大的数都pop出去了
            while (!stack.empty() && stack.peek() <= array[i]) {
                stack.pop();
            }
            ans[i] = stack.empty() ? -1 : stack.peek();
            // 为下一个温度做比较
            stack.push(array[i]);
        }
        return ans;
    }

    //循环数组的方法
    public int[] cycilmethod(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        Stacklj stack = new ArrayStacklj();
        int[] ans = new int[array.length];

        return ans;
    }
}
