package UnitTest.DataStructureTest.arrayAndListTest.arrayOpsTest;

import DataStructure.arrayRelevant.arrayOps.Retro_Snaker;

import java.util.Scanner;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/4
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 贪吃蛇 测试案例
 */
public class Retro_SnakerTest {

    //@Test
    public void test(){
        Scanner scan = new Scanner(System.in);
        String opera = scan.next();
        //贪吃蛇
        Retro_Snaker sn = new Retro_Snaker();
        sn.Retro_Snaker_opera(opera);
    }
}
