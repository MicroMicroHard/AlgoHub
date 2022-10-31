package DataStructure.heapStackQueue;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/7/14
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 双端队列的基本用法
 * 1、元素入队：首部入队            {@link DeQueuelj#offerFront}
 * 2、元素出队：尾部入队            {@link DeQueuelj#pollFront}
 * 3、弹出队首元素（不删除）         {@link DeQueuelj#peekFront}
 * 4、弹出队首尾元素（不删除）       {@link DeQueuelj#peekTail}
 * 5、元素出队：首部出队            {@link DeQueuelj#pollFront}
 * 6、元素出队：尾部出队            {@link DeQueuelj#pollTail}
 * <p>
 * 4、队列判空            {@link DeQueuelj#empty}
 * 6、获取真实队列长度      {@link DeQueuelj#getRealSize}
 * 7、获取最大队列长度      {@link DeQueuelj#getMaxSize}
 * 8、队列扩容            {@link DeQueuelj#resize}
 */

public interface DeQueuelj extends Queuelj {

    //offer = push, 队首入队
    boolean offerFront(int value);

    //offer = push, 队尾入队
    boolean offerTail(int value);

    //弹出第一个队首元素（不删除）
    int peekFront();

    //弹出第一个队尾元素（不删除）
    int peekTail();

    //poll = add, 队首出队
    int pollFront();

    //poll = add, 队尾出队
    int pollTail();
}
