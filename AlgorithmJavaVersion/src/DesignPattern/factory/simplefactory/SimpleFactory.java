package DesignPattern.factory.simplefactory;


/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-3-31 ����03:51:33
 * @authorEmail micromicrohard@outlook.com
 * @description
 * @blogURL
 */
public class SimpleFactory {

    public static CT1 createClass() {

        System.out.print("SimpleFactory:");
        return new CT1();
    }
}


