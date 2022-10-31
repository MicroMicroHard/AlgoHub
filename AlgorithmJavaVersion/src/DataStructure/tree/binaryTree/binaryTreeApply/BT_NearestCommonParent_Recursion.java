package DataStructure.tree.binaryTree.binaryTreeApply;

import DataStructure.tree.binaryTree.BinaryTreeImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-3-23 02:54:10
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 查找最近公共父节点/最近公共祖先
 * 思路一
 * 思路二
 */
public class BT_NearestCommonParent_Recursion extends BT_NearestCommonParent {
    List<BinaryTreeImpl> listX;
    List<BinaryTreeImpl> listY;

    //思路二：根据遍历的路径，求最后一个相同的路径
    public BinaryTreeImpl findNCP(BinaryTreeImpl root, int x, int y) {
        if (root == null) {
            return null;
        }
        listX = new ArrayList<>();
        listY = new ArrayList<>();
        printRoute(root, x, listX);
        printRoute(root, y, listY);
        if (listX.size() == 0 || listY.size() == 0) {
            return null;
        }
        BinaryTreeImpl node = null;
        for (int i = 0; i < listX.size(); i++) {
            if (listY.size() > i && listY.get(i).value == listX.get(i).value) {
                node = listX.get(i);
            }
        }
        return node;
    }

    public boolean printRoute(BinaryTreeImpl root, int value, List list_temp) {
        if (root == null) {
            return false;
        }
        list_temp.add(root);
        if (root.value == value) {
            return true;
        }
        if (printRoute(root.left, value, list_temp)) {
            return true;
        }
        if (printRoute(root.right, value, list_temp)) {
            return true;
        }
        list_temp.remove(list_temp.size() - 1);
        return false;
    }

    public BinaryTreeImpl findNCP1(BinaryTreeImpl root, int x, int y) {

        if (findx(root.left, x) && findx(root.left, y)) {
            BinaryTreeImpl v = findNCP(root.left, x, y);
            return v == null ? root.left : v;
        } else if (findx(root.right, x) && findx(root.right, y)) {
            BinaryTreeImpl v = findNCP(root.right, x, y);
            return v == null ? root.right : v;
        } else if (findx(root.left, x) && findx(root.right, y)
                || findx(root.right, x) && findx(root.left, y)) {
            return root;
        }
        return null;
    }
}
