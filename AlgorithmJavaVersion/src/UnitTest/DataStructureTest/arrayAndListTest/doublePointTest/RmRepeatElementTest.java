package UnitTest.DataStructureTest.arrayAndListTest.doublePointTest;

import DataStructure.arrayRelevant.doublePoint.RmRepeatElement;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/10/10
 * @author-Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 给定一个包含重复数字的数组，返回不重复的个数
 * 找出重复数组中仅出现一次的数，并排序
 */
public class RmRepeatElementTest {

    RmRepeatElement rre = new RmRepeatElement();

    @Test
    public void testmethod() {
        int target = rre.getHandledArrLen(demo01);
        assert target == ans01;
        target = rre.getHandledArrLen(demo02);
        assert target == ans02;
        target = rre.getHandledArrLen(demo031);
        assert target == ans031;
        target = rre.getHandledArrLen(demo03);
        assert target == ans03;
        target = rre.getHandledArrLen(demo04);
        assert target == ans04;
        target = rre.getHandledArrLen(demo05);
        assert target == ans05;

        int[] target1 = rre.getHandledArr(demo06);
        Assert.assertArrayEquals(target1, ans06);
        target1 = rre.getHandledArr(demo07);
        Assert.assertArrayEquals(target1, ans07);
    }

    int[] demo01 = {};
    int ans01 = 0;
    int[] demo02 = null;
    int ans02 = 0;
    int[] demo031 = {1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
    int ans031 = 9;
    int[] demo03 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int ans03 = 9;
    int[] demo04 = {1, 2, 3, 4, 6, 7, 3, 4, 5, 6, 5, 6, 7, 6, 7, 3, 6, 7, 3, 4, 5, 6, 4, 5, 6, 3, 4, 5, 6, 7, 8, 9};
    int ans04 = 9;
    int[] demo05 = {1, 12, 13, 14, 15, 26, 41, 0, 52, 63, 64, 65, 76, 77, 78, 89, 27, 28, 39, 11, 65, 76, 77, 63, 64, 65, 76, 77, 65, 76, 77, 78, 89, 27, 28, 39, 11, 78, 89, 27, 28, 39, 11, 2, 3, 78, 89, 27, 28, 39, 11, 2, 3, 4, 5, 6, 7, 8, 9};
    int ans05 = 28;

    int[] demo06 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] ans06 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] demo07 = {13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 14, 15, 16, 17, 18, 19, 21, 13, 14, 17, 18, 19, 21, 13, 14, 15, 16, 17, 18, 19, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 27, 28, 29};
    int[] ans07 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 27, 28, 29};
}
