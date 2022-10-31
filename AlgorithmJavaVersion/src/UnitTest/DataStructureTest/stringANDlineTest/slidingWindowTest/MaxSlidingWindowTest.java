package UnitTest.DataStructureTest.stringANDlineTest.slidingWindowTest;

import DataStructure.heapStackQueue.queue.MaxSlidingWindowByQueue;
import DataStructure.stringOps.slidingWindow.MaxSlidingWindow;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-12-17 下午02:14:33
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 滑动窗口的最大值 测试案例
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * @blogURL https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */

public class MaxSlidingWindowTest {

    @Test
    public void testSolution() {
        test(new MaxSlidingWindow());
    }

    @Test
    public void testMaxSlidingWindowByQueue() {
        test(new MaxSlidingWindowByQueue());
    }


    public void test(MaxSlidingWindow msw) {
        int[] answer = msw.Solution(demo01, 3);
        assert Arrays.equals(answer, target01);
        answer = msw.Solution(demo02, 3);
        assert Arrays.equals(answer, target02);
    }

    int[] demo01 = {1, 3, -1, -3, 5, 3, 6, 7};
    int[] target01 = {3, 3, 5, 5, 6, 7};
    int[] demo02 = {-5, 9, 8, -7, 5, 6, 7, 6, 7};
    int[] target02 = {9, 9, 8, 6, 7, 7, 7};
}
