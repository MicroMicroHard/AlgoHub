package DataStructure.sort.innerSort.innerSortImpl;

import Common.Utils.UTFactory;
import org.junit.Test;
import DataStructure.sort.innerSort.ArraySortINTF;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-3-23 12:09:20
 * @author-Email micromicrohard@outlook.com
 * @description 归并排序
 * @URL
 */
public class MergeSort implements ArraySortINTF {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    
    public void sortMethod(int[] array) {
        if (!check(array)) {
            return;
        }
        int[] temp = new int[array.length];
        mergesort(array, 0, array.length - 1, temp);
    }

    public void mergesort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergesort(array, left, mid, temp);
            mergesort(array, mid + 1, right, temp);
            sort(array, left, mid, right, temp);
        }
    }

    public void sort(int[] array, int left, int mid, int right, int[] temp) {

        int l = left;
        int r = mid + 1;
        int j = left;
        while (l <= mid && r <= right) {
            if (array[l] > array[r]) {
                temp[j++] = array[r++];
            } else {
                temp[j++] = array[l++];
            }
        }
        while (l <= mid) {
            temp[j++] = array[l++];
        }
        while (r <= right) {
            temp[j++] = array[r++];
        }
        if (right + 1 - left >= 0)
            System.arraycopy(temp, left, array, left, right + 1 - left);
    }
}
