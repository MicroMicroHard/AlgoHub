package UnitTest.DataStructureTest.stringANDlineTest.stringCompareTest;

import DataStructure.stringOps.stringCompare.RabinKarp;
import UnitTest.DataStructureTest.stringANDlineTest.StringCompareTestDemo;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-12-06 22:54
 * @author-Email  ljfirst@mail.ustc.edu.cn
 * @description 
 * @blogURL
 */
public class RabinKarpTest extends StringCompareTestDemo {

    @Test
    public void testCompare(){
        super.testCompare(new RabinKarp());
    }



    public void testcomparemethod(){
        RabinKarp rabinKarp = new RabinKarp();
        //rabinKarp.compare(String source, String target, int prime, int HEX);
    }
}
