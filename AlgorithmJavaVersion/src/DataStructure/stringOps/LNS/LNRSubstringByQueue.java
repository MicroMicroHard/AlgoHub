package DataStructure.stringOps.LNS;

import Common.Utils.UTFactory;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-12-17 下午02:14:33
 * @author—Email micromicrohard@outlook.com
 * @description 最长无重复子串
 * LongestNoRepeatSubstring
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @blogURL https: //leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 */

public class LNRSubstringByQueue implements LNRSubstringINTF {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误测试案例
    public void TestDoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    //use queue
    public int method(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int right = 0;
        //记录元素及其坐标
        Queue<Character> windows = new LinkedList<>();
        int count = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (!windows.contains(c)) {
                windows.add(c);
                count = Math.max(windows.size(), count);
            } else {
                //windows.size() 是为了放置 windows.peek()出现空指针
                while (windows.size() != 0 && windows.peek() != c) {
                    windows.poll();
                }
                windows.poll();
                windows.add(c);
            }
            right++;
        }
        return count;
    }

    public int lengthOfLongestSubstring5(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //记录元素及其坐标
        Queue<Character> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            while (queue.contains(s.charAt(i))) {
                queue.poll();
            }
            queue.add(s.charAt(i));
            count = Math.max(count, queue.size());
        }
        return count;
    }
}
