package DataStructure.tree.binaryTree;

import DataStructure.list.Listlj;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/11/4
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 二叉树转链表
 */
public interface BinaryTree2LinkedList {

    /**
     *
     * @param binaryTree 二叉树
     * @return 单链表
     * 二叉树转链表：所有的右孩子转到左孩子上
     */
    public Listlj BinaryTree2LinkedList(BinaryTreeImpl binaryTree);
}
