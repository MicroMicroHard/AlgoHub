package Algorithm.backtrack;

import Top100.BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-8-23 上午09:56:39
 * @author—Email micromicrohard@outlook.com
 * @description 字符串全排列
 * 将输入字符串按照全排列的方式打印输出
 * <p>
 * 输入：1、2、3
 * 输出：[1,2,3]、[1,3,2]、[2,1,3]、[2,3,1]、[3,1,2]、[3,2,1]
 * @attation 1.Java字符数组如何输出:2种方式。
 * 2.循环处i = depth
 */

public class StringCombination implements BackTrack {

    List<String> list;
    String[] answer;

    public String[] Permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        char[] c = s.toCharArray();
        list = new ArrayList<>();

        roll(c, 0);
        answer = list.toArray(new String[0]);
        return answer;
    }

    public void roll(char[] c, int depth) {

        //边界值判断
        if (depth == c.length - 1) {
            list.add(String.valueOf(c));
            return;
        }
        //注意：此处i = depth。i之前的元素已经有序，只对后续元素进行全排列
        for (int i = depth; i < c.length; i++) {
            //数组元素交换
            char ch_temp = c[i];
            c[i] = c[depth];
            c[depth] = ch_temp;
            //递归
            roll(c, depth + 1);
            //数组元素交换回去
            ch_temp = c[i];
            c[i] = c[depth];
            c[depth] = ch_temp;
        }
    }
}
