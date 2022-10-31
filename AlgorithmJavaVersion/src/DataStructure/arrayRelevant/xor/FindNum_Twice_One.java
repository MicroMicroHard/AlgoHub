package DataStructure.arrayRelevant.xor;

import Common.Constant.C;
import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/8/31
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 找数字
 * 在一组数中，每个数都出现了两次，但是出现了唯独一个数，仅出现一次，找出这个数
 */
public class FindNum_Twice_One implements FindNum {

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

    
    public int Solution(int[] array) {
        if (array == null || array.length == 0) {
            return C.ErrorNum;
        }
        int value = 0;
        for (int i = 0; i < array.length; i++) {
            value ^= array[i];
        }
        return value;
    }
}
