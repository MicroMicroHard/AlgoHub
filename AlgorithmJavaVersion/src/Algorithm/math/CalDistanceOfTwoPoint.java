package Algorithm.math;

import Common.Utils.GraphicalTools;
import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/27 01:57
 * @author-Email micromicrohard@outlook.com
 * @description 计算两点之间的距离
 * @blogURL
 */
public class CalDistanceOfTwoPoint {

    @Test // 验证功能：从数据库获取测试数据，用于单元测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误的测试案例
    public void DoubleTrack() throws Exception {
        String input = "{1,2}  ############  {2,4}";
        String output = "2.23606797749979";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    public double method(int[] point1, int[] point2) {
        GraphicalTools tools = new GraphicalTools();
        return tools.cal_distance_point2point(point1, point2);
    }
}
