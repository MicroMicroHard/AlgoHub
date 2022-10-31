package DataStructure.heapStackQueue.queue;

import DataStructure.stringOps.slidingWindow.MaxSlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-12-17 下午02:14:33
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 输入: {1,3,-1,-3,5,3,6,7}, 和 k = 3
 * 输出: {3,3, 5, 5,6,7}
 * @blogURL
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * https://mp.weixin.qq.com/s/IY4Zp7AE6p_q8a6sUIH9MA
 */
public class MaxSlidingWindowByQueue extends MaxSlidingWindow {

    public int[] Solution(int[] array, int k) {
        if (array == null || array.length < k) {
            return new int[]{};
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && array[i] >= array[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        // 注意长度是：array.length - k + 1
        int[] answer = new int[array.length - k + 1];
        if (queue.isEmpty()) {
            return new int[]{};
        }
        answer[0] = array[queue.peekFirst()];
        for (int i = k; i < array.length; i++) {
            // 当队列尾元素 小于 当前值
            while (!queue.isEmpty() && array[i] >= array[queue.peekLast()]) {
                queue.pollLast();
            }
            // 当队列首元素超出 k 的范围，逐个弹出
            while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            // 存入当前值
            queue.offerLast(i); // tips:存入的是坐标
            if (queue.isEmpty()) {
                return new int[]{};
            }
            answer[i - k + 1] = array[queue.peekFirst()];
        }
        return answer;
    }
}
