package UnitTest.AlgorithmTest.mathTest;

import Algorithm.math.Vampire;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/6
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 吸血鬼数字 测试案例
 */
public class VampireTest {

    Vampire v = new Vampire();

    @Test
    public void test() {
        long time1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            v.Vampire1();
        }
        System.out.println(System.nanoTime() - time1);

        time1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            v.Vampire2();
        }
        System.out.println(System.nanoTime() - time1);

    }
}
