package DataStructure.list.listReverse.singleListReverse;

import Common.Utils.UTFactory;
import DataStructure.list.Nodelj;
import org.junit.Test;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/6 23:07
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description
 * @blogURL
 */
public class ReverseByMultiPoint implements ReverseList {

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
        Nodelj newNode = new Nodelj();
        Nodelj cur = node;
        Nodelj pre = node;
        while (cur != null) {
            pre = cur;
            cur = cur.next;
            pre.next = newNode.next;
            newNode.next = pre;
        }
        return newNode.next;
    }
}
