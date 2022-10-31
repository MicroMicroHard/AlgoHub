package UnitTest.DataStructureTest.stackHeapQueueTest.stackTest.monotonousStackTest;

import DataStructure.heapStackQueue.stack.monotonousStack.MinValueOptStack;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-09 12:52
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description
 */
public class MinValueStackOptTest extends MinValueStackTest {

    @Test
    public void getMinValueTest() {
        test(new MinValueOptStack());
    }
}
