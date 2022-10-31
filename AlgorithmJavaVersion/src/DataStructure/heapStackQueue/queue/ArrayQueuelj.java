package DataStructure.heapStackQueue.queue;

import DataStructure.heapStackQueue.Queuelj;
import DataStructure.heapStackQueue.QueueljCommUT;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-09 22:56
 * @author-Email micromicrohard@outlook.com
 * @description 数组队列  循环队列
 */
public class ArrayQueuelj implements Queuelj {

    public static void main(String[] args) throws Exception {
        QueueljCommUT q = new QueueljCommUT();
        q.test(ArrayQueuelj.class.getName());
        //q.TestDoubleTrack(ArrayQueuelj.class.getName(), "[3,4,56,7,8,98,76,5,4]", "true");
    }

    //TestDoubleTrack

    public int[] queue;
    public int QueueRealSize;
    public int QueueMaxSize;
    public int front;
    public int tail;

    public ArrayQueuelj() {
        //默认初始值为50
        this.QueueMaxSize = 32;
        this.QueueRealSize = 0;
        this.queue = new int[QueueMaxSize];
        this.front = this.tail = 0;
    }

    public ArrayQueuelj(int num) {
        //指定初始值
        this.QueueMaxSize = num;
        this.QueueRealSize = 0;
        this.queue = new int[QueueMaxSize];
        this.front = this.tail = 0;
    }

    
    //插入元素
    public boolean offer(int value) {

        if ((tail + 1 + QueueMaxSize) % QueueMaxSize == front) {
            resize();
        }
        //循环队列
        if (tail + 1 != front) {
            queue[tail] = value;
            tail = (++tail) % QueueMaxSize;
            this.QueueRealSize++;
            return true;
        }
        return false;
    }

    
    public int poll() {
        int value = Integer.MIN_VALUE;
        //判空，元素出队
        if (!empty()) {
            value = queue[front];
            front = (front + 1 + QueueMaxSize) % QueueMaxSize;
            QueueRealSize--;
        }
        return value;
    }

    //获取队首元素，不删除元素
    
    public int peek() {
        int value = Integer.MIN_VALUE;
        //判空
        if (!empty()) {
            value = queue[front];
        }
        return value;
    }

    
    public int getRealSize() {
        return this.QueueRealSize;
    }

    
    public int getMaxSize() {
        return this.QueueMaxSize;
    }

    
    public void resize() {
        //QueueMaxsize扩大一倍
        int before = QueueMaxSize;
        QueueMaxSize <<= 1;
        int[] copy = new int[QueueMaxSize];
        int point = 0;
        if (tail < front) {
            while (front < tail + before) {
                copy[point] = queue[(front + before) % before];
                front++;
                point++;
            }
        } else {
            for (int i = front; i < tail; i++) {
                System.arraycopy(queue, front, copy, 0, tail - front);
            }
            point = tail;
        }
        front = 0;
        tail = point;
        queue = copy;
    }

    
    public boolean search(int x) {
        if (!empty()) {
            int point = this.front;
            while (point != this.tail) {
                if (queue[point] == x) {
                    return true;
                }
                point = (point + 1 + QueueMaxSize) % QueueMaxSize;
            }
        }
        return false;
    }

    
    public boolean empty() {
        return this.tail == this.front;
    }
}
