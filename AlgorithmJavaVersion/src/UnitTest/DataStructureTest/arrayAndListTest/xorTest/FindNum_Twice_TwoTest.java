package UnitTest.DataStructureTest.arrayAndListTest.xorTest;

import DataStructure.arrayRelevant.xor.FindNum_Twice_Two;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/8/31
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 找数字 测试案例
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 */
public class FindNum_Twice_TwoTest {

    @Test
    public void testget() {
        test(new FindNum_Twice_Two());
    }

    public void test(FindNum_Twice_Two instance) {
        int[] answer = instance.Solution(array01);
        Assert.assertArrayEquals(answer, target01);
        answer = instance.Solution(array02);
        Assert.assertArrayEquals(answer, target02);
        answer = instance.Solution(array03);
        Assert.assertArrayEquals(answer, target03);
        answer = instance.Solution(array04);
        Assert.assertArrayEquals(answer, target04);
        answer = instance.Solution(array05);
        Assert.assertArrayEquals(answer, target05);
        answer = instance.Solution(array06);
        Assert.assertArrayEquals(answer, target06);
        answer = instance.Solution(array07);
        Assert.assertArrayEquals(answer, target07);
        answer = instance.Solution(array08);
        Assert.assertArrayEquals(answer, target08);
        answer = instance.Solution(array09);
        Assert.assertArrayEquals(answer, target09);

        answer = instance.Solution(array10);
        Assert.assertArrayEquals(answer, target10);
        answer = instance.Solution(array11);
        Assert.assertArrayEquals(answer, target11);
        answer = instance.Solution(array12);
        Assert.assertArrayEquals(answer, target12);
    }

    int[] array01 = {};
    int[] target01 = {};
    int[] array02 = null;
    int[] target02 = {};
    int[] array03 = {5, 5, 1, 2, 6, 9, 3, 2, 6, 7, 8, 1, 4, 3, 8, 4};
    int[] target03 = {7, 9};

    int[] array04 = {5, 5, 1, 2, 6, 3, 2, 6, 7, 8, 17, 1, 4, 3, 8, 4, 5, 5, 1, 11, 2, 6, 3, 2, 6, 7, 8, 1, 4, 3, 8, 4};
    int[] target04 = {11, 17};
    int[] array05 = {3879, 700, 15, 5009, 13, 15, 455, 3, 4, 3879, 700, 222, 5, 222, 11, 455, 5009, 666, 666, 818, 818, 3, 4, 5};
    int[] target05 = {11, 13};

    int[] array06 = {11, 12, 13, 14, 14, 15, 16, 17, 18, 19, 20, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 90};
    int[] target06 = {14, 90};
    int[] array07 = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 90};
    int[] target07 = {};
    int[] array08 = {5, 5, 1, 2, 6, 9, 3, 2, 6, -45678, 8, 1, 4, 3, 8, 4};
    int[] target08 = {-45678, 9};
    int[] array09 = {1, 2, 1, 3, 2, 5};
    int[] target09 = {3, 5};

    int[] array10 = {2, 2, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, 7, 15, 15};
    int[] target10 = {5, 7};

    int[] array11 = {2, 2, 5, Integer.MIN_VALUE, Integer.MIN_VALUE, 7, 15, 15};
    int[] target11 = {5, 7};

    int[] array12 = {2, 2, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, 7, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 15};
    int[] target12 = {5, 7};
}
