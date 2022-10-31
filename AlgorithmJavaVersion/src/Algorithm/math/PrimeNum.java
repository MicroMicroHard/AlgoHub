package Algorithm.math;

import Common.Utils.ArrayTools;
import Common.Utils.UTFactory;
import DataStructure.list.Nodelj;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/19 23:22
 * @author-Email micromicrohard@outlook.com
 * @description 小于N的所有素数
 * @blogURL
 */
public class PrimeNum {

    @Test // 验证功能：从数据库获取测试数据，用于单元测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误的测试案例
    public void DoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    public int[] GetMethod(int nums) {
        if (nums < 2) {
            return new int[]{};
        }
        List<Integer> primeList = new ArrayList<>();
        boolean isPrime;
        primeList.add(2); // 素数组一开始是2

        for (int num = 3; num <= nums; num++) {
            isPrime = false;
            for (int prime : primeList) {
                isPrime = true;
                if (num % prime == 0) {// 说明不是素数
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeList.add(num);
            }
        }
        return primeList.stream().mapToInt(x -> x).toArray();
    }
}
