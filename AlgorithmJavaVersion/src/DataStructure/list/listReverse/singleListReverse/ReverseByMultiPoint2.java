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
public class ReverseByMultiPoint2 implements ReverseList {

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
    public Nodelj ReverseMethod(Nodelj nodelj) {
        if (nodelj == null) {
            return null;
        }
        Nodelj pre, newRoot = null;
        Nodelj cur = nodelj;

        while (cur != null) {
            //当前节点前进
            pre = cur;
            cur = cur.next;
            // 新节点更新
            pre.next = newRoot;
            newRoot = pre;
        }
        return newRoot;
    }
}
