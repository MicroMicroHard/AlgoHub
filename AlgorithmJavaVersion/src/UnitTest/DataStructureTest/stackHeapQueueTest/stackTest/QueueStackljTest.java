package UnitTest.DataStructureTest.stackHeapQueueTest.stackTest;

import DataStructure.heapStackQueue.stack.QueueStacklj;
import UnitTest.DataStructureTest.stackHeapQueueTest.StackljTest;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/23
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 队列栈 测试案例
 */
public class QueueStackljTest extends StackljTest {

    @Test
    public void test() {
        super.testStack(new QueueStacklj());
    }

}
