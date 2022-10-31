package DataStructure.arrayRelevant.doublePoint;

import Top100.DoublePoint;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/7/20
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 2数之和
 * 给定一个数 target，在一维数组中，找出某 2 个数相加得 target。
 * 返回所有的 2 数之和在数组中原位置的组合
 */

public class Find2ValueInArray_GetAllPosition1 implements FindValueinArray, DoublePoint {

    
    public boolean existMethod(int[] array, int target) {
        return false;
    }

    
    public List<int[]> getValues(int[] array, int target) {
        return null;
    }

    
    public List<int[]> getPositions(int[] array, int target) {

        if (!check(array)) {
            return null;
        }
        List<int[]> statistic_list = new LinkedList();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] + array[j] == target) {
                    statistic_list.add(new int[]{j, i});
                }
            }
        }
        return statistic_list;
    }
}
