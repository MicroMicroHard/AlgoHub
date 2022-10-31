package DataStructure.list.hashTable;

import DataStructure.list.Nodelj;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/7/28
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description cache 双向链表
 */

public interface DuplexLinkedListlj {

    //增加元素（链表尾部）
    boolean insertLast(Nodelj node);

    //删除元素
    boolean delete(Nodelj node);

    //删除并返回 链表首元素【当前链表中最早插入的】
    Nodelj deleteOld();

    //返回 链表最后一个元素【最新插入的】
    Nodelj getLeast();

    //获取双向链表的长度
    int getSize();

    //双向链表是否为空
    boolean isEmpty();
}
