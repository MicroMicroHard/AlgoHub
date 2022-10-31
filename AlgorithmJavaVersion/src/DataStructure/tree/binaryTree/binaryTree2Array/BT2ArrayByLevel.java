package DataStructure.tree.binaryTree.binaryTree2Array;

import Common.Utils.UTFactory;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import org.junit.Test;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/14 12:12
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 1、按行打印二叉树 【按层输出遍历的数组】
 * 2、按层遍历二叉树 输出数组
 * @blogURL
 */
public class BT2ArrayByLevel {

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

    // 2、按层遍历二叉树 输出数组
    public int[] Trans2ArrayMethod(BinaryTreeImpl root) {
        return null;
    }

    // 1、按行打印二叉树
    public void Print() {

    }
}
