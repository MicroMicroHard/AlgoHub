package UnitTest.DataStructureTest.stackHeapQueueTest;

import DataStructure.heapStackQueue.Stacklj;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/12/25
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description stack 测试案例
 */
public class StackljTest {

    public void testStack(Stacklj stacklj) {
        // * 1、测试出栈【分别测试正常、临界、异常值】
        // * 2、测试入栈【分别测试正常、临界、异常值】
        // * 3、测试获取栈顶元素【分别测试正常、临界、异常值】
        // * 4、测试栈判空【分别测试正常、临界、异常值】
        // * 5、测试查找值【分别测试正常、临界、异常值】
        // * 6、测试获取栈中实际容量【分别测试正常、临界、异常值】
        // * 7、测试获取栈中最大容量【分别测试正常、临界、异常值】
        // * 8、测试扩容【分别测试正常、临界、异常值】
        int value = stacklj.peek();
        assert value == Integer.MIN_VALUE;
        value = stacklj.pop();
        assert value == Integer.MIN_VALUE;
        //empty
        boolean flag = stacklj.empty();
        assert flag;
        //size
        value = stacklj.getRealsize();
        assert value == 0;
        value = stacklj.getMaxsize();
        assert value == 32;
        flag = stacklj.push(0);
        assert flag;
        //push
        for (int i = 1; i <= 9; i++) {
            flag = stacklj.push(i);
            assert flag;
        }
        flag = stacklj.empty();
        assert !flag;
        value = stacklj.getRealsize();
        assert value == 10;
        value = stacklj.getMaxsize();
        assert value == 32;
        flag = stacklj.push(10);
        assert flag;
        value = stacklj.pop();
        assert value == 10;
        value = stacklj.peek();
        assert value == 9;
        //search
        flag = stacklj.search(8);
        assert flag;
        flag = stacklj.search(10);
        assert !flag;
        //pop
        for (int i = 1; i <= 9; i++) {
            stacklj.pop();
        }
        flag = stacklj.empty();
        assert !flag;
        value = stacklj.pop();
        assert value == 0;
        value = stacklj.peek();
        assert value == Integer.MIN_VALUE;
        value = stacklj.getRealsize();
        assert value == 0;
        value = stacklj.getMaxsize();
        assert value == 32;

        //测试扩容
        for (int i = 0; i < 38; i++) {
            flag = stacklj.push(i);
            assert flag;
        }
        assert 38 == stacklj.getRealsize();
        assert 64 == stacklj.getMaxsize();
        stacklj.resize();
        assert 38 == stacklj.getRealsize();
        assert 128 == stacklj.getMaxsize();
    }
}
