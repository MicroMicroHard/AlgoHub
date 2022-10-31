package DataStructure.arrayRelevant.doublePoint;

import Top100.DoublePoint;

import java.util.*;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/20
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 2数之和
 * 给定一个数 target，在一维数组中，找出某 2 个数相加得 target 的 所有组合【包括重复的位置】，
 * 输出这些组合的下标。
 */
public class TwoSum_Position_Repeat implements DoublePoint {

    public List<int[]> getPositionsIndexMethod(int[] array, int target) {

        if (array == null || array.length == 0) {
            return null;
        }
        Map<Integer, List<Integer>> value_positionList_map = new TreeMap<>();

        List<int[]> statistic_list = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (value_positionList_map.containsKey(array[i])) {
                List<Integer> list = value_positionList_map.get(array[i]);
                list.add(i);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(i);
                value_positionList_map.put(array[i], list);
            }
        }

        for (Integer value : value_positionList_map.keySet()) {
            List<Integer> list = value_positionList_map.get(value);
            if (list == null) {
                continue;
            }

            int want = target - value;
            if (!value_positionList_map.containsKey(want) || value_positionList_map.get(want) == null) {
                continue;
            }
            List<Integer> list1 = value_positionList_map.get(want);

            // 所有重合的组合
            for (Integer o : list) {
                for (Integer item : list1) {
                    int[] r = item > o ? new int[]{o, item} : new int[]{item, o};
                    statistic_list.add(r);
                }
            }
            value_positionList_map.put(value, null);
            value_positionList_map.put(want, null);
        }
        return statistic_list;
    }
}
