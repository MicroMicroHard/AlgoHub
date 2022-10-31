package Algorithm.comprehensive.backpack;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/10/29
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 背包问题
 */
public interface Backpack {

    /**
     * @param goodsValue    物品的价值
     * @param goodsWeight   物品的重量
     * @param packageWeight 背包能容纳的重量
     * @return 当前背包下，能装载的最大价值
     */
    //public int Backpack(int[] goodsValue, int[] goodsWeight, int packageWeight);

    int Backpack(int[] goodsValue, int[] goodsWeight, int packageWeight);

    //背包问题的检查项
    default boolean check(int[] goodsValue, int[] weight, int packageweight) {
        if (goodsValue == null || goodsValue.length == 0 ||
                weight == null || weight.length == 0 ||
                packageweight <= 0) {
            return false;
        }
        if (goodsValue.length != weight.length) {
            return false;
        }
        return true;
    }

    default Goods[] getGoods(int[] goodsValue, int[] weight) {
        int length = goodsValue.length;
        Goods[] goods = new Goods[length];
        for (int i = 0; i < length; i++) {
            goods[i] = new Goods(goodsValue[i], weight[i], (double) goodsValue[i] / (double) weight[i]);
        }
        return goods;
    }
}
