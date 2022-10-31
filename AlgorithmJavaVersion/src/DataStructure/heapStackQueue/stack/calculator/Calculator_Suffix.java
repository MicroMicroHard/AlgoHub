package DataStructure.heapStackQueue.stack.calculator;

import Common.Utils.UTFactory;
import Top100.Calculator;
import org.junit.Test;

import java.util.Stack;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/12/17
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 后缀表达式 计算器
 * 1、只能做后缀表达式计算
 * 2、表达式没有做合规性校验
 * 3、堆栈没有判空
 */

public class Calculator_Suffix implements Calculator {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    public double cal(String exp) {
        if (exp == null || exp.length() == 0) {
            return Integer.MIN_VALUE;
        }
        String[] expArray = exp.split(" ");
        Stack<Double> numStack = new Stack<>();
        String numPattern = "[0-9]+";

        for (int i = 0; i < expArray.length; i++) {
            // 运算符 计算
            if (!expArray[i].matches(numPattern)) {
                double a1 = numStack.pop();
                double a2 = numStack.pop();
                double expResult = 0;
                switch (expArray[i]) {
                    case "+":
                        expResult = a2 + a1;
                        break;
                    case "-":
                        expResult = a2 - a1;
                        break;
                    case "*":
                        expResult = a2 * a1;
                        break;
                    case "/":
                        expResult = a2 / a1;
                        break;
                }
                numStack.push(expResult);
            } else {
                // 数字压栈
                numStack.push(Double.parseDouble(expArray[i]));
            }
        }
        return numStack.pop();
    }

    public double cal1(String exp) {
        if (exp == null || exp.length() == 0) {
            return Integer.MIN_VALUE;
        }
        String[] s = exp.split(" ");
        Stack<String> op = new Stack<>();
        Stack<String> num = new Stack<>();
        String pattern = "[0-9]+";
        int ans = 0;

        for (int i = 0; i < s.length; i++) {
            // 符号运算
            if ("+".equals(s[i]) || "-".equals(s[i])) {
                op.push(s[i]);
            } else if ("*".equals(s[i]) || "/".equals(s[i])) {
                int a1 = Integer.parseInt(num.pop());
                int a2 = Integer.parseInt(num.pop());
                if ("*".equals(s[i])) {
                    ans = a1 * a2;
                } else {
                    ans = a2 / a1;
                }
                num.push(String.valueOf(ans));
            } else if (s[i].matches(pattern)) {
                // 数字存储
                num.push(s[i]);
            } else {
                // 异常
                return Integer.MIN_VALUE;
            }
        }

        while (num.size() != 1) {
            int a1 = Integer.parseInt(num.pop());
            int a2 = Integer.parseInt(num.pop());
            String op1 = op.pop();
            if ("+".equals(op1)) {
                ans = a1 + a2;
            } else {
                ans = a2 - a1;
            }
            num.push(String.valueOf(ans));
        }

        return Integer.parseInt(num.pop());
    }
}
