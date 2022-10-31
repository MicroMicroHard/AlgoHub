package math

import (
	"AlgorithmPractice/src/DataStructure/list"
	"testing"
)

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/7/9 13:54
 * @author-Email micromicrohard@outlook.com
 * @description
 */

func Test_addMethod(t *testing.T) {

	params1 := &list.Nodelj{
		Key: 9,
		Next: &list.Nodelj{
			Key: 9,
			Next: &list.Nodelj{
				Key: 3,
				Next:  &list.Nodelj{
					Key: 1,
					Next:  nil,
				},
			},
		},
	}

	//1-4 -4->9 -1
	params2 := &list.Nodelj{
		Key: 4,
		Next: &list.Nodelj{
			Key: 5,
			Next: &list.Nodelj{
				Key: 6,
				Next:  nil,
			},
		},
	}

	params3 := addMethod(params1, params2)
	params3.Print()

}
