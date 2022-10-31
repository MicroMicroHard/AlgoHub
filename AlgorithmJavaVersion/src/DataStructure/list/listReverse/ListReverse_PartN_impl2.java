package DataStructure.list.listReverse;

import Common.Utils.UTFactory;
import DataStructure.list.Nodelj;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/12/7
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 链表反转：每N个数反转一次
 */

public class ListReverse_PartN_impl2 implements ListReverse_PartN {

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

    // 两两反转:
    public Nodelj Method(Nodelj head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        Nodelj countNode = head;
        while (count < n && countNode != null) {
            count++;
            countNode = countNode.next;
        }
        if (count < n) {
            return head;
        }
        Nodelj tail = null;
        if (countNode != null) {
            tail = Method(countNode, n);
        }

        /*Nodelj headPre = new Nodelj();
        headPre.next = head;
        Nodelj cur = headPre.next;*/
        Nodelj cur = head;
        Nodelj curPre;
        Nodelj newHead = null;

        while (cur != countNode) {
            curPre = cur;
            cur = cur.next;
            curPre.next = newHead;
            newHead = curPre;
        }

        head.next = tail;
        return newHead;
    }

    // attention: 这种做法不行，因为 没有检查 链表的长度是否小于n 就开始反转链表，导致head 发生变化
    public Nodelj Meth1od2(Nodelj head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        Nodelj headPre = new Nodelj();
        headPre.next = head;
        Nodelj cur = headPre.next;
        Nodelj curPre;
        Nodelj newHead = null;

        int count = 0;
        while (count < n && cur != null) {
            curPre = cur;
            cur = cur.next;

            curPre.next = newHead;
            newHead = curPre;

            count++;
        }
        if (count < n) {
            return head;
        }
        if (cur != null) {
            head.next = Meth1od2(cur, n);
        }
        return newHead;
    }

    public Nodelj Me1thod3(Nodelj head, int n) {
        if (head == null) {
            return head;
        }
        ListReverse_TwoPosition reverseListTool = new ListReverse_TwoPosition();
        Nodelj node = head;
        int count = 1;
        int index1 = 1;

        while (node != null) {
            node = node.next;
            count++;
            if (count % n == 0) {
                // 因为reverse操作存在head变化的情况，所以需要
                head = reverseListTool.method(head, index1, count);
                index1 = count + 1;
            }
        }
        if (index1 < count) {
            reverseListTool.method(head, index1, count);
        }
        return head;
    }
}
