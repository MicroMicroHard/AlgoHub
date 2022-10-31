package DataStructure.sort.innerSort.innerSortImpl;

import Common.Utils.UTFactory;
import org.junit.Test;
import DataStructure.sort.innerSort.ArraySortINTF;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-14 22:13
 * @author—Email micromicrohard@outlook.com
 * @description 神奇排序
 * @blogURL
 */
public class AmazingSort implements ArraySortINTF {

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
        int length = array.length;
        // 实现一：
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (array[i] < array[j]) {
                    swap(array, i, j);
                }
            }
        }
        // 实现二：
        /*for (int i = 1; i < length; i++) {
            if (array[0] < array[i]) {
                swap(array, 0, i);
            }
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    swap(array, i, j);
                }
            }
        }*/
    }
}
