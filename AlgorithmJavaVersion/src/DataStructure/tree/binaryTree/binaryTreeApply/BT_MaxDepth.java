package DataStructure.tree.binaryTree.binaryTreeApply;

import DataStructure.tree.binaryTree.BinaryTreeImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/8/19
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 * @description 二叉树最大深度
 */
public class BT_MaxDepth {

    Map<BinaryTreeImpl, Integer> statisticsMap = new HashMap<>();

    //获取树的最大深度
    public int getBiggestDepthMethod(BinaryTreeImpl root) {
        if (root == null) {
            return 0;
        }

        int left = getBiggestDepthMethod(root.left);
        int right = getBiggestDepthMethod(root.right);
        statisticsMap.put(root, Math.max(left, right) + 1);
        return Math.max(left, right) + 1;
    }
}
