package DataStructure.heapStackQueue.stack;

import DataStructure.heapStackQueue.queue.ArrayQueuelj;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/23
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 队列栈
 * 使用队列实现栈的功能
 * 主要实现：出栈、入栈、获取栈首元素
 */
public class QueueStacklj extends ArrayStacklj {

    ArrayQueuelj queue1;
    ArrayQueuelj queue2;
    int peakValue = Integer.MIN_VALUE;

    public QueueStacklj() {
        this.queue1 = new ArrayQueuelj();
        this.queue2 = new ArrayQueuelj();
    }

    public QueueStacklj(int num) {
        this.queue1 = new ArrayQueuelj(num);
        this.queue2 = new ArrayQueuelj(num);
    }

    public boolean empty() {
        return this.queue1.empty();
    }

    public boolean search(int value) {
        return this.queue1.search(value);
    }

    public int getRealsize() {
        int u = this.queue1.getRealSize();
        return u;
    }

    
    public int pop() {
        int size = this.queue1.getRealSize();
        for (int i = 0; i < size - 1; i++) {
            queue2.offer(queue1.poll());
        }
        int value = this.queue1.poll();
        int realsize = this.queue2.getRealSize();
        for (int i = 0; i < realsize; i++) {
            if (i == realsize - 1) {
                peakValue = queue2.poll();
                queue1.offer(peakValue);
            } else {
                queue1.offer(queue2.poll());
            }
        }
        return value;
    }

    
    public boolean push(int value) {
        this.queue1.offer(value);
        peakValue = value;
        return true;
    }

    
    public int peek() {
        if (empty()) {
            peakValue = Integer.MIN_VALUE;
        }
        return peakValue;

        /*此处需要谨慎，注意到tail并不是尾元素
        if (this.queue1.tail != this.queue1.front) {
            return queue1.queue[(queue1.front + queue1.QueueRealsize) % queue1.QueueRealsize - 1];
        }
        return Integer.MIN_VALUE;*/

        //这种写法是错误的，回导致元素混淆
        /*int size = queue1.getRealsize();
        for (int i = 0; i < size - 1; i++) {
            queue2.offer(queue1.poll());
        }
        int value = queue1.peek();
        int realsize = queue2.getRealsize();
        for (int i = 0; i < realsize; i++) {
            queue1.offer(queue2.poll());
        }
        return value;*/
    }

    
    public void resize() {
        this.queue1.resize();
    }

    
    public int getMaxsize() {
        return this.queue1.getMaxSize();
    }
}
