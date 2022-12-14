package DesignPattern.single;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020-02-17 18:25
 * @Email micromicrohard@outlook.com
 * @description enmueration mode can prevent reflection attacks
 * without serialization
 * @blogURL
 */
public enum EnumSingletom implements Singletom {

    EnumSingletom;

    public String singletonname;

    public String getSingletonname() {
        return singletonname;
    }

    public void setSingletonname(String singletonname) {
        this.singletonname = singletonname;
    }
}
