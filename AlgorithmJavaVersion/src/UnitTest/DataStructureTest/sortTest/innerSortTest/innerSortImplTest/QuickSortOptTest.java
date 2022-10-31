package UnitTest.DataStructureTest.sortTest.innerSortTest.innerSortImplTest;

import DataStructure.sort.innerSort.innerSortImpl.QuickSort_InsertOpt;
import UnitTest.DataStructureTest.sortTest.innerSortTest.SortTest;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2020-02-11 15:09
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 双向快排优化  测试案例
 * @blogURL
 */
public class QuickSortOptTest extends SortTest {

    @Test
    //@Benchmark
    //@BenchmarkMode(Mode.Throughput)
    public void TestInnerSortRealize(){
        super.TestInnerSortRealize(new QuickSort_InsertOpt());
    }
}
