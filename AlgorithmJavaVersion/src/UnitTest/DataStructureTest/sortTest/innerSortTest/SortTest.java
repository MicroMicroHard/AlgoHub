package UnitTest.DataStructureTest.sortTest.innerSortTest;

import Common.Utils.ArrayTools;
import DataStructure.sort.innerSort.ArraySortINTF;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020-02-11 14:59
 * @author—Email micromicrohard@outlook.com
 * @description
 * @blogURL 排序算法的主要测试类
 */
//@State(Scope.Thread)
public class SortTest extends SortTestData {

    public int[] arrayData;
    public int[] arrayDataOrigin;
    public static Map<String, int[]> mapArray;
    public static Map<String, int[]> mapExpected;

    {
        mapArray = new HashMap<>();
        mapExpected = new HashMap<>();
        try {
            getDataArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TestInnerSortRealize(ArraySortINTF arraySortINTF) {
        for (String arrayKey : mapArray.keySet()) {
            arrayDataOrigin = mapArray.get(arrayKey);
            arrayData = new int[arrayDataOrigin.length];
            System.arraycopy(arrayDataOrigin, 0, arrayData, 0, arrayDataOrigin.length);
            // sort method
            arraySortINTF.sortMethod(arrayData);
            assert ArrayTools.IntArrayEquals(arrayDataOrigin, arrayData, mapExpected.get(arrayKey));
        }
    }

    public static void getDataArray() throws Exception {
        String path = "UnitTest.DataStructureTest.sortTest.innerSortTest.SortTestData";
        Class<?> c = Class.forName(path);
        Object arrayTestDemoDataInstance = c.newInstance();
        Field[] f = c.getDeclaredFields();

        Method m;
        Object o;
        String arr = "arr";
        String expected = "expected";

        for (Field f1 : f) {
            m = c.getMethod("get" + getMethodName(f1.getName()));
            o = m.invoke(arrayTestDemoDataInstance);
            if (o instanceof int[]) {
                int[] array = (int[]) o;
                // 获取arr数组
                if (f1.getName().contains(arr)) {
                    mapArray.put(f1.getName().replace(arr, ""), array);
                }
                // 获取expected数组
                if (f1.getName().contains(expected)) {
                    mapExpected.put(f1.getName().replace(expected, ""), array);
                }
            }
        }
    }

    //将首字母大写
    private static String getMethodName(String fildeName) throws Exception {
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }
}
