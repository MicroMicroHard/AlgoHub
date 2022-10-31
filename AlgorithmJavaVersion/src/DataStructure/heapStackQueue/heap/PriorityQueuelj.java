package DataStructure.heapStackQueue.heap;

import DataStructure.heapStackQueue.Heaplj;
import DataStructure.heapStackQueue.Queuelj;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/14
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 优先队列
 */
public class PriorityQueuelj implements Queuelj, Heaplj {

    public int[] queue;
    public int QueueRealSize;
    public int QueueMaxsize;
    public boolean flag = false;//true表示大顶堆，false表示小顶堆

    public PriorityQueuelj() {
        this.QueueRealSize = 0;
        this.QueueMaxsize = 32;
        this.queue = new int[QueueMaxsize];
    }

    public PriorityQueuelj(int num) {
        this.QueueRealSize = 0;
        this.QueueMaxsize = num;
        this.queue = new int[QueueMaxsize];
    }

    // flag默认为false，小顶堆
    public PriorityQueuelj(int num, Boolean flag) {
        this.QueueRealSize = 0;
        this.QueueMaxsize = num;
        this.queue = new int[QueueMaxsize];
        this.flag = flag;
    }

    
    //入队判满
    public boolean offer(int value) {
        if (QueueRealSize + 1 >= QueueMaxsize) {
            resize();
        }
        if (QueueRealSize == 0) {
            queue[QueueRealSize] = value;
        } else {
            //插入值并进行调整
            if (flag) {
                insert_up_big(value);
            } else {
                insert_up_small(value);
            }
        }
        QueueRealSize++;
        return true;
    }

    /**
     * >>： 带符号右移。正数右移高位补0，负数右移高位补1。比如：4 >> 1，结果是2；-4 >> 1，结果是-2。-2 >> 1，结果是-1。
     * >>>：无符号右移。无论是正数还是负数，高位通通补0。
     */
    //大顶堆
    private void insert_up_big(int value) {
        int position = QueueRealSize;
        while (position > 0) {
            int parent = (position - 1) >> 1;
            if (queue[parent] >= value) {
                break;
            }
            queue[position] = queue[parent];
            position = parent;
        }
        queue[position] = value;
    }

    //小顶堆
    private void insert_up_small(int value) {
        int position = QueueRealSize;
        while (position > 0) {
            int parent = (position - 1) >> 1;
            if (queue[parent] < value) {
                break;
            }
            queue[position] = queue[parent];
            position = parent;
        }
        queue[position] = value;
    }

    
    //出队判空
    public int poll() {
        int value = Integer.MIN_VALUE;
        if (!empty()) {
            value = queue[0];
            int x = queue[QueueRealSize - 1];
            if (flag) {
                insert_down_big(0, x);
            } else {
                insert_down_small(0, x);
            }
            QueueRealSize--;
        }
        return value;
    }

    public void insert_down_big(int position, int value) {
        int half = QueueRealSize >> 1;
        while (position < half) {
            //注意：此处不可以写成 position << 1 + 1;
            int leftchild = (position << 1) + 1;
            if (leftchild + 1 <= QueueRealSize) {
                leftchild = queue[leftchild] > queue[leftchild + 1] ? leftchild : leftchild + 1;
            }
            if (value > queue[leftchild]) {
                break;
            }
            queue[position] = queue[leftchild];
            position = leftchild;
        }
        queue[position] = value;
    }

    public void insert_down_small(int position, int value) {
        int half = QueueRealSize >> 1;
        while (position < half) {
            //注意：此处不可以写成 position << 1 + 1;
            int leftchild = (position << 1) + 1;
            if (leftchild + 1 < QueueRealSize) {
                leftchild = queue[leftchild] < queue[leftchild + 1] ? leftchild : leftchild + 1;
            }
            if (value <= queue[leftchild]) {
                break;
            }
            queue[position] = queue[leftchild];
            position = leftchild;
        }
        queue[position] = value;
    }

    
    public void push(int value) {
        this.offer(value);
    }

    
    public int pop() {
        return this.poll();
    }

    
    public int peek() {
        int value = Integer.MIN_VALUE;
        if (!empty()) {
            value = queue[0];
        }
        return value;
    }

    
    public boolean empty() {
        return QueueRealSize == 0;
    }

    
    public int getRealSize() {
        return QueueRealSize;
    }

    
    public int getMaxSize() {
        return QueueMaxsize;
    }


    
    public void resize() {
        //QueueMaxsize扩大一倍
        this.QueueMaxsize <<= 1;
        int[] copy = new int[QueueMaxsize];
        System.arraycopy(queue, 0, copy, 0, queue.length);
        queue = copy;
    }

    
    public boolean search(int x) {
        if (!empty()) {
            for (int i = 0; i < QueueRealSize; i++) {
                if (queue[i] == x) {
                    return true;
                }
            }
        }
        return false;
    }
}
