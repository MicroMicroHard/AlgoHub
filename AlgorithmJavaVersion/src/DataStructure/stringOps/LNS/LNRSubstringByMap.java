package DataStructure.stringOps.LNS;

import Common.Utils.UTFactory;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-12-17 下午02:14:33
 * @author—Email micromicrohard@outlook.com
 * @description 最长无重复子串
 * LongestnoRepeatSubstring
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @blogURL https: //leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 */

public class LNRSubstringByMap implements LNRSubstringINTF {

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

    //use map
    public int method(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        //记录元素及其坐标
        Map<Character, Integer> windows = new TreeMap<>();
        while (right < s.length()) {
            Character c = s.charAt(right);
            if (!windows.containsKey(c)) {
                windows.put(c, right);
                count = Math.max(windows.size(), count);
            } else {
                //int temp = windows.get(c);
                //while (left <= temp) {
                while (left < right && windows.containsKey(c)) {
                    windows.remove(s.charAt(left));
                    left++;
                }
                windows.put(c, right);
            }
            right++;
        }
        return count;
    }
}
