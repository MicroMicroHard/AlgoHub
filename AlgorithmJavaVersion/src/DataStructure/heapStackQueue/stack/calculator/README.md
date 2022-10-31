// 计算器测试用例
public void testData4Calculator(Calculator instance) {
double answer = instance.cal(demo3_1);
assert answer == target3_1;
answer = instance.cal(demo3_2);
assert answer == target3_2;
answer = instance.cal(demo3_3);
assert answer == target3_3;
answer = instance.cal(demo3_4);
assert answer == target3_4;
answer = instance.cal(demo3_5);
assert answer == target3_5;
answer = instance.cal(demo3_6);
assert answer == target3_6;
answer = instance.cal(demo3_7);
assert answer == target3_7;
answer = instance.cal(demo3_8);
assert answer == target3_8;
answer = instance.cal(demo3_9);
assert answer == target3_9;
answer = instance.cal(demo3_10);
assert answer == target3_10;

        answer = instance.cal(demo3_11);
        assert answer == target3_11;
        answer = instance.cal(demo3_12);
        assert answer == target3_12;
        answer = instance.cal(demo3_13);
        assert answer == target3_13;

        answer = instance.cal(demo3_14);
        DecimalFormat j = new DecimalFormat("#.00000");//string format grammar: format小数点后n位的写法
        String eeee = j.format(answer);
        assert eeee.equals(String.valueOf(target3_14));

        answer = instance.cal(demo3_15);
        j = new DecimalFormat("#.000");
        eeee = j.format(answer);
        assert eeee.equals(String.valueOf(target3_15));

        answer = instance.cal(demo3_16);
        assert answer == target3_16;
        answer = instance.cal(demo3_17);
        //assert answer == target3_17;
        answer = instance.cal(demo3_18);
        assert answer == target3_18;
        answer = instance.cal(demo3_19);
        //assert answer == target3_19;
        answer = instance.cal(demo3_20);
        assert answer == target3_20;
        //answer = calculate.cal(demo3_21);
        //assert answer == target3_21;
    }

    public void testData4SimpleCalculator(Calculator instance) {
        double answer = instance.cal(demo2_1);
        assert answer == target2_1;
        answer = instance.cal(demo2_2);
        assert answer == target2_2;
        answer = instance.cal(demo2_3);
        assert answer == target2_3;
        answer = instance.cal(demo2_4);
        assert answer == target2_4;
        answer = instance.cal(demo2_5);
        assert answer == target2_5;
        /*answer = instance.cal(demo2_6);
        assert answer == target2_6;*/
    }

    public void testData4SimpleCalculator_WithOutBracketsTest(Calculator instance) {
        double answer = instance.cal(demo1_1);
        assert answer == target1_1;
        answer = instance.cal(demo1_2);
        assert answer == target1_2;
        answer = instance.cal(demo1_3);
        assert answer == target1_3;
        answer = instance.cal(demo1_4);
        assert answer == target1_4;
        answer = instance.cal(demo1_5);
        assert answer == target1_5;
        answer = instance.cal(demo1_6);
        assert answer == target1_6;
    }



String demo1_3 = "3*6";
double target1_3 = 18;
String demo1_4 = "20/5";
double target1_4 = 4;


String demo1_6 = "1*2-17+6+15/5";
double target1_6 = -6;



    String demo3_1 = "(2+3*5)*(";//括号不匹配
    double target3_1 = C.ErrorNum;






 





    String demo3_17 = "5*7/15*3";//为什么这个值算不正确，因为计算机是二进制，计算"5*7/15"时得到的就不是准确值了，所以最终结果有误
    double target3_17 = 7;
    String demo3_18 = "90+100-101-190";
    double target3_18 = -101;


    String demo3_21 = "6*6*6*6*6/36/216";//66*6*6*6*36/216/
    double target3_21 = 1;