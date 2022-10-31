package slidingWindowTestData

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/1/15
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 数组的连续积小于给定值的组合
 * 求出数组中连续数的积小于给定值的组合,使用滑动窗口
 * <p>
 * 输入：{10, 5, 2, 6}，target：100
 * 输出：{
 * {10}, {10,5}, {10,5,2},
 * {5}, {5,2}, {5,2,6},
 * {2}, {2,6},
 * {6}
 * }
 */

var (
	Demo01   = []int{10, 5, 2, 6}
	Target01 = 100
	Answer01 = [][]int{
		{10}, {10, 5}, {10, 5, 2},
		{5}, {5, 2}, {5, 2, 6},
		{2}, {2, 6},
		{6},
	}

	Demo02   = []int{2, 8, 4, 6, 9, 3}
	Target02 = 64
	Answer02 = [][]int{
		{2}, {2, 8}, {2, 8, 4},
		{8}, {8, 4},
		{4}, {4, 6},
		{6}, {6, 9},
		{9}, {9, 3},
		{3},
	}

	Demo03   = []int{2, 8, 9, 3, 7, 2}
	Target03 = 72
	Answer03 = [][]int{
		{2}, {2, 8},
		{8}, {8, 9},
		{9}, {9, 3},
		{3}, {3, 7}, {3, 7, 2},
		{7}, {7, 2},
		{2},
	}
)
