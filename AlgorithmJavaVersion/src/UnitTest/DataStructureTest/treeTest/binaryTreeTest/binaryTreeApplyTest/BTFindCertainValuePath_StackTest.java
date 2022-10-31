package UnitTest.DataStructureTest.treeTest.binaryTreeTest.binaryTreeApplyTest;

import DataStructure.tree.binaryTree.binaryTreeApply.BTFindCertainValuePath_Stack;
import org.junit.Test;

/**
 * @author liujun
 * @date 2020-02-21 09:20
 * @description  测试二叉树中和为某一值的路径
 */

public class BTFindCertainValuePath_StackTest extends BTFindCertainValuePathTest{

    @Test
    public void TestFindPath(){
        super.TestFindPath(new BTFindCertainValuePath_Stack());
    }
}
