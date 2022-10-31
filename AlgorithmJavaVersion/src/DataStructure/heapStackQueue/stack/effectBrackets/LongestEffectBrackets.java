package DataStructure.heapStackQueue.stack.effectBrackets;

import DataStructure.heapStackQueue.stack.effectBrackets.EffectBrackets;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-12-01 17:48
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 判断最长有效括号【连续】
 * 输入一个字符串，从中找出最长的有效括号
 * 输入：（（（）--（（（）））--））
 * 输出：6个 ：--》（（（）））
 * @blogURL
 */
public class LongestEffectBrackets {

    EffectBrackets effectBrackets = new EffectBrackets();

    //暴力
    public int LongestEffectBracketsNum(String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < pattern.length() - 1; i++) {
            for (int j = i + 1; j < pattern.length(); j++) {
                if (effectBrackets.EffectBracketsbyTotalNum(pattern.substring(i, j + 1))) {
                    sum = Math.max(j - i + 1, sum);
                }
            }
        }
        return sum;
    }

    //??????????Ч????
    public int LongestEffectBracketsNum_(String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return 0;
        }
        int sum = 0;

        return sum;
    }
}
