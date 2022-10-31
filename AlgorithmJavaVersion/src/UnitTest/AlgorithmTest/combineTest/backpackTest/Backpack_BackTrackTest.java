package UnitTest.AlgorithmTest.combineTest.backpackTest;

import Algorithm.comprehensive.backpack.Backpack;
import Algorithm.comprehensive.backpack.Backpack_BackTrack;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/10/29
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 背包问题的分支限界的测试案例
 */
public class Backpack_BackTrackTest extends BackpackTest {

    @Test
    public void testBackpack() {
        super.testBackpackGeneral(new Backpack_BackTrack());
    }
}
