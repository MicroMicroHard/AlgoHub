package Algorithm.math.game;

import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/6/14 23:59
 * @author—Email micromicrohard@outlook.com
 * @description N倍率 股票
 * @blogURL
 */

public class FinancialLeverage {

    // 起始价格
    int begin = 100;
    // 展示小数点后几位
    int position = 2;

    //原始股价数组
    double[][] origin;
    //做多股价数组
    double[][] origin_long_2;
    double[][] origin_long_3;
    //做空股价数组
    double[] origin_short_2;
    double[] origin_short_3;

    // 股市变化
    double[] change_up1 = {5.2, -3.1, -2.2, 2, 1.9, 0.2, -0.1, 2.3, 3.6, -1.2, 4.5, -2.3, 7, 15, 22, 4, 5};
    double[] change_up2 = {15.2, -13.1, -12.2, 12, 11.9, 10.2, -0.1, 12.3, 13.6, -11.2, 4.5, -12.3, 4, 5,};
    double[] change_up3 = {6, 5, 5, -7, -5, 5, 3, -2, 3, -2, -4, -8, 3, -4, 3, -2, -4, -8, 3, 3, -2, 3, -2, -4, -8, 3, 3, 3, -2, -4, -8, 3, 3, -2, -4, -8, 3, -8, 3, -2, -9, -2, 2,};
    double[] change_up4 = {5.2, -3.1, -12.2, 12, 1.9, 5.2, -4, 22, 5, -10.1, 12.3, 3.6, -11.2, 7, 15, -4.5, 12.3,};
    double[][] change_up = {
            {5, 5, 5, 5, -4, -4, -4, -4},
            //{-3, 4, -4, 5, -5, 6, -6, 7},
            //{4, -4, 5, -5, 6, -6, 7, -7},
    };


    @Test
    public void Method() {
        origin = new double[change_up.length][];
        origin_long_2 = new double[change_up.length][];
        origin_long_3 = new double[change_up.length][];

        for (int i = 0; i < change_up.length; i++) {
            for (int j = 0; j < change_up[i].length; j++) {
                change_up[i][j] = change_up[i][j] / 100;
            }
            origin[i] = new double[change_up[i].length + 1];
            origin_long_2[i] = new double[change_up[i].length + 1];
            origin_long_3[i] = new double[change_up[i].length + 1];
        }


        for (int i = 0; i < change_up.length; i++) {
            origin[i][0] = begin;
            origin_long_2[i][0] = begin;
            origin_long_3[i][0] = begin;
        }


        for (int i = 0; i < change_up.length; i++) {
            for (int j = 0; j < change_up[i].length; j++) {
                origin[i][j + 1] = origin[i][j] * (1 + change_up[i][j]);
                origin_long_2[i][j + 1] = origin_long_2[i][j] * (1 + change_up[i][j] * 2);
                origin_long_3[i][j + 1] = origin_long_3[i][j] * (1 + change_up[i][j] * 3);
            }
        }

        for (int j = 0; j < origin.length; j++) {
            System.out.println("------------------------------------------");
            System.out.println("原价变化：");
            for (int i = 0; i < origin[j].length; i++) {
                System.out.printf("%" + position + "f--", origin[j][i]);
            }
            System.out.println();

            System.out.println("2倍变化：");
            for (int i = 0; i < origin_long_2[j].length; i++) {
                System.out.printf("%" + position + "f--", origin_long_2[j][i]);
            }
            System.out.println();

            System.out.println("3倍变化：");
            for (int i = 0; i < origin_long_3[j].length; i++) {
                System.out.printf("%" + position + "f--", origin_long_3[j][i]);
            }
            System.out.println();
        }
    }
}
