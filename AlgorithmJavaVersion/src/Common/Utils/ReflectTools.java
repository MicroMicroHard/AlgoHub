package Common.Utils;

import Common.Conf.Config;
import Common.Constant.C;
import Common.MidwareConn.DBConn.MYSQLConn.UTDataEntity;
import Common.Utils.ToolsINTF.ReflectToolsINTF;
import DataStructure.list.Listlj;
import DataStructure.list.Nodelj;
import DataStructure.list.listRealize.SinglyLinkedList;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/3/13 11:47 PM
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 反射处理
 * get class name、method
 * get params
 * exec method、judge result
 * print params
 */
public class ReflectTools implements ReflectToolsINTF {
    /**
     * shipClassList: 不需要被统计进来的类， 比如test, top100
     * <p>
     * 缓存：
     * 类名-路径：            className_Path_Map     init_ClassName_Path_Map      get_ClassName_Path
     * 类名-class：          className_Clazz_Map    init_ClassName_Clazz_Map     get_ClassName_Path
     * 接口名-实现的class列表：interface_Clazz_Map    init_Interface_Clazz_Map     get_Interface_Clazz
     * <p>
     * 初始化<类名-类路径> classNamePathMap / 初始化<类名-类对象> className_Clazz_Map {@link ReflectTools#init_ClassName_PathMap}
     * 初始化<接口名-实现类> interface_Clazz_Map {@link ReflectTools#init_Interface_ClazzMap()}
     * <p>
     * 获取项目下 文件名对应的路径 {@link ReflectTools#get_ClassName_Path}
     * 获取项目下 文件名对应的类对象 {@link ReflectTools#GetClassName_Clazz}
     * 获取项目下 接口 interfaceName 下所有的类 {@link ReflectTools#GetInterface_ClassList}
     * <p>
     * 获取反射对象的所有方法 {@link ReflectTools#GetMethodAndName}
     * 执行方法             {@link ReflectTools#UTExecutorWithoutPool}
     * 反射方法并执行        {@link ReflectTools#MethodExec}
     * 判断结构是否相等      {@link ReflectTools#ParamsEquals}
     */

    /**
     * 当前路径, reflect grammar：System.getProperty获取系统自带的系统属性，有57个，
     * 参考blog:https://blog.csdn.net/weixin_37139197/article/details/78877766
     * 也可以使用 System.setProperty("jdbc.drivers","aaa.bbb.ccc");来设置系统属性
     */
    public static String prefixPath = System.getProperty("user.dir") + "/src/";
    public static Config config = new Config();
    public static StringTools strTools = new StringTools();
    public static String[] shipClassList = {"Test", "test", "Top100"};

    public static Map<String, String> className_PathMap;              // 类名-路径
    public static Map<String, Class<?>> className_ClazzMap;           // 类名-class
    public static Map<String, List<Class<?>>> interface_ClassListMap; // 接口名-实现的class列表
    public static Map<String, String> clazz_Interface_NameMap;        // 实现-接口名 的映射列表

    static {
        ReflectTools tools = new ReflectTools();
        tools.initReflectTools();
    }

    public void initReflectTools() {
        File directory = new File("");// 参数为空
        String sourceFile = "";
        try {
            //sourceFile = System.getProperty("user.dir");
            sourceFile = directory.getAbsolutePath() + "/src";//reflect grammar：获取项目的绝对路径
        } catch (Exception e) {
            e.printStackTrace();
        }
        className_PathMap = new HashMap<>();
        className_ClazzMap = new HashMap<>();
        interface_ClassListMap = new HashMap<>();
        clazz_Interface_NameMap = new HashMap<>();
        init_ClassName_PathMap(sourceFile);     // init className_Path_Map、className_Clazz_Map
        init_Interface_ClazzMap();              // init clazz_Interface_Map、interface_Clazz_Map
    }

    public static boolean skipList(String path) {
        for (String s : shipClassList) {
            if (path.contains(s)) {
                return true;
            }
        }
        return false;
    }

