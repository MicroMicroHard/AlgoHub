package DataStructure.list.listReverse;

import DataStructure.list.Nodelj;
import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/12/7
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 链表反转：每N个数反转一次
 */

public class ListReverse_PartN_impl implements ListReverse_PartN {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误测试案例
    public void TestDoubleTrack() throws Exception {
        String input = "{1, 2, 3, 4, 5, 6, 7}  ############  8";
        String output = "{1, 2, 3, 4, 5, 6, 7} ";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    public Nodelj Method(Nodelj head, int n) {
        if (head == null) {
            return null;
        }
        ListReverse_TwoPosition tool = new ListReverse_TwoPosition();
        int count = 1;

        Nodelj headPre = new Nodelj();
        headPre.next = head;
        Nodelj nextPartHeadPre = headPre;
        Nodelj reviseBegin = headPre.next;
        Nodelj cur = headPre.next;

        while (cur != null) {
            if (count % n == 0) {
                // 因为reverse 操作存在head变化的情况，所以需要
                Nodelj curNext = cur.next;

                nextPartHeadPre.next = tool.reverse(reviseBegin, cur);
                nextPartHeadPre = reviseBegin;

                reviseBegin = curNext;
                cur = curNext;
            } else {
                cur = cur.next;
            }
            count++;
        }
        if (reviseBegin != null) {
            nextPartHeadPre.next = reviseBegin;
        }
        return headPre.next;
    }
}
