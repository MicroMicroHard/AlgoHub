package DataStructure.heapStackQueue;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020-01-13 21:52
 * @author-Email micromicrohard@outlook.com
 * @description 队列的基本方法
 * 1、元素入队            {@link Queuelj#offer}
 * 2、元素出队            {@link Queuelj#poll}
 * 3、弹出队首元素（不删除）{@link Queuelj#peek}
 * 4、队列判空            {@link Queuelj#empty}
 * 5、查找值              {@link Queuelj#search}
 * 6、获取真实队列长度      {@link Queuelj#getRealSize}
 * 7、获取最大队列长度      {@link Queuelj#getMaxSize}
 * 8、队列扩容            {@link Queuelj#resize}
 *
 * 具体实现：
 * 1、数组队列
 * 2、链表队列
 * 3、栈队列
 * 4、优先队列
 * 5、双端队列
 * @blogURL
 */
public interface Queuelj {

    //offer = push, 入队
    boolean offer(int value);

    //poll = add, 出队
    int poll();

    //弹出第一个队首元素（不删除）
    int peek();

    //队列判空
    boolean empty();

    //获取真实队列长度
    int getRealSize();

    //获取最大队列长度
    int getMaxSize();

    //队列扩容
    void resize();

    //查找函数
    boolean search(int x);
}
