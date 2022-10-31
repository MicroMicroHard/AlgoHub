package Algorithm.math;

import Top100.BigIntegerOpera;


/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/5/15
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 大数加法
 * 1、输入检查
 * 2、关于0的处理
 * 3、运算符同号判断
 * 4、小数的处理
 * 5、进行运算：两个正数相加、正数加负数、负数加正数、负数加负数
 * 6、还原小数【注意最后输出的数字最后一位是否为小数点】
 */
public class BigNumSum implements BigIntegerOpera {

    //大整数加法
    public String calMethod(String params, String params2) {
        String sum = "";
        if (!NullCheck(params, params2)) {
            return sum;
        }
        // 去掉 前置0 和 尾置0
        params = zeroReduce(params);
        params2 = zeroReduce(params2);
        // 关于0的处理
        if (params.equals("0") || params2.equals("0")) {
            return params.equals("0") ? params2 : params;
        }

        //运算符同号判断
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

        // 进行运算：两个正数相加、正数加负数、负数加正数、负数加负数
        String d = signal + signal2;
        switch (d) {
            case "++":
                sum = instance.add(params, params2);
                break;
            case "+-":
                sum = instance.sub(params, params2);
                break;
            case "-+":
                sum = instance.sub(params2, params);
                break;
            case "--":
                sum = "-" + instance.add(params2, params);
                break;
        }

        // 还原小数
        if (decimalPointPosition != 0) {
            StringBuilder sb = new StringBuilder(sum);
            sb.insert(sum.length() - decimalPointPosition, ".");
            // 尾部处理 0 、 尾部仅有 小数点
            sum = zeroReduce(sb.toString());
        }
        return sum;
    }
}
