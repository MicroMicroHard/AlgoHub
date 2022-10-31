package DataStructure.stringOps.slidingWindow;

import Top100.SlidingWindow;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-12-17 下午02:14:33
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 输入: {1,3,-1,-3,5,3,6,7}, 和 k = 3
 * 输出: {3,3, 5, 5,6,7}
 * @blogURL https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */

public class MaxSlidingWindow implements SlidingWindow {

    public int[] Solution(int[] array, int k) {
        if (array == null || array.length < k) {
            return new int[]{};
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {// PriorityQueue grammar:PriorityQueue 写法
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });

        // 注意长度是：array.length - k + 1
        int[] answer = new int[array.length - k + 1];

        // 构造k的最大堆
        for (int i = 0; i < k; i++) {
            // queue中构造的是: value 和 index
            queue.offer(new int[]{array[i], i});
        }
        if (queue.peek() != null) {
            answer[0] = queue.peek()[0];
        }
        // 生成answer
        for (int i = k; i < array.length; i++) {
            // 先放入数据
            queue.offer(new int[]{array[i], i});
            // 再剔除数据
            while (queue.size() != 0 && queue.peek()[1] <= i - k) {
                queue.poll();
            }
            // 最后补上数据
            if (queue.peek() != null) {
                answer[i - k + 1] = queue.peek()[0];
            }
        }
        return answer;
    }
}
