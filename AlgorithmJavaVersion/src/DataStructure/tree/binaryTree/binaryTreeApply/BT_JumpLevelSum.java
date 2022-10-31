package DataStructure.tree.binaryTree.binaryTreeApply;


import Algorithm.comprehensive.lsg.LSG;
import Common.Utils.GC.binaryTreeImpl.BinaryTree2ArrayImpl;
import DataStructure.tree.binaryTree.BinaryTreeImpl;
import Top100.Dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/12/21
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://leetcode-cn.com/problems/house-robber-iii/
 * @description 二叉树间隔层之和
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 */

public class BT_JumpLevelSum extends BinaryTree2ArrayImpl implements LSG, Dynamic {

    Map<BinaryTreeImpl, Integer> containMap = new HashMap<>();
    Map<BinaryTreeImpl, Integer> nonContainMap = new HashMap<>();

    public int rob(BinaryTreeImpl root) {
        if (root == null) {
            return 0;
        }
        count(root);
        return Math.max(containMap.getOrDefault(root, 0), nonContainMap.getOrDefault(root, 0));
    }

    public void count(BinaryTreeImpl node) {
        if (node == null) {
            return;
        }
        count(node.left);
        count(node.right);
        // containMap需要把 node.value 考虑进去
        containMap.put(node, node.value + nonContainMap.getOrDefault(node.left, 0) + nonContainMap.getOrDefault(node.right, 0));
        nonContainMap.put(node, Math.max(containMap.getOrDefault(node.left, 0), nonContainMap.getOrDefault(node.left, 0))
                + Math.max(containMap.getOrDefault(node.right, 0), nonContainMap.getOrDefault(node.right, 0)));
    }

    
    public int LargestSumOfGap(int[] array) {
        return 0;
    }
}
