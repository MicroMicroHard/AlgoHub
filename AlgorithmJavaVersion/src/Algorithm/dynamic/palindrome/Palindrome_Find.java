package Algorithm.dynamic.palindrome;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/7/5 23:38
 * @author—Email micromicrohard@outlook.com
 * @description 找出回文串
 * 在给定字符串中，找出最长的连续回文串
 * 暴力法{@link Palindrome_Find#findMethod_violence}
 * 双指针{@link Palindrome_Find#findMethod_point}
 * @blogURL
 */

public class Palindrome_Find {

    public String findMethod_violence(String params) {
        if (params == null || params.length() == 0) {
            return params;
        }
        String bestStr = String.valueOf(params.charAt(0));
        for (int i = 0; i < params.length() - 1; i++) {
            for (int j = i + 2; j <= params.length(); j++) {
                String tempStr = params.substring(i, j);
                if (Palindrome_Judge.judgeMethod(tempStr) && tempStr.length() > bestStr.length()) {
                    bestStr = tempStr;
                }
            }
        }
        return bestStr;
    }

    public String findMethod_point(String params) {
        if (params == null || params.length() == 0) {
            return params;
        }
        int length = 1;
        int midPoint = 0;
        String bestStr = String.valueOf(params.charAt(0));

        for (int i = 0; i < params.length() - 1; i++) {
            int temp = deal(params, i, i);
            if (temp > length) {
                length = temp;
                midPoint = i;
                bestStr = params.substring(midPoint - length + 1, midPoint + length);
            }

            int temp2 = deal(params, i, i + 1);
            if (temp2 >= length) {
                length = temp2;
                midPoint = i;
                bestStr = params.substring(midPoint - length + 1, midPoint + length + 1);
            }
        }
        return bestStr;
    }


    public int deal(String sourceStr, int leftBound, int rightBound) {
        int left = leftBound;
        int right = rightBound;
        boolean flag = false;
        while (left >= 0 && right < sourceStr.length() && sourceStr.charAt(left) == sourceStr.charAt(right)) {
            left--;
            right++;
            flag = true;
        }
        return flag ? right - rightBound : -1;
    }

    class FindPalindromeOps {

        int left = 0;
        int maxLength = 0;

        public String FindPalindrome(String s) {
            if (s == null || s.length() == 0) return "";

            for (int i = 0; i < s.length(); i++) {
                helper(s, i, i);
                helper(s, i, i + 1);
            }
            return s.substring(left, left + maxLength);
        }

        public void helper(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLength) {
                    maxLength = r - l + 1;
                    left = l;
                }
                l--;
                r++;
            }
        }
    }

    //采用中间开花法查找回文
    public class FindPalindrome {
        public String FindPalindrome(String source) {
            if (source == null || source.length() == 0) {
                return null;
            }
            int PalindromeLength = 0;
            int preStringTempLength = 0;
            int PalindromeBegin = 0;
            //获取字符串预处理后的值
            String preString = preDealString(source, '#');
            if (preString != null) {
                for (int i = 0; i < preString.length(); i++) {
                    preStringTempLength = getPointBound(preString, i);
                    if (PalindromeLength < preStringTempLength) {
                        PalindromeLength = preStringTempLength;
                        PalindromeBegin = (i - PalindromeLength) / 2;
                    }
                }
            }
            //长度为1，即未匹配上，返回为空
            if (PalindromeLength == 1) {
                return null;
            }
            String targetString = source.substring(PalindromeBegin, PalindromeBegin + PalindromeLength);
            return targetString;
        }

        //字符串预处理，所有间隔位置加#
        public String preDealString(String source, char divideChar) {
            //检查字符串是否含有分隔符
            if (source.indexOf(divideChar) != -1) {
                return null;
            }
            char[] SPchar = source.toCharArray();
            StringBuilder stringBuffer = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                stringBuffer.append(divideChar);
                stringBuffer.append(SPchar[i]);
            }
            stringBuffer.append(divideChar);
            return stringBuffer.toString();
        }

        //获取以point为中心的回文字符串长度，注意该长度是单边长度
        public int getPointBound(String pattern, int point) {

            int length = pattern.length() - 1;
            int leftbound = point - 1;
            int rightbound = point + 1;
            int boundlength = 0;
            while (leftbound >= 0 && rightbound <= length && pattern.charAt(leftbound) == pattern.charAt(rightbound)) {
                boundlength++;
                leftbound--;
                rightbound++;
            }
            return boundlength;
        }
    }
}
