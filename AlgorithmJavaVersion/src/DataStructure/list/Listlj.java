package DataStructure.list;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/11/1
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 链表专题
 * 1、插入（批量插入、指定位置插入）
 * 2、删除（删除元素、删除指定位置的元素）
 * 3、查找（查找元素、查找指定位置的元素）
 * 4、输出（数组）
 * 5、相等
 * 6、清除
 */
public interface Listlj {

    // 插入指定元素
    boolean insert(boolean headInsert, Nodelj... nodes);
    boolean insert(boolean headInsert, int... nodes);
    boolean insertIndex(int index, Nodelj... nodes);
    boolean insertIndex(int index, int... nodes);

    // 删除指定元素
    void delete(Nodelj node);
    void delete(boolean isDeleteHead);
    void deleteIndex(int index);

    // 链表查找函数[查找指定元素],查找成功，返回该坐标的值,查找失败，返回 Integer.MIN_VALUE
    int searchValue(int value);
    int searchValue(Nodelj node);
    int searchIndex(int index);

    // 链表判断相等
    boolean listEquals(Listlj listlj);
    boolean listEquals(Listlj l1, Listlj l2);

    // 链表置空操作、链表大小、将链表输出为数组、链表打印
    void clear();
    int size();
    int[] toArray();
    void print();

    // 判断 array不为空
    default boolean checkNull(int[] array) {
        return array != null && array.length != 0;
    }
}
