package DataStructure.stringOps.LNS;

import Common.Utils.UTFactory;
import org.junit.Test;

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

public class LNRSubstringByBucket implements LNRSubstringINTF {

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

    //桶排序
    public int method(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //用于记录的桶
        int[] bottle = new int[128];
        int count = 0;
        for (int begin = 0, j = 0; j < s.length(); j++) {
            //找出子串起始位置，通过重复值来判断
            begin = Math.max(bottle[s.charAt(j)], begin);
            //更新记录值
            count = Math.max(count, j - begin + 1);
            //更新桶序号对应的子串起始位置
            bottle[s.charAt(j)] = j + 1;
        }
        return count;
    }
}
