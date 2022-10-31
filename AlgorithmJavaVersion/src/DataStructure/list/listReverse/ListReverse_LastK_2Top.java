package DataStructure.list.listReverse;

import Common.Utils.UTFactory;
import DataStructure.list.Nodelj;
import Top100.Reversal;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/12/7
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 反转链表最后几个数到最前方
 * 输入： 1, 2, 3, 4, 5  ，反转 k : 2
 * 输出： 5, 4, 1, 2, 3
 * <p>
 * 输入： 1, 2, 3, 4, 5  ，反转 k : 3
 * 输出： 5, 4, 3, 1, 2
 */

public class ListReverse_LastK_2Top implements Reversal {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    public Nodelj reviseMethod(Nodelj head, int k) {
        if (head == null) {
            return null;
        }
        int index = 0;
        Nodelj node = head;
        Nodelj tail = head;
        while (tail != null) {
            tail = tail.next;
            if (index > k) {
                node = node.next;
            }
            index++;
        }
        Nodelj newHead = head;
        if (node != head) {
            Nodelj cur = node.next;
            node.next = null;
            newHead = reviseNode(cur);
            Nodelj newNodeTail = newHead;
            while (newNodeTail.next != null) {
                newNodeTail = newNodeTail.next;
            }
            newNodeTail.next = head;
        }
        return newHead;
    }

    public Nodelj reviseNode(Nodelj node) {
        if (node == null) {
            return null;
        }
        Nodelj pre = node;
        Nodelj cur = node;
        Nodelj newNode = null;
        while (cur != null) {
            pre = cur;
            cur = cur.next;
            pre.next = newNode;
            newNode = pre;
        }
        return newNode;
    }
}