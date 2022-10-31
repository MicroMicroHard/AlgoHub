package DataStructure.stringOps.slidingWindow;

import java.util.*;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/12/21
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 最小覆盖字串
 * 1、要求 最小覆盖字串 中仅仅含有一个字符：[a-z]、[A-Z]
 * 2、要求 最小覆盖字串 中所有符号不能重复
 * 3、满足上述要求的最大值
 */
public class MinCoverSubstringPlus extends MinCoverSubstring {

    public int findMinSubString(String source) {
        int alphaNum = 0;
        int num = 0;
        Character alphaPre = null;
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            // 字符处理
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                // 纠正 alpha 的数量
                if (alphaPre != null && !queue.contains(alphaPre)) {
                    alphaNum = 0;
                }
                alphaNum++;
                if (alphaNum > 1) {
                    num = Math.max(num, queue.size());
                    minimize(queue, alphaPre, false);
                    alphaNum--;
                }
                alphaPre = c;
                queue.offer(c);
                num = Math.max(num, queue.size());
                continue;
            }
            // 非字符处理
            if (!queue.contains(c)) {
                queue.offer(c);
                num = Math.max(num, queue.size());
            } else {
                minimize(queue, c, true);
            }
        }
        return num;
    }

    // 滑动窗口内字符串减少,flag表示字符是否保留
    private void minimize(Queue<Character> queue, Character c, boolean flag) {
        while (queue.peek() != c) {
            queue.poll();
        }
        queue.poll();
        if (flag) {
            queue.offer(c);
        }
    }
}
