package Algorithm.math.game;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/8/4
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class BIgLottoTest {

    BigLotto bi = new BigLotto();

    @Test
    public void testlotto() {
        bi.congratulations(GetLottoMap(), target, false);
        //bi.congratulations(GetLottoMap(), target, true);
        //bi.congratulations(source01, Data0805_0810);
        //bi.congratulations(source02, Data0805_0810);
        //bi.congratulations(source03, Data0805_0810);
    }


    public Map<String, int[]> GetLottoMap() {
        Map<String, int[]> lottoMap = new HashMap<>();

        lottoMap.put("10-10 周一", new int[]{17, 19, 20, 23, 27, 3, 8});
        lottoMap.put("10-8 周六", new int[]{11, 21, 24, 27, 28, 5, 10});
        lottoMap.put("10-5 周三", new int[]{13, 15, 22, 31, 33, 5, 12});
        lottoMap.put("9-28 周三", new int[]{4, 11, 18, 20, 26, 6, 12});
        lottoMap.put("9-26 周一", new int[]{6, 12, 16, 19, 31, 6, 10});
        lottoMap.put("9-24 周六", new int[]{2, 13, 16, 18, 23, 3, 6});
        lottoMap.put("9-21 周三", new int[]{5, 9, 24, 29, 35, 5, 12});
        lottoMap.put("9-19 周一", new int[]{4, 7, 13, 26, 28, 7, 11});
        lottoMap.put("9-17 周六", new int[]{7, 9, 19, 28, 29, 8, 10});
        return lottoMap;
    }


    public Map<String, int[]> GetLottoMap1() {
        Map<String, int[]> lottoMap = new HashMap<>();
        lottoMap.put("9.14 周三", new int[]{16, 17, 21, 28, 32, 4, 7});
        lottoMap.put("9.12 周一", new int[]{1, 8, 9, 21, 22, 1, 4});
        lottoMap.put("9.10 周六", new int[]{3, 5, 13, 19, 25, 2, 5});
        lottoMap.put("9.07 周三", new int[]{8, 12, 16, 21, 32, 1, 12});
        lottoMap.put("9.05 周一", new int[]{1, 5, 14, 20, 30, 2, 4});
        lottoMap.put("9.03 周六", new int[]{2, 4, 6, 7, 8, 3, 6});
        lottoMap.put("8.31 周三", new int[]{10, 19, 20, 23, 31, 3, 7});
        lottoMap.put("8.29 周一", new int[]{7, 18, 25, 27, 33, 4, 5});
        lottoMap.put("8.27 周六", new int[]{1, 3, 6, 11, 13, 3, 11});
        lottoMap.put("8.24 周三", new int[]{5, 13, 22, 28, 29, 5, 11});
        lottoMap.put("8.22 周一", new int[]{16, 19, 24, 27, 33, 1, 6});
        return lottoMap;
    }

    int[][] target = {
            {11, 12, 19, 21, 33, 4, 9},
            {25, 26, 27, 30, 31, 4, 10},
            {9, 25, 32, 33, 35, 7, 11},
            {11, 19, 22, 27, 29, 6, 10},
            {4, 5, 12, 22, 28, 1, 7},
    };

    String[] Data0805_0810 = {
            "16 19 24 27 33 01 06",//8.22 周一
            "05 13 22 28 29 05 11",//8.24 周三
            "01 03 06 11 13 03 11",//8.27 周六
            "07 18 25 27 33 04 05",//8.29 周一
            "10 19 20 23 31 03 07",//8.31 周三
            "02 04 06 07 08 03 06",//9.03 周六
    };
}