package Algorithm.comprehensive.lss;

import Common.Utils.MathTools;
import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-30 00:08
 * @author—Email micromicrohard@outlook.com
 * @description 最大子段和 分治法
 * LargestSumOfSubSequence by divide
 * 给定一个数组，求这个数组的连续子数组中，最大的那一段的和
 * @blogURL
 */

public class LSS_Divide implements LSS {

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
    
    public int LargestSumOfSubSequenceMethod(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return divide(array, 0, array.length - 1);
    }

    public int divide(int[] array, int left, int right) {
        if (left < right) {//判断终止条件是left == right
            int mid = (left + right) / 2;
            int leftValue = divide(array, left, mid);
            int rightValue = divide(array, mid + 1, right);
            int midValue = mid(array, left, right);
            return MathTools.GetMostValue(false, leftValue, rightValue, midValue);
        }
        return array[left];
    }

    public int mid(int[] array, int left, int right) {
        int sumTemp = 0;
        int mid = (left + right) / 2;
        int sumBest = array[mid];//attention: 此处不可以写 sumBest = array[left] 或者 sumBest = 0
        int leftPoint = mid;
        int rightPoint = mid + 1;

        while (left <= leftPoint) {
            sumTemp += array[leftPoint];
            sumBest = Math.max(sumBest, sumTemp);
            leftPoint--;
        }
        sumTemp = sumBest;
        while (rightPoint <= right) {
            sumTemp += array[rightPoint];
            sumBest = Math.max(sumBest, sumTemp);
            rightPoint++;
        }
        return sumBest;
    }
}
