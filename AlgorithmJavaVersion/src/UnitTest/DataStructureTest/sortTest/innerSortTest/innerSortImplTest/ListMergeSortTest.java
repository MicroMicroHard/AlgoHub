package UnitTest.DataStructureTest.sortTest.innerSortTest.innerSortImplTest;

import DataStructure.list.Nodelj;
import DataStructure.sort.innerSort.listSort.ListMergeSort;
import UnitTest.DataStructureTest.sortTest.innerSortTest.SortTest;
import Common.Utils.ArrayTools;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-14 22:15
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 链表的归并排序
 * @blogURL
 */

public class ListMergeSortTest extends SortTest {

    Nodelj newRoot = new Nodelj();
    @Test
    public void TestNodeMergeSortMethod() {
        test(new ListMergeSort());
    }

    public void test(ListMergeSort listMergeSort) {
        for (String arrayKey : mapArray.keySet()) {
            arrayDataOrigin = mapArray.get(arrayKey);
            // 链表的归并排序
            newRoot = listMergeSort.sortMethod(Nodelj.Array2Nodelj(arrayDataOrigin));
            assert ArrayTools.IntArrayEquals(arrayDataOrigin, mapExpected.get(arrayKey), Nodelj.Nodelj2Array(newRoot));
        }
    }
}
