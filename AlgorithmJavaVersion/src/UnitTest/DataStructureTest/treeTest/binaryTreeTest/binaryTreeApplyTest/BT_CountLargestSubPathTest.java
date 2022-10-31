package UnitTest.DataStructureTest.treeTest.binaryTreeTest.binaryTreeApplyTest;

import DataStructure.tree.binaryTree.binaryTreeApply.BTFindLargestSubPath_NonRecursion;
import DataStructure.tree.binaryTree.binaryTreeApply.BTFindLargestSubPath_Recursion;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import DataStructure.tree.binaryTree.binaryTreeTestData.BT_TestData_Tree;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author 蔚蔚樱
 * @date 2020-02-20 11:41
 * @description 计算二叉树中最大的子树路径和 测试案例
 */
public class BT_CountLargestSubPathTest extends BT_TestData_Tree {

    BTFindLargestSubPath_Recursion instance = new BTFindLargestSubPath_Recursion();

    @Test
    public void TestcountLargestSubPath() {
        //注意：此处传入空对象，输出的是{}
        int[] arrayValue = instance.countLargestSubPath(Tree_BT_Level_WithNLF_1());
        assert Arrays.equals(arrayValue, Demo01);
        arrayValue = instance.countLargestSubPath(new BinaryTreeImpl());
        assert Arrays.equals(arrayValue, Demo02);
        arrayValue = instance.countLargestSubPath(Tree_BT_Level_WithNLF_1());
        assert Arrays.equals(arrayValue, Demo03);
        arrayValue = instance.countLargestSubPath(Tree_BT_Level_WithNLF_1());
        assert Arrays.equals(arrayValue, Demo04);
        arrayValue = instance.countLargestSubPath(Tree_BT_Level_WithNLF_1());
        assert Arrays.equals(arrayValue, Demo05);
    }

    @Test
    public void TestBTFindLargestSubPath_Recursion() {
        test(new BTFindLargestSubPath_Recursion());
    }

    @Test
    public void TestBTFindLargestSubPath_NonRecursion() {
        test(new BTFindLargestSubPath_NonRecursion());
    }

    public void test(BTFindLargestSubPath_Recursion instance) {
        int sum = instance.countLargestSum(Tree_BT_Level_WithNLF_1());
        assert sum == 0;
        sum = instance.countLargestSum(new BinaryTreeImpl());
        assert sum == 0;
        sum = instance.countLargestSum(Tree_BT_Level_WithNLF_1());
        assert sum == 11;
        sum = instance.countLargestSum(Tree_BT_Level_WithNLF_1());
        assert sum == 11;
        sum = instance.countLargestSum(Tree_BT_Level_WithNLF_1());
        assert sum == 91;
    }

    int[] Demo01 = {};
    int[] Demo02 = {};
    int[] Demo03 = {1, 3, 7};
    int[] Demo04 = {1, 3, 7};
    int[] Demo05 = {1, 3, 7, 10, 16, 17, 18, 19};
}
