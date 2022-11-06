package DataStructure.tree.binaryTree.binaryTree2Array;

import Common.Utils.UTFactory;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/14 12:13
 * @author-Email micromicrohard@outlook.com
 * @description 输出树的左视图
 * 假设一颗树：
 * 1
 * 2    3
 * 4    5
 * 打印的左视图为：1，2，4
 * 解决方法：
 * Method_LevelQueue: 利用当前队列  统计每一层的最左边的元素
 * Method_Queue     : 利用队列和标识 统计每一层的最左边的元素
 * Method_Recursive : 利用递归和层高 统计每一层的最左边的元素
 * @blogURL
 */
public class BT2ArrayByLeftView {

    @Test // 验证功能：从数据库获取测试数据，用于单元测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误的测试案例
    public void DoubleTrack() throws Exception {
        String input = "{1, 2, NLF, NLF, 4, 5, NLF, NLF, 3, 6, NLF, 7, NLF, NLF, NLF}";
        String output = "{1, 2, 5, 6, 7}";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    public int[] Method_LevelQueue(BinaryTreeImpl root) {
        if (root == null) {
            return new int[]{};
        }
        List<BinaryTreeImpl> answerList = new LinkedList<>();
        Queue<BinaryTreeImpl> queue = new LinkedList<>();
        queue.offer(root);
        answerList.add(queue.peek());
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) { // 直观上 分层统计 每一次的队列头
                BinaryTreeImpl node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            if (!queue.isEmpty()) {
                answerList.add(queue.peek());
            }
        }
        return answerList.stream().mapToInt(x -> x.value).toArray();
    }

    public int[] Method_Queue(BinaryTreeImpl root) {
        if (root == null) {
            return new int[]{};
        }
        List<BinaryTreeImpl> answerList = new LinkedList<>();
        Queue<BinaryTreeImpl> queue = new LinkedList<>();
        queue.offer(root);
        answerList.add(queue.peek());
        BinaryTreeImpl cur = root;
        BinaryTreeImpl rightTail = root;

        while (!queue.isEmpty()) {
            BinaryTreeImpl node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                cur = node.left;
            }
            if (node.right != null) {
                queue.offer(node.right);
                cur = node.right;
            }
            // 当队尾标识到达最右边的时候，队首元素就是左视图看到的元素
            if (node.equals(rightTail)) {//或者使用node == rightTail or node.value == rightTail.value
                rightTail = cur;
                if (!queue.isEmpty()) {
                    answerList.add(queue.peek());
                }
            }
        }
        return answerList.stream().mapToInt(x -> x.value).toArray();
    }

    int level = 0;

    public int[] Method_Recursive(BinaryTreeImpl root) {
        if (root == null) {
            return new int[]{};
        }
        List<BinaryTreeImpl> answerList = new LinkedList<>();
        level = 0;
        roll(1, root, answerList);
        return answerList.stream().mapToInt(x -> x.value).toArray();
    }

    public void roll(int depth, BinaryTreeImpl curNode, List<BinaryTreeImpl> answerList) {

        if (depth > level) {
            answerList.add(curNode);
            level++;
        }
        if (curNode.left != null) {
            roll(depth + 1, curNode.left, answerList);
        }
        if (curNode.right != null) {
            roll(depth + 1, curNode.right, answerList);
        }
    }
}
