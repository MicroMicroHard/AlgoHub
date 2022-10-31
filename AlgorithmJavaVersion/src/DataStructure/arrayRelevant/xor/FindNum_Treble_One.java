package DataStructure.arrayRelevant.xor;

import Common.Constant.C;
import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/8/31
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 找数字
 * 在一组数中，其他每个数都只出现三次，仅有一个数，出现了一次，找出这个数。
 * 参考博客：https://blog.csdn.net/yjw19901214/article/details/83416280
 */
public class FindNum_Treble_One implements FindNum {

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
        return imply1(array);
        // return imply2(array);
        // return imply3(array);
        // return imply4(array);
    }

    /* array中的所有数据，全部看成32位的二进制，
    当某个数出现三次，其在bit位上也出现三次，
    */
    public int imply1(int[] array) {
        //32字节
        int[] bit = new int[32];
        for (int i = 0; i < bit.length; i++) {
            for (int j : array) {
                //判断第 i 位是否位1
                int u = 1 & (j >> (31 - i));
                bit[i] += u;
            }
        }
        int sum = 0;
        for (int i = 0; i < bit.length; i++) {
            //注意此处两个表达式的顺序
            sum <<= 1;
            sum += bit[i] % 3;
        }
        return sum;
    }

    public int imply2(int[] array) {
        // 存储int 4*8=32每一位
        int[] arr = new int[32];
        for (int x : array) {
            for (int i = 0; i < 32; i++) {
                arr[i] += x & 1;
                x >>= 1;// 从低到高
            }
        }
        int res = 0, mod = 3;

        for (int i = 0; i < 32; i++) {
            res <<= 1;// 从高到低
            res += arr[31 - i] % mod;
        }
        return res;
    }

    public int imply3(int[] array) {
        int one = 0, two = 0;
        // {one, two}每三个状态一次转移
        // {0, 0} {1, 0} {0, 1} {0, 0}
        for (int x : array) {
            one = (one ^ x) & ~two;
            two = (two ^ x) & ~one;
        }
        return one;
    }

    public int imply4(int[] array) {
        int one = 0, two = 0, three = 0;
        for (int x : array) {
            two ^= (x & one);
            one ^= x;
            three = one & two;
            //刷新 one 和 two
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
