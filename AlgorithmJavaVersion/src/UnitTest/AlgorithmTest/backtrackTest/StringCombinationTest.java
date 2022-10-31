package UnitTest.AlgorithmTest.backtrackTest;

import Algorithm.backtrack.StringCombination;
import Algorithm.backtrack.StringCombination_2;
import Common.Utils.ArrayTools;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/6/29
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 字符串全排列 测试案例
 */
public class StringCombinationTest {

    @Test
    public void testStringCombination() {
        test(new StringCombination());
    }

    @Test
    public void testStringCombination_2() {
        test(new StringCombination_2());
    }

    public void test(StringCombination instance) {
        String[] answer = instance.Permutation(demo01);
        assert Arrays.equals(answer, target01);
        answer = instance.Permutation(demo02);
        assert Arrays.equals(answer, target02);

        answer = instance.Permutation(demo03);
        Arrays.sort(answer);
        Arrays.sort(target03);
        assert ArrayTools.EqualsStringArray(answer, target03);

        answer = instance.Permutation(demo04);
        Arrays.sort(answer);
        Arrays.sort(target04);
        assert ArrayTools.EqualsStringArray(answer, target04);

        answer = instance.Permutation(demo05);
        Arrays.sort(answer);
        Arrays.sort(target05);
        assert ArrayTools.EqualsStringArray(answer, target05);

        answer = instance.Permutation(demo06);
        Arrays.sort(answer);
        Arrays.sort(target06);
        assert ArrayTools.EqualsStringArray(answer, target06);

        answer = instance.Permutation(demo07);
        Arrays.sort(answer);
        Arrays.sort(target07);
        assert ArrayTools.EqualsStringArray(answer, target07);
    }

    String demo01 = "";
    String[] target01 = {};
    String demo02 = null;
    String[] target02 = {};
    String demo03 = "abcd";
    String[] target03 = {
            "abcd", "abdc", "acdb", "acbd", "adcb", "adbc",
            "bcad", "bcda", "bdac", "bdca", "bacd", "badc",
            "cadb", "cabd", "cdab", "cdba", "cbda", "cbad",
            "dacb", "dabc", "dcba", "dcab", "dbca", "dbac"};
    String demo06 = "dcab";
    String[] target06 = {
            "abcd", "abdc", "acdb", "acbd", "adcb", "adbc",
            "bcad", "bcda", "bdac", "bdca", "bacd", "badc",
            "cadb", "cabd", "cdab", "cdba", "cbda", "cbad",
            "dacb", "dabc", "dcba", "dcab", "dbca", "dbac"};
    String demo04 = "1234";
    String[] target04 = {
            "1234", "1243", "1324", "1342", "1423", "1432",
            "2143", "2134", "2314", "2341", "2413", "2431",
            "3124", "3142", "3421", "3412", "3214", "3241",
            "4321", "4312", "4231", "4213", "4123", "4132"};
    String demo05 = "2314";
    String[] target05 = {
            "1234", "1243", "1324", "1342", "1423", "1432",
            "2143", "2134", "2314", "2341", "2413", "2431",
            "3124", "3142", "3421", "3412", "3214", "3241",
            "4321", "4312", "4231", "4213", "4123", "4132"};
    String demo07 = "liu";
    String[] target07 = {"liu", "lui", "iul", "ilu", "uil", "uli",};
}
