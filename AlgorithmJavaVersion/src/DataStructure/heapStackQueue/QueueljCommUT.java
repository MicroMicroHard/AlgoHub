package DataStructure.heapStackQueue;

import Common.Constant.C;
import Common.Utils.ReflectTools;
import Common.Utils.UTFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static Common.Utils.UTFactory.strTools;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-09 22:56
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 数组队列  循环队列
 */
public class QueueljCommUT {

    static String queueName;

    // 验证功能：用于全量测试
    public void test(String queueName) throws Exception {
        QueueljCommUT.queueName = strTools.GetCleanClassName(queueName);
        UTFactory.FullTest(QueueljCommUT.class.getName());
    }

    public void TestDoubleTrack(String queueName, String input, String output) throws Exception {
        QueueljCommUT.queueName = strTools.GetCleanClassName(queueName);
        UTFactory.DebugTest(QueueljCommUT.class.getName(), input, output);
    }

    public boolean QueueTestMethod(int[] queueData) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (queueData == null || queueData.length == 0) {
            return false;
        }
        Class<?> clazz = ReflectTools.className_ClazzMap.get(QueueljCommUT.queueName);
        if (clazz == null) {
            System.out.println("缺失Class,请补充：" + QueueljCommUT.queueName);
            return false;
        }
        // return (Queuelj) clazz.newInstance();
        Constructor<?> c = clazz.getConstructor(String.class);//获取有参构造
        int queueSize = queueData.length / 2;
        Queuelj queue = (Queuelj) c.newInstance(QueueljCommUT.queueName);

        // init test
        assert queue.empty();
        assert 0 == queue.getRealSize();
        assert queueSize == queue.getMaxSize();
        assert C.ErrorNum == queue.poll();
        assert C.ErrorNum == queue.peek();
        assert !queue.search(queueSize);

        for (int i = 0; i < queueData.length; i++) {
            if (i > queueSize) {
                break;
            }
            assert queue.offer(queueData[i]);
            assert !queue.empty();
        }
        // 跳出循环时发生扩容
        assert !queue.empty();
        assert queueSize + 1 == queue.getRealSize();
        assert queueSize * 2 == queue.getMaxSize();
        assert queueData[0] == queue.peek();
        assert queue.search(queueData[0]);
        assert !queue.empty();

        for (int i = queueSize + 1; i < queueData.length; i++) {
            assert queue.offer(queueData[i]);
            assert !queue.empty();
            assert i + 1 == queue.getRealSize();
        }

        // mid
        assert !queue.empty();
        assert queueData.length == queue.getRealSize();
        assert queueData[0] == queue.peek();
        assert queue.search(queueData[queueData.length - 1]);

        for (int queueDatum : queueData) {
            assert queueDatum == queue.poll();
        }
        // end
        assert queue.empty();
        assert 0 == queue.getRealSize();
        assert C.ErrorNum == queue.poll();
        assert C.ErrorNum == queue.peek();
        assert !queue.search(queueSize);
        return true;
    }
}
