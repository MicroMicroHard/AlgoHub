package Algorithm.dynamic.lcs;

import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-7-19 上午10:52:22
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description lcs改进算法，只需一行数组即可以获取匹配数最大值，节省了空间，
 * 但是无法获取匹配匹配的字符串。
 */
public class LCS_Optimize implements LCS {

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

    boolean flag = true;
    int[] lcsOptMatrix;   // 数值矩阵 存放字符匹配数量的最大值
    int temp_before;      // temp 用来保存上一次遍历时当前位的最大值
    int temp_after;


    public int getCommonLength(String source, String pattern) {
        lcsOperation(source, pattern);
        return lcsOptMatrix == null ? 0 : lcsOptMatrix[pattern.length()];
    }


    public String GetSimilarityMethod(String source, String pattern) {
        if (!flag) {
            return "";
        }
        LCS_Dynamic lcs = new LCS_Dynamic();
        return lcs.GetSimilarityMethod(source, pattern);
    }

    public LCS lcsOperation(String source, String pattern) {

        if (!check(source, pattern)) {
            flag = false;
            return new LCS_Optimize();
        }
        flag = true;
        int n1 = source.length();
        int n2 = pattern.length();
        //初始化数组
        lcsOptMatrix = new int[n2 + 1];

        //遍历匹配
        for (int i = 0; i < n1; i++) {
            for (int j = 1; j <= n2; j++) {
                //暂存当前值
                temp_before = lcsOptMatrix[j];
                //若字符匹配相等，对角线值加一
                if (source.charAt(i) == pattern.charAt(j - 1)) {
                    //特别注意：当循环到1时，temp_after的左上角是0，而不是上一行的末尾
                    if (j == 1) {
                        temp_after = 0;
                    }
                    lcsOptMatrix[j] = temp_after + 1;
                } else {
                    //看附近值谁大
                    lcsOptMatrix[j] = Math.max(lcsOptMatrix[j], lcsOptMatrix[j - 1]);
                }
                //暂存值交替
                temp_after = temp_before;
            }
        }

        //输出子字符匹配数量的最大值
        //System.out.println("LCS_optimize最大子字符串长度为：" + lcs_opt_matrix[n2]);
        return this;
    }
}
