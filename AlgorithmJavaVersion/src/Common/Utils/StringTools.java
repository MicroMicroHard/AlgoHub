package Common.Utils;

import Common.Conf.Config;
import Common.Constant.C;
import Common.Utils.ToolsINTF.StringToolsINTF;
import DataStructure.list.Listlj;
import DataStructure.list.Nodelj;
import DataStructure.list.listRealize.SinglyLinkedList;
import DataStructure.tree.binaryTree.BinaryTreeImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/15 01:50
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description
 * @blogURL
 */
public class StringTools implements StringToolsINTF {

    public Config config = new Config();

    // 应用不同的测试场景，传入的测试名也不同
    public String GetCleanClassName(String className) {
        if (className.split("\\.").length > 1) {
            className = className.split("\\.")[className.split("\\.").length - 1];
        }
        return className;
    }

    // 替换掉字符串中的特殊符号，移除 ]、[、}、{、"
    public String ReplaceStr(String params) {
        return params.replaceAll("\\{", "").
                replaceAll("}", "").
                replaceAll("\\[", "").
                replaceAll("]", "").
                replaceAll("\"", "").
                trim();
    }

    // 将字符串统一化
    public String FormatStr(String params) {
        return params.replaceAll(" ", "");
    }

    // 检查字符串是否符合格式，并按照 逗号 进行分割
    public boolean CheckFormatStr(String params) {
        params = ReplaceStr(params);
        // 正则grammar: 检验是否仅含【大小写字母、数字、负数、逗号、空格、下划线】，如果需要加上"[]"的检验，写法：pattern = "[-,a-z\\[\\]A-Z\\s\\d*]+";
        String pattern = "[-,_,a-zA-Z\\s\\d*]+";
        if (!params.matches(pattern)) {
            System.out.println("Error, params :" + params);
            return false;
        }
        return true;
    }

