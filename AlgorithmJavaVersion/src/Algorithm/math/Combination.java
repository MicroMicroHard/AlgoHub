package Algorithm.math;

import Top100.Mathlj;
import Common.Constant.C;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/5/21 14:32
 * @author—Email micromicrohard@outlook.com
 * @description 数学组合数
 * @blogURL
 */

public class Combination implements Mathlj {

    // C(m n)
    public static int CalMethod(int m, int n) {
        if (n < 0 || m < n) {
            return C.ErrorNum;
        }
        int m_Factorial = Factorial.CalMethod(m);
        int m_n_Factorial = Factorial.CalMethod(m - n);
        int n_Factorial = Factorial.CalMethod(n);
        return m_Factorial / (m_n_Factorial * n_Factorial);
    }
}
