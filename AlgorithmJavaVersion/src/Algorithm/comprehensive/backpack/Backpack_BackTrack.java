package Algorithm.comprehensive.backpack;

import Top100.BackTrack;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-7-19 上午11:56:26
 * @author-Email micromicrohard@outlook.com
 * @description 背包问题 回溯法
 * 回溯法、分支限界法、剪枝法
 */
public class Backpack_BackTrack implements Backpack, BackTrack {

    /**
     * Goods[] goods;     物品数组
     * int BackpackValue; 背包整体最佳价值
     * int BackpackRealValue;背包实际重量
     */
    Goods[] goods;
    int BackpackValue;
    int tempValue;
    int BackpackRealWeight;
    int BackpackWeight;


    
    public int Backpack(int[] goodsValue, int[] weight, int packageWeight) {
        if (!check(goodsValue, weight, packageWeight)) {
            return -1;
        }

        this.BackpackValue = 0;
        this.tempValue = 0;
        this.BackpackRealWeight = 0;
        this.BackpackWeight = packageWeight;
        this.goods = getGoods(goodsValue, weight);
        count(0);
        return BackpackValue;
    }

    public void count(int depth) {

        if (BackpackRealWeight > BackpackWeight) {
            return;
        }
        BackpackValue = Math.max(BackpackValue, tempValue);
        for (int i = depth; i < goods.length; i++) {
            tempValue += goods[i].prices;
            BackpackRealWeight += goods[i].weight;
            //注意此处是i+1，不是depth+1
            count(i + 1);
            tempValue -= goods[i].prices;
            BackpackRealWeight -= goods[i].weight;
        }
    }
}
