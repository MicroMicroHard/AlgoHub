package UnitTest.DataStructureTest.graphTest.mstTest;

import DataStructure.graph.mst.Prim;
import UnitTest.DataStructureTest.graphTest.GraphTestData;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/3/11 12:06 AM
 * @author-Email micromicrohard@outlook.com
 * @description 普瑞姆算法 Prim
 */
public class PrimTest extends GraphTestData {

    public void test(Prim instance) {
        instance.buildMst(GraphNodeShip_demo01);
        assert instance.mstTotalValue == 10;
        instance.buildMst(GraphNodeShip_demo02);
        assert instance.mstTotalValue == 4;
        instance.buildMst(GraphNodeShip_demo03);
        assert instance.mstTotalValue == 0;
        instance.buildMst(GraphNodeShip_demo04);
        assert instance.mstTotalValue == 0;
        instance.buildMst(GraphNodeShip_demo05);
        assert instance.mstTotalValue == 8;
        instance.buildMst(GraphNodeShip_demo06);
        assert instance.mstTotalValue == 4;
        instance.buildMst(GraphNodeShip_demo07);
        assert instance.mstTotalValue == 5;
        instance.buildMst(GraphNodeShip_demo08);
        assert instance.mstTotalValue == 15;
    }
}
