package DataStructure.sort.innerSort.innerSortApply;

import DataStructure.sort.innerSort.innerSortImpl.BucketSort;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-9-5 下午08:35:45
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * h 指数的定义：h 代表“高引用次数”（high citations），
 * 一名科研人员的 h 指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的 n - h篇论文每篇被引用次数不超过 h 次。
 * <p>
 * 例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
 * 提示：如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 * 由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 */
public class CitationsByBucketSort extends BucketSort implements Citations {

    public int sortSolution(int[] array) {
        if (array == null) {
            return 0;
        }
        if (array.length == 1) {
            return array[0] == 0 ? 0 : 1;
        }
        // 输出的最大结果不可能超过 array.length ，因为引用超过 n 次数的文章数量，不可能超过文章总数
        int pageMax = array.length;
        int[] newCitations = new int[pageMax + 1];

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= pageMax) {
                newCitations[pageMax]++;
            } else {
                newCitations[array[i]]++;
            }
        }
        // 统计输出
        int sum = 0;
        for (int i = newCitations.length - 1; i >= 0; i--) {
            sum += newCitations[i];
            if (sum >= i) {
                return i;
            }
        }
        // 说明没有这样的数字
        return 0;
    }
}
