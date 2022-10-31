package UnitTest.DataStructureTest.stringANDlineTest.slidingWindowTest;

import DataStructure.stringOps.slidingWindow.FindAllAnagrams;
import UnitTest.DataStructureTest.stringANDlineTest.StringData;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/6/23
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 测试用例 ： 找所有字母异位词
 * 输入一个串S，一个串T，找到S中所有T的排列，返回它们的起始索引
 */
public class FindAllAnagramsTest extends StringData {

    @Test
    public void test() {
        testprint(new FindAllAnagrams());
    }

    public void testprint(FindAllAnagrams f) {
        int[] a = f.print(source01, pattern01);
        assert Arrays.equals(a, answer01);
        a = f.print(source02, pattern02);
        assert Arrays.equals(a, answer01);
        a = f.print(source03, pattern345);
        assert Arrays.equals(a, answer01);
        a = f.print(source04, pattern345);
        assert Arrays.equals(a, answer01);
        a = f.print(source05, pattern345);
        assert Arrays.equals(a, answer01);

        a = f.print(source06, pattern678);
        assert Arrays.equals(a, answer01);
        a = f.print(source07, pattern678);
        assert Arrays.equals(a, answer01);
        a = f.print(source08, pattern678);
        assert Arrays.equals(a, answer01);
        a = f.print(source09, pattern09);
        assert Arrays.equals(a, answer01);
        a = f.print(source10, pattern10);
        assert Arrays.equals(a, answer01);

        a = f.print(source11, pattern11);
        assert Arrays.equals(a, answer11);
        a = f.print(source12, pattern12);
        assert Arrays.equals(a, answer12);
        a = f.print(source13, pattern13);
        assert Arrays.equals(a, answer13);

        a = f.print(source14, pattern14);
        assert Arrays.equals(a, answer14);
        a = f.print(source15, pattern15);
        assert Arrays.equals(a, answer15);
    }

    int[] answer01 = {};
    int[] answer11 = {14};
    int[] answer12 = {28};
    int[] answer13 = {31};
    int[] answer14 = {6, 20, 30, 40, 50, 60};
    int[] answer15 = {0, 10, 20, 30, 40};

}
