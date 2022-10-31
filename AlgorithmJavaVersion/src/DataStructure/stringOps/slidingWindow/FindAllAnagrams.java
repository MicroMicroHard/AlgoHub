package DataStructure.stringOps.slidingWindow;

import Top100.SlidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/6/23
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 找所有字母异位词 找到源串中所有目标串的连续排列
 * 输入一个源串S，一个目标串T，找到S中所有T的连续排列，返回它们的起始索引
 * 输入：从 "2a41b156d3c24d" 中找出 "1234"
 * 输出：156d3c24
 */
public class FindAllAnagrams implements SlidingWindow {

    Map<Character, Integer> windowsMap;
    Map<Character, Integer> targetMap;
    int[] answerArray;
    List<Integer> answerList;

    public int[] print(String source, String target) {
        if (source == null || target == null || source.length() == 0 || target.length() == 0) {
            return new int[]{};
        }
        answerList = new ArrayList<>();
        windowsMap = new TreeMap<>();
        targetMap = new TreeMap<>();
        int left = 0;
        int right = 0;
        int point = 0;
        //初始化目标序列
        for (Character c1 : target.toCharArray()) {
            targetMap.put(c1, targetMap.getOrDefault(c1, 0) + 1);
        }

        for (; right < source.length(); right++) {
            char cright = source.charAt(right);
            if (targetMap.containsKey(cright)) {
                windowsMap.put(cright, windowsMap.getOrDefault(cright, 0) + 1);
                if (windowsMap.get(cright) == targetMap.get(cright)) {
                    point++;
                }
            } else {//遇见字符串断层，相应的数据需要清空
                left = right;
                windowsMap.clear();
                point = 0;
                continue;
            }
            //判断窗口收缩,此处不必用while
            if (right - left + 1 == target.length()) {
                //符合条件，进行存入
                if (point == targetMap.size()) {
                    answerList.add(left);
                    //1号位
                }
                //缩小窗口
                char cleft = source.charAt(left);
                if (windowsMap.containsKey(cleft)) {
                    windowsMap.put(cleft, windowsMap.get(cleft) - 1);
                    point--;//point--只能放在此处，不可以放在 1号位
                }
                left++;
            }
        }
        answerArray = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answerArray;
    }
}
