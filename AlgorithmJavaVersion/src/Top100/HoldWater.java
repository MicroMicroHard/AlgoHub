package Top100;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/1
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 接雨水问题
 * 1、盛水问题
 * 给定 n 个非负整数 x1,x2,x3...，每个数代表坐标中的一个点 (i,xi)。
 * 在坐标内画 n 条竖直线，竖直线 i 的两个端点分别为(i,0)和(i,xi)。找出其中的两条线，
 * 使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 2、接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 */

public interface HoldWater {

    int sum(int[] array);

    default boolean check(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        return true;
    }
}