    public String ConcatMultiParams(String... params) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < params.length - 1; i++) {
            sb.append(params[i]);
            sb.append("  ");
            sb.append(config.commonConfig.SpiltExpr);
            sb.append("  ");
        }
        return sb.append(params[params.length - 1]).toString();
    }

    // 将String拆分成String数组，特殊符号在调用方已经识别
    // 示例：{1,2,3} ==> [1,2,3]
    public String[] ReduceStr2StrArray(String params) {
        /* 因为存在空串，所以不进行检查
        if (params == null || params.length() == 0) {
            return null;
        }*/
        params = ReplaceStr(params);
        if (!CheckFormatStr(params)) {
            return null;
        }
        return params.split(",");
    }

    // 将String拆分成String二维数组，,特殊符号在调用方已经识别
    // 示例：{{1,2,3},{4,5,6},{7,8,9}} ==> [[1,2,3],[4,5,6],[7,8,9]]
    public String[] ReduceStr2StrMatrix(String params) {
        if (params == null || params.length() == 0) {
            return null;
        }
        if (!CheckFormatStr(params)) {
            return null;
        }
        if (params.contains("},{")) {
            return params.split("},\\{");
        }
        return params.split("],\\[");
    }

    public boolean RecognizeBool(String params) {
        String temp = ReplaceStr(params);
        return temp.equalsIgnoreCase(config.commonConfig.TrueExpr);
    }

    public boolean[] RecognizeBoolArray(String params) {
        return null;
    }

    public int RecognizeInt(String params) {
        params = ReplaceStr(params);
        // grammar : 无法做成switch case ，因为 case条件需要 常量，而此处是从配置文件获取的
        if (params.equals(config.commonConfig.ErrorExpr)) {
            return C.ErrorNum;
        }
        if (params.equals(config.commonConfig.MaxValueExpr)) {
            return C.MaxValueExpr;
        }
        if (params.equals(config.commonConfig.MinValueExpr)) {
            return C.MinValueExpr;
        }
        if (params.equals(config.commonConfig.NLF)) {
            return C.NLF;
        }
        int ans = 0;
        try {
            ans = Integer.parseInt(params);
        } catch (NumberFormatException e) {
            System.out.println(params);
            e.printStackTrace();
        }
        return ans;
    }

    public int[] RecognizeIntArray(String params) {
        params = ReplaceStr(params);

        if (params.equals(config.commonConfig.NullExpr)) {
            return null;
        }
        if (params.equals(config.commonConfig.EmptyExpr)) {
            return new int[]{};
        }

        String[] paramsStrArray = ReduceStr2StrArray(params);
        if (paramsStrArray == null) {
            return null;
        }
        int[] paramsStringArray = new int[paramsStrArray.length];
        for (int i = 0; i < paramsStrArray.length; i++) {
            paramsStringArray[i] = RecognizeInt(paramsStrArray[i]);
        }
        return paramsStringArray;
    }

    // int[][] 需要处理的是 {{}} 内的数据 ,{{1,2},{3,4}} ==> [[1,2],[3,4]}
    public int[][] RecognizeIntMatrix(String params) {

        // 字符串预处理： NULL/EMPTY 的处理
        if (params == null || params.contains(config.commonConfig.NullExpr) ||
                "".equals(params) || " ".equals(params)) {
            return null;
        }
        // 空的处理
        if (params.contains(config.commonConfig.EmptyExpr) ||
                FormatStr(params).equals("{}") || params.indexOf("{") + 1 == params.indexOf("}")) {
            return new int[0][];
        }
        String[] result = ReduceStr2StrMatrix(params);
        if (result == null) {
            return null;
        }
        // 正常处理
        int[][] paramsMatrix = new int[result.length][];
        for (int i = 0; i < result.length; i++) {
            paramsMatrix[i] = RecognizeIntArray(result[i]);
        }
        return paramsMatrix;
    }

    public double RecognizeDouble(String params) {
        if (params == null) {
            return 0.0;
        }
        params = ReplaceStr(params);
        if (params.equals(config.commonConfig.EmptyExpr) || params.equals(config.commonConfig.NullExpr)) {
            return 0.0;
        }
        return Double.parseDouble(params);
    }

    public double[] RecognizeDoubleArray(String params) {
        if (params == null) {
            return null;
        }
        params = ReplaceStr(params);
        if (params.equals(config.commonConfig.EmptyExpr)) {
            return new double[]{};
        }
        if (params.equals(config.commonConfig.NullExpr)) {
            return null;
        }
        String[] paramsStrArray = ReduceStr2StrArray(params);
        double[] answer = new double[paramsStrArray.length];
        for (int i = 0; i < paramsStrArray.length; i++) {
            answer[i] = RecognizeDouble(paramsStrArray[i]);
        }
        return answer;
    }

    public String RecognizeStr(String params) {
        if (params == null) {
            return null;
        }
        params = ReplaceStr(params);
        if (params.equals(config.commonConfig.EmptyExpr)) {
            return "";
        }
        if (params.equals(config.commonConfig.NullExpr)) {
            return null;
        }
        return params;
    }

    public String[] RecognizeStrArray(String params) {
        if (params == null) {
            return null;
        }
        String paramsTemp = ReplaceStr(params);
        if (paramsTemp.equals(config.commonConfig.EmptyExpr)) {
            return new String[]{};
        }
        if (paramsTemp.equals(config.commonConfig.NullExpr)) {
            return null;
        }
        String[] paramsStrArray = ReduceStr2StrArray(params);
        if (paramsStrArray == null) {
            return null;
        }
        if (paramsStrArray.length == 0) {
            return new String[]{};
        }
        String[] paramsIntArray = new String[paramsStrArray.length];
        for (int i = 0; i < paramsStrArray.length; i++) {
            paramsIntArray[i] = RecognizeStr(paramsStrArray[i]);
        }
        return paramsIntArray;
    }

    public String[][] RecognizeStrMatrix(String params) {
        return null;
    }

    public Nodelj RecognizeNodelj(String params) {
        int[] array = RecognizeIntArray(params);
        return Nodelj.Array2Nodelj(array);
    }

    public Nodelj[] RecognizeNodeljArray(String params) {
        String[] result = ReduceStr2StrMatrix(params);
        if (result == null) {
            return null;
        }
        Nodelj[] nodeArray = new Nodelj[result.length];
        for (int i = 0; i < result.length; i++) {
            nodeArray[i] = RecognizeNodelj(result[i]);
        }
        return nodeArray;
    }

    public BinaryTreeImpl RecognizeBinaryTree(String params) {
        int[] array = RecognizeIntArray(params);
        BinaryTreeImpl tools = new BinaryTreeImpl();
        return tools.deserialization(array);
    }

    public Listlj RecognizeListlj(String params) {
        Listlj l = new SinglyLinkedList();
        if (config.commonConfig.EmptyExpr.equals(params) || params.contains(config.commonConfig.EmptyExpr)) {
            return l;
        }
        String[] StrArray = params.split(",");
        for (String s : StrArray) {
            l.insert(true, RecognizeInt(s));
        }
        return l;
    }

    public List RecognizeList(String params) {
        if (config.commonConfig.EmptyExpr.equals(params)) {
            List l = new ArrayList<>();
            return l;
        }

        // case one :如果是int[] 类型的 List
        if (params.indexOf("{") != params.lastIndexOf("{")) {
            // 数组类型的判断
            String[] StrArray = params.split("},\\{");
            String demo = ReplaceStr(StrArray[0]);
            // int[] 类型的 List
            String numArrayPattern = "[[0-9]+,]+";
            if (demo.matches(numArrayPattern)) {
                List<int[]> list = new ArrayList<>();
                for (String s : StrArray) {
                    list.add(RecognizeIntArray(s));
                }
                return list;
            }
        }

        String[] StrArray = params.split(",");

        // case two :如果是int 类型的 List
        String demo = ReplaceStr(StrArray[0]);
        String numPattern = "[\\d]+";
        if (demo.matches(numPattern)) {
            List<Integer> list = new ArrayList<>();
            for (String s : StrArray) {
                list.add(RecognizeInt(s));
            }
            return list;
        }

        // case three :默认为String List
        List<String> list = new ArrayList<>();
        for (String s : StrArray) {
            list.add(RecognizeStr(s));
        }
        return list;
    }
}
