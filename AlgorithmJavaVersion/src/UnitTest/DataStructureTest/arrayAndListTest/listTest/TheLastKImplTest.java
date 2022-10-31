package UnitTest.DataStructureTest.arrayAndListTest.listTest;

import DataStructure.list.Listlj;
import DataStructure.list.Nodelj;
import DataStructure.list.listRealize.SinglyLinkedList;
import DataStructure.list.listRealize.TheLastKImpl;
import Common.Constant.C;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/6
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 输出链表的倒数第K个元素 测试案例
 */
public class TheLastKImplTest {

    TheLastKImpl tk = new TheLastKImpl();
    Listlj listlj = new SinglyLinkedList();
    Nodelj node = new Nodelj();

    // 查找链表的倒数第K个元素
    @Test
    public void TestFindTheLastK() throws Exception {
        Nodelj root = node.Array2Nodelj(demo011);
        int answer = tk.findTheLastK(root, demo011LastK);
        assert answer == demo011AfterSearch;

        root = node.Array2Nodelj(demo012);
        answer = tk.findTheLastK(root, demo012LastK);
        assert answer == demo012AfterSearch;

        root = node.Array2Nodelj(demo013);
        answer = tk.findTheLastK(root, demo013LastK);
        assert answer == demo013AfterSearch;

        root = node.Array2Nodelj(demo01);
        answer = tk.findTheLastK(root, lastK);
        assert answer == target01;

        root = node.Array2Nodelj(demo03);
        answer = tk.findTheLastK(root, lastK);
        assert answer == target03;

        root = node.Array2Nodelj(demo04);
        answer = tk.findTheLastK(root, lastK);
        assert answer == target04;

        root = node.Array2Nodelj(demo05);
        answer = tk.findTheLastK(root, lastK);
        assert answer == target05;
    }

    //删除链表的倒数第K个元素
    public void TestDeleteTheLastK() throws Exception {

    }

    @Test
    public void testgetlastk() throws Exception {
        test("getlastk");
    }

    @Test
    public void testgetlastk1() throws Exception {
        test("getlastk1");
    }

    @Test
    public void testgetlastk_recursion() throws Exception {
        test("getlastk_recursion");
    }


    private void test(String method0) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class clz = Class.forName("DataStructure.list.listRealize.TheLastKImpl");
        //反射获取方法，需要注意属性：int[].class
        Method method = clz.getMethod(method0, Listlj.class, int.class);
        Constructor appleConstructor = clz.getConstructor();
        Object TheLastK = appleConstructor.newInstance();

        listlj.clear();
        listlj.insert(false, demo01);
        int answer = (int) method.invoke(TheLastK, listlj, 5);
        assert answer == target01;


        listlj.clear();
        listlj.insert(false, demo02);
        answer = (int) method.invoke(TheLastK, listlj, 5);
        assert answer == target02;

        listlj.clear();
        listlj.insert(false, demo03);
        answer = (int) method.invoke(TheLastK, listlj, 5);
        assert answer == target03;

        listlj.clear();
        listlj.insert(false, demo04);
        answer = (int) method.invoke(TheLastK, listlj, 5);
        assert answer == target04;

        listlj.clear();
        listlj.insert(false, demo05);
        answer = (int) method.invoke(TheLastK, listlj, 5);
        assert answer == target05;

        listlj.clear();
        listlj.insert(false, demo06);
        answer = (int) method.invoke(TheLastK, listlj, 5);
        assert answer == target06;
    }

    // 链表长度等于K
    int[] demo011 = {1, 2, 3, 4, 5};
    int[] demo011AfterDelete = {2, 3, 4, 5};
    int demo011LastK = 5;
    int demo011AfterSearch = 1;

    // 链表长度大于K
    int[] demo012 = {6, 1, 2, 3, 4, 5};
    int[] demo012AfterDelete = {6, 2, 3, 4, 5};
    int demo012LastK = 5;
    int demo012AfterSearch = 1;

    // 链表长度小于K
    int[] demo013 = {2, 3, 4, 5};
    int[] demo013AfterDelete = {2, 3, 4, 5};
    int demo013LastK = 5;
    int demo013AfterSearch = C.ErrorNum;

    // 空
    int[] demo03 = {};
    int target03 = C.ErrorNum;
    int[] demo04 = null;
    int target04 = C.ErrorNum;

    int lastK = 5;
    int[] demo01 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    int target01 = 6;
    int[] demo02 = {7, 3, 8, 5, 9, 7, 6, 5, 9};
    int target02 = 9;
    int[] demo05 = {9, 8, 7, 6, 5};
    int target05 = 9;
    int[] demo06 = {0, 96, 5, 43, 456, 78, 909, 87, 65, 4, 3, 4, 5, 7, 8, 9, 0, 9, 8, 765, 43, 456, 7898, 765, 90};
    int target06 = 43;
}
