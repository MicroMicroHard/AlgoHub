package DataStructure.heapStackQueue.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-3-23 12:09:20
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 简化文件路径
 * 给你一个字符串 path ，表示指向某一文件或目录的Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。
 * 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * @blogURL https://leetcode-cn.com/problems/simplify-path/
 */

public class SimplifyPath {

    public static void main(String[] args) {
        SimplifyPath sd = new SimplifyPath();
        System.out.println(sd.simplifyPath("/..."));
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        if (path.charAt(0) != '/') {
            return null;
        }
        String[] str = path.split("/");
        for (String s : str) {
            switch (check(s)) {
                case 0:
                    break;
                case 1:
                    stack.add(s);
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }

    public int check(String s) {
        // 加进去 1
        // 不加 0
        // 不加并且退出原来的一个 2
        if (s.equals("..")) {
            return 2;
        } else if (s.equals(".") || s.equals("")) {
            return 0;
        }
        return 1;
    }
}
