package Algorithm.comprehensive.lsg;

import Top100.Dynamic;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-25 16:41
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 打家劫舍
 * 在一条直线上，有n个房屋，每个房屋中有数量不等的财宝，有一个盗 贼希望从房屋中盗取财宝，由于房屋中有报警器，
 * 如果同时从相邻的两个房屋中盗取财宝就会触发报警器。问在不触发报警器的前提下，最多可获取多少财宝？
 * 例如 [5，2，6，3，1，7]，则选择5，6，7
 * @blogURL
 */
public class LSG_Dynamic implements LSG, Dynamic {

    public int LargestSumOfGap(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        int length = array.length;
        int[] bestGoodsValue = new int[length];
        bestGoodsValue[0] = array[0];
        if (length == 1) {
            return bestGoodsValue[0];
        }
        bestGoodsValue[1] = Math.max(array[0], array[1]);
        if (length == 2) {
            return bestGoodsValue[1];
        }
        for (int i = 2; i < length; i++) {
            bestGoodsValue[i] = Math.max(
                    bestGoodsValue[i - 1],            //不选择当前的物品
                    Math.max(bestGoodsValue[i - 2] + array[i], array[i])//选择当前的物品
            );
        }
        return bestGoodsValue[length - 1];
    }
}
