package UnitTest.DataStructureTest.arrayAndListTest.xorTest;

import DataStructure.arrayRelevant.xor.FindNum_Treble_One;
import Common.Constant.C;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/8/31
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 找数字 测试案例
 * 数组中只出现一次的数字，其他出现3次
 */
public class FindNum_Treble_OneTest {

    FindNum_Treble_One instance = new FindNum_Treble_One();

    @Test
    public void testfindvalue() {
        int tarfindvalue = instance.Solution(array01);
        assert tarfindvalue == value01;
        tarfindvalue = instance.Solution(array02);
        assert tarfindvalue == value02;
        tarfindvalue = instance.Solution(array03);
        assert tarfindvalue == value03;
        tarfindvalue = instance.Solution(array04);
        assert tarfindvalue == value04;
        tarfindvalue = instance.Solution(array05);
        assert tarfindvalue == value05;
    }

    int[] array01 = {};
    int value01 = C.ErrorNum;
    int[] array02 = null;
    int value02 = C.ErrorNum;
    int[] array03 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int value03 = 10;
    int[] array04 = {10, 1, 2, 6, 5, 6, 1, 7, 3, 4, 5, 7, 9, 4, 5, 6, 1, 8, 9, 9, 8, 2, 3, 4, 2, 3, 7, 8};
    int value04 = 10;
    int[] array05 = {4567, 2456, 100001, 1234, 4567, 2456, 9605, 2038, 10086, 7329, 100001, 1234, 2038, 7329, 3918, 1234, 3918, 100001, 9605, 2038, 4567, 2456, 9605, 7329, 3918};
    int value05 = 10086;
}
