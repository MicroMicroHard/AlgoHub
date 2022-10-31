package UnitTest.DataStructureTest.stringANDlineTest.slidingWindowTest;

import DataStructure.stringOps.slidingWindow.MinCoverSubstringPlus;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/12/21
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 单元测试： 最小覆盖子串
 * 1、要求 最小覆盖字串 中仅仅含有一个字符：[a-z]、[A-Z]
 * 2、要求 最小覆盖字串 中所以符号不能重复
 * 3、满足上述要求的最大值
 */

public class MinCoverSubstringTest1Test {

    @Test
    public void test() {
        test(new MinCoverSubstringPlus());
    }

    public void test(MinCoverSubstringPlus mc) {
        int target = mc.findMinSubString(demo01);
        assert target == 2;
        target = mc.findMinSubString(demo02);
        assert target == 0;
        target = mc.findMinSubString(demo03);
        assert target == 3;
        target = mc.findMinSubString(demo04);
        assert target == 1;
        target = mc.findMinSubString(demo05);
        assert target == 5;
        target = mc.findMinSubString(demo06);
        assert target == 2;
        target = mc.findMinSubString(demo07);
        assert target == 11;
    }

    public String demo01 = "dcv2jigb3oiuyg4bouy55wertyuioplkjhgfd";
    public String demo02 = "";
    public String demo03 = "123";
    public String demo04 = "asdf";
    public String demo05 = "12d34";
    public String demo06 = "as2df";
    public String demo07 = "1234567890s098765d432f3456g789";

}
