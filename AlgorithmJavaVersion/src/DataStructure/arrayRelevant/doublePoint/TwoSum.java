package DataStructure.arrayRelevant.doublePoint;

import Top100.DoublePoint;

import java.util.*;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/7/20
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 2数之和
 * 给定一个数 target，在一维数组中，找出某 2 个数相加得 target。
 * 方法一：使用map，类似与前缀和 {@link TwoSum#existMethodWithMap}
 * 方法二：双指针 {@link TwoSum#existMethod}
 * <p>
 * 要求一：如果存在这个 2 个数，返回true，反则返回false。
 * 要求二：返回存在的这 2 个值
 * 要求三：返回存在的这 2 个值在数组中的原位置
 * 要求四：返回所有的 2 数之和的组合
 * 要求五：返回所有的 2 数之和在数组中原位置的组合
 */
public class TwoSum {

    // 方法一：如果存在这个两个数，返回true，反则返回false。
    public boolean existMethodWithMap(int[] array, int target) {
        if (array == null || array.length <= 1) {
            return false;
        }
        Map<Integer, Boolean> existMap = new HashMap<>();
        for (int j : array) {
            if (existMap.getOrDefault((target - j), false)) {
                return true;
            }
            existMap.put(j, true);
        }
        return false;
    }

    // 方法二
    public boolean existMethod(int[] array, int target) {

        if (array == null || array.length <= 1) {
            return false;
        }
        int[] newarray = Arrays.copyOf(array, array.length);
        Arrays.sort(newarray);
        return TwoSumPart(newarray, target, 0, array.length - 1);
        /*
        while (left < right) {
            while ((left < right) && (newarray[left] + newarray[right] < target)) {
                left++;
            }
            while ((left < right) && (newarray[left] + newarray[right] > target)) {
                right--;
            }
            if ((left < right) && (newarray[left] + newarray[right] == target)) {
                return true;
            }
        }
        return false;*/
    }

    public boolean TwoSumPart(int[] array, int target, int left, int right) {
        if (array == null || array.length < 2 || right > array.length - 1 || left < 0 || left > right) {
            return false;
        }
        while (left < right) {
            if (array[left] + array[right] == target) {
                return true;
            } else if (array[left] + array[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }


    public List<int[]> getValues(int[] array, int target) {
        if (array == null || array.length <= 1) {
            return null;
        }
        int left = 0;
        int right = array.length - 1;
        int[] newarray = Arrays.copyOf(array, array.length);
        Arrays.sort(newarray);
        List<int[]> lists = new ArrayList<>();

        while (left < right) {
            while ((left < right) && (newarray[left] + newarray[right] < target)) {
                left++;
            }
            while ((left < right) && (newarray[left] + newarray[right] > target)) {
                right--;
            }
            if ((left < right) && (newarray[left] + newarray[right] == target)) {
                int[] a = new int[]{newarray[left], newarray[right]};
                lists.add(a);
                left++;
                right--;
            }
        }
        return lists.size() == 0 ? null : lists;
    }


    public List<int[]> getPositions(int[] array, int target) {

        return null;
    }

    //找出确认位置
    private int[] findPosition(int[] array, int value1, int value2) {
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value1) {
                p1 = i;
            }
            if (array[i] == value2) {
                p2 = i;
            }
        }
        if (p1 > p2) {
            int temp = p1;
            p1 = p2;
            p2 = temp;
        }
        return new int[]{p1, p2};
    }
}
