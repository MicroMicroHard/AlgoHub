package UnitTest.DataStructureTest.stackHeapQueueTest.stackTest.monotonousStackTest;

import DataStructure.heapStackQueue.stack.monotonousStack.GetMinValueByRemoveK;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/1/24
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://leetcode-cn.com/problems/remove-k-digits/
 * @description 移掉 K 位数字
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * input：num = "1432219", k = 3
 * output："1219"
 * <p>
 * input：num = "10200", k = 1
 * output："200"
 * <p>
 * input：num = "10", k = 2
 * output："0"
 */

public class GetMinValueByRemoveKTest {

    @Test
    public void testGetMinValueByRemoveK() {
        test(new GetMinValueByRemoveK());
    }

    public void test(GetMinValueByRemoveK removeK) {
        String answer = removeK.removeKDigits(demo01, k3);
        assert answer.equals(target01);
        answer = removeK.removeKDigits(demo02, k1);
        assert answer.equals(target02);
        answer = removeK.removeKDigits(demo03, k1);
        assert answer.equals(target03);
        answer = removeK.removeKDigits(demo04, k3);
        assert answer.equals(target04);
    }

    int k3 = 3;
    String demo01 = "1432219";
    String target01 = "1219";

    int k1 = 1;
    String demo02 = "10";
    String target02 = "0";

    String demo03 = "100";
    String target03 = "0";

    String demo04 = "08761jcxeu800";
    String target04 = "";
}
