package Algorithm.comprehensive.backpack;

import Common.Utils.UTFactory;
import DataStructure.sort.innerSort.innerSortImpl.InsertSort;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-7-19 上午11:56:07
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 贪心算法
 */
public class Backpack_Greedy implements Backpack {

    @Test // 验证功能：从数据库获取测试数据，用于单元测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误的测试案例
    public void DoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }
    /**
     * Goods[] goods;     物品数组
     * int BackpackValue; 背包整体最佳价值
     * int BackpackRealValue;背包实际重量
     */
    Goods[] goods;
    int BackpackValue;
    int BackpackRealWeight;


    
    public int Backpack(int[] goodsValue, int[] weight, int packageweight) {
        if (!check(goodsValue, weight, packageweight)) {
            return -1;
        }
        BackpackValue = 0;
        BackpackRealWeight = packageweight;
        goods = getGoods(goodsValue, weight);
        InsertSort.sort4Good(goods);
        for (int i = goodsValue.length - 1; i >= 0; i--) {
            if (packageweight >= goods[i].weight) {
                BackpackValue += goods[i].prices;
                packageweight -= goods[i].weight;
            }
        }
        BackpackRealWeight = BackpackRealWeight - packageweight;
        return BackpackValue;
    }

}
