package DataStructure.list.listRealize;

import DataStructure.list.Nodelj;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/12/7
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 链表的倒数第K个元素
 */
public interface TheLastK {

    // 查找链表的倒数第K个元素
    int findTheLastK(Nodelj first, int lastK);

    // 删除链表的倒数第K个元素
    Nodelj deleteTheLastK(Nodelj first, int lastK);
}
