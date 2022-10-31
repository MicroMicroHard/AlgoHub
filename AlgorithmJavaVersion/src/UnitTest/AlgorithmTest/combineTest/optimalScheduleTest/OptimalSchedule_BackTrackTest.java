package UnitTest.AlgorithmTest.combineTest.optimalScheduleTest;

import Algorithm.comprehensive.optimalSchedule.OptimalSchedule;
import Algorithm.comprehensive.optimalSchedule.OptimalSchedule_BackTrack;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/11/20
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 测试 最佳调度问题
 */
public class OptimalSchedule_BackTrackTest extends OptimalScheduleTest{

    OptimalSchedule optimalSchedule = new OptimalSchedule_BackTrack();

    //测试 最佳调度问题 （分支限界、剪枝法、回溯法）
    @Test
    public void optimalSchedule_BacktrackTest(){

        super.optimalSchedule_Test(optimalSchedule);

        int time = optimalSchedule.schedule(Demo03,k1);
        assert time == 11;
        time = optimalSchedule.schedule(Demo03,k4);
        assert time == 8;
        time = optimalSchedule.schedule(Demo03,k5);
        assert time == 8;
    }
}
