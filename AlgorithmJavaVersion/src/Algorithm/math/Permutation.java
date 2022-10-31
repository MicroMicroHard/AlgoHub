package Algorithm.math;

import Top100.Mathlj;
import Common.Constant.C;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/5/21 14:40
 * @author—Email micromicrohard@outlook.com
 * @description 数学 排列数
 * @blogURL
 */

public class Permutation implements Mathlj {

    public static int CalMethod(int m, int n) {
        if (n < 0 || m < n) {
            return C.ErrorNum;
        }
        return exec2(m, n);
    }

    public static int exec(int m, int n) {
        int m_Factorial = Factorial.CalMethod(m);
        int m_n_Factorial = Factorial.CalMethod(m - n);
        return m_Factorial / m_n_Factorial;
    }

    public static int exec2(int m, int n) {
        int result = 1;
        for (int i = m; i > m - n; i--) {
            result *= i;
        }
        return result;
    }
}
