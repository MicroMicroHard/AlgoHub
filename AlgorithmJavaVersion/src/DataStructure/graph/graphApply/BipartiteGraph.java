package DataStructure.graph.graphApply;

import DataStructure.graph.EdgeNode;
import DataStructure.graph.VertexNode;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-12-25 21:08
 * @author—Email micromicrohard@outlook.com
 * @description 二分图
 * 给你一幅「图」，请你用两种颜色将图中的所有顶点着色，且使得任意一条边的两个端点的颜色都不相同
 * @blogURL https://mp.weixin.qq.com/s/b1WM7hMNik75E-f_2T7QEw
 */

public class BipartiteGraph {

    public boolean isBipartite(VertexNode[] adjacencyTable) {
        // 一个节点也可以作为二分图
        if (adjacencyTable == null || adjacencyTable.length <= 1) {
            return true;
        }
        boolean[] visit = new boolean[adjacencyTable.length];
        boolean[] color = new boolean[adjacencyTable.length];

        for (VertexNode node : adjacencyTable) {
            visit[node.nodeValue] = true;
            for (EdgeNode edge : node.edgeNodeList) {
                if (!visit[edge.vertexNode.nodeValue]) {
                    visit[edge.vertexNode.nodeValue] = true;
                    color[edge.vertexNode.nodeValue] = !color[node.nodeValue];
                } else if (color[edge.vertexNode.nodeValue] == color[node.nodeValue]) {
                    return false;
                }
            }
        }
        return true;
    }

}
