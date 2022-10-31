package Algorithm.math;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/7/18 00:56
 * @author—Email micromicrohard@outlook.com
 * @description 大整数除法 结构体
 * @blogURL
 */

public class BigNumDivStruct {

    public String Quotient;
    public String Remainder;

    public BigNumDivStruct() {
    }

    public BigNumDivStruct(String quotient, String remainder) {
        Quotient = quotient;
        Remainder = remainder;
    }

    public BigNumDivStruct(int quotient, int remainder) {
        Quotient = quotient + "";
        Remainder = remainder + "";
    }

    public BigNumDivStruct String2DivStruct(String params) {
        if (params == null || params.length() == 0) {
            return null;
        }
        String[] ans = params.split(",");
        if (ans.length != 2 || params.split(":").length != 3) {
            System.out.println("String2DivStruct Error, params: " + params);
            return null;
        }
        return new BigNumDivStruct(ans[0].split(":")[0], ans[1].split(":")[0]);
    }

    public String DivStruct2String() {
        return DivStruct2String(this);
    }

    public String DivStruct2String(BigNumDivStruct params) {
        if (params == null) {
            return "";
        }
        return "商:" + params.Quotient + ",余:" + params.Remainder;
    }
}