    // 执行反射方法
    public int MethodExec(Object instance, Method instanceExecMethod, UTDataEntity entity) {
        // get methodInput
        Object[] methodInput = GetMethodInput(instanceExecMethod, entity);
        Object methodExpectOutput = GetMethodOutput(instanceExecMethod, entity);
        Object methodActualOutput = null;

        // Exec
        try {
            methodActualOutput = instanceExecMethod.invoke(instance, methodInput);
        } catch (Exception e) {
            entity.print();
            e.printStackTrace();
            return 1;
        }

        // get methodOutput：只有出参会出现void, 说明是原址调用，保留原来的输入类型
        if ("void".equals(instanceExecMethod.getReturnType().getName())) {
            methodActualOutput = methodInput[0];
        }
        // equals
        if (!ParamsEquals(methodExpectOutput, methodActualOutput)) {
            System.out.printf("\n%s.%s exec failed", instance.getClass().getName(), instanceExecMethod.getName());
            entity.print();
            System.out.print("ActualOutput:        ");
            ParamsPrint(methodActualOutput);
            return 1;// 错误数
        }
        return 0;
    }

    // ExecMethod 执行反射方法
    public void UTExecutorWithoutPool(Class<?> classByReflect, String className, List<UTDataEntity> list) {
        Object instance = null;
        try {
            instance = classByReflect.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.printf("className: %s newInstance error:\n", className);
        }
        Map<String, Method> execMethods = GetMethodAndName(classByReflect);
        if (execMethods.size() == 0) {
            System.out.printf("%s 未执行, 请检查%s中是否包含 Solution/solution/Method/method 的待执行方法%n", className, className);
            return;
        }
        for (Method m : execMethods.values()) {
            long start = System.currentTimeMillis();
            int methodExeErrorCnt = 0; // 方法执行错误几次
            // loop SQLTestData for test
            for (UTDataEntity entity : list) {
                methodExeErrorCnt += MethodExec(instance, m, entity);
            }
            String classNameMethod = className + "." + m.getName();
            long end = System.currentTimeMillis() - start;

            String timeCostAttention = (end / list.size()) > 0 ? "《========= TimeCostAttention" : "";

            String word = methodExeErrorCnt == 0 ? String.format("%50s 测试通过，共通过 %2d 个测试案例，总耗时：%dms,平均耗时：%dms %s", classNameMethod, list.size(),
                    end, end / list.size(), timeCostAttention) :
                    String.format("%50s 测试未通过，存在 %d/%d 个测试案例没有通过", classNameMethod, methodExeErrorCnt, list.size());
            System.out.println(word);
        }
    }

    public Object ParamsRecognize(String context, String paramsType) {
        context = strTools.FormatStr(context);
        if (config.commonConfig.NullExpr.equals(context) || context.contains(config.commonConfig.NullExpr)) {
            return null;
        }

        switch (paramsType) {
            case "java.lang.Boolean":
            case "boolean":
                return strTools.RecognizeBool(context);
            case "int":
                return strTools.RecognizeInt(context);
            case "[I":
                return strTools.RecognizeIntArray(context);
            case "[[I":
                return strTools.RecognizeIntMatrix(context);
            case "double":
                return strTools.RecognizeDouble(context);
            case "[double":
                return strTools.RecognizeDoubleArray(context);
            case "java.lang.String":
                return strTools.RecognizeStr(context);
            case "[Ljava.lang.String;":
                return strTools.RecognizeStrArray(context);
            case "DataStructure.list.Nodelj":
                return strTools.RecognizeNodelj(context);
            case "DataStructure.tree.binaryTree.BinaryTreeImpl":
                return strTools.RecognizeBinaryTree(context);
            case "[LDataStructure.list.Nodelj;":
                return strTools.RecognizeNodeljArray(context);
            case "void":
                return "";// 在调用方处理
            case "java.util.List":
                return strTools.RecognizeList(context);
            case "DataStructure.list.Listlj":
                return strTools.RecognizeListlj(context);
            default:
                System.out.println(C.MissingParamsType);
                return C.MissingParamsType;
        }
    }

