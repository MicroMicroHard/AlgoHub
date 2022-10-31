package UnitTest.AlgorithmTest.dynamicTest.largestSquareTest;

import Algorithm.dynamic.largestSquare.LargestSquare_DynamicOpt;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/6/3
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 最大正方形的测试案例
 */
public class LargestSquareDynamicOptTest extends LargestSquareTest {

    @Test
    public void testSolution() {
        super.testSolution(new LargestSquare_DynamicOpt());
    }
}
