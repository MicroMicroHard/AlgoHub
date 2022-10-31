package DataStructure.arrayRelevant.arrayApply;

import java.util.*;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/1
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 解析地址：https://leetcode-cn.com/problems/merge-intervals/
 */

public class MergeSection {

    public int[][] merge(int[][] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        // 按照第一位从小到大排序
        Arrays.sort(array, Comparator.comparingInt(x -> x[0]));
        int cnt = array.length;

        for (int i = 1; i < array.length; i++) {
            int[] pre = array[i - 1];
            int[] cur = array[i];

            // 发生merge的情况
            if (pre[1] <= cur[0]) {
                continue;
            }
            merge(array, i, cur, pre);
            // 发生一次merge，实际数量减少1
            cnt--;
            clear(array, i - 1);
        }

        int[][] answerArr = new int[cnt][];
        cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if (check(array, i)) {
                answerArr[cnt] = array[i];
                cnt++;
            }
        }
        return answerArr;
    }

    public int[][] merge1(int[][] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        // 按照第一位从小到大排序
        Arrays.sort(array, Comparator.comparingInt(x -> x[0]));

        Stack<int[]> stack = new Stack();
        stack.push(array[0]);
        for (int i = 1; i < array.length; i++) {
            int[] peek = stack.peek();
            if (array[i][0] >= peek[0] && array[i][0] <= peek[1]) {
                stack.pop();
                stack.add(merge(peek, array[i]));
            } else {
                stack.add(array[i]);
            }
        }

        int[][] answerArr = new int[stack.size()][];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answerArr[i] = stack.pop();
        }
        return answerArr;
    }

    public int[] merge(int[] a, int[] b) {
        int head = Math.min(a[0], b[0]);
        int tail = Math.max(a[1], b[1]);
        return new int[]{head, tail};
    }

    public void merge(int[][] array, int index, int[] a, int[] b) {
        int head = Math.min(a[0], b[0]);
        int tail = Math.max(a[1], b[1]);
        array[index][0] = head;
        array[index][1] = tail;
    }

    public void clear(int[][] array, int index) {
        array[index][0] = Integer.MIN_VALUE;
        array[index][1] = Integer.MIN_VALUE;
    }

    public boolean check(int[][] array, int index) {
        if (array[index][0] == Integer.MIN_VALUE && array[index][1] == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }
}
