package Top100;

import DataStructure.arrayRelevant.doublePoint.MaxContinuityOne;
import DataStructure.heapStackQueue.queue.MaxSlidingWindowByQueue;
import DataStructure.stringOps.LNS.LNRSubstringByQueue;
import DataStructure.stringOps.slidingWindow.*;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/12/7
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https:blog.csdn.net/ljfirst
 * @description 滑动窗口
 */
public interface SlidingWindow {

    /**
     数组的连续积小于给定值的组合{@link Combination_Sliding}
     找到源串中所有目标串的连续排列 {@link FindAllAnagrams}

     最长无重复子串 {@link LNRSubstringByQueue}
     至少有 K 个重复字符的最长子串 {@link LongestKRepeatSequence}

     最小覆盖子串 {@link MinCoverSubstring},当条件更加严格一些，要求最小覆盖子串仅含有一个字符且所有符号不能重复{@link MinCoverSubstringPlus}

     滑动窗口的最大值，有两种解法，比如使用优先队列 {@link MaxSlidingWindow} 和使用队列的方式{@link MaxSlidingWindowByQueue}

     找出 补充并反转后的 最大连续的数字1的个数{@link MaxContinuityOne}

     一个S和一个T，请问你S中是否存在一个子串，包含T中所有字符且不包含其他字符 {@link PermutationinString}
     */
}
