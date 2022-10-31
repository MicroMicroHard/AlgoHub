package DataStructure.heapStackQueue.stack.calculator;

import DataStructure.heapStackQueue.stack.effectBrackets.JudgeExpress;
import Common.Constant.C;
import Top100.Calculator;
import Common.Utils.UTFactory;
import org.junit.Test;

import java.util.Queue;
import java.util.Stack;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-5-13 10:29:49
 * @author-Email micromicrohard@outlook.com
 * @description Calculator 简易计算器 带括号优先级
 * 根据输入的表达式，运算出结果
 * 1、输入的表达式不需要做校验，满足正常带括号优先级表达式
 */

public class Calculator_Impl_Brackets implements Calculator {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误测试案例
    public void TestDoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    
    public double cal(String expr) {

        // 校验运算表达式
        if (!JudgeExpress.check(expr)) {
            return C.ErrorNum;
        }
        Queue<String> exprQueue = ExprToQueue(expr);
        return helper(exprQueue);
    }

    public double helper(Queue<String> exprQueue) {

        Stack<Double> numStack = new Stack<>();
        String value;
        double n = 0;
        String preSymbol = "+";
        while (!exprQueue.isEmpty()) {
            value = exprQueue.poll();
            if (("(").equals(value)) {
                n = helper(exprQueue);
                if (n == C.ErrorNum) {
                    return C.ErrorNum;
                }
                continue;
            }
            double calResult = TransStringNum2Double(value);
            if (calResult != Double.MAX_VALUE) {
                if (calResult == C.ErrorNum) {
                    return C.ErrorNum;
                }
                n = calResult;
            }
            if ((!IsDigital(value)) || exprQueue.isEmpty()) {
                switch (preSymbol) {
                    case "+":
                        numStack.push(n);
                        break;
                    case "-":
                        numStack.push(-n);
                        break;
                    case "*":
                        numStack.push(numStack.pop() * n);
                        break;
                    case "/":
                        numStack.push(numStack.pop() / n);
                    default:
                        break;
                }
                preSymbol = value;
            }
            if (")".equals(value)) {
                return sum(numStack);
            }
        }
        return sum(numStack);
    }

    private Double sum(Stack<Double> numStack) {
        double res = 0;
        while (!numStack.isEmpty()) {
            res += numStack.pop();
        }
        return res;
    }
}