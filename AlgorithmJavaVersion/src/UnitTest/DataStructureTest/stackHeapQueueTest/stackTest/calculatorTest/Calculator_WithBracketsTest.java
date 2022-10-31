package UnitTest.DataStructureTest.stackHeapQueueTest.stackTest.calculatorTest;

import DataStructure.heapStackQueue.stack.calculator.Calculator_Impl_Brackets;
import Top100.Calculator;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-5-13 10:29:49
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description Calculator 简易计算器 带括号优先级
 * 根据输入的表达式，运算出结果
 * 1、输入的表达式不需要做校验，满足正常带括号优先级表达式
 */

public class Calculator_WithBracketsTest extends Calculator_TestData {

    @Test
    public void testCalculator_WithBrackets() {
        test(new Calculator_Impl_Brackets());
    }

    public void test(Calculator instance) {
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
