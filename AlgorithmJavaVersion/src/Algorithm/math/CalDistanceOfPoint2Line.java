package Algorithm.math;

import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/27 01:22
 * @author-Email micromicrohard@outlook.com
 * @description 计算点到直线的距离
 * @blogURL
 */
public class CalDistanceOfPoint2Line {

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

    public double calMethod(int[] pointPosition, int[][] linePosition) {
        if (pointPosition == null || pointPosition.length != 2) {
            return 0;
        }
        CheckMatrixConstitute tools = new CheckMatrixConstitute();
        if (!tools.checkMethod(linePosition)) {
            return 0;
        }

        return 0;
    }
}
