package Grammar.multiThread.AlternatePrint;

import lombok.SneakyThrows;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/21 15:51
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 交替打印
 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行?
 * @blogURL
 */
public class AlternatePrint_Join extends Thread {

    public static void main(String[] args) throws InterruptedException {
        AlternatePrint_Join a1 = new AlternatePrint_Join("a1");
        AlternatePrint_Join a2 = new AlternatePrint_Join("a2");
        AlternatePrint_Join a3 = new AlternatePrint_Join("a3");

        a1.start();
        a1.join();
        a2.start();
        a2.join();
        a3.start();
        a3.join();
    }

    public AlternatePrint_Join(String name) {
        setName(name);
    }

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(1_000);
        // grammar join方法会等待当前线程全部执行完，才开始下一个线程
        for (int i = 0; i < 5; i++) {
            System.out.println("i am " + this.currentThread().getName());
        }
        System.out.println("-------------");
    }
}
