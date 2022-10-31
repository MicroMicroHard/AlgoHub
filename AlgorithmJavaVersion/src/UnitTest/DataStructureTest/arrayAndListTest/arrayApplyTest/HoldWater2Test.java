package UnitTest.DataStructureTest.arrayAndListTest.arrayApplyTest;

import DataStructure.arrayRelevant.arrayApply.HoldWater2;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/1
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 接雨水 测试用例
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 */
public class HoldWater2Test {
    HoldWater2 h = new HoldWater2();

    @Test
    public void testsum() {
        int value = h.sum(demo01);
        assert value == 0;
        value = h.sum(demo02);
        assert value == 0;
        value = h.sum(demo03);
        assert value == 6;
    }

    int[] demo01 = null;
    int[] demo02 = {};
    int[] demo03 = {0,1,0,2,1,0,1,3,2,1,2,1};
}
