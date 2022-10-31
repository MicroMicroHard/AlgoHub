package Algorithm.comprehensive.lis;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/6/6
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 最长递增子序列
 * longestIncreasingSubSequence
 * <p>
 * 在一个给定的数值序列中，找到一个子序列，使得这个子序列元素的数值依次递增，并且这个子序列的长度尽可能地大。
 * 最长递增子序列中的元素在原序列中不一定是连续的
 */

public interface LIS {

    int Method(String sequence);

    default boolean check(String sequence) {
        return sequence != null && sequence.length() != 0;
    }
}
