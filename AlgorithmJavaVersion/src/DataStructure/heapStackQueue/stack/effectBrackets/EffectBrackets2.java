package DataStructure.heapStackQueue.stack.effectBrackets;

import java.util.Stack;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/29
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 判断有效括号
 * 输入一个字符串，包括（、）、*和空格 ，判断是否为有效的匹配括号
 * 输入的字符中含有 * 号，*号可以当作任意的（、）、空格
 * 注意到空格或者空，也属于正常匹配
 * 输入：（（（*）））（）*
 * 输出：true
 * 输入：（（）*））
 * 输出：false
 */
public class EffectBrackets2 {

    public boolean check(String source) {
        if (source == "" || source == null) {
            return true;
        }
        Stack<Integer> stack = new Stack();
        Stack<Integer> stackStar = new Stack();
        String[] ans = new String[source.length()];
        for (int i = 0; i < source.length(); i++) {
            ans[i] = String.valueOf(source.charAt(i));
        }
        for (int i = 0; i < ans.length; i++) {
            if ("(".equals(ans[i])) {
                stack.push(i);
            } else if ("*".equals(ans[i])) {
                stackStar.push(i);
            } else if (")".equals(ans[i])) {
                if (!stack.empty()) {
                    stack.pop();
                } else if (!stackStar.empty()) {
                    stackStar.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        while (!stack.empty()) {
            if (stack.pop() > stackStar.pop()) {
                return false;
            }
        }
        return true;
    }
}
