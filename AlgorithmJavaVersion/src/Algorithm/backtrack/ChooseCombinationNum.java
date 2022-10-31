package Algorithm.backtrack;

import Common.Utils.UTFactory;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/5/21 14:06
 * @author—Email micromicrohard@outlook.com
 * @description 给 一组数，可能有重复数字，从中选取 n 个不重复的数字出来
 * 输出所有的组合
 * @blogURL
 */

public class ChooseCombinationNum {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    public int[][] Method(int[] array, int n) {
        // 对 m 去重，如果小于 n，直接返回
        if (array == null || array.length < n) {
            return null;
        }
        Map<Integer, Integer> reduceRepeatMap = new TreeMap<>();
        for (int j : array) {
            reduceRepeatMap.put(j, 1);
        }
        if (reduceRepeatMap.size() < n) {
            return null;
        }
        // 数学方式：
        int m = reduceRepeatMap.size();

        return null;
    }
}
