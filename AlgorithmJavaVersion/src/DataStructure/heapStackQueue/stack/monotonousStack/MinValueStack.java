package DataStructure.heapStackQueue.stack.monotonousStack;

import DataStructure.heapStackQueue.stack.ArrayStacklj;

import java.util.Stack;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-8-25 03:47:41
 * @author-Email micromicrohard@outlook.com
 * @description 最小栈 单调栈
 * 实现一个这样的栈，这个栈除了可以进行普通的push、pop操作以外，还可以进行getMin的操作，
 * getMin方法被调用后，会返回当前栈的最小值。栈里面存放的都是 int 整数，并且数值的范围是 [-100000, 100000]。
 * 要求 所有操作 的时间复杂度是 O(1)。
 * 附加：如果空间复杂度也能O(1)的话可加分。
 */
public class MinValueStack extends ArrayStacklj {

    private static final long serialVersionUID = 1224463164541339165L;

    //解题思路在于新建立一个最小栈，保持当前最小值
    Stack<Integer> miniStack = new Stack<Integer>();

    public MinValueStack() {
    }

    public int getMinValue() {
        return miniStack.peek();
    }

    public boolean push(int item) {
        super.push(item);
        if (miniStack.size() == 0 || item < miniStack.peek()) {
            miniStack.push(item);
        } else {
            miniStack.push(miniStack.peek());
        }
        return true;
    }

    public int pop() {
        miniStack.pop();
        return super.pop();
    }

}
