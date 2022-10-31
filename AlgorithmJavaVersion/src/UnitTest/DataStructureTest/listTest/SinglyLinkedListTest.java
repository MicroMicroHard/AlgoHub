package UnitTest.DataStructureTest.listTest;

import Common.Utils.ArrayTools;
import DataStructure.list.Nodelj;
import DataStructure.list.listRealize.SinglyLinkedList;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/6 21:16
 * @author-Email micromicrohard@outlook.com
 * @description 单链表
 * 单链表的插入：数组和单个元素 （头插和尾插）
 * 单链表的删除：删除特定元素和指定位置元素
 * 单链表的查找：查找特定元素和指定位置元素
 * 单链表的相等：判断两个链表是否相等、自身对比
 * 单链表的清除：置空单链表
 * @blogURL
 */
public class SinglyLinkedListTest {

    @Test
    public void TestSinglyLinkedList() {
        SinglyLinkedList list = new SinglyLinkedList();
        // 验证插入指定元素
        list.insert(true, 2);            // => 2
        list.insert(true, new Nodelj(4), new Nodelj(3));// => 3,4,2
        list.insert(true, new Nodelj(1));// => 1,3,4,2
        list.insert(true, 9, 10);        // => 10,9,1,3,4,2
        list.insert(false, 5);             // => 10,9,1,3,4,2,5
        list.insert(false, new Nodelj(6)); // => 10,9,1,3,4,2,5,6
        list.insert(false, 7, 8);          // => 10,9,1,3,4,2,5,6,7,8
        assert ArrayTools.IntArrayEquals(list.toArray(), new int[]{10, 9, 1, 3, 4, 2, 5, 6, 7, 8});

        // 删除指定元素
        list.delete(new Nodelj(6)); // => 10,9,1,3,4,2,5,7,8
        list.delete(true);    // => 9,1,3,4,2,5,7,8
        list.delete(false);   // => 9,1,3,4,2,5,7
        list.deleteIndex(1);              // => 9,3,4,2,5,7
        list.deleteIndex(4);              // => 9,3,4,2,7
        list.deleteIndex(50);             // => 9,3,4,2,7
        list.delete(false);   // => 9,3,4,2
        assert ArrayTools.IntArrayEquals(list.toArray(), new int[]{9, 3, 4, 2});

        // 链表查找函数[查找指定元素],查找成功，返回该坐标的值,查找失败，返回 Integer.MIN_VALUE
        assert 0 == list.searchValue(9);  // => 9, 3, 4, 2
        assert -1 == list.searchValue(19);
        assert 1 == list.searchValue(new Nodelj(3));
        assert -1 == list.searchValue(new Nodelj(13));
        assert 2 == list.searchIndex(3);
        assert -1 == list.searchIndex(30);

        // 链表判断相等
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insert(false, 9, 3, 4, 2);
        assert list.listEquals(list2);
        assert list.listEquals(list, list2);

        // 链表置空操作
        list.clear();
        assert list.size() == 0;
    }
}
