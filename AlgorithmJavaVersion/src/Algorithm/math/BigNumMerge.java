package Algorithm.math;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/5/15
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 大数字符串合并
 * 输入："1234"，"11"
 * 输出："111234"
 */
public class BigNumMerge extends BigNumOperaBasic {

    //大整数字符串合并
    public String mergeWithSymbol(String args, String args2) {

        BigNumOperaBasic instance = new BigNumOperaBasic();
        String mergeNum = "0";
        if (!NullCheck(args, args2)) {
            return args == null || args.length() == 0 ? args2 == null || args2.length() == 0 ? mergeNum : args2 : args;
        }
        // 关于0的处理
        if (args.equals("0") || args2.equals("0")) {
            return args.equals("0") ? args2 : args;
        }
        //运算符同号判断
        int signal = 0;
        if (args.charAt(0) == '-') {
            args = args.substring(1);
            signal++;
        }
        if (args2.charAt(0) == '-') {
            args2 = args2.substring(1);//string grammar:substring是左闭右开
            signal++;
        }
        mergeNum = instance.merge(args, args2);
        //处理进位
        if (mergeNum.length() > 1) {
            mergeNum = mergeNum.substring(1);
        }
        // 正正、正负、负正、负负
        return signal == 0 ? mergeNum : "-" + mergeNum;
    }
}
