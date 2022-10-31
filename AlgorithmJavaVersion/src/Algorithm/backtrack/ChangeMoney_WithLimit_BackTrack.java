package Algorithm.backtrack;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-25 16:42
 * @author—Email micromicrohard@outlook.com
 * @description 换零钱 加上限制数组
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 target。
 * 如果零钱数组加上数量限制数组 limit，即每个零钱有一个限定使用的最大值，那么是否还能凑出target
 * 如果没有任何一种硬币组合能组成总金额，返回 false。
 * 示例 1:
 * 输入: coins = [1, 2, 5], limit = [2, 2, 2], target = 17
 * 输出: false
 * <p>
 * 示例 2:
 * 输入: coins = [1, 2, 5], limit = [2, 2, 2], target = 17
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: coins = [1, 2, 5], limit = [3, 2, 0], target = 6
 * 输出: true
 */

public class ChangeMoney_WithLimit_BackTrack {

    int sumTemp;

    public boolean GetTargetValue(int[] array, int[] limit, int target) {
        if (array == null || array.length == 0 || array.length != limit.length) {
            return false;
        }
        sumTemp = 0;
        boolean answer = roll(0, array, limit, target);
        return answer;
    }

    private boolean roll(int depth, int[] array, int[] limit, int target) {
        if (sumTemp == target) {
            return true;
        }
        if (sumTemp > target || depth == array.length) {
            return false;
        }
        for (int i = 0; i <= limit[depth]; i++) {
            sumTemp += array[depth] * i;
            boolean flag = roll(depth + 1, array, limit, target);
            if (flag) {
                return flag;
            }
            sumTemp -= array[depth] * i;
        }
        return false;
    }
}
