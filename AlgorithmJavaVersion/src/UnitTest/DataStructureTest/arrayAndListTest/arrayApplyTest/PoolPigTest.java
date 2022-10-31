package UnitTest.DataStructureTest.arrayAndListTest.arrayApplyTest;

import DataStructure.arrayRelevant.arrayApply.PoolPig;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-12-03 20:09
 * @author-Email  ljfirst@mail.ustc.edu.cn
 * @description 充分利用二进制转换
 * 假设有n只水桶，猪饮水中毒后会在m分钟内死亡，你需要多少猪（x）就能在p分钟内找出 “有毒” 水桶？
 * 这n只水桶里有且仅有一只有毒的桶。
 * @blogURL
 */
public class PoolPigTest {

    PoolPig poolpig = new PoolPig();
    @Test
    public void testneedNum(){
        int needNum = poolpig.needNum(bucketNum01, alivetime01, givenTime01);
        assert needNum == 1;
        needNum = poolpig.needNum(bucketNum02, alivetime02, givenTime02);
        assert needNum == 2;
        needNum = poolpig.needNum(bucketNum03, alivetime03, givenTime03);
        assert needNum == 5;

        needNum = poolpig.needNum(bucketNum04, alivetime04, givenTime04);
        assert needNum == 0;
        needNum = poolpig.needNum(bucketNum05, alivetime05, givenTime05);
        assert needNum == 0;
        needNum = poolpig.needNum(bucketNum06, alivetime06, givenTime06);
        assert needNum == 10;
        needNum = poolpig.needNum(bucketNum07, alivetime07, givenTime07);
        assert needNum == 1;
        needNum = poolpig.needNum(bucketNum08, alivetime08, givenTime08);
        assert needNum == 1;
    }

    int bucketNum01 = 5;
    int alivetime01 = 15;
    int givenTime01 = 60;

    int bucketNum02 = 25;
    int alivetime02 = 15;
    int givenTime02 = 60;

    int bucketNum03 = 1000;
    int alivetime03 = 15;
    int givenTime03 = 60;

    
    int bucketNum04 = 1000;
    int alivetime04 = 60;
    int givenTime04 = 10;

    int bucketNum05 = 1000;
    int alivetime05 = -1;
    int givenTime05 = 10;

    
    int bucketNum06 = 1000;
    int alivetime06 = 11;
    int givenTime06 = 20;

    int bucketNum07 = 1;
    int alivetime07 = 11;
    int givenTime07 = 20;

    int bucketNum08 = 2;
    int alivetime08 = 1;
    int givenTime08 = 20;
}
