package DataStructure.list.listRealize;

import DataStructure.list.Nodelj;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/12/11
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 链表相加
 * 两个数倒叙存放于链表中：7642+654
 * 输入： 链表A：2->4->6->7,链表B：4->5->6
 * 输出： 8296
 */
public class BigIntegersSum_List implements BigIntegerOpera_List {

    
    public Nodelj calMethod(Nodelj first, Nodelj second) {
        return null;
    }

    public int addWithSymbol(SinglyLinkedList a, SinglyLinkedList b) {

        if (a == null || a.head.key == 0 || b == null || b.head.key == 0) {
            return listtoInt(a) + listtoInt(b);
        }
        if (a.head.key < b.head.key) {
            SinglyLinkedList temp = b;
            b = a;
            a = temp;
        }
        Nodelj n1 = a.head.next;
        Nodelj n2 = b.head.next;
        Nodelj n1_pre = n1;
        int carry = 0;
        while (n2 != null) {
            int temp = n1.key + n2.key + carry;
            n1.key = temp % 10;
            carry = temp / 10;
            n1_pre = n1;
            n1 = n1.next;
            n2 = n2.next;
        }
        if (carry != 0) {
            if (n1 == null) {
                n1_pre.next = new Nodelj(carry);
            } else {
                n1.key += carry;
            }
        }
        int sum = listtoInt(a);
        return sum;
    }

    private int listtoInt(SinglyLinkedList a) {
        if (a == null || a.head.key == 0) {
            return 0;
        }
        Nodelj node = a.head.next;
        StringBuffer sb = new StringBuffer();
        while (node != null) {
            sb.append(node.key);
            node = node.next;
        }
        int key = Integer.parseInt(sb.reverse().toString());
        return key;
    }
}
