package Algorithm.backtrack;

import Top100.BackTrack;

import java.util.*;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-8-23 上午09:56:39
 * @author—Email micromicrohard@outlook.com
 * @description 数组全排列  只加一把锁
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入1：1、2、3
 * 输出1：[1,2,3]、[1,3,2]、[2,1,3]、[2,3,1]、[3,1,2]、[3,2,1]
 * <p>
 * 输入2：nums = [1,1,2]
 * 输出2：[1,1,2]、[1,2,1]、[2,1,1]]
 * @attation 1.返回所有不重复的全排列。
 * 2.循环处i = depth
 */

public class ArrayCombination_SingleLock extends ArrayCombination implements BackTrack {

    List<List<Integer>> list_all;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        list_all = new LinkedList<>();
        Arrays.sort(nums);
        //放置一个 existMap，用于统计在当前层，是否访问过 nums[i]
        roll(nums, new ArrayList<>(), new HashMap<>());
        return list_all;
    }

    public void roll(int[] nums, List list_temp, Map existMap) {
        if (list_temp.size() == nums.length) {
            list_all.add(new ArrayList<>(list_temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (existMap.containsKey(i)) {
                continue;
            }
            // Tips: 判断 i和i-1的关系
            if (i > 0 && nums[i] == nums[i - 1] && existMap.containsKey(i - 1)) {
                continue;
            }
            existMap.put(i, true);
            list_temp.add(nums[i]);
            roll(nums, list_temp, existMap);
            list_temp.remove(list_temp.size() - 1);
            existMap.remove(i);
        }
    }
}
