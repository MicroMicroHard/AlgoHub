package DataStructure.heapStackQueue.queue;

import DataStructure.heapStackQueue.stack.ArrayStacklj;
import DataStructure.heapStackQueue.Stacklj;
import DataStructure.heapStackQueue.Queuelj;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/23
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 使用栈实现队列的功能
 */
public class StackQueue implements Queuelj {

    Stacklj stack1;
    Stacklj stack2;
    public int QueueRealsize;
    public int QueueMaxsize;
    int top = 0;

    public StackQueue() {
        this.QueueMaxsize = 32;
        stack1 = new ArrayStacklj(this.QueueMaxsize);
        stack2 = new ArrayStacklj(this.QueueMaxsize);
    }

    public StackQueue(int num) {
        stack1 = new ArrayStacklj(num);
        stack2 = new ArrayStacklj(num);
    }


    public boolean offer(int value) {
        this.QueueRealsize++;
        this.stack1.push(value);
        if (QueueRealsize == 1) {
            top = value;
        }
        return true;
    }


    public int poll() {
        int value = Integer.MIN_VALUE;
        if (!empty()) {
            int count = stack1.getRealsize();
            for (int i = 0; i < count - 1; i++) {
                stack2.push(stack1.pop());
            }
            value = stack1.pop();
            this.QueueRealsize--;
            int real = stack2.getRealsize();
            for (int i = 0; i < real; i++) {
                if (i == 0) {
                    top = stack2.pop();
                    stack1.push(top);
                } else {
                    stack1.push(stack2.pop());
                }
            }
        }
        return value;
    }


    public int peek() {
        int value = Integer.MIN_VALUE;
        //判空
        if (!empty()) {
            //因为stack1本身在变化，此处判断条件不可以用stack1.getRealsize()；
            /*int count = stack1.getRealsize();
            for (int i = 0; i < count - 1; i++) {
                stack2.push(stack1.pop());
            }
            value = stack1.peek();
            int real = stack2.getRealsize();
            for (int i = 0; i < real; i++) {
                stack1.push(stack2.pop());
            }*/
            return top;
        }

        return value;
    }


    public boolean empty() {
        return this.stack1.empty();
    }


    public int getRealSize() {
        return this.stack1.getRealsize();
    }


    public int getMaxSize() {
        return this.stack1.getMaxsize();
    }


    public void resize() {
        this.QueueMaxsize <<= 1;
        this.stack1.resize();
        this.stack2.resize();
    }


    public boolean search(int x) {
        return this.stack1.search(x);
    }
}
