package DesignPattern.strategy.strategyPractice.ComProcess;

import DesignPattern.strategy.strategyPractice.Process;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/8/21
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class ToutiaoProcess implements Process {
    
    public void deal() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("it's Toutiao's Process ");
    }
}
