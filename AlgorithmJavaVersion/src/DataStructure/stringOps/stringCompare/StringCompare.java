package DataStructure.stringOps.stringCompare;

/**
 * @author 蔚蔚樱
 * @author Email  micromicrohard@outlook.com
 * @version 1.0
 * @date 2020-01-31 22:11
 * @description 字符串对比
 * @blogURL
 */
public interface StringCompare {

    /**
     * @params source:源串
     * @params target:目标串
     */
     boolean compareMethod(String source, String target);

    default boolean check(String source, String target) {
        //判空
        if (source == null || target == null) {
            return false;
        }
        //长度判断
        return target.length() <= source.length();
    }

}
