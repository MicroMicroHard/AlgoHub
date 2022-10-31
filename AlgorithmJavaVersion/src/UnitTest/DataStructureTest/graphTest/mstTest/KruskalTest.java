package UnitTest.DataStructureTest.graphTest.mstTest;

import DataStructure.graph.mst.Kruskal;
import UnitTest.DataStructureTest.graphTest.GraphTestData;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-12-26 21:34
 * @author-Email micromicrohard@outlook.com
 * @description 克鲁斯卡尔算法 Kruskal
 * @blogURL
 */
public class KruskalTest extends GraphTestData {

    @Test
    public void testKruskal() {
        test(new Kruskal());
    }

    public void test(Kruskal instance) {
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
