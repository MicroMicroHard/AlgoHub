package DataStructure.stringOps.stringAndSequence;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/19
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 最小循环字符串
 * 找出一个字符串中最小循环的那个字符串组合
 * 输入：asdfasdfasdfasdfasdfasdfasd
 * 输出：asdf
 * 输入：yhbnhgbkiugjgyhbnhgbkiugjg
 * 输出：yhbnhgbkiugjg
 * 输入：kfdf2ghjklkjh4gf2dfgjkl2gfdf6gh
 * 输出：kfdf2ghjklkjh4gf2dfgjkl2gfdf6gh
 */
public class MinCyclicsubString {

    public String getCycle(String s) {
        String answer = "";
        if (s != null && s.length() != 0) {
            for (int i = 1; i <= s.length(); i++) {
                answer = s.substring(0, i);
                if (compare(s, answer)) {
                    return answer;
                }
            }
        }
        return answer;
    }

    private boolean compare(String source, String pattern) {
        int length = pattern.length();
        int sourecePoint = 0;
        int patternPoint = 0;
        while (sourecePoint < source.length()) {
            if (source.charAt(sourecePoint) == pattern.charAt(patternPoint)) {
                sourecePoint++;
                patternPoint++;
                if (patternPoint == length ) {
                    patternPoint = 0;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
