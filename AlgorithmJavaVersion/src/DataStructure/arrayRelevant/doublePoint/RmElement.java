package DataStructure.arrayRelevant.doublePoint;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/7/2
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 去除数组中特殊的数字
 */
public interface RmElement {

    // 去除特殊数字后的数组，组成新的数组返回
    public int[] getHandledArr(int[] array, int... key);

    // 不改变原有数组，返回不重复的个数
    public int getHandledArrLen(int[] array, int... key);
}
