package Top100;

import Algorithm.backtrack.*;
import Algorithm.comprehensive.backpack.Backpack_BackTrack;
import Algorithm.comprehensive.optimalSchedule.OptimalSchedule_BackTrack;
import Algorithm.comprehensive.shortestDeliveryPath.ShortPath_BackTrack;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/1/15
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 回溯专题
 */

public interface BackTrack {

    /**
     * 背包问题 回溯法 {@link Backpack_BackTrack}
     * 最佳调度问题 （分支限界、剪枝法、回溯法）{@link OptimalSchedule_BackTrack}
     * 送货最短路径 {@link ShortPath_BackTrack}
     * 预测赢家 回溯法{@link PredictTheWinner_BackTrack}
     * <p>
     * <p>
     * 全排列问题
     * 组合数组中的数之和为指定值 {@link CombinationNum_BackTrack}
     * 数组的连续积小于给定值的组合(不使用for循环){@link CombinationPlus}
     * 字符串 全排列{@link StringCombination}
     * 时间 全排列{@link Combination_Time}
     * <p>
     * <p>
     * 数组 全排列【全排列去重问题】【通过访问标记去重】{@link ArrayCombination}
     * 数组 全排列【全排列去重问题】【通过map去重】{@link ArrayCombination_WithMap}
     * 数组 全排列【全排列去重问题】【通过mapArray去重】{@link ArrayCombination_WithMapArray}
     * {@link ArrayCombination_SingleLock}
     */
}
