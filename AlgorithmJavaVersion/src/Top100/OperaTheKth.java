package Top100;

import DataStructure.list.listRealize.TheLastKImpl;
import DataStructure.heapStackQueue.heap.ReturnKthMin;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/12/7
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 操作第K个值
 */

public interface OperaTheKth {

    default void OperaTheKth() {
        new ReturnKthMin(); // 返回最小的 第K个 元素
        new TheLastKImpl(); // 链表的倒数第K个元素
    }
}
