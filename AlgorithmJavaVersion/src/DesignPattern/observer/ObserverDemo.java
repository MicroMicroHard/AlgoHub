package DesignPattern.observer;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/5/17
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description
 */
public class ObserverDemo {

    String name;

    public ObserverDemo(String name) {
        this.name = name;
    }

    public void lister() {
        System.out.println(name + " --> 观察到异常，并采取行动");
    }
}
