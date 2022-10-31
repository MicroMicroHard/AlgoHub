package DataStructure.tree.binaryTree.binaryTreeApply;

import DataStructure.tree.binaryTree.BinaryTreeImpl;
import Top100.BTFindCertainValuePath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liujun
 * @date 2020-02-20 11:39
 * @description 计算二叉树中最大的子树路径和
 * 1、记录最大的子树路径和
 * 2、记录最大的子树路径和的值
 */
public class BTFindLargestSubPath_NonRecursion extends BTFindLargestSubPath_Recursion implements BTFindCertainValuePath {

    //用双queue实现计算二叉树中最大的子树路径和
    public int countLargestSum(BinaryTreeImpl binaryTree) {

        if (binaryTree == null) {
            return 0;
        }
        Queue<BinaryTreeImpl> queue = new LinkedList<>();
        Queue<Integer> queueInt = new LinkedList<>();
        queue.offer(binaryTree);
        int bestPath = binaryTree.value;
        queueInt.offer(binaryTree.value);

        while (!queue.isEmpty() && !queueInt.isEmpty()) {
            BinaryTreeImpl root = queue.poll();
            int rootValue = queueInt.poll();
            if (root.left != null) {
                if (rootValue + root.left.value > bestPath) {
                    bestPath = rootValue + root.left.value;
                }
                queue.offer(root.left);
                queueInt.offer(rootValue + root.left.value);
            }
            if (root.right != null) {
                if (rootValue + root.right.value > bestPath) {
                    bestPath = rootValue + root.right.value;
                }
                queue.offer(root.right);
                queueInt.offer(rootValue + root.right.value);
            }
        }
        return bestPath;
    }

    
    public ArrayList<ArrayList<BinaryTreeImpl>> FindPath(BinaryTreeImpl root, int value) {
        return null;
    }
}
