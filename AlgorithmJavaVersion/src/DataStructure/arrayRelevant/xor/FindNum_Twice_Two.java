package DataStructure.arrayRelevant.xor;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/8/31
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 找数字
 * 在一组数中，每个数都出现了两次，但是唯独有两个数，仅出现一次，找出这个数
 */
public class FindNum_Twice_Two {

    public int[] Solution(int[] array) {
        if (array == null || array.length == 0 || array.length % 2 == 1) {
            return new int[]{};
        }
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp ^= array[i];
        }

        /*int point = 1;
        for (int i = 0; i < 32; i++) {
            //从低位试探出不为0的那一位
            if ((temp & point) != 0) {
                break;
            }
            point <<= 1;
        }*/
        int point = temp & -temp;//代替上述for循环，二进制的负数就是七本身按位取反，末尾加一，相&就可以求出最右边的1

        int x = 0;
        int y = 0;
        for (int i = 0; i < array.length; i++) {
            //根据这一位区分两堆数组，分别求独立数
            if ((array[i] & point) == 0) {
                x ^= array[i];
            } else {
                y ^= array[i];
            }
        }
    /*    if (x == Integer.MIN_VALUE || y == Integer.MIN_VALUE) {
            return new int[]{};
        }
        x -= Integer.MIN_VALUE;
        y -= Integer.MIN_VALUE;*/
        if (x > y) {
            x = x + y;
            y = x - y;
            x = x - y;
        }
        int[] z = new int[]{x, y};
        return z;
    }
}
