package UnitTest.DataStructureTest.arrayAndListTest.arrayApplyTest;

import DataStructure.arrayRelevant.arrayApply.FirstLostPositiveNum;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-8-8 下午07:03:55
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */

public class FirstLostPositiveNumTest {

    @Test
    public void test() {
        test(new FirstLostPositiveNum());
    }

    public void test(FirstLostPositiveNum instance) {
        int answer = instance.Method(demo01);
        assert answer == target01;
        answer = instance.Method(demo02);
        assert answer == target02;
        answer = instance.Method(demo03);
        assert answer == target03;
        answer = instance.Method(demo04);
        assert answer == target04;
    }

    int[] demo01 = {1, 2, 0};
    int target01 = 3;

    int[] demo02 = {3, 4, -1, 1};
    int target02 = 2;

    int[] demo03 = {7, 8, 9, 11, 12};
    int target03 = 1;

    int[] demo04 = {};
    int target04 = 0;
}
