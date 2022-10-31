package DataStructure.arrayRelevant.arrayApply;

import Top100.Mathlj;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-12-03 20:09
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 充分利用二进制转换
 * 假设有n只水桶，猪饮水中毒后会在m分钟内死亡，你需要多少猪（x）就能在p分钟内找出 “有毒” 水桶？
 * 这n只水桶里有且仅有一只有毒的桶。
 * @blogURL
 */
public class PoolPig implements Mathlj {

    // n:bucketNum, m:aliveTime, p:givenTime
    public int needNum(int bucketNum, int aliveTime, int givenTime) {

        if (bucketNum <= 0 || aliveTime <= 0 || givenTime <= 0) {
            return 0;
        }
        if (givenTime <= aliveTime) {
            return 0;
        }
        int maxtTestNum = givenTime / aliveTime + 1;
        double logNum = Math.log(bucketNum) / Math.log(maxtTestNum);
        int needNum = (int) Math.ceil(logNum);
        return Math.max(needNum, 1);
    }
}
