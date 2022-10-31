package Algorithm.backtrack;

import Top100.BackTrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-8-23 上午09:56:39
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 字符串全排列
 * 将输入字符串按照全排列的方式打印输出
 * <p>
 * 输入：1、2、3
 * 输出：[1,2,3]、[1,3,2]、[2,1,3]、[2,3,1]、[3,1,2]、[3,2,1]
 * @attation 1.Java字符数组如何输出:2种方式。
 * 2.循环处i = depth
 */

public class StringCombination_2 extends StringCombination implements BackTrack {

    List<String> list_all;
    List<Character> list_temp;
    String[] answer;

    public String[] Permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        char[] c = s.toCharArray();
        list_temp = new LinkedList<>();
        list_all = new LinkedList<>();
        roll(c, 0);
        answer = list_all.toArray(new String[0]);
        return answer;
    }

    public void roll(char[] c, int depth) {

        //边界值判断
        if (depth == c.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list_temp.size(); i++) {
                sb.append(list_temp.get(i));
            }
            list_all.add(sb.toString());
            return;
        }
        //注意：此处i = depth。i之前的元素已经有序，只对后续元素进行全排列
        for (int i = 0; i < c.length; i++) {
            if (list_temp.contains(c[i])) {
                continue;
            }
            //数组元素交换
            list_temp.add(c[i]);
            //递归
            roll(c, depth + 1);
            //数组元素交换回去
            list_temp.remove(list_temp.size() - 1);
        }
    }
}
