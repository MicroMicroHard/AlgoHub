package UnitTest.DataStructureTest.arrayAndListTest.matrixTest;

import DataStructure.arrayRelevant.matrix.MatrixSetZero;
import Common.Utils.ArrayTools;
import org.junit.Test;

public class MatrixSetZeroTest {

    @Test
    public void testMatrixSetZero() {
        test(new MatrixSetZero());
    }

    public void test(MatrixSetZero msz) {
        int[][] answer = msz.set(demo01);
        assert ArrayTools.EqualsIntMatrix(answer, demo01_target);
        answer = msz.set(demo02);
        assert ArrayTools.EqualsIntMatrix(answer, demo02_target);
        answer = msz.set(demo03);
        assert ArrayTools.EqualsIntMatrix(answer, demo03_target);
        answer = msz.set(demo04);
        assert ArrayTools.EqualsIntMatrix(answer, demo04_target);
    }

    int[][] demo01 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    int[][] demo01_target = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};

    int[][] demo02 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
    int[][] demo02_target = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};

    int[][] demo03 = {{1}, {0}};
    int[][] demo03_target = {{0}, {0}};

    int[][] demo04 = {{0}, {1}};
    int[][] demo04_target = {{0}, {0}};
}
