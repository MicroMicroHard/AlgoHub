package Algorithm.dynamic.lcs;

import Common.Utils.UTFactory;
import Top100.Dynamic;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-7-19 Time：上午10:15:35
 * @author—Email micromicrohard@outlook.com
 * @description LCS算法，找出两个字符串最大匹配子串。
 */

public class LCS_Dynamic implements LCS, Dynamic {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误测试案例
    public void TestDoubleTrack() throws Exception {
        String input = "EmptyExpr  ############  NullExpr";
        String output = "EmptyExpr";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    int n1, n2;                // 获取字符串长度,其中在矩阵中n1表示行数,n2表示列数
    int[][] numMatrix;         // 数值矩阵 存放字符匹配数量的最大值
    char[][] similarityMatrix; // 标记矩阵 存放字符匹配标记
    String lcsString = null;   // lsc串

    public int getCommonLength(String source, String pattern) {
        lcsOperation(source, pattern);
        return numMatrix[n1][n2];
    }

    public String GetSimilarityMethod(String source, String pattern) {

        LCS_Dynamic ans = lcsOperation(source, pattern);
        if (ans == null) {
            return "";
        }
        //找寻匹配上的字符串
        StringBuilder sb = new StringBuilder();
        for (int i = n1, j = n2; i > 0 && j > 0; ) {
            if (similarityMatrix[i][j] == '↖') {
                sb.append(source.charAt(i - 1));
                i--;
                j--;
            } else if (similarityMatrix[i][j] == '↑') {
                i--;
            } else {
                j--;
            }
        }
        lcsString = sb.length() == 0 ? "" : sb.reverse().toString();
        return lcsString;
    }

    public LCS_Dynamic lcsOperation(String source, String pattern) {

        if (!check(source, pattern)) {
            return null;
        }
        n1 = source.length();
        n2 = pattern.length();
        numMatrix = new int[n1 + 1][n2 + 1];
        similarityMatrix = new char[n1 + 1][n2 + 1];

        //数值矩阵初始化（若未初始化,数值矩阵显示为0,标记矩阵显示为口）
        for (int i = 0; i < n1; i++) {
            numMatrix[i][0] = 0;
            similarityMatrix[i][0] = 0;
        }
        for (int j = 0; j < n2; j++) {
            numMatrix[0][j] = 0;
            similarityMatrix[0][j] = 0;
        }

        //矩阵匹配,从每一行（或列）开始匹配
        //初始化的部分不用考虑，匹配从1开始
        for (int row = 1; row <= n1; row++) {
            //遍历列
            for (int column = 1; column <= n2; column++) {
                numMatrix[row][column] = 0;//初始化数值矩阵
                similarityMatrix[row][column] = 0;//初始化标记矩阵

                if (source.charAt(row - 1) == pattern.charAt(column - 1)) {//字符串元素匹配相等
                    numMatrix[row][column] = numMatrix[row - 1][column - 1] + 1;//取矩阵左上角数值加一
                    similarityMatrix[row][column] = '↖';//匹配标记（方便后面寻找）
                } else {//字符串元素匹配不等
                    if (numMatrix[row - 1][column] > numMatrix[row][column - 1]) {
                        numMatrix[row][column] = numMatrix[row - 1][column];//取矩阵上一行数值
                        similarityMatrix[row][column] = '↑';//向上寻找标记
                    } else {
                        numMatrix[row][column] = numMatrix[row][column - 1];//取矩阵左边数值
                        similarityMatrix[row][column] = '←';//向左寻找标记
                    }
                }
            }
        }
        return this;
    }
}
