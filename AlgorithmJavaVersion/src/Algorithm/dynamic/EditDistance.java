package Algorithm.dynamic;

import Common.Utils.MathTools;
import Common.Utils.UTFactory;
import Top100.Dynamic;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-12-06 22:04
 * @author—Email micromicrohard@outlook.com
 * @description 编辑距离
 * 指的是在两个单词之间，由其中一个单词转换为另一个单词所需要的最少单字符编辑操作次数。
 * 在这里定义的单字符编辑操作有且仅有三种：插入（Insertion）、删除（Deletion）、替换（Substitution）
 * <p>
 * 譬如，"kitten" 和 "sitting" 这两个单词，由 "kitten" 转换为 "sitting" 需要的最少单字符编辑操作有：
 * 1.kitten → sitten (substitution of "s" for "k")
 * 2.sitten → sittin (substitution of "i" for "e")
 * 3.sittin → sitting (insertion of "g" at the end)
 * <p>
 * 因此，"kitten" 和 "sitting" 这两个单词之间的编辑距离为 3 。
 * @blogURL https://www.jianshu.com/p/a617d20162cf
 */
public class EditDistance implements Dynamic {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误测试案例
    public void TestDoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    public int GetDistanceMethod(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2 == null ? 0 : word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        int length1 = word1.length();
        int length2 = word2.length();
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int[][] comp = new int[length1 + 1][length2 + 1];
        // initial
        for (int i = 0; i < length1 + 1; i++) {
            comp[i][0] = i;
        }
        for (int j = 0; j < length2 + 1; j++) {
            comp[0][j] = j;
        }
        // count
        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    comp[i][j] = comp[i - 1][j - 1];
                    continue;
                }
                // 否则取附近三者的最小值
                comp[i][j] = MathTools.GetMostValue(true,
                        comp[i - 1][j - 1], comp[i - 1][j],
                        comp[i][j - 1]
                ) + 1;
            }
        }
        return comp[length1][length2];
    }
}