    // 判断结构是否相等 judgeMethodResultEquals
    public boolean ParamsEquals(Object obj1, Object obj2) {

        if (obj1 == null || obj2 == null) {
            return obj1 == null && obj2 == null;
        }
        if (obj1 instanceof Boolean && obj2 instanceof Boolean) {
            return ((Boolean) obj1).booleanValue() == ((Boolean) obj2).booleanValue();
        }
        if (obj1 instanceof Integer && obj2 instanceof Integer) {
            return ((Integer) obj1).intValue() == ((Integer) obj2).intValue();
        }
        if (obj1 instanceof int[] && obj2 instanceof int[]) {
            return ArrayTools.IntArrayEquals((int[]) obj1, (int[]) obj2);
        }
        if (obj1 instanceof int[][] && obj2 instanceof int[][]) {
            return ArrayTools.EqualsIntMatrix((int[][]) obj1, (int[][]) obj2);
        }
        if (obj1 instanceof Double && obj2 instanceof Double) {
            return ((Double) obj1).equals((Double) obj2);
        }
        if (obj1 instanceof String && obj2 instanceof String) {
            return ((String) obj1).equals((String) obj2);
        }
        if (obj1 instanceof String[] && obj2 instanceof String[]) {
            return ArrayTools.EqualsStringArray((String[]) obj1, (String[]) obj2);
        }
        if (obj1 instanceof Nodelj && obj2 instanceof Nodelj) {
            return ((Nodelj) obj1).equals((Nodelj) obj2);
        }
        if (obj1 instanceof BinaryTreeImpl && obj2 instanceof BinaryTreeImpl) {
            return ((BinaryTreeImpl) obj1).equals((BinaryTreeImpl) obj2);
        }
        if (obj1 instanceof List && obj2 instanceof List) {
            List list1 = (List) obj1;
            List list2 = (List) obj2;
            if (list1.size() != list2.size()) {
                return false;
            }
            if (list1.size() == 0) {
                return true;
            }
            for (int i = 0; i < list1.size(); i++) {
                if (!ParamsEquals(list1.get(i), list2.get(i))) {
                    return false;
                }
            }
            return true;
        }
        if (obj1 instanceof Listlj && obj2 instanceof Listlj) {
            SinglyLinkedList list1 = (SinglyLinkedList) obj1;
            SinglyLinkedList list2 = (SinglyLinkedList) obj2;
            if (list1.head.key != list2.head.key) {
                return false;
            }
            if (list1.head.key == 0) {
                return true;
            }
            return list1.listEquals(list2);
        }
        System.out.println("MethodResultEquals Error: 缺少参数识别类型, 原参数：" + obj1);
        return false;
    }

    // 打印参数
    public void ParamsPrint(Object obj1) {
        if (obj1 == null) {
            System.out.println("null");
            return;
        }
        if (obj1 instanceof Boolean) {
            System.out.println(obj1);
            return;
        }
        if (obj1 instanceof Integer) {
            switch ((Integer) obj1) {
                case C.ErrorNum:
                    System.out.println(config.commonConfig.ErrorExpr);
                    break;
                case C.MaxValueExpr:
                    System.out.println(config.commonConfig.MaxValueExpr);
                    break;
                case C.MinValueExpr:
                    System.out.println(config.commonConfig.MinValueExpr);
                    break;
                case C.NLF:
                    System.out.println(config.commonConfig.NLF);
                    break;
                default:
                    System.out.println(obj1);
            }
            return;
        }
        if (obj1 instanceof int[]) {
            ArrayTools.printIntArray((int[]) obj1);
            return;
        }
        if (obj1 instanceof int[][]) {
            ArrayTools.printIntMatrix((int[][]) obj1);
            return;
        }
        if (obj1 instanceof Double) {
            System.out.println(obj1);
            return;
        }
        if (obj1 instanceof String) {
            System.out.println(obj1);
            return;
        }
        if (obj1 instanceof String[]) {
            System.out.println(Arrays.toString((String[]) obj1));
            return;
        }
        if (obj1 instanceof Nodelj) {
            ((Nodelj) obj1).print();
            return;
        }
        if (obj1 instanceof BinaryTreeImpl) {
            ((BinaryTreeImpl) obj1).print();
            return;
        }
        if (obj1 instanceof Listlj) {
            SinglyLinkedList list = (SinglyLinkedList) obj1;
            list.print();
            return;
        }
        if (obj1 instanceof List) {
            List<?> list = (List<?>) obj1;
            if (list.size() == 0) {
                System.out.println("null");
            }
            for (Object o : list) {
                ParamsPrint(o);
                //System.out.println(o);
            }
            return;
        }
        System.out.println("无法识别参数类型，无法打印");
    }

