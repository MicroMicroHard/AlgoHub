package Algorithm.math.game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/8/4
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 大乐透
 */
public class BigLotto {

    public void congratulations(int[][] source, String... s) {
        for (String s1 : s) {
            congratulations(source, s1);
            System.out.println("--------\n");
        }
    }

    public void congratulations(Map<String, int[]> targetMap, int[][] source, boolean look) {
        for (String name : targetMap.keySet()) {
            for (int[] ints : source) {
                congratulations(ints, targetMap.get(name), name, look);
            }
        }
    }

    public void congratulations(int[] source, int[] target, String name, boolean look) {
        if (!validateParams(source) || !validateParams(target)) {
            return;
        }
        if (source.length != 7 || target.length != 7) {
            System.out.println("err != 7");
            return;
        }
        Map<Integer, Integer> blueMap = new HashMap<>();
        Map<Integer, Integer> redMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            if (i < 5) {
                blueMap.put(target[i], 1);
            } else {
                redMap.put(target[i], 1);
            }
        }
        int blue = 0;
        int red = 0;
        for (int i = 0; i < 5; i++) {
            if (blueMap.containsKey(source[i])) {
                blue++;
            }
        }
        for (int i = 5; i < 7; i++) {
            if (redMap.containsKey(source[i])) {
                red++;
            }
        }
        if (red >= 2 || (red + blue >= 3)) {
            System.out.printf("\n%s : red >= 2 || red+blue>=3,  Total:%d \nsource: %s,\ntarget: %s\n",
                    name, red + blue, Arrays.toString(source), Arrays.toString(target));
        }
        if (look && (red + blue >= 1)) {
            System.out.printf("\nlook:%s : red >= 2 || red+blue>=3 \nsource: %s,\ntarget: %s\n",
                    name, Arrays.toString(source), Arrays.toString(target));
        }
    }

    public boolean validateParams(int[] params) {
        if (params.length != 7) {
            System.out.printf("err != 7,%s\n", Arrays.toString(params));
            return false;
        }
        Map<Integer, Integer> blueMap = new HashMap<>();
        Map<Integer, Integer> redMap = new HashMap<>();
        for (int i = 0; i < params.length; i++) {
            if (i < 5) {
                if (blueMap.getOrDefault(params[i], 0) > 0) {
                    System.out.printf("error,%s--> error num:%d\n", Arrays.toString(params), params[i]);
                    return false;
                }
                blueMap.put(params[i], 1);
                if (params[i] > 35 || params[i] < 1) {
                    System.out.printf("error,%s--> error num:%d\n", Arrays.toString(params), params[i]);
                    return false;
                }
            } else {
                if (redMap.getOrDefault(params[i], 0) > 0) {
                    System.out.printf("error,%s--> error num:%d\n", Arrays.toString(params), params[i]);
                    return false;
                }
                redMap.put(params[i], 1);
                if (params[i] > 12 || params[i] < 1) {
                    System.out.printf("error,%s\n", Arrays.toString(params));
                    return false;
                }
            }
        }
        return true;
    }

    public void congratulations(int[][] source, String s) {
        String[] arrs = s.split(" ");
        int blue;
        int red;
        for (int[] ints : source) {
            blue = 0;
            red = 0;
            for (int i = 0; i < 5; i++) {
                if (ints[i] == Integer.parseInt(arrs[i])) {
                    blue++;
                }
            }
            for (int i = 5; i < 7; i++) {
                if (ints[i] == Integer.parseInt(arrs[i])) {
                    red++;
                }
            }
            if (red >= 2 || (red + blue >= 3)) {
                System.out.print("red >= 2 || red+blue>=3" + "\nsource:");
                Arrays.stream(ints).forEach(x -> System.out.print(x + " "));
                System.out.println("\nreal  :" + s + "\n");
            } /*else {
                System.out.println("fail");
            }*/
        }
    }
}
