package Top100;

import Algorithm.math.*;
import DataStructure.list.listRealize.BigIntegersSum_List;
import DataStructure.list.listRealize.BigIntegersMulti_List;
import DataStructure.list.listRealize.BigIntegersSub_List;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/1/15
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 大整数操作
 * 输入：使用字符串或者链表来表示数【对于字符串和链表中的符号位，可以另外处理，此处只求最基本的运算】
 * 包括加减乘除
 * <p>
 * 1、入参判断 {@link BigIntegerOpera#NullCheck}
 * 2、数字判断 {@link BigIntegerOpera#numCheck}
 * 3、数字0判断 {@link BigIntegerOpera#zeroCheck}
 * 4、字符串前置0 和后置0 处理 {@link BigIntegerOpera#zeroReduce}
 * 5、判断 params 是否 小于 params2 [无符号数] {@link BigIntegerOpera#less}
 */

public interface BigIntegerOpera {

    BigNumOperaBasic instance = new BigNumOperaBasic();

    default boolean NullCheck(String params1, String params2) {
        // 异常和0值的判断
        if (params1 == null || params2 == null || params1.length() == 0 || params2.length() == 0) {
            return false;
        }
        // 数字校验
        return numCheck(params1) && numCheck(params2);
    }

    default boolean numCheck(String params) {
        String pattern = "[0-9]+|-[0-9]+|-[0-9]+\\.[0-9]+|[0-9]+\\.[0-9]+"; // 正则 grammar
        return params.matches(pattern);
    }

    // 如果输入仅包含 0 和符号以及小数点，则返回0
    default boolean zeroCheck(String params) {
        String pattern = "0+|-0+\\.0+|0+\\.0+"; // 正则 grammar
        return params.matches(pattern);
    }

    // 字符串前置0 和后置0 处理
    default String zeroReduce(String params) {
        StringBuilder sb = new StringBuilder(params);
        int index = 0;
        if (params.charAt(0) == '-') {
            index = 1;
        }
        // 去掉首部的0，并且下一位不是小数点 , attention: index + 1 < sb.length()
        while (sb.charAt(index) == '0' && index + 1 < sb.length() && sb.charAt(index + 1) != '.') {
            sb.deleteCharAt(index);
        }
        index = sb.length() - 1;
        if (!params.contains(".")) { // 如果不包含小数，则无需走下去
            return zeroCheck(sb.toString()) ? "0" : sb.toString();
        }

        // 去掉尾部的0
        while (sb.charAt(index) == '0') {
            sb.deleteCharAt(index);
            index--;
        }
        // 注意最后一个数字是 "."
        if (sb.lastIndexOf(".") == sb.length() - 1) {
            sb.deleteCharAt(sb.lastIndexOf("."));
        }
        // 如果仅包含0 ，则返回0
        return zeroCheck(sb.toString()) ? "0" : sb.toString();
    }

    // 判断 无符号数 params 是否 小于 params2
    default boolean less(String params, String params2) {
        if (params2.length() > params.length()) {
            return true;
        }
        if (params2.length() == params.length()) {
            for (int i = 0; i < params.length(); i++) {
                if (params.charAt(i) > params2.charAt(i)) {
                    return false;
                }
                if (params.charAt(i) < params2.charAt(i)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 10的 N 次方, begin 是开头的数
    default String buildPowNum(int N, int begin) {
        if (begin == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(begin + "");// string grammar:new StringBuilder 里面必须是 字符串
        for (int i = 0; i < N; i++) {
            sb.append(0);
        }
        return sb.toString();
    }

    /**
     * 大数加法，带符号{@link BigNumSum#calMethod},无符号{@link BigNumOperaBasic#add}
     * 大数减法，带符号{@link BigNumSub#calMethod},无符号{@link BigNumOperaBasic#sub}
     * 大数乘法，带符号{@link BigNumMulti#calMethod},无符号{@link BigNumOperaBasic#multi}
     * 大数除法，带符号{@link BigNumDiv#calMethod},无符号{@link BigNumOperaBasic#div}
     * <p>
     * 数字字符串合并 {@link BigNumMerge#merge}
     */

    default void TypicalImply() {
        new BigNumSum();    // 字符串形式的大整数加法
        new BigNumSub();    // 字符串形式的大整数减法
        new BigNumMulti();  // 字符串形式的大整数乘法
        new BigNumDiv();    // 字符串形式的大整数除法
        new BigIntegersSum_List();     // 链表形式的大整数加法
        new BigIntegersSub_List();     // 链表形式的大整数减法
        new BigIntegersMulti_List();   // 链表形式的大整数乘法
    }
}
