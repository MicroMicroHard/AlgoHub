package Algorithm.math;

import Top100.Mathlj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-8-2 上午10:30:01
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst/article/details/98177653
 * @description 水仙花数
 * 水仙花数（Narcissistic number）也被称为超完全数字不变数（pluperfect digital invariant, PPDI）、
 * 自恋数、自幂数、阿姆斯壮数或阿姆斯特朗数（Armstrong number），
 * 水仙花数是指一个 3 位数，它的每个位上的数字的 3次幂之和等于它本身（例如：1^3 + 5^3+ 3^3 = 153）。
 * <p>
 * 水仙花数又称阿姆斯特朗数。
 * 三位的水仙花数共有4个：153，370，371，407；
 * 四位的四叶玫瑰数共有3个：1634，8208，9474；
 * 五位的五角星数共有3个：54748，92727，93084；
 * 六位的六合数只有1个：548834；
 * 七位的北斗七星数共有4个：1741725，4210818，9800817，9926315；
 * 八位的八仙数共有3个：24678050，24678051，88593477
 */
public class Narcissistic implements Mathlj {

    public void narcissistic() {
        List<Integer> list = new ArrayList<Integer>();
        int value;
        int temp;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    value = i * 100 + j * 10 + k;
                    temp = i * i * i + j * j * j + k * k * k;
                    if (value >= 100 && value == temp) {
                        list.add(i * 100 + j * 10 + k);
                    }
                }
            }
        }
		/*for (int i : list) {
			System.out.println(i);
		}*/
    }

    public void narcissisticOptic() {
        int[] cubic = new int[10];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < cubic.length; i++) {
            cubic[i] = i * i * i;
        }
        int value;
        for (int i = 0; i < cubic.length; i++) {
            for (int j = i; j < cubic.length; j++) {
                for (int k = j; k < cubic.length; k++) {
                    value = cubic[i] + cubic[j] + cubic[k];
                    char[] c = Integer.toString(value).toCharArray();
                    int cmp = i ^ j ^ k;
                    for (int l = 0; l < c.length; l++) {
                        cmp ^= Integer.parseInt(c[l] + "");
                    }
                    if (cmp == 0 && value < 1000 && value > 100) {
                        if (value == i * 100 + j * 10 + k || value == i * 100 + k * 10 + j || value == j * 100 + i * 10 + k
                                || value == j * 100 + k * 10 + i || value == k * 100 + j * 10 + i || value == k * 100 + i * 10 + j) {
                            list.add(value);
                        }
                    }
                }
            }
        }
		/*for (int i : list) {
			System.out.println(i);
		}*/
    }
}
