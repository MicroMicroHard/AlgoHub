package Grammar.multiThread.Synchronization;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/21 16:33
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 发令枪问题 循环发令枪
 * 能够重复使用的发令枪：CyclicBarrier
 * @blogURL
 */
public class StartingGun_Cycle {
    public static void main(String[] args) {
        int threadNum = 5;
        CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 最后完成任务");
            }
        });
        for (int i = 0; i < threadNum; i++) {
            new TaskThread(barrier).start();
        }
    }
}

class TaskThread extends Thread {
    CyclicBarrier barrier;

    public TaskThread(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(4_000);
        System.out.println(getName() + " 到达栅栏 A");
        barrier.await();

        System.out.println(getName() + " 冲破栅栏 A");
        Thread.sleep(8_000);
        System.out.println(getName() + " 到达栅栏 B");

        barrier.await();
        System.out.println(getName() + " 冲破栅栏 B");
    }
}
