package UnitTest.DataStructureTest.arrayAndListTest.arrayApplyTest;

import DataStructure.arrayRelevant.arrayApply.HoldWater1;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/1
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 盛水问题 测试用例
 */
public class HoldWater1Test {

    HoldWater1 h = new HoldWater1();

    @Test
    public void testsum() {
        int value = h.sum(demo01);
        assert value == 0;
        value = h.sum(demo02);
        assert value == 0;
        value = h.sum(demo03);
        assert value == 49;
        value = h.sum(demo04);
        assert value == 7;
    }


    int[] demo01 = null;
    int[] demo02 = {};
    int[] demo03 = {3, 8, 6, 2, 5, 4, 8, 3, 7};
    int[] demo04 = {1, 3, 7, 4000, 2};

}
