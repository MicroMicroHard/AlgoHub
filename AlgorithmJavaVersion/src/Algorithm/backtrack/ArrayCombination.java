package Algorithm.backtrack;

import Top100.BackTrack;

import java.util.*;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-8-23 上午09:56:39
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 数组全排列 每层加锁
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入1：1、2、3
 * 输出1：[1,2,3]、[1,3,2]、[2,1,3]、[2,3,1]、[3,1,2]、[3,2,1]
 * <p>
 * 输入2：nums = [1,1,2]
 * 输出2：[1,1,2]、[1,2,1]、[2,1,1]]
 * @attation 1.返回所有不重复的全排列。
 * 2.循环处i = depth
 */

public class ArrayCombination implements BackTrack {

    List<List<Integer>> list_all;
    List<Integer> list_temp;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        list_all = new LinkedList<>();
        roll(0, nums);
        return list_all;
    }

    public void roll(int depth, int[] nums) {
        if (depth == nums.length) {
            list_temp = new ArrayList<>();
            for (int num : nums) {
                list_temp.add(num);
            }
            list_all.add(new ArrayList<>(list_temp));
            return;
        }

        // 每一层放置一个 existMap，用于统计在当前层，是否访问过 nums[i]
        Map<Integer, Boolean> existMap = new HashMap<>();
        for (int i = depth; i < nums.length; i++) {

            // Tips:为什么锁 nums[i] 而不是 i
            if (existMap.containsKey(nums[i])) {
                continue;
            }
            existMap.put(nums[i], true);

            swap(nums, depth, i);
            roll(depth + 1, nums);
            swap(nums, depth, i);
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
