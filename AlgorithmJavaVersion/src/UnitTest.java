import Common.Utils.UTDataTools;
import Common.Utils.UTFactory;
import DataStructure.list.listReverse.ListReverse_PartN_impl;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/5/3 22:51
 * @author—Email micromicrohard@outlook.com
 * @description 过一遍 项目全量 测试
 * 测试数据插入:{@link BuildUTData#insert()}
 * 打印测试案例:{@link BuildUTData#PrintUTData()}
 * 获取算法测试数据:{@link BuildUTData#GetAlgorithmClass()}
 * 获取数据结构测试数据:{@link BuildUTData#GetDataStructureClass()}
 * <p>
 * 测试全量:{@link UnitTest#TestAllUT()}
 * 算法{@link UnitTest#TestAlgorithmUT()} 、
 * 数据结构{@link UnitTest#TestDataStructureUT()}
 * 单个调试:{@link UnitTest#TestFunc()}
 * 单步调试:{@link UnitTest#TestDoubleTrack()}
 * @blogURL
 */

public class UnitTest extends UTDataTools {

    @Test // 调试功能 : 用于复现错误测试案例
    public void TestFunc() throws Exception {
        UTFactory.FullTest(ListReverse_PartN_impl.class);
    }

    @Test
    public void TestDoubleTrack() throws Exception {
        //String input = BuildUTData.concatMultiParams("-000123.89", "-000123.89");
        String input = "{1, 2, 3, 4, 5, 6, 7, 8, 7, 6, 5, 4, 3, 2, 1}  ############  2";
        String output = "{2,1,4,3,6,5,8,7,6,7,4,5,2,3,1}";
        UTFactory.DebugTest(ListReverse_PartN_impl.class, input, output);
    }

    @Test // 全量回归测试
    public void TestAllUT() throws Exception {
        Class<?>[] a = BuildUTData.GetAlgorithmClass();
        Class<?>[] b = BuildUTData.GetDataStructureClass();
        Class<?>[] c = new Class[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        if (c.length - b.length >= 0) System.arraycopy(b, 0, c, a.length, b.length);
        UTFactory.FullTestAll(c);
    }

    @Test
    public void TestAlgorithmUT() throws Exception {
        UTFactory.FullTestAll(BuildUTData.GetAlgorithmClass());
        UTFactory.FullTestAllThreadPool(BuildUTData.GetDataStructureClass());
    }

    @Test
    public void TestDataStructureUT() throws Exception {
        UTFactory.FullTestAll(BuildUTData.GetDataStructureClass());
    }
}
