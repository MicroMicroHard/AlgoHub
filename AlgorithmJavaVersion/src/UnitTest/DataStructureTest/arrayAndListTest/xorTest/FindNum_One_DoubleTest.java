package UnitTest.DataStructureTest.arrayAndListTest.xorTest;

import DataStructure.arrayRelevant.xor.FindNum_Once_Double;
import Common.Constant.C;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/9/1
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 找数字
 * 在一组数中，其他每个数都只出现一次，仅有一个数，出现了两次，找出这个数。
 */
public class FindNum_One_DoubleTest {

    FindNum_Once_Double instance = new FindNum_Once_Double();

    @Test
    public void testfindvalue() {
        int tarfindvalue = instance.Solution(array01);
        assert value01 == tarfindvalue;
        tarfindvalue = instance.Solution(array02);
        assert value02 == tarfindvalue;
        tarfindvalue = instance.Solution(array03);
        assert value03 == tarfindvalue;
        tarfindvalue = instance.Solution(array04);
        assert value04 == tarfindvalue;
        tarfindvalue = instance.Solution(array05);
        assert value05 == tarfindvalue;
        tarfindvalue = instance.Solution(array06);
        assert value06 == tarfindvalue;
        tarfindvalue = instance.Solution(array07);
        assert value07 == tarfindvalue;
    }

    int[] array01 = {};
    int value01 = C.ErrorNum;
    int[] array02 = null;
    int value02 = C.ErrorNum;
    int[] array03 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9};
    int value03 = 9;
    int[] array04 = {10000078, 20000078, 30000078, 40000078, 50000078, 60000078, 70000078, 80000078, 90000078, 100000078, 90000078};
    int value04 = 90000078;
    int[] array05 = {-10000078, -20000078, -30000078, -40000078, -50000078, -60000078, -70000078, -80000078, -90000078, -100000078, -90000078};
    int value05 = -90000078;
    int[] array06 = {-8, -3, -1, -2, -5, 0, -10, -7, -6, -4, -9, -9};
    int value06 = -9;
    int[] array07 = {2, 2, 1};
    int value07 = 2;
}
