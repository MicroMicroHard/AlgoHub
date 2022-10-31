package DataStructure.graph.shortestPath.singleSourceShortestPath;

import Common.Utils.MathTools;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-12-25 21:11
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 迪杰斯特拉算法 Dijkstra
 * 输入：一幅图和一个起点 start，
 * 输出：计算 start 到其他节点的最短距离
 * <p>
 * 迪杰斯特拉(Dijkstra)算法是典型最短路径算法，用于计算一个节点到其他节点的最短路径，
 * 它的主要特点是以起始点为中心向外层层扩展(广度优先搜索思想)，直到扩展到终点为止。
 * @blogURL
 */

public class Dijkstra {

    public int[] getShortestPath(int startPoint, int[][] matrix) {
        if (!MathTools.judgeIsSquare(matrix)) {
            return null;
        }
        int length = matrix.length;
        Node4Dijkstra[] table = new Node4Dijkstra[length];

        //initial
        for (int i = 0; i < length; i++) {
            table[i] = new Node4Dijkstra(matrix[startPoint][i]);
        }
        table[startPoint].key = 0;
        table[startPoint].visit = true;

        for (int i = 1; i < length; i++) {
            int minvalue = Integer.MAX_VALUE;
            int curNode = 0;

            //find the min path
            for (int j = 0; j < length; j++) {
                if (!table[j].visit && table[j].key < minvalue) {
                    minvalue = table[j].key;
                    curNode = j;
                }
            }
            //fail to find min path,then break
            if (minvalue == Integer.MAX_VALUE) {
                break;
            }
            table[curNode].visit = true;
            table[curNode].key = minvalue;

            //update the table
            for (int j = 0; j < length; j++) {
                if (!table[j].visit && matrix[curNode][j] != Integer.MAX_VALUE &&
                        table[j].key > matrix[curNode][j] + minvalue) {
                    table[j].key = matrix[curNode][j] + minvalue;
                }
            }
        }
        return toArray(table);
    }

    public int[] toArray(Node4Dijkstra[] dijkstraArray) {
        if (dijkstraArray == null || dijkstraArray.length == 0) {
            return new int[]{};
        }
        int[] answer = new int[dijkstraArray.length];
        for (int i = 0; i < dijkstraArray.length; i++) {
            answer[i] = dijkstraArray[i].key;
        }
        return answer;
    }
}
