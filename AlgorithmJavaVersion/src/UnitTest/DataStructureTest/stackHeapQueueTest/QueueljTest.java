package UnitTest.DataStructureTest.stackHeapQueueTest;

import DataStructure.heapStackQueue.Queuelj;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/11/17
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description Queuelj 测试案例
 */
public class QueueljTest {

    public void testQueue(Queuelj queuelj) {

        // * 1、测试元素入队【分别测试正常、临界、异常值】
        // * 2、测试元素出队【分别测试正常、临界、异常值】
        // * 3、测试弹出队首元素（不删除）【分别测试正常、临界、异常值】
        // * 4、测试队列判空【分别测试正常、临界、异常值】
        // * 5、测试查找值【分别测试正常、临界、异常值】
        // * 6、测试获取真实队列长度【分别测试正常、临界、异常值】
        // * 7、测试获取最大队列长度【分别测试正常、临界、异常值】
        // * 8、测试队列扩容【分别测试正常、临界、异常值】
        //init
        assert queuelj.getRealSize() == 0;
        assert queuelj.getMaxSize() == 32;
        assert queuelj.empty();
        assert queuelj.peek() == Integer.MIN_VALUE;
        assert !queuelj.search(3);
        assert queuelj.poll() == Integer.MIN_VALUE;
        //insert
        for (int i = 0; i < 33; i++) {
            queuelj.offer(i);
            if (i == 9) {
                assert queuelj.getRealSize() == 10;
                assert queuelj.getMaxSize() == 32;
                assert !queuelj.empty();
                assert queuelj.peek() == 0;
                assert queuelj.search(3);
            }
        }
        assert queuelj.getRealSize() == 33;
        assert queuelj.getMaxSize() == 64;
        assert !queuelj.empty();
        assert queuelj.peek() == 0;
        assert queuelj.search(3);
        assert queuelj.poll() == 0;
        //final
        assert queuelj.offer(1234);
        assert queuelj.getRealSize() == 33;
        assert queuelj.peek() == 1;
        assert queuelj.poll() == 1;

        for (int i = 2; i <= 20; i++) {
            queuelj.poll();
        }
        for (int i = 33; i <= 63 + 15; i++) {
            queuelj.offer(i);
        }
        assert queuelj.getRealSize() == 59;
        assert queuelj.getMaxSize() == 64;
        assert !queuelj.search(3);
        assert queuelj.search(33);
        assert !queuelj.empty();
        assert queuelj.peek() == 21;
        assert queuelj.poll() == 21;

        for (int i = 79; i <= 79+20; i++) {
            queuelj.offer(i);
        }
        assert queuelj.getRealSize() == 79;
        assert queuelj.getMaxSize() == 128;
        assert !queuelj.search(3);
        assert queuelj.search(33);
        assert !queuelj.empty();
        assert queuelj.peek() == 22;
        assert queuelj.poll() == 22;
    }
}
