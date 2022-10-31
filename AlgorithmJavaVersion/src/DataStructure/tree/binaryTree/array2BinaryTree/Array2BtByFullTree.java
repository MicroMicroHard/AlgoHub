package DataStructure.tree.binaryTree.array2BinaryTree;

import Common.Utils.UTFactory;
import DataStructure.list.Nodelj;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/11/4 01:58
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 将按照完全二叉树输入的数组 构造成一个完全二叉树
 * @blogURL
 */
public class Array2BtByFullTree {

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
}
