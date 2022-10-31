package DataStructure.heapStackQueue.stack;

import java.util.Stack;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/8/3
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 逆置栈中元素
 * 有两个相同的栈，一个里面放着自大到小排列的数，栈顶的数最小，另一个栈是空的.
 * 不允许利用其它的数据结构，只能利用这两个栈，要求把第一个栈里的数字反过来，从
 * 小到大排列，结果还放在原来的那个栈里面。
 */
public class InversionStack_Recursion extends InversionStack {

    Stack<Integer> stackB = new Stack();

    public Stack inversion(Stack<Integer> stackA) {
        stackB = new Stack();
        stackB.push(cu(stackA));
        while (!stackB.empty()) {
            stackA.push(stackB.pop());
        }
        return stackA;
    }

    public int cu(Stack<Integer> stackA) {
        if (stackA.size() == 1) {
            return stackA.pop();
        }
        int v = stackA.pop();
        stackB.push(cu(stackA));
        return v;
    }
}
