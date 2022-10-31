package DataStructure.graph.graphConnect;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-9-10 下午12:23:06
 * @author—Email micromicrohard@outlook.com
 * @description 判断名流问题
 * 给你输入一个大小为n x n的二维数组（邻接矩阵）graph表示一幅有n个节点的图，每个人都是图中的一个节点，编号为0到n - 1。
 * 如果graph[i][j] == 1代表第i个人认识第j个人，如果graph[i][j] == 0代表第i个人不认识第j个人
 * 如果存在，算法返回这个名人的编号，如果不存在，算法返回 -1。
 * 输入：二维矩阵 节点为 0 或者 1
 * 输出：节点编号 i
 * 给你n个人的社交关系（你知道任意两个人之间是否认识），然后请你找出这些人中的「名人」。
 * 所谓「名人」有两个条件：
 * 1、所有其他人都认识「名人」。
 * 2、「名人」不认识任何其他人。
 * @blogURL https://mp.weixin.qq.com/s?__biz=MzI2NjA3NTc4Ng==&mid=2652091734&idx=2&sn=f5f00d72ca9f11758ca1fdf6f7f46ef3&chksm=f174beb3c60337a5b407483bb31605266e5352f564092383f565288ed3244c8abc48f224513d&mpshare=1&scene=1&srcid=1224GbNuZ52IbStuxq3b4J8u&sharer_sharetime=1640410592297&sharer_shareid=cdda06ad5032af8222ba84df7d2a14e4&version=3.1.23.90391&platform=mac#rd
 */

public class SearchTheCelebritiesOps extends SearchTheCelebrities {

    // todo

    public int search(int[][] matrix) {
        int n = matrix.length;
        // 先假设 cand 是名人
        int cand = 0;
        for (int other = 1; other < n; other++) {
            if (matrix[other][cand] == 0 || matrix[cand][other] == 1) {
                // cand 不可能是名人，排除
                // 假设 other 是名人
                cand = other;
            } else {
                // other 不可能是名人，排除
                // 什么都不用做，继续假设 cand 是名人
            }
        }

        // 现在的 cand 是排除的最后结果，但不能保证一定是名人
        for (int other = 0; other < n; other++) {
            if (cand == other) continue;
            // 需要保证其他人都认识 cand，且 cand 不认识任何其他人
            if (matrix[other][cand] == 0 || matrix[cand][other] == 1) {
                return -1;
            }
        }

        return cand;
    }
}
