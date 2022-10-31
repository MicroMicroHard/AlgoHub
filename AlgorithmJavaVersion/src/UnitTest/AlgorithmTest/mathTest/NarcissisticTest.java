package UnitTest.AlgorithmTest.mathTest;

import Algorithm.math.Narcissistic;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/1/6
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 水仙花数 测试案例
 */
public class NarcissisticTest {

    Narcissistic narcissistic = new Narcissistic();

    @Test
    public void test() {
        long time1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            narcissistic.narcissistic();
        }
        System.out.println(System.nanoTime() - time1);

        time1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            narcissistic.narcissisticOptic();
        }
        System.out.println(System.nanoTime() - time1);
    }
}
