package DataStructure.arrayRelevant.arrayTransformation;

import Top100.Reversal;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/8/25
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 反转字符串
 * "i am a student" -> "student a am i"
 * 例如："["i"," ","a","m"," ","a"," ","s","t","u","d","e","n","t"]" -> "["s","t","u","d","e","n","t"," ","a"," ","a","m"," ","i"]"
 * 要求：原址排序
 */

public class ReversalString3 implements Reversal {

    public char[] method(char[] cArray) {
        if (cArray == null || cArray.length == 0) {
            return null;
        }

        int last = cArray.length - 1;
        // 整体反转
        cArray = Reversal(cArray, 0, last);
        // 每个单词反转
        int pre = 0;
        int tail = 0;
        while (pre <= last) {
            if (cArray[pre] != ' ') {
                pre++;
            } else {
                cArray = Reversal(cArray, tail, pre - 1);
                tail = pre + 1;
                pre++;
            }
        }
        if (tail != pre) {
            cArray = Reversal(cArray, tail, pre - 1);
        }
        return cArray;
    }

    public char[] Reversal(char[] cArray, int begin, int end) {
        while (begin < end) {
            char cTemp = cArray[begin];
            cArray[begin] = cArray[end];
            cArray[end] = cTemp;
            begin++;
            end--;
        }
        return cArray;
    }
}
