package UnitTest.DataStructureTest.stackHeapQueueTest.stackTest;

import DataStructure.heapStackQueue.stack.InversionStack;
import DataStructure.heapStackQueue.stack.InversionStack_Recursion;
import org.junit.Test;

import java.util.Stack;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/8/3
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 逆置栈中元素 测试用例
 */
public class InversionStackTest {

    @Test
    public void testInversion() {
        test(new InversionStack());
    }

    @Test
    public void testInversionStack_Recursion() {
        test(new InversionStack_Recursion());
    }

    public void test(InversionStack stack) {
        Stack<Integer> demo01 = new Stack<>();
        for (int i = 0; i < 10; i++) {
            demo01.push(i);
        }
        stack.inversion(demo01);
        for (int i = 0; i < 10; i++) {
            assert i == demo01.pop();
        }
    }

}
