package UnitTest.DataStructureTest.stackHeapQueueTest.stackTest.effectBracketsTest;

import DataStructure.heapStackQueue.stack.effectBrackets.EffectBrackets2;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/29
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 判断有效括号 测试案例
 */
public class EffectBrackets2Test {

    EffectBrackets2 effectBrackets2 = new EffectBrackets2();

    @Test
    public void test() {
        boolean flag = effectBrackets2.check(demo01);
        assert flag;
        flag = effectBrackets2.check(demo01);
        assert flag;
        flag = effectBrackets2.check(demo01);
        assert flag;
        flag = effectBrackets2.check(demo02);
        assert flag;
        flag = effectBrackets2.check(demo03);
        assert flag;
        flag = effectBrackets2.check(demo04);
        assert flag;
        flag = effectBrackets2.check(demo05);
        assert flag;
        flag = effectBrackets2.check(demo06);
        assert flag;
        flag = effectBrackets2.check(demo07);
        assert flag;
        flag = effectBrackets2.check(demo08);
        assert flag;
        flag = effectBrackets2.check(demo09);
        assert flag;

        flag = effectBrackets2.check(demo10);
        assert !flag;
        flag = effectBrackets2.check(demo11);
        assert flag;
        flag = effectBrackets2.check(demo12);
        assert !flag;
    }

    String demo01 = "";
    String demo02 = null;
    String demo03 = "(((*)))";
    String demo04 = "((())*";
    String demo05 = "*()";
    String demo06 = "*)";
    String demo07 = "*()";
    String demo08 = "*()()(())*";
    String demo09 = "*)()(((*)*";

    String demo10 = "*(";
    String demo11 = "*())";
    String demo12 = "*(()";
}
