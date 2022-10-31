package Algorithm.math;

import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/27 01:24
 * @author-Email micromicrohard@outlook.com
 * @description 检查四个点是否构成矩阵
 * @blogURL
 */
public class CheckMatrixConstitute {

    @Test // 验证功能：从数据库获取测试数据，用于单元测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误的测试案例
    public void DoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    public boolean checkMethod(int[][] matrixPoint) {
        if (matrixPoint == null || matrixPoint.length != 4) {
            return false;
        }
        for (int[] ints : matrixPoint) {
            if (ints.length != 2) {
                return false;
            }
        }
        return false;
    }
}
