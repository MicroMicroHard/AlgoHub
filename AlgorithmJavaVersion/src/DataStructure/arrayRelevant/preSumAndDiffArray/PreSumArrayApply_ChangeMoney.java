package DataStructure.arrayRelevant.preSumAndDiffArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-30 00:08
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 交换零钱
 * 给定一个数组，选取数组内连续的数，是否能凑出 target
 * @blogURL
 */

public class PreSumArrayApply_ChangeMoney extends PreSumArray {

    public boolean check(int[] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }
        Map<Integer, Boolean> map = new HashMap();
        int[] prefixSumArray = new int[array.length];
        map.put(array[0], true);
        prefixSumArray[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + array[i];
            map.put(prefixSumArray[i], true);
            int wantNum = prefixSumArray[i] - target;
            if (map.getOrDefault(wantNum, false)) {
                return true;
            }
        }
        return false;
    }

    public boolean check1(int[] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }
        Map prefixMap = prefixSumSet(array);
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            boolean flag = (Boolean) prefixMap.getOrDefault(sum + target, false);
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
