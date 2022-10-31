package DataStructure.arrayRelevant.preSumAndDiffArray;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/8
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 差分数组应用
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。我们这儿有一份航班预订表，
 * 表中第 i 条预订记录 bookings[i] = [i, j, k] 意味着我们在从 i 到 j 的每个航班上预订了 k 个座位。
 * 请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。
 * 示例：
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 */
public class DiffArrayApply extends DiffArray {

    public int[] deal(int[][] arrays, int n) {
        if (arrays == null || arrays.length == 0) {
            return new int[]{};
        }
        int[] ans = new int[n];
        buildDiffArray(ans);
        for (int[] an : arrays) {
            //diffINC(an[0] - 1, an[1] - 1, an[2]);
        }
        return getDiffOrigin(ans);
    }

    // opera里面是闭区间 [begin, end]
    public int[] diffINCArray(int[] array, int[][] opera) {
        if (array == null || array.length == 0 || opera == null) {
            return new int[]{};
        }
        int[] diffArray = buildDiffArray(array);
        for (int i = 0; i < opera.length; i++) {
            // 异常检查
            if (opera[i] == null || opera[i].length != 3) {
                return null;
            }
            diffINC(diffArray, opera[i][0], opera[i][1], opera[i][2]);
            /*if (opera[i][0] >= 0) {
                int begin = opera[i][0];
                diffArray[begin] += opera[i][3][i];
            }
            if (opera[i][1] + 1 < diffArray.length) {
                int end = opera[i][1];
                //Tips：根据差分数组的性质，此处的操作对象是end + 1
                diffArray[end + 1] -= opera[i][3][i];
            }*/
        }
        return diffArray;
    }
}
