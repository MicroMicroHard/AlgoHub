package UnitTest.AlgorithmTest.combineTest.backpackTest;

import Algorithm.comprehensive.backpack.Backpack_Dynamic;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-9-21 下午08:18:31
 * @author—Email micromicrohard@outlook.com
 * @description 背包问题的动态规划算法的测试案例
 */
public class Backpack_DynamicTest extends BackpackTest {

    @Test
    public void testBackpack() {
        super.testBackpackGeneral(new Backpack_Dynamic());
    }
}
