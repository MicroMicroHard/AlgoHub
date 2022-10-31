package Top100;

import DataStructure.tree.binaryTree.BinaryTreeImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

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

public interface BTFindCertainValuePath {

    ArrayList<ArrayList<BinaryTreeImpl>> FindPath(BinaryTreeImpl root, int value);

    default ArrayList<ArrayList<BinaryTreeImpl>> sort(ArrayList<ArrayList<BinaryTreeImpl>> all_route_list) {
        if (all_route_list.size() >= 2) {

            //Collections 重写 compare 方法
            /*Collections.sort(all_route_list, new Comparator<ArrayList<Integer>>() {
                
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    int diff = o1.size() - o2.size();
                    if (diff == 0) {
                        return 0;
                    }
                    return diff > 0 ? 1 : -1;
                }
            });*/

            //stream 写法
            all_route_list = (ArrayList<ArrayList<BinaryTreeImpl>>) all_route_list.stream()
                    .sorted(Comparator.comparing(ArrayList::size))
                    .collect(Collectors.toList());
        }
        return all_route_list;
    }
}
