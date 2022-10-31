package binaryTreeTestData

import "AlgorithmPractice/src/DataStructure/tree/binaryTree"

func GetFullBinaryTreeDemo04() *binaryTree.BinaryTreeImpl {
	binaryTree1 := binaryTree.BinaryTreeImpl{Value: 1}
	binaryTree2 := binaryTree.BinaryTreeImpl{Value: 2}
	binaryTree3 := binaryTree.BinaryTreeImpl{Value: 3}
	binaryTree1.Left = &binaryTree2
	binaryTree1.Right = &binaryTree3
	return &binaryTree1
}

func GetBinaryTreeDemo03() *binaryTree.BinaryTreeImpl {
	binaryTree1 := binaryTree.BinaryTreeImpl{Value: 1}
	binaryTree2 := binaryTree.BinaryTreeImpl{Value: 2}
	binaryTree3 := binaryTree.BinaryTreeImpl{Value: 3}
	binaryTree4 := binaryTree.BinaryTreeImpl{Value: 4}
	binaryTree5 := binaryTree.BinaryTreeImpl{Value: 5}
	binaryTree6 := binaryTree.BinaryTreeImpl{Value: 6}
	binaryTree7 := binaryTree.BinaryTreeImpl{Value: 7}
	binaryTree1.Left = &binaryTree2
	binaryTree1.Right = &binaryTree3
	binaryTree2.Left = &binaryTree4
	binaryTree2.Right = &binaryTree5
	binaryTree3.Left = &binaryTree6
	binaryTree3.Right = &binaryTree7
	return &binaryTree1
}

func GetsubtreeDemo03() *binaryTree.BinaryTreeImpl {
	binaryTree3 := binaryTree.BinaryTreeImpl{Value: 3}
	binaryTree6 := binaryTree.BinaryTreeImpl{Value: 6}
	binaryTree7 := binaryTree.BinaryTreeImpl{Value: 7}
	binaryTree3.Left = &binaryTree6
	binaryTree3.Right = &binaryTree7
	return &binaryTree3
}

func GetBinaryTreeDemo04() *binaryTree.BinaryTreeImpl {
	binaryTree1 := binaryTree.BinaryTreeImpl{Value: 1}
	binaryTree2 := binaryTree.BinaryTreeImpl{Value: 2}
	binaryTree3 := binaryTree.BinaryTreeImpl{Value: 3}
	binaryTree4 := binaryTree.BinaryTreeImpl{Value: 4}
	binaryTree7 := binaryTree.BinaryTreeImpl{Value: 7}
	binaryTree1.Left = &binaryTree2
	binaryTree1.Right = &binaryTree3
	binaryTree2.Left = &binaryTree4
	binaryTree3.Right = &binaryTree7
	return &binaryTree1
}

func GetBinaryTreeDemo05() *binaryTree.BinaryTreeImpl {
	binaryTree1 := binaryTree.BinaryTreeImpl{Value: 1}
	binaryTree2 := binaryTree.BinaryTreeImpl{Value: 2}
	binaryTree3 := binaryTree.BinaryTreeImpl{Value: 3}
	binaryTree4 := binaryTree.BinaryTreeImpl{Value: 4}
	binaryTree5 := binaryTree.BinaryTreeImpl{Value: 5}
	binaryTree6 := binaryTree.BinaryTreeImpl{Value: 6}
	binaryTree7 := binaryTree.BinaryTreeImpl{Value: 7}
	binaryTree8 := binaryTree.BinaryTreeImpl{Value: 8}
	binaryTree9 := binaryTree.BinaryTreeImpl{Value: 9}
	binaryTree10 := binaryTree.BinaryTreeImpl{Value: 10}
	binaryTree11 := binaryTree.BinaryTreeImpl{Value: 11}
	binaryTree12 := binaryTree.BinaryTreeImpl{Value: 12}
	binaryTree13 := binaryTree.BinaryTreeImpl{Value: 13}
	binaryTree14 := binaryTree.BinaryTreeImpl{Value: 14}
	binaryTree15 := binaryTree.BinaryTreeImpl{Value: 15}
	binaryTree16 := binaryTree.BinaryTreeImpl{Value: 16}
	binaryTree17 := binaryTree.BinaryTreeImpl{Value: 17}
	binaryTree18 := binaryTree.BinaryTreeImpl{Value: 18}
	binaryTree19 := binaryTree.BinaryTreeImpl{Value: 19}
	binaryTree20 := binaryTree.BinaryTreeImpl{Value: 20}

	binaryTree1.Left = &binaryTree2
	binaryTree1.Right = &binaryTree3
	binaryTree2.Left = &binaryTree4
	binaryTree2.Right = &binaryTree6
	binaryTree3.Left = &binaryTree7
	binaryTree3.Right = &binaryTree8
	binaryTree4.Left = &binaryTree9
	binaryTree7.Left = &binaryTree10
	binaryTree7.Right = &binaryTree11
	binaryTree8.Left = &binaryTree12
	binaryTree9.Left = &binaryTree13
	binaryTree10.Left = &binaryTree15
	binaryTree10.Right = &binaryTree16
	binaryTree12.Left = &binaryTree5
	binaryTree13.Left = &binaryTree14
	binaryTree16.Left = &binaryTree17
	binaryTree5.Right = &binaryTree20
	binaryTree17.Right = &binaryTree18
	binaryTree18.Left = &binaryTree19
	return &binaryTree1
}

func GetBinaryTreeDemo06() *binaryTree.BinaryTreeImpl {
	binaryTree1 := binaryTree.BinaryTreeImpl{Value: 1}
	binaryTree2 := binaryTree.BinaryTreeImpl{Value: 2}
	binaryTree3 := binaryTree.BinaryTreeImpl{Value: 3}
	binaryTree4 := binaryTree.BinaryTreeImpl{Value: 4}
	binaryTree5 := binaryTree.BinaryTreeImpl{Value: 5}
	binaryTree8 := binaryTree.BinaryTreeImpl{Value: 8}
	binaryTree1.Left = &binaryTree2
	binaryTree1.Right = &binaryTree3
	binaryTree2.Right = &binaryTree4
	binaryTree3.Left = &binaryTree5
	binaryTree5.Left = &binaryTree8
	return &binaryTree1
}
