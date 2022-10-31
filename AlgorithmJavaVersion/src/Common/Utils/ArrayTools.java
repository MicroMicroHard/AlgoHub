package Common.Utils;

import Common.Conf.Config;
import Common.Constant.C;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020-02-11 15:11
 * @author-Email micromicrohard@outlook.com
 * @description 数组工具类
 * <p>
 * 1、判断相等 (不相等则打印)
 * 判断两个int[]    是否相等 : {@link ArrayTools#IntArrayEquals}
 * 判断两个int[][]  是否相等 : {@link ArrayTools#EqualsIntMatrix}
 * 判断两个char[]   是否相等 : {@link ArrayTools#EqualsCharArray}
 * 判断两个string[] 是否相等 : {@link ArrayTools#EqualsStringArray}
 * 判断两个string[] 是否严格相等(index严格一致) : {@link ArrayTools#StringArrayEqualsStrict}
 * <p>
 * 2、类型转换
 * 将 String 的数字字符串转换成int[] : {@link ArrayTools#Sequence2IntArray}
 * 将 int[]  拼接成String : {@link ArrayTools#IntArray2Sequence}
 * <p>
 * 3、打印输出
 * 打印一维数组 : {@link ArrayTools#printIntArray}
 * 打印二维数组 : {@link ArrayTools#printIntMatrix}
 * 打印二维字符串数组 : {@link ArrayTools}
 * 4、排序
 * 将int类型的 List 要求:按照内部list的长度从小到大排序,相同长度的list，按照相同位置 字典序 小的优先排序,
 * 最小单元数组，有序排列: {@link ArrayTools#ListSort}
 * 5、复制
 * 数组深copy {@link ArrayTools#ArrayDeepCopy}
 * 矩阵深copy {@link ArrayTools#MatrixDeepCopy}
 */

public class ArrayTools {

    public static Config config = new Config();

    public static boolean IntArrayEquals(int[] arr1, int[] arr2) {
        if (Arrays.equals(arr1, arr2)) {
            return true;
        }
        System.out.println("arr1:");
        printIntArray(arr1);
        System.out.println("arr2:");
        printIntArray(arr2);
        return false;
    }

    public static void main(String[] args) {
        int[] a = null;
        int[] b = null;
        boolean d = Arrays.equals(a, b);
        System.out.println(d);
    }

    public static boolean IntArrayEquals(int[] arrOrigin, int[] arrBySort, int[] arrByLinkSort) {
        if (Arrays.equals(arrBySort, arrByLinkSort)) {
            return true;
        }
        System.out.println("arrOrigin:");
        printIntArray(arrOrigin);
        System.out.println("arrBySort:");
        printIntArray(arrBySort);
        System.out.println("arrTarget:");
        printIntArray(arrByLinkSort);
        return false;
    }

    // 1、判断两个int[][] 是否相等
    public static boolean EqualsIntMatrix(int[][] a, int[][] b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (!Arrays.equals(a[i], b[i])) {
                System.out.println();
                System.out.println("a[i]:" + " " + Arrays.toString(a[i]));
                System.out.println("b[i]:" + " " + Arrays.toString(b[i]));
                return false;
            }
        }
        return true;
    }

    // 2、判断两个char[] 是否相等
    public static boolean EqualsCharArray(char[] a, char[] b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.length == 0 && b.length == 0) {
            return true;
        }
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    // 3、判断两个 string 数组相等，打印不相等的数组【允许乱序】
    public static boolean EqualsStringArray(String[] a, String[] b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.length != b.length) {
            return false;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s : a) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : b) {
            if (map.getOrDefault(s, 0) == 0) {
                return false;
            }
            if (map.getOrDefault(s, 0) == 1) {
                map.remove(s);
            }
        }
        return map.size() == 0;
    }

    // 3、判断两个 string 数组相等，打印不相等的数组【严格相等：字符串出现顺序必须一致】
    public static boolean StringArrayEqualsStrict(String[] a, String[] b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                System.out.println("a[i]:" + a[i] + "-------,b[i]" + b[i]);
                return false;
            }
        }
        return true;
    }

    // 4、将String类型的数字字符串转换成int数组
    public static int[] Sequence2IntArray(String sequence) {
        if (sequence == null || sequence.length() == 0) {
            return new int[]{};
        }
        int length = sequence.length();
        int[] intArray = new int[sequence.length()];
        for (int i = 0; i < length; i++) {
            int v = Integer.parseInt(String.valueOf(sequence.charAt(i)));
            intArray[i] = v;
        }
        return intArray;
    }

    // 4.1、将int[] 转换成String : IntArray2Sequence
    public static String IntArray2Sequence(int[] array) {
        if (array == null || array.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int j : array) {
            sb.append(j);
        }
        return sb.toString();
    }

    public static String IntArray2Sequence(int[] array, String symbol) {
        if (array == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        if ("{".equals(symbol)) {
            sb.append(symbol);
        } else {
            sb.append("[");
        }

        for (int j : array) {
            if (j == C.NLF) {
                sb.append(config.commonConfig.NLF).append(", ");
            } else {
                sb.append(j).append(", ");
            }
        }
        if (sb.length() >= 2) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return "{".equals(symbol) ? sb.append("}").toString() : sb.append("]").toString();
    }

    // 5、打印一维数组
    public static void printIntArray(int[] array) {
        System.out.println(IntArray2Sequence(array, "{"));
    }

    // 5.1、打印二维数组 , n 表示 n行 进行一次换行
    public static void printIntMatrix(int[][] array) {
        printIntMatrix(array, array.length);
    }

    public static void printIntMatrix(int[][] array, int n) {
        int count = 0;
        System.out.println();
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            printIntArray(array[i]);
            if (i != array.length - 1) {
                System.out.print(",");
            }
            count++;
            if (count % n == 0) {
                System.out.println();
            }
        }
        System.out.print("}");
        System.out.println();
    }

    // 7、将List要求按照内部list的长度从小到大排序，相同长度的数组，按照相同位置小的优先排序 : sortList
    public static int[][] ListSort(List<List<Integer>> listAll) {
        ArrayList<int[]> all_route_list = new ArrayList<>(listAll.size());
        int[][] all_route_Array = new int[listAll.size()][];

        // 内部list转成数组
        for (List<Integer> list_temp : listAll) {
            int[] intArray = list_temp.stream().mapToInt(x -> (int) x).toArray();
            Arrays.sort(intArray);
            all_route_list.add(intArray);
        }

        // 按照内部list的长度进行排序
        all_route_list = (ArrayList<int[]>) all_route_list.stream().sorted(Comparator.comparing(x -> x.length)).collect(Collectors.toList());

        // 全部转成数组
        for (int i = 0; i < all_route_list.size(); i++) {
            all_route_Array[i] = all_route_list.get(i);
        }

        for (int h = 0; h < all_route_Array.length; h++) {
            boolean flag = false;
            // 按照冒泡排序，对相同的数组，按照逐位大小比较
            for (int i = 0; i < all_route_Array.length - 1; i++) {
                int[] array_i = all_route_Array[i];
                int[] array_i_1 = all_route_Array[i + 1];

                if (array_i.length != array_i_1.length) {
                    continue;
                }
                // 对相同的数组，按照逐位大小比较
                for (int j = 0; j < array_i.length; j++) {
                    if (array_i[j] < array_i_1[j]) {
                        break;
                    } else if (array_i[j] > array_i_1[j]) {
                        int[] temp = all_route_Array[i];
                        all_route_Array[i] = all_route_Array[i + 1];
                        all_route_Array[i + 1] = temp;
                        flag = true;
                        break;
                    }
                    // 相等的话，比较下一位
                }
            }
            if (!flag) {
                return all_route_Array;
            }
        }
        return all_route_Array;
    }

    public static int[] ArrayDeepCopy(int[] matrix) {
        int[] b = new int[matrix.length];
        System.arraycopy(matrix, 0, b, 0, matrix.length);
        return b;
    }

    public static int[][] MatrixDeepCopy(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int[][] b = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, b[i], 0, matrix[i].length);
        }
        return b;
    }
}
