package DataStructure.arrayRelevant.matrix;

import Top100.Reversal;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-7-19 下午03:07:41
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 矩阵顺时针反转
 * @blogURL https://leetcode-cn.com/problems/rotate-image/
 */

public class Matrix_Reversal implements Reversal {

    public int[][] MatrixReversal(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            return null;
        }
        //首先对矩阵进行反转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 再对矩阵每一行进行反转
        for (int[] array : matrix) {
            int head = 0;
            int tail = matrix[0].length - 1;
            while (head < tail) {
                int temp = array[head];
                array[head] = array[tail];
                array[tail] = temp;
                head++;
                tail--;
            }
        }
        return matrix;
    }
}
