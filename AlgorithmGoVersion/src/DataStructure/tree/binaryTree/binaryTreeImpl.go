package binaryTree

type BinaryTreeImpl struct {
	Left   *BinaryTreeImpl //左孩子
	Right  *BinaryTreeImpl //右孩子
	Parent *BinaryTreeImpl //父节点
	Value  int             //值
	Count  int             //层计数值
}

func (bt *BinaryTreeImpl) EqualsDouble(source, target *BinaryTreeImpl) bool {

	if source == nil {
		return target == nil
	}
	if target != nil {
		if source.Value != target.Value {
			return false
		}
		return bt.EqualsDouble(source.Left, target.Left) && bt.EqualsDouble(source.Right, target.Right)
	}
	return false
}

func (bt *BinaryTreeImpl) Equals(target *BinaryTreeImpl) bool {

	return bt.EqualsDouble(bt, target)
}

func (bt *BinaryTreeImpl) InterfaceName() string {
	return "BinaryTree"
}
