package UnitTest.AlgorithmTest.dynamicTest.PalindromeTest;

import Algorithm.dynamic.palindrome1.CreatePalindromebyAdd;
import Algorithm.dynamic.palindrome1.Palindrome;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-07 20:08
 * @author-Email micromicrohard@outlook.com
 * @description
 */
public class CreatePalindromebyAddTest {
    CreatePalindromebyAdd createPalindromebyadd = new CreatePalindromebyAdd();

    @Test
    public void TestCreatePalindromebyAdd() {
        useDeleteTest(new CreatePalindromebyAdd());
    }

    @Test
    public void headAndTailCompareTest() {

        int flag = createPalindromebyadd.headAndTailCompare(TestString01);
        assert flag == -1;
        flag = createPalindromebyadd.headAndTailCompare(TestString02);
        assert flag == -1;
        flag = createPalindromebyadd.headAndTailCompare(TestString03);
        assert flag == 4;
        flag = createPalindromebyadd.headAndTailCompare(TestString04);
        assert flag == 3;
        flag = createPalindromebyadd.headAndTailCompare(TestString05);
        assert flag == 2;
        flag = createPalindromebyadd.headAndTailCompare(TestString06);
        assert flag == 7;
        flag = createPalindromebyadd.headAndTailCompare(TestString07);
        assert flag == 0;
        flag = createPalindromebyadd.headAndTailCompare(TestString08);
        assert flag == -1;
        flag = createPalindromebyadd.headAndTailCompare(TestString09);
        assert flag == 0;
    }

    public void useDeleteTest(Palindrome createPalindromebyadd) {
        int flag = createPalindromebyadd.CreatePalindromeByAdd(TestString01);
        assert flag == -1;
        flag = createPalindromebyadd.CreatePalindromeByAdd(TestString02);
        assert flag == -1;
        flag = createPalindromebyadd.CreatePalindromeByAdd(TestString03);
        assert flag == 4;
        flag = createPalindromebyadd.CreatePalindromeByAdd(TestString04);
        assert flag == 3;
        flag = createPalindromebyadd.CreatePalindromeByAdd(TestString05);
        assert flag == 2;
        flag = createPalindromebyadd.CreatePalindromeByAdd(TestString06);
        assert flag == 7;
        flag = createPalindromebyadd.CreatePalindromeByAdd(TestString07);
        assert flag == 0;
        flag = createPalindromebyadd.CreatePalindromeByAdd(TestString08);
        assert flag == -1;
        flag = createPalindromebyadd.CreatePalindromeByAdd(TestString09);
        assert flag == 0;
    }

    //��������LCS˼�����
    @Test
    public void useLCSTest() {
        //�޷��ж��ǵ�iλ����length-iλ
    }


    //��������01:�գ�������-1
    String TestString01 = null;
    //��������02:�մ���������-1
    String TestString02 = "";
    //��������03:ż�����Ȼ��Ĵ���������4
    String TestString03 = "abcddcba";
    //��������04:�������Ȼ��Ĵ���������3
    String TestString04 = "abcdcba";
    //��������05:��ɾ����3λ��������2
    String TestString05 = "ab2cdcba";
    //��������06:��ɾ�����һλ��7��������7
    String TestString06 = "abcdcba3";
    //��������07:��ɾ����һλ��0��������0
    String TestString07 = "0abcdcba";
    //��������08:ɾ��һλ���Բ��ǻ��Ĵ���������-1
    String TestString08 = "0abcd3cba";
    //��������09:����1���ַ�
    String TestString09 = "a";
}
