package Common.Constant;

public class C {

    // 相互识别对
    public static final int MaxValueExpr = Integer.MAX_VALUE;       // int类型的最大值
    public static final int MinValueExpr = Integer.MIN_VALUE;       // int类型的最大值

    public static final int ErrorNum = Integer.MIN_VALUE + 1;       // 表示错误的计算结果,+1是为了区分最小值
    public static final String ErrorExpr = "ErrorExpr";
    public static final String ErrorNumStr = "ErrorNum";

    public static final int NLF = Integer.MIN_VALUE + 2;            // NLF = NullLeafSymbol:表示空叶子结点，+2是为了区分最小值


    // Common
    public static String QuotationMark = "\"";             //引号
    public static String QuotationMarkSingle = "\'";       //单引号
    public static String Backslash = "\\\"";               //斜杠
    public static boolean useLocalDB = true;               //是否使用本地数据库


    // 方法的三种状态：执行了(1)、未执行了(0)、执行失败(-1)
    public static final int MethodExeError = -1;
    public static final int MethodExe = 1;
    public static final int MethodNotExe = 0;


    public static String MissingParamsType = "缺失参数类型，请补充case";       //用于方法入参校验
    public static String MissingParams = "不正确";                           //用于方法入参校验
    public static String ErrorMethodParams = "方法入参数量不正确，请检查方法";   //用于方法入参校验

    public static final String mysqlVersion_new = "com.mysql.cj.jdbc.Driver";
    public static final String mysqlVersion_old = "com.mysql.jdbc.Driver";
    public static final String mysqlVersion = mysqlVersion_old;
    public static final String dbHost = "localhost";
    public static final String dbPassword = "12345678";

    // HTTP 连接数据
    public static final String BaiduURLStr = "http://www.baidu.com";

}
