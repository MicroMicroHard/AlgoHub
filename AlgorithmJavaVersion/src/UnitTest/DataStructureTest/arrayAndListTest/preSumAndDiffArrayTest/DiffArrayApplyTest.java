package UnitTest.DataStructureTest.arrayAndListTest.preSumAndDiffArrayTest;

import DataStructure.arrayRelevant.preSumAndDiffArray.DiffArrayApply;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/9/8
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 差分数组/及应用
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。我们这儿有一份航班预订表，
 * 表中第 i 条预订记录 bookings[i] = [i, j, k] 意味着我们在从 i 到 j 的每个航班上预订了 k 个座位。
 * 请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。
 * 示例：
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 */

public class DiffArrayApplyTest extends DiffArrayTest {

    DiffArrayApply diffArray = new DiffArrayApply();

    @Test
    public void testdiffINCArray() {
        int[] answer = diffArray.getDiffOrigin(diffArray.diffINCArray(demo01, opear01));
        assert Arrays.equals(answer, target01);
        answer = diffArray.getDiffOrigin(diffArray.diffINCArray(demo02, opear02));
        assert Arrays.equals(answer, target02);
        answer = diffArray.getDiffOrigin(diffArray.diffINCArray(demo03, opear03));
        assert Arrays.equals(answer, target03);
        answer = diffArray.getDiffOrigin(diffArray.diffINCArray(demo04, opear04));
        assert Arrays.equals(answer, target04);
    }
}
