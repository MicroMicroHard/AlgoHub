package UnitTest.DataStructureTest.graphTest;

import DataStructure.graph.shortestPath.singleSourceShortestPath.Dijkstra;
import Common.Utils.ArrayTools;
import org.junit.Test;


/**
 * @author liujun
 * @version 1.0
 * @date 2019-12-25 21:37
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 狄杰斯特拉算法 测试案例
 * @blogURL
 */

public class DijkstraTest extends GraphTestData {

    Dijkstra dijkstra = new Dijkstra();

    @Test
    public void test() {
        int[] answer = dijkstra.getShortestPath(0, AdjacencyMatrix_demo01);
        assert ArrayTools.IntArrayEquals(answer, target01_0);
        answer = dijkstra.getShortestPath(1, AdjacencyMatrix_demo01);
        assert ArrayTools.IntArrayEquals(answer, target01_1);
        answer = dijkstra.getShortestPath(2, AdjacencyMatrix_demo01);
        assert ArrayTools.IntArrayEquals(answer, target01_2);
        answer = dijkstra.getShortestPath(3, AdjacencyMatrix_demo01);
        assert ArrayTools.IntArrayEquals(answer, target01_3);

        answer = dijkstra.getShortestPath(0, AdjacencyMatrix_demo02);
        assert ArrayTools.IntArrayEquals(answer, target02_0);
        answer = dijkstra.getShortestPath(1, AdjacencyMatrix_demo02);
        assert ArrayTools.IntArrayEquals(answer, target02_1);
        answer = dijkstra.getShortestPath(2, AdjacencyMatrix_demo02);
        assert ArrayTools.IntArrayEquals(answer, target02_2);

        answer = dijkstra.getShortestPath(0, AdjacencyMatrix_demo03);
        assert ArrayTools.IntArrayEquals(answer, target03_0);
    }

    int[] target01_0 = null;
    int[] target01_1 = null;
    int[] target01_2 = null;
    int[] target01_3 = null;

    int[] target02_0 = null;
    int[] target02_1 = null;
    int[] target02_2 = null;

    int[] target03_0 = null;
}
