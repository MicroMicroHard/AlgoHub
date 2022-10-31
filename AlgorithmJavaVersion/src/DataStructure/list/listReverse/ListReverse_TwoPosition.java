package DataStructure.list.listReverse;

import DataStructure.list.Nodelj;
import Top100.Reversal;
import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/12/7
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 链表反转
 * 反转从 leftBorder 到 rightBorder 之间的数据，区间是 左闭右闭
 */

public class ListReverse_TwoPosition implements Reversal {

    @Test // 验证功能：从数据库获取测试数据，用于单元测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误的测试案例
    public void TestDoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    /**
     * @param head        链表头
     * @param leftBorder  左边界
     * @param rightBorder 右边界
     * @return 反转后的链表
     * @attation 因为是原址操作，原来的输入已经发送变化，所以测试用例不可复用，最好是执行前深拷贝一份做对比
     */
    public Nodelj method(Nodelj head, int leftBorder, int rightBorder) {
        if (head == null || leftBorder >= rightBorder) {
            return head;
        }
        if (leftBorder <= 0) {
            leftBorder = 1;
        }

        // 准备好第一个 起始点
        int curIndex = 1;
        Nodelj cur = head;
        Nodelj partOneTail = null;
        while (cur != null && curIndex < leftBorder) {
            partOneTail = cur;
            cur = cur.next;
            curIndex++;
        }
        // 不满足起始地址
        if (cur == null || curIndex != leftBorder) {
            return head;
        }

        Nodelj partTwoTail = cur;
        Nodelj partTwoHead = cur;
        Nodelj pre = null;
        while (cur != null && curIndex <= rightBorder) {
            // 进行指针反转
            pre = cur;
            cur = cur.next;
            pre.next = partTwoHead;
            partTwoHead = pre;
            curIndex++;
        }

        // 整理两部分的链接
        partTwoTail.next = cur;
        if (partOneTail != null) {
            partOneTail.next = partTwoHead;
            return head;
        }
        return partTwoHead;
    }

    public Nodelj reverse(Nodelj node1, Nodelj node2) {
        if (node1 == null || node1 == node2) {
            return node1;
        }
        Nodelj head = node1;
        Nodelj pre = null;
        Nodelj newNode = null;

        while (node1 != node2) {
            pre = node1;
            node1 = node1.next;
            pre.next = newNode;
            newNode = pre;
        }
        node2.next = newNode;
        return node2;
    }
}
