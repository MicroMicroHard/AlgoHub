package DataStructure.heapStackQueue;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/14
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 堆的基本用法
 * 1、元素入堆            {@link Heaplj#push}
 * 2、元素出堆            {@link Heaplj#pop}
 * 3、弹出堆顶元素（不删除）{@link Heaplj#peek}
 * 4、堆判空             {@link Heaplj#empty}
 * 6、获取真实堆长度      {@link Heaplj#getRealSize}
 * 7、获取最大堆长度      {@link Heaplj#getMaxSize}
 * 8、堆扩容             {@link Heaplj#resize}
 */

public interface Heaplj {

    void push(int value);

    int pop();

    int peek();

    boolean empty();

    int getRealSize();

    int getMaxSize();

    void resize();
}
