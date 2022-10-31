package UnitTest.DataStructureTest.treeTest.binaryTreeTest.binaryTreeImplTest;

import DataStructure.tree.binaryTree.BinaryTreeImpl;
import UnitTest.DataStructureTest.treeTest.binaryTreeTest.binaryTreeTestData.BT_TestData_Tree;
import org.junit.Test;

/**
 * @author liujun
 * @date 2020-02-18 18:47
 * @description 二叉树 ： 判断两个二叉树相等
 */
public class BinaryTreeImplTest extends BT_TestData_Tree {

    BinaryTreeImpl binaryTreeDemo = new BinaryTreeImpl();

    @Test
    public void testEquals() {
        assert binaryTreeDemo.equals(null, null);
        assert !binaryTreeDemo.equals(null, Tree_BT_Level_WithNLF_7());
        assert !binaryTreeDemo.equals(Tree_BT_Level_WithNLF_7(), null);
        assert !binaryTreeDemo.equals(null, Tree_BT_Level_WithNLF_7());
        assert !binaryTreeDemo.equals(Tree_BT_Level_WithNLF_7(), Tree_BT_Level_WithNLF_7());
        assert binaryTreeDemo.equals(Tree_BT_Level_WithNLF_5(), Tree_BT_Level_WithNLF_5());
        assert binaryTreeDemo.equals(Tree_BT_Level_WithNLF_6(), Tree_BT_Level_WithNLF_6());
        assert !binaryTreeDemo.equals(Tree_BT_Level_WithNLF_5(), Tree_BT_Level_WithNLF_6());
    }

    @Test
    public void testEqualsSingle() {
        assert !binaryTreeDemo.equals(null);
        assert !binaryTreeDemo.equals(Tree_BT_Level_WithNLF_7());
        assert !binaryTreeDemo.equals(Tree_BT_Level_WithNLF_4());
        binaryTreeDemo = Tree_BT_Level_WithNLF_3();
        assert !binaryTreeDemo.equals(null);
        binaryTreeDemo = Tree_BT_Level_WithNLF_4();
        assert !binaryTreeDemo.equals(Tree_BT_Level_WithNLF_5());
        binaryTreeDemo = Tree_BT_Level_WithNLF_5();
        assert binaryTreeDemo.equals(Tree_BT_Level_WithNLF_5());
        assert !binaryTreeDemo.equals(Tree_BT_Level_WithNLF_6());
        binaryTreeDemo = Tree_BT_Level_WithNLF_6();
        assert binaryTreeDemo.equals(Tree_BT_Level_WithNLF_6());
    }
}
