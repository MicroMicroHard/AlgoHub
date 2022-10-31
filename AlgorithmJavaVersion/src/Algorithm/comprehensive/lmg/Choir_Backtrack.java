package Algorithm.comprehensive.lmg;

import Common.Utils.UTFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020-02-12 09:37
 * @author—Email micromicrohard@outlook.com
 * @description 合唱团 回溯法
 * * 有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，
 * *要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
 * @blogURL
 */
public class Choir_Backtrack implements Choir {

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

    //选择的数量
    int choseNum;
    int intervald;

    //定义乘积最优解
    int bestValue;
    int tempValue;

    //记录选择的学生编号
    List<Integer> list_temp;
    List<Integer> list_best;

    
    public int getMaxValue(int[] array, int choseNum, int intervald) {
        return check(array, choseNum, intervald) ? countMaxValue(array, choseNum, intervald) : -1;
    }

    public int countMaxValue(int[] array, int choseNum, int intervald) {
        // initial
        this.choseNum = choseNum;
        this.intervald = intervald;
        // 需要每次刷新
        this.bestValue = 1;
        this.list_best = new ArrayList<>();
        /*
         第一个可选择的人所在的位置，必须小于需要选择的人数[array.length - choseNum],也必须小于间隔数[array.length - intervald]，
         否则要么凑不够需要选择的人数[choseNum]，要么满足不了间隔数[intervald]要求
         */
        int last_choose_position = Math.max(choseNum, intervald);

        for (int i = 0; i < array.length - last_choose_position; i++) {
            this.tempValue = 1;
            this.list_temp = new ArrayList<>();
            roll(0, i, array);
        }
        return bestValue;
    }

    //回溯函数
    private void roll(int depth, int start, int[] array) {
        if (depth == choseNum) {
            if (tempValue > bestValue) {
                bestValue = tempValue;
                list_best = new ArrayList<>(list_temp);
            }
            return;
        }

        //因为此处是顺序选人，所有i不用从 0 开始，而是从递归的深度（遍历到当前的这个人）
        int bound = Math.min(start + intervald, array.length);
        for (int i = start; i < bound; i++) {
            //异常情况，特殊处理
            if (array[i] == 0) {
                continue;
            }

            tempValue *= array[i];
            list_temp.add(i);
            roll(depth + 1, i + 1, array);
            tempValue /= array[i];
            list_temp.remove(list_temp.size() - 1);
        }
    }
}
