package DesignPattern.proxy;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2018-7-28 ����08:47:26
 * @Email micromicrohard@outlook.com
 * @description ����ģʽ�����壺real
 */
public class Real implements ProxyInterface {

    
    public void work() {
        System.out.println("i am real, i am doing work");
    }
}
