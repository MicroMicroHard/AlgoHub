package Common.Utils.ToolsINTF;

import DataStructure.list.Listlj;
import DataStructure.list.Nodelj;
import DataStructure.tree.binaryTree.BinaryTreeImpl;

import java.util.List;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/10 11:29
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description Format、Replace、Check
 * trans params
 * Recognize params
 * PlaceHolder
 */

public interface StringToolsINTF {

    String GetCleanClassName(String className);// 应用不同的测试场景，传入的测试名也不同

    // Format、Replace、Check
    String FormatStr(String params);           // 数据处理的时候，需要消除不规则的空格
    String ReplaceStr(String params);          // 数据处理的时候，需要把这五个符号替换掉: }、{、]、"、[
    boolean CheckFormatStr(String params);     // 数据处理的时候，需要校验是否仅含【大小写字母、数字、负数、逗号、空格】
    String ConcatMultiParams(String... params);// 写入数据库的时候，多参数进行拼接

    // trans params
    String[] ReduceStr2StrArray(String params);      // String 转 数组，数据处理的时候，需要字符串解析成String一维数组
    String[] ReduceStr2StrMatrix(String params);     // String 转 矩阵，数据处理的时候，需要字符串解析成String二维数组

    // Recognize params
    boolean RecognizeBool(String params);             //将字符串转成 boolean
    boolean[] RecognizeBoolArray(String params);      //将字符串转成 boolean 数组
    int RecognizeInt(String params);                  //将字符串转成 int
    int[] RecognizeIntArray(String params);           //将字符串转成 int 数组
    int[][] RecognizeIntMatrix(String params);        //将字符串转成 int 矩阵
    double RecognizeDouble(String params);            //将字符串转成 double
    double[] RecognizeDoubleArray(String params);     //将字符串转成 double 矩阵
    String RecognizeStr(String params);               //将字符串转成 String
    String[] RecognizeStrArray(String params);        //将字符串转成 String 数组
    String[][] RecognizeStrMatrix(String params);     //将字符串转成 String 矩阵
    Nodelj RecognizeNodelj(String params);            //将字符串转成 Nodelj
    Nodelj[] RecognizeNodeljArray(String params);     //将字符串转成 Nodelj 数组
    BinaryTreeImpl RecognizeBinaryTree(String params);//将字符串转成 二叉树
    Listlj RecognizeListlj(String params);            //将字符串转成 Listlj
    List RecognizeList(String params);                //将字符串转成 各种类型的List
}
