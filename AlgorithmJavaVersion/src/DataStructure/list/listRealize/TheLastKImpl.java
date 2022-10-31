package DataStructure.list.listRealize;

import DataStructure.list.Listlj;
import DataStructure.list.Nodelj;
import Top100.DoublePoint;
import Top100.OperaTheKth;
import Common.Constant.C;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/1/6
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 链表的倒数第K个元素
 * 使用双指针
 */

public class TheLastKImpl implements TheLastK, OperaTheKth, DoublePoint {

    
    public int findTheLastK(Nodelj first, int lastK) {
        if (first == null) {
            return C.ErrorNum;
        }
        Nodelj fast, slow;
        fast = first;
        slow = first;
        int count = 0;
        while (fast != null) {
            count++;//表示链表中真实的节点个数
            fast = fast.next;
            if (count > lastK) {
                slow = slow.next;
            }
        }
        if (count < lastK) {
            return C.ErrorNum;
        }
        return slow.key;
    }

    
    public Nodelj deleteTheLastK(Nodelj first, int lastK) {
        return null;
    }

    //method one
    public int getlastk(Listlj listlj1, int k) {
        SinglyLinkedList listlj = (SinglyLinkedList) listlj1;
        if (listlj == null || listlj.head.key == 0) {
            return Integer.MIN_VALUE;
        }
        Nodelj pre = listlj.head.next;
        Nodelj point = listlj.head.next;
        int count = 0;
        while (pre != null) {
            count++;
            pre = pre.next;
            if (pre != null && count >= k) {
                point = point.next;
            }
        }
        if (count >= k) {
            return point.key;
        }
        return Integer.MIN_VALUE;
    }

    //method two
    public int getlastk1(Listlj listlj1, int k) {
        SinglyLinkedList listlj = (SinglyLinkedList) listlj1;
        if (listlj == null || listlj.head.key == 0) {
            return Integer.MIN_VALUE;
        }
        Nodelj pre = listlj.head.next;
        Nodelj point = listlj.head.next;
        int count = 0;
        int newk = listlj.head.key - k;
        while (pre != null) {
            count++;
            pre = pre.next;
            if (count == newk) {
                point = pre;
            }
        }
        if (count < k) {
            return Integer.MIN_VALUE;
        }
        return point.key;
    }

    //method three
    public int getlastk_recursion(Listlj listlj1, int k) {
        SinglyLinkedList listlj = (SinglyLinkedList) listlj1;
        if (listlj == null || listlj.head.key == 0) {
            return Integer.MIN_VALUE;
        }
        int find = listlj.head.key - k + 1;
        recursion(listlj.head.next, find, 0);
        return target == null ? Integer.MIN_VALUE : target.key;
    }

    Nodelj target;

    private void recursion(Nodelj nodelj, int k, int count) {
        if (nodelj == null) {
            return;
        }
        recursion(nodelj.next, k, ++count);
        if (count == k) {
            target = nodelj;
            return;
        }
    }
}
