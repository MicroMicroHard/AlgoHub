package Top100;


import Common.Utils.ArrayTools;

import java.util.*;
import java.util.concurrent.CountDownLatch;

class Node {
    char c;
    Node left;
    Node right;

    public Node() {
    }

    public Node(char c) {
        this.c = c;
    }
}


public class A_Practice {

    public static volatile int index = 0;
    public static volatile int sum = 0;
    static int gap = 100;

    public static void m1ai1n1() {
        int threadNum = 10;
        final CountDownLatch lock = new CountDownLatch(threadNum);
        // 10 thread
        for (int i = 0; i < threadNum; i++) {
            MyRunnable runnable = new MyRunnable(index, gap, lock);
            Thread t = new Thread(runnable);
            t.start();
        }
        //lock.await();
        System.out.println(sum);
    }

    static class MyRunnable implements Runnable {
        CountDownLatch cdAnswer;
        int begin;
        int gap;
        int sum_temp = 0;

        public MyRunnable(int begin, int gap, CountDownLatch cdAnswer) {
            this.cdAnswer = cdAnswer;
            this.begin = begin;
            this.gap = gap;
        }

        public void count() {
            for (int i = begin; i < begin + gap; i++) {
                sum_temp++;
            }
            sum += sum_temp;
        }

        public void run() {
            //获取线程的名称，打印一句话
            try {
                count();
                cdAnswer.countDown();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void m1ai1n(String[] args) {
        int[][] pickLoc = new int[3][2];
        pickLoc[0] = new int[]{1, 1};
        pickLoc[1] = new int[]{-1, 1};
        pickLoc[2] = new int[]{2, 3};
        int value = minRoutes(pickLoc, 0, 0);
        System.out.println(value);
    }

    public static int minRoutes(int[][] pickLoc, int baseX0, int baseY0) {
        Map<Double, Integer> map = new HashMap<>();
        // Write your code here
        double k;
        for (int[] ints : pickLoc) {
            int x = ints[0];
            int y = ints[1];
            if (x != 0) {
                k = (double) y / (double) x;
            } else {
                k = Integer.MAX_VALUE;
            }
            map.putIfAbsent(k, 1);
        }
        return map.size();
    }

    public static int[] calculatePrimeNumbers(int num) {
        int[] answer = new int[]{};
        // Write your code here
        if (num == 1) {
            return answer;
        }
        List<Integer> list = new ArrayList<>();
        boolean flag = false;
        for (int i = 2; i <= num; i++) {
            int div = i / 2;
            flag = false;
            for (int j = 2; j <= div; j++) {
                if (i != j && i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(i);
            }
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        A_Practice method = new A_Practice();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.next();
            Node n = method.buildBinaryTree(a);
            String ans = method.printNode(n);
            System.out.println(ans);
        }
    }

    public Node buildBinaryTree(String node) {
        if (node == null || node.length() == 0) {
            return null;
        }
        char[] cArr = node.toCharArray();
        String pattern = "[a-z]";
        if (!String.valueOf(cArr[0]).matches(pattern)) {
            return null;
        }
        Node n = new Node(cArr[0]);
        if (node.length() == 1) {
            return n;
        }
        String[] strArr = SplitString(node);
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        n.left = buildBinaryTree(strArr[0]);
        n.right = buildBinaryTree(strArr[1]);
        return n;
    }

    public String[] SplitString(String params) {
        if (params == null || params.length() == 0) {
            return null;
        }
        params = params.substring(2, params.length() - 1);
        if (params.length() == 0) {
            return null;
        }
        if (params.length() == 1) {
            return new String[]{params, ""};
        }
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < params.length(); i++) {
            char c = params.charAt(i);
            if (charStack.size() == 0 && c == ',') {
                String p1 = params.substring(0, i);// 不包括 "，"
                String p2 = params.substring(i + 1);
                return new String[]{p1, p2};
            }
            if (c == '{') {
                charStack.push(c);
                continue;
            }
            if (c == '}') {
                if (charStack.size() == 0) {
                    return null;//error
                }
                charStack.pop();
            }
        }
        return null;
    }

    public String printNode(Node n) {
        if (n == null) {
            return "";
        }
        return printNode(n.left) + n.c + printNode(n.right);
    }


    public static void mai1n(String[] args) {
        Scanner in = new Scanner(System.in);
        A_Practice method = new A_Practice();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.next();
            int ans = method.count(a);
            System.out.println(ans);
        }
    }

    public int count(String params) {
        if (params == null || params.length() == 0) {
            return 0;
        }
        char[] cArr = params.toCharArray();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c : cArr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (stack.empty()) {
                return 0;// error
            }
            char cpop = stack.peek();
            if ((c == ')' && cpop == '(') || (c == ']' && cpop == '[') || (c == '}' && cpop == '{')) {
                stack.pop();
                count++;
            }
        }
        return stack.size() == 0 ? count : 0;
    }

