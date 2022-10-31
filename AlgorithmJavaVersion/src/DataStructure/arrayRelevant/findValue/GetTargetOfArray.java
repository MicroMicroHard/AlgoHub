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
 * @description 求有序数组旋转后的指定值的索引
 *  * 一个有序数组，比如[1,2,3,4,5,6,7],后面部分被替换到前面，比如[5,6,7,1,2,3,4],找出替换后的数组的最大值
 *  * 一个有序数组，比如[1,2,3,4,5,6,7],后面部分被替换到前面，比如[5,6,7,1,2,3,4],找出替换后的数组的最小值
 *  * 一个有序数组，比如[1,2,3,4,5,6,7],后面部分被替换到前面，比如[5,6,7,1,2,3,4],找出替换后的数组的给定值
 * @blogURL
 */
public class GetTargetOfArray {

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

    public int Method(int[] array, int target) {
        if (array == null || array.length == 0) {
            return C.ErrorNum;
        }
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            //边界值
            /*if (array[left] == target) {
                return left;
            }
            if (array[right] == target) {
                return right;
            }*/
            // todo  为什么不可以使用left和right
            if (array[mid] == target) {
                return mid;
            }

            if (array[left] <= array[mid]) {
                if (array[left] <= target && target <= array[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (array[mid] <= target && target <= array[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return C.ErrorNum;
    }

    public int getTargetValueMethod(int[] array, int target) {
        if (array == null || array.length == 0) {
            return C.ErrorNum;
        }
        return getTarget(array, target, 0, array.length - 1);
    }

    public int getTarget(int[] array, int value, int left, int right) {
        int answer = C.ErrorNum;
        if (left >= right) {
            return answer;
        }
        int mid = (left + right) / 2;
        if (array[right] == value) {
            return right;
        } else if (value < array[left]) {
            answer = getTarget(array, value, mid, right);
        } else {
            answer = getTarget(array, value, left, mid);
        }
        return answer;
    }
}
