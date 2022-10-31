package Algorithm.dynamic.lcs;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-7-19 Time：上午10:15:35
 * @author—Email micromicrohard@outlook.com
 * @description 最长公共子序列
 * longest Common Sequence
 * LCS算法，找出两个字符串最大匹配子序列。
 */

public interface LCS {

    //获取LCS的长度
    int getCommonLength(String source, String pattern);

    //获取LCS的最长字串
    String GetSimilarityMethod(String source, String pattern);

    //计算方法
    //LCS count(String source, String pattern);
    default boolean check(String source, String pattern) {
        if (source == null || pattern == null || source.length() == 0 || pattern.length() == 0) {
            return false;
        }
        return true;
    }
}
