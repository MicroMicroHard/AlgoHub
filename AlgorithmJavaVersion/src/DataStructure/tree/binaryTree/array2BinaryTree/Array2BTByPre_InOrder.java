package DataStructure.tree.binaryTree.array2BinaryTree;

import Common.Utils.UTFactory;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/14 12:15
 * @author-Email micromicrohard@outlook.com
 * @description 已知前序遍历序列和中序遍历序列，
 * 构建唯一一棵确定的二叉树。【递归、非递归解法】
 * @blogURL
 */
public class Array2BTByPre_InOrder {

    @Test // 验证功能：从数据库获取测试数据，用于单元测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误的测试案例
    public void DoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    public BinaryTreeImpl Method(int[] array_pre, int[] array_in) {
        if (array_pre == null || array_pre.length == 0 ||
                array_in == null || array_in.length == 0 ||
                array_in.length != array_pre.length) {
            return null;
        }
        return null;
    }
    public BinaryTreeImpl Method_Recursive(int[] array_pre, int[] array_in) {
        if (array_pre == null || array_pre.length == 0 ||
                array_in == null || array_in.length == 0 ||
                array_in.length != array_pre.length) {
            return null;
        }
        return null;
    }
}
