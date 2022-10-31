package Common.ThreadPool;

import Common.MidwareConn.DBConn.MYSQLConn.UTDataEntity;
import Common.Utils.UTFactory;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/7/20 00:34
 * @author—Email micromicrohard@outlook.com
 * @description
 * @blogURL
 */

public class ThreadPoollj {

    //1.使用工厂类获取线程池对象
    public ExecutorService es = Executors.newCachedThreadPool(new ThreadFactory() {
        int n = 1;


        public Thread newThread(@NotNull Runnable r) {
            return new Thread(r, "自定义的线程名称" + n++);
        }
    });

    public void SubmitTask(Class<?> clazz, List<UTDataEntity> list, CountDownLatch cdAnswer) {
        //2.提交任务
        es.submit(new MyRunnable(clazz, list, cdAnswer));
    }
}

class MyRunnable implements Runnable {
    Class<?> clazz;
    List<UTDataEntity> list;
    CountDownLatch cdAnswer;

    public MyRunnable(Class<?> clazz, List<UTDataEntity> list, CountDownLatch cdAnswer) {
        this.clazz = clazz;
        this.list = list;
        this.cdAnswer = cdAnswer;
    }


    public void run() {
        //获取线程的名称，打印一句话
        try {
            UTFactory.DoUnitTest(clazz, list);
            cdAnswer.countDown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
