package Top100;

import Algorithm.backtrack.*;
import Algorithm.dynamic.*;
import DataStructure.arrayRelevant.preSumAndDiffArray.PreSumArrayApply_ChangeMoney;
import DataStructure.stringOps.slidingWindow.Combination_Sliding;
import DataStructure.tree.binaryTree.binaryTreeApply.BT_JumpLevelSum;

/**
 * @author liujun
 * @version 1.0
 * @date 2022/2/9
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst/article/details/122782616?spm=1001.2014.3001.5502
 * @description 零钱交换专题
 * 有这样一个问题：给定不同面额的硬币 coins 和一个总金额 target，求出组成target金额的硬币序列。
 * <p>
 * 延伸出下列问题：
 * <p>
 * 1、零钱数组是否可以组成target表示的金额
 * 2、在(1)问题的基础上，凑出target表示金额所需要的最少零钱数量
 * 3、在(2)问题的基础上，进行排列组合
 * 3.1、组合问题和排列问题
 * 3.2、动态规划和回溯解法
 * 4、零钱数组每个数仅能用1次的基础上，是否还能凑出target表示金额
 * 5、在前4条的基础上，进行排列去重
 * 6、上述5个问题，零钱序列都可以随意组合，如果限制随意组合，仅能选取连续的钱币，那么是否还能凑出target表示金额
 * 7、上述7个问题是加和问题，如果是乘积呢？
 * 7.1、随意组合，凑出乘积等于target的组合
 * 7.2、连续组合，凑出乘积等于target的组合
 * 8、现在题目反过来，将target拆分为至少两个正整数的和，并使这些整数的乘积最大化
 * 9、总结一下上面的问题
 * 9.1、最大子段和(连续)
 * 9.2、最大间隔和
 * 9.3、最大子段乘积(连续)
 * 9.4、最大间隔乘积
 * 10、如果给定的coins数组修改为二叉树：选取非相邻的二叉树节点进行组装，组装的最大值是多少？
 * 11、如果零钱数组加上数量限制数组，即每个零钱有一个限定使用的最大值，那么是否还能凑出target
 */
public interface ChangeMoney {

