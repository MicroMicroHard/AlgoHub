package binaryTree

/**
 * @author 蔚蔚樱
 * @date 2021-11-21 16:09
 * @description 二叉树的实现（二叉树反序列化）
 * 单序创建：
 * 1、将按层次遍历的方式输入的数组  构造成一个二叉树
 * 2、将按先序遍历的方式输入的数组  构造成一个二叉树
 * 3、将按中序遍历的方式输入的数组  构造成一个二叉树
 * 4、将按后序遍历的方式输入的数组  构造成一个二叉树
 * 5、将一个完全二叉树的数组 构造成一个二叉树
 * 多序创建：
 * 6、已知前序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。
 * 7、已知后序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。
 */

type Array2BinaryTree interface {

	//1、将按层次遍历的方式输入的数组  构造成一个二叉树
	CreateBinaryTreeByLevelInput(array []int) (*BinaryTreeImpl, error)

	//2、将按先序遍历的方式输入的数组  构造成一个二叉树
	CreateBinaryTreeByPreOrderInput(array []int) (*BinaryTreeImpl, error)

	//3、将按中序遍历的方式输入的数组  构造成一个二叉树
	CreateBinaryTreeByInOrderInput(array []int) (*BinaryTreeImpl, error)

	//4、将按后序遍历的方式输入的数组  构造成一个二叉树
	CreateBinaryTreeByPostOrderInput(array []int) (*BinaryTreeImpl, error)

	//5、将一个完全二叉树的数组 构造成一个二叉树
	CreateFullBinaryTree(array []int) (*BinaryTreeImpl, error)

	//6、已知前序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。
	CreateBinaryTreeByPre_In_OrderInput(preOrderArray, inOrderArray []int) (*BinaryTreeImpl, error)

	//7、已知后序遍历序列和中序遍历序列，构建唯一一棵确定的二叉树。
	CreateTreePost_InOrderInput(postOrderArray, inOrderArray []int) (*BinaryTreeImpl, error)
}
