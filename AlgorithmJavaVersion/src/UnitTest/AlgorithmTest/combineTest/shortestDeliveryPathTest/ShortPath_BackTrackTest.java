package UnitTest.AlgorithmTest.combineTest.shortestDeliveryPathTest;

import Algorithm.comprehensive.shortestDeliveryPath.ShortPath;
import Algorithm.comprehensive.shortestDeliveryPath.ShortPath_BackTrack;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020-02-11 16:08
 * @author—Email  micromicrohard@outlook.com
 * @description  送货最短路径_回溯算法_UT ShortestDeliveryPath
 * @blogURL
 */
public class ShortPath_BackTrackTest extends ShortPathTestData {

    @Test
    public void shortPath(){
        ShortPath shortPath = new ShortPath_BackTrack();

        int sum = shortPath.shortPath(Demorow_01, Democolumn_01);
        assert sum == 30;
        sum = shortPath.shortPath(Demorow_02, Democolumn_02);
        assert sum == -1;
        sum = shortPath.shortPath(Demorow_03, Democolumn_03);
        assert sum == -1;
        sum = shortPath.shortPath(Demorow_04, Democolumn_04);
        assert sum == -1;
        sum = shortPath.shortPath(Demorow_05, Democolumn_05);
        assert sum == 24;
    }
}
