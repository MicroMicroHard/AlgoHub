package Algorithm.dynamic;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/7/14
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 数字变换
 * 给定一个正整数 x, 可以对x做如下变换:
 * x 为奇数时，x => x-1 or x => x+1
 * x 为偶数时，x => x/2
 * 则至少对x做多少次变换可以变换为1
 */

public class NumChange {

    public int GetChangeTime(int num) {
        int[] answer = new int[num + 1];
        answer[0] = 1;
        answer[1] = 0;
        for (int i = 2; i <= num; i++) {
            if ((num & 1) == 1) {
                answer[i] = Math.min(answer[i - 1] + 1, answer[(i + 1) / 2] + 2);
            } else {
                answer[i] = answer[i / 2] + 1;
            }
        }
        return answer[num];
    }
}
