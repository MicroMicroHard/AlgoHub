package UnitTest.DataStructureTest.arrayAndListTest.arrayTransformationTest;

import DataStructure.arrayRelevant.arrayTransformation.ReversalString3;
import Common.Utils.ArrayTools;
import org.junit.Test;

public class ReversalString3Test {

    @Test
    public void testMethod() {
        test(new ReversalString3());
    }

    public void test(ReversalString3 rs3) {
        char[] answer = rs3.method(demo01);
        assert ArrayTools.EqualsCharArray(target01, answer);
    }

    char[] demo01 = {'i', ' ', 'a', 'm', ' ', 'a', ' ', 's', 't', 'u', 'd', 'e', 'n', 't'};
    char[] target01 = {'s', 't', 'u', 'd', 'e', 'n', 't', ' ', 'a', ' ', 'a', 'm', ' ', 'i'};
}
