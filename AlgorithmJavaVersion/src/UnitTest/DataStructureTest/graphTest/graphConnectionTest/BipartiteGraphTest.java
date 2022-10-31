package UnitTest.DataStructureTest.graphTest.graphConnectionTest;

import DataStructure.graph.graphApply.BipartiteGraph;
import UnitTest.DataStructureTest.graphTest.GraphTestData;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/3/7 4:21 PM
 * @author-Email micromicrohard@outlook.com
 * @description
 */
public class BipartiteGraphTest extends GraphTestData {

    @Test
    public void test() {
        BipartiteGraph instance = new BipartiteGraph();
        assert !instance.isBipartite(AdjacencyTable_demo01());
        assert !instance.isBipartite(AdjacencyTable_demo02());
        assert instance.isBipartite(AdjacencyTable_demo03());
        assert instance.isBipartite(AdjacencyTable_demo04());
        assert !instance.isBipartite(AdjacencyTable_demo05());
        assert !instance.isBipartite(AdjacencyTable_demo06());
        assert instance.isBipartite(AdjacencyTable_demo07());
    }
}
