package UnitTest.DataStructureTest.arrayAndListTest.matrixTest;

import DataStructure.arrayRelevant.matrix.Matrix_Reversal;
import Common.Utils.ArrayTools;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-7-19 下午03:07:41
 * @author—Email micromicrohard@outlook.com
 * @description 矩阵顺时针反转 测试案例
 */

public class Matrix_ReversalTest {

    @Test
    public void testMatrix_Reversal() {
        test(new Matrix_Reversal());
    }

    public void test(Matrix_Reversal mr) {
        int[][] answer = mr.MatrixReversal(demo01);
        assert ArrayTools.EqualsIntMatrix(answer, demo01_target);
    }

    int[][] demo01 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };
    int[][] demo01_target = {
            {13, 9, 5, 1},
            {14, 10, 6, 2},
            {15, 11, 7, 3},
            {16, 12, 8, 4}
    };
}
