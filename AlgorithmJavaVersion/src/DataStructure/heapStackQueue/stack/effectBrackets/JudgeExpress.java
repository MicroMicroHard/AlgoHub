package DataStructure.heapStackQueue.stack.effectBrackets;

import DataStructure.heapStackQueue.stack.effectBrackets.EffectBrackets;
import Top100.Calculator;
import UnitTest.DataStructureTest.stackHeapQueueTest.stackTest.calculatorTest.Calculator_TestData;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/30
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 判断一个表达式是否为正确的 数学运算表达式
 * （1.0）字符串是否为空串，     ->样例：null 或者 ""
 * （1.1）将string数据去空格，  ->样例： 23 + 3*5 /   2
 * （1.2）是否仅含数字和字符，   ->样例： 2dd3+8/2c
 * （1.3）判断括号是否符合标准，  ->样例： (4*(2+3)
 * （1.4）判断运算符是否符合标准，->样例： 2+-3     或者  2+（*9）
 * （1.5）判断数字是否标准，     ->样例： 012*003  或者  2+（.23+7）
 */
public class JudgeExpress extends Calculator_TestData {

    //检查并处理字符串
    public static boolean check(String expr) {
        if (expr == null || expr.length() == 0 || expr.trim().length() == 0) {
            return false;
        }
        //1、将string数据去空格  ：expr.replaceAll(" ","");
        expr = expr.replaceAll("\\s*", "");

        //2、是否仅含数字、字符（+、-、*、/、（、））、小数点
        String pattern = "([+\\-*/()\\d.]?)*";
        if (!expr.matches(pattern)) {
            return false;
        }

        //3、判断括号是否符合标准
        if (!EffectBrackets.EffectBracketsbyStack(expr)) {
            return false;
        }

        //4、判断运算符是否符合标准
        /*List<Character> listChar = new ArrayList() {{
            add('+');
            add('-');
            add('*');
            add('/');
        }};*/
        List<Character> listChar = Stream.of('+', '-', '*', '/').collect(Collectors.toList());
        boolean operaSymbol = false;
        for (int i = 0; i < expr.length(); i++) {
            // 小数点前不是数字
            if (i > 0 && expr.charAt(i) == '.' && !IsDigital(expr.charAt(i - 1))) {
                return false;
            }
            //出现 双运算符号
            if (operaSymbol && listChar.contains(expr.charAt(i))) {
                return false;
            }
            //出现（ + 运算符，经过前面的括号匹配，所以此处的 i 不可能是最后一位，可以放心使用i+1
            if (expr.charAt(i) == '(' && listChar.contains(expr.charAt(i + 1))) {
                return false;
            }
            //出现 运算符 + ）
            if (operaSymbol && ")".equals(String.valueOf(expr.charAt(i)))) {
                return false;
            }
            operaSymbol = listChar.contains(expr.charAt(i));
        }

        //5、判断数字是否标准
        //在 Calculate 的 count 中做过了

        return true;
    }

    // 是否为数字【需要考虑小数点】
    public static Boolean IsDigital(char c) {
        return c >= '0' && c <= '9' || c == '.';
    }
}
