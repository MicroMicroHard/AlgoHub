package UnitTest.DataStructureTest.sortTest.innerSortTest.innerSortImplTest;

import DataStructure.sort.innerSort.innerSortImpl.AmazingSort;
import UnitTest.DataStructureTest.sortTest.innerSortTest.SortTest;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2020-02-11 15:10
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 神奇排序  测试案例
 * @blogURL
 */
public class AmazingSortTest extends SortTest {

    @Test
    //@Benchmark
    //@BenchmarkMode(Mode.Throughput)
    public void TestInnerSortRealize() {
        super.TestInnerSortRealize(new AmazingSort());
    }
}
