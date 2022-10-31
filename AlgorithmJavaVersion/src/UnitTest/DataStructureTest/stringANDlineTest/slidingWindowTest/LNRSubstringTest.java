package UnitTest.DataStructureTest.stringANDlineTest.slidingWindowTest;

import DataStructure.stringOps.LNS.LNRSubstringINTF;
import DataStructure.stringOps.LNS.LNRSubstringByBucket;
import DataStructure.stringOps.LNS.LNRSubstringByMap;
import DataStructure.stringOps.LNS.LNRSubstringByQueue;
import org.junit.Test;

/**
 * @author liujun
 * @author Email ljfirst@mail.ustc.edu.cn
 * @version 1.0
 * @date 2019-11-06 00:06
 * @description 单元测试： 最长无重复子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */

public class LNRSubstringTest {

    @Test
    public void testLNRSubstringByBucket() {
        test(new LNRSubstringByBucket());
    }

    @Test
    public void testLNRSubstringByMap() {
        test(new LNRSubstringByMap());
    }

    @Test
    public void testLNRSubstringByQueue() {
        test(new LNRSubstringByQueue());
    }

    public void test(LNRSubstringINTF instance) {
        int length = instance.method(demo01);
        assert length == 0;
        length = instance.method(demo02);
        assert length == 0;
        length = instance.method(demo03);
        assert length == 1;
        length = instance.method(demo04);
        assert length == 36;
        length = instance.method(demo05);
        assert length == 3;
        
        length = instance.method(demo06);
        assert length == 14;
        length = instance.method(demo07);
        assert length == 21;
        length = instance.method(demo08);
        assert length == 18;
        length = instance.method(demo09);
        assert length == 2;
        length = instance.method(demo10);
        assert length == 7;
    }

    public String demo01 = "";
    public String demo02 = null;
    public String demo03 = "aaaaaaaaaaaaaaaaaaaaaa";
    public String demo04 = "1234567890abcdefghijklmnopqrstuvwxyz";
    public String demo05 = "123123123123123123123";
    public String demo06 = "abcdefg1234567abcdefg1234567";
    public String demo07 = "abcdefg!@#$%^&1234567abcdefg!@#$%^&1234567";
    public String demo08 = "abcdg!@#$^&1234567abcg!@#$^&567";
    public String demo09 = "122333444455555666666";
    public String demo10 = "111111111111112345677777777777777777";
}

