package DataStructure.graph;

import Common.Constant.C;
import Common.Utils.ArrayTools;
import Common.Utils.MathTools;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/6/25 11:07 AM
 * @author-Email micromicrohard@outlook.com
 * @description 阈值距离内邻居最少的城市
 * 有 n个城市，按从 0 到 n-1编号。给你一个边数组edges，
 * 其中 edges[i] = [fromi, toi, weighti]代表fromi和toi两个城市之间的双向加权边，距离阈值是一个整数distanceThreshold。
 * 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为distanceThreshold的城市。
 * 如果有多个这样的城市，则返回编号最大的城市。
 * 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
 * @blogURL https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 */
public class TheLeastNeighbors {

    @Test // 点击运行测试案例
    public void TestFunc() throws Exception {
        //UTFactory.FullTest(this.getClass());
        TheLeastNeighbors t = new TheLeastNeighbors();
        int answer = 0;

        int[][] h2 = {{0, 1, 2}, {0, 4, 8}, {1, 2, 10000}, {1, 4, 2}, {2, 3, 10000}, {3, 4, 1}};
        answer = t.Method(5, h2, 10000);
        // 预期是2


        int[][] h = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        answer = t.Method(5, h, 2);


        int[][] h1 = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        answer = t.Method(4, h1, 4);


    }

    public int Method(int n, int[][] edges, int distanceThreshold) {

        if (n <= 0) {
            return C.ErrorNum;
        }
        if (edges == null || edges.length == 0) {
            return C.ErrorNum;
        }
        // 点被截止访问
        int[] edgeNeighbors = new int[n];
        // 构造邻接矩阵
        int[][] matrix = new int[n][n];
        int[][] matrixOrigin = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.MAX_VALUE;
                // 自己到自己赋值为 不可达
                matrixOrigin[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int[] edge : edges) {
            if (edge.length <= 2) {
                return C.ErrorNum;
            }
            // 注意：无向图需要 双边赋值
            matrixOrigin[edge[0]][edge[1]] = edge[2];
            matrixOrigin[edge[1]][edge[0]] = edge[2];
            matrix[edge[0]][edge[1]] = edge[2];
            matrix[edge[1]][edge[0]] = edge[2];
        }

        // 最多循环n次，表示最大经过n个点，距离仍为最大值的两个点不可到达
        for (int i = 0; i < n; i++) {
            matrix = Multiply(matrix, matrixOrigin, distanceThreshold);
        }

        // 统计可达点
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] <= distanceThreshold) {
                    edgeNeighbors[i]++;
                }
            }
        }

        int best = edgeNeighbors[0];
        int index = 0;
        for (int i = 0; i < edgeNeighbors.length; i++) {
            if (edgeNeighbors[i] <= best) {
                index = i;
                best = edgeNeighbors[i];
            }
        }
        return index;
    }


    public int[][] Multiply(int[][] matrix_a, int[][] matrix_b, int distanceThreshold) {
        if (!MathTools.judgeIsRectangle(matrix_a) || !MathTools.judgeIsRectangle(matrix_b)) {
            return null;
        }

        //定义相乘后的矩阵
        int row = matrix_a.length;//获取矩阵的行
        int column = matrix_b[0].length;//获取矩阵的列
        // 原始矩阵需要提前copy,否则运算时被更改
        int[][] matrix_c = ArrayTools.MatrixDeepCopy(matrix_a);
        int k = matrix_b.length;//矩阵相乘的中间元素个数

        if (k != matrix_a[0].length) {
            return null;
        }
        //矩阵相乘
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                for (int h = 0; h < k; h++) {
                    // 剪枝操作 :自己到自己不参与运算,不可达不参与运算
                    if (i == j || matrix_a[i][h] == Integer.MAX_VALUE || matrix_b[h][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    int tempPath = matrix_a[i][h] + matrix_b[h][j];
                    if (distanceThreshold < tempPath) {
                        continue;
                    }
                    // 注意：原先不可达的，可以更改为可达
                    if (tempPath < matrix_c[i][j] || matrix_c[i][j] == Integer.MAX_VALUE) {
                        matrix_c[i][j] = tempPath;
                    }
                }
            }
        }
        return matrix_c;
    }
}
