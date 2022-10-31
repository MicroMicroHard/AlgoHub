package DataStructure.sort.innerSort.innerSortImpl;


import DataStructure.sort.innerSort.ArraySortINTF;
import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-14 22:13
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 冒泡排序
 * @blogURL
 */
public class BubbleSort implements ArraySortINTF {

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

    //冒泡排序    参数：int类型数组，对数组进行排序
    public void sortMethod(int[] array) {
        if (!check(array)) {
            return;
        }
        //当某次内部排序无数据交换发送时，flag不变，则此时数组有序，无需再循环对比
        boolean flag = false;
        int length = array.length;
        //外部循环：循环元素个数减一次，因为最后一次默认有序
        for (int i = 0; i < length - 1; i++) {
            //内部循环：外部循环i次，可以确定i个元素已经有序，因此剩余n-i个无序元素，
            //内部循环次数为元素个数n减去外部循环次数i,又因为i和i+1对比，因此防止的对比越界，需再减一
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    swap(array, j, j + 1);
                }
            }
            if (!flag) {
                return;
            }
        }
    }
}
