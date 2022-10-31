package Algorithm.backtrack;

import Common.Utils.ArrayTools;
import Top100.CombinationAndPermutation;
import Top100.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/14
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 组合数组中的数之和为指定值  --- 换零钱的递归做法
 * 给定数组 array=[1,3,6,8,5] 和 给定的目标值 target=9
 * 数组可以无限重复的选择，最终给出符合target的序列
 * 比如符合给定数组和目标值的序列为：
 * [
 * [1,1,1,6],
 * [1,8],
 * [3,6],
 * [1,3,5],
 * [1,1,1,1,5]]
 * [1,1,1,1,1,1,1,1,1]]
 * [1,1,3,1,3]]
 * [3,3,3]
 * ]
 */
public class CombinationNum_BackTrack implements CombinationAndPermutation, BackTrack {

    List<List<Integer>> list_all;
    List<Integer> list_temp;
    int sum;
    int[] array;

    public int[][] Solution(int[] array, int target) {

        if (array == null || array.length == 0) {
            return null;
        }
        list_all = new ArrayList<>();
        list_temp = new ArrayList<>();

        //为防止生成结果中出现重复的值，比如：[1,1,1,3]、[1,1,1,3]
        Arrays.sort(array);
        this.array = array;
        this.sum = 0;
        roll(0, target);
        //list_all = list_all.stream().sorted(Comparator.comparing(ArrayList::size)).collect(Collectors.toList());
        return ArrayTools.ListSort(list_all);
    }

    private void roll(int depth, int target) {
        if (sum == target) {
            list_all.add(new ArrayList<>(list_temp));
            return;
        }
        if (sum > target) {
            return;
        }
        //Tips:为了防止重复，允许重复选取自身，但是不可以选择前面的元素
        for (int i = depth; i < this.array.length; i++) {
            sum += array[i];
            list_temp.add(array[i]);
            roll(i, target);
            list_temp.remove(list_temp.size() - 1);
            sum -= array[i];
        }
    }
}
