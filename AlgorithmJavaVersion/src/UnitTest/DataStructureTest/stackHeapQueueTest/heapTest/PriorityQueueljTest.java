package UnitTest.DataStructureTest.stackHeapQueueTest.heapTest;

import DataStructure.heapStackQueue.heap.PriorityQueuelj;
import UnitTest.DataStructureTest.stackHeapQueueTest.QueueljTest;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/23
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 优先队列 测试案例
 */
public class PriorityQueueljTest extends QueueljTest {

    @Test
    public void testArrayQueue(){
        super.testQueue(new PriorityQueuelj());
        test(new PriorityQueuelj(10));
    }

    public void test(PriorityQueuelj queue) {
        //测试队列基本功能
        assert queue.empty();
        assert 10 == queue.getMaxSize();
        assert 0 == queue.getRealSize();
        queue.offer(6);
        assert !queue.empty();
        assert 6 == queue.peek();
        assert 6 == queue.poll();
        queue.resize();
        assert 20 == queue.getMaxSize();

        //测试优先队列
        queue.offer(8);
        queue.offer(17);
        queue.offer(9);
        queue.offer(12);
        queue.offer(16);
        queue.offer(4);

        assert 4 == queue.peek();
        assert 4 == queue.poll();
        assert 8 == queue.poll();
        assert 9 == queue.poll();
        assert 12 == queue.poll();

        //此时还剩下16,17
        queue.offer(1);
        queue.offer(6);
        queue.offer(11);
        assert 1 == queue.peek();
        assert 1 == queue.poll();
        assert 6 == queue.poll();
    }
}
