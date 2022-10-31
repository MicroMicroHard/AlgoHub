package DataStructure.heapStackQueue.heap;


import DataStructure.heapStackQueue.Queuelj;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/5/15
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 得到一个数据流中的中位数
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 例如，[2,3,4]的中位数是 3
 * [2,3]的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 解析：
 * 维护两个堆，一个大顶堆，一个小顶堆，保持两个堆数量平衡，
 * 取数的时候，分别取大顶堆的尾和小顶堆的头，平均一下即可。
 */

public class GetMidNum {

    Queuelj queue_small = new PriorityQueuelj(32);
    Queuelj queue_big = new PriorityQueuelj(32, true);

    public void addNum(int num) {
        // 大顶堆 其实存放的是 较小的一堆数字
        queue_big.offer(num);
        if (queue_big.getRealSize() > queue_small.getRealSize() + 1) {
            queue_small.offer(queue_big.poll());
        }
    }

    public double findMedian() {
        if (queue_big.getRealSize() == queue_small.getRealSize()) {
            return ((double) queue_big.peek() + (double) queue_small.peek()) / 2;
        }
        return queue_big.peek();
    }
}
