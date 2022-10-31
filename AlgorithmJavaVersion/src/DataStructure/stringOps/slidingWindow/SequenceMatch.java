package DataStructure.stringOps.slidingWindow;

import DataStructure.stringOps.stringCompare.StringCompare;

/**
 * @author liujun
 * @version 1.0
 * @date 2020-02-05 21:08
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 序列匹配
 * 在 源串序列(source) 中是否含有 目标串的(target) 序列
 * @blogURL
 */
public class SequenceMatch implements StringCompare {

    
    public boolean compareMethod(String source, String target) {
        return check(source, target) && match(source, target);
    }

    //子串匹配
    private boolean match(String source, String target) {
        char[] sourceCharArray = source.toCharArray();
        char[] targetCharArray = target.toCharArray();

        int targetPoint = 0;
        int sourcePoint = 0;
        while (sourcePoint < source.length() && targetPoint < target.length()) {
            if (targetCharArray[targetPoint] == sourceCharArray[sourcePoint]) {
                targetPoint++;
            }
            sourcePoint++;
        }
        return targetPoint == target.length();
    }

}
