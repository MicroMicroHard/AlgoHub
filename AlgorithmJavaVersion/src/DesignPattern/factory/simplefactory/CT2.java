package DesignPattern.factory.simplefactory;


import DesignPattern.factory.Factory;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-3-31 ����03:59:35
 * @authorEmail micromicrohard@outlook.com
 * @description
 * @blogURL
 */
public class CT2 implements Factory {

    String s = "i am CT2 implements ClassTest";


    public void method() {
        System.out.println(s);
    }

}
