package DataStructure.heapStackQueue.stack.calculator;

import DataStructure.heapStackQueue.stack.effectBrackets.JudgeExpress;
import Top100.Calculator;
import Common.Constant.C;
import Common.Utils.UTFactory;
import org.junit.Test;

import java.util.*;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-5-13 10:29:49
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description Calculate 计算器
 * 代码第一部分，处理输入的计算式，处理完输出list: 具体见 JudgeExpress
 * 代码第二部分，中缀表达式转化为后缀表达式
 * 代码第三部分，计算后缀表达式，并返回运算结果
 * <p>
 * 1、支持小数运算
 * 2、支持括号运算
 * 3、支持表达式校验
 * 参考博客：https://blog.csdn.net/u010177752/article/details/84743407?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-7.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-7.channel_param
 */
public class Calculator_Impl implements Calculator {

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

    //主要业务代码
    public double cal(String expr) {
        // 校验运算表达式
        if (!JudgeExpress.check(expr)) {
            return C.ErrorNum;
        }

        Queue<String> queue = ExprToQueue(expr);
        if (queue == null) {
            return C.ErrorNum;
        }
        //中缀表达式转化为后缀表达式
        queue = Infix2Suffix(queue);
        //计算后缀表达式，并返回运算结果,数字不合规的情况下，输出 Integer.MIN_VALUE
        return calculatorResult(queue);
    }

    private Queue<String> Infix2Suffix(Queue<String> infixQueue) {
        Deque<String> suffixQueue = new LinkedList<>();
        // stackTemp是临时栈，专门来处理高优先级的符号
        Stack<String> optStackTemp = new Stack<>();
        Stack<String> numStackTemp = new Stack<>();

        while (!infixQueue.isEmpty()) {
            String s = infixQueue.poll();
            if ("(".equals(s) || "*".equals(s) || "/".equals(s)) {
                // 此处直接使用：stackTemp.push(s)，会产生顺序错误，比如： 3*7/21 正常是得到结果1，但是后缀表达式先计算7/21得到小数，再运算*3
                optStackTemp.push(s);
                //deal(s, stackTemp, suffixQueue, infixQueue);
            } else if ("+".equals(s) || "-".equals(s) || ")".equals(s)) {
                // 数字可以倒序
                while (!numStackTemp.empty() && !numStackTemp.peek().equals("(")) {
                    suffixQueue.add(numStackTemp.pop());
                }
                // 操作符需要正序
                Stack<String> tempS = new Stack<String>();
                while (!optStackTemp.empty() && !optStackTemp.peek().equals("(")) {
                    tempS.add(optStackTemp.pop());
                }
                while (!tempS.empty()) {
                    suffixQueue.add(tempS.pop());
                }

                if (")".equals(s)) {//右括号出栈,去掉"("
                    optStackTemp.pop();
                } else {
                    optStackTemp.push(s);
                }
            } else {
                //纯数字 加入
                numStackTemp.add(s);
                //suffixQueue.add(s);
            }
        }

        while (!numStackTemp.empty()) {
            suffixQueue.add(numStackTemp.pop());
        }

        //注意：兜底stack中的数据:需要按照运算优先级加入list中
        if (!optStackTemp.empty()) {
            if ((!optStackTemp.contains("*") && !optStackTemp.contains("/")) ||
                    (!optStackTemp.contains("+") && !optStackTemp.contains("-"))) {
                Stack<String> s = new Stack<>();
                // 倒序输出到 suffixList
                while (!optStackTemp.empty()) {
                    s.push(optStackTemp.pop());
                }
                while (!s.empty()) {
                    suffixQueue.add(s.pop());
                }
            } else {
                while (!optStackTemp.empty()) {
                    suffixQueue.add(optStackTemp.pop());
                }
            }
        }
        return suffixQueue;
    }

    public Stack<String> deal(String s, Stack<String> stackTemp, Deque<String> suffixQueue, Queue<String> infixQueue) {
        if ("(".equals(s) || suffixQueue.isEmpty() || infixQueue.isEmpty()) {
            stackTemp.push(s);
            return stackTemp;
        }
        double a1 = TransStringNum2Double(suffixQueue.pollLast());
        double a2 = TransStringNum2Double(infixQueue.poll());
        if ("*".equals(s)) {
            s = String.valueOf(a1 * a2);
        } else {
            s = String.valueOf(a1 / a2);
        }
        stackTemp.push(s);
        return stackTemp;
    }

    //计算后缀表达式，并返回运算结果
    private double calculatorResult(Queue<String> suffixQueue) {
        Stack<Double> numStack = new Stack<>();
        while (!suffixQueue.isEmpty()) {
            String value = suffixQueue.poll();
            if (IsOperation(value)) {
                // 除以0 错误
                if (doCal(numStack, value) == C.ErrorNum) {
                    return C.ErrorNum;
                }
            } else {
                // 数字转换
                double numValue = TransStringNum2Double(value);
                if (numValue == Double.MIN_VALUE) {
                    return C.ErrorNum;
                }
                numStack.push(numValue);
            }
        }
        return numStack.pop();
    }
}