package DesignPattern.adapter;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-1-24 ����06:25:09
 * @authorEmail micromicrohard@outlook.com
 * @description
 * @blogURL
 */
public interface Target {

    public int method3();

    public String method4();
}

class Target1 implements Target {

    
    public int method3() {
        
        System.out.println("Target1 implements Target use method3");
        return 0;
    }

    
    public String method4() {
        
        System.out.println("Target1 implements Target use method4");
        return null;
    }

}