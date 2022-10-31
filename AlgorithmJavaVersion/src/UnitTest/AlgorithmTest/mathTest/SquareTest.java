package UnitTest.AlgorithmTest.mathTest;

import Algorithm.math.Square;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/1/6
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 求平方根 测试案例
 */
public class SquareTest {

    Square square = new Square();

    @Test
    public void test() {
        double taregt = square.cal(demo01, accuracy01);
        assert taregt == answer01;
        taregt = square.cal(demo02, accuracy02);
        assert taregt == answer02;
        taregt = square.cal(demo03, accuracy03);
        assert taregt == answer03;
        taregt = square.cal(demo04, accuracy04);
        assert taregt == answer04;
        taregt = square.cal(demo05, accuracy05);
        assert taregt == answer05;
        taregt = square.cal(demo06, accuracy06);
        assert taregt == answer06;
        taregt = square.cal(demo07, accuracy07);
        assert taregt == answer07;

    }

    double demo01 = 9;
    int accuracy01 = 3;
    double answer01 = 3.000;

    double demo02 = 99;
    int accuracy02 = 4;
    double answer02 = 9.9498;

    double demo03 = 100;
    int accuracy03 = 9;
    double answer03 = 10.0;

    double demo04 = 101;
    int accuracy04 = 7;
    double answer04 = 10.0498756;

    double demo05 = 10000;
    int accuracy05 = 7;
    double answer05 = 100.0;

    /*double demo06 = 87698;
    int accuracy06 = 9;
    double answer06 = 296.138481119;*/
    double demo06 = 123;
    int accuracy06 = 8;
    double answer06 = 11.09053650;

    double demo07 = 26;
    int accuracy07 = 7;
    double answer07 = 5.0990195;
}
