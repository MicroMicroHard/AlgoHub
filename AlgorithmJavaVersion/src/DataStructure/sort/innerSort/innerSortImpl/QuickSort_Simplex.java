package DataStructure.sort.innerSort.innerSortImpl;

import Common.Utils.UTFactory;
import org.junit.Test;
import DataStructure.sort.innerSort.ArraySortINTF;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-7-19 上午11:55:48
 * @author—Email micromicrohard@outlook.com
 * @description 快速排序 单向快排
 * 单向快排：
 * 1.同时设两个指针，一个指针代表中间定位mid,另一个指针i从左到右寻找比标杆小的元素(隐藏在for循环中)，
 * 2.当i找到比标杆元素小的，发生交换，
 * 3.最后一个比对元素跟标杆元素交换
 * 4.比对结束，由中间结点划分两部分，递归重复1.2。
 * 注意事项：
 * 1）mid先加一，再交换
 * 2）为什么是left<right作为判定条件？
 * 因为递归调用quick_sort_duplexing(A, left, low-1)时，
 * 存在left>low-1使程序出错
 */

public class QuickSort_Simplex implements ArraySortINTF {

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

    //单向快排：
    
    public void sortMethod(int[] array) {
        //边界判空
        if (!check(array)) {
            return;
        }
        quickSortSimplex(array, 0, array.length - 1);
    }

    public int[] quickSortSimplex(int[] array, int left, int right) {
        //left：即时左边界，也是用于做比较的标杆变量
        int midPosition = left;
        if (left < right) {
            //从左到右寻找比标杆小的元素，依次与mid交换
            for (int cur = left + 1; cur <= right; cur++) {
                if (array[cur] < array[left]) {
                    midPosition++;
                    swap(array, midPosition, cur);
                }
            }
            //最后一个比对元素跟标杆元素交换
            if (midPosition != left) {
                swap(array, left, midPosition);
            }
            //递归
            quickSortSimplex(array, left, midPosition - 1);
            quickSortSimplex(array, midPosition + 1, right);
        }
        return array;
    }
}
