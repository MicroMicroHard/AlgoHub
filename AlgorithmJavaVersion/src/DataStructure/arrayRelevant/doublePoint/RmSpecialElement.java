package DataStructure.arrayRelevant.doublePoint;

import java.util.Arrays;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/10/10
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 去除指定元素
 * 给定数组，去除指定元素，返回不含指定元素的数组
 */
public class RmSpecialElement implements RmElement {

    public int head = 0;
    public int tail = 0;

    //给定数组，去除指定元素，返回不含指定元素的数组
    public int[] method(int[] array, int key) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        head = 0;
        tail = 0;
        for (; tail < array.length; tail++) {
            if (array[tail] != key) {
                array[head] = array[tail];
                head++;
            }
        }
        return Arrays.copyOfRange(array, 0, head);
    }

    //给定数组，去除指定元素，返回剩余元素的个数
    public int method1(int[] array, int key) {
        method(array, key);
        return head;
    }

    /**
     * @param array
     * @return 去除指定元素后的数组，组成新的数组返回
     */
    
    public int[] getHandledArr(int[] array,int... key) {
        return new int[0];
    }

    /**
     * @param array
     * @return 不改变原有数组，返回不重复的个数
     */
    
    public int getHandledArrLen(int[] array,int... key) {
        return 0;
    }
}
