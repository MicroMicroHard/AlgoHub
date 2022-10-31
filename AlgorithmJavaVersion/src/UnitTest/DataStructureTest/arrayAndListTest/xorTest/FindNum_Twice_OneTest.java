package UnitTest.DataStructureTest.arrayAndListTest.xorTest;

import DataStructure.arrayRelevant.xor.FindNum_Twice_One;
import Common.Constant.C;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/8/31
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 找数字 测试案例
 * 在一组数中，每个数都出现了两次，但是出现了唯独一个数，仅出现一次，找出这个数
 */
public class FindNum_Twice_OneTest {

    @Test
    public void testfindvalue() {
        test(new FindNum_Twice_One());
    }

    public void test(FindNum_Twice_One fv) {
        int tarfindvalue = fv.Solution(array01);
        assert tarfindvalue == value01;
        tarfindvalue = fv.Solution(array02);
        assert tarfindvalue == value02;
        tarfindvalue = fv.Solution(array03);
        assert tarfindvalue == value03;
        tarfindvalue = fv.Solution(array04);
        assert tarfindvalue == value04;
        tarfindvalue = fv.Solution(array05);
        assert tarfindvalue == value05;
        tarfindvalue = fv.Solution(array06);
        assert tarfindvalue == value06;
    }

    int[] array01 = {};
    int value01 = C.ErrorNum;
    int[] array02 = null;
    int value02 = C.ErrorNum;
    int[] array03 = {5, 5, 1, 2, 6, 3, 2, 6, 7, 8, 1, 4, 3, 8, 4};
    int value03 = 7;
    int[] array04 = {5, 5, 1, 2, 6, 3, 2, 6, 7, 8, 1, 4, 3, 8, 4, 5, 5, 1, 11, 2, 6, 3, 2, 6, 7, 8, 1, 4, 3, 8, 4};
    int value04 = 11;
    int[] array05 = {3879, 700, 15, 5009, 15, 455, 3, 4, 3879, 700, 222, 5, 222, 11, 455, 5009, 666, 666, 818, 818, 3, 4, 5};
    int value05 = 11;
    int[] array06 = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 90};
    int value06 = 90;
}
