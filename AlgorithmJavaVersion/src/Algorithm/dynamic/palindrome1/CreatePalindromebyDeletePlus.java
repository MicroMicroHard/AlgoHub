package Algorithm.dynamic.palindrome1;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-8-16 下午11:19:38
 * @author—Email micromicrohard@outlook.com
 * @description 通过两个字符串删除一部分内容，再拼接构造回文串/由子序列构造的最长回文串的长度
 * 给你两个字符串 word1 和 word2 ，请你按下述方法构造一个字符串：
 * 从 word1 中选出某个 非空 子序列 subsequence1 。
 * 从 word2 中选出某个 非空 子序列 subsequence2 。
 * 连接两个子序列 subsequence1 + subsequence2 ，得到字符串。
 * 返回可按上述方法构造的最长 回文串 的 长度 。如果无法构造回文串，返回 0 。
 * <p>
 * 输入：word1 = "cacb", word2 = "cbba"
 * 输出：5
 * 解释：从 word1 中选出 "ab" ，从 word2 中选出 "cba" ，得到回文串 "abcba" 。
 * @blogURL https://leetcode-cn.com/problems/maximize-palindrome-length-from-subsequences/
 */

//CreatePalindromebyDelete
public class CreatePalindromebyDeletePlus extends CreatePalindromebyDelete {

    //构造回文串
    public int CreatePalindromeByDelete(String s1, String s2) {
        if (s1 == null || s2.length() == 0) {
            return -1;
        }
        int n1 = s1.length();
        int n2 = s2.length();

        /*String target01 = s1 + s2;
        int l1 = s1.size(), l2 = s2.size(), len = l1 + l2;
        // 拼接s1 s2得到一个完整的字符串w
        String w = s1 + s2;
        vector<vector<int>> dp(len, vector<int>(len, 0));
        // 特殊判断word1的最后一个字符是否与word2第一个字符相等，若相等则res初始化为2.
        int res = (w[l1-1] == w[l1]) ? 2: 0;
        // 以下与计算最长回文子串解法一致
        for(int i = 0 ; i < len ; i ++) {
            dp[i][i] = 1;
        }
        for(int i = 0 ; i < len - 1 ; i ++) {
            dp[i][i+1] = (w[i] == w[i+1])? 2: 1;
        }

        for(int l = 2 ; l < len ; l ++) {
            for(int i = 0 ; i + l < len ; i ++) {
                int j = i + l;
                if(w[i] == w[j]) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                    // 唯一的区别就在于当两端字符相等更新最长回文子串时
                    // 若 i j 分别属于两个字符串，才更新最终结果值
                    if(i < l1 && j >= l1){
                        res = max(res, dp[i][j]);
                    }
                }
                else {
                    dp[i][j] = max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }*/
       // return res;
        return 2;

    }
}
