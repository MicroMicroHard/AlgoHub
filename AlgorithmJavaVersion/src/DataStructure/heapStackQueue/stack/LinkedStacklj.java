package DataStructure.heapStackQueue.stack;

import DataStructure.list.Nodelj;
import DataStructure.heapStackQueue.Stacklj;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-10-21 12:17
 * @author-Email micromicrohard@outlook.com
 * @description 链式栈
 */
public class LinkedStacklj implements Stacklj {

    public Nodelj stackTop;
    public int stackRealSize;
    public int stackMaxSize;

    public LinkedStacklj(int num) {
        this.stackRealSize = 0;
        this.stackMaxSize = num;
        this.stackTop = null;
    }

    public LinkedStacklj() {
        //init size 32
        this.stackRealSize = 0;
        this.stackMaxSize = 32;
        this.stackTop = null;
    }

    public int pop() {
        if (!this.empty()) {
            this.stackRealSize--;
            int key = this.stackTop.key;
            this.stackTop = this.stackTop.next;
            return key;
        }
        return Integer.MIN_VALUE;
    }

    public boolean push(int key) {
        Nodelj node = new Nodelj(key);
        if (this.stackRealSize == this.stackMaxSize) {
            resize();
        }
        node.next = this.stackTop;
        this.stackTop = node;
        this.stackRealSize++;
        return true;
    }

    public int peek() {
        return (stackTop == null && stackRealSize == 0) ? Integer.MIN_VALUE : stackTop.key;
    }

    public boolean empty() {
        return (stackTop == null && stackRealSize == 0);
    }

    public boolean search(int key) {
        Nodelj test = stackTop;
        while (test != null) {
            if (test.key == key) {
                return true;
            }
            test = test.next;
        }
        return false;
    }

    public int getRealsize() {
        return this.stackRealSize;
    }

    public int getMaxsize() {
        return this.stackMaxSize;
    }

    
    public void resize() {
        this.stackMaxSize <<= 1;
    }

}
