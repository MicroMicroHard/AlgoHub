// 默认模版

import java.util.HashMap;
import java.util.Map;

// 实现一个 zset
// 添加时相同的 key 会被最新数据覆盖
// 弹出时，先弹出 score 最大的，score 相同时弹出顺序不限定
// 测试用例中的弹出顺序应该是: k2, k3, k1
// 限制：插入时需要保证数据有序，弹出时间复杂度应该是 o(1)
class Main {
    public static void main(String[] args) {
        MyZSet myZSet = new MyZSet();
        myZSet.add("k1", 10);
        myZSet.add("k2", 5);
        myZSet.add("k3", 15);
        myZSet.add("k1", 11);
        myZSet.add("k2", 20);

        String k = myZSet.pop();
        while (k != null) {
            System.out.println(k);
            k = myZSet.pop();
        }
    }
}

class Node {
    int score;
    String val;

    public Node(int score, String val) {
        this.score = score;
        this.val = val;
    }
}

class MyZSet {

    Node[] array;
    int realCap;
    int initCap;
    Map<String, Node> zSetMap;

    MyZSet() {
        // todo
        realCap = 0;
        initCap = 10;
        array = new Node[initCap];
        zSetMap = new HashMap();
    }

    public void add(String key, int score) {
        // todo
        Node node = new Node(score, key);
        if (zSetMap.containsKey(key)) {
            node = zSetMap.get(key);
            if (score == node.score) {
                return;
            }
            node.score = score;
        } else {
            zSetMap.put(key, node);
        }
        if (this.realCap + 1 > initCap) {
            resize();
        }
        this.array[this.realCap] = node;
        this.realCap++;
        heapSort();
    }

    public String pop() {
        // todo
        Node head = this.array[0];
        this.array[0] = this.array[realCap];
        this.realCap--;
        heapSort();
        return head.val;
    }

    private void heapSort() {
        for (int i = 0; i < this.realCap / 2; i++) {
            heap_big(i);
        }
    }

    private void heap_big(int index_parent) {
        int child_left = index_parent * 2 + 1;
        if (child_left > this.realCap) {
            return;
        }
        if (child_left + 1 < this.realCap) {
            child_left = this.array[child_left + 1].score > this.array[child_left].score ? child_left + 1 : child_left;
        }
        if (this.array[child_left].score > this.array[index_parent].score) {
            Node temp = this.array[child_left];
            this.array[child_left] = this.array[index_parent];
            this.array[index_parent] = temp;
            heap_big(child_left);
        }
    }

    private void resize() {
        this.initCap *= 1.5;
        Node[] arrayNew = new Node[this.initCap];
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        this.array = arrayNew;
    }
}