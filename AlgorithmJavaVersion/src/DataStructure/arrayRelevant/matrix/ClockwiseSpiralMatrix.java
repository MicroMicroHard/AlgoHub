package DataStructure.arrayRelevant.matrix;

import Common.Utils.MathTools;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-09 22:22
 * @author—Email micromicrohard@outlook.com
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
public class ClockwiseSpiralMatrix {

    //点位计算法
    public int[] pointCount(int[][] matrix) {
        if (!MathTools.judgeIsRectangle(matrix)) {
            return null;
        }
        //List list = new LinkedList();
        //左上角(a, b),右下角(c, d)
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        int[] target = new int[(c + 1) * (d + 1)];
        int index = 0;

        while (a <= c && b <= d) {
            //最外层一圈打印
            //特殊情况：单独行、单独列
            if (a == c) {
                for (int i = b; i <= d; i++) {
                    target[index++] = matrix[a][i];
                    //list.add(matrix[a][i]);
                }
            } else if (b == d) {
                for (int i = a; i <= c; i++) {
                    target[index++] = matrix[i][b];
                    //list.add(matrix[i][b]);
                }
            } else {
                //四个循环，分别是从左到右，从上到下，到右到左，从下到上
                for (int i = b; i < d; i++) {
                    target[index++] = matrix[a][i];
                    //list.add(matrix[a][i]);
                }
                for (int i = a; i < c; i++) {
                    target[index++] = matrix[i][d];
                    //list.add(matrix[i][d]);
                }
                for (int i = d; i > b; i--) {
                    target[index++] = matrix[c][i];
                    //list.add(matrix[c][i]);
                }
                for (int i = c; i > a; i--) {
                    target[index++] = matrix[i][b];
                    //list.add(matrix[i][b]);
                }
            }
            //缩小一层
            a++;
            b++;
            c--;
            d--;
        }
        /*for (int i = 0; i < list.size(); i++) {
            target[i] = list.get(i);
        }*/
        //target = list.toArray(new int[0]);
        return target;
    }
}