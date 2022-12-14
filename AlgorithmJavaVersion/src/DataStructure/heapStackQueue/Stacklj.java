package DataStructure.heapStackQueue;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020-01-13 22:01
 * @author—Email micromicrohard@outlook.com
 * @description 栈
 * 1、出栈
 * 2、入栈
 * 3、获取栈顶元素
 * 4、栈判空
 * 5、查找值
 * 6、获取栈中实际容量
 * 7、获取栈中最大容量
 * 8、扩容
 *
 * 具体实现：
 * 1、数组栈
 * 2、链表栈
 * 3、最小栈
 * 4、队列栈
 * @blogURL
 */
public interface Stacklj {

    /**
     * 出栈操作
     *
     * @return 栈顶元素
     */
    int pop();

    /**
     * 入栈操作
     *
     * @param value 入栈值
     * @return 入栈是否成功
     */
    boolean push(int value);

    /**
     * 获取栈顶元素
     *
     * @return 栈顶元素
     */
    int peek();

    /**
     * 判空操作
     *
     * @return 栈是否为空
     */
    boolean empty();

    /**
     * 查找某元素
     *
     * @param value 查找值
     * @return 查找是否成功
     */
    boolean search(int value);

    /**
     * 获取栈中实际的元素数量
     *
     * @return 栈中实际的元素数量
     */
    int getRealsize();

    /**
     * 获取栈的最大元素数量
     *
     * @return 栈的最大元素数量
     */
    int getMaxsize();

    /**
     * 扩容操作
     */
    void resize();
}
