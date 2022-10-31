package Algorithm.dynamic.palindrome;

/**
 * @author liujun
 * @version 1.0
 * @date 2022/7/5 23:37
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 回文串判断
 * @blogURL
 */

public class Palindrome_Judge {

    public static boolean judgeMethod(String params) {
        if (params == null || params.length() == 0) {
            return false;
        }
        return params.equals(new StringBuffer(params).reverse().toString());
    }

    public boolean judgeMethodTwoPoint(String params) {
        if (params == null || params.length() == 0) {
            return false;
        }
        int left = 0;
        int right = params.length() - 1;
        return rangeJudge(params, left, right);
    }

    public boolean rangeJudge(String params, int leftPosition, int rightPosition) {
        if (params == null || params.length() == 0 ||
                leftPosition > rightPosition || leftPosition < 0 || rightPosition >= params.length()) {
            return false;
        }
        while (leftPosition < rightPosition) {
            if (params.charAt(leftPosition) != params.charAt(rightPosition)) {
                return false;
            }
            leftPosition++;
            rightPosition--;
        }
        return true;
    }
}
