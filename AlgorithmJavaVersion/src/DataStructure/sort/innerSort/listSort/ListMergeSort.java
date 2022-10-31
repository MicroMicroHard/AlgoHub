package DataStructure.sort.innerSort.listSort;

import DataStructure.list.Nodelj;
import Common.Utils.UTFactory;
import DataStructure.sort.innerSort.ListSortINTF;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-3-23 12:09:20
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 链表的归并排序
 */

public class ListMergeSort implements ListSortINTF {

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

    //注意：该方法必须是有返回值类型的，初始root的值可能会发生更改，因此最后需要返回新的root
    public Nodelj sortMethod(Nodelj root) {
        //边界判空
        if (root == null || root.next == null) {
            return root;
        }
        Nodelj mid = getMid(root);
        Nodelj first = root;
        Nodelj second = mid.next;
        mid.next = null;

        first = sortMethod(first);
        second = sortMethod(second);
        return merge(first, second);
    }

    // 快慢指针
    public Nodelj getMid(Nodelj head) {
        if (head == null) {
            return null;
        }
        Nodelj fast = head;
        Nodelj slow = head;
        // 无须判断slow，因为fast不为空的时候，slow肯定不为空
        // 此处的判断条件不可以写成：fast != null && fast.next != null
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Nodelj merge(Nodelj first, Nodelj second) {
        if (first == null && second == null) {
            return null;
        }
        if (first == null || second == null) {
            return first == null ? second : first;
        }
        // 新建一个假的头节点
        Nodelj newHead = new Nodelj();
        Nodelj cur = newHead;
        while (first != null && second != null) {
            if (first.key < second.key) {
                cur.next = first;
                first = first.next;
            } else {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
        }
        if (first != null) {
            cur.next = first;
        }
        if (second != null) {
            cur.next = second;
        }
        // 返回假的头节点的下一个
        return newHead.next;
    }
}
