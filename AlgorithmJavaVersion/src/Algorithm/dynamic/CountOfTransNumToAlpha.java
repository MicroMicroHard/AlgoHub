package Algorithm.dynamic;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/6/29
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */

public class CountOfTransNumToAlpha {

  /*  public String input01 = "12258";
    public int output01 = 5;*/

    public int count(int input1) {

        String input = String.valueOf(input1);
        if (input.length() <= 0) {
            return 0;
        }
        if (input.length() == 1) {
            return 1;
        }
        int[] ss = new int[input.length()];
        ss[0] = 1;
        ss[1] = 1;
        if (judge(input.charAt(0), input.charAt(1)) == 1) {
            ss[1] = 2;
        }
        for (int i = 2; i < input.length(); i++) {
            // 组合成功
            if (judge(input.charAt(i - 1), input.charAt(i)) == 1) {
                ss[i] = ss[i - 1] + ss[i - 2];
            } else {
                ss[i] = ss[i - 1];
            }
        }
        return ss[ss.length - 1];
    }

    public int judge(char x1, char x2) {
        if (x1 == '0') {
            return 0;
        }
        int nu = Integer.parseInt("" + x1 + x2);
        return 'a' + nu <= 'z' ? 1 : 0;
    }

    public static void main(String[] args) {
        CountOfTransNumToAlpha u = new CountOfTransNumToAlpha();
        System.out.println(u.count(0));
    }
}
