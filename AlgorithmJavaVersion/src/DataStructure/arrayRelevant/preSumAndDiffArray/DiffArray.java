package DataStructure.arrayRelevant.preSumAndDiffArray;

import Top100.PreSumAndDiffArray;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/9/8
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 差分数组
 * 链接：https://mp.weixin.qq.com/s/9L6lz0XDZ9gi-d_iPrSs8Q
 */
public class DiffArray implements PreSumAndDiffArray {

    int[] prefixSumArray;

    //差分数组:数组前后两者之差
    public int[] buildDiffArray(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int[] diffArray = new int[array.length];
        diffArray[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            diffArray[i] = array[i] - array[i - 1];
        }
        return diffArray;
    }

    //差分数组:通过差分数组获取原数组
    public int[] getDiffOrigin(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        int[] originArray = new int[array.length];
        originArray[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            originArray[i] = array[i] + originArray[i - 1];
        }
        return originArray;
    }

    // 闭区间 [begin, end]
    public void diffINC(int[] array, int begin, int end, int value) {
        if (begin >= 0) {
            array[begin] += value;
        }
        if (end + 1 < array.length) {
            array[end + 1] -= value;
        }
    }
}
