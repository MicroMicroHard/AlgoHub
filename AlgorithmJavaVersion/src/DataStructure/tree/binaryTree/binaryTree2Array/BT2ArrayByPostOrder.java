package DataStructure.tree.binaryTree.binaryTree2Array;

import Common.Utils.UTFactory;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import org.junit.Test;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/14 12:09
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 后序 遍历二叉树 输出数组
 * 递归写法、
 * 单栈法、
 * 双栈法
 * @blogURL
 */
public class BT2ArrayByPostOrder {

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

    // 后序 遍历二叉树 输出数组【单栈法】
    public int[] Method_Stack(BinaryTreeImpl root) {
        if (root == null) {
            return null;
        }
        return null;
    }

    // 后序 遍历二叉树 输出数组【双栈法】
    public int[] Method_DoubleStack(BinaryTreeImpl root) {
        if (root == null) {
            return null;
        }
        return null;
    }

    // 后序 遍历二叉树 输出数组【递归写法】
    public int[] Method_Recursive(BinaryTreeImpl root) {
        if (root == null) {
            return null;
        }
        return null;
    }
}
