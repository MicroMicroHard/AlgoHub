package DataStructure.arrayRelevant.arrayTransformation;

import Top100.Reversal;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/8/25
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 反转字符串
 * 例如：从$开始反转字符串："123$456789" -> "456789$123"
 * 要求：原址排序
 */
public class ReversalString implements Reversal {

    public String method(String s, char c1) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] c = s.toCharArray();
        int num = s.indexOf(c1);
        if (num == -1) {
            return s;
        }
        int length = s.length();
        //需要注意此处的i <= (num - 1) / 2，而不是i <= num / 2
        for (int i = 0; i <= (num - 1) / 2; i++) {
            char temp = c[i];
            c[i] = c[num - 1 - i];
            c[num - 1 - i] = temp;
        }
        System.out.println(c);
        for (int i = 0; i < (length - num) / 2; i++) {
            char temp = c[num + 1 + i];
            c[num + 1 + i] = c[length - 1 - i];
            c[length - 1 - i] = temp;
        }
        System.out.println(c);
        for (int i = 0; i < length / 2; i++) {
            char temp = c[i];
            c[i] = c[length - 1 - i];
            c[length - 1 - i] = temp;
        }
        System.out.println(c);
        String target = String.valueOf(c);
        return target;
    }
}
