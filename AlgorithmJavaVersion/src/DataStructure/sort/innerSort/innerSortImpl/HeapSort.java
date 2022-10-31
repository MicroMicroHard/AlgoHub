package DataStructure.sort.innerSort.innerSortImpl;

import Common.Utils.UTFactory;
import org.junit.Test;
import DataStructure.sort.innerSort.ArraySortINTF;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-14 22:14
 * @author—Email micromicrohard@outlook.com
 * @description 堆排序
 * 设计思路 1)初试化建堆，建完后，堆顶即最大/最小元素。
 * 2)交换堆顶和数组末尾元素，然后针对剩余的n-1个元素，对堆顶元素进行调整即可，
 * 3)重复2),直到所有元素有序。
 * <p>
 * 如何将数组调整为大顶堆
 * 1、初始化建堆只需要对二叉树的非叶子节点调用，从数组二分之n处分别跟左右孩子对比，
 * 发生交换，交换后的孩子，进一步跟它的左右孩子发生对比，直到数组对比达到边界,
 * 至此，二分之n这个二叉树有序(大顶堆)。O(n)
 * 2、不断缩小范围，自底向上，从右到左，从二分之n循环到顶(1)，
 * 至此，整个数组/二叉树有序(大顶堆)。
 * @blogURL
 */
public class HeapSort implements ArraySortINTF {

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
        if (!check(array)) {
            return;
        }
        /**
         * tips:长度为n的数组，最后一个非叶子结点的index是: (n-1)/2
         * 推导：index为k的非叶子结点的左右孩子index分别是：2k+1、2k+2，所以为了求出确切的k值，index为n的孩子结点的父节点是：(n-1)/2
         * 应用：array最后一个叶子结点的index：n=len(array)-1，最后一个非叶子结点的index：（len(array)-1-1）/2 = len(array)/2-1
         */
        //初试化建堆,数组的左孩子/2 一定是父节点
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify_big(array, i, array.length - 1);
        }
        //交换堆顶和数组末尾元素，循环整堆,注意边界值
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify_big(array, 0, i - 1);
        }
    }

    //整堆函数——小顶堆
    public void heapify_small(int[] array, int root, int border) {

        //边界检查
        if (border >= array.length || border <= 0) {
            return;
        }
        //左孩子，最大值标记
        int child = root * 2 + 1;
        //越界判断：如果左孩子存在
        if (child > border) {
            return;
        }
        //如果右孩子存在，左右孩子对比，找最小值
        if (child + 1 <= border) {
            child = array[child] > array[child + 1] ? child + 1 : child;
        }
        //对比父节点和孩子结点，找最大值,发生交换,并递归其最大值孩子结点
        if (array[child] < array[root]) {
            swap(array, root, child);
            heapify_small(array, child, border);
        }
    }

    /**
     * @param array  整堆函数——大顶堆
     * @param root   父节点的位置
     * @param border 边界（包含）
     */
    public void heapify_big(int[] array, int root, int border) {

        //边界检查
        if (border >= array.length || border <= 0) {
            return;
        }
        //左孩子，最大值标记
        int child = root * 2 + 1;
        //越界判断：如果左孩子存在
        if (child > border) {
            return;
        }
        //如果右孩子存在
        if (child + 1 <= border) {
            //左右孩子对比，找最大值
            child = array[child] > array[child + 1] ? child : child + 1;
        }
        //对比父节点和孩子结点，找最大值,发生交换,并递归其最大值孩子结点
        if (array[child] > array[root]) {
            swap(array, child, root);
            heapify_big(array, child, border);
        }
    }
}
