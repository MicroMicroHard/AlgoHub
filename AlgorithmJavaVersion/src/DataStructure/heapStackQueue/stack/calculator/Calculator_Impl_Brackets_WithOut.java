package DataStructure.heapStackQueue.stack.calculator;

import DataStructure.heapStackQueue.stack.effectBrackets.JudgeExpress;
import Top100.Calculator;
import Common.Constant.C;
import Common.Utils.UTFactory;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-5-13 10:29:49
 * @author-Email micromicrohard@outlook.com
 * @description Calculator 简易计算器 无括号优先级
 * 根据输入的表达式，运算出结果
 * 1、输入的表达式不需要做校验，满足正常无括号优先级表达式
 */

public class Calculator_Impl_Brackets_WithOut implements Calculator {

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

        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        int n = expr.length();
        char[] cArray = expr.toCharArray();

        for (int i = 0; i < cArray.length; ++i) {
            //从字符串取数字
            if (Character.isDigit(cArray[i])) {
                num = num * 10 + cArray[i] - '0';
            }
            //计算,i == n - 1：表示最后一次运算
            if (!Character.isDigit(expr.charAt(i)) && cArray[i] != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    //符号优先级
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = cArray[i];
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
