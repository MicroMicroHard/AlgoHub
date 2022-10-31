package UnitTest.DataStructureTest.arrayAndListTest.arrayTransformationTest;

import DataStructure.arrayRelevant.arrayTransformation.ReversalString;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/8/25
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description
 */
public class ReversalString1Test {

    @Test
    public void testmethod1() {
        testmethod(new ReversalString());
    }

    public void testmethod(ReversalString RS) {
        String s = RS.method(demo01, c01);
        assert target01.equals(s);
        s = RS.method(demo02, c02);
        assert s == target02;
        s = RS.method(demo03, c03);
        assert target03.equals(s);
        s = RS.method(demo04, c04);
        assert target04 == s;

        s = RS.method(demo05, c05);
        assert target05.equals(s);
        s = RS.method(demo06, c06);
        assert target06.equals(s);
    }

    String demo01 = "123$456789";
    String target01 = "456789$123";
    char c01 = '$';

    String demo02 = "";
    String target02 = null;
    char c02 = '$';

    String demo03 = "123$456789";
    String target03 = "123$456789";
    char c03 = ' ';

    String demo04 = null;
    String target04 = null;
    char c04 = '$';

    String demo05 = "micromicrohard@mail.ustc.edu.cn";
    String target05 = "mail.ustc.edu.cn@micromicrohard";
    char c05 = '@';

    String demo06 = "123456789^abcdefghijklmn";
    String target06 = "abcdefghijklmn^123456789";
    char c06 = '^';
}
