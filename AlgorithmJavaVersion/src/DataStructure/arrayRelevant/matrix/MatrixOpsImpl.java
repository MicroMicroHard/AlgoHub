package DataStructure.arrayRelevant.matrix;

import Common.Utils.MathTools;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-7-19 下午03:07:41
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 矩阵相乘
 */
public class MatrixOpsImpl implements MatrixOps {

    public int[][] MultiplyMethod(int[][] matrix_a, int[][] matrix_b) {
        if (!MathTools.judgeIsRectangle(matrix_a) || !MathTools.judgeIsRectangle(matrix_b)) {
            return null;
        }

        //定义相乘后的矩阵
        int row = matrix_a.length;//获取矩阵的行
        int column = matrix_b[0].length;//获取矩阵的列
        int[][] matrix_c = new int[row][column];
        int k = matrix_b.length;//矩阵相乘的中间元素个数

        if (k != matrix_a[0].length) {
            return null;
        }
        //矩阵相乘
        //首先循环A矩阵的行,时间复杂度：O(matrix_a.length)
        for (int i = 0; i < row; i++) {
            //再循环B矩阵的列,时间复杂度：O(matrix_b[0].length)
            for (int j = 0; j < column; j++) {
                //A矩阵的行元素和B矩阵列元素逐个相乘,
                //注意matrix_b.length=matrix_a[0].length != matrix_c的任何值
                for (int h = 0; h < k; h++) {
                    matrix_c[i][j] += matrix_a[i][h] * matrix_b[h][j];
                }
            }
        }
        return matrix_c;
    }

    
    public int[][] copy(int[][] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        int[][] b = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            System.arraycopy(a[i], 0, b[i], 0, a[i].length);
        }
        return b;
    }

    public void print(int[][] matrix_c) {
        int row = matrix_c.length;//获取矩阵的行
        int column = matrix_c[0].length;//获取矩阵的列
        //打印输出c矩阵
        for (int[] ints : matrix_c) {
            for (int j = 0; j < column; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

}