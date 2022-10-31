package DesignPattern.adapter;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date�� 2019-1-24 ����06:25:27
 * @author��Email:micromicrohard@outlook.com
 * @description:��Target��method3��4����ΪAdaptee��method1��2
 * @URL:
 */
public interface Adaptee {

    public int method1();

    public String method2();
}

class Adaptee1 implements Adaptee {


    public int method1() {
        System.out.println("Adapter1 implements Adaptee use method1");
        return 0;
    }


    public String method2() {
        System.out.println("Adapter1 implements Adaptee use method2");
        return null;
    }

}