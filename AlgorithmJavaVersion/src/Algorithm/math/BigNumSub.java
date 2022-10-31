package Algorithm.math;

import Top100.BigIntegerOpera;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/5/15
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 大整数减法
 * 1、输入检查
 * 2、符号判断
 * 3、关于0的处理【0的处理需要考虑负号，因此放在符号判断以后】
 * 4、进行运算
 * 5、
 * 6、
 */

public class BigNumSub implements BigIntegerOpera {

    //大整数减法
    public String calMethod(String params, String params2) {
        String sub = "";
        // 输入检查
        if (!NullCheck(params, params2)) {
            return sub;
        }
        // 去掉 前置0 和 尾置0
        params = zeroReduce(params);
        params2 = zeroReduce(params2);

        // 关于0的处理,attention:注意0和负数的情况
        if (params.equals("0") || params2.equals("0")) {
            if (params.equals("0")) {
                return params2.contains("-") ? params2.replace("-", "") : "-" + params2;
            }
            return params;
        }

        // 符号判断
        String signal = "+";
        String signal2 = "+";
        if (params.charAt(0) == '-') {
            params = params.substring(1);
            signal = "-";
        }
        if (params2.charAt(0) == '-') {
            params2 = params2.substring(1);// substring是左闭右开
            signal2 = "-";
        }

        // 小数的处理
        int decimalPointPosition = 0; // 小数点的位置
        if (params.contains(".") || params2.contains(".")) {
            int pointPosition = params.indexOf(".");
            int pointPosition2 = params2.indexOf(".");

            // 删除小数点
            StringBuilder paramsBuilder = new StringBuilder(params);
            if (pointPosition != -1) {
                paramsBuilder.deleteCharAt(pointPosition);
            } else {
                pointPosition = params.length();
            }

            StringBuilder paramsBuilder2 = new StringBuilder(params2);
            if (pointPosition2 != -1) {
                paramsBuilder2.deleteCharAt(pointPosition2);
            } else {
                pointPosition2 = params2.length();
            }

            int h1 = pointPosition == params.length() ? 0 : params.length() - 1 - pointPosition;
            int h2 = pointPosition2 == params2.length() ? 0 : params2.length() - 1 - pointPosition2;
            decimalPointPosition = Math.max(h1, h2);
            while (h1 < decimalPointPosition) {
                paramsBuilder.append("0");
                h1++;
            }
            while (h2 < decimalPointPosition) {
                paramsBuilder2.append("0");
                h2++;
            }
            params = paramsBuilder.toString();
            params2 = paramsBuilder2.toString();
        }

        // 进行运算：两个正数相减、正数减负数、负数减正数、负数减负数
        String d = signal + signal2;
        switch (d) {
            case "++":
                sub = instance.sub(params, params2);//两个正数相减
                break;
            case "+-":
                sub = instance.add(params, params2);//正数减负数
                break;
            case "-+":
                sub = "-" + instance.add(params, params2);//负数减正数
                break;
            case "--":
                sub = instance.sub(params2, params);//负数减负数
                break;
        }

        // 还原小数
        if (decimalPointPosition != 0) {
            StringBuilder sb = new StringBuilder(sub);
            sb.insert(sub.length() - decimalPointPosition, ".");
            // 尾部处理 0 、 尾部仅有 小数点
            sub = zeroReduce(sb.toString());
        }
        return sub;
    }
}
