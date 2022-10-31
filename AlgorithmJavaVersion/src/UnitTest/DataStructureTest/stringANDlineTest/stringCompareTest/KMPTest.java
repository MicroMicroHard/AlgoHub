package UnitTest.DataStructureTest.stringANDlineTest.stringCompareTest;

import DataStructure.stringOps.stringCompare.KMP;
import UnitTest.DataStructureTest.stringANDlineTest.StringCompareTestDemo;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-12-06 22:54
 * @author-Email micromicrohard@outlook.com
 * @description
 * @blogURL
 */
public class KMPTest extends StringCompareTestDemo {

    @Test
    public void testCompare() {
        super.testCompare(new KMP());
    }
}
