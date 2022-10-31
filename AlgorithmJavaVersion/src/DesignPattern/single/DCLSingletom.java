package DesignPattern.single;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020-02-17 19:02
 * @Email micromicrohard@outlook.com
 * @description
 * @blogURL
 */
public class DCLSingletom {
    //禁止指令重排
    private static volatile DCLSingletom dclSingletom = null;

    private DCLSingletom() {
    }

    //Experiments show that the double locks is faster
    public static DCLSingletom getdclSingletom() {
        if (dclSingletom == null) {
            synchronized (LazySingle.class) {
                if (dclSingletom == null) {
                    dclSingletom = new DCLSingletom();
                }
            }
        }
        return dclSingletom;
    }
}