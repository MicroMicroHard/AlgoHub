package Algorithm.dynamic;

import java.util.Arrays;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/7/14
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 数字变换 升级版
 * 给定一个正整数 x, 可以对x做如下变换:
 * 给定两个参数: k,t。 任意时刻你可以对你的数执行下面两个步骤之一：
 * 1.X = X - i(1 <= i <= t)
 * 2.若 X 为 k 的倍数，X = X / k
 * 则至少对x做多少次变换可以变换为1
 */

public class NumChangeOps {

    // todo
    public int GetChangeTime(int num, int k, int t) {
        int[] answer = new int[num + 1];
        answer[0] = 1;
        answer[1] = 0;
        // -10 是防止后续加和出现益处
        Arrays.fill(answer, Integer.MAX_VALUE - 10);
        for (int i = 2; i <= num; i++) {
            for (int j = i; j >= i - t && j >= 0; j--) {
                answer[i] = Math.min(answer[i], answer[j] + 1);
            }
            if (i % k == 0) {
                answer[i] = Math.min(answer[i], answer[i / k]) + 1;
            }
        }
        return answer[num];
    }
}
