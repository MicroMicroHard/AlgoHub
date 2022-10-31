package DataStructure.tree.binaryTree;

import DataStructure.tree.Tree;

/**
 * @author liujun
 * @date 2020-02-18 16:13
 * @description 二叉树 ： 判断两个二叉树相等（自身）
 * 二叉树 ： 判断两个二叉树相等（其他两个树）
 */
public interface BinaryTree extends Tree {

    //判断两个二叉树相等
    boolean equals(BinaryTreeImpl source, BinaryTreeImpl target);

    //判断两个二叉树相等
    boolean equals(BinaryTreeImpl target);

    // bind
    void bind(BinaryTreeImpl root, BinaryTreeImpl left, BinaryTreeImpl right, BinaryTreeImpl parent);

    void bind(BinaryTreeImpl left, BinaryTreeImpl right, BinaryTreeImpl parent);

    void bind(BinaryTreeImpl left, BinaryTreeImpl right);

    // 序列化
    int[] serialize(BinaryTreeImpl root);

    // 反序列化
    BinaryTreeImpl deserialization(int[] array);

    // 显示输出 打印
    void print();
}
