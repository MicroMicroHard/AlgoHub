package DataStructure.arrayRelevant.arrayApply;

import Common.Utils.UTFactory;
import DataStructure.list.Nodelj;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/18 20:49
 * @author-Email micromicrohard@outlook.com
 * @description 座位的最大利用率
 * 一列具有m个座位的火车，从起点到终点共停靠n个站点，站点编号从0到n-1发车前有x名乘客预定了座位，
 * 因为预定数量可能超出座位数，为了保证效率最大化，请计算如何分配才能是座位利用率最大，并输出最大的座位利用数。
 * 说明:
 * 座位利用数定义为每个座位被使用的站数。
 * 例如有两个座位，第一个座位从第0到10站有人坐(表示从0站上车，10站下车，第10站不占座，所以利用率是10-0=10)，
 * 第二个座位从第1到9站有人坐则座位利用率为(10-0)+(9-1)=18
 * 乘客在某站下车后，其他乘客从这一站就可以开始使用这个座位;无需考虑乘客需要更换座位的问题，
 * 保证任意时刻列车上乘客数量不超过m即可
 * @blogURL
 */

public class MostAvailabilitySeat {

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
     * @param seatNum          车位数量
     * @param stationNum       停靠站点
     * @param passengerJourney 乘客路途
     * @return 座位的最大利用率
     */
    int[][] passengerJourney;
    int[] statistics;
    int bestNum;
    int bestNum_temp;

    public int Method(int seatNum, int stationNum, int[][] passengerJourney) {
        if (seatNum <= 0 || stationNum <= 0 || passengerJourney == null || passengerJourney.length == 0) {
            return -1;
        }
        // init statistics
        statistics = new int[seatNum];
        Arrays.fill(statistics, stationNum);
        this.passengerJourney = passengerJourney;
        bestNum = 0;
        roll(0);
        return bestNum;
    }

    public void roll(int depth) {
        /**
         *                 [1,6]
         *     [3,7]       [4,7]  [1,10]
         * [4,7][1,10]
         * [1,10]
         */
        for (int i = depth; i < this.passengerJourney.length; i++) {
            // opera: :还原：1,   分配: -1
            int[] pa = this.passengerJourney[i];
            if (!seatOpera(pa[0], pa[1], -1)) {
                continue;
            }
            int seatNumCur = pa[1] - pa[0];
            //seatOpera(pa[0], pa[1], -1);
            bestNum_temp += seatNumCur;
            if (bestNum_temp > bestNum) {
                bestNum = bestNum_temp;
            }
            roll(depth + 1);
            seatOpera(pa[0], pa[1], 1);
            bestNum_temp -= seatNumCur;
        }
    }

    // opera: :还原：1,   分配: -1
    public boolean seatOpera(int begin, int end, int opera) {
        // check
        for (int i = begin; i < end; i++) {
            if (statistics[i] + opera < 0) {
                return false;
            }
        }
        // exec
        for (int i = begin; i < end; i++) {
            statistics[i] += opera;
        }
        return true;
    }
}
