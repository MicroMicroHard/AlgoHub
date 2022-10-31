package DataStructure.list.listRealize;

import DataStructure.list.Nodelj;
import Common.Utils.UTFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author liujun
 * @version 1.0
 * @date 2022/3/27 12:51
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description 合并多条有序链表
 */

public class MergeMultiList {

    @Test // 验证功能：用于全量测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误测试案例
    public void TestDoubleTrack() throws Exception {
        String input = "[1,3,5,7,9],[2,4,6,8,10]";
        String output = "[1,2,3,4,5,6,7,8,9,10]";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    public Nodelj MergeMethod(Nodelj[] nodeList) {
        if (nodeList == null || nodeList.length == 0) {
            return null;
        }
        List<Nodelj> list = new ArrayList<>();
        for (Nodelj node : nodeList) {
            if (node != null) {
                list.add(node);
            }
        }
        // PriorityQueue grammar:如果不写Comparator函数，会导致queue.add失败,同时需要注意Comparator的类型
        PriorityQueue<Nodelj> queue = new PriorityQueue<>(new Comparator<Nodelj>() {
            
            public int compare(Nodelj o1, Nodelj o2) {
                return o1.key - o2.key;
            }
        });

        queue.addAll(list);
        Nodelj newHead = new Nodelj();
        Nodelj cur = newHead;
        while (!queue.isEmpty()) {
            Nodelj headNode = queue.poll();
            if (headNode.next != null) {
                queue.add(headNode.next);
            }
            cur.next = headNode;
            cur = cur.next;
        }
        return newHead.next;
    }
}
