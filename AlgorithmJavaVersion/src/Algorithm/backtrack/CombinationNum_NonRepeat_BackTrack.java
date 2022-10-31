package Algorithm.backtrack;

import Common.Utils.ArrayTools;
import Top100.CombinationAndPermutation;
import Top100.BackTrack;

import java.util.*;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/1/14
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 组合数组中的数之和为指定值  --- 换零钱的递归做法
 * 给定数组 array=[1,3,6,8,5] 和 给定的目标值 target=9
 * 数组 不可以 无限重复 的选择，最终给出符合target的序列
 * 比如符合给定数组和目标值的序列为：
 * [
 * [1,8],
 * [3,6],
 * [1,3,5],
 * ]
 */

public class CombinationNum_NonRepeat_BackTrack implements CombinationAndPermutation, BackTrack {

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

        //Tips 1_1: sort 为防止出现重复：比如原数组[1,7,1]组合8,不排序会出现：[1,7],[7,1]
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
        // Tips 1_2: set 为防止出现重复:比如原数组[1,7,1]组合8,不使用set会出现：[1,7],[1,7]
        Set<Integer> set = new HashSet<>();
        // Tips 1_3: 为什么 i=depth 而不是 i=0 ？为了防止重复选取数字，比如原数组[1,7,1]组合8,使用i = 0会出现：[1,1,1,1,1,1,1]
        for (int i = depth; i < array.length; i++) {
            if (set.contains(array[i])) {
                continue;
            }
            set.add(array[i]);
            sum += array[i];
            list_temp.add(array[i]);
            //Tips 1_4: 同1_3,防止出现重复选取数字，和CombinationNum_BackTrack 的区别在于组合中是否有重复的数出现，通过此处控制不回头选择
            roll(i + 1, target);
            list_temp.remove(list_temp.size() - 1);
            sum -= array[i];
        }
    }
}
