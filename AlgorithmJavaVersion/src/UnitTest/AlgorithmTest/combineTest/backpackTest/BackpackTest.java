package UnitTest.AlgorithmTest.combineTest.backpackTest;

import Algorithm.comprehensive.backpack.Backpack;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/10/29
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 背包问题 基础案例
 */
public class BackpackTest {

    public void testBackpackGeneral(Backpack backpack) {
        testBackpack(backpack);
        int Value = backpack.Backpack(goodsValue051, weight051, packageWeight051);
        assert Value == targetValue051;
        Value = backpack.Backpack(goodsValue052, weight052, packageWeight052);
        assert Value == targetValue052;
        Value = backpack.Backpack(goodsValue053, weight053, packageWeight053);
        assert Value == targetValue053;
        Value = backpack.Backpack(goodsValue05, weight05, packageWeight05);
        assert Value == targetValue05;
    }

    public void testBackpack(Backpack backpack) {
        int value = backpack.Backpack(goodsValue01, weight01, packageWeight01);
        assert value == targetValue01;
        value = backpack.Backpack(goodsValue02, weight02, packageWeight02);
        assert value == targetValue02;
        value = backpack.Backpack(goodsValue03, weight03, packageWeight03);
        assert value == targetValue03;
        value = backpack.Backpack(goodsValue04, weight04, packageWeight04);
        assert value == targetValue04;
        value = backpack.Backpack(goodsValue041, weight041, packageWeight041);
        assert value == targetValue041;
    }

    //物品价值、物品重量、背包的重量
    int[] goodsValue01 = {};
    int[] weight01 = {3, 8, 3, 9, 4, 6, 6, 3, 9, 2, 9, 8, 1, 9, 7};
    int packageWeight01 = -9;
    int targetValue01 = -1;

    int[] goodsValue02 = {3, 8, 3, 9, 4, 6, 6, 3, 9, 2, 9, 8, 1, 9, 7};
    int[] weight02 = {};
    int packageWeight02 = 90;
    int targetValue02 = -1;

    int[] goodsValue03 = null;
    int[] weight03 = null;
    int packageWeight03 = -9;
    int targetValue03 = -1;

    int[] goodsValue04 = {3, 8, 3, 9, 4, 6, 6, 3, 9, 2, 9, 8, 1, 9, 7};
    int[] weight04 = {3, 8, 3, 9, 4, 6, 6, 3, 9, 2, 9, 8, 1, 9, 7};
    int packageWeight04 = 1;
    int targetValue04 = 1;

    int[] goodsValue041 = {3, 8, 3, 9, 4, 6, 6, 3, 9, 2, 9, 8, 1, 9, 7};
    int[] weight041 = {3, 8, 3, 9, 4, 6, 6, 3, 9, 8, 1, 9, 7};
    int packageWeight041 = 1;
    int targetValue041 = -1;

    //-------  Backpack General Data
    int[] goodsValue05 = {6, 6, 1, 5, 2, 1, 1, 9, 4, 9, 9, 5, 4, 5, 2};
    int[] weight05 = {3, 8, 3, 9, 4, 6, 6, 3, 9, 2, 9, 8, 1, 9, 7};
    int packageWeight05 = 40;
    int targetValue05 = 50;

    int[] goodsValue051 = {6, 6, 1, 5, 4, 5, 2};
    int[] weight051 = {3, 8, 3, 9, 1, 9, 7};
    int packageWeight051 = 20;
    int targetValue051 = 18;

    int[] goodsValue052 = {6, 6, 1, 5, 2, 1, 1, 9, 4, 9, 9, 5, 4, 5, 2};
    int[] weight052 = {3, 8, 3, 9, 4, 6, 6, 3, 9, 2, 9, 8, 1, 9, 7};
    int packageWeight052 = 45;
    int targetValue052 = 53;

    int[] goodsValue053 = {6, 6, 1, 5, 8, 5, 2};
    int[] weight053 = {3, 8, 3, 8, 1, 9, 7};
    int packageWeight053 = 13;
    int targetValue053 = 20;
}
