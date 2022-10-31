package DataStructure.sort.innerSort;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-14 21:27
 * @author—Email micromicrohard@outlook.com
 * @description 所有排序算法的接口
 * 冒泡、选择、归并、插入
 * 计数、基数、桶排序、希尔
 * 堆排（初始化建堆模式、边排边整）
 * 快速（单向、双向、插排改进）
 */
public interface ArraySortINTF<T> {

    /**
     * 数组的排序
     *
     * @param array 输入一个无序数组，原址排序为一个有序的数组
     */
    void sortMethod(int[] array);

    default boolean check(int[] array) {
        if (array == null || array.length <= 1) {
            return false;
        }
        return true;
    }

    // 此处传递的是index，不是数组的value
    default void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /*
    java grammar:因为Java是值传递，又因为下列写法的作用范围只在当前闭包，所以下列写法不能达到数组中值交换的目的
    java grammar:@Deprecated 标记废弃的方法
    */
    @Deprecated
    default void swap(int value1, int value2) {
        int temp = value1;
        value1 = value2;
        value2 = temp;
    }
}
