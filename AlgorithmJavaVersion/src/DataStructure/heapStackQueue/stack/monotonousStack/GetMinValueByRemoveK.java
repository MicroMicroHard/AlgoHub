package DataStructure.heapStackQueue.stack.monotonousStack;

import java.util.Stack;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/1/24
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://leetcode-cn.com/problems/remove-k-digits/
 * @description 移掉 K 位数字
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * input：num = "1432219", k = 3
 * output："1219"
 * <p>
 * input：num = "10200", k = 1
 * output："200"
 * <p>
 * input：num = "10", k = 2
 * output："0"
 */

public class GetMinValueByRemoveK {

    public String removeKDigits(String num, int k) {
        if (num == null || k > num.length()) {
            return "";
        }
        if (k == num.length()) {
            return "0";
        }
        int[] numIntArray = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            if (n > 9) { // 防止出现字符
                return "";
            } else {
                numIntArray[i] = n;
            }
        }
        // 单调栈
        Stack<Integer> stack = new Stack<>();
        for (int j : numIntArray) {
            while (!stack.empty() && k > 0 && stack.peek() > j) {
                k--;
                stack.pop();
            }
            stack.push(j);
        }
        while (k != 0 && !stack.empty()) {
            k--;
            stack.pop();
        }

        //输出最小值，前缀0去除
        StringBuilder sb = new StringBuilder();
        int zeroLength = 0;
        while (!stack.empty()) {
            int u = stack.pop();
            sb.append(u);
            if (u != 0) {
                zeroLength = 0;
            } else {
                zeroLength++;
            }
        }
        String answer = sb.reverse().toString();
        if (zeroLength != 0) {
            answer = answer.substring(zeroLength);
        }
        return answer.length() == 0 ? "0" : answer;
    }
}
