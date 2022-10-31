package DataStructure.stringOps.slidingWindow;

import Top100.SlidingWindow;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/6/23
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 子串检测
 * 一个S和一个P，请问你S中是否存在一个子串，包含P中所有字符且不包含其他字符
 * <p>
 * 注意：这道题要注意区别是字符串，不是序列，因此最好是用滑动窗口，而不是仅仅map之间的对比
 */
public class PermutationinString implements SlidingWindow {

    Map<Character, Integer> windowsMap;
    Map<Character, Integer> targetMap;

    public boolean check(String source, String pattern) {
        if (source == null || pattern == null || source.length() == 0 || pattern.length() == 0) {
            return false;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        windowsMap = new TreeMap<>();
        targetMap = new TreeMap<>();

        for (char c : pattern.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        //滑动窗口开始
        while (right < source.length()) {
            char cright = source.charAt(right);
            right++;

            if (targetMap.containsKey(cright)) {
                windowsMap.put(cright, windowsMap.getOrDefault(cright, 0) + 1);
                if (windowsMap.get(cright) == targetMap.get(cright)) {
                    count++;
                }
            } else {
                left = right;
                count = 0;
                windowsMap.clear();
                continue;
            }

            if (right - left == pattern.length()) {
                if (count == targetMap.size()) {
                    return true;
                }
                char cleft = source.charAt(left);
                if (windowsMap.containsKey(cleft)) {
                    windowsMap.put(cleft, windowsMap.get(cleft) - 1);
                    count--;
                }
                left++;
            }
        }
        return false;
    }
}
