package DataStructure.tree.binaryTree.binaryTreeApply;

import DataStructure.tree.binaryTree.BinaryTreeImpl;
import Top100.BTFindCertainValuePath;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 蔚蔚樱
 * @date 2020-02-20 11:39
 * @description 计算二叉树中最大的子树路径和
 * 1、记录最大的子树路径和
 * 2、记录最大的子树路径和的值
 */
public class BTFindLargestSubPath_Recursion implements BTFindCertainValuePath {

    int sum;
    int sumTemp;
    List<Integer> list;
    List<Integer> listTemp;

    public int[] countLargestSubPath(BinaryTreeImpl binaryTree) {
        if (binaryTree == null) {
            return null;
        }
        //init
        list = new ArrayList<>();
        listTemp = new ArrayList<>();
        sum = 0;
        sumTemp = 0;
        //count
        roll(binaryTree);
        int[] arrayValue = list.stream().mapToInt(Integer::intValue).toArray();
        return arrayValue;
    }

    private void roll(BinaryTreeImpl binaryTree) {
        if (binaryTree == null) {
            return;
        }
        sumTemp += binaryTree.value;
        listTemp.add(binaryTree.value);

        if (sumTemp > sum) {
            sum = sumTemp;
            //此处的list一定要重新赋值（Java值传递，但是此处是引用）
            list = new ArrayList<>(listTemp);
        }
        roll(binaryTree.left);
        roll(binaryTree.right);

        sumTemp -= binaryTree.value;
        //list最好用remove对象方式，而不是值
        listTemp.remove((Integer) binaryTree.value);
    }

    public int countLargestSum(BinaryTreeImpl binaryTree) {
        if (binaryTree == null) {
            return 0;
        }
        sumTemp += binaryTree.value;
        if (sumTemp > sum) {
            sum = sumTemp;
        }
        countLargestSum(binaryTree.left);
        countLargestSum(binaryTree.right);

        sumTemp -= binaryTree.value;
        return sum;
    }

    
    public ArrayList<ArrayList<BinaryTreeImpl>> FindPath(BinaryTreeImpl root, int value) {
        return null;
    }
}
