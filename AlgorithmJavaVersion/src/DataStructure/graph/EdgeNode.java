package DataStructure.graph;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-8-2 04:43:06
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://www.cnblogs.com/hapjin/p/4760934.html
 * @description 图的邻接表 边
 */

public class EdgeNode {

    public VertexNode vertexNode; // 边的结束顶点
    public int edgeValue;         // 边的值（起始-结束节点）

    public EdgeNode(VertexNode vertex, int value) {
        this.vertexNode = vertex;
        edgeValue = value;
    }
}
