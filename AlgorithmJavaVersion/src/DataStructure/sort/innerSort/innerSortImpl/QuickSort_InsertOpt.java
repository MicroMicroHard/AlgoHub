package DataStructure.sort.innerSort.innerSortImpl;

import Common.Utils.UTFactory;
import org.junit.Test;
import DataStructure.sort.innerSort.ArraySortINTF;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-3-23 下午12:08:37
 * @author—Email micromicrohard@outlook.com
 * @description 采用插入法来优化快速排序
 * @URL
 */
public class QuickSort_InsertOpt implements ArraySortINTF {

    InsertSort insertionsort = new InsertSort();

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
        //边界判空
        if (!check(array)) {
            return;
        }
        // 默认k为3
        quicksortOpsSimplex(array, 0, array.length - 1, 8);
    }

    public int[] quicksortOpsSimplex(int[] sortNum, int left, int right, int k) {

        //定位变量
        int mid = left;
        int temp = 0;
        if (right - left + 1 <= k) {
            insertionsort.insertionSort(sortNum, left, right);
            return sortNum;
        }
        if (left < right) {
            //从左到右寻找比标杆小的元素，依次与mid交换
            for (int i = left + 1; i <= right; i++) {
                if (sortNum[i] < sortNum[left]) {
                    mid++;
                    temp = sortNum[mid];
                    sortNum[mid] = sortNum[i];
                    sortNum[i] = temp;
                }
            }
            //最后一个比对元素跟标杆元素交换
            temp = sortNum[mid];
            sortNum[mid] = sortNum[left];
            sortNum[left] = temp;

            //递归
            quicksortOpsSimplex(sortNum, left, mid - 1, k);
            quicksortOpsSimplex(sortNum, mid + 1, right, k);
        }
        return sortNum;
    }
}
