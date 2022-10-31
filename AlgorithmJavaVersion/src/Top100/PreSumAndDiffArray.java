package Top100;


import DataStructure.arrayRelevant.preSumAndDiffArray.DiffArray;
import DataStructure.arrayRelevant.preSumAndDiffArray.DiffArrayApply;
import DataStructure.arrayRelevant.preSumAndDiffArray.PreSumArray;
import DataStructure.arrayRelevant.preSumAndDiffArray.PreSumArrayApply;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/9/8
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 前缀和、差分数组
 * 前缀和链接：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484488&idx=1&sn=848f76e86fce722e70e265d0c6f84dc3&chksm=9bd7fa40aca07356a6f16db72f5a56529044b1bdb2dcce2de4efe59e0338f0c313de682aef29&scene=21#wechat_redirect
 * 差分数组链接：https://mp.weixin.qq.com/s/9L6lz0XDZ9gi-d_iPrSs8Q
 */

public interface PreSumAndDiffArray {

    default void TypicalImply() {
        new DiffArray();        // 差分数组
        new DiffArrayApply();   // 差分数组 应用
        new PreSumArray();      // 前缀和数组
        new PreSumArrayApply(); // 前缀和数组 应用
    }
}
