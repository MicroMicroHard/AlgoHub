package DataStructure.heapStackQueue.stack.calculator;

import Common.Utils.UTFactory;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/3/20 7:16 PM
 * @author-Email micromicrohard@outlook.com
 * @description 中缀转后缀
 */
public class Infix2Suffix {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误测试案例
    public void TestDoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        String s = "2+3/5*5+7";
        for (int i = 0; i < s.length(); i++) {
            queue.add(String.valueOf(s.charAt(i)));
        }
        Deque<String> fr = Infix2Suffix.infix2SuffixMethod(queue);
        while (!fr.isEmpty()) {
            System.out.print(fr.poll() + " ");
        }
    }

    public static Deque<String> infix2SuffixMethod(Queue<String> infixQueue) {
        Deque<String> suffixQueue = new LinkedList<>();
        if (infixQueue.isEmpty()) {
            return suffixQueue;
        }
        Stack<String> numStack = new Stack<>();
        Stack<String> optStack = new Stack<>();

        while (!infixQueue.isEmpty()) {
            String symbol = infixQueue.poll();
            switch (symbol) {
                case "+":
                case "-":
                case "*":
                case "/":
                    optStack.push(symbol);
                    break;
                case "(":
                    infix2SuffixMethod(infixQueue);
                    break;
                case ")":
                    deal(suffixQueue, numStack, optStack);
                    break;
                default:
                    // 数字
                    numStack.push(symbol);
                    break;
            }
        }
        deal(suffixQueue, numStack, optStack);
        return suffixQueue;
    }

    public static void deal(Deque<String> suffixQueue, Stack<String> numStack, Stack<String> optStack) {
        while (!numStack.empty()) {
            suffixQueue.add(numStack.pop());
        }
        Stack<String> tempS = new Stack<>();
        while (!optStack.empty()) {
            tempS.push(optStack.pop());
        }
        while (!tempS.empty()) {
            suffixQueue.add(tempS.pop());
        }
    }
}
