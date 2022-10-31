package UnitTest.AlgorithmTest.dynamicTest.PalindromeTest;

import Algorithm.dynamic.palindrome1.CreatePalindromebyDeletePlus;
import Algorithm.dynamic.palindrome1.Palindrome;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-07 20:07
 * @author-Email micromicrohard@outlook.com
 * @description
 */
public class CreatePalindromebyDeletePlusTest {

    @Test
    public void TestCreatePalindromebyDelete() {
        useLcsTest(new CreatePalindromebyDeletePlus());
    }

    public void useLcsTest(Palindrome createPalindromebyDelete) {
        int target = createPalindromebyDelete.CreatePalindromeByDelete("cacb", "cbba");
        assert target == 5;
        target = createPalindromebyDelete.CreatePalindromeByDelete("aa", "bb");
        assert target == 0;
        target = createPalindromebyDelete.CreatePalindromeByDelete("ab", "ab");
        assert target == 3;
        target = createPalindromebyDelete.CreatePalindromeByDelete("cfe", "ef");
        assert target == 4;
        target = createPalindromebyDelete.CreatePalindromeByDelete("ceebeddc", "d");
        assert target == 3;
    }
}
