package binaryTree

/**
 * @author 蔚蔚樱
 * @date 2020-02-18 16:13
 * @description
 * 二叉树 ： 判断两个二叉树相等（自身）
 * 二叉树 ： 判断两个二叉树相等（其他两个树）
 */

type BinaryTree interface {

	//判断两个二叉树相等
	EqualsDouble(source, target *BinaryTreeImpl) bool

	//判断两个二叉树相等
	Equals(target *BinaryTreeImpl) bool

	InterfaceName() string
}
