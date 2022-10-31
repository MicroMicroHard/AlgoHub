package UnitTest.DataStructureTest.sortTest.innerSortTest.innerSortImplTest;

import DataStructure.sort.innerSort.innerSortImpl.InsertSort;
import DataStructure.sort.innerSort.listSort.ListInsertSort;
import DataStructure.list.Listlj;
import DataStructure.list.listRealize.SinglyLinkedList;
import UnitTest.DataStructureTest.sortTest.innerSortTest.SortTest;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020-02-11 15:12
 * @author-Email micromicrohard@outlook.com
 * @description 插入排序的测试案例
 * @blogURL
 */
public class InsertSortTest extends SortTest {

    @Test
    //@Benchmark
    //@BenchmarkMode(Mode.Throughput)
    public void TestInnerSortRealize() {
        super.TestInnerSortRealize(new InsertSort());
    }

    Listlj listlj = new SinglyLinkedList();
    InsertSort insertSort = new InsertSort();
    ListInsertSort linkInsertSort = new ListInsertSort();


    /*@Test
    public void TestInnerSortRealize1() throws Exception {
        //两种不同获取反射结果的方式
        //Map<String, int[]> arrayMap = getSortTestData1();
        Map<String, int[]> arrayMap = getSortTestData2();

        for (String s : arrayMap.keySet()) {
            int[] arr = arrayMap.get(s);
            int[] arrCopy = Arrays.copyOf(arr, arr.length);
            insertSort.sortMethod(arr);
            listlj.clear();
            listlj.insert(false, arrCopy);
            linkInsertSort.sortMethod(listlj);
            int[] targetArr = listlj.toArray();
            assert Arrays.equals(targetArr, arr);
        }
    }*/

    private Map getSortTestData1() throws Exception {
        Map<String, int[]> map = new HashMap<>();
        Class c = Class.forName("UnitTest.DataStructureTest.arrayAndListTest.listTest.ListljTest");
        Object gg = c.newInstance();
        Field[] f = c.getDeclaredFields();
        for (Field f1 : f) {
            if (f1.getName().contains("array0")) {
                Method m = c.getMethod("get" + getMethodName(f1.getName()));
                Object o = m.invoke(gg);
                if (o instanceof int[]) {
                    int[] array = (int[]) o;
                    map.put(f1.getName(), array);
                }
            }
        }
        return map;
    }

    //将首字母大写
    public String getMethodName(String fildeName) throws Exception {
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }


   /* public Map getSortTestData2() throws Exception {
        Class c = Class.forName("UnitTest.DataStructureTest.arrayAndListTest.listTest.ListljTest");
        ListljTest gg = (ListljTest) c.newInstance();
        Field[] f = c.getDeclaredFields();
        Map<String, Object> map = Arrays.stream(f)
                .filter(x -> x.getName().contains("array0"))
                //此处添加了方法的返回值判断
                .filter(x -> x.getType().getName().equals("[I"))
                .collect(Collectors.toMap(Field::getName, field -> {
                    Object resultObj = null;
                    field.setAccessible(true);
                    try {
                        resultObj = field.get(gg);
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return Optional.ofNullable(resultObj).orElse(new int[]{});
                }, (k1, k2) -> k2));
        return map;
    }*/
}
