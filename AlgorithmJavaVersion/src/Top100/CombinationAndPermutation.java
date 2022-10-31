package Top100;

import Algorithm.backtrack.*;
import Algorithm.dynamic.ChangeMoneyCombination_Dynamic;
import Algorithm.dynamic.ChangeMoneyPermutation_Dynamic;
import Algorithm.dynamic.ChangeMoney_Least_Dynamic;
import Algorithm.dynamic.CombinationNum_NonRepeat_Dynamic;
import DataStructure.stringOps.slidingWindow.Combination_Sliding;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/15
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 排列组合问题
 * 全排列问题
 */

public interface CombinationAndPermutation extends BackTrack {

    /**
     * 排列组合问题
     * <p>
     * <p>
     * 排列问题 Permutation
     * 数组中存在 等于给定值的组合 是一个组合问题
     * 数组 可以   无限重复的选择 {@link CombinationNum_BackTrack}
     * 数组 不可以 无限重复的选择 {@link CombinationNum_NonRepeat_BackTrack} 和 {@link CombinationNum_NonRepeat_Dynamic}
     * <p>
     * 进阶组合问题
     * 数组的连续积 小于等于给定值的组合,是一个组合问题, 使用非for循环实现 {@link CombinationPlus} 和滑动窗口实现 {@link Combination_Sliding}
     * <p>
     * Tips：排列和组合的问题
     * 1、体现在Dynamic上是两层for循环，具体见 {@link ChangeMoneyPermutation_Dynamic} 和 {@link ChangeMoneyCombination_Dynamic}
     * 2、体现在BackTrack上是内层for的起始值，具体见 {@link ChangeMoneyPermutation_BackTrack} 和 {@link ChangeMoneyCombination_BackTrack}
     * <p>
     * 排列和组合综合：
     * 给一个数组和一个target，换零钱问题会演变出来以下：
     * 0、换成Target，是否可以凑出来 {@link CombinationNum_NonRepeat_Dynamic}
     * 1、换成Target，所需要的最少零钱数量  {@link ChangeMoney_Least_Dynamic}
     * 2、换成Target，输出所有的零钱排列【允许同一面值的零钱复用】【排列问题】 {@link ChangeMoneyPermutation_BackTrack}
     * 3、换成Target，输出所有不重复的零钱组合【允许同一面值的零钱复用】【组合问题】 {@link ChangeMoneyCombination_BackTrack}
     * 4、换成Target，输出所有不重复不复用的零钱组合【不允许同一面值的零钱复用】 {@link CombinationNum_NonRepeat_Dynamic}
     */

    // 输出的 List 按照 List.size 从小到大 来排序
    int[][] Solution(int[] array, int target);

}
