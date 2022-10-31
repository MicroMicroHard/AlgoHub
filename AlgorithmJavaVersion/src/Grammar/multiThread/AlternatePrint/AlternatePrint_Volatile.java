package Grammar.multiThread.AlternatePrint;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/21 15:51
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 交替打印
 * @blogURL
 */
public class AlternatePrint_Volatile {

    public static int[] array = {1, 2, 3, 4};
    public static String[] alpha = {"a", "b", "c", "d", "e",};
    public static volatile boolean alphaPrintFlag = false;

    public static void main(String[] args) {
        Thread alphaPrint = new Thread() {
            @Override
            public void run() {
                int count = 0;
                while (count < alpha.length) {
                    if (alphaPrintFlag) {
                        System.out.print(alpha[count] + " ");
                        //alphaPrintFlag = !alphaPrintFlag; // grammar :类似于++、取反都是非原子类操作，不可以运用到volatile变量
                        alphaPrintFlag = false;
                        count++;
                    }
                }
            }
        };


        Thread arrayPrint = new Thread() {
            @Override
            public void run() {
                int count = 0;
                while (count < array.length) {
                    if (!alphaPrintFlag) {
                        System.out.print(array[count] + " ");
                        alphaPrintFlag = true;
                        count++;
                    }
                }
            }
        };

        alphaPrint.start();
        arrayPrint.start();
    }
}
