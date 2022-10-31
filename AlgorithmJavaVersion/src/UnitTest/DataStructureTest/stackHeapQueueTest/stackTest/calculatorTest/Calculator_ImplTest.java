package UnitTest.DataStructureTest.stackHeapQueueTest.stackTest.calculatorTest;

import DataStructure.heapStackQueue.stack.calculator.Calculator_Impl;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-09 12:53
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 计算器测试用例
 */
public class Calculator_ImplTest extends Calculator_TestData {

    @Test
    public void testtestCalculateImpl() {
        test(new Calculator_Impl());
    }

    public void test(Calculator_Impl instance) {
        //1、只带加减的表达式     【仅包括：加减】
        testOnlySumSub(instance);
        // 2、加减乘除的表达式     【仅包括：加减、乘除】
        testFourArithmetic(instance);
        //3、加减乘除及小数的表达式【仅包括：加减、乘除、小数】
        testWithDecimals(instance);
        //4、加减乘除及括号的表达式【仅包括：加减、乘除、括号】
        testWithBrackets(instance);
        // 5、全量表达式          【仅包括：加减、乘除、小数、括号】
        testFullExpression(instance);
    }
}
