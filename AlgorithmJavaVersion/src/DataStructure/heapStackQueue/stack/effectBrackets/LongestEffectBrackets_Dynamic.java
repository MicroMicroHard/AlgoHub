package DataStructure.heapStackQueue.stack.effectBrackets;

import java.util.Arrays;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-12-01 17:48
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 判断最长有效括号【不连续】
 * 输入一个字符串，从中找出最长的有效括号
 * 输入：（（（）--（（（）））--））
 * 输出：6个 ：--》（（（）））
 * @blogURL
 */
public class LongestEffectBrackets_Dynamic extends LongestEffectBrackets {

    // todo  test
    public int LongestEffectBracketsNum(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        int dp[] = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') { //上一个括号可以和当前形成组合
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') { //排除掉已经计算过的括号后，
                    // 再判断前一个括号是否可以和当前形成组合，dp[i - 1]代表上一步中已经得知的有效括号长度，减去这个长度后就可方便的得到尚未匹配的那个括号。
                    // 最近的未匹配点的匹配值
                    int lastMatchValue = (i - 2 - dp[i - 1]) >= 0 ? dp[i - 2 - dp[i - 1]] : 0;
                    dp[i] = dp[i - 1] + lastMatchValue + 2;
                } else {
                    dp[i] = dp[i - 1];
                }
//                maxLength = Math.max(maxLength, dp[i]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        System.out.println(s);
        // array print grammar: 打印数组，但是这种方式打印出来的是[1,2,3],不是{1,2,3}
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }
}
