package DataStructure.heapStackQueue.stack.calculator;

import DataStructure.heapStackQueue.stack.effectBrackets.JudgeExpress;
import Top100.Calculator;
import Common.Constant.C;

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
public class CalculateImpl implements Calculator {

    JudgeExpress judgeExpress = new JudgeExpress();

    //主要业务代码
    public double cal(String expr) {
        // 校验运算表达式
        if (judgeExpress.check(expr)) {

            Queue<String> queue = ExprToQueue(expr);
            if (queue == null) {
                return C.ErrorNum;
            }
            //中缀表达式转化为后缀表达式
            queue = Infix2Suffix(queue);
            //计算后缀表达式，并返回运算结果,数字不合规的情况下，输出 Integer.MIN_VALUE
            return calculatorResult(queue);
        }
        return C.ErrorNum;
    }

    //中缀表达式转化为后缀表达式
    private Queue<String> Infix2Suffix(Queue<String> infixQueue) {

        Queue<String> suffixQueue = new LinkedList<>();
        // stackTemp是临时栈，专门来处理高优先级的符号
        Stack<String> stackTemp = new Stack<>();

        while (!infixQueue.isEmpty()) {
            String s = infixQueue.poll();
            if ("(".equals(s) || "*".equals(s) || "/".equals(s)) {
                stackTemp.push(s);
            } else if ("+".equals(s) || "-".equals(s)) {
                while (!stackTemp.empty() && !stackTemp.peek().equals("(")) {
                    suffixQueue.add(stackTemp.pop());
                }
                stackTemp.push(s);
            } else if (")".equals(s)) {//右括号出栈
                //如果数据可信，不需要加 !stackTemp.empty()
                while (!stackTemp.empty() && !stackTemp.peek().equals("(")) {
                    suffixQueue.add(stackTemp.pop());
                }
                stackTemp.pop();
            } else {
                //纯数字 加入
                suffixQueue.add(s);
            }
        }
        //注意：兜底stack中的数据:需要按照运算优先级加入list中
        if (!stackTemp.empty()) {
            if ((!stackTemp.contains("*") && !stackTemp.contains("/")) ||
                    (!stackTemp.contains("+") && !stackTemp.contains("-"))) {
                Stack<String> s = new Stack<>();
                // 倒序输出到 suffixList
                while (!stackTemp.empty()) {
                    s.push(stackTemp.pop());
                }
                while (!s.empty()) {
                    suffixQueue.add(s.pop());
                }
            } else {
                while (!stackTemp.empty()) {
                    suffixQueue.add(stackTemp.pop());
                }
            }
        }
        return suffixQueue;
    }

    //计算后缀表达式，并返回运算结果
    private double calculatorResult(Queue<String> suffixQueue) {
        Stack<Double> numStack = new Stack<>();
        while (!suffixQueue.isEmpty()) {
            String value = suffixQueue.poll();
            if (IsDigital(value)) {
                // 数字转换
                double numValue = TransStringNum2Double(value);
                if (numValue == Double.MIN_VALUE) {
                    return C.ErrorNum;
                }
                numStack.push(numValue);
            } else {
                doCal(numStack, value);
            }
        }
        return numStack.pop();
    }
}