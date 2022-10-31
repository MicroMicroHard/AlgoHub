package UnitTest.DataStructureTest.stackHeapQueueTest.queueTest;

import DataStructure.heapStackQueue.queue.ArrayQueuelj;
import DataStructure.heapStackQueue.Queuelj;
import UnitTest.DataStructureTest.stackHeapQueueTest.QueueljTest;
import Common.Constant.C;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-09 22:56
 * @author-Email micromicrohard@outlook.com
 * @description 数组队列的测试案例
 */
public class ArrayQueueTest extends QueueljTest {

    @Test
    public void testArrayQueue() {
        //super.testQueue(new ArrayQueuelj());
        methodTest(new ArrayQueuelj(3));
    }


    public void methodTest(Queuelj arrayQueue) {
        // init test
        boolean flag = arrayQueue.empty();
        assert flag;
        int value = arrayQueue.poll();
        assert value == C.ErrorNum;
        value = arrayQueue.peek();
        assert value == C.ErrorNum;
        value = arrayQueue.getRealSize();
        assert value == 0;
        flag = arrayQueue.offer(0);
        assert flag;

        for (int i = 1; i <= 9; i++) {
            arrayQueue.offer(i);
            if (i == 5) {
                flag = arrayQueue.empty();
                assert !flag;
                value = arrayQueue.poll();
                assert value == 0;
                value = arrayQueue.peek();
                assert value == 1;
                value = arrayQueue.getRealSize();
                assert value == 5;
            }
        }
        flag = arrayQueue.offer(10);
        assert flag;
        flag = arrayQueue.offer(11);
        assert flag;
        //此时队列内元素为： [1,2,3,4,5,6,7,8,9，10，11]
        for (int i = 1; i <= 8; i++) {
            arrayQueue.poll();
            if (i == 5) {
                flag = arrayQueue.empty();
                assert !flag;
                value = arrayQueue.poll();
                assert value == 6;
                value = arrayQueue.peek();
                assert value == 7;
                value = arrayQueue.getRealSize();
                assert value == 5;
            }
        }
        value = arrayQueue.poll();
        assert value == 10;
        flag = arrayQueue.empty();
        assert !flag;
        value = arrayQueue.poll();
        assert value == 11;
        value = arrayQueue.peek();
        assert value == Integer.MIN_VALUE;
        value = arrayQueue.getRealSize();
        assert value == 0;

        //测试扩容
        arrayQueue = new ArrayQueuelj(2);
        arrayQueue.offer(1);
        arrayQueue.offer(2);
        arrayQueue.offer(3);
        arrayQueue.offer(4);

        arrayQueue.poll();
        arrayQueue.poll();
        arrayQueue.offer(5);
        arrayQueue.offer(6);
        arrayQueue.offer(7);
        arrayQueue.offer(8);

        arrayQueue.poll();
        arrayQueue.poll();
        arrayQueue.offer(9);
        arrayQueue.offer(10);
        arrayQueue.offer(11);
        arrayQueue.offer(12);
        assert 8 == arrayQueue.getRealSize();
    }
}
