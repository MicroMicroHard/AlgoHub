package DataStructure.arrayRelevant.doublePoint;

import Top100.DoublePoint;
import Common.Utils.ArrayTools;

import java.util.*;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/20
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 2数之和
 * 给定一个数 target，在一维数组中，找出某 2 个数相加得 target 的 所有组合。
 * <p>
 * 方法一：使用map，类似与前缀和 {@link TwoSum_Position#existMethodWithMap}
 * 方法二：双指针 {@link TwoSum_Position#existMethod}
 */
public class TwoSum_Position implements DoublePoint {

    // 方法一：如果存在这个两个数，返回true，反则返回false。
    public int[][] existMethodWithMap(int[] array, int target) {
        if (array == null || array.length <= 1) {
            return null;
        }
        Map<Integer, Boolean> existMap = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();

        for (int j : array) {
            // 防重复
            if (existMap.getOrDefault(j, false)) {
                continue;
            }
            if (existMap.getOrDefault((target - j), false)) {
                list.add(new ArrayList<Integer>() {{
                    this.add(j);
                    this.add(target - j);
                }});
            }
            existMap.put(j, true);
        }
        return list.size() == 0 ? new int[][]{} : ArrayTools.ListSort(list);
    }

    // 方法二
    public int[][] existMethod(int[] array, int target) {

        if (array == null || array.length <= 1) {
            return null;
        }
        int[] newarray = Arrays.copyOf(array, array.length);
        Arrays.sort(newarray);

        List<List<Integer>> list = TwoSumPart(newarray, target, 0, array.length - 1);
        return list.size() == 0 ? new int[][]{} : ArrayTools.ListSort(list);
    }

    public List<List<Integer>> TwoSumPart(int[] array, int target, int left, int right) {
        if (array == null || array.length < 2 || right > array.length - 1 || left < 0 || left > right) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        while (left < right) {
            if (array[left] + array[right] == target) {
                int finalLeft = left;
                int finalRight = right;
                list.add(new ArrayList<Integer>() {{
                    this.add(array[finalLeft]);
                    this.add(array[finalRight]);
                }});
            }

            if (array[left] + array[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return list;
    }
}
