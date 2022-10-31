package UnitTest.DataStructureTest.arrayAndListTest.doublePointTest;

import DataStructure.arrayRelevant.doublePoint.RmSpecialElement;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/10/10
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 去除指定元素 测试用例
 */
public class RmSpecialElementTest {

    RmSpecialElement r = new RmSpecialElement();

    @Test
    public void test() {
        int[] target = r.method(demo01, 6);
        Assert.assertArrayEquals(target, ans01);
        assert r.head == position01;
        target = r.method(demo02, 6);
        Assert.assertArrayEquals(target, ans02);
        assert r.head == position02;
        target = r.method(demo03, 6);
        Assert.assertArrayEquals(target, ans03);
        assert r.head == position03;
        target = r.method(demo04, 6);
        Assert.assertArrayEquals(target, ans04);
        assert r.head == position04;
        target = r.method(demo05, 6);
        Assert.assertArrayEquals(target, ans05);
        assert r.head == position05;

    }

    int[] demo01 = {1, 2, 3, 4, 5, 6, 7, 6, 8, 69, 6, 10, 6};
    int[] ans01 = {1, 2, 3, 4, 5, 7, 8, 69, 10};
    int position01 = 9;

    int[] demo02 = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6, 7, 6, 8, 69, 6, 10, 6};
    int[] ans02 = {1, 2, 3, 4, 5, 7, 8, 69, 10};
    int position02 = 9;

    int[] demo03 = {1, 2, 3, 4, 5, 6, 7, 6, 8, 69, 6, 10, 6, 6, 6, 6, 6, 6, 6, 6, 6};
    int[] ans03 = {1, 2, 3, 4, 5, 7, 8, 69, 10};
    int position03 = 9;

    int[] demo04 = {1, 2, 6, 6, 6, 6, 6, 3, 4, 5, 6, 6, 6, 6, 6, 7, 6, 8, 69, 6, 6, 6, 6, 6, 10, 6};
    int[] ans04 = {1, 2, 3, 4, 5, 7, 8, 69, 10};
    int position04 = 9;

    int[] demo05 = {6, 6, 6, 6, 1, 2, 3, 4, 5, 6, 7, 6, 6, 6, 6, 6, 8, 69, 6, 6, 6, 6, 6, 10, 6, 6, 6, 6, 6};
    int[] ans05 = {1, 2, 3, 4, 5, 7, 8, 69, 10};
    int position05 = 9;
}
