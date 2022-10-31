package DataStructure.graph.mst;

import DataStructure.graph.EdgeNode;
import DataStructure.graph.VertexNode;
import DataStructure.graph.graphConnect.UnionFindOpt;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-8-2 04:43:06
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 克鲁斯卡尔算法 Kruskal
 */
public class Kruskal implements MST {

    // 最小生成树的权重和
    public int mstTotalValue;
    // 最小生成树的临接表
    public List<EdgeNode> mstEdgeList;
    // 最小生成树的临接矩阵
    public int[][] mstMatrix;


    public void buildMst(int[][] matrix) {
        mstTotalValue = 0;
        mstMatrix = null;
        if (matrix == null || matrix.length == 0) {
            return;
        }
        mstMatrix = new int[matrix.length][matrix.length];
        buildEdgeSet(matrix);
    }

    private void buildEdgeSet(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        VertexNode[] adjacencyTable = GraphNodeShip2AdjacencyTable(matrix);
        UnionFindOpt uf = new UnionFindOpt(adjacencyTable.length);

        // 利用优先队列，实现对边权重的从小到大排列
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int[] edgeNode : matrix) {
            queue.add(new int[]{edgeNode[0], edgeNode[1], edgeNode[2]});
        }
        // 执行算法：将排列后的边纳入到最小生成树
        while (queue.size() != 0) {
            int[] edgeNode = queue.poll();
            // 通过并查集确认是否有环
            if (uf.connected(edgeNode[0], edgeNode[1])) {
                continue;
            }
            mstTotalValue += edgeNode[2];
            uf.union(edgeNode[0], edgeNode[1]);
            mstMatrix[edgeNode[0]][edgeNode[1]] = edgeNode[2];
        }
        if (uf.count() != 1) {
            mstTotalValue = 0;
            mstMatrix = null;
        }
    }

    /**
     * @author liujun
     * @version 1.0
     * @date 2019-12-27 00:09
     * @author-Email ljfirst@mail.ustc.edu.cn
     * @description 克鲁斯卡尔算法的节点
     * @blogURL
     */
    class KruskalEdgeNode {

        int edgeValue;
        int startPoint;
        int endPoint;

        /**
         * @param edgeValue  边的值
         * @param startPoint 起始点
         * @param endPoint   结束点
         */
        KruskalEdgeNode(int edgeValue, int startPoint, int endPoint) {
            this.edgeValue = edgeValue;
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        }
    }
}