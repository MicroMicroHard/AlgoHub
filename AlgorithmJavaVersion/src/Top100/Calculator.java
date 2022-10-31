package Top100;

import DataStructure.heapStackQueue.stack.calculator.Calculator_Impl_Brackets_WithOut;
import DataStructure.heapStackQueue.stack.calculator.Calculator_Impl_Brackets;
import DataStructure.heapStackQueue.stack.calculator.Calculator_Impl;
import DataStructure.heapStackQueue.stack.calculator.Calculator_Suffix;
import Common.Constant.C;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-5-13 10:29:49
 * @author-Email micromicrohard@outlook.com
 * @description Calculate 计算器
 * 根据输入的表达式，运算出结果
 */

public interface Calculator {

    double cal(String exp);

    default void TypicalImply() {
        // 简易计算器 无括号优先级
        Calculator_Impl_Brackets_WithOut c1 = new Calculator_Impl_Brackets_WithOut();
        // 简易计算器 带括号优先级
        Calculator_Impl_Brackets c2 = new Calculator_Impl_Brackets();
        // 后缀表达式 计算器
        Calculator_Suffix c3 = new Calculator_Suffix();
        // 计算器
        Calculator_Impl c4 = new Calculator_Impl();
    }

    default Queue<String> ExprToQueue(String expr) {
        if (expr == null || expr.length() == 0) {
            return null;
        }
        // 转换成便于处理的Queue
        expr = expr.replaceAll("\\s*", "");
        StringBuilder sb = new StringBuilder();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (!IsDigital(c)) {
                if (sb.length() > 0) {
                    queue.add(sb.toString());
                    sb.delete(0, sb.length());
                }
                queue.add(String.valueOf(c));
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            queue.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return queue;
    }

    // 是否为数字【需要考虑小数点】
    default Boolean IsDigital(char c) {
        return c >= '0' && c <= '9' || c == '.';
    }

    default Boolean IsDigital(String c) {
        // 正则grammar: \\d标识数字，+表示至少1个
        String pattern = "[.\\d]+";
        return c.matches(pattern);
        /*int num = 0;
        try {
            num = Integer.parseInt(c);
        } catch (Exception e) {
            return false;
        }
        return ".".equals(c) || (num >= 0 && num <= 9);*/
    }

    default Boolean IsOperation(String c) {
        //return Stream.of("+", "-", "*", "/").anyMatch(x -> x.equals(c));
        return Arrays.asList("+", "-", "*", "/").contains(c);
    }

    // String类型的小数转化成Double
    default double TransStringNum2Double(String valueStr) {
        if (!IsDigital(valueStr)) {
            return Double.MAX_VALUE;
        }
        return Double.parseDouble(valueStr);
        /*// 小数的处理
        if (valueStr.contains(".")) {
            String[] num = valueStr.split("\\.");
            // 默认超过2位小数的数字不合规
            if (num.length > 2 || num[0] == null || num[0].length() == 0) {
                return C.ErrorNum;
            }
            return Double.parseDouble(num[0]) + Double.parseDouble(num[1]) / Math.pow(10, num[1].length());
        }
        // 整数的处理
        return Double.parseDouble(valueStr);*/
    }

    default double doCal(Stack<Double> numStack, String operation) {
        if (numStack.size() < 2) {
            return 0;
        }
        double a1 = numStack.pop();
        double a2 = numStack.pop();
        double value1 = 0;
        switch (operation) {
            case "+":
                value1 = a2 + a1;
                break;
            case "-":
                value1 = a2 - a1;
                break;
            case "*":
                value1 = a2 * a1;
                break;
            case "/":
                if (a1 == 0) {
                    return C.ErrorNum;
                }
                value1 = a2 / a1;
                break;
        }
        numStack.push(value1);
        return value1;
    }
}
