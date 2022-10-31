package UnitTest.DataStructureTest.arrayAndListTest.arrayApplyTest;

import DataStructure.arrayRelevant.arrayApply.ArrayMulti;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/12/20
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */

public class ArrayMultiTest {

    ArrayMulti am = new ArrayMulti();

    @Test
    public void testArrayMulti() {
        int[] answer = am.calMethod(demo01);
        assert Arrays.equals(answer, target01);
        answer = am.calMethod(demo02);
        assert Arrays.equals(answer, target02);
        answer = am.calMethod(demo03);
        assert Arrays.equals(answer, target03);
        answer = am.calMethod(demo04);
        assert Arrays.equals(answer, target04);
        answer = am.calMethod(demo05);
        assert Arrays.equals(answer, target05);
    }

    public int[] demo01 = new int[]{1, 2, 3, 4, 5};
    public int[] target01 = new int[]{120, 60, 40, 30, 24};

    public int[] demo02 = new int[]{9, 16, 7, 6, 5, 4, 2, 3};//725750
    public int[] target02 = new int[]{80640, 45360, 103680, 120960, 145152, 181440, 362880, 241920};

    public int[] demo03 = new int[]{9, -16, 7, 6, 3};//-18144
    public int[] target03 = new int[]{-2016, 1134, -2592, -3024, -6048};

    public int[] demo04 = new int[]{9, -16, 7, -6, 3};//18144
    public int[] target04 = new int[]{2016, -1134, 2592, -3024, 6048};

    public int[] demo05 = new int[]{9, -16, 7, 0, -6, 3};//0---18144
    public int[] target05 = new int[]{0, 0, 0, 18144, 0, 0};
}
