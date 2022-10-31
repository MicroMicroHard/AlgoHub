package UnitTest.DataStructureTest.graphTest;

import DataStructure.graph.EdgeNode;
import DataStructure.graph.VertexNode;
import Common.Utils.ArrayTools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphTestData {

    public int U = Integer.MAX_VALUE;//U = Unreachable

    // 图的邻接矩阵
    public int[][] AdjacencyMatrix_demo01 = {
            {0, U, 2, 5},
            {U, 0, 7, 3},
            {2, 7, 0, 9},
            {5, 3, 9, 0}
    };
    public int[][] GraphNodeShip_demo01 = {
            {0, 2, 2},
            {0, 3, 5},
            {1, 2, 7},
            {1, 3, 3},
            {2, 0, 2},
            {2, 1, 7},
            {2, 3, 9},
            {3, 0, 5},
            {3, 1, 3},
            {3, 2, 9},
    };


    // 图的邻接表
    public VertexNode[] AdjacencyTable_demo01() {
        VertexNode[] table = new VertexNode[4];
        for (int i = 0; i < table.length; i++) {
            table[i] = new VertexNode(i);
        }
        table[0].edgeNodeList.add(new EdgeNode(table[2], 2));
        table[0].edgeNodeList.add(new EdgeNode(table[3], 5));

        table[1].edgeNodeList.add(new EdgeNode(table[2], 7));
        table[1].edgeNodeList.add(new EdgeNode(table[3], 3));

        table[2].edgeNodeList.add(new EdgeNode(table[0], 2));
        table[2].edgeNodeList.add(new EdgeNode(table[1], 7));
        table[2].edgeNodeList.add(new EdgeNode(table[3], 9));

        table[3].edgeNodeList.add(new EdgeNode(table[0], 5));
        table[3].edgeNodeList.add(new EdgeNode(table[1], 3));
        table[3].edgeNodeList.add(new EdgeNode(table[2], 9));
        return table;
    }

    // 图的邻接矩阵
    public int[][] AdjacencyMatrix_demo02 = {
            {0, 2, 5},
            {U, 0, 3},
            {2, 7, 0}
    };
    public int[][] GraphNodeShip_demo02 = {
            {0, 1, 2},
            {0, 2, 5},
            {1, 2, 3},
            {2, 0, 2},
            {2, 1, 7},
    };

    public VertexNode[] AdjacencyTable_demo02() {
        VertexNode[] table = new VertexNode[3];
        for (int i = 0; i < table.length; i++) {
            table[i] = new VertexNode(i);
        }
        table[0].edgeNodeList.add(new EdgeNode(table[1], 2));
        table[0].edgeNodeList.add(new EdgeNode(table[2], 5));

        table[1].edgeNodeList.add(new EdgeNode(table[2], 3));

        table[2].edgeNodeList.add(new EdgeNode(table[0], 2));
        table[2].edgeNodeList.add(new EdgeNode(table[1], 7));
        return table;
    }

    // 图的邻接矩阵
    public int[][] AdjacencyMatrix_demo03 = null;
    public int[][] GraphNodeShip_demo03 = null;

    public VertexNode[] AdjacencyTable_demo03() {
        return null;
    }

    // 图的邻接矩阵
    public int[][] AdjacencyMatrix_demo04 = {
            {0}
    };
    public int[][] GraphNodeShip_demo04 = {
            {0, 0, 0}
    };

    public VertexNode[] AdjacencyTable_demo04() {
        VertexNode[] table = new VertexNode[1];
        table[0] = new VertexNode(0);
        return table;
    }

    public int[][] AdjacencyMatrix_demo05 = {
            {0, 1, 2, 5},
            {1, 0, 7, U},
            {2, 7, 0, 9},
            {5, U, 9, 0}
    };
    public int[][] GraphNodeShip_demo05 = {
            {0, 1, 1},
            {0, 2, 2},
            {0, 3, 5},
            {1, 0, 1},
            {1, 2, 7},
            {2, 0, 2},
            {2, 1, 7},
            {2, 3, 9},
            {3, 0, 5},
            {3, 2, 9},
    };

    public VertexNode[] AdjacencyTable_demo05() {
        VertexNode[] table = new VertexNode[4];
        for (int i = 0; i < table.length; i++) {
            table[i] = new VertexNode(i);
        }
        table[0].edgeNodeList.add(new EdgeNode(table[1], 1));
        table[0].edgeNodeList.add(new EdgeNode(table[2], 2));
        table[0].edgeNodeList.add(new EdgeNode(table[3], 5));

        table[1].edgeNodeList.add(new EdgeNode(table[0], 1));
        table[1].edgeNodeList.add(new EdgeNode(table[2], 7));

        table[2].edgeNodeList.add(new EdgeNode(table[0], 2));
        table[2].edgeNodeList.add(new EdgeNode(table[1], 7));
        table[2].edgeNodeList.add(new EdgeNode(table[3], 9));

        table[3].edgeNodeList.add(new EdgeNode(table[0], 5));
        table[3].edgeNodeList.add(new EdgeNode(table[2], 9));
        return table;
    }

    public int[][] AdjacencyMatrix_demo06 = {
            {0, 2, 5},
            {U, 0, 3},
            {2, 7, 0}
    };

    public int[][] GraphNodeShip_demo06 = {
            {0, 1, 2},
            {0, 2, 5},
            {1, 2, 3},
            {2, 0, 2},
            {2, 1, 7},
    };

    public VertexNode[] AdjacencyTable_demo06() {
        VertexNode[] table = new VertexNode[3];
        for (int i = 0; i < table.length; i++) {
            table[i] = new VertexNode(i);
        }
        table[0].edgeNodeList.add(new EdgeNode(table[1], 2));
        table[0].edgeNodeList.add(new EdgeNode(table[2], 5));

        table[1].edgeNodeList.add(new EdgeNode(table[2], 3));

        table[2].edgeNodeList.add(new EdgeNode(table[0], 2));
        table[2].edgeNodeList.add(new EdgeNode(table[1], 7));
        return table;
    }

    public int[][] AdjacencyMatrix_demo07 = {
            {0, 2, 5, U},
            {1, 0, U, 3},
            {2, U, 0, 7},
            {U, 2, 7, 0}
    };

    public int[][] GraphNodeShip_demo07 = {
            {0, 1, 2},
            {0, 2, 5},
            {1, 0, 1},
            {1, 3, 3},
            {2, 0, 2},
            {2, 3, 7},
            {3, 1, 2},
            {3, 2, 7}
    };

    public VertexNode[] AdjacencyTable_demo07() {
        VertexNode[] table = new VertexNode[4];
        for (int i = 0; i < table.length; i++) {
            table[i] = new VertexNode(i);
        }
        table[0].edgeNodeList.add(new EdgeNode(table[1], 2));
        table[0].edgeNodeList.add(new EdgeNode(table[2], 5));

        table[1].edgeNodeList.add(new EdgeNode(table[0], 1));
        table[1].edgeNodeList.add(new EdgeNode(table[3], 3));

        table[2].edgeNodeList.add(new EdgeNode(table[0], 2));
        table[2].edgeNodeList.add(new EdgeNode(table[3], 7));

        table[3].edgeNodeList.add(new EdgeNode(table[1], 2));
        table[3].edgeNodeList.add(new EdgeNode(table[2], 7));
        return table;
    }

    // 无向图
    public int[][] AdjacencyMatrix_demo08 = {
            {0, 2, U, U, 8, 3},
            {2, 0, U, 3, U, U},
            {U, U, 0, U, 7, 1},
            {U, 3, U, 0, U, U},
            {8, U, 7, U, 0, 6},
            {3, U, 1, U, 6, 0}
    };
    public int[][] GraphNodeShip_demo08 = {
            {0, 1, 2},
            {1, 0, 2},
            {0, 4, 8},
            {4, 0, 8},
            {0, 5, 3},
            {5, 0, 3},
            {1, 3, 3},
            {3, 1, 3},
            {4, 2, 7},
            {2, 4, 7},
            {4, 5, 6},
            {5, 4, 6},
            {5, 2, 1},
            {2, 5, 1},
    };

    public VertexNode[] AdjacencyTable_demo08() {
        VertexNode[] table = new VertexNode[6];
        for (int i = 0; i < table.length; i++) {
            table[i] = new VertexNode(i);
        }
        table[0].edgeNodeList.add(new EdgeNode(table[1], 2));
        table[0].edgeNodeList.add(new EdgeNode(table[4], 8));
        table[0].edgeNodeList.add(new EdgeNode(table[5], 3));

        table[1].edgeNodeList.add(new EdgeNode(table[0], 2));
        table[1].edgeNodeList.add(new EdgeNode(table[3], 3));
        table[2].edgeNodeList.add(new EdgeNode(table[4], 7));
        table[2].edgeNodeList.add(new EdgeNode(table[5], 1));
        table[3].edgeNodeList.add(new EdgeNode(table[1], 3));

        table[4].edgeNodeList.add(new EdgeNode(table[0], 8));
        table[4].edgeNodeList.add(new EdgeNode(table[2], 7));
        table[4].edgeNodeList.add(new EdgeNode(table[5], 6));

        table[5].edgeNodeList.add(new EdgeNode(table[0], 3));
        table[5].edgeNodeList.add(new EdgeNode(table[2], 1));
        table[5].edgeNodeList.add(new EdgeNode(table[4], 6));
        return table;
    }

    public static void printAdjacencyTable(int level, List<EdgeNode> nodeList1, List<EdgeNode> nodeList2) {
        System.out.println("level: " + level + " ,nodeList1.size(): " + nodeList1.size() + " ,nodeList2.size(): " + nodeList2.size());
        System.out.println("nodeList1:");
        printAdjacencyTable(nodeList1);
        System.out.println("nodeList2:");
        printAdjacencyTable(nodeList2);
    }

    public static boolean AdjacencyTableEqual(VertexNode[] vertexArray1, VertexNode[] vertexArray2) {
        if (vertexArray1 == null && vertexArray2 == null) {
            return true;
        }
        if (vertexArray1 == null || vertexArray2 == null || vertexArray1.length != vertexArray2.length) {
            return false;
        }
        for (int i = 0; i < vertexArray1.length; i++) {
            List<EdgeNode> nodeList1 = vertexArray1[i].edgeNodeList;
            List<EdgeNode> nodeList2 = vertexArray2[i].edgeNodeList;
            if (nodeList1.size() == 0 && nodeList2.size() == 0) {
                continue;
            }
            if (nodeList1.size() != nodeList2.size()) {
                printAdjacencyTable(i, nodeList1, nodeList2);
                return false;
            }
            Map<Integer, Boolean> map = new HashMap<>();
            for (EdgeNode edgeNode : nodeList1) {
                map.put(edgeNode.vertexNode.nodeValue, true);
            }
            for (EdgeNode edgeNode : nodeList2) {
                if (map.getOrDefault(edgeNode.vertexNode.nodeValue, false)) {
                    map.remove(edgeNode.vertexNode.nodeValue);
                } else {
                    //不相等节点
                    printAdjacencyTable(i, nodeList1, nodeList2);
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean AdjacencyMatrixEqual(int[][] adjacencyMatrix1, int[][] adjacencyMatrix2) {
        return ArrayTools.EqualsIntMatrix(adjacencyMatrix1, adjacencyMatrix2);
    }

    public static void printAdjacencyTable(List<EdgeNode> nodeList) {
        if (nodeList == null || nodeList.size() == 0) {
            System.out.println("nodeList is empty");
            return;
        }
        for (EdgeNode edgeNode : nodeList) {
            System.out.print("edgeValue: " + edgeNode.edgeValue + " ,vertexNodeValue: " + edgeNode.vertexNode.nodeValue + "\n");
        }
    }
}


