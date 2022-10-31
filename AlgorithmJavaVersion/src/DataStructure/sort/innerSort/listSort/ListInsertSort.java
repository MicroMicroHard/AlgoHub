package DataStructure.sort.innerSort.listSort;

import DataStructure.list.Nodelj;
import DataStructure.list.listRealize.SinglyLinkedList;
import Common.Utils.UTFactory;
import DataStructure.sort.innerSort.ListSortINTF;
import org.junit.Test;
import DataStructure.list.Listlj;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-14 22:15
 * @author—Email micromicrohard@outlook.com
 * @description 链表的插入排序
 * 链表本身的插入排序:
 * @blogURL
 */

public class ListInsertSort implements ListSortINTF {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误测试案例
    public void TestDoubleTrack() throws Exception {
        String input = "[EmptyExpr]";
        String output = "[EmptyExpr]";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    //注意：该方法必须是有返回值类型的，初始root的值可能会发生更改，因此最后需要返回新的root
    public Nodelj sortMethod(Nodelj root) {
        if (root == null || root.next == null) {
            return root;
        }
        //为了方便cur的断开，必须在cur之前加入一个可以找到cur的点
        Nodelj curPre = root;
        Nodelj cur = root.next;
        // 通过构建辅助节点，当作链表的头节点:helpHead
        Nodelj helpHead = new Nodelj();
        helpHead.next = root;

        while (cur != null) {
            Nodelj compareNodePre = helpHead;
            // 查找插入点
            while (compareNodePre != cur && compareNodePre.next != null && compareNodePre.next.key < cur.key) {
                compareNodePre = compareNodePre.next;
            }
            if (compareNodePre.next != cur) {
                // 进行插入操作
                curPre.next = cur.next;
                cur.next = compareNodePre.next;
                compareNodePre.next = cur;
                // 更新 新的 cur
                cur = curPre;
            }
            curPre = cur;
            cur = cur.next;
        }
        return helpHead.next;
    }

    //链表的插入排序
    public Listlj sortMe1thod(Listlj array) {
        SinglyLinkedList l = (SinglyLinkedList) array;
        if (array == null || l.head == l.tail) {
            return array;
        }
        Nodelj next_pre = l.head.next;
        Nodelj next = l.head.next.next;
        while (next != null) {
            Nodelj point = l.head;
            while (point.next != next) {
                if (next.key >= point.next.key) {
                    point = point.next;
                } else {
                    //替换出next
                    next_pre.next = next.next;
                    next.next = null;
                    //插入合适位置
                    next.next = point.next;
                    point.next = next;
                    //更新 新的 next
                    next = next_pre;
                    break;
                }
            }
            next_pre = next;
            next = next.next;
        }
        return array;
    }
}
