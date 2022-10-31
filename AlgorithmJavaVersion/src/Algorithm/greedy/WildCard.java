package Algorithm.greedy;

import Top100.Greed;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/6/8
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 通配符匹配
 * 给定一个字符串(s) 和一个字符模式(p) ，实现一个支持'?'和'*'的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 * s可能为空，且只包含从a-z的小写字母。
 * p可能为空，且只包含从a-z的小写字母，以及字符?和*。
 *
 * 示例1:
 * 输入:s = "aa"          p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例2:
 * 输入:s = "aa"          p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 *
 * 示例3:
 * 输入:s = "cb"          p = "?a"
 * 输出: false
 * 解释:'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 *
 * 示例4:
 * 输入:s = "adceb"       p = "*a*b"
 * 输出: true
 * 解释:第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 *
 * 示例5:
 * 输入:s = "acdcb"       p = "a*c?b"
 * 输出: false
 *
 */
public class WildCard implements Greed {
}
