package DataStructure.list;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/11/1
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 链表结构
 * 应用于：
 * 单链表{@link Nodelj#Nodelj},
 * 1、根据 String 生成链表{@link Nodelj#String2Nodelj},链表 序列化为 String {@link Nodelj#Nodelj2String}
 * 2、根据 数组 生成链表{@link Nodelj#Array2Nodelj},链表 序列化为 数组 {@link Nodelj#Nodelj2Array}
 * 3、Int数据 转成 Nodelj 节点{@link Nodelj#Int2Nodelj},,Nodelj 节点转成 Int数据{@link Nodelj#Nodelj2Int}
 * 4、打印链表 {@link Nodelj#print}
 * 4、链式输出 {@link Nodelj#express}
 * 5、判断两个链表是否相等{@link Nodelj#equals}
 * 双链表节点
 * 跳表节点
 */

public class Nodelj {

    public int key;
    public String value;
    public Nodelj front;
    public Nodelj next;
    public Nodelj down;

    // 单链表
    public Nodelj() {
        this.key = Integer.MIN_VALUE;
        this.next = null;
        this.front = null;
        this.down = null;
    }

    // 单链表、双向链表、跳表
    public Nodelj(int key) {
        this.key = key;
        this.next = null;
        this.front = null;
        this.down = null;
    }

    // cache
    public Nodelj(int key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.front = null;
        this.down = null;
    }

    // 根据 String 生成链表,要求 String是全部数字组成
    public Nodelj String2Nodelj(String array) {
        if (array == null || array.length() == 0) {
            return null;
        }
        Nodelj root = new Nodelj(array.charAt(0) - '0');
        Nodelj first = root;
        for (int i = 1; i < array.length(); i++) {
            root.next = new Nodelj(array.charAt(i) - '0');
            root = root.next;
        }
        return first;
    }

    public String Nodelj2String(Nodelj node) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.key);
            node = node.next;
        }
        return sb.toString();
    }

    // 根据数组生成链表
    public static Nodelj Array2Nodelj(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        Nodelj root = new Nodelj(array[0]);
        Nodelj first = root;
        for (int i = 1; i < array.length; i++) {
            root.next = new Nodelj(array[i]);
            root = root.next;
        }
        return first;
    }

    // 链表转数组
    public static int[] Nodelj2Array(Nodelj root) {
        if (root == null) {
            return new int[]{};
        }
        int nodeLength = 0;
        Nodelj ahead = root;
        while (root != null) {
            nodeLength++;
            root = root.next;
        }
        int[] array = new int[nodeLength];
        for (int i = 0; i < nodeLength; i++) {
            // 防止意外的其他并发操作了Node导致空指针
            if (ahead == null) {
                return null;
            }
            array[i] = ahead.key;
            ahead = ahead.next;
        }
        return array;
    }

    private int Nodelj2Int(Nodelj node) {
        if (node == null) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.value);
            node = node.next;
        }
        String valueStr = sb.toString();
        return Integer.parseInt(valueStr);
    }

    private Nodelj Int2Nodelj(int a) {
        if (a == 0) {
            return new Nodelj(0);
        }
        String arrayStr = String.valueOf(a);
        return String2Nodelj(arrayStr);
    }

    public void express(Nodelj root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            System.out.println(root.value + "->");
            root = root.next;
        }
    }

    public void express() {
        express(this);
    }

    // 打印链表
    public void print() {
        print(this);
    }

    public void print(Nodelj root) {
        System.out.println();
        if (root == null) {
            return;
        }
        while (root != null) {
            //System.out.println("Nodelj print: ");
            System.out.print(root.key + " -> ");
            root = root.next;
        }
    }

    public boolean equals(Nodelj first, Nodelj second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
        while (first != null && second != null) {
            if (first.key != second.key) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return first == null && second == null;
    }

    public boolean equals(Nodelj root) {
        return equals(this, root);
    }
}
