package DataStructure.arrayRelevant.preSumAndDiffArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/8
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 前缀和应用
 * 给定一个整数数组和一个整数K，找出数组中和为K的连续子数组的个数
 * 前缀和链接：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484488&idx=1&sn=848f76e86fce722e70e265d0c6f84dc3&chksm=9bd7fa40aca07356a6f16db72f5a56529044b1bdb2dcce2de4efe59e0338f0c313de682aef29&scene=21#wechat_redirect
 */

public class PreSumArrayApply extends PreSumArray {

    public int CountOfSumEqualsK(int[] array, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int count = 0;
        map.put(0, 1);//此处的0，保证当前值可以被选入，比如array[i] == k ，那么它需要的前缀和为 0 即可
        for (int j : array) {
            preSum += j;
            int wantValue = preSum - k;
            if (map.containsKey(wantValue)) {
                //count++; 不使用count++的原因是存在多个前缀和相等
                count += map.getOrDefault(wantValue, 0);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
