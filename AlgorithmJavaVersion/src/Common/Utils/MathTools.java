package Common.Utils;

import java.util.Arrays;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/10 16:47
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 数学相关的检查函数
 * 数组中的最小值：{@link MathTools#GetMostValue}
 * 检测matrix 是否为空矩阵 {@link MathTools#judgeIsNull}
 * 检测matrix 是否为正方形 {@link MathTools#judgeIsSquare}
 * 检测matrix 是否为长方形 {@link MathTools#judgeIsRectangle}
 * 检测matrix 是否为三角形 {@link MathTools#judgeIsTriangle}
 * <p>
 * 计算两点之间的距离 {@link MathTools#judgeIsTriangle}
 * @blogURL
 */
public class MathTools {

    // 检测matrix 是否为空矩阵
    public static boolean judgeIsNull(int[][] matrix) {
        return matrix == null || matrix.length == 0 || matrix[0].length == 0;
    }

    // 检测matrix 是否为正方形
    public static boolean judgeIsSquare(int[][] matrix) {

        if (judgeIsNull(matrix)) {
            return false;
        }
        //检查矩阵是否为正方形
        int matrixLength = matrix.length;
        long p = Arrays.stream(matrix).filter(x -> x.length == matrixLength).count();
        return matrixLength == p;
    }

    // 检测matrix 是否为长方形
    public static boolean judgeIsRectangle(int[][] matrix) {
        if (judgeIsNull(matrix)) {
            return false;
        }
        //检查矩阵是否为长方形
        int length = matrix[0].length;
        long p = Arrays.stream(matrix).filter(x -> x.length == length).count();
        return matrix.length == p;
    }

    // 检测matrix 是否为三角形
    public static boolean judgeIsTriangle(int[][] matrix) {
        if (judgeIsNull(matrix)) {
            return false;
        }
        //检查数组是否为三角形
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != i + 1) {
                return false;
            }
        }
        return true;
    }

    public static int GetMostValue(boolean isMinValue, int... value) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int j : value) {
            min = Math.min(min, j);
            max = Math.max(max, j);
        }
        return isMinValue ? min : max;
    }
}
