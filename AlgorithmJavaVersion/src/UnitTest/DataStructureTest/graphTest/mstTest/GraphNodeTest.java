package UnitTest.DataStructureTest.graphTest.mstTest;

import DataStructure.graph.GraphNode;
import DataStructure.graph.VertexNode;
import UnitTest.DataStructureTest.graphTest.GraphTestData;
import org.junit.Test;

public class GraphNodeTest extends GraphTestData implements GraphNode {

    @Test
    public void testAdjacencyMatrix2Table() {
        VertexNode[] answer = AdjacencyMatrix2Table(AdjacencyMatrix_demo01);
        assert AdjacencyTableEqual(answer, AdjacencyTable_demo01());
        answer = AdjacencyMatrix2Table(AdjacencyMatrix_demo02);
        assert AdjacencyTableEqual(answer, AdjacencyTable_demo02());
        answer = AdjacencyMatrix2Table(AdjacencyMatrix_demo03);
        assert AdjacencyTableEqual(answer, AdjacencyTable_demo03());
        answer = AdjacencyMatrix2Table(AdjacencyMatrix_demo04);
        assert AdjacencyTableEqual(answer, AdjacencyTable_demo04());
        answer = AdjacencyMatrix2Table(AdjacencyMatrix_demo05);
        assert AdjacencyTableEqual(answer, AdjacencyTable_demo05());
        answer = AdjacencyMatrix2Table(AdjacencyMatrix_demo06);
        assert AdjacencyTableEqual(answer, AdjacencyTable_demo06());
        answer = AdjacencyMatrix2Table(AdjacencyMatrix_demo07);
        assert AdjacencyTableEqual(answer, AdjacencyTable_demo07());
        answer = AdjacencyMatrix2Table(AdjacencyMatrix_demo08);
        assert AdjacencyTableEqual(answer, AdjacencyTable_demo08());
    }

    @Test
    public void testAdjacencyTable2Matrix() {
        int[][] answer = AdjacencyTable2Matrix(AdjacencyTable_demo01());
        assert AdjacencyMatrixEqual(answer, AdjacencyMatrix_demo01);
        answer = AdjacencyTable2Matrix(AdjacencyTable_demo02());
        assert AdjacencyMatrixEqual(answer, AdjacencyMatrix_demo02);
        answer = AdjacencyTable2Matrix(AdjacencyTable_demo03());
        assert AdjacencyMatrixEqual(answer, AdjacencyMatrix_demo03);
        answer = AdjacencyTable2Matrix(AdjacencyTable_demo04());
        assert AdjacencyMatrixEqual(answer, AdjacencyMatrix_demo04);
        answer = AdjacencyTable2Matrix(AdjacencyTable_demo05());
        assert AdjacencyMatrixEqual(answer, AdjacencyMatrix_demo05);
        answer = AdjacencyTable2Matrix(AdjacencyTable_demo06());
        assert AdjacencyMatrixEqual(answer, AdjacencyMatrix_demo06);
        answer = AdjacencyTable2Matrix(AdjacencyTable_demo07());
        assert AdjacencyMatrixEqual(answer, AdjacencyMatrix_demo07);
        answer = AdjacencyTable2Matrix(AdjacencyTable_demo08());
        assert AdjacencyMatrixEqual(answer, AdjacencyMatrix_demo08);
    }

    @Test
    public void testGraphNodeShip2AdjacencyTable() {
        VertexNode[] answer = GraphNodeShip2AdjacencyTable(GraphNodeShip_demo01);
        assert AdjacencyTableEqual(answer, AdjacencyTable_demo01());
        answer = GraphNodeShip2AdjacencyTable(GraphNodeShip_demo02);
        assert AdjacencyTableEqual(answer, AdjacencyTable_demo02());
        answer = GraphNodeShip2AdjacencyTable(GraphNodeShip_demo03);
        assert AdjacencyTableEqual(answer, AdjacencyTable_demo03());
        answer = GraphNodeShip2AdjacencyTable(GraphNodeShip_demo04);
        assert AdjacencyTableEqual(answer, AdjacencyTable_demo04());
        answer = GraphNodeShip2AdjacencyTable(GraphNodeShip_demo05);
        assert AdjacencyTableEqual(answer, AdjacencyTable_demo05());
        answer = GraphNodeShip2AdjacencyTable(GraphNodeShip_demo06);
        assert AdjacencyTableEqual(answer, AdjacencyTable_demo06());
        answer = GraphNodeShip2AdjacencyTable(GraphNodeShip_demo07);
        assert AdjacencyTableEqual(answer, AdjacencyTable_demo07());
        answer = GraphNodeShip2AdjacencyTable(GraphNodeShip_demo08);
        assert AdjacencyTableEqual(answer, AdjacencyTable_demo08());
    }

    @Test
    public void testGraphNodeShip2AdjacencyMatrix() {
        int[][] answer = GraphNodeShip2AdjacencyMatrix(GraphNodeShip_demo01);
        assert AdjacencyMatrixEqual(answer, AdjacencyMatrix_demo01);
        answer = GraphNodeShip2AdjacencyMatrix(GraphNodeShip_demo02);
        assert AdjacencyMatrixEqual(answer, AdjacencyMatrix_demo02);
        answer = GraphNodeShip2AdjacencyMatrix(GraphNodeShip_demo03);
        assert AdjacencyMatrixEqual(answer, AdjacencyMatrix_demo03);
        answer = GraphNodeShip2AdjacencyMatrix(GraphNodeShip_demo04);
        assert AdjacencyMatrixEqual(answer, AdjacencyMatrix_demo04);
        answer = GraphNodeShip2AdjacencyMatrix(GraphNodeShip_demo05);
        assert AdjacencyMatrixEqual(answer, AdjacencyMatrix_demo05);
        answer = GraphNodeShip2AdjacencyMatrix(GraphNodeShip_demo06);
        assert AdjacencyMatrixEqual(answer, AdjacencyMatrix_demo06);
        answer = GraphNodeShip2AdjacencyMatrix(GraphNodeShip_demo07);
        assert AdjacencyMatrixEqual(answer, AdjacencyMatrix_demo07);
        answer = GraphNodeShip2AdjacencyMatrix(GraphNodeShip_demo08);
        assert AdjacencyMatrixEqual(answer, AdjacencyMatrix_demo08);
    }
}
