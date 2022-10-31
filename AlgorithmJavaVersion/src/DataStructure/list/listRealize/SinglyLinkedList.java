package DataStructure.list.listRealize;

import DataStructure.list.Listlj;
import DataStructure.list.Nodelj;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-8-18 01:08:11
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 单链表
 * 单链表的插入：数组和单个元素 （头插和尾插）
 * 单链表的删除：删除特定元素和指定位置元素
 * 单链表的查找：查找特定元素和指定位置元素
 * 单链表的相等：判断两个链表是否相等、自身对比
 * 单链表的清除：置空单链表
 */
public class SinglyLinkedList implements Listlj {

    //头节点、尾节点，头节点的值为单链表的长度
    public Nodelj head;
    public Nodelj tail;
    private static final int error = -1;

    public SinglyLinkedList() {
        this.head = new Nodelj();
        this.head.key = 0;     // 单链表的长度存储在头节点的value中
        this.tail = this.head;
    }

    @Override
    public boolean insert(boolean headInsert, Nodelj... nodes) {
        if (nodes == null) {
            return false;
        }
        for (Nodelj node : nodes) {
            if (headInsert) { //头插法
                node.next = this.head.next;
                this.head.next = node;
                if (this.head == this.tail) { // 首次使用头插法插入需要注意
                    this.tail = node;
                }
            } else { //尾插法
                tail.next = node;
                tail = node;
            }
            this.head.key++;
        }
        return true;
    }

    /**
     * 链表的插入
     * 1、允许插入单个值 或者 数组
     * 2、使用头插法或者尾插法
     * 3、对本list进行操作
     *
     * @param arr        参数
     * @param headInsert true表示头插法，tail表示尾插法
     */
    public boolean insert(boolean headInsert, int... arr) {
        if (!checkNull(arr)) {
            return false;
        }
        Nodelj[] nodes = new Nodelj[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Nodelj(arr[i]);
        }
        insert(headInsert, nodes);
        return true;
    }

    @Override
    public boolean insertIndex(int index, Nodelj... nodes) {
        if (index > this.head.key) {
            return false;
        }
        Nodelj pre = this.head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        for (Nodelj node : nodes) {
            node.next = pre.next;
            pre.next = node;
            if (pre == this.tail) { //update tail
                this.tail = node;
            }
            pre = node; //update ahead point
            this.head.key++;// 这一步总是会遗忘
        }
        return true;
    }

    @Override
    public boolean insertIndex(int index, int[] array) {
        if (array == null) {
            return false;
        }
        Nodelj[] nodes = new Nodelj[array.length];
        for (int i = 0; i < array.length; i++) {
            nodes[i] = new Nodelj(array[i]);
        }
        insertIndex(index, nodes);
        return false;
    }

    @Override
    public void delete(Nodelj node) {
        Nodelj nodelj = this.head.next;
        Nodelj pre = this.head;
        while (nodelj != null) {
            if (nodelj.key == node.key) {
                pre.next = nodelj.next;
                this.head.key--;
            }
            pre = nodelj;
            nodelj = nodelj.next;
        }
    }

    @Override
    public void delete(boolean isDeleteHead) {
        if (this.head == this.tail) {
            return;
        }
        if (isDeleteHead) {
            this.head.next = this.head.next.next;
            this.head.key--;
            return;
        }
        Nodelj node = this.head;
        while (node.next != this.tail) {
            node = node.next;
        }
        node.next = null;
        this.tail = node;
        this.head.key--;
    }

    /**
     * 链表删除特定索引的函数
     */
    @Override
    public void deleteIndex(int index) {
        if (this.head.key < index) {
            return;
        }
        Nodelj nodelj = this.head;
        Nodelj pre = this.head;
        int count = 0;
        while (count <= index) {
            if (nodelj == null) {
                return;
            }
            pre = nodelj;
            nodelj = nodelj.next;
            count++;
        }
        pre.next = nodelj.next;
        this.head.key--;
    }

    @Override
    public int searchValue(int key) {
        return searchValue(new Nodelj(key));
    }

    @Override
    public int searchValue(Nodelj node) {
        Nodelj nodelj = this.head.next;
        int count = 0;
        while (nodelj != null) {
            if (nodelj.key == node.key) {
                return count;
            }
            nodelj = nodelj.next;
            count++;
        }
        return error;
    }

    @Override
    public int searchIndex(int index) {
        Nodelj nodelj = this.head.next;
        int count = 0;
        while (count++ < index) {
            if (nodelj == null) {
                return error;
            }
            nodelj = nodelj.next;
        }
        return nodelj.key;
    }

    /**
     * @return l1和链表自身进行对比
     */
    public boolean listEquals(Listlj l2) {
        return listEquals(this, l2);
    }

    /**
     * @return l1和l2进行对比
     */
    public boolean listEquals(Listlj l3, Listlj l4) {
        SinglyLinkedList l1 = (SinglyLinkedList) l3;
        SinglyLinkedList l2 = (SinglyLinkedList) l4;
        if (l1 == l2) {
            return true;
        }
        if (l1 != null && l2 != null && l1.head.key == l2.head.key) {
            Nodelj p1 = l1.head.next;
            Nodelj p2 = l2.head.next;
            while (p1 != null && p2 != null) {
                if (p1.key != p2.key) {
                    return false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return true;
        }
        return false;
    }

    /**
     * 链表清除函数
     */
    public void clear() {
        this.head = new Nodelj();
        //单链表的长度存储在头节点的value中
        this.head.key = 0;
        tail = head;
    }

    @Override
    public int size() {
        return this.head.key;
    }

    /**
     * 链表输出为数组
     */
    public int[] toArray() {
        if (head.next == null) {
            return new int[]{};
        }
        int[] array = new int[head.key];
        Nodelj nodelj = this.head.next;
        int count = 0;
        while (nodelj != null) {
            array[count++] = nodelj.key;
            nodelj = nodelj.next;
        }
        return array;
    }

    public void print() {
        if (this.head == null) {
            return;
        }
        Nodelj node = this.head.next;
        while (node.next != null) {
            System.out.print(node.key + "-");
            node = node.next;
        }
        System.out.println(node.key);
    }
}
