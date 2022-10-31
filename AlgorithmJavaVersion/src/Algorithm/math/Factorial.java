package Algorithm.math;

import Top100.Mathlj;
import Common.Constant.C;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/5/21 14:18
 * @author—Email micromicrohard@outlook.com
 * @description 阶乘
 * @blogURL
 */

public class Factorial implements Mathlj {

    public static int CalMethod(int n) {
        if (n < 0) {
            return C.ErrorNum;
        }
        if (n == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // grammar： 尾递归
    public static int Cal(int n, int sum) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return sum;
        }
        return Cal(n - 1, sum * n);
    }

    public static void main(String[] args) {
        int u = Cal(6, 1);
        System.out.println(u);
    }
}
