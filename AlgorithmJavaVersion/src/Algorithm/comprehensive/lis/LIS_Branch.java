package Algorithm.comprehensive.lis;

import Common.Utils.ArrayTools;
import Common.Utils.UTFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/6/7
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 最长递增子序列
 * 分支限界法
 */
public class LIS_Branch implements LIS {

    //用于存放数据
    public List<Integer> list_temp;
    public List<Integer> list_best;
    int length;
    //int count_temp;
    int count_best;
    int[] StringArray;

    
    public int Method(String sequence) {
        if (!check(sequence)) {
            return 0;
        }
        length = sequence.length();
        count_best = 0;
        StringArray = ArrayTools.Sequence2IntArray(sequence);
        //剩下的待遍历距离小于当前的最优解，就没有必要再继续下去了。
        for (int i = 1; count_best <= length - i; i++) {
            list_temp = new ArrayList<>();
            list_temp.add(StringArray[i - 1]);
            //count_temp = 1;
            count(i);
        }
        return count_best;
    }

    public void count(int depth) {
        //剪枝条件：当前temp的值加上剩下待遍历的距离，小于等于最优值的时候，就没有必要再继续下去了。
        // (length - depth)：剩余路径
        // count_temp ：当前的已选路径数值
        if ((length - depth) + list_temp.size() <= count_best) {
            return;
        }
        if (list_temp.size() > count_best) {//更新最优解，并继续下去
            list_best = new ArrayList<>(list_temp);
            count_best = list_temp.size();
        }
        //达到终点，停止递归
        if (depth == length - 1) {
            return;
        }
        //分支递归
        for (int i = depth; i < length; i++) {
            if (list_temp.get(list_temp.size() - 1) < StringArray[i]) {
                list_temp.add(StringArray[i]);
                count(i + 1);
                list_temp.remove(list_temp.size() - 1);
            }
        }
    }

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误测试案例
    public void TestDoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }
}