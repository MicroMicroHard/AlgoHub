package Algorithm.dynamic.palindrome1;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-07 22:41
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 回文串判断
 */

public class Palindrome {

    //回文串判断
    public boolean JudgePalindrome(String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return false;
        }
        boolean flag = new StringBuffer(pattern).reverse().toString().equals(pattern);
        return flag;
    }

    //回文串查找
    public String FindPalindrome(String pattern) {
        return "";
    }

    //回文串构造——增加法
    public int CreatePalindromeByAdd(String pattern) {
        return 0;
    }

    //回文串构造——删除法
    public int CreatePalindromeByDelete(String pattern) {
        return 0;
    }

    public int CreatePalindromeByDelete(String pattern, String pattern2) {
        return 0;
    }
}
