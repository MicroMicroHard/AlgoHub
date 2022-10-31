package Algorithm.comprehensive.lss;

import Common.Utils.UTFactory;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-7-19 Time：上午10:15:35
 * @author—Email micromicrohard@outlook.com
 * @description 最大子段和
 * LargestSumOfSubSequence by dynamic
 * 已知数组A[1..n]中存放着一些实数，有正有负，请写程序找出其最大求和子区间
 */

public class LSSOpt implements LSS {

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

    public int begin = 0; //最大字段和的起始地址
    int begin_temp = 0;   //假设的最大值
    public int end = 0;   //最大字段和的结束地址
    int sum_temp = 0;     //暂时的最大值
    int sum = 0;          //记录最大值

    //输入序列数组，输出最大子段和、起始地址、结束地址
    public int LargestSumOfSubSequenceMethod(int[] Sequence) {

        if (Sequence == null || Sequence.length == 0) {
            return 0;
        }
        sum = sum_temp = Sequence[0];
        for (int i = 1; i < Sequence.length; i++) {
            sum_temp += Sequence[i];
            if (sum_temp <= Sequence[i]) {  //新开始
                sum_temp = Sequence[i];     //sum清空
                begin_temp = i;             //假定的起始位置
            }
            //区间：[begin, end]
            if (sum < sum_temp) {
                sum = sum_temp;             //记录最大值
                begin = begin_temp;         //假定的起始地址赋值给起始地址
                end = i;                    //结束地址包括 i
            }
        }
        //System.out.println("maxValue:"+sum);
        //System.out.println("start position:"+(begin+1)+"  end position:"+(end+1));
        return sum;
    }
}
