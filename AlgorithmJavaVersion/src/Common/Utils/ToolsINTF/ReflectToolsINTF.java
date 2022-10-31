package Common.Utils.ToolsINTF;

import Common.MidwareConn.DBConn.MYSQLConn.UTDataEntity;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public interface ReflectToolsINTF {
    // get class name、method  获取结构体的名字，如果是接口，则返回 InterfaceName 接口名
    Map<String, Method> GetMethodAndName(Class<?> classByReflect);//获取含有method和solution的 方法数组和方法名数组
    void initReflectTools();                         // 初始化 className_Path_Map、className_Clazz_Map、clazz_Interface_Map、interface_Clazz_Map
    void init_Interface_ClazzMap();                  // 获取项目下 接口 interfaceName 下所有的类
    void init_ClassName_PathMap(String path);        // 根据path 初始化 className_Path_Map / className_Class_Map
    String get_ClassName_Path(String className);     // 根据类名 获取项目下文件名对应的路径
    String GetClass_InterfaceName(String className); // 根据类 获取类实现的接口名【接口名以INTF结尾】
    Class<?> GetClassName_Clazz(String className);   // 根据类名 获取类
    List<Class<?>> GetInterface_ClassList(String interfaceName);//根据接口名 获取所有的实现类

    // get params
    Object[] GetMethodInput(Method method, UTDataEntity entity);// 转换方法的输入
    Object GetMethodOutput(Method method, UTDataEntity entity); // 转换方法的输出
    Object ParamsRecognize(String context, String paramsType);  // 将string转换成入参类型
    void ParamsPrint(Object obj1);                              // print params
    boolean ParamsEquals(Object obj1, Object obj2);             // judge params equals

    // exec method、judge result
    int MethodExec(Object instance, Method instanceExecMethod, UTDataEntity entity);//执行反射方法
    void UTExecutorWithoutPool(Class<?> classByReflect, String className, List<UTDataEntity> list);
}
