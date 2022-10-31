package DataStructure.list.listReverse;

import DataStructure.list.Nodelj;
import Top100.Reversal;
import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-8-18 01:08:11
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */

public class ListReverse_Part2_SwapPairs implements Reversal {

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

    public Nodelj Method(Nodelj head) {
        if (head == null || head.next == null) {
            return head;
        }
        Nodelj newHead = head.next;
        head.next = Method(head.next.next);
        newHead.next = head;
        return newHead;
    }
}
