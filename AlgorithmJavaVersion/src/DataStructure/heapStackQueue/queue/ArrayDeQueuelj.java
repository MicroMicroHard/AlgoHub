package DataStructure.heapStackQueue.queue;

import DataStructure.heapStackQueue.DeQueuelj;

/**
 * @author liujun
 * @version 1.0
 * @date 2022/4/6 12:08
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 数组实现 双端队列
 * @blogURL
 */

public class ArrayDeQueuelj implements DeQueuelj {

    public int[] queue;
    public int QueueRealSize;
    public int QueueMaxSize;
    public int front;
    public int tail;

    
    public boolean offerFront(int value) {
        return false;
    }

    
    public int pollFront() {
        return poll();
    }

    
    public int peekFront() {
        return peek();
    }

    
    public boolean offerTail(int value) {
        return offer(value);
    }

    
    public int pollTail() {
        return 0;
    }

    
    public int peekTail() {
        return 0;
    }

    
    public boolean offer(int value) {
        return false;
    }

    
    public int poll() {
        return 0;
    }

    
    public int peek() {
        return 0;
    }

    
    public boolean empty() {
        return false;
    }

    
    public int getRealSize() {
        return 0;
    }

    
    public int getMaxSize() {
        return 0;
    }

    
    public void resize() {
    }

    
    public boolean search(int x) {
        return false;
    }
}
