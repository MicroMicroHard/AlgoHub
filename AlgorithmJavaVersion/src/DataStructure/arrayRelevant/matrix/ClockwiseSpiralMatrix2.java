package DataStructure.arrayRelevant.matrix;

import Common.Utils.MathTools;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-09 22:22
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 顺时针打印螺旋矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4*4矩阵：
 * 1   2  3  4
 * 12 13 14  5
 * 11 16 15  6
 * 10  9  8  7
 * 则依次打印出数字 1,2,3,4,5,6,7,8,9,10,11,12
 * <p>
 * 例如，如果输入如下4*4矩阵：
 * 1  2  3  4
 * 5  6  7  8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class ClockwiseSpiralMatrix2 extends ClockwiseSpiralMatrix {

    //转置法
    public int[] pointCount(int[][] matrix) {
        if (!MathTools.judgeIsRectangle(matrix)) {
            return null;
        }
        //获取矩阵的行、列、总数
        int row = matrix.length;
        int column = matrix[0].length;
        int count = row * column;
        List<Integer> list = new ArrayList<Integer>();
        int[] target = new int[row * column];

        while (count > 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                list.add(matrix[0][i]);
                count--;
            }
            matrix = Matrix_transposed(matrix);
        }
        for (int i = 0; i < list.size(); i++) {
            target[i] = list.get(i);
        }
        return target;
    }

    //转置函数：去除第一行之后，再进行矩阵转置
    public int[][] Matrix_transposed(int[][] matrix) {

        //获取矩阵的行、列
        int row = matrix.length;
        int column = matrix[0].length;
        //新建一个转置数组，行数减一
        int[][] matrix_transposed = new int[column][row - 1];
        for (int i = 1, h = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix_transposed[column - j - 1][h] = matrix[i][j];
            }
            h++;
        }
		/*
		 * 输出测试
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < row-1; j++) {
				System.out.print(matrix_transposed[i][j]+ " ");
			}
			System.out.println();
		}*/
        return matrix_transposed;
    }
}