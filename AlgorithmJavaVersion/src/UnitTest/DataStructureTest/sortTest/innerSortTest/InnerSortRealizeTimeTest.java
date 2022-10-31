package UnitTest.DataStructureTest.sortTest.innerSortTest;

import org.junit.Test;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/6/4
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 排序算法的性能测试
 */
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class InnerSortRealizeTimeTest {

    //@Test
    public void sortTimeTest() throws RunnerException {

        Options options = new OptionsBuilder().
                include("Sort")//此处是模糊匹配
                .warmupIterations(10)//预热2轮
                .measurementIterations(10)//实际2轮
                .forks(3)//预热2轮+实际2轮算一组，这是循环2组
                .build();
        new Runner(options).run();
    }
}
