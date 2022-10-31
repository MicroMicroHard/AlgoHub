package Algorithm.comprehensive.optimalSchedule;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/10/28
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 最佳调度问题
 * 设有n个任务由k个可并行工作的机器来完成，完成任务i需要时间为 task_SpendTime。
 * 试设计一个算法找出完成这n个任务的最佳调度，使完成全部任务的时间最早
 */
public interface OptimalSchedule {

    public int schedule(int[] taskspendTime, int machineNum);

    default boolean check(int[] taskspendTime, int machineNum) {
        if (taskspendTime == null || taskspendTime.length == 0 || machineNum <= 0) {
            return false;
        }
        return true;
    }
}
