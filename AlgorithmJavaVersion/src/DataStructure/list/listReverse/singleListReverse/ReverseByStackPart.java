package DataStructure.list.listReverse.singleListReverse;

import Common.Utils.UTFactory;
import DataStructure.list.Nodelj;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/6 23:03
 * @author-Email micromicrohard@outlook.com
 * @description
 * @blogURL
 */
public class ReverseByStackPart implements ReverseList {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误测试案例
    public void TestDoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    @Override
    public Nodelj ReverseMethod(Nodelj node) {
        if (node == null) {
            return null;
        }
        return reverse(node);
    }

    public Nodelj reverse(Nodelj node) {
        if (node.next == null) {
            return node;
        }
        Nodelj newNode = reverse(node.next);
        // 重建关系
        node.next.next = node;
        node.next = null;
        // 此处需要注意返回值
        return newNode;
    }
}
