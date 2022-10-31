package UnitTest.DataStructureTest.stackHeapQueueTest.stackTest;

import DataStructure.heapStackQueue.stack.ArrayStacklj;
import UnitTest.DataStructureTest.stackHeapQueueTest.StackljTest;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-09 12:53
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 数组栈 测试案例
 */
public class ArrayStackTest extends StackljTest {

    @Test
    public void methodTest() {
        super.testStack(new ArrayStacklj());
    }
}