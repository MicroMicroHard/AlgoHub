package DataStructure.sort.innerSort.innerSortImpl;

import Common.Utils.UTFactory;
import org.junit.Test;
import DataStructure.sort.innerSort.ArraySortINTF;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/6/21
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 堆排序
 */
public class HeapSort2 implements ArraySortINTF {

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
        //输入检查
        if (!check(array)) {
            return;
        }
        int length = array.length - 1;
        for (int i = 0; i < length; i++) {
            heapify_big(array, length - i);
            swap(array, 0, length - i);
        }
    }

    //小顶堆
    public void heapify_big(int[] array, int border) {

        /**
         * 最后一个非叶子结点的index见 {@link HeapSort#sortMethod},java grammar: @link的用法：类名#方法或者属性
         * 参考blog：https://blog.csdn.net/qq_27093465/article/details/59121608
         */
        for (int root = (border - 1) / 2; root >= 0; root--) {
            int child = 2 * root + 1;
            // attention:边界值的 等于 需要特别注意
            if (child + 1 <= border) {
                child = array[child] > array[child + 1] ? child : child + 1;
            }
            if (child <= border && array[child] > array[root]) {
                swap(array, child, root);
            }
        }
    }
}
