package UnitTest.AlgorithmTest.combineTest.sumofSubSequenceTest.LSSTest;

import Algorithm.comprehensive.lss.LSS;
import Algorithm.comprehensive.lss.*;
import UnitTest.AlgorithmTest.combineTest.sumofSubSequenceTest.LargestValueTestData;
import org.junit.Test;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-25 16:39
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 最大子段和
 * @blogURL
 */
public class LSS_DynamicTest extends LargestValueTestData {

    // 存储接口IDataValidator所有实现类的对象
    private static List<LSS> dataValidators = new ArrayList<>();

    {
        // 扫描 LargestSumOfSubSequence 所在的包
        Reflections reflections = new Reflections(LSS.class.getPackage().getName());
        // 获取包 下面所有 LargestSumOfSubSequence 实现类
        Set<Class<? extends LSS>> implClass = reflections.getSubTypesOf(LSS.class);
        for (Class<? extends LSS> aClass : implClass) {
            try {
                dataValidators.add(aClass.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void TestLSS_Divide() {
        test(new LSS_Divide());
    }

    @Test
    public void TestLSS_Dynamic() {
        test(new LSS_Dynamic());
    }

    @Test
    public void TestLSSopt() {
        test(new LSSOpt());
    }

    public void test(LSS instance) {
        int answer = instance.LargestSumOfSubSequenceMethod(demo01);
        assert answer == target01_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo02);
        assert answer == target02_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo03);
        assert answer == target03_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo04);
        assert answer == target04_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo05);
        assert answer == target05_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo06);
        assert answer == target06_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo07);
        assert answer == target07_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo08);
        assert answer == target08_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo09);
        assert answer == target09_lss;

        answer = instance.LargestSumOfSubSequenceMethod(demo10);
        assert answer == target10_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo11);
        assert answer == target11_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo12);
        assert answer == target12_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo13);
        assert answer == target13_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo14);
        assert answer == target14_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo15);
        assert answer == target15_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo16);
        assert answer == target16_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo17);
        assert answer == target17_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo18);
        assert answer == target18_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo19);
        assert answer == target19_lss;


        answer = instance.LargestSumOfSubSequenceMethod(demo20);
        assert answer == target20_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo21);
        assert answer == target21_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo22);
        assert answer == target22_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo23);
        assert answer == target23_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo24);
        assert answer == target24_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo25);
        assert answer == target25_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo26);
        assert answer == target26_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo27);
        assert answer == target27_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo28);
        assert answer == target28_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo29);
        assert answer == target29_lss;

        answer = instance.LargestSumOfSubSequenceMethod(demo30);
        assert answer == target30_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo31);
        assert answer == target31_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo32);
        assert answer == target32_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo33);
        assert answer == target33_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo34);
        assert answer == target34_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo35);
        assert answer == target35_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo36);
        assert answer == target36_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo37);
        assert answer == target37_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo38);
        assert answer == target38_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo39);
        assert answer == target39_lss;

        answer = instance.LargestSumOfSubSequenceMethod(demo40);
        assert answer == target40_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo41);
        assert answer == target41_lss;
        answer = instance.LargestSumOfSubSequenceMethod(demo42);
        assert answer == target42_lss;
    }
}
