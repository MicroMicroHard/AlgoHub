package DataStructure.arrayRelevant.doublePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/20
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 3数之和
 * 给定一个数 target，在一维数组中，找出某 3 个数相加得 target。
 * 要求一：如果存在这个 3 个数，返回true，反则返回false。
 * 要求二：返回所有的 3 数之和的组合
 * 要求三：返回所有的 3 数之和在数组中原位置的组合
 */

public class ThreeSum implements FindValueinArray {

    TwoSum twoSum = new TwoSum();

    //要求一：判断是否存在这样的三个数，存在返回true，否则返回false。
    public boolean existMethod(int[] array, int target) {
        if (array == null || array.length <= 2) {
            return false;
        }
        int[] newarray = Arrays.copyOf(array, array.length);
        Arrays.sort(newarray);

        for (int i = 0; i < newarray.length; i++) {
            if (twoSum.TwoSumPart(newarray, target - array[i], i + 1, array.length - 1)) {
                return true;
            }
            /*int target = value - j;
            // attention：不指定 左右指针 容易错
            if (find2Value.existMethod(array, target)) {
                return true;
            }*/
        }
        return false;
    }

    
    public List<int[]> getValues(int[] array, int target) {
        if (array == null || array.length <= 2) {
            return null;
        }
        int[] arraycopy = Arrays.copyOf(array, array.length);
        Arrays.sort(arraycopy);
        List<int[]> lists = new ArrayList<>();
        for (int i = 0; i < arraycopy.length; i++) {
            int u = arraycopy[i];
            arraycopy[i] = Integer.MIN_VALUE;
            int subtarget = target - u;
            List<int[]> list = twoSum.getValues(arraycopy, subtarget);
            if (list != null) {
                for (int j = 0; j < list.size(); j++) {
                    lists.add(new int[]{u, list.get(j)[0], list.get(j)[1]});
                }
            }
            // arraycopy[i] = u;
        }
        return lists.size() == 0 ? null : lists;
    }

    
    public List getPositions(int[] array, int target) {
        return null;
    }

    //要求二：返回这三个数在数组中的位置
    public int[] getValuePosition(int[] array, int value) {
        if (array == null || array.length <= 2) {
            return new int[]{};
        }
        int[] a = {-1, -1, -1};
        int[] b;
        int[] sd;
        for (int i = 0; i < array.length; i++) {
            a[0] = i;
            sd = Arrays.copyOf(array, array.length);
            //防重复选值
            sd[i] = Integer.MIN_VALUE;
            if (twoSum.existMethod(array, value - array[i])) {
                //b = f.getValuePosition(sd, value - array[i]);
                //a[1] = b[0];
                //a[2] = b[1];
                return a;
            }
        }
        //查找失败
        a[0] = -1;
        return a;
    }
}
