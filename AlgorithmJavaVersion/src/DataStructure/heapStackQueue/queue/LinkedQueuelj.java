package DataStructure.heapStackQueue.queue;

import DataStructure.list.Nodelj;
import DataStructure.heapStackQueue.Queuelj;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-09 22:56
 * @author-Email micromicrohard@outlook.com
 * @description 链队列
 */
public class LinkedQueuelj implements Queuelj {

    public int queueRealSize;
    public int queueMaxSize;
    public Nodelj front;
    public Nodelj tail;


    public LinkedQueuelj() {
        //默认初始值为32
        this.queueMaxSize = 32;
        new LinkedQueuelj(queueMaxSize);
    }

    public LinkedQueuelj(int num) {
        this.queueRealSize = 0;
        this.queueMaxSize = num;
        this.front = this.tail = null;
    }

    
    public boolean offer(int key) {
        //队空判断
        if (this.queueRealSize == this.queueMaxSize) {
            resize();
        }
        Nodelj linkedQueueNode = new Nodelj(key);
        if (this.queueRealSize == 0) {
            this.front = linkedQueueNode;
        } else {
            this.tail.next = linkedQueueNode;
        }
        this.tail = linkedQueueNode;
        this.queueRealSize++;
        return true;
    }

    
    public int poll() {
        int key = Integer.MIN_VALUE;
        //判空
        if (!empty()) {
            key = this.front.key;
            this.front = front.next;
            this.queueRealSize--;
        }
        return key;
    }

    
    public int peek() {
        int key = Integer.MIN_VALUE;
        //判空
        if (!empty()) {
            key = this.front.key;
        }
        return key;
    }

    
    public int getRealSize() {
        return this.queueRealSize;
    }

    
    public int getMaxSize() {
        return this.queueMaxSize;
    }

    
    public void resize() {
        this.queueMaxSize <<= 1;
    }

    
    public boolean search(int x) {
        if (!empty()) {
            Nodelj node = this.front;
            while (node.next != null) {
                if (node.key == x) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    
    public boolean empty() {
        return this.queueRealSize == 0;
    }
}