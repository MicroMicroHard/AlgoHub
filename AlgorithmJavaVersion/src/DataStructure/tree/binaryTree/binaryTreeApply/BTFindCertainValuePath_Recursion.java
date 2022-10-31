package DataStructure.tree.binaryTree.binaryTreeApply;

import DataStructure.tree.binaryTree.BinaryTreeImpl;
import Top100.CombinationAndPermutation;
import Top100.BTFindCertainValuePath;

import java.util.*;

/**
 * @author liujun
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

// 二叉树中和为某一值的路径
public class BTFindCertainValuePath_Recursion implements CombinationAndPermutation, BTFindCertainValuePath {

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
        roll(root, value);
        //排序 ： 在返回值的list中，数组长度大的数组靠前
        all_route_list = sort(all_route_list);
        return all_route_list;
    }

    private void roll(BinaryTreeImpl root, int value) {
        if (root == null) {
            return;
        }
        route_list.add(root);
        /* why not keep the routeList and value at same time ?
        because value is not a global variable,stack will do it(the stack level retain the valve). */
        value -= root.value;

        //解法1：当遍历到叶子结点，并且累加值为target的时候，结束
		/*if(target == 0 && root.left == null && root.right == null){
			//all_list加入的是route_list的引用，不新建容易被后续的修改
			all_route_list.add(new ArrayList<Integer>(route_list));
		}*/

        //解法2：当遍历到某点满足值要求，则不再继续加下去，直接返回
        if (value <= 0) {
            //错误写法：all_route_list.add(route_list);
            if (value == 0) {
                all_route_list.add(new ArrayList<>(route_list));
            }
            route_list.remove(route_list.size() - 1);//退出时不保留当前值
            return;
        }

        roll(root.left, value);
        roll(root.right, value);
        route_list.remove(route_list.size() - 1);
    }

    
    public int[][] Solution(int[] array, int target) {
        return new int[0][];
    }
}
