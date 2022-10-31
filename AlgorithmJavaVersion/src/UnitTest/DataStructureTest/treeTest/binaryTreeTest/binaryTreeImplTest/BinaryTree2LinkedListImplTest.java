package UnitTest.DataStructureTest.treeTest.binaryTreeTest.binaryTreeImplTest;

import DataStructure.list.Listlj;
import DataStructure.list.listRealize.SinglyLinkedList;
import DataStructure.tree.binaryTree.BinaryTree2LinkedListImpl;
import UnitTest.DataStructureTest.treeTest.binaryTreeTest.binaryTreeTestData.BT_TestData_Tree;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/11/4
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 二叉树转链表 测试案例
 */
public class BinaryTree2LinkedListImplTest extends BT_TestData_Tree {

    BinaryTree2LinkedListImpl bt = new BinaryTree2LinkedListImpl();

    @Test
    public void test() {
        Listlj list = bt.BinaryTree2LinkedList(Tree_BT_Level_WithNLF_1());
        assert list == null;

        list = bt.BinaryTree2LinkedList(Tree_BT_Level_WithNLF_2());
        SinglyLinkedList listlj = new SinglyLinkedList();
        listlj.insert(false, binaryTree2LinkedListDemo3);
        assert list.listEquals(listlj);

        list = bt.BinaryTree2LinkedList(Tree_BT_Level_WithNLF_3());
        listlj.clear();
        listlj.insert(false, binaryTree2LinkedListDemo4);
        assert list.listEquals(listlj);

        list = bt.BinaryTree2LinkedList(Tree_BT_Level_WithNLF_4());
        listlj.clear();
        listlj.insert(false, binaryTree2LinkedListDemo5);
        assert list.listEquals(listlj);

        list = bt.BinaryTree2LinkedList(Tree_BT_Level_WithNLF_5());
        listlj.clear();
        listlj.insert(false, binaryTree2LinkedListDemo5_fake);
        assert !list.listEquals(listlj);
    }

    int[] binaryTree2LinkedListDemo3 = {1, 2, 4, 5, 3, 6, 7};
    int[] binaryTree2LinkedListDemo4 = {1, 2, 4, 3, 7};
    int[] binaryTree2LinkedListDemo5 = {1, 2, 4, 9, 13, 14, 6, 3, 7, 10, 15, 16, 17, 18, 19, 11, 8, 12, 5, 20};
    int[] binaryTree2LinkedListDemo5_fake = {1, 2, 4, 5, 3, 6, 7};
}
