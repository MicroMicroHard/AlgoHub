package DataStructure.arrayRelevant.matrix;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-7-19 下午03:07:41
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 矩阵的操作
 */
public interface MatrixOps {

    // 矩阵相乘
    int[][] MultiplyMethod(int[][] a, int[][] b);

    // 矩阵复制
    int[][] copy(int[][] a);

    // 矩阵打印
    void print(int[][] matrix);
}
