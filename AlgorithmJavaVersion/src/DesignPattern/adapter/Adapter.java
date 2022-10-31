package DesignPattern.adapter;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-1-24 06:25:40
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description
 * @blogURL
 */
public class Adapter implements Adaptee {

    Target t;

    public Adapter(Target target) {
        this.t = target;
    }

    
    public int method1() {
        System.out.print("Adapter method1 plus:");
        t.method3();
        return 0;
    }

    
    public String method2() {
        System.out.print("Adapter method2 plus:");
        t.method4();
        return null;
    }

    public static void main(String[] args) {
        Adaptee1 a = new Adaptee1();
        a.method1();
        a.method2();
        Target1 t = new Target1();
        Adapter at = new Adapter(t);
        at.method1();
        at.method2();
    }
}
