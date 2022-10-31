package Algorithm.math;

import Top100.Mathlj;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/6
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 平方根
 * @attention
 * 1、每次取值都是在区间的中点，一开始区间左边界是0，右边界是被平方数
 * 2、precisionAccuracy是精度差，确保平方根求出来的数与被平方数相差小于 精度差
 * 3、循环条件是 accuracy 精度
 * 4、针对类似于99.999这样的优化
 */
public class Square implements Mathlj {

    /**
     * precisionAccuracy 精度差
     */
    double precisionAccuracy = 1;
    double HEX = 10;

    public double cal(double value) {
        //默认精度为3
        return cal(value, 3);
    }

    /**
     * @param value    被开方数
     * @param accuracy 精度：小数点后几位
     * @return 平方根
     */
    public double cal(double value, int accuracy) {
        if (value <= 0 || accuracy <= 0) {
            return 0;
        }
        precisionAccuracy = 1;
        for (int i = 0; i < accuracy; i++) {
            precisionAccuracy /= HEX;
        }
        double left = 0;
        double right = value;
        double mid = 0;
        double ans = 0;
        int acc = 0;
        //循环条件是精度
        while (count(ans, value) > precisionAccuracy) {
            mid = (left + right) / 2;
            ans = mid * mid;
            if (ans > value) {
                right = mid;
            } else if (ans < value) {
                left = mid;
            } else {
                break;
            }
        }
        //精度问题
        String[] temp = String.valueOf(mid).split("\\.");
        int length = temp[1].length();
        if (length == accuracy) {
            return mid;
        } else if (length < accuracy) {
            //精度不足
            for (int i = temp[1].length(); i < accuracy; i++) {
                temp[1] += "0";
            }
        } else {
            //精度超过
            temp[1] = temp[1].substring(0, accuracy);
        }
        mid = Double.parseDouble(temp[0] + "." + temp[1]);
        //针对类似于99.999这样的优化
        mid = ops9(mid);
        return mid;
    }

    private double count(double a, double b) {
        double t = a - b > 0 ? a - b : b - a;
        return t;
    }

    private double ops9(double valDouble) {
        String valueStr = String.valueOf(valDouble);
        String[] d = String.valueOf(valDouble).split("\\.");
        boolean flag = true;
        for (int i = 0; i < valueStr.length(); i++) {
            if (valueStr.charAt(i) != '9' && valueStr.charAt(i) != '.') {
                flag = false;
                break;
            }
        }
        if (flag) {
            valDouble = Double.parseDouble(d[0]) + 1;
        }
        return valDouble;
    }
}
