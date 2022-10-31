package DataStructure.arrayRelevant.arrayOps;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/7/28
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，
 * 其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
 * 编写一个算法来重建这个队列，使其符合要求。
 * <p>
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * <p>
 * 解题思路：
 * 对输入数组的身高排序（倒叙）
 * 身高的相同，基于人数排序（正序）
 */
public class BuildTeamByTall {

    public int[][] solution(int[][] array) {

        if (array == null || array.length == 0) {
            return new int[0][0];
        }
        /* Arrays.sort(array, new Comparator<int[]>() {
            
            public int compare(int[] x1, int[] x2) {
                if (x1[0] != x2[0]) {
                    return x2[0] - x1[0];
                }
                return x1[1] - x2[1];
            }
        });*/

        Arrays.sort(array, (x1, x2) -> { // lambda grammar: 使用lambda表达式简化排序代码
            // 身高按照降序排列 x[0]
            if (x1[0] != x2[0]) {
                return x2[0] - x1[0];
            }
            // 位置按照升序排列 x[1]
            return x1[1] - x2[1];
        });
        //System.out.println(Arrays.deepToString(array));// print grammar: 矩阵的打印，不可打印数组，Arrays.deepToString

        List<int[]> list = new LinkedList<>();
        for (int[] p : array) {
            list.add(p[1], p);
        }

        return list.toArray(new int[array.length][]);
    }

    public int[][] solution1(int[][] array) {

        if (array == null || array.length == 0) {
            return new int[0][0];
        }
        //使用lambda表达式简化代码

        //Arrays.sort(array, (x1, x2) -> x2[0] - x1[0]);
        Arrays.sort(array, (x1, x2) -> {
            if (x1[0] != x2[0]) {
                return x2[0] - x1[0]; // 消除了身高的因素
            }
            return x1[1] - x2[1];
        });
        //System.out.println(Arrays.deepToString(array));

       /* for (int i = 1; i < array.length; i++) {
            int h = i;
            int[] temp = array[i];
            while (temp[1] != h && h >= 0) {
                array[h] = array[h - 1];
                h--;
            }
            array[h] = temp;
            System.out.println(Arrays.deepToString(array));
        }*/
        for (int i = 1; i < array.length; i++) {
            int h = i;
            int[] temp = array[i];
            while (temp[1] != h) {
                array[h] = array[h - 1];
                h--;
            }
            array[temp[1]] = temp;
            //System.out.println(Arrays.deepToString(array));
        }
        // sort一定是稳定的排序
        //Arrays.sort(array, (x1, x2) -> x2[1] - x1[1]);
        return array;
    }
}
