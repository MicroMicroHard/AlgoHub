package UnitTest.DataStructureTest.stackHeapQueueTest.queueTest;

import DataStructure.heapStackQueue.queue.LinkedQueuelj;
import DataStructure.heapStackQueue.Queuelj;
import UnitTest.DataStructureTest.stackHeapQueueTest.QueueljTest;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-09 22:57
 * @author-Email micromicrohard@outlook.com
 * @description
 */
public class LinkedQueueTest extends QueueljTest {

    @Test
    public void testArrayQueue() {
        super.testQueue(new LinkedQueuelj());
        methodTest(new LinkedQueuelj(10));
    }

    public void methodTest(Queuelj queuelj) {
        boolean flag = queuelj.empty();
        assert flag;
        int value = queuelj.poll();
        assert value == Integer.MIN_VALUE;
        value = queuelj.peek();
        assert value == Integer.MIN_VALUE;
        value = queuelj.getRealSize();
        assert value == 0;
        flag = queuelj.offer(0);
        assert flag;
        //��Ӳ���
        for (int i = 1; i <= 9; i++) {
            queuelj.offer(i);
            if (i == 5) {
                flag = queuelj.empty();
                assert !flag;
                value = queuelj.poll();
                assert value == 0;
                value = queuelj.peek();
                assert value == 1;
                value = queuelj.getRealSize();
                assert value == 5;
            }
        }
        flag = queuelj.offer(10);
        assert flag;
        flag = queuelj.offer(11);
        assert flag;
        //目前队内的值 [1,2,3,4,5,6,7,8,9,10,11]
        for (int i = 1; i <= 9; i++) {
            queuelj.poll();
            if (i == 5) {
                flag = queuelj.empty();
                assert !flag;
                value = queuelj.poll();
                assert value == 6;
                value = queuelj.peek();
                assert value == 7;
                value = queuelj.getRealSize();
                assert value == 5;
            }
        }
        value = queuelj.poll();
        assert value == 11;
        flag = queuelj.empty();
        assert flag;
        value = queuelj.poll();
        assert value == Integer.MIN_VALUE;
        value = queuelj.peek();
        assert value == Integer.MIN_VALUE;
        value = queuelj.getRealSize();
        assert value == 0;
    }
}
