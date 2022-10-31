package Algorithm.comprehensive.optimalSchedule;

import Top100.BackTrack;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-12-06 22:05
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 最佳调度问题 （分支限界、剪枝法、回溯法）
 * 设有n个任务由k个可并行工作的机器来完成，完成任务i需要时间为 task_SpendTime。
 * 试设计一个算法找出完成这n个任务的最佳调度，使完成全部任务的时间最早
 */

//注释掉的部分，是用于记录 任务-机器 对应表
public class OptimalSchedule_BackTrack implements OptimalSchedule, BackTrack {

    int bestTime;//最优解
    int[] MachineHoldTotalTaskTime; //机器对应的任务序列总时间，数组中的值是：这台机器完成分配给 该机器的所有任务 需要的总时间
    int machineNum;
    int[] taskSpendTime;
    int taskNum;
    /*//每个任务分配给的机器型号
    int[] tasktoMachine_temp;
    int[] tasktoMachine_best;*/

    public int schedule(int[] taskSpendTime, int machineNum) {

        //检查
        if (!check(taskSpendTime, machineNum)) {
            return -1;
        }
        bestTime = Integer.MAX_VALUE;
        taskNum = taskSpendTime.length;
        this.machineNum = machineNum;
        this.taskSpendTime = taskSpendTime;
        this.MachineHoldTotalTaskTime = new int[machineNum];
       /* this.tasktoMachine_temp = new int[taskNum];
        this.tasktoMachine_best = new int[taskNum];*/
        arrange(0);
        return bestTime;
    }

    public void arrange(int taskDepth) {
        // 退出条件
        if (taskDepth == taskNum) {
            //找出所有机器的最大耗时
            int taskMaxSpendTime = 0;
            for (int i = 0; i < machineNum; i++) {
                taskMaxSpendTime = Math.max(taskMaxSpendTime, MachineHoldTotalTaskTime[i]);
            }
            //刷新 任务-机器 对应表
            if (bestTime > taskMaxSpendTime) {
                bestTime = taskMaxSpendTime;
                /*for (int i = 0; i < taskNum; i++) {
                    tasktoMachine_best[i] = tasktoMachine_temp[i];
                }*/
            }
            return;
        }
        for (int i = 0; i < machineNum; i++) {
            //剪枝,相对没有if的语句，效率提升一个数量级
            if (MachineHoldTotalTaskTime[i] + taskSpendTime[taskDepth] < bestTime) {
                MachineHoldTotalTaskTime[i] += taskSpendTime[taskDepth];
                /*tasktoMachine_temp[taskDepth] = i;*/
                arrange(taskDepth + 1);
                MachineHoldTotalTaskTime[i] -= taskSpendTime[taskDepth];
            }
        }
    }
}
