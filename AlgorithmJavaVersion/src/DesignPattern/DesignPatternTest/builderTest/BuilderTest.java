package DesignPattern.DesignPatternTest.builderTest;

import DesignPattern.builder.Student;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/10/21
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 构造器设计模式 测试案例
 */
public class BuilderTest {

    @Test
    public void testuuu(){
        Student s = new Student.Builder()
                .setage(12)
                .setname("zhangsan")
                .setaaddress("上海市")
                .setclassname("三班")
                .build();
        System.out.println(s.tostring());
    }
}
