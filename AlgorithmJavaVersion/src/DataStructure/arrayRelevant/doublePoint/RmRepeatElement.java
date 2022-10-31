package DataStructure.arrayRelevant.doublePoint;

import DataStructure.sort.innerSort.innerSortImpl.HeapSort2;

import java.util.Arrays;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/10/10
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 去除重复元素
 * 给定一个包含重复数字的数组，返回不重复的个数
 * 找出重复数组中不重复的个数
 */
public class RmRepeatElement implements RmElement {

    HeapSort2 hs = new HeapSort2();

    //给定一个包含重复数字的数组，返回不重复的个数
   /* public int method(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        head = 0;
        tail = 0;
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (array[head] == array[tail]) {
                tail++;
            } else {
                head++;
                int temp = array[head];
                array[head] = array[tail];
                array[tail] = temp;
                tail++;
            }
        }
        ans = array;
        return head + 1;
    }*/


    /**
     * @param array
     * @return 去除去除重复元素后的数组，组成新的数组返回
     */
    
    public int[] getHandledArr(int[] array, int... key) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int head = 0;
        int tail = 0;
        hs.sortMethod(array);
        for (; tail < array.length - 1; tail++) {
            if (array[tail] == array[tail + 1]) {
                tail++;
            } else {
                head++;
                int temp = array[tail + 1];
                array[tail + 1] = array[head];
                array[head] = temp;
                tail++;
            }
        }
        return Arrays.copyOfRange(array, 0, tail);
    }

    /**
     * @param array
     * @return 不改变原有数组，返回不重复的个数
     */
    
    public int getHandledArrLen(int[] array, int... key) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return 1;
        }
        int tail = 0;
        int count = 1;
        hs.sortMethod(array);
        for (; tail < array.length - 1; tail++) {
            if (array[tail] != array[tail + 1]) {
                count++;
            }
        }
        return count;
    }

}
