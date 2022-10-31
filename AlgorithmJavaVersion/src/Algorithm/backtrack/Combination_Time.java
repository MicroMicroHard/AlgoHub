package Algorithm.backtrack;

import Top100.BackTrack;

import java.util.*;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-8-23 上午09:56:39
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 时间的全排列
 * Given four digits, count how many valid times can be displayed on a digital clock (in 24-hour format) using those digits.
 * The earliest time is 00:00 and the latest time is 23:59.
 */

public class Combination_Time implements BackTrack {

    int correctNum = 0;
    String MaxTime = "";

    // 获取排列中正确的24时制的时间个数
    public int GetCorrectTimeCount(int[] array) {
        //int[] nums = new int[]{A, B, C, D};
        correctNum = 0;
        roll(0, array);
        return correctNum;
    }

    // 获取排列中最大的那个时间
    public String GetCorrectMaxTime(int[] array) {
        //int[] nums = new int[]{A, B, C, D};
        MaxTime = "";
        roll(0, array);
        return MaxTime;
    }

    public void roll(int depth, int[] nums) {

        /* 错误剪枝条件：
           虽然 hour的十位不能大于2，minute的十位不能大于6
           但是 此处返回会影响后续正确交换的出现，导致数据缺失
         */
        /*if ((depth == 0 && nums[0] > 2) || (depth == 2 && nums[2] > 6)) {
            return;
        }*/

        if (depth == nums.length && check(nums)) {
            correctNum++;
            MaxTime = countMaxTime(nums);
            return;
        }
        Map existMap = new HashMap();
        for (int i = depth; i < nums.length; i++) {
            if (existMap.containsKey(nums[i])) {
                continue;
            }
            existMap.put(nums[i], true);

            swap(nums, i, depth);
            roll(depth + 1, nums);
            swap(nums, i, depth);
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public boolean check(int[] nums) {
        if (nums.length != 4) {
            System.out.println("error input");
            return false;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(nums[0]).append(nums[1]);
        int hour = Integer.parseInt(sb.toString());
        if (hour < 0 || hour > 23) {
            return false;
        }
        sb = new StringBuffer();
        sb.append(nums[2]).append(nums[3]);
        int minute = Integer.parseInt(sb.toString());
        if (minute < 0 || minute > 59) {
            return false;
        }
        System.out.println(hour + ":" + minute);
        return true;
    }

    public String countMaxTime(int[] nums) {
        if (nums.length != 4) {
            System.out.println("error input");
            return MaxTime;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(nums[0]).append(nums[1]);
        int hour = Integer.parseInt(sb.toString());
        if (hour < 0 || hour > 23) {
            return MaxTime;
        }
        sb = new StringBuffer();
        sb.append(nums[2]).append(nums[3]);
        int minute = Integer.parseInt(sb.toString());
        if (MaxTime.equals("")) {
            return buildTime(hour, minute);
        }
        String[] MaxTimeArray = MaxTime.split(":");
        if (Integer.parseInt(MaxTimeArray[0]) > hour) {
            return MaxTime;
        }
        if (Integer.parseInt(MaxTimeArray[0]) == hour && Integer.parseInt(MaxTimeArray[1]) > minute) {
            return MaxTime;
        }
        return buildTime(hour, minute);
    }

    public String buildTime(int hour, int minute) {
        if (minute == 0) {
            return hour == 0 ? "0:00" : hour + ":00";
        }
        return hour + ":" + minute;
    }
}
