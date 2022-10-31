package DesignPattern.DesignPatternTest.factoryTest;


import DesignPattern.factory.simplefactory.CT1;
import DesignPattern.factory.simplefactory.SimpleFactory;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-3-31 ����03:52:46
 * @Email micromicrohard@outlook.com
 * @description
 * @URL
 */
public class FactoryTest {

    public static void main(String[] args) {

        CT1 obj = SimpleFactory.createClass();
        obj.method();
    }
}
