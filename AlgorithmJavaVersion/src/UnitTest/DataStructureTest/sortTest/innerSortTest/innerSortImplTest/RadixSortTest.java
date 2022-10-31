package UnitTest.DataStructureTest.sortTest.innerSortTest.innerSortImplTest;

import DataStructure.sort.innerSort.innerSortImpl.RadixSort;
import UnitTest.DataStructureTest.sortTest.innerSortTest.SortTest;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2020-02-11 15:08
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 基数排序  测试案例
 * @blogURL
 */
public class RadixSortTest extends SortTest {

    @Test
    //@Benchmark
    //@BenchmarkMode(Mode.Throughput)
    public void TestInnerSortRealize(){
        super.TestInnerSortRealize(new RadixSort());
    }
}
