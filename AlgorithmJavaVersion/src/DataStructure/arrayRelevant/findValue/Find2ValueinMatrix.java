package DataStructure.arrayRelevant.findValue;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/6/29
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 在矩阵中查找某两个值等于给定值
 */
public class Find2ValueinMatrix implements FindValue {

    int[] position = {-1, -1, -1, -1};

    
    public int[] find(int[][] matrix, int target) {

        if (check(matrix)) {
            int row = matrix.length;
            int column = matrix[0].length;
            int p1row = 0;
            int p1column = column - 1;
            int p2row = row - 1;
            int p2column = 0;

            if (matrix[p1row][p1column] + matrix[p2row][p2column] < target) {

            }

        }
        return position;
    }
}
