package DataStructure.arrayRelevant.xor;

import Common.Constant.C;
import Common.Utils.UTFactory;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/9/1
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 找数字
 * 在一组数中，其他每个数都只出现一次，仅有一个数，出现了两次，找出这个数。
 */
public class FindNum_Once_Double implements FindNum {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误测试案例
    public void TestDoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    public int Solution(int[] array) {
        if (array == null || array.length == 0) {
            return C.ErrorNum;
        }
        int num = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int count = 0;
        for (int x : array) {
            count = map.get(x) == null ? 1 : map.get(x) + 1;
            map.put(x, count);
            if (count == 2) {
                return x;
            }
        }
        return num;
    }

    /*public int method1(int[] array) {
        int one = 0, two = 0, three = 0;
        for (int x : array) {
            two ^= (x & one);
            one ^= x;
            three = one & two;
            //刷新 one 和 two
            one &= ~three;
            two &= ~three;
        }
        return two;
    }*/
}
