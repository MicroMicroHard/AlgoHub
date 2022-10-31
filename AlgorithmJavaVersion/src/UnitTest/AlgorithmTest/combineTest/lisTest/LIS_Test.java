package UnitTest.AlgorithmTest.combineTest.lisTest;

import Algorithm.comprehensive.lis.LIS;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/6/7
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 最长递增子序列 测试案例
 */
public class LIS_Test {

    public void TestDemo(LIS LISImpl) {
        int result = LISImpl.Method(demo01);
        assert result == 9;
        result = LISImpl.Method(demo02);
        assert result == 0;
        result = LISImpl.Method(demo03);
        assert result == 0;
        result = LISImpl.Method(demo04);
        assert result == 5;
        result = LISImpl.Method(demo05);
        assert result == 9;
        result = LISImpl.Method(demo06);
        assert result == 5;
        result = LISImpl.Method(demo07);
        assert result == 4;
        result = LISImpl.Method(demo08);
        assert result == 1;
        result = LISImpl.Method(demo09);
        assert result == 1;
        result = LISImpl.Method(demo10);
        assert result == 9;
        result = LISImpl.Method(demo11);
        assert result == 1;
        result = LISImpl.Method(demo12);
        assert result == 4;
    }

    // 最长递增子序列 测试数据
    public String demo01 = "1528334656789123456";//123456789
    public String demo02 = "";
    public String demo03 = null;
    public String demo04 = "18386873921";     //13679
    public String demo05 = "1234567823456789";//123456789
    public String demo06 = "13572468";        //12468
    public String demo07 = "24681357";        //2468
    public String demo08 = "987654321";       //1
    public String demo09 = "1";               //1
    public String demo10 = "12834615526431378242287536564437529688";//123456789
    public String demo11 = "777777777777";    //1
    public String demo12 = "010323";          //4

}
