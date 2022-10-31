package DataStructure.tree.binaryTree.binaryTreeApply;

import DataStructure.tree.binaryTree.BinaryTreeImpl;
import Top100.BTFindCertainValuePath;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author 蔚蔚樱
 * @date 2020-02-21 09:08
 * @description 二叉树中和为某值的节点路径
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为：从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * <p>
 * 解题思路：
 * 1）首先是采用先序遍历二叉树的思想
 * 2）先对根节点进行非空判断（非空结点先加进来，如果不合适，后续删除）
 * 3）当遍历到叶子结点，并且累加值为target的时候，结束
 * 4）左右孩子递归，删除不合适结点。
 * <p>
 * 注意：如果路径中存在负数，修改代码，遍历到叶子节点。
 */

//二叉树中和为某一值的路径
public class BTFindCertainValuePath_Stack implements BTFindCertainValuePath {

    //当前路径用list表示
    ArrayList<BinaryTreeImpl> route_list;
    //所有路径list 组成的 all_route_list
    ArrayList<ArrayList<BinaryTreeImpl>> all_route_list;


    public ArrayList<ArrayList<BinaryTreeImpl>> FindPath(BinaryTreeImpl root, int value) {

        //init ArrayList
        route_list = new ArrayList<>();
        all_route_list = new ArrayList<>();
        if (value <= 0 || root == null) {
            return all_route_list;
        }
        Stack<BinaryTreeImpl> stack = new Stack<>();
        int sum = 0;
        BinaryTreeImpl node = root;

        //先序遍历左孩子，再遍历右孩子，判断点要写在左孩子的循环内
        while (!stack.empty() || node != null) {
            while (node != null && sum + root.value <= value) {
                sum += node.value;
                route_list.add(node);
                stack.push(node);
                if (sum == value) {
                    all_route_list.add(new ArrayList<>(route_list));
                }
                if (sum >= value) {//剪枝
                    stack.pop();
                    break;
                }
                node = node.left;
            }

            if (!stack.empty()) {//出栈检查
                node = stack.pop();
                while (node.right == null && !stack.empty()) {
                    sum -= node.value;
                    route_list.remove(node);
                    node = stack.pop();
                }
                //更新 sum 和 route_list
                while (route_list.size() > 0 && node != route_list.get(route_list.size() - 1)) {
                    sum -= route_list.get(route_list.size() - 1).value;
                    route_list.remove(route_list.size() - 1);
                }
                node = node.right;
            }
            //循环退出条件
            if ((node == null || sum + node.value > value) && stack.empty()) {
                break;
            }
        }
        all_route_list = sort(all_route_list);
        return all_route_list;
    }
}
