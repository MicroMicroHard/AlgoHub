package DataStructure.sort.innerSort.innerSortImpl;

import Common.Utils.UTFactory;
import org.junit.Test;
import DataStructure.sort.innerSort.ArraySortINTF;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-3-23 12:09:48
 * @author-Email micromicrohard@outlook.com
 * @description 基数排序
 */
public class RadixSort implements ArraySortINTF {

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

    
    public void sortMethod(int[] array) {
        //检查
        if (!check(array)) {
            return;
        }
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp = array[i] > 0 ? array[i] : -array[i];
            if (max < temp) {
                max = temp;
            }
        }
        int d = String.valueOf(max).length();
        radixsort(array, d, 10);
    }

    public void radixsort(int[] array, int d, int radix) {
        int radixtemp = 1;
        int[][] radixbucket = new int[radix][array.length];
        int[] radixpoint = new int[radix];
        int temp = 0;
        for (int loopcount = 0; loopcount <= d; loopcount++) {
            for (int i = 0; i < array.length; i++) {
                temp = (array[i] / radixtemp) % radix;
                radixbucket[temp][radixpoint[temp]] = array[i];
                radixpoint[temp]++;
            }
            int bucketcount = 0;
            for (int i = 0; i < radix; i++) {
                int j = 0;
                while (radixpoint[i] != 0) {
                    array[bucketcount++] = radixbucket[i][j++];
                    radixpoint[i]--;
                }
            }
            radixtemp *= radix;
        }
    }
}