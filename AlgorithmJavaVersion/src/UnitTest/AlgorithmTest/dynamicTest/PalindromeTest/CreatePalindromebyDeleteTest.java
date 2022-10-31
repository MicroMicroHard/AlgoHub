package UnitTest.AlgorithmTest.dynamicTest.PalindromeTest;

import Algorithm.dynamic.palindrome1.CreatePalindromebyDelete;
import Algorithm.dynamic.palindrome1.Palindrome;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-07 20:07
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description
 */
public class CreatePalindromebyDeleteTest {

    @Test
    public void TestCreatePalindromebyDelete() {
        useLcsTest(new CreatePalindromebyDelete());
    }

    public void useLcsTest(Palindrome createPalindromebyDelete) {
        int flag = createPalindromebyDelete.CreatePalindromeByDelete(TestString01);
        assert flag == -1;
        flag = createPalindromebyDelete.CreatePalindromeByDelete(TestString02);
        assert flag == -1;
        flag = createPalindromebyDelete.CreatePalindromeByDelete(TestString03);
        assert flag == 0;
        flag = createPalindromebyDelete.CreatePalindromeByDelete(TestString04);
        assert flag == 0;
        flag = createPalindromebyDelete.CreatePalindromeByDelete(TestString05);
        assert flag == 1;
        flag = createPalindromebyDelete.CreatePalindromeByDelete(TestString06);
        assert flag == 1;
        flag = createPalindromebyDelete.CreatePalindromeByDelete(TestString07);
        assert flag == 1;
        flag = createPalindromebyDelete.CreatePalindromeByDelete(TestString08);
        assert flag == 2;
        flag = createPalindromebyDelete.CreatePalindromeByDelete(TestString081);
        assert flag == 3;
        flag = createPalindromebyDelete.CreatePalindromeByDelete(TestString082);
        assert flag == 3;
        flag = createPalindromebyDelete.CreatePalindromeByDelete(TestString09);
        assert flag == 0;
    }

    String TestString01 = null;
    String TestString02 = "";
    String TestString03 = "abcddcba";
    String TestString04 = "abcdcba";
    String TestString05 = "ab2cdcba";
    String TestString06 = "abcdcba3";
    String TestString07 = "0abcdcba";
    String TestString08 = "0abcd3cba";
    String TestString081 = "123aa454n321";
    String TestString082 = "12344321234";
    String TestString09 = "a";
}
