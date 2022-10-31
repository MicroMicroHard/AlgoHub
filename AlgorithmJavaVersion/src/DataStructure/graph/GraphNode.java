package DataStructure.graph;

import Common.Utils.ArrayTools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-8-2 04:43:06
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://www.cnblogs.com/hapjin/p/4760934.html
 * https://www.jianshu.com/p/bce71b2bdbc8
 * @description 图的数据结构转换，表示图的数据结构有：邻接矩阵[GraphMatrix] 和 邻接表[GraphTable]
 * 图是由(V, E)来表示的，
 * 对于无向图来说，其中 V = (v0, v1, ... , vn)，E = { (vi,vj) (0 <=  i, j <=  n且i 不等于j)}，
 * 对于有向图，E = { < vi,vj > (0 <=  i, j <=  n且i 不等于j)}。V是顶点的集合，E是边的集合。
 * <p>
 * 1、邻接矩阵 通过 n*n 的表格展示点和点的关系，matirx[i][j]表示边的值，分为有向图和无向图
 * 2、邻接表 数组加链表，在邻接列表实现中，每一个顶点会存储一个从它这里开始的边的列表
 * 3、边和节点关系数组[三元组] V = (v0, v1, ... , vn)，E = { (vi,vj) (0 <=  i, j <=  n且i 不等于j)}
 */

public interface GraphNode {

    int U = Integer.MAX_VALUE;            // U = Unreachable
    /*
        int[][]      adjacencyMatrix;     // 邻接矩阵
        VertexNode[] adjacencyTable;      // 邻接表
        int[][]      GraphNodeShip;       // 边和节点关系数组

       主要处理以下关系
       1、邻接矩阵 转 邻接表
       2、邻接表 转 邻接矩阵
       3、边和节点关系数组 转 邻接矩阵
       4、边和节点关系数组 转 邻接表
     */

    // 1、邻接矩阵转邻接表
    default VertexNode[] AdjacencyMatrix2Table(int[][] adjacencyMatrix) {
        if (adjacencyMatrix == null || adjacencyMatrix.length == 0) {
            return null;
        }
        // adjacencyTable init
        VertexNode[] table = new VertexNode[adjacencyMatrix.length];
        for (int startVertex = 0; startVertex < adjacencyMatrix.length; startVertex++) {
            table[startVertex] = new VertexNode(startVertex);
        }
        // adjacencyTable set value
        for (int startVertex = 0; startVertex < adjacencyMatrix.length; startVertex++) {
            for (int endVertex = 0; endVertex < adjacencyMatrix[startVertex].length; endVertex++) {
                // 非自身 并且 startVertex 和 endVertex 之间有关联
                if (endVertex != startVertex && adjacencyMatrix[startVertex][endVertex] != U) {
                    // startVertex 和 endVertex 之间的边
                    EdgeNode edge = new EdgeNode(table[endVertex], adjacencyMatrix[startVertex][endVertex]);
                    table[startVertex].edgeNodeList.add(edge);
                }
            }
        }
        return table;
    }

    // 2、邻接表转邻接矩阵
    default int[][] AdjacencyTable2Matrix(VertexNode[] adjacencyTable) {
        if (adjacencyTable == null) {
            return null;
        }
        // init
        int[][] adjacencyMatrix = fullMatrix(adjacencyTable.length);

        // startVertex : 边的起始点
        // endVertex   : 边的结束点
        for (int startVertex = 0; startVertex < adjacencyTable.length; startVertex++) {
            List<EdgeNode> edgeList = adjacencyTable[startVertex].edgeNodeList;
            if (edgeList.size() == 0) {
                continue;
            }
            for (EdgeNode endVertex : edgeList) {
                adjacencyMatrix[startVertex][endVertex.vertexNode.nodeValue] = endVertex.edgeValue;
            }
        }
        return adjacencyMatrix;
    }

    // 3、边和节点关系数组 转 邻接矩阵
    default int[][] GraphNodeShip2AdjacencyMatrix(int[][] pointShip) {
        if (pointShip == null || pointShip.length == 0) {
            return null;
        }
        Map<Integer, Boolean> statisticsMap = new HashMap<>();
        for (int[] ints : pointShip) {
            statisticsMap.put(ints[0], true);
            statisticsMap.put(ints[1], true);
        }
        // init
        int[][] adjacencyMatrix = fullMatrix(statisticsMap.size());

        for (int[] ship : pointShip) {
            adjacencyMatrix[ship[0]][ship[1]] = ship[2];
        }
        return adjacencyMatrix;
    }

    // 4、边和节点关系数组 转 邻接表
    default VertexNode[] GraphNodeShip2AdjacencyTable(int[][] pointShip) {
        if (pointShip == null || pointShip.length == 0) {
            return null;
        }
        Arrays.sort(pointShip, (x1, x2) -> {
            return x1[0] - x2[0];
        });
        Map<Integer, Boolean> statisticsMap = new HashMap<>();
        for (int[] ints : pointShip) {
            statisticsMap.put(ints[0], true);
            statisticsMap.put(ints[1], true);
        }
        VertexNode[] table = new VertexNode[statisticsMap.size()];
        // adjacencyTable init
        for (int startVertex = 0; startVertex < statisticsMap.size(); startVertex++) {
            table[startVertex] = new VertexNode(startVertex);
        }
        for (int[] ship : pointShip) {
            if (!check(ship, pointShip)) {
                return null;
            }
            // non-self
            if (ship[0] == ship[1]) {
                continue;
            }
            table[ship[0]].edgeNodeList.add(new EdgeNode(table[ship[1]], ship[2]));
        }
        return table;
    }

    default boolean check(int[] ship, int[][] pointShip) {
        // non-Standard GraphNodeShip
        if (ship.length != 3) {
            System.out.println("Wrong pointShip:");
            ArrayTools.printIntArray(ship);
            return false;
        }
        return true;
    }

    default int[][] fullMatrix(int length) {
        int[][] adjacencyMatrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    adjacencyMatrix[i][j] = U;
                }
            }
        }
        return adjacencyMatrix;
    }
}
