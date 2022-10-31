package Grammar.multiThread.Synchronization;

import Common.Utils.UTFactory;
import DataStructure.list.Nodelj;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/21 16:33
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 发令枪问题
 * 百米赛跑，4名运动员选手到达场地等待裁判口令，裁判一声口令，选手听到后同时起跑，当所有选手到达终点，裁判进行汇总排名
 * @blogURL
 */
public class StartingGun {

    public static void main(String[] args) {
        StartingGun sg = new StartingGun();
        sg.Competition(4);
    }

    public void Competition(int AthletesNum) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        final CountDownLatch begin = new CountDownLatch(1); // attention 此处统一发令，因此为1
        final CountDownLatch end = new CountDownLatch(AthletesNum);

        for (int i = 0; i < AthletesNum; i++) {
            Runnable r = new Runnable() {
                @Override
                @SneakyThrows
                public void run() {
                    System.out.println("选手" + Thread.currentThread().getName() + "正在等待裁判发布口令");
                    begin.await();
                    System.out.println("选手" + Thread.currentThread().getName() + "已接受裁判口令");
                    Thread.sleep((long) (Math.random() * 6_000));
                    System.out.println("选手" + Thread.currentThread().getName() + "到达终点");
                    end.countDown();
                }
            };
            threadPool.execute(r);
        }

        try {
            Thread.sleep((long) (Math.random() * 3_000));
            System.out.println("裁判" + Thread.currentThread().getName() + "即将发布口令");
            begin.countDown();
            Thread.sleep(3_000);
            System.out.println("裁判" + Thread.currentThread().getName() + "已发送口令，正在等待所有选手到达终点");
            end.await();
            System.out.println("所有选手都到达终点");
            System.out.println("裁判" + Thread.currentThread().getName() + "汇总成绩排名");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadPool.shutdown();
    }
}
