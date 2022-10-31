package Algorithm.math;

import Top100.BigIntegerOpera;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/5/15
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 大整数除法
 * @blog https://wenku.baidu.com/view/202b9fda730abb68a98271fe910ef12d2af9a901.html
 */

public class BigNumDiv implements BigIntegerOpera {

    //大整数除法
    public String calMethod(String params, String params2) {
        // 异常和0值的判断
        if (!NullCheck(params, params2)) {
            return "";
        }
        if (params.equals("0") || params2.equals("0")) {
            return "0";
        }
        //运算符判断
        int signal = 0;
        if (params.charAt(0) == '-') {
            params = params.substring(1);
            signal ^= 1;
        }
        if (params2.charAt(0) == '-') {
            params2 = params2.substring(1);
            signal ^= 1;
        }
        params = zeroReduce(params);
        params2 = zeroReduce(params2);

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
            decimalPointPosition = h1 - h2;
            params = paramsBuilder.toString();
            params2 = paramsBuilder2.toString();
        }

        String div = instance.div(params, params2, 5);
        return null;

        // 还原小数
       /* if (decimalPointPosition != 0) {
            StringBuilder sb = new StringBuilder(multi);
            sb.insert(multi.length() - decimalPointPosition, ".");
            // 尾部处理 0 、 尾部仅有 小数点
            multi = zeroReduce(sb.toString());
        }
        //带上运算符号
        return signal == 1 ? "-" + multi : multi;*/


    }
}
