package DataStructure.sort.innerSort.innerSortImpl;

import Common.Utils.UTFactory;
import org.junit.Test;
import DataStructure.sort.innerSort.ArraySortINTF;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-7-19 上午11:55:48
 * @author—Email micromicrohard@outlook.com
 * @description 快速排序  双向快排
 * <p>
 * 双向快排：
 * 1.设高低指针，低指针从左往右找大于标杆的元素，高指针找小的
 * 2.交换高低指针所指向的元素
 * 3.交换标杆和低指针所指向的元素
 * 4.依次递归
 * 注意事项：
 * 1）发生两次数值交换
 * 2）left, right, lowPosition, highPosition, mid,交换需注意
 */

public class QuickSort_Duplex implements ArraySortINTF {

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
        if (check(array)) {
            quickSortDuplexing(array, 0, array.length - 1);
        }
    }

    //双向快排
    public int[] quickSortDuplexing(int[] array, int left, int right) {

        //记录双向指针
        int lowPosition = left;
        int highPosition = right;

        if (left < right) {
            while (lowPosition < highPosition) {
                /**
                 * attention：两个while必须有一个=，不然会导致死循环
                 *
                 * tips004:下方两个while循环可以互相换顺序，
                 * 但是如果是从小到大排序，"="号必须给high
                 * 但是如果是从大到小排序，"="号必须给low
                 */
                //高指针从右往左找小于标杆的元素
                while ((lowPosition < highPosition) && (array[highPosition] >= array[left])) {
                    highPosition--;
                }
                //低指针从左往右找大于标杆的元素
                while ((lowPosition < highPosition) && (array[lowPosition] < array[left])) {
                    lowPosition++;
                }
                //高低值，交换元素，此处if可以不写
                if (lowPosition < highPosition) {
                    swap(array, lowPosition, highPosition);
                }
            }
            //中位数与标杆，交换元素
            if (lowPosition != left) {
                swap(array, lowPosition, left);
            }
            //递归，循环到此处，lowPosition==highPosition，所以递归的边界写low或者high都可以
            quickSortDuplexing(array, left, lowPosition - 1);
            quickSortDuplexing(array, highPosition + 1, right);
        }
        return array;
    }
}
