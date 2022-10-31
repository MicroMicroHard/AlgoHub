package DataStructure.list.listRealize;

import DataStructure.list.Nodelj;
import Top100.BigIntegerOpera;

/**
 * @author liujun
 * @version 1.0
 * @date 2021/1/15
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 大整数操作，链表类型
 * 输入：使用字符串或者链表来表示数【对于字符串和链表中的符号位，可以另外处理，此处只求最基本的运算】
 * 包括加减乘除，
 */

public interface BigIntegerOpera_List extends BigIntegerOpera {

    Nodelj calMethod(Nodelj first, Nodelj second);
}
