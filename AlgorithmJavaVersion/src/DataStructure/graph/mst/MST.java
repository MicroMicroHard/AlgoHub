package DataStructure.graph.mst;

import DataStructure.graph.GraphNode;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-12-27 00:15
 * @author-Email micromicrohard@outlook.com
 * @description 最小生成树 (Minimum Spanning Tree)
 * @blogURL
 */
public interface MST extends GraphNode {

    /**
     * @param matrix 关联矩阵
     * @return 生成最小生出树
     */
    public void buildMst(int[][] matrix);
}
