package UnitTest.DataStructureTest.treeTest.binaryTreeTest.binaryTreeApplyTest;

import DataStructure.tree.binaryTree.binaryTreeApply.BT_NearestCommonParent_Recursion;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import DataStructure.tree.binaryTree.binaryTreeApply.BT_NearestCommonParent;
import DataStructure.tree.binaryTree.binaryTreeTestData.BT_TestData_Tree;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/11/5
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 查找最近公共父节点 测试案例
 */
public class BT_NearestCommonParentTest extends BT_TestData_Tree {

    @Test
    public void testfindNCP_Recursion() {
        test(new BT_NearestCommonParent_Recursion());
    }

    @Test
    public void testfindNCP() {
        test(new BT_NearestCommonParent());
    }

    public void test(BT_NearestCommonParent instance) {
        BinaryTreeImpl targetNode = instance.findNCP(Tree_BT_Level_WithNLF_1(), 1, 1);
        assert targetNode.value == 1;
        targetNode = instance.findNCP(Tree_BT_Level_WithNLF_1(), 5, 337);
        assert targetNode == null;
        targetNode = instance.findNCP(Tree_BT_Level_WithNLF_2(), 2, 1);
        assert targetNode.value == 1;
        targetNode = instance.findNCP(Tree_BT_Level_WithNLF_2(), 5, 337);
        assert targetNode == null;
        targetNode = instance.findNCP(Tree_BT_Level_WithNLF_3(), 2, 3);
        assert targetNode.value == 2;
        targetNode = instance.findNCP(Tree_BT_Level_WithNLF_3(), 5, 337);
        assert targetNode == null;
        targetNode = instance.findNCP(Tree_BT_Level_WithNLF_4(), 6, 7);
        assert targetNode.value == 3;
        targetNode = instance.findNCP(Tree_BT_Level_WithNLF_4(), 5, 337);
        assert targetNode == null;
        targetNode = instance.findNCP(Tree_BT_Level_WithNLF_5(), 5, 7);
        assert targetNode.value == 4;
        targetNode = instance.findNCP(Tree_BT_Level_WithNLF_5(), 335, 7);
        assert targetNode == null;
        targetNode = instance.findNCP(Tree_BT_Level_WithNLF_6(), 11, 12);
        assert targetNode.value == 6;
        targetNode = instance.findNCP(Tree_BT_Level_WithNLF_6(), 335, 7);
        assert targetNode == null;
        targetNode = instance.findNCP(Tree_BT_Level_WithNLF_7(), 5, 18);
        assert targetNode.value == 4;
        targetNode = instance.findNCP(Tree_BT_Level_WithNLF_7(), 335, 7);
        assert targetNode == null;
        targetNode = instance.findNCP(Tree_BT_Level_WithNLF_8(), 25, 17);
        assert targetNode.value == 1;
        targetNode = instance.findNCP(Tree_BT_Level_WithNLF_8(), 335, 7);
        assert targetNode == null;
        targetNode = instance.findNCP(Tree_BT_Level_WithNLF_9(), 6, 8);
        assert targetNode.value == 6;
        targetNode = instance.findNCP(Tree_BT_Level_WithNLF_9(), 6, 11);
        assert targetNode == null;
    }
   /* public void test(BT_NearestCommonParent instance) {
        BinaryTreeImpl targetNode = instance.findNCP(BinaryTreeBuildDemo.getBinaryTreeDemo3(), 5, 7);
        assert targetNode.value == 1;
        targetNode = instance.findNCP(BinaryTreeBuildDemo.getBinaryTreeDemo3(), 1, 7);
        assert targetNode.value == 1;
        targetNode = instance.findNCP(BinaryTreeBuildDemo.getBinaryTreeDemo3(), 7, 1);
        assert targetNode.value == 1;

        // 反案例
        targetNode = instance.findNCP(BinaryTreeBuildDemo.getBinaryTreeDemo3(), 1, 9);
        assert targetNode == null;

        targetNode = instance.findNCP(BinaryTreeBuildDemo.getBinaryTreeDemo3(), 7, 9);
        assert targetNode != null;
        targetNode = instance.findNCP(BinaryTreeBuildDemo.getBinaryTreeDemo3(), 1, 9);
        assert targetNode != null;

        targetNode = instance.findNCP(BinaryTreeBuildDemo.getBinaryTreeDemo3(), 5, 3);
        assert targetNode.value == 1;
        targetNode = instance.findNCP(BinaryTreeBuildDemo.getBinaryTreeDemo3(), 6, 7);
        assert targetNode.value == 3;
        targetNode = instance.findNCP(BinaryTreeBuildDemo.getBinaryTreeDemo4(), 2, 7);
        assert targetNode.value == 1;
        targetNode = instance.findNCP(BinaryTreeBuildDemo.getBinaryTreeDemo5(), 15, 5);
        assert targetNode.value == 3;
        targetNode = instance.findNCP(BinaryTreeBuildDemo.getBinaryTreeDemo5(), 10, 19);
        assert targetNode.value == 10;
        targetNode = instance.findNCP(BinaryTreeBuildDemo.getBinaryTreeDemo5(), 17, 18);
        assert targetNode.value == 17;
    }*/
}
