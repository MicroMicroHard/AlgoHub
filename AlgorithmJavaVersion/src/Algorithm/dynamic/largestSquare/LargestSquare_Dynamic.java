package Algorithm.dynamic.largestSquare;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/6/3
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 动态规划法
 */
public class LargestSquare_Dynamic implements LargestSquare {

    
    public int Solution(int[][] Matrix) {
        if (check(Matrix)) {
            int MaxSideLength = 0;
            //状态矩阵
            int raw_bound = Matrix.length;
            int column_bound = Matrix[0].length;
            int[][] statusMatrix = new int[raw_bound + 1][column_bound + 1];

            for (int i = 1; i <= raw_bound; i++) {
                for (int j = 1; j <= column_bound; j++) {
                    if (Matrix[i - 1][j - 1] == 1) {
                        statusMatrix[i][j] = Math.min(Math.min(statusMatrix[i - 1][j - 1], statusMatrix[i - 1][j]),
                                statusMatrix[i][j - 1]) + Matrix[i - 1][j - 1];//Matrix[i - 1][j - 1] 就是 1
                        MaxSideLength = Math.max(MaxSideLength, statusMatrix[i][j]);
                    }
                }
            }
            return MaxSideLength * MaxSideLength;
        }
        return -1;
    }
}
