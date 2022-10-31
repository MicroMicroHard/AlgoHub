package DesignPattern.DesignPatternTest.templateTest;

import DesignPattern.template.SubTemplate;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/4/10
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description
 */
public class TemplateTest {

    SubTemplate subTemplate = new SubTemplate();

    @Test
    public void testTemplate() {
        subTemplate.template();
    }
}
