package UnitTest.DataStructureTest.treeTest.binaryTreeTest.binaryTreeImplTest;

import Common.Utils.GC.binaryTreeImpl.BinaryTree2ArrayImpl;
import DataStructure.tree.binaryTree.binaryTreeTestData.BT_TestData_Tree;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author 蔚蔚樱
 * @date 2020-02-18 18:44
 * @description 根据二叉树 创建数组【二叉树序列化】 测试案例
 * 按层：
 * 1、按层遍历二叉树 输出数组
 * S形：
 * 1、S形遍历二叉树 输出数组
 * 按序：
 * 1、先序遍历二叉树 输出数组
 * 2、中序遍历二叉树 输出数组
 * 3、后序遍历二叉树 输出数组
 * <p>
 * 说明
 * withSymbol==true 表示用特殊符号【Constant.NullLeafSymbol】来表示叶子节点的左右孩子
 * recursive==true  表示递归方式
 */

public class BinaryTree2ArrayImplTest extends BT_TestData_Tree {

    BinaryTree2ArrayImpl instance = new BinaryTree2ArrayImpl();

    //按层遍历二叉树 输出数组
    @Test
    public void BT2ArrayByLevelOutput() {
        int[] answer = instance.BT2ArrayByLevelOutput(Tree_BT_Full_Level_WithNLF_1());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_1));
        answer = instance.BT2ArrayByLevelOutput(Tree_BT_Full_Level_WithNLF_2());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_2));
        answer = instance.BT2ArrayByLevelOutput(Tree_BT_Full_Level_WithNLF_3());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_3));
        answer = instance.BT2ArrayByLevelOutput(Tree_BT_Full_Level_WithNLF_4());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_4));

        answer = instance.BT2ArrayByLevelOutput(Tree_BT_Level_WithNLF_1());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_1));
        answer = instance.BT2ArrayByLevelOutput(Tree_BT_Level_WithNLF_2());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_2));
        answer = instance.BT2ArrayByLevelOutput(Tree_BT_Level_WithNLF_3());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_3));
        answer = instance.BT2ArrayByLevelOutput(Tree_BT_Level_WithNLF_4());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_4));
        answer = instance.BT2ArrayByLevelOutput(Tree_BT_Level_WithNLF_5());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_5));
        answer = instance.BT2ArrayByLevelOutput(Tree_BT_Level_WithNLF_6());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_6));
        answer = instance.BT2ArrayByLevelOutput(Tree_BT_Level_WithNLF_7());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_7));
        answer = instance.BT2ArrayByLevelOutput(Tree_BT_Level_WithNLF_8());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_8));
        answer = instance.BT2ArrayByLevelOutput(Tree_BT_Level_WithNLF_9());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_9));
    }
    //按行打印二叉树
   /* void BT2ArrayByLevelPrint(){
        
    }*/

    //S形遍历二叉树 输出数组
    @Test
    public void BT2ArrayBySPrint() {
        int[] answer = instance.BT2ArrayBySPrint(Tree_BT_Full_Level_WithNLF_1());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_1_S_Print));
        answer = instance.BT2ArrayBySPrint(Tree_BT_Full_Level_WithNLF_2());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_2_S_Print));
        answer = instance.BT2ArrayBySPrint(Tree_BT_Full_Level_WithNLF_3());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_3_S_Print));
        answer = instance.BT2ArrayBySPrint(Tree_BT_Full_Level_WithNLF_4());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_4_S_Print));

        answer = instance.BT2ArrayBySPrint(Tree_BT_Level_WithNLF_1());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_1));
        answer = instance.BT2ArrayBySPrint(Tree_BT_Level_WithNLF_2());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_2_S_Print));
        answer = instance.BT2ArrayBySPrint(Tree_BT_Level_WithNLF_3());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_3_S_Print));
        answer = instance.BT2ArrayBySPrint(Tree_BT_Level_WithNLF_4());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_4_S_Print));
        answer = instance.BT2ArrayBySPrint(Tree_BT_Level_WithNLF_5());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_5_S_Print));
        answer = instance.BT2ArrayBySPrint(Tree_BT_Level_WithNLF_6());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_6_S_Print));
        answer = instance.BT2ArrayBySPrint(Tree_BT_Level_WithNLF_7());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_7_S_Print));
        answer = instance.BT2ArrayBySPrint(Tree_BT_Level_WithNLF_8());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_8_S_Print));
        answer = instance.BT2ArrayBySPrint(Tree_BT_Level_WithNLF_9());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_9_S_Print));
    }

    //先序遍历二叉树 输出数组【递归、单栈】
    @Test
    public void BT2ArrayByPreOrder() {
        int[] answer = instance.BT2ArrayByPreOrder(Tree_BT_Full_Level_WithNLF_1());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_1_PreOrder));
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Full_Level_WithNLF_2());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_2_PreOrder));
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Full_Level_WithNLF_3());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_3_PreOrder));
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Full_Level_WithNLF_4());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_4_PreOrder));

        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_1());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_1));
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_2());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_2_PreOrder));
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_3());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_3_PreOrder));
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_4());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_4_PreOrder));
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_5());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_5_PreOrder));
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_6());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_6_PreOrder));
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_7());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_7_PreOrder));
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_8());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_8_PreOrder));
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_9());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_9_PreOrder));
    }

    @Test
    public void BT2ArrayByPreOrder_WithSymbolAndRecursive() {
        int[] answer = instance.BT2ArrayByPreOrder(Tree_BT_Full_Level_WithNLF_1(), true, true);
        assert Arrays.equals(answer, Array_BT_Full_Level_WithNLF_1_PreOrder);
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Full_Level_WithNLF_2(), true, true);
        assert Arrays.equals(answer, Array_BT_Full_Level_WithNLF_2_PreOrder);
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Full_Level_WithNLF_3(), true, true);
        assert Arrays.equals(answer, Array_BT_Full_Level_WithNLF_3_PreOrder);
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Full_Level_WithNLF_4(), true, true);
        assert Arrays.equals(answer, Array_BT_Full_Level_WithNLF_4_PreOrder);

        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_1(), true, true);
        assert Arrays.equals(answer, Array_BT_Full_Level_WithNLF_1);
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_2(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_2_PreOrder);
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_3(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_3_PreOrder);
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_4(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_4_PreOrder);
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_5(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_5_PreOrder);
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_6(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_6_PreOrder);
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_7(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_7_PreOrder);
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_8(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_8_PreOrder);
        answer = instance.BT2ArrayByPreOrder(Tree_BT_Level_WithNLF_9(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_9_PreOrder);
    }

    //中序 遍历二叉树 输出数组【递归、单栈】
    @Test
    public void BT2ArrayByInOrder() {
        int[] answer = instance.BT2ArrayByInOrder(Tree_BT_Full_Level_WithNLF_1());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_1_InOrder));
        answer = instance.BT2ArrayByInOrder(Tree_BT_Full_Level_WithNLF_2());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_2_InOrder));
        answer = instance.BT2ArrayByInOrder(Tree_BT_Full_Level_WithNLF_3());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_3_InOrder));
        answer = instance.BT2ArrayByInOrder(Tree_BT_Full_Level_WithNLF_4());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_4_InOrder));

        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_1());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_1));
        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_2());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_2_InOrder));
        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_3());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_3_InOrder));
        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_4());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_4_InOrder));
        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_5());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_5_InOrder));
        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_6());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_6_InOrder));
        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_7());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_7_InOrder));
        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_8());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_8_InOrder));
        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_9());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_9_InOrder));
    }

    @Test
    public void BT2ArrayByInOrder_WithSymbolAndRecursive() {
        int[] answer = instance.BT2ArrayByInOrder(Tree_BT_Full_Level_WithNLF_1(), true, true);
        assert Arrays.equals(answer, Array_BT_Full_Level_WithNLF_1_InOrder);
        answer = instance.BT2ArrayByInOrder(Tree_BT_Full_Level_WithNLF_2(), true, true);
        assert Arrays.equals(answer, Array_BT_Full_Level_WithNLF_2_InOrder);
        answer = instance.BT2ArrayByInOrder(Tree_BT_Full_Level_WithNLF_3(), true, true);
        assert Arrays.equals(answer, Array_BT_Full_Level_WithNLF_3_InOrder);
        answer = instance.BT2ArrayByInOrder(Tree_BT_Full_Level_WithNLF_4(), true, true);
        assert Arrays.equals(answer, Array_BT_Full_Level_WithNLF_4_InOrder);

        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_1(), true, true);
        assert Arrays.equals(answer, Array_BT_Full_Level_WithNLF_1_InOrder);
        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_2(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_2_InOrder);
        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_3(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_3_InOrder);
        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_4(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_4_InOrder);
        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_5(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_5_InOrder);
        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_6(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_6_InOrder);
        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_7(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_7_InOrder);
        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_8(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_8_InOrder);
        answer = instance.BT2ArrayByInOrder(Tree_BT_Level_WithNLF_9(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_9_InOrder);
    }

    //后序 遍历二叉树 输出数组【递归写法、单栈法 双栈法】
    @Test
    public void BT2ArrayByPostOrder() {
        int[] answer = instance.BT2ArrayByPostOrder(Tree_BT_Full_Level_WithNLF_1());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_1_PostOrder));
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Full_Level_WithNLF_2());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_2_PostOrder));
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Full_Level_WithNLF_3());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_3_PostOrder));
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Full_Level_WithNLF_4());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_4_PostOrder));

        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_1());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Full_Level_WithNLF_1));
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_2());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_2_PostOrder));
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_3());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_3_PostOrder));
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_4());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_4_PostOrder));
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_5());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_5_PostOrder));
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_6());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_6_PostOrder));
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_7());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_7_PostOrder));
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_8());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_8_PostOrder));
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_9());
        assert Arrays.equals(answer, ReduceNLF(Array_BT_Level_WithNLF_9_PostOrder));
    }

    @Test
    public void BT2ArrayByPostOrder_WithSymbolAndRecursive() {
        int[] answer = instance.BT2ArrayByPostOrder(Tree_BT_Full_Level_WithNLF_1(), true, true);
        assert Arrays.equals(answer, Array_BT_Full_Level_WithNLF_1_PostOrder);
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Full_Level_WithNLF_2(), true, true);
        assert Arrays.equals(answer, Array_BT_Full_Level_WithNLF_2_PostOrder);
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Full_Level_WithNLF_3(), true, true);
        assert Arrays.equals(answer, Array_BT_Full_Level_WithNLF_3_PostOrder);
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Full_Level_WithNLF_4(), true, true);
        assert Arrays.equals(answer, Array_BT_Full_Level_WithNLF_4_PostOrder);

        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_1(), true, true);
        assert Arrays.equals(answer, Array_BT_Full_Level_WithNLF_1_PostOrder);
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_2(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_2_PostOrder);
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_3(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_3_PostOrder);
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_4(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_4_PostOrder);
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_5(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_5_PostOrder);
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_6(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_6_PostOrder);
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_7(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_7_PostOrder);
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_8(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_8_PostOrder);
        answer = instance.BT2ArrayByPostOrder(Tree_BT_Level_WithNLF_9(), true, true);
        assert Arrays.equals(answer, Array_BT_Level_WithNLF_9_PostOrder);
    }
}
