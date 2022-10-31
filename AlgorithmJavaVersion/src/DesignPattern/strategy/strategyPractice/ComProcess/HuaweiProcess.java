package DesignPattern.strategy.strategyPractice.ComProcess;

import DesignPattern.strategy.strategyPractice.Process;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/8/21
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description
 */
public class HuaweiProcess implements Process {
    
    public void deal() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("it's Tecent's Process ");
    }
}
