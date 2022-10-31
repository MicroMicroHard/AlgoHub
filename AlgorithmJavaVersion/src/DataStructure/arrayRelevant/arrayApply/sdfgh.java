package DataStructure.arrayRelevant.arrayApply;

import Common.Utils.UTFactory;
import DataStructure.list.Nodelj;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/18 22:14
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description
 * @blogURL
 */
public class sdfgh {

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
     * 0 1 2 3 4 5 6 7 8 9 = 10
     * 0 1 2 3 4 5 6 7
     */

    int F1;
    int G1;
    int[] garden;
    int best;
    int best_temp;

    public int plan(int F, int G) {
        this.F1 = F;
        this.G1 = G;
        garden = new int[G1];
        Arrays.fill(garden, -1);
        for (int i = 0; i < F1; i++) {
            garden[i] = i;
        }
        return best;
    }

    public void roll(int depth) {
        if (depth == F1 && check(garden)) {
            best_temp++;
            best = Math.max(best_temp, best);
        }
        for (int i = 0; i < G1; i++) {
            if (garden[i] != -1) {
                continue;
            }
            garden[i] = depth;
            roll(depth + 1);
            garden[i] = -1;
        }
    }

    public boolean check(int[] garden) {
        for (int i = 0; i < garden.length; i++) {
            if (garden[i] % G1 == i) {
                return false;
            }
        }
        return true;
    }
}
