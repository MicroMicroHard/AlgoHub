package Grammar.multiThread.AlternatePrint;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/21 15:51
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 交替打印
 * @blogURL
 */
public class AlternatePrint_Lock_Synchronized {
    public static int[] array = {
            1, 2, 3, 4, 5,
            6, 7, 8, 9, 0,
            11, 12, 13, 14, 15,
            16, 17, 18, 19, 20,
    };
    public static String[] alpha = {
            "a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o",
            "p", "q", "r", "s", "t",
    };
    public static volatile int count = 0; // grammar 加上volatile后效果不一样
    public static volatile int alphaCount = 0;
    public static volatile int arrayCount = 0;
    static Lock lock = new ReentrantLock();
    public static final Object object = new Object();

    public static void main(String[] args) throws Exception {
        AlternatePrint_Lock_Synchronized a = new AlternatePrint_Lock_Synchronized();
        for (int i = 0; i < 10; i++) {
            a.func();
            Thread.sleep(3_000);
            count = 0;
            alphaCount = 0;
            arrayCount = 0;
            System.out.println("------------------");
        }
    }

    public void func() {
        Thread alphaThread = new Thread() {
            @SneakyThrows // grammar :SneakyThrows 代替 try catch
            @Override
            public void run() {
                int u, u1 = 0;
                while (alphaCount < alpha.length) {
                    //lock.lock();
                    synchronized (object) {
                        if (count % 2 != 0 && alphaCount < alpha.length) {
                            u = count + 1;
                            count = u;
                            System.out.print(alpha[alphaCount] + " ");
                            if (count % 10 == 0) {
                                System.out.println();
                            }
                            u1 = alphaCount + 1;
                            alphaCount = u1;
                        }
                    }
                    //lock.unlock();
                }
            }
        };

        Thread arrayThread = new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                int u, u1 = 0;
                while (arrayCount < array.length) {
                    //lock.lock(); // attention  lock.lock()放在 if (count % 2 != 0) 内，仍然会产生类似DDL的问题
                    synchronized (object) {
                        if (count % 2 == 0 && arrayCount < array.length) {
                            u = count + 1;
                            count = u;
                            System.out.print(array[arrayCount] + " ");
                            u1 = arrayCount + 1;
                            arrayCount = u1;
                        }
                    }
                    //lock.unlock();
                }
            }
        };
        // 各自开5个线程，相当于一个线程池来共同执行
        for (int i = 0; i < 5; i++) {
            Thread a = new Thread(alphaThread);
            a.start();
            Thread b = new Thread(arrayThread);
            b.start();
        }
    }
}
