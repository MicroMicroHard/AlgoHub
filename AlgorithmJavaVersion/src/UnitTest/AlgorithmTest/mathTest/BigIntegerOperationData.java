package UnitTest.AlgorithmTest.mathTest;

import Common.Constant.C;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/5/15
 * @author-Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 大整数 测试案例 符号问题
 * 数据类型有：0、以0开头的数字、正负整数、正负小数、非数字
 */
public class BigIntegerOperationData {

    public static Map<String, String> mapTarget;

    {
        try {
            mapTarget = new HashMap<>();
            getDataTarget();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 数据类型有：0、以0开头/结尾的数字、正负整数、正负小数、非数字
    public String[] demoNum = {
            "0",
            "0000012",    // 以0开头的数字,
            "5600",       // 以0结尾的数字,
            "1200000012000000000",
            "234",        // 正整数,      
            "1200000012",
            "-012",       // 负整数,      
            "-123456789",
            "0034.890",   // 正数小数,    
            "0000012.23000",
            "-000123.89", // 负数小数,    
            "34+56789",   // 非数字,      
            "0.45678)",
            "34.567.89",
            "12a3.45s6"
    };

    public static void getDataTarget() throws Exception {
        String path = "UnitTest.AlgorithmTest.mathTest.BigIntegerOperationData";
        Class<?> c = Class.forName(path);
        Object arrayTestDemoDataInstance = c.newInstance();
        Field[] f = c.getDeclaredFields();

        Method m;
        Object o;
        String arr = "arr";
        String expected = "expected";

        for (Field f1 : f) {
            m = c.getMethod("get" + getMethodName(f1.getName()));
            o = m.invoke(arrayTestDemoDataInstance);
            if (o instanceof String) {
                String str = (String) o;
                // 获取target
                if (f1.getName().contains(arr)) {
                    mapTarget.put(f1.getName().replace(arr, ""), str);
                }
            }
        }
    }

    //将首字母大写
    private static String getMethodName(String fildeName) {
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'd' + 'D');
        return new String(items);
    }

    // --------------sum/sub/mul/div--------------
    // sum
    public String demoNumSum1_1 = "0";
    public String demoNumSum1_2 = "0";
    public String demoNumSum1_3 = "0";
    public String demoNumSum1_4 = "0";
    public String demoNumSum1_5 = "0";
    public String demoNumSum1_6 = "0";
    public String demoNumSum1_7 = "0";
    public String demoNumSum1_8 = "0";
    public String demoNumSum2_1 = "0";
    public String demoNumSum2_2 = "0";
    public String demoNumSum2_3 = "0";
    public String demoNumSum2_4 = "0";
    public String demoNumSum2_5 = "0";
    public String demoNumSum2_6 = "0";
    public String demoNumSum2_7 = "0";
    public String demoNumSum2_8 = "0";
    public String demoNumSum3_1 = "0";
    public String demoNumSum3_2 = "0";
    public String demoNumSum3_3 = "0";
    public String demoNumSum3_4 = "0";
    public String demoNumSum3_5 = "0";
    public String demoNumSum3_6 = "0";
    public String demoNumSum3_7 = "0";
    public String demoNumSum3_8 = "0";
    public String demoNumSum4_1 = "0";
    public String demoNumSum4_2 = "0";
    public String demoNumSum4_3 = "0";
    public String demoNumSum4_4 = "0";
    public String demoNumSum4_5 = "0";
    public String demoNumSum4_6 = "0";
    public String demoNumSum4_7 = "0";
    public String demoNumSum4_8 = "0";
    public String demoNumSum5_1 = "0";
    public String demoNumSum5_2 = "0";
    public String demoNumSum5_3 = "0";
    public String demoNumSum5_4 = "0";
    public String demoNumSum5_5 = "0";
    public String demoNumSum5_6 = "0";
    public String demoNumSum5_7 = "0";
    public String demoNumSum5_8 = "0";
    public String demoNumSum6_1 = "0";
    public String demoNumSum6_2 = "0";
    public String demoNumSum6_3 = "0";
    public String demoNumSum6_4 = "0";
    public String demoNumSum6_5 = "0";
    public String demoNumSum6_6 = "0";
    public String demoNumSum6_7 = "0";
    public String demoNumSum6_8 = "0";
    public String demoNumSum7_1 = "0";
    public String demoNumSum7_2 = "0";
    public String demoNumSum7_3 = "0";
    public String demoNumSum7_4 = "0";
    public String demoNumSum7_5 = "0";
    public String demoNumSum7_6 = "0";
    public String demoNumSum7_7 = "0";
    public String demoNumSum7_8 = "0";
    public String demoNumSum8_1 = "0";
    public String demoNumSum8_2 = "0";
    public String demoNumSum8_3 = "0";
    public String demoNumSum8_4 = "0";
    public String demoNumSum8_5 = "0";
    public String demoNumSum8_6 = "0";
    public String demoNumSum8_7 = "0";
    public String demoNumSum8_8 = "0";
    // sub
    public String demoNumSub1_1 = "0";
    public String demoNumSub1_2 = "0";
    public String demoNumSub1_3 = "0";
    public String demoNumSub1_4 = "0";
    public String demoNumSub1_5 = "0";
    public String demoNumSub1_6 = "0";
    public String demoNumSub1_7 = "0";
    public String demoNumSub1_8 = "0";
    public String demoNumSub2_1 = "0";
    public String demoNumSub2_2 = "0";
    public String demoNumSub2_3 = "0";
    public String demoNumSub2_4 = "0";
    public String demoNumSub2_5 = "0";
    public String demoNumSub2_6 = "0";
    public String demoNumSub2_7 = "0";
    public String demoNumSub2_8 = "0";
    public String demoNumSub3_1 = "0";
    public String demoNumSub3_2 = "0";
    public String demoNumSub3_3 = "0";
    public String demoNumSub3_4 = "0";
    public String demoNumSub3_5 = "0";
    public String demoNumSub3_6 = "0";
    public String demoNumSub3_7 = "0";
    public String demoNumSub3_8 = "0";
    public String demoNumSub4_1 = "0";
    public String demoNumSub4_2 = "0";
    public String demoNumSub4_3 = "0";
    public String demoNumSub4_4 = "0";
    public String demoNumSub4_5 = "0";
    public String demoNumSub4_6 = "0";
    public String demoNumSub4_7 = "0";
    public String demoNumSub4_8 = "0";
    public String demoNumSub5_1 = "0";
    public String demoNumSub5_2 = "0";
    public String demoNumSub5_3 = "0";
    public String demoNumSub5_4 = "0";
    public String demoNumSub5_5 = "0";
    public String demoNumSub5_6 = "0";
    public String demoNumSub5_7 = "0";
    public String demoNumSub5_8 = "0";
    public String demoNumSub6_1 = "0";
    public String demoNumSub6_2 = "0";
    public String demoNumSub6_3 = "0";
    public String demoNumSub6_4 = "0";
    public String demoNumSub6_5 = "0";
    public String demoNumSub6_6 = "0";
    public String demoNumSub6_7 = "0";
    public String demoNumSub6_8 = "0";
    public String demoNumSub7_1 = "0";
    public String demoNumSub7_2 = "0";
    public String demoNumSub7_3 = "0";
    public String demoNumSub7_4 = "0";
    public String demoNumSub7_5 = "0";
    public String demoNumSub7_6 = "0";
    public String demoNumSub7_7 = "0";
    public String demoNumSub7_8 = "0";
    public String demoNumSub8_1 = "0";
    public String demoNumSub8_2 = "0";
    public String demoNumSub8_3 = "0";
    public String demoNumSub8_4 = "0";
    public String demoNumSub8_5 = "0";
    public String demoNumSub8_6 = "0";
    public String demoNumSub8_7 = "0";
    public String demoNumSub8_8 = "0";
    // multi
    public String demoNumDiv1_1 = C.ErrorNumStr;
    public String demoNumDiv1_2 = "0";
    public String demoNumDiv1_3 = "0";
    public String demoNumDiv1_4 = "0";
    public String demoNumDiv1_5 = "0";
    public String demoNumDiv1_6 = "0";
    public String demoNumDiv1_7 = "0";
    public String demoNumDiv1_8 = "0";
    public String demoNumDiv2_1 = C.ErrorNumStr;
    public String demoNumDiv2_2 = "0";
    public String demoNumDiv2_3 = "0";
    public String demoNumDiv2_4 = "0";
    public String demoNumDiv2_5 = "0";
    public String demoNumDiv2_6 = "0";
    public String demoNumDiv2_7 = "0";
    public String demoNumDiv2_8 = "0";
    public String demoNumDiv3_1 = C.ErrorNumStr;
    public String demoNumDiv3_2 = "0";
    public String demoNumDiv3_3 = "0";
    public String demoNumDiv3_4 = "0";
    public String demoNumDiv3_5 = "0";
    public String demoNumDiv3_6 = "0";
    public String demoNumDiv3_7 = "0";
    public String demoNumDiv3_8 = "0";
    public String demoNumDiv4_1 = C.ErrorNumStr;
    public String demoNumDiv4_2 = "0";
    public String demoNumDiv4_3 = "0";
    public String demoNumDiv4_4 = "0";
    public String demoNumDiv4_5 = "0";
    public String demoNumDiv4_6 = "0";
    public String demoNumDiv4_7 = "0";
    public String demoNumDiv4_8 = "0";
    public String demoNumDiv5_1 = C.ErrorNumStr;
    public String demoNumDiv5_2 = "0";
    public String demoNumDiv5_3 = "0";
    public String demoNumDiv5_4 = "0";
    public String demoNumDiv5_5 = "0";
    public String demoNumDiv5_6 = "0";
    public String demoNumDiv5_7 = "0";
    public String demoNumDiv5_8 = "0";
    public String demoNumDiv6_1 = C.ErrorNumStr;
    public String demoNumDiv6_2 = "0";
    public String demoNumDiv6_3 = "0";
    public String demoNumDiv6_4 = "0";
    public String demoNumDiv6_5 = "0";
    public String demoNumDiv6_6 = "0";
    public String demoNumDiv6_7 = "0";
    public String demoNumDiv6_8 = "0";
    public String demoNumDiv7_1 = C.ErrorNumStr;
    public String demoNumDiv7_2 = "0";
    public String demoNumDiv7_3 = "0";
    public String demoNumDiv7_4 = "0";
    public String demoNumDiv7_5 = "0";
    public String demoNumDiv7_6 = "0";
    public String demoNumDiv7_7 = "0";
    public String demoNumDiv7_8 = "0";
    public String demoNumDiv8_1 = C.ErrorNumStr;
    public String demoNumDiv8_2 = "0";
    public String demoNumDiv8_3 = "0";
    public String demoNumDiv8_4 = "0";
    public String demoNumDiv8_5 = "0";
    public String demoNumDiv8_6 = "0";
    public String demoNumDiv8_7 = "0";
    public String demoNumDiv8_8 = "0";
    // merge
    public String demoNumMerge1_1 = "0";
    public String demoNumMerge1_2 = "0";
    public String demoNumMerge1_3 = "0";
    public String demoNumMerge1_4 = "0";
    public String demoNumMerge1_5 = "0";
    public String demoNumMerge1_6 = "0";
    public String demoNumMerge1_7 = "0";
    public String demoNumMerge1_8 = "0";
    public String demoNumMerge2_1 = "0";
    public String demoNumMerge2_2 = "0";
    public String demoNumMerge2_3 = "0";
    public String demoNumMerge2_4 = "0";
    public String demoNumMerge2_5 = "0";
    public String demoNumMerge2_6 = "0";
    public String demoNumMerge2_7 = "0";
    public String demoNumMerge2_8 = "0";
    public String demoNumMerge3_1 = "0";
    public String demoNumMerge3_2 = "0";
    public String demoNumMerge3_3 = "0";
    public String demoNumMerge3_4 = "0";
    public String demoNumMerge3_5 = "0";
    public String demoNumMerge3_6 = "0";
    public String demoNumMerge3_7 = "0";
    public String demoNumMerge3_8 = "0";
    public String demoNumMerge4_1 = "0";
    public String demoNumMerge4_2 = "0";
    public String demoNumMerge4_3 = "0";
    public String demoNumMerge4_4 = "0";
    public String demoNumMerge4_5 = "0";
    public String demoNumMerge4_6 = "0";
    public String demoNumMerge4_7 = "0";
    public String demoNumMerge4_8 = "0";
    public String demoNumMerge5_1 = "0";
    public String demoNumMerge5_2 = "0";
    public String demoNumMerge5_3 = "0";
    public String demoNumMerge5_4 = "0";
    public String demoNumMerge5_5 = "0";
    public String demoNumMerge5_6 = "0";
    public String demoNumMerge5_7 = "0";
    public String demoNumMerge5_8 = "0";
    public String demoNumMerge6_1 = "0";
    public String demoNumMerge6_2 = "0";
    public String demoNumMerge6_3 = "0";
    public String demoNumMerge6_4 = "0";
    public String demoNumMerge6_5 = "0";
    public String demoNumMerge6_6 = "0";
    public String demoNumMerge6_7 = "0";
    public String demoNumMerge6_8 = "0";
    public String demoNumMerge7_1 = "0";
    public String demoNumMerge7_2 = "0";
    public String demoNumMerge7_3 = "0";
    public String demoNumMerge7_4 = "0";
    public String demoNumMerge7_5 = "0";
    public String demoNumMerge7_6 = "0";
    public String demoNumMerge7_7 = "0";
    public String demoNumMerge7_8 = "0";
    public String demoNumMerge8_1 = "0";
    public String demoNumMerge8_2 = "0";
    public String demoNumMerge8_3 = "0";
    public String demoNumMerge8_4 = "0";
    public String demoNumMerge8_5 = "0";
    public String demoNumMerge8_6 = "0";
    public String demoNumMerge8_7 = "0";
    public String demoNumMerge8_8 = "0";

    // 0 * -12345679 = 0
    public String demo01 = "0";
    public String demo011 = "-12345679";
    public String demo01Sum = "-12345679";
    public String demo01Sub = "12345679";
    public String demo01Multi = "0";
    public String demo01Div = "0";
    public String demo01Merge = "-12345679";

    // -12345679 * 0 = " 0
    public String demo02 = "-12345679";
    public String demo021 = "0";
    public String demo02Sum = "-12345679";
    public String demo02Sub = "-12345679";
    public String demo02Multi = "0";
    public String demo02Div = C.ErrorNumStr;
    public String demo02Merge = "-12345679";

    // 12345679 * 0 = " 0
    public String demo03 = "12345679";
    public String demo031 = "0";
    public String demo03Sum = "12345679";
    public String demo03Sub = "12345679";
    public String demo03Multi = "0";
    public String demo03Div = C.ErrorNumStr;
    public String demo03Merge = "12345679";

    // 0 * 0 = " 0
    public String demo04 = "0";
    public String demo041 = "0";
    public String demo04Sum = "0";
    public String demo04Sub = "0";
    public String demo04Multi = "0";
    public String demo04Div = C.ErrorNumStr;
    public String demo04Merge = "0";

    // 1 * -1 = " -1
    public String demo05 = "1";
    public String demo051 = "-1";
    public String demo05Sum = "0";
    public String demo05Sub = "2";
    public String demo05Multi = "-1";
    public String demo05Div = "-1";
    public String demo05Merge = "-2";

    // 异常参数
    public String demo06 = "";
    public String demo061 = "12";
    public String demo06Sum = "0";
    public String demo06Sub = "0";
    public String demo06Multi = "0";
    public String demo06Div = C.ErrorNumStr;
    public String demo06Merge = "12";

    // 1 * 1 = " 1
    public String demo07 = "1";
    public String demo071 = "1";
    public String demo07Sum = "2";
    public String demo07Sub = "0";
    public String demo07Multi = "1";
    public String demo07Div = "1";
    public String demo07Merge = "2";

    // 5981 * 128692 = 769706852
    public String demo08 = "5981";
    public String demo081 = "128692";
    public String demo08Sum = "134673";
    public String demo08Sub = "-122711";
    public String demo08Multi = "769706852";
    public String demo08Div = "0.04647";//控制在小数点后5位
    public String demo08Merge = "726792";

    // 128692 * 0 =  0
    public String demo09 = "12345679";
    public String demo091 = "0";
    public String demo09Sum = "12345679";
    public String demo09Sub = "12345679";
    public String demo09Multi = "0";
    public String demo09Div = "21.5158";
    public String demo09Merge = "12345679";

    // 1111 * 9999 =   11108889
    public String demo10 = "1111";
    public String demo101 = "9999";
    public String demo10Sum = "11110";
    public String demo10Sub = "-8888";
    public String demo10Multi = "11108889";
    public String demo10Div = "0.1111111111";
    public String demo10Merge = "1110";

    // 12345 * 67890 =   838102050
    public String demo11 = "12345";
    public String demo111 = "67890";
    public String demo11Sum = "80235";
    public String demo11Sub = "-55545";
    public String demo11Multi = "838102050";
    public String demo11Div = "0.1818382678";
    public String demo11Merge = "80235";

    public String demo12 = "12098";
    public String demo121 = "98915";
    public String demo12Sum = "111013";
    public String demo12Sub = "-86817";
    public String demo12Multi = "1196673670";
    public String demo12Div = "0.1223070313";
    public String demo12Merge = "11013";

    // 【正数、正数】、【正数、负数】、【负数、正数】、【负数、负数】
    // 5981 * 128692 = " 769706852
    public String demo18 = "345";
    public String demo181 = "8765";
    public String demo18Sum = "9110";
    public String demo18Sub = "-8420";
    public String demo18Multi = "3023925";
    public String demo18Div = "0.03936109527";//控制在小数点后5位
    public String demo18Merge = "2215";

    public String demo28 = "345";
    public String demo281 = "-8765";
    public String demo28Sum = "-8420";
    public String demo28Sub = "9110";
    public String demo28Multi = "-3023925";
    public String demo28Div = "-0.03936109527";//控制在小数点后5位
    public String demo28Merge = "-2215";

    public String demo38 = "-345";
    public String demo381 = "8765";
    public String demo38Sum = "8420";
    public String demo38Sub = "-9110";
    public String demo38Multi = "-3023925";
    public String demo38Div = "-0.03936109527";//控制在小数点后5位
    public String demo38Merge = "-2215";

    public String demo48 = "-345";
    public String demo481 = "-8765";
    public String demo48Sum = "-9110";
    public String demo48Sub = "8420";
    public String demo48Multi = "3023925";
    public String demo48Div = "0.03936109527";//控制在小数点后5位
    public String demo48Merge = "-2215";

    // 大数测试案例
    // 5981 * 128692 = " 769706852
    public String bigNumDemo18 = "345.90";
    public String bigNumDemo181 = "8765.19";
    public String bigNumDemo18Sum = "9111.09";
    public String bigNumDemo18Sub = "-8419.29";
    public String bigNumDemo18Multi = "3031879.221";
    public String bigNumDemo18Div = "0.03946292094";//控制在小数点后5位

    public String bigNumDemo28 = "345.90";
    public String bigNumDemo281 = "-8765.19";
    public String bigNumDemo28Sum = "-8419.29";
    public String bigNumDemo28Sub = "9111.09";
    public String bigNumDemo28Multi = "-3031879.221";
    public String bigNumDemo28Div = "-0.03946292094";//控制在小数点后5位

    public String bigNumDemo38 = "-345.90";
    public String bigNumDemo381 = "8765.19";
    public String bigNumDemo38Sum = "8419.29";
    public String bigNumDemo38Sub = "-9111.09";
    public String bigNumDemo38Multi = "-3031879.221";
    public String bigNumDemo38Div = "-0.03946292094";//控制在小数点后5位

    public String bigNumDemo48 = "-345.90";
    public String bigNumDemo481 = "-8765.19";
    public String bigNumDemo48Sum = "-9111.09";
    public String bigNumDemo48Sub = "8419.29";
    public String bigNumDemo48Multi = "3031879.221";
    public String bigNumDemo48Div = "0.03946292094";//控制在小数点后5位

    public String bigNumDemo58 = "345.901";
    public String bigNumDemo581 = "8765.1993";
    public String bigNumDemo58Sum = "9111.1003";
    public String bigNumDemo58Sub = "-8419.2983";
    public String bigNumDemo58Multi = "3031891.2030693";
    public String bigNumDemo58Div = "0.03946299316";//控制在小数点后5位

    public String bigNumDemo68 = "222222222222222222.222222222222";
    public String bigNumDemo681 = "111111111111111111.111111111111";
    public String bigNumDemo68Sum = "333333333333333333.333333333333";
    public String bigNumDemo68Sub = "111111111111111111.111111111111";
    public String bigNumDemo68Multi = "2";
    public String bigNumDemo68Div = "2";//控制在小数点后5位

    public String bigNumDemo78 = "-911.23";
    public String bigNumDemo781 = "11";
    public String bigNumDemo78Sum = "-900.23";
    public String bigNumDemo78Sub = "-922.23";
    public String bigNumDemo78Multi = "-10023.53";
    public String bigNumDemo78Div = "-82.8390909091";//控制在小数点后5位

    public String bigNumDemo88 = "-911.123";
    public String bigNumDemo881 = "11.123";
    public String bigNumDemo88Sum = "-900";
    public String bigNumDemo88Sub = "-922.246";
    public String bigNumDemo88Multi = "-10023.53";
    public String bigNumDemo88Div = "-82.8390909091";//控制在小数点后5位

    public String bigNumDemo98 = "911.123";
    public String bigNumDemo981 = "11.123";
    public String bigNumDemo98Sum = "922.246";
    public String bigNumDemo98Sub = "900";
    public String bigNumDemo98Multi = "-10023.53";
    public String bigNumDemo98Div = "-82.8390909091";//控制在小数点后5位
}
