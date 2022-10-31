package Algorithm.math;

import Top100.BigIntegerOpera;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/5/15
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 大数相关操作
 * 无符号大数相加{@link BigNumOperaBasic#add}
 * 无符号大数相减{@link BigNumOperaBasic#sub}
 * 无符号大数相乘{@link BigNumOperaBasic#multi}
 * <p>
 * 无符号大数相除{@link BigNumOperaBasic#div}
 * 无符号大数取余{@link BigNumOperaBasic#mod}
 * 无符号大数相除并且取余{@link BigNumOperaBasic#divWithMod}
 */

public class BigNumOperaBasic implements BigIntegerOpera {

    //大数加法【无符号】
    public String add(String params, String params2) {
        if (params.length() == 0 || params2.length() == 0) {
            return params.length() == 0 ? params2 : params;
        }
        StringBuilder sb = new StringBuilder(params);
        StringBuilder sb2 = new StringBuilder(params2);
        //字符串逆置，方便计算和存储
        char[] ch = sb.reverse().toString().toCharArray();
        char[] ch2 = sb2.reverse().toString().toCharArray();
        // 找出最大位数的那个数
        if (ch2.length > ch.length) {
            char[] temp = ch2;
            ch2 = ch;
            ch = temp;
        }
        //加法可能会进位，需要重新构造一个StringBuilder
        StringBuilder sb3 = new StringBuilder();
        int decimal = 0;// 进位
        //运算,数值整理和进位
        int pisition = 0;
        int temp = 0;
        while (pisition < ch.length) {
            if (pisition < ch2.length) {
                temp = (ch[pisition] - '0') + (ch2[pisition] - '0') + decimal;
            } else {
                temp = ch[pisition] - '0' + decimal;
            }
            decimal = temp / 10;
            sb3.append((char) (temp % 10 + '0'));//attention:最后需要加上'0'
            pisition++;
        }
        // attention: 最后的进位
        if (decimal != 0) {
            sb3.append(decimal);
        }
        return sb3.reverse().toString();
    }

    //大整数减法【无符号】
    public String sub(String params, String params2) {
        StringBuilder sb = new StringBuilder(params);
        StringBuilder sb2 = new StringBuilder(params2);
        //字符串逆置，方便计算和存储
        char[] ch = sb.reverse().toString().toCharArray();
        char[] ch2 = sb2.reverse().toString().toCharArray();

        // attention: 此处跟加法的交换不一样, 被减数小的情况需要交换
        boolean exchange = false;
        if (less(params, params2)) {
            char[] temp = ch;
            ch = ch2;
            ch2 = temp;
            exchange = true;
        }

        //减法没有进位，所以原址排序即可
        int decimal = 0;// 进位
        int temp = 0;

        //运算
        for (int i = 0; i < ch.length; i++) {
            if (i < ch2.length) {
                temp = (ch[i] - '0') - (ch2[i] - '0') + decimal;
            } else if (decimal == 0) {//设计的比较好
                break;
            } else {
                temp = (ch[i] - '0') + decimal;
            }
            if (temp < 0) {
                temp += 10;
                decimal = -1;
            } else {
                decimal = 0;
            }
            ch[i] = (char) (temp + '0');
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(ch));
        String ans = sb3.reverse().toString();
        return exchange ? '-' + ans : ans;
    }

    //大整数乘法【无符号】
    public String multi(String params, String params2) {
        StringBuilder sb = new StringBuilder(params);
        StringBuilder sb2 = new StringBuilder(params2);

        //字符串逆置，方便计算和存储
        char[] ch = sb.reverse().toString().toCharArray();
        char[] ch2 = sb2.reverse().toString().toCharArray();
        //两个数相乘的积位数不会大于两数位数之和
        int length = ch.length + ch2.length;
        int[] multiSum = new int[length];
        //运算
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                multiSum[i + j] += (ch[i] - '0') * (ch2[j] - '0');
                //数值整理和进位
                multiSum[i + j + 1] += multiSum[i + j] / 10;
                multiSum[i + j] %= 10;
            }
        }
        StringBuilder sb3 = new StringBuilder();
        //消除0
        boolean zeroFlag = false;
        for (int i = length - 1; i >= 0; i--) {
            if (multiSum[i] != 0) {
                zeroFlag = true;
            }
            if (zeroFlag) {
                sb3.append(multiSum[i]);
            }
        }
        return sb3.toString();
    }

    public static void main(String[] args) {
        BigNumOperaBasic b = new BigNumOperaBasic();
        // 12_000_000_000_000_000_000;
        String ans = b.div("290", "12", 10);
        //String ans = b.divWithMod("1", "0").DivStruct2String();
        System.out.println(ans);

        // 12,12
        // 13,12
        // 12000,12
        // 12001,12
        // 0,12
        // 2,12
        // 11,12
        // 12000000000000000000001,12
        // 110,12
        // 1110,12
        // 11110,12
    }


    //  params / params2
    public String mod(String params, String params2) {
        return null;
    }

    /**
     * @param params:除数
     * @param params2:被除数
     * @param accuracy:精度，小数点后几位
     * @return 商
     */
    public String div(String params, String params2, int accuracy) {
        StringBuilder sb = new StringBuilder(params);
        for (int i = 0; i < accuracy; i++) {
            sb.append("0");
        }
        params = sb.toString();

        if ("0".equals(params) || less(params, params2)) {
            return "0";
        }
        // 除数是否 等于/小于 被除数
        if (params.equals(params2)) {
            return "1";
        }
        if ("0".equals(params2)) {
            return "0";
        }
        String quotient = "";  // 商
        String remainder = "0"; // 余数

        while (!less(params, params2)) {
            int gap = params.length() - params2.length();
            int count = 0;
            boolean flag = true;
            for (int i = 0; gap > 0 && i < params2.length(); i++) {
                if (params.charAt(i) < params2.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                gap--;
            }
            while (!less(params, multi(params2, buildPowNum(gap, count + 1)))) {
                count++;
            }
            quotient = add(quotient, buildPowNum(gap, count));
            remainder = sub(params, multi(params2, buildPowNum(gap, count)));
            params = zeroReduce(remainder);
        }
        return quotient + "";
    }

    public BigNumDivStruct divWithMod(String params, String params2) {
        if ("0".equals(params2)) {
            return new BigNumDivStruct();
        }
        // 除数是否 等于/小于 被除数
        if (params.equals(params2)) {
            return new BigNumDivStruct("1", "0");
        }
        if ("0".equals(params) || less(params, params2)) {
            return new BigNumDivStruct("0", params);
        }
        String quotient = "";  // 商
        String remainder = "0"; // 余数

        while (!less(params, params2)) {
            int gap = params.length() - params2.length();
            int count = 0;
            boolean flag = true;
            for (int i = 0; gap > 0 && i < params2.length(); i++) {
                if (params.charAt(i) < params2.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                gap--;
            }
            while (!less(params, multi(params2, buildPowNum(gap, count + 1)))) {
                count++;
            }
            quotient = add(quotient, buildPowNum(gap, count));
            remainder = sub(params, multi(params2, buildPowNum(gap, count)));
            params = zeroReduce(remainder);
        }
        return new BigNumDivStruct(quotient, zeroReduce(remainder));
    }

    //大整数合并【无符号】
    public String merge(String params, String params2) {
        StringBuilder sb = new StringBuilder();
        if (params.length() < params2.length()) {
            String temp = params;
            params = params2;
            params2 = temp;
        }
        int decimal = 0;// 进位
        for (int i = params.length() - 1; i >= 0; i--) {
            if (i < params2.length()) {
                int tempSum = (params.charAt(i) - '0' + params2.charAt(i)) - '0' + decimal;
                decimal = tempSum / 10;
                sb.append((char) (tempSum % 10 + '0'));
            } else {
                sb.append(params.charAt(i));
            }
        }
        // 最后一位表示进位
        sb.append(decimal);
        return sb.reverse().toString();
    }
}
