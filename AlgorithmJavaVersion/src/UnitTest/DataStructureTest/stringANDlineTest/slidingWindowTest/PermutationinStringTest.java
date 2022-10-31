package UnitTest.DataStructureTest.stringANDlineTest.slidingWindowTest;

import DataStructure.stringOps.slidingWindow.PermutationinString;
import UnitTest.DataStructureTest.stringANDlineTest.StringData;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/6/23
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 测试用例： 字符串排列
 */
public class PermutationinStringTest extends StringData {

    @Test
    public void test() {
        testcheck(new PermutationinString());
    }

    public void testcheck(PermutationinString p) {
        boolean flag = p.check(source01, pattern01);
        assert !flag;
        flag = p.check(source02, pattern02);
        assert !flag;

        flag = p.check(source03, pattern345);
        assert !flag;
        flag = p.check(source04, pattern345);
        assert !flag;
        flag = p.check(source05, pattern345);
        assert !flag;

        flag = p.check(source06, pattern678);
        assert !flag;
        flag = p.check(source07, pattern678);
        assert !flag;
        flag = p.check(source08, pattern678);
        assert !flag;

        flag = p.check(source09, pattern09);
        assert !flag;
        flag = p.check(source10, pattern10);
        assert !flag;

        flag = p.check(source11, pattern11);
        assert flag;
        flag = p.check(source12, pattern12);
        assert flag;
        flag = p.check(source13, pattern13);
        assert flag;
        flag = p.check(source131, pattern131);
        assert flag;
    }
}
