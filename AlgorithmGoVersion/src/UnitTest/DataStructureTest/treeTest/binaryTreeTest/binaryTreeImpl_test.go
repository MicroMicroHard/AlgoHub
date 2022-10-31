package binaryTreeTest

import (
	"AlgorithmPractice/src/DataStructure/tree/binaryTree"
	"AlgorithmPractice/src/UnitTest/TestDate/DataStructureTestData/treeTestData/binaryTreeTestData"
	"github.com/stretchr/testify/assert"
	"testing"
)

//判断两个二叉树相等
func TestEqualsDouble(t *testing.T) {

	bt := &binaryTree.BinaryTreeImpl{}
	assert.Equal(t, bt.EqualsDouble(nil, nil), true)
	assert.Equal(t, bt.EqualsDouble(binaryTreeTestData.GetBinaryTreeDemo03(), nil), false)
	assert.Equal(t, bt.EqualsDouble(nil, binaryTreeTestData.GetBinaryTreeDemo03()), false)

	assert.Equal(t, bt.EqualsDouble(binaryTreeTestData.GetFullBinaryTreeDemo04(), binaryTreeTestData.GetFullBinaryTreeDemo04()), true)
	assert.Equal(t, bt.EqualsDouble(binaryTreeTestData.GetFullBinaryTreeDemo04(), binaryTreeTestData.GetBinaryTreeDemo04()), false)
	assert.Equal(t, bt.EqualsDouble(binaryTreeTestData.GetFullBinaryTreeDemo04(), binaryTreeTestData.GetBinaryTreeDemo05()), false)
	assert.Equal(t, bt.EqualsDouble(binaryTreeTestData.GetFullBinaryTreeDemo04(), binaryTreeTestData.GetBinaryTreeDemo06()), false)
	assert.Equal(t, bt.EqualsDouble(binaryTreeTestData.GetBinaryTreeDemo03(), binaryTreeTestData.GetBinaryTreeDemo04()), false)
	assert.Equal(t, bt.EqualsDouble(binaryTreeTestData.GetBinaryTreeDemo03(), binaryTreeTestData.GetBinaryTreeDemo03()), true)
	assert.Equal(t, bt.EqualsDouble(binaryTreeTestData.GetBinaryTreeDemo04(), binaryTreeTestData.GetBinaryTreeDemo04()), true)
	assert.Equal(t, bt.EqualsDouble(binaryTreeTestData.GetBinaryTreeDemo04(), binaryTreeTestData.GetBinaryTreeDemo05()), false)
	assert.Equal(t, bt.EqualsDouble(binaryTreeTestData.GetBinaryTreeDemo05(), binaryTreeTestData.GetBinaryTreeDemo06()), false)
	assert.Equal(t, bt.EqualsDouble(binaryTreeTestData.GetBinaryTreeDemo05(), binaryTreeTestData.GetBinaryTreeDemo05()), true)
	assert.Equal(t, bt.EqualsDouble(binaryTreeTestData.GetBinaryTreeDemo06(), binaryTreeTestData.GetBinaryTreeDemo06()), true)
}

//判断两个二叉树相等
func TestEquals(t *testing.T) {

	bt := &binaryTree.BinaryTreeImpl{}
	assert.Equal(t, bt.Equals(nil), false)

	bt = binaryTreeTestData.GetFullBinaryTreeDemo04()
	assert.Equal(t, bt.Equals(binaryTreeTestData.GetFullBinaryTreeDemo04()), true)
	assert.Equal(t, bt.Equals(binaryTreeTestData.GetBinaryTreeDemo04()), false)
	assert.Equal(t, bt.Equals(binaryTreeTestData.GetBinaryTreeDemo05()), false)
	assert.Equal(t, bt.Equals(binaryTreeTestData.GetBinaryTreeDemo06()), false)
	bt = binaryTreeTestData.GetBinaryTreeDemo03()
	assert.Equal(t, bt.Equals(binaryTreeTestData.GetBinaryTreeDemo04()), false)
	assert.Equal(t, bt.Equals(binaryTreeTestData.GetBinaryTreeDemo03()), true)
	bt = binaryTreeTestData.GetBinaryTreeDemo04()
	assert.Equal(t, bt.Equals(binaryTreeTestData.GetBinaryTreeDemo04()), true)
	assert.Equal(t, bt.Equals(binaryTreeTestData.GetBinaryTreeDemo05()), false)
	bt = binaryTreeTestData.GetBinaryTreeDemo05()
	assert.Equal(t, bt.Equals(binaryTreeTestData.GetBinaryTreeDemo06()), false)
	assert.Equal(t, bt.Equals(binaryTreeTestData.GetBinaryTreeDemo05()), true)
	bt = binaryTreeTestData.GetBinaryTreeDemo06()
	assert.Equal(t, bt.Equals(binaryTreeTestData.GetBinaryTreeDemo06()), true)
}
