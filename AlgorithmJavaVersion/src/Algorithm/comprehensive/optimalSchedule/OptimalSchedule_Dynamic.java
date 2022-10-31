package Algorithm.comprehensive.optimalSchedule;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-12-06 22:05
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 最佳调度问题 （动态规划）
 * 设有n个任务由k个可并行工作的机器来完成，完成任务i需要时间为 taskSpendTime。
 * 试设计一个算法找出完成这n个任务的最佳调度，使完成全部任务的时间最早
 */

public class OptimalSchedule_Dynamic implements OptimalSchedule {

    //最优解
    int bestTime;
    //机器花费的时间序列、任务数量
    int[] MachineTask_Schedule;
    int machineNum;
    int[] taskSpendTime;
    int taskNum;

    int[][] Machine_Task;

    public int schedule(int[] taskSpendTime, int machineNum) {
        //检查
        if (!check(taskSpendTime, machineNum)) {
            return -1;
        }
        Machine_Task = new int[machineNum + 1][taskSpendTime.length + 1];
        //init
        for (int i = 0; i < machineNum + 1; i++) {
            Machine_Task[i][0] = 0;
        }
        for (int i = 0; i < taskSpendTime.length + 1; i++) {
            Machine_Task[0][i] = 0;
        }
        //do
        for (int i = 1; i < machineNum + 1; i++) {
            for (int j = 1; j < taskSpendTime.length + 1; j++) {

            }
        }
        return 1;


    }
}
