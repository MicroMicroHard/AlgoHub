package UnitTest.DataStructureTest.stackHeapQueueTest.stackTest.calculatorTest;

import Common.Constant.C;
import Top100.Calculator;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-09 12:53
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 计算器 测试用例
 * 测试用例包括：
 * 1、只带加减的表达式     【仅包括：加减】                  testOnlySumSub
 * 2、加减乘除的表达式     【仅包括：加减、乘除】             testFourArithmetic
 * 3、加减乘除及小数的表达式【仅包括：加减、乘除、小数】        testWithDecimals
 * 4、加减乘除及括号的表达式【仅包括：加减、乘除、括号】        testWithBrackets
 * 5、全量表达式          【仅包括：加减、乘除、小数、括号】   testFullExpression
 */
public class Calculator_TestData {

    // 1、只带加减的表达式     【仅包括：加减】                  testOnlySumSub
    public void testOnlySumSub(Calculator instance) {
        double answer = instance.cal(demo1_1);
        assert answer == target1_1;
        answer = instance.cal(demo1_2);
        assert answer == target1_2;
        answer = instance.cal(demo1_3);
        assert answer == target1_3;
        answer = instance.cal(demo1_4);
        assert answer == target1_4;
        answer = instance.cal(demo1_5);
        assert answer == target1_5;
        answer = instance.cal(demo1_6);
        assert answer == target1_6;
    }

    // 2、加减乘除的表达式     【仅包括：加减、乘除】             testFourArithmetic
    public void testFourArithmetic(Calculator instance) {
        double answer = instance.cal(demo2_1);
        assert answer == target2_1;
        answer = instance.cal(demo2_2);
        assert answer == target2_2;
        answer = instance.cal(demo2_3);
        assert answer == target2_3;
        answer = instance.cal(demo2_4);
        assert answer == target2_4;
        answer = instance.cal(demo2_5);
        assert answer == target2_5;
        answer = instance.cal(demo2_6);
        assert answer == target2_6;
    }

    // 3、加减乘除及小数的表达式【仅包括：加减、乘除、小数】        testWithDecimals
    public void testWithDecimals(Calculator instance) {
        double answer = instance.cal(demo3_1);
        assert answer == target3_1;
        answer = instance.cal(demo3_2);
        assert answer == target3_2;
        answer = instance.cal(demo3_3);
        assert answer == target3_3;
       /*
        answer = instance.cal(demo3_4);
        assert answer == target3_4;
        answer = instance.cal(demo3_5);
        assert answer == target3_5;
        answer = instance.cal(demo3_6);
        assert answer == target3_6;*/
    }

    // 4、加减乘除及括号的表达式【仅包括：加减、乘除、括号】        testWithBrackets
    public void testWithBrackets(Calculator instance) {
        double answer = instance.cal(demo4_1);
        assert answer == target4_1;
        answer = instance.cal(demo4_2);
        assert answer == target4_2;
        answer = instance.cal(demo4_3);
        assert answer == target4_3;
        answer = instance.cal(demo4_4);
        assert answer == target4_4;
        answer = instance.cal(demo4_5);
        assert answer == target4_5;
        answer = instance.cal(demo4_6);
        assert answer == target4_6;
    }

    // 5、全量表达式          【仅包括：加减、乘除、小数、括号】   testFullExpression
    public void testFullExpression(Calculator instance) {
        double answer = instance.cal(demo5_1);
        assert answer == target5_1;
        answer = instance.cal(demo5_2);
        assert answer == target5_2;
        answer = instance.cal(demo5_3);
        assert answer == target5_3;
        answer = instance.cal(demo5_4);
        assert answer == target5_4;
        answer = instance.cal(demo5_5);
        assert answer == target5_5;
        answer = instance.cal(demo5_6);
        assert answer == target5_6;

        answer = instance.cal(demo5_7);
        assert answer == target5_7;
        answer = instance.cal(demo5_8);
        assert answer == target5_8;
        answer = instance.cal(demo5_9);
        assert answer == target5_9;
        answer = instance.cal(demo5_10);
        assert answer == target5_10;
    }

    public String demo1_1 = "1+1";
    public double target1_1 = 2;
    public String demo1_2 = "5-4";
    public double target1_2 = 1;
    public String demo1_3 = "5-.4";
    public double target1_3 = C.ErrorNum;
    public String demo1_4 = "0.5-4";
    public double target1_4 = -3.5;
    public String demo1_5 = "1+1-2-100+2+100";
    public double target1_5 = 2;
    public String demo1_6 = "0-1-2-3-4-5-6-7-8-9-10";
    public double target1_6 = -55;

    public String demo2_1 = "2 + 3 * 6 / 2 + 8";//2+9+8
    public double target2_1 = 19;
    public String demo2_2 = "";
    public double target2_2 = C.ErrorNum;
    public String demo2_3 = null;
    public double target2_3 = C.ErrorNum;
    public String demo2_4 = "2 + 03 * 6 / 002 + 8";
    public double target2_4 = 19;
    public String demo2_5 = "1*2*3*4*5";
    public double target2_5 = 120;
    public String demo2_6 = "102 + 3 * 6 / 0 + 10008";
    public double target2_6 = C.ErrorNum;

    // 3、加减乘除及小数的表达式【仅包括：加减、乘除、小数】        testWithDecimals
    public String demo3_1 = "2.1 5+3.45*  6/2+        8.1";
    public double target3_1 = 20.6;
    public String demo3_2 = "12.0+3.0*20.0/4.0-7";
    public double target3_2 = 20;
    public String demo3_3 = "3/(2+6*6*6/216)";
    public double target3_3 = 1;

    public String demo4_1 = "(1-1)/2";
    public double target4_1 = 0;
    public String demo4_2 = "(5-4)*2)";
    public double target4_2 = C.ErrorNum;
    public String demo4_3 = "3*(6/2-1)+3*4";
    public double target4_3 = 18;
    public String demo4_4 = "20/0*2";
    public double target4_4 = C.ErrorNum;
    public String demo4_5 = "12+3*(20/5+1)-7/7-6";
    public double target4_5 = 20;
    public String demo4_6 = "1+20/5-(27-5+3*9)+6/2-1";
    public double target4_6 = 12;

    public String demo5_1 = "(2.15+03.451 77)*6/2+ 8.1-(2.1  7 *45-2*3)";
    public double target5_1 = -66.74469;
    public String demo5_2 = "23.6    7+12.41*(2.3 +5.90)+(12/2   +   3.41)*(8  /4+3-6/2)";
    public double target5_2 = 144.252;
    public String demo5_3 = "2*(1.2d3+0j4)";//非仅含数字和运算符
    public double target5_3 = C.ErrorNum;
    public String demo5_4 = "(5/3*( 3+3)";//括号不匹配
    public double target5_4 = C.ErrorNum;
    public String demo5_5 = "(4*6 )+(2+/ 3+   4   -5)";//运算符多余
    public double target5_5 = C.ErrorNum;
    public String demo5_6 = "2*(.23+4)";//小数点不匹配
    public double target5_6 = C.ErrorNum;
    public String demo5_7 = "2*(1.23+0   .0.4)";//数字，小数点不匹配
    public double target5_7 = C.ErrorNum;
    public String demo5_8 = "2*(1.2 .3+0  4)";//数字，小数点不匹配
    public double target5_8 = C.ErrorNum;
    public String demo5_9 = "2*(=1.23+04)";//非仅含数字和运算符
    public double target5_9 = C.ErrorNum;
    public String demo5_10 = "12*(8/(2*4))/2*(((8/4+7)/9)+3/3+2*2*2)";
    public double target5_10 = 60;
}
