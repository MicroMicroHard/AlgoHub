package Algorithm.backtrack;

import Top100.BackTrack;

import java.util.*;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-8-23 上午09:56:39
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 数组全排列
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入1：1、2、3
 * 输出1：[1,2,3]、[1,3,2]、[2,1,3]、[2,3,1]、[3,1,2]、[3,2,1]
 * <p>
 * 输入2：nums = [1,1,2]
 * 输出2：[1,1,2]、[1,2,1]、[2,1,1]]
 * @attation 1.返回所有不重复的全排列。
 * 2.循环处i = depth
 */

public class ArrayCombination_WithMapArray extends ArrayCombination implements BackTrack {

    List<List<Integer>> list_all;
    List<Integer> list_temp;
    HashMap[] visitMapArray;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        list_all = new LinkedList<>();
        visitMapArray = new HashMap[nums.length];
        roll(0, nums);
        return list_all;
    }

    public void roll(int depth, int[] nums) {
        if (depth == nums.length) {
            list_temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list_temp.add(nums[i]);
            }
            list_all.add(new ArrayList<>(list_temp));
            return;
        }

        for (int i = depth; i < nums.length; i++) {

            if (visitMapArray[depth] != null && visitMapArray[depth].containsKey(nums[i])) {
                continue;
            }
            if (visitMapArray[depth] == null) {
                visitMapArray[depth] = new HashMap();
                visitMapArray[depth].put(nums[i], true);
            }
            if (!visitMapArray[depth].containsKey(nums[i])) {
                visitMapArray[depth].put(nums[i], true);
            }

            int temp = nums[i];
            nums[i] = nums[depth];
            nums[depth] = temp;

            roll(depth + 1, nums);

            temp = nums[i];
            nums[i] = nums[depth];
            nums[depth] = temp;
            for (int j = depth + 1; j < nums.length; j++) {
                visitMapArray[j] = null;
            }
        }
    }
}
