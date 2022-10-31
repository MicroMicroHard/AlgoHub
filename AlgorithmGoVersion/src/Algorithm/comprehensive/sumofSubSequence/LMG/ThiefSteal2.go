package LMG

import "AlgorithmPractice/src/Common/Utils"

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-25 16:41
 * @author—Email micromicrohard@outlook.com
 * @description 打家劫舍2
 * 在一条直线上，有n个房屋，每个房屋中有数量不等的财宝，有一个盗 贼希望从房屋中盗取财宝，由于房屋中有报警器，
 * 如果同时从相邻的两个房屋中盗取财宝就会触发报警器。问在不触发报警器的前提下，最多可获取多少财宝？
 * 例如 [5，2，6，3，1，7]，则选择5 * 6 * 7 = 210
 * 例如 [5，2，6，3，1，-7]，则选择5 * 6 = 30
 * 例如 [5，2，-6，3，1，-7]，则选择5 * -6 * -7 = 210
 * @blogURL
 */

type ThiefSteal2 struct {
}

func (ts *ThiefSteal2) Method(values []int) int {

	if len(values) == 0 {
		return 0
	}
	if len(values) == 1 {
		return values[0]
	}
	ValueMax := make([]int, len(values))
	ValueMin := make([]int, len(values))
	ValueMax[0] = values[0]
	ValueMin[0] = values[0]
	if len(values) == 2 {
		return Utils.GetMax(values[0], values[1])
	}
	ValueMax[1] = Utils.GetMax(values[0], values[1])
	ValueMin[1] = Utils.GetMin(values[0], values[1])
	for i := 2; i < len(values); i++ {
		ValueMax[i] = Utils.GetMax(Utils.GetMax(Utils.GetMax(
			ValueMax[i-2]*values[i], ValueMax[i-1]),
			ValueMin[i-2]*values[i]),
			values[i])

		ValueMin[i] = Utils.GetMin(Utils.GetMin(Utils.GetMin(
			ValueMax[i-2]*values[i], ValueMin[i-1]),
			ValueMin[i-2]*values[i]),
			values[i])
	}
	return ValueMax[len(values)-1]
}
