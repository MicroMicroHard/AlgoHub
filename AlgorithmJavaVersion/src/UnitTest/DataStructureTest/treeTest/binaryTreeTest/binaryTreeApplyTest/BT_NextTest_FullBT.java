package UnitTest.DataStructureTest.treeTest.binaryTreeTest.binaryTreeApplyTest;

import DataStructure.tree.binaryTree.binaryTreeApply.BT_Next;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import DataStructure.tree.binaryTree.binaryTreeTestData.BT_TestData_Tree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-7-21 10:57:09
 * @author-Email micromicrohard@outlook.com
 * @description 填充节点 测试案例
 * 填充每个节点的下一个右侧节点指针 题目见链接
 * @blogURL https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */

public class BT_NextTest_FullBT extends BT_TestData_Tree {

    @Test
    public void TestBT_Full_Next() {
        test(new BT_Next());
    }

    public void test(BT_Next bt) {
        BinaryTreeImpl answer = bt.connect(demo01);
        assert Arrays.equals(target01, BuildArrayFromBT_Full_Next(answer));
        /*answer = bt.connect(demo02);
        assert Arrays.equals(target02, BuildArrayFromBT_Full_Next(answer));*/
    }

    BinaryTreeImpl demo01 = null;
    int[] target01 = {};


    public int[] BuildArrayFromBT_Full_Next(BinaryTreeImpl root) {
        if (root == null) {
            return new int[]{};
        }
        List list = new ArrayList();
        BinaryTreeImpl head = root;
        while (head != null) {
            BinaryTreeImpl nextHead = head.left;
            while (head != null) {
                list.add(head.value);
                head = head.next;
            }
            head = nextHead;
        }
        int[] arrayValue = list.stream().mapToInt(x -> (int) x).toArray();
        return arrayValue;
    }
}
