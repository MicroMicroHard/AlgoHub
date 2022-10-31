package DataStructure.heapStackQueue.heap;

import DataStructure.heapStackQueue.Heaplj;
import Common.Utils.ArrayTools;
import Common.Utils.UTFactory;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liujun
 * @version 1.0
 * @date 2022/4/17 18:23
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 堆的基本用法
 * @blogURL 链表实现
 */

public class LinkedHeaplj implements Heaplj {

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

    // 堆的测试用例
    public boolean Method(int[] array) {
        if (array == null || array.length == 0) {
            return true;
        }
        int[] arrayCopy = Arrays.copyOfRange(array, 0, array.length);
        Arrays.sort(arrayCopy);
        int[] heapArray = new int[array.length];
        assert this.empty();
        for (int j : array) {
            this.push(j);
        }
        for (int i = 0; i < array.length; i++) {
            heapArray[i] = this.pop();
        }
        ArrayTools.IntArrayEquals(arrayCopy, heapArray);
        assert this.empty();
        return true;
    }

    
    public void push(int value) {

    }

    
    public int pop() {
        return 0;
    }

    
    public int peek() {
        return 0;
    }

    
    public boolean empty() {
        return false;
    }

    
    public int getRealSize() {
        return 0;
    }

    
    public int getMaxSize() {
        return 0;
    }

    
    public void resize() {

    }
}
