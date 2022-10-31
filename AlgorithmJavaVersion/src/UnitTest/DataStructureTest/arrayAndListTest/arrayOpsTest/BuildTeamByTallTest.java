package UnitTest.DataStructureTest.arrayAndListTest.arrayOpsTest;

import DataStructure.arrayRelevant.arrayOps.BuildTeamByTall;
import Common.Utils.ArrayTools;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/7/28
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 根据身高重建队列 测试案例
 */
public class BuildTeamByTallTest {

    BuildTeamByTall instance = new BuildTeamByTall();

    @Test
    public void testsolution1() {
        int[][] answer = instance.solution1(demo01);
        assert ArrayTools.EqualsIntMatrix(answer, target01);
        answer = instance.solution1(demo02);
        assert ArrayTools.EqualsIntMatrix(answer, target02);
        answer = instance.solution1(demo03);
        assert ArrayTools.EqualsIntMatrix(answer, target03);
        answer = instance.solution1(demo04);
        assert ArrayTools.EqualsIntMatrix(answer, target04);
        answer = instance.solution1(demo05);
        assert ArrayTools.EqualsIntMatrix(answer, target05);
    }

    int[][] demo01 = {{4, 4}, {6, 1}, {7, 1}, {5, 0}, {7, 0}, {5, 2}};
    int[][] target01 = {{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}};
    int[][] demo02 = null;
    int[][] target02 = {};
    int[][] demo03 = {};
    int[][] target03 = {};
    int[][] demo04 = {{22, 2}, {9, 1}, {7, 0}, {3, 4}, {2, 1}, {11, 4}, {4, 0}, {34, 0}, {12, 0}, {72, 0}};
    int[][] target04 = {{4, 0}, {2, 1}, {7, 0}, {12, 0}, {9, 1}, {3, 4}, {34, 0}, {72, 0}, {22, 2}, {11, 4}};
    int[][] demo05 = {{9, 0}, {7, 0}, {1, 9}, {3, 0}, {2, 7}, {5, 3}, {6, 0}, {3, 4}, {6, 2}, {5, 2}};
    int[][] target05 = {{3, 0}, {6, 0}, {7, 0}, {5, 2}, {3, 4}, {5, 3}, {6, 2}, {2, 7}, {9, 0}, {1, 9}};
}
