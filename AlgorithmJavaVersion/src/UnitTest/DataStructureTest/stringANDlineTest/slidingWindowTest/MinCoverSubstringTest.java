package UnitTest.DataStructureTest.stringANDlineTest.slidingWindowTest;

import DataStructure.stringOps.slidingWindow.MinCoverSubstring;
import UnitTest.DataStructureTest.stringANDlineTest.StringData;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/6/23
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 测试用例： 最小覆盖子串
 * 最小覆盖子串
 * 在S(source) 中找到包含T(pattern) 中全部字母的一个子串，且这个子串一定是所有可能子串中最短的
 * 允许T(pattern)子串中包含多个相同的字符
 * 比如在 sx65ytguhuihuba9d08cuygf4e5f3wsedc89faojinbfre43wedcfgv
 * 中查找 abcdeff 的 最小覆盖子串 是 edc89faojinbf
 */
public class MinCoverSubstringTest extends StringData {

    MinCoverSubstring instance = new MinCoverSubstring();

    @Test
    public void testfindMinSubStringMethod() {
        String answer = instance.findMinSubStringMethod(source01, pattern01);
        assert answer.equals(pattern012);
        answer = instance.findMinSubStringMethod(source02, pattern02);
        assert answer.equals(pattern012);
        answer = instance.findMinSubStringMethod(source022, pattern022);
        assert answer.equals(pattern0122);

        answer = instance.findMinSubStringMethod(source03, pattern345);
        assert answer.equals(pattern0345);
        answer = instance.findMinSubStringMethod(source04, pattern345);
        assert answer.equals(pattern0345);
        answer = instance.findMinSubStringMethod(source05, pattern345);
        assert answer.equals(pattern0345);

        answer = instance.findMinSubStringMethod(source06, pattern678);
        assert answer.equals(pattern0678);
        answer = instance.findMinSubStringMethod(source07, pattern678);
        assert answer.equals(pattern0678);
        answer = instance.findMinSubStringMethod(source08, pattern678);
        assert answer.equals(pattern0678);

        answer = instance.findMinSubStringMethod(source09, pattern09);
        assert answer.equals(pattern09);

        answer = instance.findMinSubStringMethod(source10, pattern10);
        assert answer.equals(pattern10);

        answer = instance.findMinSubStringMethod(source16, pattern16);
        assert answer.equals(pattern16);
    }
}