    /**
     1、零钱数组【是否】可以组成target表示的金额
     1.1、零钱数组可以组成，并且数组元素 可以  无限重复的选择{@link CombinationNum_BackTrack},{@link CombinationNum_Dynamic}
     1.2、零钱数组可以组成，但是数组元素 不可以 无限重复的选择【演变成背包问题】{@link CombinationNum_NonRepeat_BackTrack},{@link CombinationNum_NonRepeat_Dynamic}

     2、在 1 问题的基础上，凑出target表示金额所需要的【最少】零钱数量
     有动态规划{@link ChangeMoney_Least_Dynamic}和回溯{@link ChangeMoney_Least_BackTrack}两种方式,
     其中回溯写法的类似题目还有{@link CombinationNum_BackTrack}

     3、在 (2) 问题的基础上，对凑出target表示金额的【所有】结果，进行排列组合，并给出动态规划和回溯解法两种解法
     3.1、组合问题的动态规划解法 {@link ChangeMoneyPermutation_Dynamic}
     3.2、组合问题的回溯解法 {@link ChangeMoneyPermutation_BackTrack}
     3.3、排列问题的动态规划解法 {@link ChangeMoneyCombination_Dynamic}
     3.4、排列问题的回溯解法 {@link ChangeMoneyCombination_BackTrack}
     注意：排列和组合的问题
     1）排列组合体现在回溯上:
     递归内的for循环，i 从0开始，是排列问题，从上次的深度depth开始，是组合问题
     2）排列组合体现在动态规划上：
     target在内循环，数组在外循环是求解排列数
     数组在内循环，target在外循环是求解组合数

     4、零钱数组每个数仅能用1次的基础上，是否还能凑出target表示金额
     // 见1.2

     5、前4条讨论的 数组 是不含重复元素的，当数组中存在重复元素时，进行 全排列 就需要考虑"去重"的问题【排列、组合、组合去重】
     通过访问标记去重{@link ArrayCombination}，只有递归到当前深度的时候，才创建锁，map扮演锁的角色，保障不重复，具有剪枝的功能
     通过map去重{@link ArrayCombination_WithMap}，把最终结果放到map去重，并没有剪枝的操作
     通过mapArray去重{@link ArrayCombination_WithMapArray}，一开始的时候就根据递归深度，创建锁数组，为每一层加锁，具有剪枝的功能
     通过mapArray去重{@link  ArrayCombination_SingleLock}，从始至终只有一个map对当前深度进行去重，在当前层放入数的时候，需要在退出时释放这个数

     6、上述5个问题，零钱序列都可以随意组合，如果限制随意组合，是否还能凑出target表示金额
     6.1、仅能选取【连续】的钱币，{@link PreSumArrayApply_ChangeMoney},思路是前缀和
     6.2、仅能选取【间隔】的钱币，{@link ChangeMoney_SumGap_BackTrack},思路是回溯

     7、上述7个问题是加和问题，如果是乘积呢？如何凑出乘积等于target的组合
     7.1、随意组合，{@link ChangeMoney_BackTrack},思路是回溯
     7.2、连续组合，{@link Combination_Sliding},思路是滑动窗口

     8、现在题目反过来，将 target 拆分为至少两个正整数的和，并使这些整数的乘积最大化
     8.1、动态规划，{@link NumReduceMaxMulti}
     8.2、数学上的均值定理 {@link NumReduceMaxMulti_Math}

     9、总结一下上面的问题
     9.1、最大子段和(连续)    {@link LSS#LargestSumOfSubSequence}
     9.2、最大间隔和         {@link LSG#LargestSumOfGap}
     9.3、最大子段乘积(连续)  {@link LMS#LargestMultiOfSubSequence}，
     9.4、最大间隔乘积       {@link LMG#LargestMultiOfGap}

     10、如果给定的coins数组修改为二叉树：选取非相邻的二叉树节点进行组装，组装的最大值是多少
     {@link BT_JumpLevelSum},思路是回溯递归，但是需要考虑分类情况

     11、如果零钱数组加上数量限制数组，即每个零钱有一个限定使用的最大值，那么是否还能凑出target？
     {@link ChangeMoney_WithLimit_BackTrack},思路是回溯

     总结：上述问题的考虑角度主要为：
     1、重复的数字：给定数组中是否包含重复的数字，比如：重复：[1,1,2]、不重复[1,2,3,4]
     2、选取方式：连续、不一定连续、一定不连续【子序列和子串问题】
     3、计算方式：求和还是求积
     4、匹配方式：选取集合为最值 best 还是指定值 target
     5、输出方式：输出结果集合、还是集合的数量、能否凑出集合、集合中的最优解
     6、输出结果：集合是排列还是组合结果，排列是否去重，还是结果集合中的最优

     排列组合举例：原数组是[1,2,3,4],组合成4
     在可以多选的情况下，[1,1,2] 只计算一次，是组合。
     在可以多选的情况下，[1,1,2]、[1,2、1]、[2,1,1] 计算三次是排列
     如果原数组是[1,1,2,3,4],组合成4，在可以多选的情况下，[1,1,2] 不重复计算是排列去重

     常见做法：
     1、求连续和为最优解一般是 最大字段和，求连续和为指定值一般是 前缀和，不一定连续的情况考虑使用背包
     2、针对(5)输出结果，获取集合类最方便的是回溯，求最值问题一般是DP
     3、针对(2)选取方式和(6)输出结果，考虑加锁
     4、补充：回溯算法，递归的for循环中，i从0开始，是排列问题，从上次的深度depth开始，是组合问题，排列去重考虑加锁
     */
}
