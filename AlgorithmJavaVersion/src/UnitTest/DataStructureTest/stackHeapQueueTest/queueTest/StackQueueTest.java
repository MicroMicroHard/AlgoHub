package UnitTest.DataStructureTest.stackHeapQueueTest.queueTest;

import DataStructure.heapStackQueue.Queuelj;
import DataStructure.heapStackQueue.queue.StackQueue;
import UnitTest.DataStructureTest.stackHeapQueueTest.QueueljTest;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/7/23
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 使用栈实现队列的功能 测试用例
 */
public class StackQueueTest extends QueueljTest {

    Queuelj queue = new StackQueue(5);
    ArrayQueueTest aqt = new ArrayQueueTest();

    @Test
    public void testStackQueue(){
        super.testQueue(new StackQueue());
        aqt.methodTest(queue);
    }
}
