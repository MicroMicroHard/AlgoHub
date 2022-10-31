package Algorithm.math;

import Top100.Mathlj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-8-2 下午01:18:35
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard/article/details/98177653
 * @description 吸血鬼数字
 * 吸血鬼数字是指位数为偶数的数字，可以由一对数字相乘而得到，
 * 而这对数字各包含乘积的一半位数的数字，其中从最初的数字中选取的数字可以任意排序.
 * <p>
 * 以两个0结尾的数字是不允许的，例如，下列数字都是“吸血鬼”数字：
 * 1260 = 21 * 60 　1827 = 21 * 87 　2187 = 27 * 81
 * 4位数的吸血鬼数有7个：
 * 1260, 1395, 1435, 1530, 1827, 2187, 6880
 * 6位数的吸血鬼数字有155个：
 * 102510, 104260, 105210, 105264, 105750, 108135, 110758, 115672, 116725, 117067, 118440, 120600, 123354, 124483, 125248, 125433, 125460, 125500, 126000, 126027, 126846, 129640, 129775, 131242, 132430, 133245, 134725, 135828, 135837, 136525, 136948, 139500, 140350, 143500, 145314, 146137, 146952, 150300, 152608, 152685, 153000, 153436, 156240, 156289, 156915, 162976, 163944, 172822, 173250, 174370, 175329, 180225, 180297, 182250, 182650, 182700, 186624, 190260, 192150, 193257, 193945, 197725, 201852, 205785, 211896, 213466, 215860, 216733, 217638, 218488, 218700, 226498, 226872, 229648, 233896, 241564, 245182, 251896, 253750, 254740, 260338, 262984, 263074, 284598, 284760, 286416, 296320, 304717, 312475, 312975, 315594, 315900, 319059, 319536, 326452, 329346, 329656, 336550, 336960, 338296, 341653, 346968, 361989, 362992, 365638, 368550, 369189, 371893, 378400, 378418, 378450, 384912, 386415, 392566, 404968, 414895, 416650, 416988, 428980, 429664, 447916, 456840, 457600, 458640, 475380, 486720, 489159, 489955, 498550, 516879, 529672, 536539, 538650, 559188, 567648, 568750, 629680, 638950, 673920, 679500, 688000, 729688, 736695, 738468, 769792, 789250, 789525, 792585, 794088, 809919, 809964, 815958, 829696, 841995, 939658
 * 其中125460比较特殊，因为125460=204*615且125640=246*510.
 * 伪吸血鬼数和一般吸血鬼数不同之处在于其尖牙不强制是n/2个位的数，故伪吸血鬼数的位数可以是奇数。
 * 2002年Carlos Rivera定义了质吸血鬼数：尖牙是质因子的吸血鬼数，例如117067, 124483, 146137, 371893, 536539。
 */
public class Vampire implements Mathlj {

    public void Vampire1() {
        List<String> list = new ArrayList<String>();
        for (int i = 10; i <= 99; i++) {
            for (int j = i; j <= 99; j++) {
                // Pete Hartley's theoretical result:
                //If x·y is a vampire number then x·y == x+y (mod 9)
                if ((i * j) % 9 != (i + j) % 9) {
                    continue;
                }
                int value = i * j;
                String s = i + "" + j;
                char[] c = Integer.toString(value).toCharArray();
                if (c.length != 4) {
                    continue;
                }
                for (int l = 0; l < c.length; l++) {
                    if (s.indexOf(c[l]) != -1) {
                        s = s.substring(0, s.indexOf(c[l])) + "a" + s.substring(s.indexOf(c[l]) + 1, s.length());
                    }
                }
                if (s.equals("aaaa")) {
                    list.add(i + "*" + j + "=" + value);
                }
            }
        }
		/*for (String s : list) {
			System.out.println(s);
		}*/
    }

    public void Vampire2() {
        int[] startDigit = new int[4];
        int[] productDigit = new int[4];
        for (int num1 = 10; num1 <= 99; num1++)
            for (int num2 = num1; num2 <= 99; num2++) {
                // Pete Hartley's theoretical result:  
                // If x·y is a vampire number then  
                // x·y == x+y (mod 9)  
                if ((num1 * num2) % 9 != (num1 + num2) % 9)
                    continue;
                int product = num1 * num2;
                startDigit[0] = num1 / 10;
                startDigit[1] = num1 % 10;
                startDigit[2] = num2 / 10;
                startDigit[3] = num2 % 10;
                productDigit[0] = product / 1000;
                productDigit[1] = (product % 1000) / 100;
                productDigit[2] = product % 1000 % 100 / 10;
                productDigit[3] = product % 1000 % 100 % 10;
                int count = 0;
                for (int x = 0; x < 4; x++)
                    for (int y = 0; y < 4; y++) {
                        if (productDigit[x] == startDigit[y]) {
                            count++;
                            productDigit[x] = -1;
                            startDigit[y] = -2;  
                            /*if (count == 4)  
                                System.out.println(num1 + " * " + num2 + " : "  
                                        + product); */
                        }
                    }
            }
    }
}
