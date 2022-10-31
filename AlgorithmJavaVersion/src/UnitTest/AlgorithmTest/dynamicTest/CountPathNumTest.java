package UnitTest.AlgorithmTest.dynamicTest;

import Algorithm.dynamic.CountPathNum;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/12/9
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 计算路径数 测试案例
 */
public class CountPathNumTest {

    CountPathNum cp = new CountPathNum();

    @Test
    public void testcount() {
        int answer = cp.count(3, 7);
        assert answer == 28;
        answer = cp.count(3, 2);
        assert answer == 3;
        answer = cp.count(17, 1);
        assert answer == 1;
        answer = cp.count(1, 17);
        assert answer == 1;
    }
}
