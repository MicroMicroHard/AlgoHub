package DataStructure.arrayRelevant.arrayApply;

import Top100.HoldWater;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/7/1
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 *
 * 解析地址：https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
 */
public class HoldWater2 implements HoldWater {

    public int sum(int[] array) {
        if (!check(array)) {
            return 0;
        }
        int maxValue = 0;
        //左右指针
        int leftpoint = 0;
        int rightpoint = array.length - 1;
        //
        int leftMax = array[leftpoint];//因为高度不为负数，所以可以设置为最低 0
        int rightMax = array[rightpoint];

        while (leftpoint < rightpoint) {
            if (array[leftpoint] < array[rightpoint]) {
                if (leftMax < array[leftpoint]) {
                    leftMax = array[leftpoint];
                } else {
                    maxValue += leftMax - array[leftpoint];
                }
                leftpoint++;
            } else {
                if (rightMax < array[rightpoint]) {
                    rightMax = array[rightpoint];
                } else {
                    maxValue += rightMax - array[rightpoint];
                }
                rightpoint--;
            }
        }
        return maxValue;
    }
}
