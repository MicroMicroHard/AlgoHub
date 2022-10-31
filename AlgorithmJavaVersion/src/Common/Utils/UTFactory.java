package Common.Utils;

import Common.MidwareConn.DBConn.MYSQLConn.UTDataEntity;
import Common.ThreadPool.ThreadPoollj;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.CountDownLatch;

import static Common.Utils.ReflectTools.config;


/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/3/14 12:25 AM
 * @author-Email micromicrohard@outlook.com
 * @description 单元测试工厂
 * 主要包含以下的方法：
 * FullTest：测试全量数据，通过{@link UTFactory#FullTest}，连接数据库获取测试案例，然后逐个执行,
 * DebugTest：遇见不正确的案例，会输出在控制台，然后使用{@link UTFactory#DebugTest}，将控制台的输入输出手动粘贴到对应的input和output，进行断点调试
 * InterfaceTest：根据接口名获取所有的实现，使用统一的测试数据，逐个测试实现类的方法，{@link UTFactory#DoUnitTest_Interface}
 * 根据 className 打印测试案例：{@link UTFactory#PrintUTData}
 */
public class UTFactory {

    public static String SpiltExpr = "";
    public static ReflectTools reflectTools = new ReflectTools();
    public static DBTools dbTools = new DBTools();
    public static StringTools strTools = new StringTools();

    public static void PrintSpilt(Class<?> clazz) {
        String[] classNameArr = clazz.getName().split("\\.");
        // 利用 class path 的路径不相同，来决定入打印
        if (!classNameArr[0].equals(SpiltExpr)) {
            //String symbol = "    ##################    ";
            String space = "    ";
            String symbol = space + strTools.config.commonConfig.SpiltExpr + space;
            System.out.printf("\n%70s%s\n\n", symbol + classNameArr[0], symbol);
            SpiltExpr = classNameArr[0];
        }
    }

    public static void PrintUTData(String className) throws Exception {
        Class<?> classByReflect = reflectTools.GetClassName_Clazz(className);
        PrintUTData(classByReflect);
    }

    public static void PrintUTData(Class<?> clazz) {
        String className = strTools.GetCleanClassName(clazz.getName());
        // prepare SQL Data
        List<UTDataEntity> list = dbTools.UTDate_Query(dbTools.BuildSelectSQL(clazz, className));
        System.out.printf("%s 的全部测试案例：\n", className);

        Map<String, Method> instanceExecMethods = reflectTools.GetMethodAndName(clazz);
        if (instanceExecMethods.size() == 0) {
            System.out.printf("%s 未执行, 请检查%s中是否包含 Solution/solution/Method/method 的待执行方法%n", className, className);
            return;
        }

        Method instanceExecMethod = null;
        for (Method m : instanceExecMethods.values()) {
            if (m != null) {
                instanceExecMethod = m;
                break;
            }
        }
        if (instanceExecMethod == null) {
            return;
        }

        for (UTDataEntity entity : list) {
            Object[] methodInput = reflectTools.GetMethodInput(instanceExecMethod, entity);
            Object methodExpectOutput = reflectTools.GetMethodOutput(instanceExecMethod, entity);
            System.out.println("\ninput:");
            for (int i = 0; i < methodInput.length; i++) {
                if (methodInput.length > 1) {
                    System.out.printf("     input Params %d:\n     ", i);
                    reflectTools.ParamsPrint(methodInput[i]);
                }
            }
            System.out.println("output:");
            System.out.print("     ");
            reflectTools.ParamsPrint(methodExpectOutput);
        }
    }

    public static void DebugTest(Class<?> clazz) throws Exception {
        FullTest(clazz);
    }

    public static void DebugTest(String className, String input, String output) throws Exception {
        Class<?> classByReflect = reflectTools.GetClassName_Clazz(className);
        DebugTest(classByReflect, input, output);
    }

    // 用于复现测试案例
    public static void DebugTest(Class<?> clazz, String input, String output) throws Exception {

        String className = strTools.GetCleanClassName(clazz.getName());
        UTDataEntity entity = new UTDataEntity(input, output, className);
        // 应用不同的测试场景，传入的测试名也不同
        if (className.split("\\.").length > 1) {
            className = className.split("\\.")[className.split("\\.").length - 1];
        }

        // exec Class method
        List<UTDataEntity> list = new ArrayList<>();
        list.add(entity);

        reflectTools.UTExecutorWithoutPool(clazz, className, list);
    }

    // 用于接口的单元测试
    public static void DoUnitTest_Interface(Class<?> clazz, List<UTDataEntity> list) throws Exception {
        String interfaceName = strTools.GetCleanClassName(clazz.getName());
        // 对于 Interface类型的全部类，一次性将所有的测试案例都取出来
        List<Class<?>> classList = reflectTools.GetInterface_ClassList(interfaceName);
        if (list == null || list.size() == 0) { // totalTestData = list.size();// 总测试案例个数
            System.out.printf("%s 未配置测试案例，请check测试数据库\n", interfaceName);
            return;
        }
        if (classList.size() == 0) {
            System.out.printf("%s 未找到实现，请检查该接口\n", interfaceName);
            return;
        }
        System.out.printf("\n%50s %s\n", "======$$$$【" + " Interface : " + interfaceName, "】$$$$======");
        for (Class<?> cla : classList) {
            DoUnitTest(cla, list);
        }
        System.out.println();
    }

    public static void FullTestAll(Class<?>... clazz) throws Exception {
        long start = System.currentTimeMillis();
        List<UTDataEntity> UTDataList = dbTools.UTDate_Query(dbTools.BuildSelectSQL(null, ""));
        long dbTimeCost = System.currentTimeMillis() - start;

        Map<String, List<UTDataEntity>> map = new HashMap<>();
        for (UTDataEntity entity : UTDataList) {
            // 对于公用的类名，比如：{ArraySortINTF, ListSortINTF}，需要进行处理分成两个key，进行map
            String[] classNameArray = strTools.RecognizeStrArray(entity.className);
            for (String className : classNameArray) {
                if (!map.containsKey(className)) {
                    List<UTDataEntity> lists = new LinkedList<>();
                    map.put(className, lists);
                }
                map.get(className).add(entity);
            }
        }

        for (Class<?> c : clazz) {
            PrintSpilt(c);
            String cleanClassName = strTools.GetCleanClassName(c.getName());
            if (c.isInterface()) {
                // 一个方法的不同实现会统一使用一个接口的测试数据
                List<UTDataEntity> list = map.get(cleanClassName);
                DoUnitTest_Interface(c, list);
                continue;
            }

            // 是否实现了接口
            List<UTDataEntity> list = map.get(cleanClassName);
            if (list == null || list.size() == 0) {
                String interfaceName = reflectTools.GetClass_InterfaceName(cleanClassName);
                list = map.get(interfaceName);
            }
            DoUnitTest(c, list);
        }
        long totalTime = System.currentTimeMillis() - start;
        System.out.printf("Totally Run Time: %d ms, 数据库耗时：%d ms, 程序执行耗时：%d ms \n", totalTime, dbTimeCost, totalTime - dbTimeCost);
    }

    public static void FullTestAllThreadPool(Class<?>... clazz) throws Exception {

        long start = System.currentTimeMillis();
        List<UTDataEntity> list = dbTools.UTDate_Query(dbTools.BuildSelectSQL(null, ""));
        Map<String, List<UTDataEntity>> map = new HashMap<>();
        for (UTDataEntity entity : list) {
            if (!map.containsKey(entity.className)) {
                List<UTDataEntity> lists = new LinkedList<>();
                map.put(entity.className, lists);
            }
            map.get(entity.className).add(entity);
        }
        long dbTimeCost = System.currentTimeMillis() - start;

        ThreadPoollj pool = new ThreadPoollj();
        final CountDownLatch cdAnswer = new CountDownLatch(clazz.length);
        for (Class<?> c : clazz) {
            List<UTDataEntity> testData =
                    map.get(strTools.GetCleanClassName(c.getName())) == null ? map.get(strTools.GetCleanClassName(c.getName()).replaceAll("Interface", "")) : map.get(strTools.GetCleanClassName(c.getName()));
            if (testData == null || testData.size() == 0) { // totalTestData = map.get(GetClassName(c)).size() 总测试案例个数
                System.out.printf(" %s 未配置测试案例，请检查测试数据库[ThreadPool]", strTools.GetCleanClassName(c.getName()));
                return;
            }

            if (c.isInterface()) {
                // 对于 Interface类型的全部类，一次性将所有的测试案例都取出来
                List<Class<?>> classList = reflectTools.GetInterface_ClassList(c.getName());
                final CountDownLatch cdAnswer1 = new CountDownLatch(classList.size());
                for (Class<?> cla : classList) {
                    pool.SubmitTask(cla, testData, cdAnswer1);
                }
                cdAnswer1.await();
                cdAnswer.countDown();
                continue;
            }
            pool.SubmitTask(c, testData, cdAnswer);
        }
        cdAnswer.await();
        System.out.printf("Totally Run Time: %d ms, 数据库耗时：%d ms, 程序执行耗时：%d ms【FullTestAllThreadPool】\n",
                System.currentTimeMillis() - start,
                dbTimeCost,
                System.currentTimeMillis() - start - dbTimeCost);
    }

    public static void FullTest(String className) throws Exception {
        // prepare Class instance
        FullTest(reflectTools.GetClassName_Clazz(strTools.GetCleanClassName(className)));
    }

    public static void FullTest(Class<?> clazz) throws Exception {
        String className = strTools.GetCleanClassName(clazz.getName());

        // prepare SQL Data
        List<UTDataEntity> list = dbTools.UTDate_Query(dbTools.BuildSelectSQL(clazz, className));

        //GetExecUTData(list,className);

        if (list == null || list.size() == 0) {
            System.out.printf("测试案例 %s 未配置，请检查测试数据库", className);
            System.out.println();
            return;
        }

        // 如果是接口
        if (clazz.isInterface()) {
            DoUnitTest_Interface(clazz, list);
            return;
        }
       /* ThreadPoollj pool = new ThreadPoollj();
        final CountDownLatch cdAnswer = new CountDownLatch(1);
        pool.SubmitTask(clazz, list, cdAnswer);*/
        DoUnitTest(clazz, list);
    }

    public static void DoUnitTest(Class<?> clazz, List<UTDataEntity> list) throws Exception {

        String cleanClassName = strTools.GetCleanClassName(clazz.getName());
        if (list == null || list.size() == 0) {  // 兜底再次查询数据库
            System.out.printf("\n%s Error : list == null || list.size() == 0\n", clazz);
            list = dbTools.UTDate_Query(dbTools.BuildSelectSQL(clazz, cleanClassName));
            if (list == null || list.size() == 0) {
                System.out.println(cleanClassName + " 未配置测试案例，请检查测试数据库");
                return;
            }
        }
        reflectTools.UTExecutorWithoutPool(clazz, cleanClassName, list);
    }
}
