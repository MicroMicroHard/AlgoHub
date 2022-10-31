package DataStructure.sort.innerSort.innerSortImpl;

import Algorithm.comprehensive.backpack.Goods;
import DataStructure.sort.innerSort.ArraySortINTF;
import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-14 22:15
 * @author—Email micromicrohard@outlook.com
 * @description 插入排序
 * 1、数组的插入排序
 * 2、链表的插入排序
 * @blogURL
 */
public class InsertSort implements ArraySortINTF {

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

    //====实现1
    public void sortMethod1(int[] array) {
        //输入检查
        if (!check(array)) {
            return;
        }
        int temp = 0;
        //外部循环从1开始，直到最后
        for (int i = 1; i < array.length; i++) {
            //内部循环从外部位置遍历到0
            int j = i;
            temp = array[i];
            while ((j > 0) && (temp < array[j - 1])) {
                array[j] = array[j - 1];
                j--;
            }
            if (j != i) {
                //因为在循环内j已经被减过。所以此处赋值给j，而不是j-1
                array[j] = temp;
            }
        }
    }

    //====实现2
    public void sortMethod(int[] array) {
        //输入检查
        if (!check(array)) {
            return;
        }
        int temp = 0;
        //外部循环从1开始，直到最后
        for (int i = 1; i < array.length; i++) {
            //内部循环从外部位置遍历到0，类似冒泡交换
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }


    //插入排序（指定范围的插入排序）
    public void insertionSort(int[] array, int left, int right) {
        //越界检查
        if (!check(array)) {
            return;
        }
        int temp = 0;
        //外部循环从1开始，直到最后
        for (int i = left + 1; i <= right; i++) {
            //内部循环从外部位置遍历到0
            int j = i;
            temp = array[i];
            while ((j > left) && (temp < array[j - 1])) {
                array[j] = array[j - 1];
                j--;
            }
            if (j != i) {
                //因为在循环内j已经被减过。所以此处赋值给j，而不是j-1
                array[j] = temp;
            }
        }
    }

    public static void sort4Good(Goods[] array) {
        //输入检查
        if (array == null || array.length <= 1) {
            return;
        }
        Goods temp;
        //外部循环从1开始，直到最后
        for (int i = 1; i < array.length; i++) {
            //内部循环从外部位置遍历到0
            int j = i;
            temp = array[i];
            while ((j > 0) && (temp.getPw() < array[j - 1].getPw())) {
                array[j] = array[j - 1];
                j--;
            }
            if (j != i) {
                //因为在循环内j已经被减过。所以此处赋值给j，而不是j-1
                array[j] = temp;
            }
        }
    }
}
