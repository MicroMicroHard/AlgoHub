package Top100;

import Algorithm.math.BitCount;
import Algorithm.math.NthPowerOfTwo;
import DataStructure.arrayRelevant.xor.FindNum_Twice_One;
import DataStructure.arrayRelevant.xor.FindNum_Twice_Two;
import DataStructure.arrayRelevant.xor.FindNum_Once_Double;
import DataStructure.arrayRelevant.xor.FindNum_Treble_One;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-9-3 下午06:59:34
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description bit操作题
 */

public interface BitOperation {

    /**
     计算bit位中1的个数 {@link BitCount}
     判断一个数是不是2的N次方 {@link NthPowerOfTwo}

     在一组数中，每个数都出现了两次，但是唯独有一个数，仅出现一次，找出这个数 {@link FindNum_Twice_One}
     在一组数中，每个数都出现了两次，但是唯独有两个数，仅出现一次，找出这个数 {@link FindNum_Twice_Two}
     在一组数中，每个数都只出现一次，但是唯独有一个数，出现了两次，找出这个数 {@link FindNum_Once_Double}
     在一组数中，每个数都只出现三次，但是唯独有一个数，仅出现一次，找出这个数 {@link FindNum_Treble_One}
     */
}
