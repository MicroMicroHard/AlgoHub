package DataStructure.tree.binaryTree.binaryTreeImpl;

import DataStructure.tree.binaryTree.BinaryTreeImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/8
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 树的左视图
 * 假设一颗树：
 * 1
 * 2       3
 * 4      5
 * 打印的左视图为：1，2，4
 */
public class BT_PrintLeftView {

    List<Integer> list = new ArrayList();

    public int[] print1(BinaryTreeImpl root) {
        if (root == null) {
            return new int[]{};
        }
        list.clear();
        Queue<BinaryTreeImpl> q = new LinkedList();
        q.add(root);
        list.add(root.value);
        BinaryTreeImpl front = root;
        BinaryTreeImpl tail = root;
        while (!q.isEmpty()) {
            BinaryTreeImpl node = q.poll();
            if (node.left != null) {
                q.add(node.left);
                tail = node.left;
            }
            if (node.right != null) {
                q.add(node.right);
                tail = node.right;
            }
            if (front == node) {
                if (!q.isEmpty()) {
                    list.add(q.peek().value);
                    front = tail;
                }
            }
        }
        int[] a = list.stream().mapToInt(Integer::intValue).toArray();
        return a;
    }

    // todo 记录当前层的count
    // todo 使用 List<list<Node>> -> list<Node>表示当前层的节点(从左到右)

    public int[] printMethod(BinaryTreeImpl root) {
        if (root == null) {
            return new int[]{};
        }
        Queue<BinaryTreeImpl> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        q.add(root);
        level.add(root.value);
        list.add(level);
        while (!q.isEmpty()) {
            int size = q.size();
            level = new ArrayList<>();
            while (size > 0) {
                BinaryTreeImpl node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                    level.add(node.left.value);
                }
                if (node.right != null) {
                    q.add(node.right);
                    level.add(node.right.value);
                }
                size--;
            }
            if (level.size() != 0) {
                list.add(level);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i).get(0);
        }
        return res;
    }
}
