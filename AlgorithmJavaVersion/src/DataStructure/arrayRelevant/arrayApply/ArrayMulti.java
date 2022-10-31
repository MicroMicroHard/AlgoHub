package DataStructure.arrayRelevant.arrayApply;


import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/12/20
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */
public class ArrayMulti {

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

    public int[] calMethod(int[] array) {

        if (array == null || array.length == 0) {
            return new int[]{};
        }
        // left
        int[] left = new int[array.length];
        left[0] = 1;
        for (int i = 1; i < array.length; i++) {
            left[i] = left[i - 1] * array[i - 1];
        }

        int right = array[array.length - 1];
        // 从右边第二个开始
        for (int i = array.length - 2; i >= 0; i--) {
            left[i] *= right;
            right *= array[i];
        }
        return left;
    }
}
