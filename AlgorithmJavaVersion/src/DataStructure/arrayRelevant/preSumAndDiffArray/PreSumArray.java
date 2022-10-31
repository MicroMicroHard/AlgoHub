package DataStructure.arrayRelevant.preSumAndDiffArray;

import Top100.PreSumAndDiffArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/9/8
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 前缀和、差分数组
 * 前缀和链接：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484488&idx=1&sn=848f76e86fce722e70e265d0c6f84dc3&chksm=9bd7fa40aca07356a6f16db72f5a56529044b1bdb2dcce2de4efe59e0338f0c313de682aef29&scene=21#wechat_redirect
 * 差分数组链接：https://mp.weixin.qq.com/s/9L6lz0XDZ9gi-d_iPrSs8Q
 */

public class PreSumArray implements PreSumAndDiffArray {

    //前缀和:返回闭区间[i,j]之间的累加和
    public int prefixSumCount(int[] array, int i, int j) {
        int[] prefixSumArray = PrefixSumArray(array);
        j = Math.min(j, (prefixSumArray.length - 1));
        i = Math.max(i, 0);
        // 因为是闭区间，所以是 prefixSumArray[j] - prefixSumArray[i - 1]
        return i == 0 ? prefixSumArray[j] : prefixSumArray[j] - prefixSumArray[i - 1];
    }

    // 构建前缀和数组
    public int[] PrefixSumArray(int[] array) {
        if (array == null && array.length == 0) {
            return null;
        }
        int[] prefixSumArray = new int[array.length];
        prefixSumArray[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + array[i];
        }
        return prefixSumArray;
    }

    public Map prefixSumSet(int[] array) {
        if (array == null && array.length == 0) {
            return null;
        }

        Map<Integer, Boolean> map = new HashMap();
        int[] prefixSumArray = new int[array.length];
        map.put(array[0], true);
        prefixSumArray[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + array[i];
            map.put(prefixSumArray[i], true);
        }
        return map;
    }

    // 根据 前缀和组数 获取 原数组
    public int[] prefixGetOrigin(int[] array) {
        if (array == null && array.length == 0) {
            return null;
        }
        int[] originArray = new int[array.length];
        originArray[0] = array[0];
        int prefixSum = array[0];
        for (int i = 1; i < array.length; i++) {
            originArray[i] = array[i] - prefixSum;
            prefixSum += originArray[i];
        }
        return originArray;
    }
}
