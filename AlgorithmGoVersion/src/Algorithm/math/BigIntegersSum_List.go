package math

import "AlgorithmPractice/src/DataStructure/list"

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/7/9 13:41
 * @author-Email micromicrohard@outlook.com
 * @description
 */
type BigIntegersSum_List struct {
}

func addMethod(params1, params2 *list.Nodelj) *list.Nodelj {

	if params1 == nil || params2 == nil {
		return nil
	}
	carry := add(params1, params2)
	if carry == 0 {
		return params1
	}
	node := &list.Nodelj{
		Key: carry,
		Next:  params1,
	}
	return node
}

func add(params1, params2 *list.Nodelj) int {

	carry := add(params1.Next, params2.Next)
	sum := params1.Key + params2.Key + carry
	carry = sum / 10
	params1.Key = sum % 10
	return carry
}
