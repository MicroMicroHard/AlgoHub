package UnitTest.DataStructureTest.stringANDlineTest.sequenceANDstringTest;

import DataStructure.stringOps.stringAndSequence.MinCyclicsubString;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/1/19
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 最小循环字符串 测试案例
 */
public class MinCyclicsubStringTest {

    MinCyclicsubString mcs = new MinCyclicsubString();

    @Test
    public void test() {
        String answer = mcs.getCycle(demo01);
        assert answer.equals(target01);
        answer = mcs.getCycle(demo02);
        assert answer.equals(target02);
        answer = mcs.getCycle(demo03);
        assert answer.equals(target03);
        answer = mcs.getCycle(demo04);
        assert answer.equals(target04);
    }

    String demo01 = "asdfasdfasdfasdfasdfasdfasd";
    String target01 = "asdf";
    String demo02 = "yhbnhgbkiugjgyhbnhgbkiugjg";
    String target02 = "yhbnhgbkiugjg";
    String demo03 = "kfdf2ghjklkjh4gf2dfgjkl2gfdf6gh";
    String target03 = "kfdf2ghjklkjh4gf2dfgjkl2gfdf6gh";
    String demo04 = "asdfasdfasdf1asdfasdfasdf1asd";
    String target04 = "asdfasdfasdf1";
}
