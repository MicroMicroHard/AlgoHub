package Algorithm.comprehensive.backpack;

import Common.Utils.UTFactory;
import Top100.Dynamic;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-7-19 上午11:55:33
 * @author—Email micromicrohard@outlook.com
 * @description 背包问题的动态规划法
 * 1.状态转换方程
 * 2.如何找出所选物品
 */
public class Backpack_Dynamic implements Backpack, Dynamic {

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
     * int[][] bestValue; 价值矩阵
     * Goods[] goods;     物品数组
     * int BackpackValue; 背包整体最佳价值
     * int BackpackRealValue;背包实际重量
     */
    int[][] bestValue;
    Goods[] goods;
    int BackpackValue;
    int BackpackRealWeight;

    
    public int Backpack(int[] goodsValue, int[] goodsWeight, int packageWeight) {
        if (!check(goodsValue, goodsWeight, packageWeight)) {
            return -1;
        }
        goods = getGoods(goodsValue, goodsWeight);
        BackpackValue = count(goods, packageWeight);
        //print(goods, packageWeight);
        //printBackpackGoods(goods, packageWeight);
        return BackpackValue;
    }

    private int count(Goods[] goods, int packageWeight) {
        //价值矩阵，列:背包的重量，行:加入的物品
        bestValue = new int[packageWeight + 1][goods.length + 1];

        //逐层规划,外层循环表示背包重量增加
        for (int i = 1; i <= packageWeight; i++) {
            //内层循环,遍历物品
            for (int j = 1; j <= goods.length; j++) {
                //如果放入值比背包总重量还大，放弃
                if (goods[j - 1].weight > i) { // j - 1表示的是第 j 个物品
                    bestValue[i][j] = bestValue[i][j - 1];
                } else {
                    int restWeight = i - goods[j - 1].weight;//拿了当前物品的背包剩余重量
                    bestValue[i][j] = Math.max(
                            bestValue[i][j - 1],//不拿当前物品的解
                            bestValue[restWeight][j - 1] + goods[j - 1].prices//选取当前物品+当前重量减去这个物品的最优解
                    );
                }
            }
        }
        return bestValue[packageWeight][goods.length];
    }

    public void print(Goods[] goods, int packageWeight) {
        //打印矩阵值
        for (int i = 1; i <= packageWeight; i++) {
            for (int j = 1; j <= goods.length; j++) {
                //调整输出格式
                if (bestValue[i][j] < 10) {
                    System.out.print(" " + bestValue[i][j] + " ");
                } else {
                    System.out.print(bestValue[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void printBackpackGoods(Goods[] goods, int packageWeight) {
        //存放选择的物品
        int x[] = new int[goods.length];
        //找出所选物品
        int i = packageWeight;
        int j = x.length;

        while (j >= 1 && i >= 1) {
            if (bestValue[i][j] != bestValue[i][j - 1]) {
                x[j - 1] = 1;//装入第i个物品
                i -= goods[j - 1].weight;
                BackpackRealWeight += goods[j - 1].weight;
                j--;
            } else {
                x[j - 1] = 0;//不装入第i个物品
                j--;
            }
        }

        System.out.println("背包实际转载重量为：" + BackpackRealWeight);
        System.out.println("背包最大价值为：\n" + BackpackValue);
        System.out.println("背包包含物品为：");

        //输出选择的物品
        for (int y = 0; y < x.length; y++) {
            if (x[y] != 0) {
                System.out.print(y + " ");
            }
        }
    }
}
