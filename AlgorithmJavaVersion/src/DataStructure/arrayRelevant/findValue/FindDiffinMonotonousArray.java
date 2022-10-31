package DataStructure.arrayRelevant.findValue;

/**
 * @author liujun
 * @version 1.0
 * @date 2020-01-08 14:01
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 数组单调递增然后单调递减，输出元素中不同的个数，
 * 要求：数组原址，不能改变数组元素和顺序，空间复杂度：O(1)
 * @blogURL
 */
public class FindDiffinMonotonousArray {

    public int find(int[] array) {

        int left = 0;
        int right = array.length - 1;

        int count = 0;
        int value = 0;
        int preValue = Integer.MIN_VALUE;

        //相当于在数组的两边，自底向上【从小到大】进行排序
        while (left <= right) {//此处最好是=，因为存在中间值未被记录的情况
            if (array[left] < array[right]) {
                value = array[left];
                left++;
            } else {
                value = array[right];
                right--;
            }
            if (value > preValue) {
                preValue = value;
                count++;
            }
        }
        return count;
    }
}
