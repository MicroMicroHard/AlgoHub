package UnitTest.DataStructureTest.sortTest.innerSortTest.innerSortImplTest;

import DataStructure.sort.innerSort.innerSortImpl.HeapSort2;
import UnitTest.DataStructureTest.sortTest.innerSortTest.SortTest;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020-02-11 15:11
 * @author-Email micromicrohard@outlook.com
 * @description 堆排  测试案例
 * @blogURL
 */
public class HeapSort2Test extends SortTest {

    @Test
    //@Benchmark
    //@BenchmarkMode(Mode.Throughput)
    public void TestInnerSortRealize(){
        super.TestInnerSortRealize(new HeapSort2());
    }
}
