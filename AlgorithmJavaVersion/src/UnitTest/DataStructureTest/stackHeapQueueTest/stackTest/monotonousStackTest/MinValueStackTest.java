package UnitTest.DataStructureTest.stackHeapQueueTest.stackTest.monotonousStackTest;

import DataStructure.heapStackQueue.stack.ArrayStacklj;
import DataStructure.heapStackQueue.stack.monotonousStack.MinValueStack;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-09 12:52
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description
 */
public class MinValueStackTest {

    @Test
    public void getMinValueTest() {
        test(new MinValueStack());
    }

    public void test(ArrayStacklj minValueStack) {

        minValueStack.push(7);
        minValueStack.push(9);
        minValueStack.push(8);
        int value = minValueStack.getMinValue();
        assert value == 7;

        minValueStack.push(5);
        minValueStack.push(3);
        value = minValueStack.peek();
        assert value == 3;
        minValueStack.push(4);
        value = minValueStack.getMinValue();
        assert value == 3;

        // still remain stack ->{7,9,8,5,3,4}
        for (int i = 1; i <= 4; i++) {
            minValueStack.pop();
        }

        // still remain stack ->{7,9}
        value = minValueStack.getMinValue();
        assert value == 7;

        // still remain stack ->{7,9}
        minValueStack.push(21);
        value = minValueStack.getMinValue();
        assert value == 7;

        minValueStack.push(1);
        value = minValueStack.getMinValue();
        assert value == 1;

        //----- 新一轮测试
        while (!minValueStack.empty()) {
            minValueStack.pop();
        }

        minValueStack.push(7);
        minValueStack.push(9);
        minValueStack.push(8);
        value = minValueStack.getMinValue();
        assert value == 7;

        minValueStack.push(5);
        minValueStack.push(3);
        minValueStack.push(4);
        value = minValueStack.getMinValue();
        assert value == 3;

        assert 4 == minValueStack.pop();
        assert 3 == minValueStack.pop();
        assert 5 == minValueStack.pop();
        assert 8 == minValueStack.pop();

        value = minValueStack.getMinValue();
        assert value == 7;

        // still remain stack ->{7,9}
        minValueStack.push(21);
        value = minValueStack.getMinValue();
        assert value == 7;

        minValueStack.push(1);
        value = minValueStack.getMinValue();
        assert value == 1;

        for (int i = 1; i <= 3; i++) {
            minValueStack.pop();
        }

        value = minValueStack.getMinValue();
        assert value == 7;

        value = minValueStack.pop();
        assert value == 7;
    }
}
