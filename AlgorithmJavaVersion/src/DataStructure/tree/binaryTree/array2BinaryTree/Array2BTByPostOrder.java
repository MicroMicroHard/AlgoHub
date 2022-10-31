package DataStructure.tree.binaryTree.array2BinaryTree;

import Common.Utils.UTFactory;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import org.junit.Test;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/14 12:15
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 按后序遍历的方式输入的数组
 * 构造成一个二叉树（特殊符号）【递归、非递归解法】
 * @blogURL
 */
public class Array2BTByPostOrder {

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

    public BinaryTreeImpl Method(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return null;
    }

    public BinaryTreeImpl Method_Recursive(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return null;
    }
}
