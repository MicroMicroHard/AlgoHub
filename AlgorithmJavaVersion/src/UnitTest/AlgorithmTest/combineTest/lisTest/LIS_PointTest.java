package UnitTest.AlgorithmTest.combineTest.lisTest;

import Algorithm.comprehensive.lis.LIS;
import Algorithm.comprehensive.lis.LIS_Point;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/12/31
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 最长递增子序列 双指针 测试案例
 */
public class LIS_PointTest extends LIS_Test {

    LIS lis = new LIS_Point();

    @Test
    public void testLIS_333(){
        super.TestDemo(new LIS_Point());
    }

    @Test
    public void testLIS_Point() {
        int length = lis.Method(demo01);
        assert length == 8;
        length = lis.Method(demo02);
        assert length == 6;
        length = lis.Method(demo03);
        assert length == 4;
        length = lis.Method(demo04);
        assert length == 0;
        length = lis.Method(demo05);
        assert length == 8;
    }

    String demo01 = "8765123456786543";
    String demo02 = "8765456789234";
    String demo03 = "17891";
    String demo04 = "";
    String demo05 = "123456234567891234567";

}