    // 根据path 初始化 className_Path_Map / className_Class_Map
    public void init_ClassName_PathMap(String path) {
        if (skipList(path)) {
            return;
        }
        File file = new File(path);
        File[] tempList = file.listFiles();//reflect grammar：获取file包下面的文件，list显示
        Class<?> cl = null;
        for (int i = 0; i < Objects.requireNonNull(tempList).length; i++) {
            if (tempList[i].isDirectory()) {//reflect grammar：判断当前文件是否是目录
                init_ClassName_PathMap(tempList[i].getPath());
            }
            if (tempList[i].isFile() && tempList[i].getName().contains(".java")) {
                //文件名，不包含路径
                String fileName = tempList[i].getName().replace(".java", "");
                className_PathMap.put(fileName, tempList[i].getPath());
                try {
                    cl = Class.forName(get_ClassName_Path(fileName));// reflect grammar:通过反射获取对象
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
                className_ClazzMap.put(fileName, cl);
            }
        }
    }

    // 获取项目下 接口 interfaceName 下所有的类
    public void init_Interface_ClazzMap() {
        //interface_Clazz_Map = new HashMap<>();
        for (Class<?> T : className_ClazzMap.values()) {
            for (Class<?> classInterface : T.getInterfaces()) {
                if (skipList(classInterface.getName())) {
                    continue;
                }
                String interfaceName = strTools.GetCleanClassName(classInterface.getName());
                String className = strTools.GetCleanClassName(T.getName());
                interface_ClassListMap.computeIfAbsent(interfaceName, k -> new ArrayList<Class<?>>());
                interface_ClassListMap.get(interfaceName).add(T);
                clazz_Interface_NameMap.put(className, interfaceName);
            }
        }
    }

    // 获取项目下 文件名对应的路径
    public String get_ClassName_Path(String className) {
        if (className == null || className.length() == 0) {
            return null;
        }
        String classPath = className_PathMap.get(className);
        return classPath == null ? "" : classPath
                .replace(prefixPath, "")
                .replace(".java", "")
                .replace("/", ".");
    }

    public String GetClass_InterfaceName(String className) {
        String interfaceName = clazz_Interface_NameMap.getOrDefault(className, "");
        return interfaceName;
    }

    public Class<?> GetClassName_Clazz(String className) {
        if (className == null || className.length() == 0) {
            return null;
        }
        return className_ClazzMap.getOrDefault(className, null);
    }

    public List<Class<?>> GetInterface_ClassList(String interfaceName) {
        if (interfaceName == null || interfaceName.length() == 0) {
            return null;
        }
        return interface_ClassListMap.getOrDefault(interfaceName, null);
    }

    @Test
    public void testGetClassPath() {
        String name = get_ClassName_Path("DigitalTrans");
        System.out.println(name);
    }

    // 获取反射对象的所有方法 GetExecMethod
    public Map<String, Method> GetMethodAndName(Class<?> classByReflect) {
        Map<String, Method> map = new HashMap<>();
        for (Method method : classByReflect.getMethods()) {
            // 方法名必须含有 "Solution" 或者 "Method"
            if (!method.getName().contains("Solution") && !method.getName().contains("solution")
                    && !method.getName().contains("Method") && !method.getName().contains("method")) {
                continue;
            }
            map.put(method.getName(), method);
        }
        return map;
    }

    // 转换方法的输入 GetMethodInput
    public Object[] GetMethodInput(Method method, UTDataEntity entity) {
        Class<?>[] inputParamsTypes = method.getParameterTypes();
        Object[] methodInput = new Object[inputParamsTypes.length];
        // 参数分割符
        String symbol = config.commonConfig.SpiltExpr;

        String[] inputParams = strTools.FormatStr(entity.input).split(symbol);

        if (inputParams.length != inputParamsTypes.length) {
            System.out.printf("入参数量不正确，请检查入参！需要的参数类型个数：%d,实际读取到的参数类型个数：%d，参数输出： \n",
                    inputParamsTypes.length, inputParams.length);
            entity.print();
        }
        // 根据入参的类型，对input字符串逐一转换
        for (int i = 0; i < inputParamsTypes.length; i++) {
            Object input = ParamsRecognize(inputParams[i], inputParamsTypes[i].getName());
            methodInput[i] = input;
        }
        return methodInput;
    }

    // 转换方法的输出 GetMethodOutput
    public Object GetMethodOutput(Method method, UTDataEntity entity) {
        String outputParamsTypeName = method.getReturnType().getName();
        if ("void".equals(outputParamsTypeName)) {
            outputParamsTypeName = method.getParameterTypes()[0].getName();
        }
        return ParamsRecognize(entity.output, outputParamsTypeName);
    }
}
