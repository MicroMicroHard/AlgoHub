package UnitTest.DataStructureTest.stackHeapQueueTest.stackTest.effectBracketsTest;

import DataStructure.heapStackQueue.stack.effectBrackets.LongestEffectBrackets;
import DataStructure.heapStackQueue.stack.effectBrackets.LongestEffectBrackets_Dynamic;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-12-01 17:51
 * @author-Email micromicrohard@outlook.com
 * @description
 * @blogURL
 */
public class LongestEffectBracketsTest {

    @Test
    public void TestLongestEffectBrackets_Dynamic() {
        test(new LongestEffectBrackets_Dynamic());
    }

    @Test
    public void TestLongestEffectBrackets() {
        test(new LongestEffectBrackets());
    }

    public void test(LongestEffectBrackets longestEffectBrackets) {
        int num = longestEffectBrackets.LongestEffectBracketsNum(Demo01);
        assert num == 0;
        num = longestEffectBrackets.LongestEffectBracketsNum(Demo02);
        assert num == 0;
        num = longestEffectBrackets.LongestEffectBracketsNum(Demo03);
        assert num == 2;
        num = longestEffectBrackets.LongestEffectBracketsNum(Demo04);
        assert num == 4;
        num = longestEffectBrackets.LongestEffectBracketsNum(Demo05);
        assert num == 14;
        num = longestEffectBrackets.LongestEffectBracketsNum(Demo06);
        assert num == 14;
        num = longestEffectBrackets.LongestEffectBracketsNum(Demo07);
        assert num == 10;
        num = longestEffectBrackets.LongestEffectBracketsNum(Demo08);
        assert num == 2;
    }

    String Demo01 = "";//0
    String Demo02 = null;//0
    String Demo03 = "()";//2
    String Demo04 = "()()";//4
    String Demo05 = "(()()(()(())))";//14
    String Demo06 = "(()()(()(()))))";//false //14
    String Demo07 = "()(()()))(()(()()))";//10
    String Demo08 = "()((((((((((((((";//2
}
