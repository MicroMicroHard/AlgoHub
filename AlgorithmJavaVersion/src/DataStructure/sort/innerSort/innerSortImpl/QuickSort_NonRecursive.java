package DataStructure.sort.innerSort.innerSortImpl;

import Common.Utils.UTFactory;
import DataStructure.sort.innerSort.ArraySortINTF;
import org.junit.Test;

import java.util.Stack;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-7-19 上午11:55:48
 * @author—Email micromicrohard@outlook.com
 * @description 快速排序 单向快排 非递归方式
 */

public class QuickSort_NonRecursive implements ArraySortINTF {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误测试案例
    public void TestDoubleTrack() throws Exception {
        String input = "4,3,2,1";
        String output = "1,2,3,4";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    //单向快排：

    public void sortMethod(int[] array) {
        //边界判空
        if (!check(array)) {
            return;
        }
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, array.length - 1});

        while (!stack.isEmpty()) {
            int[] head = stack.pop();
            int index = nonRecursive(array, head[0], head[1]);
            if (index == -1) {
                continue;
            }
            if (head[0] <= index - 1) {
                stack.push(new int[]{head[0], index - 1});
            }
            if (index + 1 <= head[1]) {
                stack.push(new int[]{index + 1, head[1]});
            }
        }
    }

    // 返回 最终交换的中间index
    public int nonRecursive(int[] array, int left, int right) {
        //left：即时左边界，也是用于做比较的标杆变量
        int midPosition = left;
        if (left > right) {
            return -1;
        }

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
        return midPosition;
    }
}
