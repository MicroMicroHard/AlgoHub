package Algorithm.backtrack;

import Common.Utils.ArrayTools;
import Top100.CombinationAndPermutation;
import Top100.BackTrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/1/15
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 数组的连续积小于等于给定值的组合
 * 求出数组中连续数的积小于等于给定值的组合，前提是不使用for循环
 * 输入：{10, 5, 2, 6}，target：100
 * 输出：{
 * {10}, {10,5}, {10,5,2},
 * {5}, {5,2}, {5,2,6},
 * {2}, {2,6},
 * {6}
 * }
 */

public class CombinationPlus implements CombinationAndPermutation, BackTrack {

    List<List<Integer>> list_all;
    Deque<Integer> deque;
    int sum = 1;
    int target = 0;

    public int[][] Solution(int[] array, int target) {
        list_all = new ArrayList<>();
        deque = new LinkedList<>();
        this.target = target;
        roll(array, 0, 0);
        int[][] sortedArray = ArrayTools.ListSort(list_all);
        return sortedArray;
    }

    public void roll(int[] array, int left, int right) {
        if (right == array.length) {
            if (left < array.length && deque.size() >= 2) {
                deque.pollFirst();
                int u = deque.pollFirst();
                sum = u;
                deque.clear();
                deque.add(u);
                list_all.add(new LinkedList(deque));
                roll(array, left + 1, left + 2);
            }
            return;
        }
        if (array[right] == 0) {
            roll(array, right + 1, right + 1);
        }
        if (sum * array[right] > target) {
            if (deque.size() >= 1) {
                deque.pollFirst();
                int u = deque.pollFirst();
                sum = u;
                deque.clear();
                deque.add(u);
                list_all.add(new LinkedList(deque));
                roll(array, left + 1, left + 2);
            } else {
                roll(array, left, right + 1);
            }
        } else {
            sum *= array[right];
            deque.addLast(array[right]);
            list_all.add(new LinkedList(deque));
            roll(array, left, right + 1);
            sum /= array[right];
            deque.pollLast();
        }
    }
}
