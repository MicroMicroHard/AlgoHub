package DataStructure.graph.mst;

import DataStructure.graph.VertexNode;

import java.util.*;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-8-2 下午04:43:17
 * @author—Email micromicrohard@outlook.com
 * @description 普瑞姆算法 Prim
 * Prim算法主要考虑在选取mst的节点的时候，构造一个与mst邻接的数组，来统计剩余节点到mst的最短距离
 * 如果是双向边，mst的邻接数组考虑使用数组来维护
 * 如果是单向边，mst的邻接数组考虑使用优先队列来维护
 */
public class Prim extends Kruskal implements MST {

    // 最小生成树的权重和
    public int mstTotalValue;
    // 最小生成树的临接表
    public VertexNode[] mstEdgeList;
    // 最小生成树的临接矩阵
    public int[][] mstMatrix;

    
    public void buildMst(int[][] matrix) {
        int[][] adjacencyMatrix = GraphNodeShip2AdjacencyMatrix(matrix);
        mstTotalValue = 0;
        mstMatrix = null;
        if (adjacencyMatrix == null) {
            return;
        }
        // mst的邻接边[adjacencyEdge]：与最小生成树 连接 的若干条边的集合
        int[] adjacencyEdge = new int[adjacencyMatrix.length];
        Arrays.fill(adjacencyEdge, Integer.MAX_VALUE);
        mstMatrix = new int[adjacencyMatrix.length][adjacencyMatrix.length];
        int fromEdge = 0;
        int toEdge = 0;

        // 任意一个节点开始，假设从0，对于已经访问过的节点，标记为Integer.MAX_VALUE
        adjacencyEdge[fromEdge] = Integer.MIN_VALUE;

        // 剩余n-1个节点，以昵称循环n-1次
        for (int i = 1; i < adjacencyEdge.length; i++) {
            int distance = Integer.MAX_VALUE;
            // use toEdge update mst的邻接边[mstQueue]
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyEdge[j] != Integer.MIN_VALUE) {
                    // 对无连接点的特殊处理
                    adjacencyMatrix[fromEdge][j] = adjacencyMatrix[fromEdge][j] == 0 ? Integer.MAX_VALUE : adjacencyMatrix[fromEdge][j];
                    adjacencyMatrix[j][fromEdge] = adjacencyMatrix[j][fromEdge] == 0 ? Integer.MAX_VALUE : adjacencyMatrix[j][fromEdge];

                    adjacencyEdge[j] = Math.min(adjacencyEdge[j],
                            Math.min(adjacencyMatrix[fromEdge][j], adjacencyMatrix[j][fromEdge]));
                    // search min distance
                    if (distance > adjacencyEdge[j]) {
                        distance = adjacencyEdge[j];
                        toEdge = j;
                    }
                }
            }
            // update mst
            mstTotalValue += distance;
            mstMatrix[fromEdge][toEdge] = distance;
            // Tips: 已经访问过和不联通需要分别设置不同的flag，防止错误判断
            adjacencyEdge[toEdge] = Integer.MIN_VALUE;
            fromEdge = toEdge;
        }
    }
}
