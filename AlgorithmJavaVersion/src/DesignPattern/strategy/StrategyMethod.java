package DesignPattern.strategy;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date  2018-8-22 ����12:10:06
 * @Email micromicrohard@outlook.com
 * @description
 */
public class StrategyMethod {

    Strategy strategy;

    public StrategyMethod(Strategy strategy) {
        this.strategy = strategy;
    }

    public void opera() {
        strategy.method();
    }
}
