package Algorithm.math;

import Top100.BitOperation;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/6
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 判断一个数是不是2的N次方
 */

public class NthPowerOfTwo implements BitOperation {

    public Boolean checkMethod(int value) {
        return (value & (value - 1)) == 0;
    }
}
