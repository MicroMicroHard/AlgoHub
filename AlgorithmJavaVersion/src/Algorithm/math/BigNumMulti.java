package Algorithm.math;

import Top100.BigIntegerOpera;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/5/15
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 大数乘法
 */
public class BigNumMulti implements BigIntegerOpera {

    //大整数乘法
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
            decimalPointPosition = h1 + h2;
            params = paramsBuilder.toString();
            params2 = paramsBuilder2.toString();
        }

        String multi = instance.multi(params, params2);

        // 还原小数
        if (decimalPointPosition != 0) {
            StringBuilder sb = new StringBuilder(multi);
            sb.insert(multi.length() - decimalPointPosition, ".");
            // 尾部处理 0 、 尾部仅有 小数点
            multi = zeroReduce(sb.toString());
        }
        //带上运算符号
        return signal == 1 ? "-" + multi : multi;
    }

    //大整数乘法
    public String multi1(String params, String params2) {

        StringBuffer sb = new StringBuffer(params);
        StringBuffer sb2 = new StringBuffer(params2);
        //运算符判断
        int signal = 0;
        if ("-".equals(params.substring(0, 1))) {
            sb.delete(0, 1);
            signal++;
        }
        if ("-".equals(params2.substring(0, 1))) {
            sb2.delete(0, 1);
            signal++;
        }

        //两个数相乘的积位数不会大于两数位数之和
        int[] multiSum = new int[params.length() + params2.length()];
        //运算
        for (int i = params.length() - 1; i >= 0; i--) {
            for (int j = params2.length() - 1; j >= 0; j--) {
                // 计算单个值
                int temp = (params.charAt(i) - '0') * (params.charAt(j) - '0');
                // i + j + 1 是新数组的最后一个元素
                multiSum[i + j + 1] += temp % 10;
                multiSum[i + j] += temp / 10;
            }
        }

        StringBuffer sb3 = new StringBuffer();
        //消除0
        int u = multiSum.length - 1;
        while (multiSum[u] == 0) {
            u--;
        }
        //逆序
        for (; u >= 0; u--) {
            sb3.append(multiSum[u]);
        }

        //带上运算符号
        if ((signal & 1) == 1) {
            sb3.insert(0, "-");
        }
        return sb3.toString();
    }

    public String calMetho1d2(String params, String params2) {
        // 异常和0值的判断
        if (!NullCheck(params, params2) || params.equals("0") || params2.equals("0")) {
            return "0";
        }

        StringBuffer sb = new StringBuffer(params);
        StringBuffer sb2 = new StringBuffer(params2);
        //运算符判断
        int signal = 0;
        if ("-".equals(params.substring(0, 1))) {
            sb.delete(0, 1);
            signal++;
        }
        if ("-".equals(params2.substring(0, 1))) {
            sb2.delete(0, 1);
            signal++;
        }

        //两个数相乘的积位数不会大于两数位数之和
        int[] multiSum = new int[sb.toString().length() + sb2.toString().length()];
        //运算
        for (int i = sb.toString().length() - 1; i >= 0; i--) {
            for (int j = sb2.toString().length() - 1; j >= 0; j--) {
                // 计算单个值
                int temp = multiSum[i + j + 1] + (sb.toString().charAt(i) - '0') * (sb2.toString().charAt(j) - '0');
                // i + j + 1 是新数组的最后一个元素
                multiSum[i + j + 1] = temp % 10;
                multiSum[i + j] += temp / 10;

                /**
                 * attention：值覆盖问题很难发现
                 * 比如这种写法就是错误的：multiSum[i + j + 1]存在值覆盖的问题
                 * int temp = (sb.toString().charAt(i) - '0') * (sb2.toString().charAt(j) - '0');
                 * // i + j + 1 是新数组的最后一个元素
                 * multiSum[i + j + 1] = (multiSum[i + j + 1]+temp) % 10;
                 * multiSum[i + j] += (multiSum[i + j + 1]+temp) / 10;
                 */
            }
        }

        StringBuffer sb3 = new StringBuffer();
        //消除计算结果的前缀0
        int u = 0;
        while (multiSum[u] == 0) {
            u++;
        }
        //逆序
        for (; u <= multiSum.length - 1; u++) {
            sb3.append(multiSum[u]);
        }

        //带上运算符号
        if ((signal & 1) == 1) {
            sb3.insert(0, "-");
        }
        return sb3.toString();
    }
}
