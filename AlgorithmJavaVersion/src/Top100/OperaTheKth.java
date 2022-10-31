package Top100;

import DataStructure.list.listRealize.TheLastKImpl;
import DataStructure.heapStackQueue.heap.ReturnKthMin;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/12/7
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 操作第K个值
 */

public interface OperaTheKth {

    default void OperaTheKth() {
        new ReturnKthMin(); // 返回最小的 第K个 元素
        new TheLastKImpl(); // 链表的倒数第K个元素
    }
}
