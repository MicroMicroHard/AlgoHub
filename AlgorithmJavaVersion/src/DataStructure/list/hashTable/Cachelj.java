package DataStructure.list.hashTable;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/12/24
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 缓存
 * 1、新增元素
 * 2、删除元素
 * 3、获取元素
 * 主要实现：
 * 1、最近最少使用算法  （LFU, Least Frequently Used）
 * 2、最近最久未使用算法 (LRU, Least Recently Used)
 */
public interface Cachelj {

    // 新增元素
    boolean put(int key, String value);

    // 获取元素
    String get(int key);

    // 删除元素
    boolean delete(int x);

    // 清除内存，删除 最近不使用/频率最低 的
    boolean deleteLeast();

    // 获取 最近/频率最高 的元素，并重新更新到队尾
    String getRecent();

    /*
      LRU的内部接口：
      boolean makeRecently(Node4Cache node);     // 更新最近元素
      boolean addRecently(int x, String value);  // 新增最近元素
      LFU的内部接口：
      void increaseFreq(int key);                // 提升元素频率
      void pageElimination();                    // 替换操作
    */

    // 内部接口：判断缓存是否为空
    boolean empty();
}