    public static void ma1in(String[] args) {
        Scanner in = new Scanner(System.in);
        A_Practice method = new A_Practice();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            int ans = method.count(a, b);
            System.out.println(ans);
        }
    }

    public static void main1(String[] args) {
        A_Practice a = new A_Practice();
        Scanner s = new Scanner(System.in);
        while (true) {
            int p1 = s.nextInt();
            int p2 = s.nextInt();
            /*String[] params = paramsStr.trim().split(" ");
            int[] param = new int[params.length];
            for (int i = 0; i < param.length; i++) {
                param[i] = Integer.parseInt(params[i]);
            }*/
            int ans = a.count(p1, p2);
            System.out.println(ans);
        }
    }

    public int count(int allocateNum, int alphaLength) {
        if (allocateNum == 0 || alphaLength == 0) {
            return 0; // error
        }
        int alphaNum = cal(alphaLength);
        int mod = allocateNum % alphaNum == 0 ? 0 : 1;
        int total = allocateNum / alphaNum + mod;
        for (int i = 1; i < Math.max(total, 1000000); i++) {
            int n = dealAllocate(i);
            if (n >= total) {
                return i;
            }
        }
        return 0;
    }

    public int dealAllocate(int total) {
        /**
         * 1:10; 0-9
         * 2:110; 0-99 + 0+[0-9]
         * 3:1110;0-999 + 0+[0-99] +00+[0-9]
         */
        int hed = 1;
        int sum = 0;
        for (int i = 0; i < total; i++) {
            sum += hed * 10;
            hed *= 10;
        }
        return sum;
    }

    public int cal(int y) {
        int sum = 1;
        int hed = 26;
        for (int i = 0; i < y; i++) {
            sum *= hed;
        }
        return sum;
    }


    public void print(int count, int n) {
        if (count > n) {
            return;
        }
        for (int i = 0; i < 9; i++) {
            System.out.print(count * 10 + i + " - ");
            print(count * 10 + i, n);
            /*print(i * 10, n);
            System.out.println(count++ + " - ");*/
        }
    }

    public int deep(int cur, int n) {
        if (cur < n) {
            System.out.print(cur + " - ");
            deep(cur * 10, n);
            return 0;
        }
        int border = getBorder(cur);
        while (cur < border) {
            cur++;
            System.out.print(cur + " - ");
        }
        return cur;
    }

    public int getBorder(int cur) {
        if (cur < 9) {
            return cur + 1;
        }
        char[] curLength = String.valueOf(cur).toCharArray();
        if (curLength.length <= 2) {
            return 0;
        }
        char c = curLength[curLength.length - 2];
        int num = Integer.valueOf(c);
        if (num + 1 >= 9) {
            return 0;
        }
        curLength[curLength.length - 2] = (char) (num + 1);
        return Integer.parseInt(Arrays.toString(curLength));
    }


 /*   public static void main(String[] args) {
        A_Practice a = new A_Practice();
        a.asteroidsDestroyed(5, new int[]{4, 9, 23, 4});
    }*/

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        if (mass <= 0 || asteroids == null || asteroids.length == 0) {
            return false;
        }
        Arrays.sort(asteroids);

        int u = 0;
        int sum = mass;

        while (u < asteroids.length) {
            if (asteroids[u] > mass) {
                return false;
            }
            while (asteroids[u] < mass) {
                sum += asteroids[u];
                u++;
                if (u >= asteroids.length) {
                    return true;
                }
            }
            mass = sum;
        }
        return true;
    }

}

