package UnitTest.DataStructureTest.arrayAndListTest.preSumAndDiffArrayTest;

import DataStructure.arrayRelevant.preSumAndDiffArray.PreSumArray;
import DataStructure.arrayRelevant.preSumAndDiffArray.PreSumArrayApply;
import org.junit.Test;

import java.util.Arrays;

public class PreSumArrayTest {

    @Test
    public void testprefixSumCount() {
        test(new PreSumArray());
    }

    public void test(PreSumArray instance) {
        int answer = instance.prefixSumCount(demo01, 2, 4);
        assert sumdemo01_2_4 == answer;
        answer = instance.prefixSumCount(demo01, 5, 6);
        assert sumdemo01_5_6 == answer;
        answer = instance.prefixSumCount(demo01, 2, 8);
        assert sumdemo01_2_8 == answer;
        answer = instance.prefixSumCount(demo01, 1, 6);
        assert sumdemo01_1_6 == answer;

        answer = instance.prefixSumCount(demo03, 1, 3);
        assert answer == sumdemo03_1_3;
        answer = instance.prefixSumCount(demo03, 1, 6);
        assert answer == sumdemo03_1_6;
        answer = instance.prefixSumCount(demo03, 6, 7);
        assert answer == sumdemo03_6_7;
        answer = instance.prefixSumCount(demo03, 3, 5);
        assert answer == sumdemo03_3_5;
        answer = instance.prefixSumCount(demo03, -1, 80);
        assert answer == sumdemo03_01_80;
    }

    @Test
    public void testprefixGetOrigin() {
        testprefixGetOrigin(new PreSumArrayApply());
    }

    public void testprefixGetOrigin(PreSumArray instance) {
        int[] answer = instance.prefixGetOrigin(instance.PrefixSumArray(demo01));
        assert Arrays.equals(demo01, answer);
        answer = instance.prefixGetOrigin(instance.PrefixSumArray(demo02));
        assert Arrays.equals(demo02, answer);
        answer = instance.prefixGetOrigin(instance.PrefixSumArray(demo03));
        assert Arrays.equals(demo03, answer);
    }

    int[] demo01 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};//和为5的有：[2,3]、[5]
    int sumdemo01_2_4 = 12;
    int sumdemo01_5_6 = 13;
    int sumdemo01_2_8 = 42;
    int sumdemo01_1_6 = 27;

    //和为5的有：[2,3]、[4,1]、[4,1,0]、[0,5]、[5]、[0, 1, 2, 2]、[01, 2, 2]
    int[] demo02 = {1, 2, 3, 4, 1, 0, 5, 9, 0, 1, 2, 2};//answer = 7

    int[] demo03 = {1, 2, 3, 4, -5, 6, 7, 8, 9};// 和为5的有:[2,3]、[4, -5, 6]、[1, 2, 3, 4, -5]
    int sumdemo03_1_3 = 9;
    int sumdemo03_1_6 = 17;
    int sumdemo03_6_7 = 15;
    int sumdemo03_3_5 = 5;
    int sumdemo03_01_80 = 35;

    // [2,3]、[2,3,0]、[3,0,1,1]、[5]、[5]、[5]、[1, 1, 1, 2]、[1, 1, 2, 1]、[1, 2, 1, 1]、[2, 1, 1, 1]
    int[] demo04 = {1, 2, 3, 0, 1, 1, 8, 5, 5, 5, 1, 1, 1, 2, 1, 1, 1};//answer = 10
    int[] demo05 = {8, 9, 7, 9, 7, 9, 8, 9, 7, 8, 7};//0
    //[2, 3]、[1, 4]、[1, 4, 0]、[0, 5]、[0, 5, 0]、[0, 5, 0, 0]、[5]、[5, 0]、[5, 0, 0]、[5]
    int[] demo06 = {2, 3, 1, 4, 0, 5, 0, 0, 8, 1, 2, 1, 3, 4, 5};//answer = 10
    // [5]、[5, -5, 2, 3]、[5, -5, 2, 3, 2, -2]、[2, 3]、[2, 3, 2, -2]、[3, 2]
    int[] demo07 = {5, -5, 2, 3, 2, -2};//answer = 6
    int[] demo08 = {5};//answer = 1
    int[] demo081 = {5, 2, 3};//answer = 2:[5]、[2,3]
    // 求和为0的连续数组 [2, -2]、[2, -2, 0]、[2, -2, 0, 1, -1]、[2, -2, 0, 1, -1, 5, -2, -3]、
    //[0]、[0, 1, -1]、[0, 1, -1, 5, -2, -3]、[1, -1]、[1, -1, 5, -2, -3]、[5, -2, -3]
    int[] demo09 = {2, -2, 0, 1, -1, 5, -2, -3};//answer = 10
}
