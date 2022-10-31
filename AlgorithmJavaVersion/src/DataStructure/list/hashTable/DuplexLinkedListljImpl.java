package DataStructure.list.hashTable;

import DataStructure.list.Nodelj;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/28
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description cache 双向链表
 */
public class DuplexLinkedListljImpl implements DuplexLinkedListlj {

    //链表头尾指针，链表的实际长度
    Nodelj head;
    Nodelj tail;
    int linkedSize;

    //初始化 双向链表
    public DuplexLinkedListljImpl() {
        this.head = new Nodelj();
        this.tail = new Nodelj();
        this.head.next = this.tail;
        this.tail.front = this.head;
    }

    //增加元素（链表尾部）
    public boolean insertLast(Nodelj node) {
        //空链表的处理方法
        if (head.next == tail) {
            head.next = node;
            node.front = head;
        } else {
            tail.front.next = node;
            node.front = tail.front;
        }
        linkedSize++;
        node.next = tail;
        tail.front = node;
        return true;
    }

    //删除元素
    public boolean delete(Nodelj node) {
        node.next.front = node.front;
        node.front.next = node.next;
        linkedSize--;
        return true;
    }

    //删除并返回 首元素
    public Nodelj deleteOld() {
        if (head.next == tail) {
            return null;
        }
        Nodelj first = head.next;
        delete(first);
        return first;
    }

    //返回 链表最后一个元素【最新插入的】
    public Nodelj getLeast() {
        if (head.next == tail) {
            return null;
        }
        return tail.front;
    }

    //获取双向链表的长度
    public int getSize() {
        return this.linkedSize;
    }

    //双向链表是否为空
    public boolean isEmpty() {
        return this.head.next == this.tail;
    }
}
