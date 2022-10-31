package UnitTest.DataStructureTest.treeTest.binaryTreeTest.binaryTreeApplyTest;

import DataStructure.tree.binaryTree.binaryTreeApply.BT_JumpLevelSum;
import DataStructure.tree.binaryTree.binaryTreeImpl.Array2BinaryTreeImpl;
import UnitTest.DataStructureTest.treeTest.binaryTreeTest.binaryTreeTestData.BT_TestData_Tree;
import org.junit.Test;

public class BT_JumpLevelSumTest extends BT_TestData_Tree {

    Array2BinaryTreeImpl btree = new Array2BinaryTreeImpl();

    @Test
    public void testBT_JumpLevelSum() {
        test(new BT_JumpLevelSum());
    }

    public void test(BT_JumpLevelSum bt) {
        int answer = bt.rob(btree.createBTByLevelNonRecursive(demo01));
        assert answer == target01;
        answer = bt.rob(btree.createBTByLevelNonRecursive(demo02));
        assert answer == target02;
    }

    int[] demo01 = {3, 2, 3, NLF, 3, NLF, 1};
    int target01 = 7;
    int[] demo02 = {3, 4, 5, 1, 3, NLF, 1};
    int target02 = 9;
}
