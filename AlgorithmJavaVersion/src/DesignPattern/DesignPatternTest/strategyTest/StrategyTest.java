package DesignPattern.DesignPatternTest.strategyTest;

import DesignPattern.strategy.Strategy;
import DesignPattern.strategy.StrategyMethod;
import DesignPattern.strategy.strategy01;
import DesignPattern.strategy.strategy02;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/5/17
 * @author��Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description
 */
public class StrategyTest {

    @Test
    public void tetsStrategy(){
        Strategy s1 = new strategy01();
        Strategy s2 = new strategy02();
        StrategyMethod sm1 = new StrategyMethod(s1);
        sm1.opera();
        StrategyMethod sm2 = new StrategyMethod(s2);
        sm2.opera();
    }
}
