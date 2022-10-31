package UnitTest.DataStructureTest.sortTest.innerSortTest.innerSortImplTest;

import DataStructure.list.Nodelj;
import DataStructure.sort.innerSort.listSort.ListInsertSort;
import Common.Utils.ArrayTools;
import UnitTest.DataStructureTest.sortTest.innerSortTest.SortTest;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-11-14 22:15
 * @author—Email micromicrohard@outlook.com
 * @description 链表的插入排序
 * 链表本身的插入排序:
 * @blogURL
 */

public class ListInsertSortTest extends SortTest {

    Nodelj node = new Nodelj();
    Nodelj newRoot = new Nodelj();

    @Test
    public void TestNodeInsertSortMethod() {
        test(new ListInsertSort());
    }

    public void test(ListInsertSort listInsertSort) {
        for (String arrayKey : mapArray.keySet()) {
            arrayDataOrigin = mapArray.get(arrayKey);
            // 链表的插入排序
            newRoot = listInsertSort.sortMethod(Nodelj.Array2Nodelj(arrayDataOrigin));
            assert ArrayTools.IntArrayEquals(arrayDataOrigin, mapExpected.get(arrayKey), Nodelj.Nodelj2Array(newRoot));
        }
    }
}
