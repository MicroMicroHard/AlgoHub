package Top100;

import Algorithm.comprehensive.lis.LIS_Point;
import DataStructure.arrayRelevant.doublePoint.TwoSum;
import DataStructure.arrayRelevant.doublePoint.ThreeSum;
import DataStructure.arrayRelevant.doublePoint.OriginLength;
import DataStructure.arrayRelevant.doublePoint.TwoSum_Position_Repeat;
import DataStructure.list.listRealize.TheLastKImpl;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2021/12/7
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 双指针专题
 */
public interface DoublePoint {

    // interface grammar:一个类实现了两个接口，这两个接口具体同名的default函数，编译不过，因为无法区分
    // 具体见：https://blog.csdn.net/qq_22339457/article/details/52664395
    default void TypicalImply() {
        new LIS_Point();                          // 最长递增子序列 双指针
        new TwoSum();                             // 2数之和
        new TwoSum_Position_Repeat();             // 找出某 2 个数相加得 target,返回所有的 2 数之和在数组中原位置的组合
        new ThreeSum();                           // 3数之和
        new TheLastKImpl();                       // 链表的倒数第K个元素
        new OriginLength();                       // 给定一个包含重复数字的数组，返回不重复的个数
    }
}
