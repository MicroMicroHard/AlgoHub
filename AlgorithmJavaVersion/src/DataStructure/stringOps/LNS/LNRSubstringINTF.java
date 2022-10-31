package DataStructure.stringOps.LNS;


import Top100.SlidingWindow;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-12-17 下午02:14:33
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 最长无重复子串 LongestNonRepeatSubstring
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @blogURL https: //leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 */

public interface LNRSubstringINTF extends SlidingWindow {

    public int method(String s);
}
