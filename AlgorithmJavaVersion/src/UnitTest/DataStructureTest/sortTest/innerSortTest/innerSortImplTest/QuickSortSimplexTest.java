package UnitTest.DataStructureTest.sortTest.innerSortTest.innerSortImplTest;

import DataStructure.sort.innerSort.innerSortImpl.QuickSort_Simplex;
import UnitTest.DataStructureTest.sortTest.innerSortTest.SortTest;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2020-02-11 15:09
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 单向快排  测试案例
 * @blogURL
 */
public class QuickSortSimplexTest extends SortTest {

    @Test
    //@Benchmark
    //@BenchmarkMode(Mode.Throughput)
    public void TestInnerSortRealize(){
        super.TestInnerSortRealize(new QuickSort_Simplex());
    }
}
