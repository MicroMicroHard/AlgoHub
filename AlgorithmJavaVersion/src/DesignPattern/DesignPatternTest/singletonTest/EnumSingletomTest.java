package DesignPattern.DesignPatternTest.singletonTest;

import DesignPattern.single.EnumSingletom;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020-02-17 18:32
 * @Email micromicrohard@outlook.com
 * @description
 * @blogURL
 */
public class EnumSingletomTest {

    @Test
    public void testEnumSingletom() {

        EnumSingletom singletom = EnumSingletom.EnumSingletom;
        singletom.setSingletonname("first");
        System.out.println(singletom.singletonname);

        EnumSingletom singletom2 = EnumSingletom.EnumSingletom;
        singletom2.setSingletonname("second");
        System.out.println(singletom2.singletonname + " , " + singletom.singletonname);

        try {
            EnumSingletom[] single = EnumSingletom.class.getEnumConstants();
            for (EnumSingletom i : single) {
                System.out.println(i.getSingletonname());
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
