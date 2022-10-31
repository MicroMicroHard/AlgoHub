package DataStructure.tree.binaryTree.binaryTree2Array;

import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/14 12:13
 * @author-Email micromicrohard@outlook.com
 * @description 输出树的左视图
 * @blogURL
 */
public class BT2ArrayByLeftView {

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
}
