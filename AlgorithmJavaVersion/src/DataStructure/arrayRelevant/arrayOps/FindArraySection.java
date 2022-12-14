package DataStructure.arrayRelevant.arrayOps;

import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/1/5
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 查找给定值的数组区间
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 时间复杂度要求： O(log n)
 * <p>
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */

public class FindArraySection {

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

    public int[] Method(int[] array, int value) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        int left = searchIndex(array, value, 0);
        int right = searchIndex(array, value, 1);
        return new int[]{left, right};
    }

    /**
     * @param array
     * @param value
     * @param pos   0：查找左边界，1：查找右边界
     * @return 边界值
     */
    private int searchIndex(int[] array, int value, int pos) {
        int left = 0;
        int right = array.length - 1;
        int last = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < value) {
                left = mid + 1;
            } else if (array[mid] > value) {
                right = mid - 1;
            } else {
                last = mid;
                if (pos == 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return last;
    }
}
