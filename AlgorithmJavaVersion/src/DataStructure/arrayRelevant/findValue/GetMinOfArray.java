package DataStructure.arrayRelevant.findValue;

import Common.Constant.C;
import Common.Utils.UTFactory;
import DataStructure.list.Nodelj;
import org.junit.Test;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/10 16:58
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 求有序数组旋转后的最小值
 * * 一个有序数组，比如[1,2,3,4,5,6,7],后面部分被替换到前面，比如[5,6,7,1,2,3,4],找出替换后的数组的最大值
 * * 一个有序数组，比如[1,2,3,4,5,6,7],后面部分被替换到前面，比如[5,6,7,1,2,3,4],找出替换后的数组的最小值
 * * 一个有序数组，比如[1,2,3,4,5,6,7],后面部分被替换到前面，比如[5,6,7,1,2,3,4],找出替换后的数组的给定值
 * @blogURL
 */
public class GetMinOfArray {

    @Test // 验证功能：从数据库获取测试数据，用于单元测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误的测试案例
    public void DoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    public int Method(int[] array) {
        if (array == null || array.length == 0) {
            return C.ErrorNum;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (left + 1 == right) {
                return Math.min(array[left], array[right]);
            }
            int mid = (left + right) / 2;
            // 最大值是跟左边对比，最小值是跟右边对比
            if (array[right] < array[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[left];
    }

    public int getMinValueMethod(int[] array) {
        if (array == null || array.length == 0) {
            return C.ErrorNum;
        }
        int target = array[0];
        int minvalue = getMin(array, 0, array.length - 1);
        return Math.min(target, minvalue);
    }

    // arr必须是有序的
    private int getMin(int[] arr, int left, int right) {
        if (left > right) {
            return C.ErrorNum;
        }
        if (left == right || left + 1 == right) {
            return Math.min(arr[left], arr[right]);
        }
        int mid = (left + right) / 2;
        if (arr[left] < arr[mid]) {
            return getMin(arr, mid + 1, right);
        } else {
            return getMin(arr, left, mid);
        }
    }
}
