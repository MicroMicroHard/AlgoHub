package DataStructure.graph.shortestPath.multiSourceShortestPath;

import DataStructure.arrayRelevant.matrix.MatrixOpsImpl;
import Common.Constant.C;
import Common.Utils.ArrayTools;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-12-25 21:11
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 弗洛伊德算法 Floyd
 * 用来求解赋权图中每对顶点间的最短距离 以及 输出任意两点之间最短路径
 * Let us create the following weighted graph
 * 10
 * (0)------->(3)
 * |         /|\
 * 5 |          |
 * |          | 1
 * \|/         |
 * (1)------->(2)
 * 3
 * @blogURL
 */

public class Floyd {

    // 每对顶点间的最短距离 矩阵
    int[][] distance;
    // 任意两点之间最短路径
    int[][] shortestPath;
    MatrixOpsImpl matrixOps = new MatrixOpsImpl();

    @Test
    public void Testjj() {
        int[][] graph = {{0, 5, C.MaxValueExpr, 10}, {C.MaxValueExpr, 0, 3, C.MaxValueExpr}, {C.MaxValueExpr, C.MaxValueExpr, 0, 1}, {C.MaxValueExpr, C.MaxValueExpr, C.MaxValueExpr, 0}};
        Floyd f = new Floyd();
        int[][] answer = f.CalDistanceMethod(graph);
        int[][] target = {{0, 5, 8, 9}, {C.MaxValueExpr, 0, 3, 4}, {C.MaxValueExpr, C.MaxValueExpr, 0, 1}, {C.MaxValueExpr, C.MaxValueExpr, C.MaxValueExpr, 0}};
        assert ArrayTools.EqualsIntMatrix(answer, target);
        List<Integer> list = f.GetShortestPath(3, 0, graph);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public int[][] CalDistanceMethod(int[][] inputMatrix) {
        if (inputMatrix == null || inputMatrix.length == 0) {
            return null;
        }

        distance = matrixOps.copy(inputMatrix);

        int n = inputMatrix.length;
        shortestPath = new int[n][n];
        // init shortestPath
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                shortestPath[i][j] = i;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (k == i) {
                    continue;
                }

                for (int j = 0; j < n; j++) {
                    if (j == i || j == k) {
                        continue;
                    }
                    if (distance[i][k] == C.MaxValueExpr || distance[k][j] == C.MaxValueExpr) {
                        continue;
                    }

                    // 更新最段距离
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        shortestPath[i][j] = shortestPath[k][j];
                    }
                }
            }
        }
        return distance;
    }

    // 获取 任意两点之间最短路径
    public List<Integer> GetShortestPath(int src, int des, int[][] inputMatrix) {
        CalDistanceMethod(inputMatrix);
        // 如果两点之间不可达
        if (distance[src][des] == C.MaxValueExpr) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        list.add(des);
        while (src != shortestPath[src][des]) {
            list.add(shortestPath[src][des]);
            des = shortestPath[src][des];
        }
        list.add(src);
        Collections.reverse(list);
        return list;
    }
}
